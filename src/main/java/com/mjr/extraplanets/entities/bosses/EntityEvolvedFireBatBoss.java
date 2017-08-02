package com.mjr.extraplanets.entities.bosses;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.core.entities.EntityBossBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class EntityEvolvedFireBatBoss extends EntityBossBase implements IMob, IEntityBreathable {
	private int explosionStrength = 1;

	private static final DataParameter<Boolean> ATTACKING = EntityDataManager.<Boolean> createKey(EntityEvolvedFireBatBoss.class, DataSerializers.BOOLEAN);
	/** Coordinates of where the bat spawned. */
	private BlockPos spawnPosition;

	public EntityEvolvedFireBatBoss(World worldIn) {
		super(worldIn);
		this.setSize(6.5F, 6.9F);
		this.isImmuneToFire = true;
		this.tasks.addTask(7, new EntityEvolvedFireBatBoss.AIFireballAttack(this));
		this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(ATTACKING, Boolean.valueOf(false));
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

	@Override
	@Nullable
	protected SoundEvent getAmbientSound() {
		return this.rand.nextInt(4) != 0 ? null : SoundEvents.ENTITY_BAT_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound() {
		return SoundEvents.ENTITY_BAT_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_BAT_DEATH;
	}

	/**
	 * Returns true if this entity should push and be pushed by other entities when colliding.
	 */
	@Override
	public boolean canBePushed() {
		return false;
	}

	@Override
	protected void collideWithEntity(Entity entityIn) {
	}

	@Override
	protected void collideWithNearbyEntities() {
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(450.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100.0D);
	}

	@SideOnly(Side.CLIENT)
	public boolean isAttacking() {
		return this.dataManager.get(ATTACKING).booleanValue();
	}

	public void setAttacking(boolean attacking) {
		this.dataManager.set(ATTACKING, Boolean.valueOf(attacking));
	}

	public int getFireballStrength() {
		return this.explosionStrength;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void onUpdate() {
		super.onUpdate();

		if (!this.worldObj.isRemote && this.worldObj.getDifficulty() == EnumDifficulty.PEACEFUL) {
			this.setDead();
		}
		this.motionY *= 0.6000000238418579D;
	}

	@Override
	protected void updateAITasks() {
		super.updateAITasks();
		if (this.spawnPosition != null && (!this.worldObj.isAirBlock(this.spawnPosition) || this.spawnPosition.getY() < 1)) {
			this.spawnPosition = null;
		}

		if (this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.distanceSq(((int) this.posX), ((int) this.posY), ((int) this.posZ)) < 4.0D) {
			this.spawnPosition = new BlockPos((int) this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int) this.posY + this.rand.nextInt(6) - 2, (int) this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
		}

		double d0 = this.spawnPosition.getX() + 0.5D - this.posX;
		double d1 = this.spawnPosition.getY() + 1.5D - this.posY;
		double d2 = this.spawnPosition.getZ() + 0.5D - this.posZ;
		this.motionX += (Math.signum(d0) * 0.5D - this.motionX) * 0.10000000149011612D;
		this.motionY += (Math.signum(d1) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
		this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.10000000149011612D;
		float f = (float) (MathHelper.atan2(this.motionZ, this.motionX) * (180D / Math.PI)) - 90.0F;
		float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
		this.moveForward = 0.5F;
		this.rotationYaw += f1;
	}

	static class AIFireballAttack extends EntityAIBase {
		private EntityEvolvedFireBatBoss parentEntity;
		public int attackTimer;

		public AIFireballAttack(EntityEvolvedFireBatBoss entityEvolvedFireBatBoss) {
			this.parentEntity = entityEvolvedFireBatBoss;
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		@Override
		public boolean shouldExecute() {
			return this.parentEntity.getAttackTarget() != null;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		@Override
		public void startExecuting() {
			this.attackTimer = 0;
		}

		/**
		 * Resets the task
		 */
		@Override
		public void resetTask() {
			this.parentEntity.setAttacking(false);
		}

		/**
		 * Updates the task
		 */
		@Override
		public void updateTask() {
			EntityLivingBase entitylivingbase = this.parentEntity.getAttackTarget();

			if (entitylivingbase.getDistanceSqToEntity(this.parentEntity) < 4096.0D && this.parentEntity.canEntityBeSeen(entitylivingbase)) {
				World world = this.parentEntity.worldObj;
				++this.attackTimer;

				if (this.attackTimer == 10) {
					world.playEvent((EntityPlayer) null, 1015, new BlockPos(this.parentEntity), 0);
				}

				if (this.attackTimer == 10 || this.attackTimer == 30 || this.attackTimer == 50 || this.attackTimer == 70) {
					Vec3d vec3d = this.parentEntity.getLook(1.0F);
					double d2 = entitylivingbase.posX - (this.parentEntity.posX + vec3d.xCoord * 4.0D);
					double d3 = entitylivingbase.getEntityBoundingBox().minY + entitylivingbase.height / 2.0F - (0.5D + this.parentEntity.posY + this.parentEntity.height / 2.0F);
					double d4 = entitylivingbase.posZ - (this.parentEntity.posZ + vec3d.zCoord * 4.0D);
					world.playEvent((EntityPlayer) null, 1016, new BlockPos(this.parentEntity), 0);
					EntityLargeFireball entitylargefireball = new EntityLargeFireball(world, this.parentEntity, d2, d3, d4);
					entitylargefireball.explosionPower = this.parentEntity.getFireballStrength();
					entitylargefireball.posX = this.parentEntity.posX + vec3d.xCoord * 4.0D;
					entitylargefireball.posY = this.parentEntity.posY + this.parentEntity.height / 2.0F + 0.5D;
					entitylargefireball.posZ = this.parentEntity.posZ + vec3d.zCoord * 4.0D;
					world.spawnEntityInWorld(entitylargefireball);
					if (this.attackTimer == 70)
						this.attackTimer = -40;
				}
			} else if (this.attackTimer > 0) {
				--this.attackTimer;
			}

			this.parentEntity.setAttacking(this.attackTimer > 10);
		}
	}

	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to prevent them from trampling crops
	 */
	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
	}

	@Override
	protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
	}

	/**
	 * Return whether this entity should NOT trigger a pressure plate or a tripwire.
	 */
	@Override
	public boolean doesEntityNotTriggerPressurePlate() {
		return true;
	}

	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isEntityInvulnerable(source)) {
			return false;
		} else {
			return super.attackEntityFrom(source, amount);
		}
	}

	public static void registerFixesBat(DataFixer fixer) {
		EntityLiving.registerFixesMob(fixer, "Bat");
	}

	/**
	 * /** (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
		super.writeEntityToNBT(nbt);
		nbt.setInteger("ExplosionPower", this.explosionStrength);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
		super.readEntityFromNBT(nbt);

		if (nbt.hasKey("ExplosionPower", 99)) {
			this.explosionStrength = nbt.getInteger("ExplosionPower");
		}
	}

	@Override
	public float getEyeHeight() {
		return this.height / 2.0F;
	}

	@Override
	public EntityItem entityDropItem(ItemStack par1ItemStack, float par2) {
		final EntityItem entityitem = new EntityItem(this.worldObj, this.posX, this.posY + par2, this.posZ, par1ItemStack);
		entityitem.motionY = -2.0D;
		entityitem.setDefaultPickupDelay();
		if (this.captureDrops) {
			this.capturedDrops.add(entityitem);
		} else {
			this.worldObj.spawnEntityInWorld(entityitem);
		}
		return entityitem;
	}

	@Override
	@Nullable
	protected ResourceLocation getLootTable() {
		return LootTableList.ENTITIES_BAT;
	}

	@Override
	public boolean canBreath() {
		return true;
	}

	@Override
	public int getChestTier() {
		return 5;
	}

	@Override
	public void dropKey() {
		this.entityDropItem(new ItemStack(ExtraPlanets_Items.TIER_5_KEY, 1, 0), 0.5F);
	}

	@Override
	public ItemStack getGuaranteedLoot(Random rand) {
		List<ItemStack> stackList = GalacticraftRegistry.getDungeonLoot(5);
		return stackList.get(rand.nextInt(stackList.size())).copy();
	}

	@Override
	public Color getHealthBarColor() {
		return Color.BLUE;
	}
}