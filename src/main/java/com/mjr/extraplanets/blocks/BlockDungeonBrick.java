package com.mjr.extraplanets.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import com.mjr.extraplanets.ExtraPlanets;

public class BlockDungeonBrick extends Block{

	protected BlockDungeonBrick(Material material) {
		super(material);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
	}

	@Override
	 public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion)
	{
		return 40.0F;
	}

	@Override
	public float getBlockHardness(World par1World, BlockPos pos)
	{
		return 4.0F;
	}
}
