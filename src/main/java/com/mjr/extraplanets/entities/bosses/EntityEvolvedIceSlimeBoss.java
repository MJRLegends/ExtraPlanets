package com.mjr.extraplanets.entities.bosses;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.entities.EntityBossBase;
import micdoodle8.mods.galacticraft.core.network.PacketSimple;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class EntityEvolvedIceSlimeBoss extends EntityBossBase implements IEntityBreathable {
	public float squishAmount;
	public float squishFactor;
	public float prevSquishFactor;
	private boolean wasOnGround;
	private static final DataParameter<Integer> SLIME_SIZE = EntityDataManager.<Integer> createKey(EntityEvolvedIceSlimeBoss.class, DataSerializers.VARINT);

	public EntityEvolvedIceSlimeBoss(World worldIn) {
		super(worldIn);
		this.moveHelper = new EntityEvolvedIceSlimeBoss.SlimeMoveHelper(this);
		this.tasks.addTask(1, new EntityEvolvedIceSlimeBoss.AISlimeFloat(this));
		this.tasks.addTask(2, new EntityEvolvedIceSlimeBoss.AISlimeAttack(this));
		this.tasks.addTask(3, new EntityEvolvedIceSlimeBoss.AISlimeFaceRandom(this));
		this.tasks.addTask(5, new EntityEvolvedIceSlimeBoss.AISlimeHop(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true, false, null));	}
	
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

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(SLIME_SIZE, Integer.valueOf(1));
	}

	protected void setSlimeSize(int size) {
		this.dataManager.set(SLIME_SIZE, Integer.valueOf(size));
		this.setSize(0.51000005F * size, 0.51000005F * size);
		this.setPosition(this.posX, this.posY, this.posZ);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((0.2F + 0.1F * size) / 2);
		this.setHealth(this.getMaxHealth());
		this.experienceValue = size;
	}

	/**
	 * Returns the size of the slime.
	 */
	public int getSlimeSize() {
		return this.dataManager.get(SLIME_SIZE).intValue();
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void writeEntityToNBT(NBTTagCompound tagCompound) {
		super.writeEntityToNBT(tagCompound);
		tagCompound.setInteger("Size", this.getSlimeSize() - 1);
		tagCompound.setBoolean("wasOnGround", this.wasOnGround);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readEntityFromNBT(NBTTagCompound tagCompund) {
		super.readEntityFromNBT(tagCompund);
		int i = tagCompund.getInteger("Size");

		if (i < 0) {
			i = 0;
		}

		this.setSlimeSize(i + 1);
		this.wasOnGround = tagCompund.getBoolean("wasOnGround");
	}

	protected EnumParticleTypes getParticleType() {
		return EnumParticleTypes.SLIME;
	}

	/**
     * Called to update the entity's position/logic.
     */
    @Override
	public void onUpdate()
    {
        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL && this.getSlimeSize() > 0)
        {
            this.isDead = true;
        }

        this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
        this.prevSquishFactor = this.squishFactor;
        super.onUpdate();

        if (this.onGround && !this.wasOnGround)
        {
            int i = this.getSlimeSize();
            if (spawnCustomParticles()) { i = 0; } // don't spawn particles if it's handled by the implementation itself
            for (int j = 0; j < i * 8; ++j)
            {
                float f = this.rand.nextFloat() * ((float)Math.PI * 2F);
                float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
                float f2 = MathHelper.sin(f) * i * 0.5F * f1;
                float f3 = MathHelper.cos(f) * i * 0.5F * f1;
                World world = this.world;
                EnumParticleTypes enumparticletypes = this.getParticleType();
                double d0 = this.posX + f2;
                double d1 = this.posZ + f3;
                world.spawnParticle(enumparticletypes, d0, this.getEntityBoundingBox().minY, d1, 0.0D, 0.0D, 0.0D, new int[0]);
            }

            this.playSound(this.getSquishSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            this.squishAmount = -0.5F;
        }
        else if (!this.onGround && this.wasOnGround)
        {
            this.squishAmount = 1.0F;
        }

        this.wasOnGround = this.onGround;
        this.alterSquishAmount();
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

	protected EntityEvolvedIceSlimeBoss createInstance() {
		return new EntityEvolvedIceSlimeBoss(this.world);
	}

	@Override
	public void notifyDataManagerChange(DataParameter<?> key) {
		if (SLIME_SIZE.equals(key)) {
			int i = this.getSlimeSize();
			this.setSize(0.51000005F * i, 0.51000005F * i);
			this.rotationYaw = this.rotationYawHead;
			this.renderYawOffset = this.rotationYawHead;

			if (this.isInWater() && this.rand.nextInt(20) == 0) {
				this.resetHeight();
			}
		}

		super.notifyDataManagerChange(key);
	}

	/**
	 * Applies a velocity to each of the entities pushing them away from each other. Args: entity
	 */
	@Override
	public void applyEntityCollision(Entity entityIn) {
		super.applyEntityCollision(entityIn);
	}

	/**
	 * Called by a player entity when they collide with an entity
	 */
	@Override
	public void onCollideWithPlayer(EntityPlayer entityIn) {
		if (this.canDamagePlayer()) {
			this.dealDamage(entityIn);
		}
	}

	protected void dealDamage(EntityLivingBase entityIn) {
		int i = this.getSlimeSize();

		if (this.canEntityBeSeen(entityIn) && this.getDistanceSqToEntity(entityIn) < 0.6D * i * 0.6D * i && entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), this.getAttackStrength())) {
			this.playSound(SoundEvents.ENTITY_SLIME_ATTACK, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			this.applyEnchantments(this, entityIn);
		}
	}

	@Override
	public float getEyeHeight() {
		return 0.625F * this.height;
	}

	/**
	 * Indicates weather the slime is able to damage the player (based upon the slime's size)
	 */
	protected boolean canDamagePlayer() {
		return this.getSlimeSize() > 1;
	}

	/**
	 * Gets the amount of damage dealt to the player when "attacked" by the slime.
	 */
	protected int getAttackStrength() {
		return this.getSlimeSize() * 7;
	}

	@Override
	protected SoundEvent getHurtSound() {
		return SoundEvents.ENTITY_SLIME_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SLIME_DEATH;
	}

	protected SoundEvent getSquishSound() {
		return SoundEvents.ENTITY_SLIME_SQUISH;
	}

	protected SoundEvent getJumpSound() {
		return SoundEvents.ENTITY_SLIME_JUMP;
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	@Override
	protected float getSoundVolume() {
		return 0.4F * this.getSlimeSize();
	}

	/**
	 * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently use in wolves.
	 */
	@Override
	public int getVerticalFaceSpeed() {
		return 0;
	}

	/**
	 * Returns true if the slime makes a sound when it jumps (based upon the slime's size)
	 */
	protected boolean makesSoundOnJump() {
		return this.getSlimeSize() > 0;
	}

	/**
	 * Returns true if the slime makes a sound when it lands after a jump (based upon the slime's size)
	 */
	protected boolean makesSoundOnLand() {
		return this.getSlimeSize() > 2;
	}

	/**
	 * Causes this entity to do an upwards motion (jumping).
	 */
	@Override
	protected void jump() {
		this.motionY = 0.41999998688697815D;
		this.isAirBorne = true;
	}

	/**
	 * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
	 */
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		this.setSlimeSize(6);
		return super.onInitialSpawn(difficulty, livingdata);
	}

	/*
	 * ======================================== FORGE START =====================================
	 */
	/**
	 * Called when the slime spawns particles on landing, see onUpdate. Return true to prevent the spawning of the default particles.
	 */
	protected boolean spawnCustomParticles() {
		return false;
	}

	/*
	 * ======================================== FORGE END =====================================
	 */

	static class AISlimeAttack extends EntityAIBase {
		private EntityEvolvedIceSlimeBoss slime;
		private int field_179465_b;

		public AISlimeAttack(EntityEvolvedIceSlimeBoss p_i45824_1_) {
			this.slime = p_i45824_1_;
			this.setMutexBits(2);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		@Override
		public boolean shouldExecute() {
			EntityLivingBase entitylivingbase = this.slime.getAttackTarget();
			return entitylivingbase == null ? false : (!entitylivingbase.isEntityAlive() ? false : !(entitylivingbase instanceof EntityPlayer) || !((EntityPlayer) entitylivingbase).capabilities.disableDamage);
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		@Override
		public void startExecuting() {
			this.field_179465_b = 300;
			super.startExecuting();
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		@Override
		public boolean continueExecuting() {
			EntityLivingBase entitylivingbase = this.slime.getAttackTarget();
			return entitylivingbase == null ? false : (!entitylivingbase.isEntityAlive() ? false : (entitylivingbase instanceof EntityPlayer && ((EntityPlayer) entitylivingbase).capabilities.disableDamage ? false : --this.field_179465_b > 0));
		}

		/**
		 * Updates the task
		 */
		@Override
		public void updateTask() {
			this.slime.faceEntity(this.slime.getAttackTarget(), 10.0F, 10.0F);
			((EntityEvolvedIceSlimeBoss.SlimeMoveHelper) this.slime.getMoveHelper()).setDirection(this.slime.rotationYaw, this.slime.canDamagePlayer());
		}
	}

	static class AISlimeFaceRandom extends EntityAIBase {
		private EntityEvolvedIceSlimeBoss slime;
		private float field_179459_b;
		private int field_179460_c;

		public AISlimeFaceRandom(EntityEvolvedIceSlimeBoss p_i45820_1_) {
			this.slime = p_i45820_1_;
			this.setMutexBits(2);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		@Override
		public boolean shouldExecute() {
			return this.slime.getAttackTarget() == null && (this.slime.onGround || this.slime.isInWater() || this.slime.isInLava());
		}

		/**
		 * Updates the task
		 */
		@Override
		public void updateTask() {
			if (--this.field_179460_c <= 0) {
				this.field_179460_c = 40 + this.slime.getRNG().nextInt(60);
				this.field_179459_b = this.slime.getRNG().nextInt(360);
			}

			((EntityEvolvedIceSlimeBoss.SlimeMoveHelper) this.slime.getMoveHelper()).setDirection(this.field_179459_b, false);
		}
	}

	static class AISlimeFloat extends EntityAIBase {
		private EntityEvolvedIceSlimeBoss slime;

		public AISlimeFloat(EntityEvolvedIceSlimeBoss p_i45823_1_) {
			this.slime = p_i45823_1_;
			this.setMutexBits(5);
			((PathNavigateGround) p_i45823_1_.getNavigator()).setCanSwim(true);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		@Override
		public boolean shouldExecute() {
			return this.slime.isInWater() || this.slime.isInLava();
		}

		/**
		 * Updates the task
		 */
		@Override
		public void updateTask() {
			if (this.slime.getRNG().nextFloat() < 0.8F) {
				this.slime.getJumpHelper().setJumping();
			}

			((EntityEvolvedIceSlimeBoss.SlimeMoveHelper) this.slime.getMoveHelper()).setSpeed(1.2D);
		}
	}

	static class AISlimeHop extends EntityAIBase {
		private EntityEvolvedIceSlimeBoss slime;

		public AISlimeHop(EntityEvolvedIceSlimeBoss p_i45822_1_) {
			this.slime = p_i45822_1_;
			this.setMutexBits(5);
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
			((EntityEvolvedIceSlimeBoss.SlimeMoveHelper) this.slime.getMoveHelper()).setSpeed(1.0D);
		}
	}

	static class SlimeMoveHelper extends EntityMoveHelper
    {
        private float yRot;
        private int jumpDelay;
        private final EntityEvolvedIceSlimeBoss slime;
        private boolean isAggressive;

        public SlimeMoveHelper(EntityEvolvedIceSlimeBoss slimeIn)
        {
            super(slimeIn);
            this.slime = slimeIn;
            this.yRot = 180.0F * slimeIn.rotationYaw / (float)Math.PI;
        }

        public void setDirection(float p_179920_1_, boolean p_179920_2_)
        {
            this.yRot = p_179920_1_;
            this.isAggressive = p_179920_2_;
        }

        public void setSpeed(double speedIn)
        {
            this.speed = speedIn;
            this.action = EntityMoveHelper.Action.MOVE_TO;
        }

        @Override
		public void onUpdateMoveHelper()
        {
            this.entity.rotationYaw = this.limitAngle(this.entity.rotationYaw, this.yRot, 90.0F);
            this.entity.rotationYawHead = this.entity.rotationYaw;
            this.entity.renderYawOffset = this.entity.rotationYaw;

            if (this.action != EntityMoveHelper.Action.MOVE_TO)
            {
                this.entity.setMoveForward(0.0F);
            }
            else
            {
                this.action = EntityMoveHelper.Action.WAIT;

                if (this.entity.onGround)
                {
                    this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));

                    if (this.jumpDelay-- <= 0)
                    {
                        this.jumpDelay = this.slime.getJumpDelay();

                        if (this.isAggressive)
                        {
                            this.jumpDelay /= 3;
                        }

                        this.slime.getJumpHelper().setJumping();

                        if (this.slime.makesSoundOnJump())
                        {
                            this.slime.playSound(this.slime.getJumpSound(), this.slime.getSoundVolume(), ((this.slime.getRNG().nextFloat() - this.slime.getRNG().nextFloat()) * 0.2F + 1.0F) * 0.8F);
                        }
                    }
                    else
                    {
                        this.slime.moveStrafing = 0.0F;
                        this.slime.moveForward = 0.0F;
                        this.entity.setAIMoveSpeed(0.0F);
                    }
                }
                else
                {
                    this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));
                }
            }
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
		return 7;
	}

	@Override
	public void dropKey() {
		this.entityDropItem(new ItemStack(ExtraPlanets_Items.TIER_7_KEY, 1, 0), 0.5F);
	}

	@Override
	public ItemStack getGuaranteedLoot(Random rand) {
		List<ItemStack> stackList = GalacticraftRegistry.getDungeonLoot(7);
		return stackList.get(rand.nextInt(stackList.size())).copy();
	}

	@Override
	public Color getHealthBarColor() {
		return Color.BLUE;
	}
}