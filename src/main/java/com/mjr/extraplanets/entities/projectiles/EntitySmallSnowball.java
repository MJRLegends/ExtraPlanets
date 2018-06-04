package com.mjr.extraplanets.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntitySmallSnowball extends EntitySnowball {
	public EntitySmallSnowball(World world) {
		super(world);
	}

	public EntitySmallSnowball(World world, EntityLivingBase throwerIn) {
		super(world, throwerIn);
	}

	public EntitySmallSnowball(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (result.entityHit != null) {
			int i = 0;
			if (result.entityHit instanceof EntityPlayer) {
				i = 20;
			}

			result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), i);
		}

		for (int j = 0; j < 8; ++j) {
			this.world.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
		}

		if (!this.world.isRemote) {
			this.setDead();
		}
	}
}