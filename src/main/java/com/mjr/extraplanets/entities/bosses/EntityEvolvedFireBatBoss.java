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
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.tileEntities.treasureChest.TileEntityT5TreasureChest;

import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityEvolvedFireBatBoss extends EntityMob implements IMob, IEntityBreathable, IBossDisplayData, IBoss {
	private Vector3 roomCoords;
	private Vector3 roomSize;

	public int entitiesWithin;
	public int entitiesWithinLast;
	public int deathTicks = 0;
	private TileEntityDungeonSpawner spawner;
	public int courseChangeCooldown;
	public double waypointX;
	public double waypointY;
	public double waypointZ;
	private Entity targetedEntity;
	/** Cooldown time between target loss and new target aquirement. */
	private int aggroCooldown;
	public int prevAttackCounter;
	public int attackCounter;
	/** The explosion radius of spawned fireballs. */
	private int explosionStrength = 1;

	/** Coordinates of where the bat spawned. */
	private ChunkCoordinates spawnPosition;

	public EntityEvolvedFireBatBoss(World p_i1680_1_) {
		super(p_i1680_1_);
		this.setSize(6.5F, 6.9F);
		this.isImmuneToFire = true;
	}

	@SideOnly(Side.CLIENT)
	public boolean func_110182_bF() {
		return this.dataWatcher.getWatchableObjectByte(16) != 0;
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte) 0));
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	@Override
	protected float getSoundVolume() {
		return 0.1F;
	}

	/**
	 * Gets the pitch of living sounds in living entities.
	 */
	@Override
	protected float getSoundPitch() {
		return super.getSoundPitch() * 0.95F;
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	@Override
	protected String getLivingSound() {
		return this.rand.nextInt(4) != 0 ? null : "mob.bat.idle";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound() {
		return "mob.bat.hurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound() {
		return "mob.bat.death";
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(450.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(100.0D);
	}

	@Override
	protected void updateEntityActionState() {
		if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
			this.setDead();
		}

		this.despawnEntity();
		this.prevAttackCounter = this.attackCounter;
		double d0 = this.waypointX - this.posX;
		double d1 = this.waypointY - this.posY;
		double d2 = this.waypointZ - this.posZ;
		double d3 = d0 * d0 + d1 * d1 + d2 * d2;

		if (d3 < 1.0D || d3 > 3600.0D) {
			this.waypointX = this.posX + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F;
			this.waypointY = this.posY + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F;
			this.waypointZ = this.posZ + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F;
		}

		if (this.courseChangeCooldown-- <= 0) {
			this.courseChangeCooldown += this.rand.nextInt(5) + 2;
			d3 = MathHelper.sqrt_double(d3);

			if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d3)) {
				this.motionX += d0 / d3 * 0.1D;
				this.motionY += d1 / d3 * 0.1D;
				this.motionZ += d2 / d3 * 0.1D;
			} else {
				this.waypointX = this.posX;
				this.waypointY = this.posY;
				this.waypointZ = this.posZ;
			}
		}

		if (this.targetedEntity != null && this.targetedEntity.isDead) {
			this.targetedEntity = null;
		}

		if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
			this.targetedEntity = this.worldObj.getClosestVulnerablePlayerToEntity(this, 100.0D);

			if (this.targetedEntity != null) {
				this.aggroCooldown = 20;
			}
		}

		double d4 = 64.0D;

		if (this.targetedEntity != null && this.targetedEntity.getDistanceSqToEntity(this) < d4 * d4) {
			double d5 = this.targetedEntity.posX - this.posX;
			double d6 = this.targetedEntity.boundingBox.minY + this.targetedEntity.height / 2.0F - (this.posY + this.height / 2.0F);
			double d7 = this.targetedEntity.posZ - this.posZ;
			this.renderYawOffset = this.rotationYaw = -((float) Math.atan2(d5, d7)) * 180.0F / (float) Math.PI;

			if (this.canEntityBeSeen(this.targetedEntity)) {
				if (this.attackCounter == 10) {
					this.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1007, (int) this.posX, (int) this.posY, (int) this.posZ, 0);
				}

				++this.attackCounter;

				if (this.attackCounter == 20) {
					this.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1008, (int) this.posX, (int) this.posY, (int) this.posZ, 0);
					EntityLargeFireball entitylargefireball = new EntityLargeFireball(this.worldObj, this, d5, d6, d7);
					entitylargefireball.field_92057_e = this.explosionStrength;
					double d8 = 4.0D;
					Vec3 vec3 = this.getLook(1.0F);
					entitylargefireball.posX = this.posX + vec3.xCoord * d8;
					entitylargefireball.posY = this.posY + this.height / 2.0F + 1.5D;
					entitylargefireball.posZ = this.posZ + vec3.zCoord * d8;
					this.worldObj.spawnEntityInWorld(entitylargefireball);
					this.attackCounter = -40;
				}
			} else if (this.attackCounter > 0) {
				--this.attackCounter;
			}
		} else {
			this.renderYawOffset = this.rotationYaw = -((float) Math.atan2(this.motionX, this.motionZ)) * 180.0F / (float) Math.PI;

			if (this.attackCounter > 0) {
				--this.attackCounter;
			}
		}

		if (!this.worldObj.isRemote) {
			byte b1 = this.dataWatcher.getWatchableObjectByte(16);
			byte b0 = (byte) (this.attackCounter > 10 ? 1 : 0);

			if (b1 != b0) {
				this.dataWatcher.updateObject(16, Byte.valueOf(b0));
			}
		}

		if (this.spawnPosition != null && (!this.worldObj.isAirBlock(this.spawnPosition.posX, this.spawnPosition.posY, this.spawnPosition.posZ) || this.spawnPosition.posY < 1)) {
			this.spawnPosition = null;
		}

		if (this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 4.0F) {
			this.spawnPosition = new ChunkCoordinates((int) this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int) this.posY + this.rand.nextInt(6) - 2, (int) this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
		}

		double d01 = this.spawnPosition.posX + 0.5D - this.posX;
		double d11 = this.spawnPosition.posY + 0.1D - this.posY;
		double d21 = this.spawnPosition.posZ + 0.5D - this.posZ;
		this.motionX += (Math.signum(d01) * 0.5D - this.motionX) * 0.10000000149011612D;
		this.motionY += (Math.signum(d11) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
		this.motionZ += (Math.signum(d21) * 0.5D - this.motionZ) * 0.10000000149011612D;
		float f = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
		float f1 = MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
		this.moveForward = 0.5F;
		this.rotationYaw += f1;
	}

	/**
	 * True if the ghast has an unobstructed line of travel to the waypoint.
	 */
	private boolean isCourseTraversable(double p_70790_1_, double p_70790_3_, double p_70790_5_, double p_70790_7_) {
		double d4 = (this.waypointX - this.posX) / p_70790_7_;
		double d5 = (this.waypointY - this.posY) / p_70790_7_;
		double d6 = (this.waypointZ - this.posZ) / p_70790_7_;
		AxisAlignedBB axisalignedbb = this.boundingBox.copy();

		for (int i = 1; i < p_70790_7_; ++i) {
			axisalignedbb.offset(d4, d5, d6);

			if (!this.worldObj.getCollidingBoundingBoxes(this, axisalignedbb).isEmpty()) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void onUpdate() {
		super.onUpdate();
		this.motionY *= 0.6000000238418579D;

	}

	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to prevent them from trampling crops
	 */
	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	/**
	 * Called when the mob is falling. Calculates and applies fall damage.
	 */
	@Override
	protected void fall(float p_70069_1_) {
	}

	/**
	 * Takes in the distance the entity has fallen this tick and whether its on the ground to update the fall distance and deal fall damage if landing on the ground. Args: distanceFallenThisTick, onGround
	 */
	@Override
	protected void updateFallState(double p_70064_1_, boolean p_70064_3_) {
	}

	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
		if (this.isEntityInvulnerable()) {
			return false;
		} else {
			return super.attackEntityFrom(p_70097_1_, p_70097_2_);
		}
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
		super.writeEntityToNBT(nbt);
		nbt.setByte("BatFlags", this.dataWatcher.getWatchableObjectByte(16));
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
		this.dataWatcher.updateObject(16, Byte.valueOf(nbt.getByte("BatFlags")));

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
				if (tile instanceof TileEntityT5TreasureChest) {
					final double d3 = tile.xCoord + 0.5D - this.posX;
					final double d4 = tile.yCoord + 0.5D - this.posY;
					final double d5 = tile.zCoord + 0.5D - this.posZ;
					final double dSq = d3 * d3 + d4 * d4 + d5 * d5;
					TileEntityT5TreasureChest chest = (TileEntityT5TreasureChest) tile;

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

			this.entityDropItem(new ItemStack(ExtraPlanets_Items.T5key, 1, 0), 0.5F);

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

	@Override
	public void onLivingUpdate() {
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

		super.onLivingUpdate();
	}

	public ItemStack getGuaranteedLoot(Random rand) {
		List<ItemStack> stackList;
		stackList = GalacticraftRegistry.getDungeonLoot(5);
		return stackList.get(rand.nextInt(stackList.size())).copy();
	}
}