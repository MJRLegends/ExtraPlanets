package com.mjr.extraplanets.entities.bosses;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.entities.EntityBossBase;
import micdoodle8.mods.galacticraft.core.network.PacketSimple;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class EntityEvolvedGhastBoss extends EntityBossBase implements IMob, IEntityBreathable {
	private int explosionStrength = 1;
    private static final DataParameter<Boolean> ATTACKING = EntityDataManager.<Boolean>createKey(EntityEvolvedGhastBoss.class, DataSerializers.BOOLEAN);

	public EntityEvolvedGhastBoss(World worldIn) {
		super(worldIn);
		this.setSize(4.0F, 4.0F);
		this.isImmuneToFire = true;
		this.experienceValue = 5;
		this.moveHelper = new EntityEvolvedGhastBoss.GhastMoveHelper(this);
		this.tasks.addTask(5, new EntityEvolvedGhastBoss.AIRandomFly(this));
		this.tasks.addTask(7, new EntityEvolvedGhastBoss.AILookAround(this));
		this.tasks.addTask(7, new EntityEvolvedGhastBoss.AIFireballAttack(this));
		this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));
	}
	
    @Override
    protected void onDeathUpdate()
    {
        super.onDeathUpdate();

        if (!this.world.isRemote)
        {
            if (this.deathTicks == 100)
            {
                GalacticraftCore.packetPipeline.sendToAllAround(new PacketSimple(PacketSimple.EnumSimplePacket.C_PLAY_SOUND_BOSS_DEATH, GCCoreUtil.getDimensionID(this.world), new Object[] { 1.5F }), new NetworkRegistry.TargetPoint(GCCoreUtil.getDimensionID(this.world), this.posX, this.posY, this.posZ, 40.0D));
            }
        }
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

		if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL) {
			this.setDead();
		}
	}

	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isEntityInvulnerable(source)) {
			return false;
		} else if ("fireball".equals(source.getDamageType()) && source.getEntity() instanceof EntityPlayer) {
			super.attackEntityFrom(source, 10.0F);
            ((EntityPlayer)source.getEntity()).addStat(AchievementList.GHAST);
			return true;
		} else {
			return super.attackEntityFrom(source, amount);
		}
	}

	@Override
	protected void entityInit() {
        super.entityInit();
        this.dataManager.register(ATTACKING, Boolean.valueOf(false));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1000.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100.0D);
	}

    @Override
	public SoundCategory getSoundCategory()
    {
        return SoundCategory.HOSTILE;
    }

    @Override
	protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_GHAST_AMBIENT;
    }

    @Override
	protected SoundEvent getHurtSound()
    {
        return SoundEvents.ENTITY_GHAST_HURT;
    }

    @Override
	protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_GHAST_DEATH;
    }

	@Override
	protected Item getDropItem() {
		return Items.GUNPOWDER;
	}

	/**
	 * Drop 0-2 items of this living's type
	 */
	@Override
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		int i = this.rand.nextInt(2) + this.rand.nextInt(1 + p_70628_2_);

		for (int j = 0; j < i; ++j) {
			this.dropItem(Items.GHAST_TEAR, 1);
		}

		i = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);

		for (int k = 0; k < i; ++k) {
			this.dropItem(Items.GUNPOWDER, 1);
		}
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	@Override
	protected float getSoundVolume() {
		return 10.0F;
	}

	/**
	 * Checks if the entity's current position is a valid location to spawn this entity.
	 */
	@Override
	public boolean getCanSpawnHere() {
		return this.rand.nextInt(20) == 0 && super.getCanSpawnHere() && this.world.getDifficulty() != EnumDifficulty.PEACEFUL;
	}

	/**
	 * Will return how many at most can spawn in a chunk at once.
	 */
	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}

	@Override
	public float getEyeHeight() {
		return 2.6F;
	}

	static class AIFireballAttack extends EntityAIBase {
		private EntityEvolvedGhastBoss parentEntity;
		public int attackTimer;

		public AIFireballAttack(EntityEvolvedGhastBoss p_i45837_1_) {
			this.parentEntity = p_i45837_1_;
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
		public void updateTask()
        {
            EntityLivingBase entitylivingbase = this.parentEntity.getAttackTarget();
            double d0 = 64.0D;

            if (entitylivingbase.getDistanceSqToEntity(this.parentEntity) < 4096.0D && this.parentEntity.canEntityBeSeen(entitylivingbase))
            {
                World world = this.parentEntity.world;
                ++this.attackTimer;

                if (this.attackTimer == 10)
                {
                    world.playEvent((EntityPlayer)null, 1015, new BlockPos(this.parentEntity), 0);
                }

                if (this.attackTimer == 20)
                {
                    double d1 = 4.0D;
                    Vec3d vec3d = this.parentEntity.getLook(1.0F);
                    double d2 = entitylivingbase.posX - (this.parentEntity.posX + vec3d.xCoord * 4.0D);
                    double d3 = entitylivingbase.getEntityBoundingBox().minY + entitylivingbase.height / 2.0F - (0.5D + this.parentEntity.posY + this.parentEntity.height / 2.0F);
                    double d4 = entitylivingbase.posZ - (this.parentEntity.posZ + vec3d.zCoord * 4.0D);
                    world.playEvent((EntityPlayer)null, 1016, new BlockPos(this.parentEntity), 0);
                    EntityLargeFireball entitylargefireball = new EntityLargeFireball(world, this.parentEntity, d2, d3, d4);
                    entitylargefireball.explosionPower = this.parentEntity.getFireballStrength();
                    entitylargefireball.posX = this.parentEntity.posX + vec3d.xCoord * 4.0D;
                    entitylargefireball.posY = this.parentEntity.posY + this.parentEntity.height / 2.0F + 0.5D;
                    entitylargefireball.posZ = this.parentEntity.posZ + vec3d.zCoord * 4.0D;
                    world.spawnEntity(entitylargefireball);
                    this.attackTimer = -40;
                }
            }
            else if (this.attackTimer > 0)
            {
                --this.attackTimer;
            }

            this.parentEntity.setAttacking(this.attackTimer > 10);
        }
	}

	static class AILookAround extends EntityAIBase {
		private EntityEvolvedGhastBoss parentEntity;

		public AILookAround(EntityEvolvedGhastBoss p_i45839_1_) {
			this.parentEntity = p_i45839_1_;
			this.setMutexBits(2);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		@Override
		public boolean shouldExecute() {
			return true;
		}

		/**
		 * Updates the task
		 */
		@Override
		public void updateTask() {
			if (this.parentEntity.getAttackTarget() == null) {
				this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw = -((float) MathHelper.atan2(this.parentEntity.motionX, this.parentEntity.motionZ)) * 180.0F / Constants.floatPI;
			} else {
				EntityLivingBase entitylivingbase = this.parentEntity.getAttackTarget();
				double d0 = 64.0D;

				if (entitylivingbase.getDistanceSqToEntity(this.parentEntity) < d0 * d0) {
					double d1 = entitylivingbase.posX - this.parentEntity.posX;
					double d2 = entitylivingbase.posZ - this.parentEntity.posZ;
					this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw = -((float) MathHelper.atan2(d1, d2)) * 180.0F / Constants.floatPI;
				}
			}
		}
	}

	static class AIRandomFly extends EntityAIBase {
		private EntityEvolvedGhastBoss parentEntity;

		public AIRandomFly(EntityEvolvedGhastBoss p_i45836_1_) {
			this.parentEntity = p_i45836_1_;
			this.setMutexBits(1);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		@Override
		public boolean shouldExecute() {
			EntityMoveHelper entitymovehelper = this.parentEntity.getMoveHelper();

			if (!entitymovehelper.isUpdating()) {
				return true;
			} else {
				double d0 = entitymovehelper.getX() - this.parentEntity.posX;
				double d1 = entitymovehelper.getY() - this.parentEntity.posY;
				double d2 = entitymovehelper.getZ() - this.parentEntity.posZ;
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;
				return d3 < 1.0D || d3 > 3600.0D;
			}
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		@Override
		public boolean continueExecuting() {
			return false;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		@Override
		public void startExecuting() {
			Random random = this.parentEntity.getRNG();
			double d0 = this.parentEntity.posX + (random.nextFloat() * 2.0F - 1.0F) * 16.0F;
			double d1 = this.parentEntity.posY + (random.nextFloat() * 2.0F - 1.0F) * 16.0F;
			double d2 = this.parentEntity.posZ + (random.nextFloat() * 2.0F - 1.0F) * 16.0F;
			this.parentEntity.getMoveHelper().setMoveTo(d0, d1, d2, 1.0D);
		}
	}

	static class GhastMoveHelper extends EntityMoveHelper
    {
        private final EntityEvolvedGhastBoss parentEntity;
        private int courseChangeCooldown;

        public GhastMoveHelper(EntityEvolvedGhastBoss ghast)
        {
            super(ghast);
            this.parentEntity = ghast;
        }

        @Override
		public void onUpdateMoveHelper()
        {
            if (this.action == EntityMoveHelper.Action.MOVE_TO)
            {
                double d0 = this.posX - this.parentEntity.posX;
                double d1 = this.posY - this.parentEntity.posY;
                double d2 = this.posZ - this.parentEntity.posZ;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;

                if (this.courseChangeCooldown-- <= 0)
                {
                    this.courseChangeCooldown += this.parentEntity.getRNG().nextInt(5) + 2;
                    d3 = MathHelper.sqrt(d3);

                    if (this.isNotColliding(this.posX, this.posY, this.posZ, d3))
                    {
                        this.parentEntity.motionX += d0 / d3 * 0.1D;
                        this.parentEntity.motionY += d1 / d3 * 0.1D;
                        this.parentEntity.motionZ += d2 / d3 * 0.1D;
                    }
                    else
                    {
                        this.action = EntityMoveHelper.Action.WAIT;
                    }
                }
            }
        }

        /**
         * Checks if entity bounding box is not colliding with terrain
         */
        private boolean isNotColliding(double x, double y, double z, double p_179926_7_)
        {
            double d0 = (x - this.parentEntity.posX) / p_179926_7_;
            double d1 = (y - this.parentEntity.posY) / p_179926_7_;
            double d2 = (z - this.parentEntity.posZ) / p_179926_7_;
            AxisAlignedBB axisalignedbb = this.parentEntity.getEntityBoundingBox();

            for (int i = 1; i < p_179926_7_; ++i)
            {
                axisalignedbb = axisalignedbb.offset(d0, d1, d2);

                if (!this.parentEntity.world.getCollisionBoxes(this.parentEntity, axisalignedbb).isEmpty())
                {
                    return false;
                }
            }

            return true;
        }
    }

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
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
    public EntityItem entityDropItem(ItemStack par1ItemStack, float par2)
    {
        final EntityItem entityitem = new EntityItem(this.world, this.posX, this.posY + par2, this.posZ, par1ItemStack);
        entityitem.motionY = -2.0D;
        entityitem.setDefaultPickupDelay();
        if (this.captureDrops)
        {
            this.capturedDrops.add(entityitem);
        }
        else
        {
            this.world.spawnEntity(entityitem);
        }
        return entityitem;
    }

	@Override
	public boolean canBreath() {
		return true;
	}

	@Override
	public int getChestTier() {
		return 6;
	}

	@Override
	public void dropKey() {
		this.entityDropItem(new ItemStack(ExtraPlanets_Items.TIER_6_KEY, 1, 0), 0.5F);
	}

	@Override
	public ItemStack getGuaranteedLoot(Random rand) {
		List<ItemStack> stackList;
		if(Config.MORE_PLANETS_COMPATIBILITY)
			stackList = GalacticraftRegistry.getDungeonLoot(5);
		else
			stackList = GalacticraftRegistry.getDungeonLoot(6);
		return stackList.get(rand.nextInt(stackList.size())).copy();
	}

	@Override
	public Color getHealthBarColor() {
		return Color.BLUE;
	}
}