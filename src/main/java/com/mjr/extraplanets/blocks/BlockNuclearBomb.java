package com.mjr.extraplanets.blocks;

import com.mjr.extraplanets.entities.EntityNuclearBombPrimed;
import com.mjr.mjrlegendslib.block.BlockBasicExplosion;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
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
			EntityNuclearBombPrimed.fuse = world.rand.nextInt(EntityNuclearBombPrimed.fuse / 4) + EntityNuclearBombPrimed.fuse / 8;
			world.spawnEntity(EntityNuclearBombPrimed);
		}
	}

	@Override
	public void explode(World world, BlockPos pos, IBlockState state, EntityLivingBase igniter) {
		if (!world.isRemote) {
			if (state.getValue(EXPLODE).booleanValue()) {
				EntityNuclearBombPrimed EntityNuclearBombPrimed = new EntityNuclearBombPrimed(world, pos.getX() + 0.5F, pos.getY(), pos.getZ() + 0.5F, igniter);
				world.spawnEntity(EntityNuclearBombPrimed);
				world.playSound((EntityPlayer) null, EntityNuclearBombPrimed.posX, EntityNuclearBombPrimed.posY, EntityNuclearBombPrimed.posZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
			}
		}
	}
}