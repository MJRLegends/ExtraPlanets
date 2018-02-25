package com.mjr.extraplanets.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import com.mjr.extraplanets.entities.EntityFireBombPrimed;
import com.mjr.mjrlegendslib.block.BlockBasicExplosion;

public class BlockFireBomb extends BlockBasicExplosion {

	public BlockFireBomb() {
		super();
	}

	@Override
	public void onBlockDestroyedByExplosion(World world, BlockPos pos, Explosion explosionIn) {
		if (!world.isRemote) {
			EntityFireBombPrimed EntityFireBombPrimed = new EntityFireBombPrimed(world, pos.getX() + 0.5F, pos.getY(), pos.getZ() + 0.5F, explosionIn.getExplosivePlacedBy());
			EntityFireBombPrimed.fuse = world.rand.nextInt(EntityFireBombPrimed.fuse / 4) + EntityFireBombPrimed.fuse / 8;
			world.spawnEntityInWorld(EntityFireBombPrimed);
		}
	}

	@Override
	public void explode(World world, BlockPos pos, IBlockState state, EntityLivingBase igniter) {
		if (!world.isRemote) {
			if (state.getValue(EXPLODE).booleanValue()) {
				EntityFireBombPrimed EntityFireBombPrimed = new EntityFireBombPrimed(world, pos.getX() + 0.5F, pos.getY(), pos.getZ() + 0.5F, igniter);
				world.spawnEntityInWorld(EntityFireBombPrimed);
				world.playSoundAtEntity(EntityFireBombPrimed, "game.tnt.primed", 1.0F, 1.0F);
			}
		}
	}
}