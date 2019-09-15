package com.mjr.extraplanets.blocks;

import com.mjr.extraplanets.entities.EntityNuclearBombPrimed;
import com.mjr.mjrlegendslib.block.BlockBasicExplosion;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockNuclearBomb extends BlockBasicExplosion {

	public BlockNuclearBomb() {
		super();
	}

	@Override
	public void onBlockDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
		if (!world.isRemote) {
			EntityNuclearBombPrimed EntityNuclearBombPrimed = new EntityNuclearBombPrimed(world, pos.getX() + 0.5F, pos.getY(), pos.getZ() + 0.5F, explosion.getExplosivePlacedBy());
			EntityNuclearBombPrimed.setFuse(world.rand.nextInt(EntityNuclearBombPrimed.getFuse() / 4) + EntityNuclearBombPrimed.getFuse() / 8);
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