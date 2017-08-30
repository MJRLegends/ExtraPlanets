package com.mjr.extraplanets.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntitySmallSnowball extends EntitySnowball {
	public EntitySmallSnowball(World worldIn) {
		super(worldIn);
	}

	public EntitySmallSnowball(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntitySmallSnowball(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	@Override
	protected void onImpact(RayTraceResult p_70184_1_) {
		if (p_70184_1_.entityHit != null) {
			int i = 0;
			if (p_70184_1_.entityHit instanceof EntityPlayer) {
				i = 20;
			}

			p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), i);
		}

		for (int j = 0; j < 8; ++j) {
			this.worldObj.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
		}

		if (!this.worldObj.isRemote) {
			this.setDead();
		}
	}
}