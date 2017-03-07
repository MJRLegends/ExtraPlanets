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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.entities.projectiles.EntitySmallSnowball;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.tile.TileEntityT6TreasureChest;

import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;

public class EntityEvolvedSnowmanBoss extends EntityGolem implements IRangedAttackMob, IEntityBreathable, IBossDisplayData, IBoss {

	private Vector3 roomCoords;
	private Vector3 roomSize;

	public int entitiesWithin;
	public int entitiesWithinLast;
	public int deathTicks = 0;

	private TileEntityDungeonSpawner spawner;

	public EntityEvolvedSnowmanBoss(World p_i1692_1_) {
		super(p_i1692_1_);
		this.setSize(0.4F * 8, 1.8F * 6.5F);
		this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAIArrowAttack(this, 0.75D, 20, 5F));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 12.0F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled() {
		return true;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(400.0F);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
	}
	
	protected void updateEntityActionState() {
		if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
			this.setDead();
		}
	}

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons use this to react to sunlight and start to burn.
	 */
	public void onLivingUpdate() {
		super.onLivingUpdate();
		
		new Vector3(this);

		if (this.roomCoords != null && this.roomSize != null) {
			@SuppressWarnings("unchecked")
			List<Entity> entitiesWithin = this.worldObj.getEntitiesWithinAABB(
					EntityPlayer.class,
					AxisAlignedBB.getBoundingBox(this.roomCoords.intX() - 1, this.roomCoords.intY() - 1, this.roomCoords.intZ() - 1, this.roomCoords.intX() + this.roomSize.intX(), this.roomCoords.intY() + this.roomSize.intY(), this.roomCoords.intZ()
							+ this.roomSize.intZ()));

			this.entitiesWithin = entitiesWithin.size();

			if (this.entitiesWithin == 0 && this.entitiesWithinLast != 0) {
				@SuppressWarnings("unchecked")
				List<EntityPlayer> entitiesWithin2 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(this.roomCoords.intX() - 11, this.roomCoords.intY() - 11, this.roomCoords.intZ() - 11, this.roomCoords.intX()
						+ this.roomSize.intX() + 10, this.roomCoords.intY() + this.roomSize.intY() + 10, this.roomCoords.intZ() + this.roomSize.intZ() + 10));

				for (EntityPlayer p : entitiesWithin2) {
					p.addChatMessage(new ChatComponentText(GCCoreUtil.translate("gui.skeletonBoss.message")));
				}

				this.setDead();

				if (this.spawner != null) {
					this.spawner.playerCheated = true;
				}

				return;
			}

			this.entitiesWithinLast = this.entitiesWithin;
		}
	}

	protected Item getDropItem() {
		return Items.snowball;
	}

	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param par2 - Level of Looting used to kill this mob.
	 */
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		int j = this.rand.nextInt(16);

		for (int k = 0; k < j; ++k) {
			this.dropItem(Items.snowball, 1);
		}
	}

	/**
	 * Attack the specified entity using a ranged attack.
	 */
	public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
		EntitySmallSnowball entitysnowball = new EntitySmallSnowball(this.worldObj, this);
		double d0 = p_82196_1_.posX - this.posX;
		double d1 = p_82196_1_.posY + (double) p_82196_1_.getEyeHeight() - 1.100000023841858D - entitysnowball.posY;
		double d2 = p_82196_1_.posZ - this.posZ;
		entitysnowball.setThrowableHeading(d0, d1, d2, 1.6F, 1.0F);
		this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.worldObj.spawnEntityInWorld(entitysnowball);
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
		super.writeEntityToNBT(nbt);
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
		this.roomCoords = new Vector3();
		this.roomCoords.x = nbt.getDouble("roomCoordsX");
		this.roomCoords.y = nbt.getDouble("roomCoordsY");
		this.roomCoords.z = nbt.getDouble("roomCoordsZ");
		this.roomSize = new Vector3();
		this.roomSize.x = nbt.getDouble("roomSizeX");
		this.roomSize.y = nbt.getDouble("roomSizeY");
		this.roomSize.z = nbt.getDouble("roomSizeZ");
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

	@Override
	public boolean canBreath() {
		return true;
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
				// PacketDispatcher.sendPacketToAllAround(this.posX, this.posY, this.posZ, 40.0, this.worldObj.provider.dimensionId, PacketUtil.createPacket(GalacticraftCore.CHANNEL, EnumPacketClient.PLAY_SOUND_EXPLODE, new Object[] { 0 }));
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
				// PacketDispatcher.sendPacketToAllAround(this.posX, this.posY, this.posZ, 40.0, this.worldObj.provider.dimensionId, PacketUtil.createPacket(GalacticraftCore.CHANNEL, EnumPacketClient.PLAY_SOUND_BOSS_DEATH, new Object[] { 0 }));
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
				if (tile instanceof TileEntityT6TreasureChest) {
					final double d3 = tile.xCoord + 0.5D - this.posX;
					final double d4 = tile.yCoord + 0.5D - this.posY;
					final double d5 = tile.zCoord + 0.5D - this.posZ;
					final double dSq = d3 * d3 + d4 * d4 + d5 * d5;
					TileEntityT6TreasureChest chest = (TileEntityT6TreasureChest) tile;

					if (dSq < 10000) {
						if (!chest.locked) {
							chest.locked = true;
						}

						for (int k = 0; k < chest.getSizeInventory(); k++) {
							chest.setInventorySlotContents(k, null);
						}

						ChestGenHooks info = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);

						// Generate three times, since it's an extra extra special chest
						WeightedRandomChestContent.generateChestContents(this.rand, info.getItems(this.rand), chest, info.getCount(this.rand));
						WeightedRandomChestContent.generateChestContents(this.rand, info.getItems(this.rand), chest, info.getCount(this.rand));
						WeightedRandomChestContent.generateChestContents(this.rand, info.getItems(this.rand), chest, info.getCount(this.rand));

						chest.setInventorySlotContents(this.rand.nextInt(chest.getSizeInventory()), this.getGuaranteedLoot(this.rand));

						break;
					}
				}
			}

			this.entityDropItem(new ItemStack(ExtraPlanets_Items.T6key, 1, 0), 0.5F);

			super.setDead();

			if (this.spawner != null) {
				this.spawner.isBossDefeated = true;
				this.spawner.boss = null;
				this.spawner.spawned = false;
			}
		}
	}

	@Override
	public void setDead() {
		if (this.spawner != null) {
			this.spawner.isBossDefeated = false;
			this.spawner.boss = null;
			this.spawner.spawned = false;
		}

		super.setDead();
	}

	public ItemStack getGuaranteedLoot(Random rand) {
		List<ItemStack> stackList;
		if (Config.morePlanetsCompatibility)
			stackList = GalacticraftRegistry.getDungeonLoot(4);
		else
			stackList = GalacticraftRegistry.getDungeonLoot(8);
		return stackList.get(rand.nextInt(stackList.size())).copy();
	}
}