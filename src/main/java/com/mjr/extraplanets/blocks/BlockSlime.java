package com.mjr.extraplanets.blocks;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSlime extends BlockBreakable {
	private boolean bounce = false;
	private double howHigh = 0.8;

	public BlockSlime(String name) {
		super(Constants.TEXTURE_PREFIX + name, Material.ice, false);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
		this.slipperiness = 0.8F;
		this.setBlockName(name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		return this.blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world_, int x, int y, int z) {
		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1 - 0.0625F, z + 1);
	}

	@Override
	public void onFallenUpon(World world, int X, int Y, int Z, Entity entity, float entityFallDistance) {
		if (entity.isSneaking()) {
			super.onFallenUpon(world, X, Y, Z, entity, entityFallDistance);
		} else {
			entity.fallDistance = 0.0F;
			bounce = true;
			howHigh = -entity.motionY;
		}
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int X, int Y, int Z, Entity entity) {
		if (!entity.isSneaking()) {
			if (bounce) {
				entity.motionY = howHigh;
				bounce = false;
			} else if (Math.abs(entity.motionY) < 0.1D) {
				double d0 = 0.4D + Math.abs(entity.motionY) * 0.2D;
				entity.motionX *= d0;
				entity.motionZ *= d0;
			}
		}
		super.onEntityCollidedWithBlock(world, X, Y, Z, entity);
	}

	/**
	 * Triggered whenever an entity collides with this block (enters into the block)
	 */
	@Override
	public void onEntityWalking(World worldIn, int x, int y, int z, Entity entityIn) {
		if (Math.abs(entityIn.motionY) < 0.1D && !entityIn.isSneaking()) {
			double d0 = 0.4D + Math.abs(entityIn.motionY) * 0.2D;
			entityIn.motionX *= d0;
			entityIn.motionZ *= d0;
		}

		super.onEntityWalking(worldIn, x, y, z, entityIn);
	}
}