package com.mjr.extraplanets.blocks.fluid;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class FluidBasic extends BlockFluidClassic {
    @SideOnly(Side.CLIENT)
    IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    IIcon flowingIcon;
    Fluid fluid;

    public FluidBasic(Fluid fluid) {
	super(fluid, Material.water);
	this.fluid = fluid;
    }

    public FluidBasic(Fluid fluid, Material material) {
	super(fluid, material);
	this.fluid = fluid;
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
	if (world.getBlock(x, y, z).getMaterial().isLiquid()) {
	    return false;
	}
	if (world.getBlock(x, y, z).getMaterial() == Material.water) {
	    return false;
	}
	return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
	if (world.getBlock(x, y, z).getMaterial().isLiquid()) {
	    return false;
	}
	if (world.getBlock(x, y, z).getMaterial() == Material.water) {
	    return false;
	}
	return super.displaceIfPossible(world, x, y, z);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
	this.stillIcon = iconRegister.registerIcon(getStillTextures());
	this.flowingIcon = iconRegister.registerIcon(getFlowingTextures());
	this.fluid.setFlowingIcon(this.flowingIcon);
	this.fluid.setStillIcon(this.stillIcon);
    }

    @SideOnly(Side.CLIENT)
    public IIcon func_149691_a(int par1, int par2) {
	return (par1 != 0) && (par1 != 1) ? this.flowingIcon : this.stillIcon;
    }

    public abstract String getStillTextures();

    public abstract String getFlowingTextures();
}
