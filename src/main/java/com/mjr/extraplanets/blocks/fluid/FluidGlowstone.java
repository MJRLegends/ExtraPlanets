package com.mjr.extraplanets.blocks.fluid;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.mjr.extraplanets.Constants;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FluidGlowstone extends FluidBasic {
	public FluidGlowstone(String name) {
		super(ExtraPlanets_Fluids.glowstone_fluid);
		setRenderPass(1);
		setBlockName(name);
		setLightLevel(1.0F);
	}

	public void func_149670_a(World world, int x, int y, int z, Entity entity) {
		if ((entity instanceof EntityLivingBase)) {
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 50, 1));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		super.randomDisplayTick(world, x, y, z, rand);
		int meta = world.getBlockMetadata(x, y, z);
		if (rand.nextInt(64) == 0) {
			if ((meta > 0) && (meta < 8)) {
				world.playSound(x + 0.5F, y + 0.5F, z + 0.5F, "liquid.water", rand.nextFloat() * 0.25F + 0.75F, rand.nextFloat() * 1.0F + 0.5F, false);
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
		return Constants.TEXTURE_PREFIX + "/fluids/" + "glowstone_still";
	}

	@Override
	public String getFlowingTextures() {
		return Constants.TEXTURE_PREFIX + "/fluids/" + "glowstone_flow";
	}
}
