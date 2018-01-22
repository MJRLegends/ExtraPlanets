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
	public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
		if (!worldIn.isRemote) {
			EntityNuclearBombPrimed EntityNuclearBombPrimed = new EntityNuclearBombPrimed(worldIn, pos.getX() + 0.5F, pos.getY(), pos.getZ() + 0.5F, explosionIn.getExplosivePlacedBy());
			EntityNuclearBombPrimed.fuse = worldIn.rand.nextInt(EntityNuclearBombPrimed.fuse / 4) + EntityNuclearBombPrimed.fuse / 8;
			worldIn.spawnEntityInWorld(EntityNuclearBombPrimed);
		}
	}

	public void explode(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase igniter) {
		if (!worldIn.isRemote) {
			if (state.getValue(EXPLODE).booleanValue()) {
				EntityNuclearBombPrimed EntityNuclearBombPrimed = new EntityNuclearBombPrimed(worldIn, pos.getX() + 0.5F, pos.getY(), pos.getZ() + 0.5F, igniter);
				worldIn.spawnEntityInWorld(EntityNuclearBombPrimed);
				worldIn.playSoundAtEntity(EntityNuclearBombPrimed, "game.tnt.primed", 1.0F, 1.0F);
			}
		}
	}
}