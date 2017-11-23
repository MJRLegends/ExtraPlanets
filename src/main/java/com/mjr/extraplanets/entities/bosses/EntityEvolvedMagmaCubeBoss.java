package com.mjr.extraplanets.entities.bosses;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.entities.IBoss;
import micdoodle8.mods.galacticraft.core.network.PacketSimple;
import micdoodle8.mods.galacticraft.core.network.PacketSimple.EnumSimplePacket;
import micdoodle8.mods.galacticraft.core.tile.TileEntityDungeonSpawner;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.tile.treasureChest.TileEntityT4TreasureChest;

import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;

public class EntityEvolvedMagmaCubeBoss extends EntityMob implements IEntityBreathable, IBossDisplayData, IBoss {
	public int deathTicks = 0;

	public float squishAmount;
	public float squishFactor;
	public float prevSquishFactor;
	/** ticks until this slime jumps again */
	private int slimeJumpDelay;

	private TileEntityDungeonSpawner spawner;

	public int entitiesWithin;
	public int entitiesWithinLast;
	public Entity targetEntity;
	private Vector3 roomCoords;
	private Vector3 roomSize;

	public EntityEvolvedMagmaCubeBoss(World p_i1742_1_) {
		super(p_i1742_1_);
		int i = 10;
		// int i = 5;
		this.yOffset = 0.0F;
		this.slimeJumpDelay = this.rand.nextInt(20) + 10;
		this.setSlimeSize(i);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte) 1));
	}

	protected void setSlimeSize(int p_70799_1_) {
		this.dataWatcher.updateObject(16, new Byte((byte) p_70799_1_));
		this.setSize(0.6F * p_70799_1_, 0.6F * p_70799_1_);
		this.setPosition(this.posX, this.posY, this.posZ);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((p_70799_1_ * p_70799_1_) * 4);
		this.setHealth(this.getMaxHealth());
		this.experienceValue = p_70799_1_;
	}

	/**
	 * Returns the size of the slime.
	 */
	public int getSlimeSize() {
		return this.dataWatcher.getWatchableObjectByte(16);
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
		super.writeEntityToNBT(nbt);
		nbt.setInteger("Size", this.getSlimeSize() - 1);
		if (this.roomCoords != null) {
			nbt.setDouble("roomCoordsX", this.roomCoords.x);
			nbt.setDouble("roomCoordsY", this.roomCoords.y);
			nbt.setDouble("roomCoordsZ", this.roomCoords.z);
			nbt.setDouble("roomSizeX", this.roomSize.x);
			nbt.setDouble("roomSizeY", this.roomSize.y);
			nbt.setDouble("roomSizeZ", this.roomSize.z);
		}
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
		super.readEntityFromNBT(nbt);
		int i = nbt.getInteger("Size");

		if (i < 0) {
			i = 0;
		}

		this.setSlimeSize(i + 1);
		this.roomCoords = new Vector3();
		this.roomCoords.x = nbt.getDouble("roomCoordsX");
		this.roomCoords.y = nbt.getDouble("roomCoordsY");
		this.roomCoords.z = nbt.getDouble("roomCoordsZ");
		this.roomSize = new Vector3();
		this.roomSize.x = nbt.getDouble("roomSizeX");
		this.roomSize.y = nbt.getDouble("roomSizeY");
		this.roomSize.z = nbt.getDouble("roomSizeZ");
	}

	/**
	 * Returns the name of a particle effect that may be randomly created by
	 * EntitySlime.onUpdate()
	 */
	protected String getSlimeParticle() {
		return "slime";
	}

	/**
	 * Returns the name of the sound played when the slime jumps.
	 */
	protected String getJumpSound() {
		return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void onUpdate() {
		if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL && this.getSlimeSize() > 0) {
			this.isDead = true;
		}

		this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
		this.prevSquishFactor = this.squishFactor;
		boolean flag = this.onGround;
		super.onUpdate();
		int i;

		if (this.onGround && !flag) {
			i = this.getSlimeSize();

			for (int j = 0; j < i * 8; ++j) {
				float f = this.rand.nextFloat() * Constants.floatPI * 2.0F;
				float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
				float f2 = MathHelper.sin(f) * i * 0.5F * f1;
				float f3 = MathHelper.cos(f) * i * 0.5F * f1;
				this.worldObj.spawnParticle(this.getSlimeParticle(), this.posX + f2, this.boundingBox.minY, this.posZ + f3, 0.0D, 0.0D, 0.0D);
			}

			if (this.makesSoundOnLand()) {
				this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
			}

			this.squishAmount = -0.5F;
		} else if (!this.onGround && flag) {
			this.squishAmount = 1.0F;
		}

		this.alterSquishAmount();

		if (this.worldObj.isRemote) {
			i = this.getSlimeSize();
			this.setSize(0.6F * i, 0.6F * i);
		}
	}

	@Override
	protected void updateEntityActionState() {
		this.despawnEntity();
		EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);

		if (entityplayer != null) {
			this.faceEntity(entityplayer, 10.0F, 20.0F);
		}

		if (this.onGround && this.slimeJumpDelay-- <= 0) {
			this.slimeJumpDelay = this.getJumpDelay();

			if (entityplayer != null) {
				this.slimeJumpDelay /= 3;
			}

			this.isJumping = true;

			if (this.makesSoundOnJump()) {
				this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 0.8F);
			}

			this.moveStrafing = 1.0F - this.rand.nextFloat() * 2.0F;
			this.moveForward = 1 * this.getSlimeSize();
		} else {
			this.isJumping = false;

			if (this.onGround) {
				this.moveStrafing = this.moveForward = 0.0F;
			}
		}
	}

	protected void alterSquishAmount() {
		this.squishAmount *= 0.6F;
	}

	/**
	 * Gets the amount of time the slime needs to wait between jumps.
	 */
	protected int getJumpDelay() {
		return this.rand.nextInt(20) + 10;
	}

	protected EntityEvolvedMagmaCubeBoss createInstance() {
		return new EntityEvolvedMagmaCubeBoss(this.worldObj);
	}

	@Override
	public void onLivingUpdate() {
		final EntityPlayer player = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 20.0);

		if (player != null && !player.equals(this.targetEntity)) {
			if (this.getDistanceSqToEntity(player) < 400.0D) {
				this.getNavigator().getPathToEntityLiving(player);
				this.targetEntity = player;
			}
		} else {
			this.targetEntity = null;
		}

		new Vector3(this);

		if (this.roomCoords != null && this.roomSize != null) {
			@SuppressWarnings("unchecked")
			List<Entity> entitiesWithin = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class,
					AxisAlignedBB.getBoundingBox(this.roomCoords.intX() - 1, this.roomCoords.intY() - 1, this.roomCoords.intZ() - 1, this.roomCoords.intX() + this.roomSize.intX(), this.roomCoords.intY() + this.roomSize.intY(), this.roomCoords.intZ() + this.roomSize.intZ()));

			this.entitiesWithin = entitiesWithin.size();

			if (this.entitiesWithin == 0 && this.entitiesWithinLast != 0) {
				@SuppressWarnings("unchecked")
				List<EntityPlayer> entitiesWithin2 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class,
						AxisAlignedBB.getBoundingBox(this.roomCoords.intX() - 11, this.roomCoords.intY() - 11, this.roomCoords.intZ() - 11, this.roomCoords.intX() + this.roomSize.intX() + 10, this.roomCoords.intY() + this.roomSize.intY() + 10, this.roomCoords.intZ() + this.roomSize.intZ() + 10));

				for (EntityPlayer p : entitiesWithin2) {
					p.addChatMessage(new ChatComponentText(GCCoreUtil.translate("gui.skeletonBoss.message")));
				}

				this.setDead();

				if (this.spawner != null) {
					this.spawner.playerCheated = true;
				}

				return;
			}
		}

		super.onLivingUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void onDeathUpdate() {
		++this.deathTicks;

		if (this.deathTicks >= 180 && this.deathTicks <= 200) {
			final float f = (this.rand.nextFloat() - 0.5F) * 1.5F;
			final float f1 = (this.rand.nextFloat() - 0.5F) * 2.0F;
			final float f2 = (this.rand.nextFloat() - 0.5F) * 1.5F;
			this.worldObj.spawnParticle("hugeexplosion", this.posX + f, this.posY + 2.0D + f1, this.posZ + f2, 0.0D, 0.0D, 0.0D);
		}

		int i;
		int j;

		if (!this.worldObj.isRemote) {
			if (this.deathTicks >= 180 && this.deathTicks % 5 == 0) {
				GalacticraftCore.packetPipeline.sendToAllAround(new PacketSimple(EnumSimplePacket.C_PLAY_SOUND_EXPLODE, new Object[] {}), new TargetPoint(this.worldObj.provider.dimensionId, this.posX, this.posY, this.posZ, 40.0D));
				// PacketDispatcher.sendPacketToAllAround(this.posX, this.posY,
				// this.posZ, 40.0, this.worldObj.provider.dimensionId,
				// PacketUtil.createPacket(GalacticraftCore.CHANNEL,
				// EnumPacketClient.PLAY_SOUND_EXPLODE, new Object[] { 0 }));
			}

			if (this.deathTicks > 150 && this.deathTicks % 5 == 0) {
				i = 30;

				while (i > 0) {
					j = EntityXPOrb.getXPSplit(i);
					i -= j;
					this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
				}
			}

			if (this.deathTicks == 1) {
				GalacticraftCore.packetPipeline.sendToAllAround(new PacketSimple(EnumSimplePacket.C_PLAY_SOUND_BOSS_DEATH, new Object[] {}), new TargetPoint(this.worldObj.provider.dimensionId, this.posX, this.posY, this.posZ, 40.0D));
				// PacketDispatcher.sendPacketToAllAround(this.posX, this.posY,
				// this.posZ, 40.0, this.worldObj.provider.dimensionId,
				// PacketUtil.createPacket(GalacticraftCore.CHANNEL,
				// EnumPacketClient.PLAY_SOUND_BOSS_DEATH, new Object[] { 0 }));
			}
		}

		this.moveEntity(0.0D, 0.10000000149011612D, 0.0D);
		this.renderYawOffset = this.rotationYaw += 20.0F;

		if (this.deathTicks == 200 && !this.worldObj.isRemote) {
			i = 20;

			while (i > 0) {
				j = EntityXPOrb.getXPSplit(i);
				i -= j;
				this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
			}

			for (final TileEntity tile : (List<TileEntity>) this.worldObj.loadedTileEntityList) {
				if (tile instanceof TileEntityT4TreasureChest) {
					final double d3 = tile.xCoord + 0.5D - this.posX;
					final double d4 = tile.yCoord + 0.5D - this.posY;
					final double d5 = tile.zCoord + 0.5D - this.posZ;
					final double dSq = d3 * d3 + d4 * d4 + d5 * d5;
					TileEntityT4TreasureChest chest = (TileEntityT4TreasureChest) tile;

					if (dSq < 10000) {
						if (!chest.locked) {
							chest.locked = true;
						}

						for (int k = 0; k < chest.getSizeInventory(); k++) {
							chest.setInventorySlotContents(k, null);
						}

						ChestGenHooks info = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);

						// Generate three times, since it's an extra extra
						// special chest
						WeightedRandomChestContent.generateChestContents(this.rand, info.getItems(this.rand), chest, info.getCount(this.rand));
						WeightedRandomChestContent.generateChestContents(this.rand, info.getItems(this.rand), chest, info.getCount(this.rand));
						WeightedRandomChestContent.generateChestContents(this.rand, info.getItems(this.rand), chest, info.getCount(this.rand));

						chest.setInventorySlotContents(this.rand.nextInt(chest.getSizeInventory()), this.getGuaranteedLoot(this.rand));

						break;
					}
				}
			}

			this.entityDropItem(new ItemStack(ExtraPlanets_Items.T4key, 1, 0), 0.5F);

			super.setDead();

			if (this.spawner != null) {
				this.spawner.isBossDefeated = true;
				this.spawner.boss = null;
				this.spawner.spawned = false;
			}
		}
	}

	public ItemStack getGuaranteedLoot(Random rand) {
		List<ItemStack> stackList = GalacticraftRegistry.getDungeonLoot(4);
		return stackList.get(rand.nextInt(stackList.size())).copy();
	}

	/**
	 * Will get destroyed next tick.
	 */
	@Override
	public void setDead() {
		if (this.spawner != null) {
			this.spawner.isBossDefeated = false;
			this.spawner.boss = null;
			this.spawner.spawned = false;
		}
		super.setDead();
	}

	/**
	 * Called by a player entity when they collide with an entity
	 */
	@Override
	public void onCollideWithPlayer(EntityPlayer p_70100_1_) {
		if (this.canDamagePlayer()) {
			int i = this.getSlimeSize();

			if (this.canEntityBeSeen(p_70100_1_) && this.getDistanceSqToEntity(p_70100_1_) < 0.6D * i * 0.6D * i && p_70100_1_.attackEntityFrom(DamageSource.causeMobDamage(this), this.getAttackStrength())) {
				this.playSound("mob.attack", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			}
		}
	}

	/**
	 * Indicates weather the slime is able to damage the player (based upon the
	 * slime's size)
	 */
	protected boolean canDamagePlayer() {
		return this.getSlimeSize() > 1;
	}

	/**
	 * Gets the amount of damage dealt to the player when "attacked" by the
	 * slime.
	 */
	protected int getAttackStrength() {
		return this.getSlimeSize();
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound() {
		return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound() {
		return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
	}

	@Override
	protected Item getDropItem() {
		return this.getSlimeSize() == 1 ? Items.slime_ball : Item.getItemById(0);
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	@Override
	protected float getSoundVolume() {
		return 0.4F * this.getSlimeSize();
	}

	/**
	 * The speed it takes to move the entityliving's rotationPitch through the
	 * faceEntity method. This is only currently use in wolves.
	 */
	@Override
	public int getVerticalFaceSpeed() {
		return 0;
	}

	/**
	 * Returns true if the slime makes a sound when it jumps (based upon the
	 * slime's size)
	 */
	protected boolean makesSoundOnJump() {
		return this.getSlimeSize() > 0;
	}

	/**
	 * Returns true if the slime makes a sound when it lands after a jump (based
	 * upon the slime's size)
	 */
	protected boolean makesSoundOnLand() {
		return this.getSlimeSize() > 2;
	}

	@Override
	public boolean canBreath() {
		return true;
	}

	@Override
	public void setRoom(Vector3 roomCoords, Vector3 roomSize) {
		this.roomCoords = roomCoords;
		this.roomSize = roomSize;
	}

	@Override
	public void onBossSpawned(TileEntityDungeonSpawner spawner) {
		this.spawner = spawner;
	}
}