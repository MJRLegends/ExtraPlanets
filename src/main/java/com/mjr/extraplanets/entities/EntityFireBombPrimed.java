package com.mjr.extraplanets.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityFireBombPrimed extends Entity {
	public int fuse;
	private EntityLivingBase tntPlacedBy;

	public EntityFireBombPrimed(World p_i1729_1_) {
		super(p_i1729_1_);
		this.fuse = 80;
		this.preventEntitySpawning = true;
		this.setSize(0.98F, 0.98F);
		this.yOffset = this.height / 2.0F;
	}

	public EntityFireBombPrimed(World p_i1730_1_, double p_i1730_2_, double p_i1730_4_, double p_i1730_6_, EntityLivingBase p_i1730_8_) {
		this(p_i1730_1_);
		this.setPosition(p_i1730_2_, p_i1730_4_, p_i1730_6_);
		float f = (float) (Math.random() * Math.PI * 2.0D);
		this.motionX = -((float) Math.sin(f)) * 0.02F;
		this.motionY = 0.20000000298023224D;
		this.motionZ = -((float) Math.cos(f)) * 0.02F;
		this.fuse = 25;
		this.prevPosX = p_i1730_2_;
		this.prevPosY = p_i1730_4_;
		this.prevPosZ = p_i1730_6_;
		this.tntPlacedBy = p_i1730_8_;
	}

	@Override
	protected void entityInit() {
	}

	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to prevent them from trampling crops
	 */
	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	/**
	 * Returns true if other Entities should be prevented from moving through this Entity.
	 */
	@Override
	public boolean canBeCollidedWith() {
		return !this.isDead;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.motionY -= 0.03999999910593033D;
		this.moveEntity(this.motionX, this.motionY, this.motionZ);
		this.motionX *= 0.9800000190734863D;
		this.motionY *= 0.9800000190734863D;
		this.motionZ *= 0.9800000190734863D;

		if (this.onGround) {
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
			this.motionY *= -0.5D;
		}

		if (this.fuse-- <= 0) {
			this.setDead();

			if (!this.worldObj.isRemote) {
				this.explode();
			}
		} else {
			this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
		}
	}

	private void explode() {
		float f = 5.0F;
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, f, true);
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 15; j++){
				if(this.rand.nextInt(3) == 1)
					this.worldObj.setBlock((int)this.posX + i, this.worldObj.getHeightValue((int)this.posX + i, (int)this.posZ + j), (int)this.posZ + j, Blocks.fire);
			}
		}
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(this.rand.nextInt(3) == 1)
					this.worldObj.setBlock((int)this.posX - i, this.worldObj.getHeightValue((int)this.posX + i, (int)this.posZ + j), (int)this.posZ - j, Blocks.fire);
			}
		}
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(this.rand.nextInt(3) == 1)
					this.worldObj.setBlock((int)this.posX + i, this.worldObj.getHeightValue((int)this.posX + i, (int)this.posZ + j), (int)this.posZ - j, Blocks.fire);
			}
		}
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(this.rand.nextInt(3) == 1)
					this.worldObj.setBlock((int)this.posX - i, this.worldObj.getHeightValue((int)this.posX + i, (int)this.posZ + j), (int)this.posZ + j, Blocks.fire);
			}
		}
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {
		p_70014_1_.setInteger("Fuse", this.fuse);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {
		this.fuse = p_70037_1_.getInteger("Fuse");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public float getShadowSize() {
		return 0.0F;
	}

	/**
	 * returns null or the entityliving it was placed or ignited by
	 */
	public EntityLivingBase getTntPlacedBy() {
		return this.tntPlacedBy;
	}
}
