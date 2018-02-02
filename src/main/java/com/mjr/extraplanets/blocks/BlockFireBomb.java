package com.mjr.extraplanets.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import com.mjr.extraplanets.entities.EntityFireBombPrimed;
import com.mjr.mjrlegendslib.block.BlockBasicExplosion;

public class BlockFireBomb extends BlockBasicExplosion {

	public BlockFireBomb() {
		super();
	}

	@Override
	public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
		if (!worldIn.isRemote) {
			EntityFireBombPrimed EntityFireBombPrimed = new EntityFireBombPrimed(worldIn, pos.getX() + 0.5F, pos.getY(), pos.getZ() + 0.5F, explosionIn.getExplosivePlacedBy());
			EntityFireBombPrimed.fuse = worldIn.rand.nextInt(EntityFireBombPrimed.fuse / 4) + EntityFireBombPrimed.fuse / 8;
			worldIn.spawnEntityInWorld(EntityFireBombPrimed);
		}
	}

	@Override
	public void explode(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase igniter) {
		if (!worldIn.isRemote) {
			if (state.getValue(EXPLODE).booleanValue()) {
				EntityFireBombPrimed EntityFireBombPrimed = new EntityFireBombPrimed(worldIn, pos.getX() + 0.5F, pos.getY(), pos.getZ() + 0.5F, igniter);
				worldIn.spawnEntityInWorld(EntityFireBombPrimed);
				worldIn.playSound((EntityPlayer) null, EntityFireBombPrimed.posX, EntityFireBombPrimed.posY, EntityFireBombPrimed.posZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
			}
		}
	}
}