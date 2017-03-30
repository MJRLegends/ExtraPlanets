package com.mjr.extraplanets.blocks.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.mjr.extraplanets.Constants;

public class ExtraPlanets_Fluids {
	public static Block glowstone;
	public static Fluid glowstone_fluid;

	public static Block magma;
	public static Fluid magma_fluid;

	public static Block nitrogen;
	public static Fluid nitrogen_fluid;

	public static Block frozen_water;
	public static Fluid frozen_water_fluid;

	public static Block salt;
	public static Fluid salt_fluid;

	public static Block radioactiveWater;
	public static Fluid radioactiveWater_fluid;

	public static Block cleanWater;
	public static Fluid cleanWater_fluid;

	public static Block infectedWater;
	public static Fluid infectedWater_fluid;

	public static Block methane;
	public static Fluid methane_fluid;

	public static Block nitrogen_ice;
	public static Fluid nitrogen_ice_fluid;

	public static Material glowstone_material = new MaterialLiquid(MapColor.YELLOW);
	public static Material magma_material = new MaterialLiquid(MapColor.NETHERRACK);
	public static Material nitrogen_material = new MaterialLiquid(MapColor.LIGHT_BLUE);
	public static Material frozen_water_material = new MaterialLiquid(MapColor.DIAMOND);
	public static Material salt_material = new MaterialLiquid(MapColor.GRAY);
	public static Material methane_material = new MaterialLiquid(MapColor.GRASS);

	public static void init() {
		initFluid();
		registerBlocks();
	}

	private static void initFluid() {
		glowstone_fluid = new Fluid("glowstone_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/glowstone_still"), new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/glowstone_flow")).setBlock(glowstone)
				.setDensity(800).setViscosity(1500);
		FluidRegistry.registerFluid(glowstone_fluid);
		glowstone = new FluidBlockEP(glowstone_fluid, "glowstone", glowstone_material);

		magma_fluid = new Fluid("magma_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/magma_still"), new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/magma_flow")).setBlock(magma).setDensity(800)
				.setViscosity(1500);
		FluidRegistry.registerFluid(magma_fluid);
		magma = new FluidBlockEP(magma_fluid, "magma", Material.LAVA);

		nitrogen_fluid = new Fluid("nitrogen_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/nitrogen_still"), new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/nitrogen_flow")).setBlock(nitrogen).setDensity(800)
				.setViscosity(1500);
		FluidRegistry.registerFluid(nitrogen_fluid);
		nitrogen = new FluidBlockEP(nitrogen_fluid, "nitrogen", nitrogen_material);

		frozen_water_fluid = new Fluid("frozen_water_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/frozen_water_still"), new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/frozen_water_flow"))
				.setBlock(frozen_water).setDensity(800).setViscosity(1500);
		FluidRegistry.registerFluid(frozen_water_fluid);
		frozen_water = new FluidBlockEP(frozen_water_fluid, "frozen_water", frozen_water_material);

		salt_fluid = new Fluid("salt_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/salt_still"), new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/salt_flow")).setBlock(salt).setDensity(800).setViscosity(1500);
		FluidRegistry.registerFluid(salt_fluid);
		salt = new FluidBlockEP(salt_fluid, "salt", salt_material);

		radioactiveWater_fluid = new Fluid("radioactive_water_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/radioactive_water_still"), new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/radioactive_water_flow"))
				.setBlock(radioactiveWater).setDensity(800).setViscosity(1500);
		FluidRegistry.registerFluid(radioactiveWater_fluid);
		radioactiveWater = new FluidBlockEP(radioactiveWater_fluid, "radioactive_water", frozen_water_material);

		cleanWater_fluid = new Fluid("clean_water_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/clean_water_still"), new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/clean_water_flow")).setBlock(cleanWater)
				.setDensity(800).setViscosity(1500);
		FluidRegistry.registerFluid(cleanWater_fluid);
		cleanWater = new FluidBlockEP(cleanWater_fluid, "clean_water", frozen_water_material);

		infectedWater_fluid = new Fluid("infected_water_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/infected_water_still"), new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/infected_water_flow"))
				.setBlock(infectedWater).setDensity(800).setViscosity(1500);
		FluidRegistry.registerFluid(infectedWater_fluid);
		infectedWater = new FluidBlockEP(infectedWater_fluid, "infected_water", frozen_water_material);

		methane_fluid = new Fluid("methane_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/methane_still"), new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/methane_flow")).setBlock(methane).setDensity(800)
				.setViscosity(1500);
		FluidRegistry.registerFluid(methane_fluid);
		methane = new FluidBlockEP(methane_fluid, "methane", methane_material);

		nitrogen_ice_fluid = new Fluid("nitrogen_ice_fluid", new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/nitrogen_ice_still"), new ResourceLocation(Constants.TEXTURE_PREFIX + "blocks/fluids/nitrogen_ice_flow"))
				.setBlock(nitrogen_ice).setDensity(800).setViscosity(1500);
		FluidRegistry.registerFluid(nitrogen_ice_fluid);
		nitrogen_ice = new FluidBlockEP(nitrogen_ice_fluid, "nitrogen_ice", nitrogen_material);
	}

	private static void registerBlocks() {
		GameRegistry.registerBlock(glowstone, "glowstone");
		GameRegistry.registerBlock(magma, "magma");
		GameRegistry.registerBlock(nitrogen, "nitrogen");
		GameRegistry.registerBlock(frozen_water, "frozen_water");
		GameRegistry.registerBlock(salt, "salt");
		GameRegistry.registerBlock(radioactiveWater, "radioactive_water");
		GameRegistry.registerBlock(cleanWater, "clean_water");
		GameRegistry.registerBlock(infectedWater, "infected_water");
		GameRegistry.registerBlock(methane, "methane");
		GameRegistry.registerBlock(nitrogen_ice, "nitrogen_ice");
	}
}
