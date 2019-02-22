package com.mjr.extraplanets.blocks;

import com.mjr.extraplanets.ExtraPlanets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockDungeonBrick extends Block {

	protected BlockDungeonBrick(Material material) {
		super(material);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
	}

	@Override
	public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion) {
		return 40.0F;
	}

	@Override
	public float getBlockHardness(IBlockState state, World world, BlockPos pos) {
		return 4.0F;
	}
}
