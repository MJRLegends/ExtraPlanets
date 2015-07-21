package com.mjr.extraplanets.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import com.mjr.extraplanets.ExtraPlanets;

public class BlockDungeonBrick extends Block{

    protected BlockDungeonBrick(Material material) {
	super(material);
	this.setCreativeTab(ExtraPlanets.BlocksTab);
    }

    @Override
    public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
    {
	return 40.0F;
    }

    @Override
    public float getBlockHardness(World par1World, int par2, int par3, int par4)
    {
	return 4.0F;
    }
}
