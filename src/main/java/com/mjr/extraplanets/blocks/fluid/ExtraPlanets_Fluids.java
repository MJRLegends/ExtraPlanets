package com.mjr.extraplanets.blocks.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.util.RegisterHelper;

public class ExtraPlanets_Fluids {
	public static Block GLOWSTONE;
	public static Fluid GLOWSTONE_FLUID;

	public static Block MAGMA;
	public static Fluid MAGMA_FLUID;

	public static Block NITROGEN;
	public static Fluid NITROGEN_FLUID;

	public static Block FROZEN_WATER;
	public static Fluid FROZEN_WATER_FLUID;

	public static Block SALT;
	public static Fluid SALT_FLUID;

	public static Block RADIO_ACTIVE_WATER;
	public static Fluid RADIO_ACTIVE_WATER_FLUID;

	public static Block CLEAN_WATER;
	public static Fluid CLEAN_WATER_FLUID;

	public static Block INFECTED_WATER;
	public static Fluid INFECTED_WATER_FLUID;

	public static Block METHANE;
	public static Fluid METHANE_FLUID;

	public static Block NITROGEN_ICE;
	public static Fluid NITROGEN_ICE_FLUID;

	public static Block LIQUID_HYDROCARBON;
	public static Fluid LIQUID_HYDROCARBON_FLUID;

	public static Material GLOWSTONE_MATERIAL = new MaterialLiquid(MapColor.YELLOW);
	public static Material MAGMA_MATERIAL = new MaterialLiquid(MapColor.NETHERRACK);
	public static Material NITROGEN_MATERIAL = new MaterialLiquid(MapColor.LIGHT_BLUE);
	public static Material FROZEN_WATER_MATERIAL = new MaterialLiquid(MapColor.DIAMOND);
	public static Material SALT_MATERIAL = new MaterialLiquid(MapColor.GRAY);
	public static Material METHANE_MATERIAL = new MaterialLiquid(MapColor.GRASS);

	public static void init() {
		initFluid();
		registerBlocks();
	}

	private static void initFluid() {
		GLOWSTONE_FLUID = new Fluid("glowstone_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/glowstone_still"), new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/glowstone_flow")).setBlock(GLOWSTONE)
				.setDensity(800).setViscosity(1500);
		FluidRegistry.registerFluid(GLOWSTONE_FLUID);
		GLOWSTONE = new FluidBlockEP(GLOWSTONE_FLUID, "glowstone", GLOWSTONE_MATERIAL).setLightLevel(1.0F);

		MAGMA_FLUID = new Fluid("magma_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/magma_still"), new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/magma_flow")).setBlock(MAGMA).setDensity(800)
				.setViscosity(1500);
		FluidRegistry.registerFluid(MAGMA_FLUID);
		MAGMA = new FluidBlockEP(MAGMA_FLUID, "magma", Material.LAVA);

		NITROGEN_FLUID = new Fluid("nitrogen_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/nitrogen_still"), new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/nitrogen_flow")).setBlock(NITROGEN).setDensity(800)
				.setViscosity(1500);
		FluidRegistry.registerFluid(NITROGEN_FLUID);
		NITROGEN = new FluidBlockEP(NITROGEN_FLUID, "nitrogen", NITROGEN_MATERIAL);

		FROZEN_WATER_FLUID = new Fluid("frozen_water_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/frozen_water_still"), new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/frozen_water_flow"))
				.setBlock(FROZEN_WATER).setDensity(800).setViscosity(1500);
		FluidRegistry.registerFluid(FROZEN_WATER_FLUID);
		FROZEN_WATER = new FluidBlockEP(FROZEN_WATER_FLUID, "frozen_water", FROZEN_WATER_MATERIAL);

		SALT_FLUID = new Fluid("salt_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/salt_still"), new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/salt_flow")).setBlock(SALT).setDensity(800).setViscosity(1500);
		FluidRegistry.registerFluid(SALT_FLUID);
		SALT = new FluidBlockEP(SALT_FLUID, "salt", SALT_MATERIAL);

		RADIO_ACTIVE_WATER_FLUID = new Fluid("radioactive_water_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/radioactive_water_still"), new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/radioactive_water_flow"))
				.setBlock(RADIO_ACTIVE_WATER).setDensity(800).setViscosity(1500);
		FluidRegistry.registerFluid(RADIO_ACTIVE_WATER_FLUID);
		RADIO_ACTIVE_WATER = new FluidBlockEP(RADIO_ACTIVE_WATER_FLUID, "radioactive_water", FROZEN_WATER_MATERIAL);

		CLEAN_WATER_FLUID = new Fluid("clean_water_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/clean_water_still"), new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/clean_water_flow")).setBlock(CLEAN_WATER)
				.setDensity(800).setViscosity(1500);
		FluidRegistry.registerFluid(CLEAN_WATER_FLUID);
		CLEAN_WATER = new FluidBlockEP(CLEAN_WATER_FLUID, "clean_water", FROZEN_WATER_MATERIAL);

		INFECTED_WATER_FLUID = new Fluid("infected_water_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/infected_water_still"), new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/infected_water_flow"))
				.setBlock(INFECTED_WATER).setDensity(800).setViscosity(1500);
		FluidRegistry.registerFluid(INFECTED_WATER_FLUID);
		INFECTED_WATER = new FluidBlockEP(INFECTED_WATER_FLUID, "infected_water", FROZEN_WATER_MATERIAL);

		METHANE_FLUID = new Fluid("methane_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/methane_still"), new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/methane_flow")).setBlock(METHANE).setDensity(800)
				.setViscosity(1500);
		FluidRegistry.registerFluid(METHANE_FLUID);
		METHANE = new FluidBlockEP(METHANE_FLUID, "methane", METHANE_MATERIAL);

		NITROGEN_ICE_FLUID = new Fluid("nitrogen_ice_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/nitrogen_ice_still"), new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/nitrogen_ice_flow"))
				.setBlock(NITROGEN_ICE).setDensity(800).setViscosity(1500);
		FluidRegistry.registerFluid(NITROGEN_ICE_FLUID);
		NITROGEN_ICE = new FluidBlockEP(NITROGEN_ICE_FLUID, "nitrogen_ice", NITROGEN_MATERIAL);

		LIQUID_HYDROCARBON_FLUID = new Fluid("liquid_hydrocarbon_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/liquid_hydrocarbon_still"), new ResourceLocation(Constants.TEXTURE_PREFIX
				+ "blocks/fluids/liquid_hydrocarbon_flow")).setBlock(LIQUID_HYDROCARBON).setDensity(800).setViscosity(1500);
		FluidRegistry.registerFluid(LIQUID_HYDROCARBON_FLUID);
		LIQUID_HYDROCARBON = new FluidBlockEP(LIQUID_HYDROCARBON_FLUID, "liquid_hydrocarbon", FROZEN_WATER_MATERIAL);
	}

	private static void registerBlocks() {
		RegisterHelper.registerBlock(GLOWSTONE, "glowstone");
		RegisterHelper.registerBlock(MAGMA, "magma");
		RegisterHelper.registerBlock(NITROGEN, "nitrogen");
		RegisterHelper.registerBlock(FROZEN_WATER, "frozen_water");
		RegisterHelper.registerBlock(SALT, "salt");
		RegisterHelper.registerBlock(RADIO_ACTIVE_WATER, "radioactive_water");
		RegisterHelper.registerBlock(CLEAN_WATER, "clean_water");
		RegisterHelper.registerBlock(INFECTED_WATER, "infected_water");
		RegisterHelper.registerBlock(METHANE, "methane");
		RegisterHelper.registerBlock(NITROGEN_ICE, "nitrogen_ice");
		RegisterHelper.registerBlock(LIQUID_HYDROCARBON, "liquid_hydrocarbon");
	}
}
