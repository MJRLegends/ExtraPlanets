package com.mjr.extraplanets.blocks;

import com.mjr.extraplanets.entities.EntityFireBombPrimed;
import com.mjr.mjrlegendslib.block.BlockBasicExplosion;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockFireBomb extends BlockBasicExplosion {

	public BlockFireBomb() {
		super();
	}

	@Override
	public void onBlockDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
		if (!world.isRemote) {
			EntityFireBombPrimed EntityFireBombPrimed = new EntityFireBombPrimed(world, pos.getX() + 0.5F, pos.getY(), pos.getZ() + 0.5F, explosion.getExplosivePlacedBy());
			EntityFireBombPrimed.setFuse(world.rand.nextInt(EntityFireBombPrimed.getFuse() / 4) + EntityFireBombPrimed.getFuse() / 8);
			world.spawnEntityInWorld(EntityFireBombPrimed);
		}
	}

	@Override
	public void explode(World world, BlockPos pos, IBlockState state, EntityLivingBase igniter) {
		if (!world.isRemote) {
			if (state.getValue(EXPLODE).booleanValue()) {
				EntityFireBombPrimed EntityFireBombPrimed = new EntityFireBombPrimed(world, pos.getX() + 0.5F, pos.getY(), pos.getZ() + 0.5F, igniter);
				world.spawnEntityInWorld(EntityFireBombPrimed);
				world.playSound((EntityPlayer) null, EntityFireBombPrimed.posX, EntityFireBombPrimed.posY, EntityFireBombPrimed.posZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
			}
		}
	}
}