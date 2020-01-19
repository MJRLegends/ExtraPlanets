package com.mjr.extraplanets.entities;

import com.mjr.mjrlegendslib.entity.EntityTNTPrimedBase;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityNuclearBombPrimed extends EntityTNTPrimedBase {

	public EntityNuclearBombPrimed(World worldIn) {
		super(worldIn);
	}

	public EntityNuclearBombPrimed(World worldIn, double x, double y, double z, EntityLivingBase igniter) {
		super(worldIn, x, y, z, igniter);
	}

	@Override
	protected void explode() {
		float f = 25.0F;
		this.world.createExplosion(this, this.posX, this.posY + this.height / 16.0F, this.posZ, f, true);
	}
}