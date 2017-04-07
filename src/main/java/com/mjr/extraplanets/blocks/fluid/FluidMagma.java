package com.mjr.extraplanets.blocks.fluid;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import com.mjr.extraplanets.Constants;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FluidMagma extends FluidBasic {
	public FluidMagma(String name) {
		super(ExtraPlanets_Fluids.magma_fluid, Material.lava);
		setRenderPass(1);
		setBlockName(name);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if ((entity instanceof EntityLivingBase)) {
			if (world.getTotalWorldTime() % 8 == 0 && entity instanceof EntityLivingBase && !((EntityLivingBase) entity).isEntityUndead()) {
				((EntityLivingBase) entity).attackEntityFrom(DamageSource.lava, 4.0F);
				((EntityLivingBase) entity).setFire(15);
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		super.randomDisplayTick(world, x, y, z, rand);
		int meta = world.getBlockMetadata(x, y, z);
		if (rand.nextInt(64) == 0) {
			if ((meta > 0) && (meta < 8)) {
				world.playSound(x + 0.5F, y + 0.5F, z + 0.5F, "liquid.lava", rand.nextFloat() * 0.25F + 0.75F, rand.nextFloat() * 1.0F + 0.5F, false);
			}
		}
		if (rand.nextInt(10) == 0) {
			if ((meta <= 0) || (meta >= 8)) {
				world.spawnParticle("suspended", x + rand.nextFloat(), y + rand.nextFloat(), z + rand.nextFloat(), 0.0D, 0.0D, 0.0D);
			}
		}
		if ((rand.nextInt(10) == 0) && (World.doesBlockHaveSolidTopSurface(world, x, y - 1, z)) && (!world.getBlock(x, y - 2, z).getMaterial().blocksMovement())) {
			double d5 = x + rand.nextFloat();
			double d6 = y - 1.05D;
			double d7 = z + rand.nextFloat();
			world.spawnParticle("dripWater", d5, d6, d7, 0.0D, 0.0D, 0.0D);
		}
	}

	@Override
	public String getStillTextures() {
		return Constants.TEXTURE_PREFIX + "magma_still";
	}

	@Override
	public String getFlowingTextures() {
		return Constants.TEXTURE_PREFIX + "magma_flow";
	}
}
