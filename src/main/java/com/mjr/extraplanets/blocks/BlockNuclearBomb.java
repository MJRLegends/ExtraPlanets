package com.mjr.extraplanets.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import com.mjr.extraplanets.entities.EntityNuclearBombPrimed;
import com.mjr.mjrlegendslib.block.BlockBasicExplosion;

public class BlockNuclearBomb extends BlockBasicExplosion {

	public BlockNuclearBomb() {
		super();
	}

	@Override
	public void onBlockDestroyedByExplosion(World world, BlockPos pos, Explosion explosionIn) {
		if (!world.isRemote) {
			EntityNuclearBombPrimed EntityNuclearBombPrimed = new EntityNuclearBombPrimed(world, pos.getX() + 0.5F, pos.getY(), pos.getZ() + 0.5F, explosionIn.getExplosivePlacedBy());
			EntityNuclearBombPrimed.fuse = world.rand.nextInt(EntityNuclearBombPrimed.fuse / 4) + EntityNuclearBombPrimed.fuse / 8;
			world.spawnEntityInWorld(EntityNuclearBombPrimed);
		}
	}

	@Override
	public void explode(World world, BlockPos pos, IBlockState state, EntityLivingBase igniter) {
		if (!world.isRemote) {
			if (state.getValue(EXPLODE).booleanValue()) {
				EntityNuclearBombPrimed EntityNuclearBombPrimed = new EntityNuclearBombPrimed(world, pos.getX() + 0.5F, pos.getY(), pos.getZ() + 0.5F, igniter);
				world.spawnEntityInWorld(EntityNuclearBombPrimed);
				world.playSoundAtEntity(EntityNuclearBombPrimed, "game.tnt.primed", 1.0F, 1.0F);
			}
		}
	}
}