package com.mjr.extraplanets.entities;

import com.mjr.mjrlegendslib.entity.EntityTNTPrimedBase;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityFireBombPrimed extends EntityTNTPrimedBase {

	public EntityFireBombPrimed(World worldIn) {
		super(worldIn);
	}

	public EntityFireBombPrimed(World worldIn, double x, double y, double z, EntityLivingBase igniter) {
		super(worldIn, x, y, z, igniter);
	}

	@Override
	protected void explode() {
		float f = 5.0F;
		this.world.createExplosion(this, this.posX, this.posY + this.height / 16.0F, this.posZ, f, true);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 15; j++) {
				if (this.rand.nextInt(3) == 1)
					this.world.setBlockState(new BlockPos((int) this.posX + i, this.world.getTopSolidOrLiquidBlock(new BlockPos((int) this.posX + i, 0, (int) this.posZ + j)).getY(), (int) this.posZ + j), Blocks.FIRE.getDefaultState());
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (this.rand.nextInt(3) == 1)
					this.world.setBlockState(new BlockPos((int) this.posX - i, this.world.getTopSolidOrLiquidBlock(new BlockPos((int) this.posX + i, 0, (int) this.posZ + j)).getY(), (int) this.posZ - j), Blocks.FIRE.getDefaultState());
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (this.rand.nextInt(3) == 1)
					this.world.setBlockState(new BlockPos((int) this.posX + i, this.world.getTopSolidOrLiquidBlock(new BlockPos((int) this.posX + i, 0, (int) this.posZ + j)).getY(), (int) this.posZ - j), Blocks.FIRE.getDefaultState());
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (this.rand.nextInt(3) == 1)
					this.world.setBlockState(new BlockPos((int) this.posX - i, this.world.getTopSolidOrLiquidBlock(new BlockPos((int) this.posX + i, 0, (int) this.posZ + j)).getY(), (int) this.posZ + j), Blocks.FIRE.getDefaultState());
			}
		}
	}
}