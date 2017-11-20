package com.mjr.extraplanets.blocks.fluid;

import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

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
	
	public static Block radio_active_water;
	public static Fluid radio_active_water_fluid;
	
	public static Block infected_water;
	public static Fluid infected_water_fluid;
	
	public static Block methane;
	public static Fluid methane_fluid;
	
	public static Block nitrogen_ice;
	public static Fluid nitrogen_ice_fluid;
	
	public static Block liquid_chocolate;
	public static Fluid liquid_chocolate_fluid;

	public static Block liquid_caramel;
	public static Fluid liquid_caramel_fluid;
	
	public static void init() {
		initFluid();
		registerBlocks();
	}

	private static void initFluid() {
		glowstone_fluid = new Fluid("glowstone_fluid").setBlock(glowstone);
		FluidRegistry.registerFluid(glowstone_fluid);
		glowstone = new FluidGlowstone("glowstone_fluid");

		magma_fluid = new Fluid("magma_fluid").setBlock(magma);
		FluidRegistry.registerFluid(magma_fluid);
		magma = new FluidMagma("magma_fluid");

		nitrogen_fluid = new Fluid("nitrogen_fluid").setBlock(nitrogen);
		FluidRegistry.registerFluid(nitrogen_fluid);
		nitrogen = new FluidNitrogen("nitrogen_fluid");

		frozen_water_fluid = new Fluid("frozen_water_fluid").setBlock(frozen_water);
		FluidRegistry.registerFluid(frozen_water_fluid);
		frozen_water = new FluidFrozenWater("frozen_water_fluid");

		salt_fluid = new Fluid("salt_fluid").setBlock(salt);
		FluidRegistry.registerFluid(salt_fluid);
		salt = new FluidSalt("salt");

		radio_active_water_fluid = new Fluid("radioactive_water_fluid").setBlock(radio_active_water);
		FluidRegistry.registerFluid(radio_active_water_fluid);
		radio_active_water = new FluidRadioActiveWater("radioactive_water_fluid");

		infected_water_fluid = new Fluid("infected_water_fluid").setBlock(infected_water);
		FluidRegistry.registerFluid(infected_water_fluid);
		infected_water = new FluidInfectedWater("infected_water_fluid");

		methane_fluid = new Fluid("methane_fluid").setBlock(methane);
		FluidRegistry.registerFluid(methane_fluid);
		methane = new FluidMethane("methane_fluid");

		nitrogen_ice_fluid = new Fluid("nitrogen_ice_fluid").setBlock(nitrogen_ice);
		FluidRegistry.registerFluid(nitrogen_ice_fluid);
		nitrogen_ice = new FluidNitrogenIce("nitrogen_ice_fluid");

		liquid_chocolate_fluid = new Fluid("liquid_choclate_fluid").setBlock(liquid_chocolate);
		FluidRegistry.registerFluid(liquid_chocolate_fluid);
		liquid_chocolate = new FluidLiquidChocolate("liquid_chocolate_fluid");

		liquid_caramel_fluid = new Fluid("liquid_caramel_fluid").setBlock(liquid_caramel);
		FluidRegistry.registerFluid(liquid_caramel_fluid);
		liquid_caramel = new FluidLiquidCaramel("liquid_caramel_fluid");
	}

	private static void registerBlocks() {
		GameRegistry.registerBlock(glowstone, "glowstone");
		GameRegistry.registerBlock(magma, "magma");
		GameRegistry.registerBlock(nitrogen, "nitrogen");
		GameRegistry.registerBlock(frozen_water, "frozen_water");
		GameRegistry.registerBlock(radio_active_water, "radio_active_water");
		GameRegistry.registerBlock(infected_water, "infected_water");
		GameRegistry.registerBlock(methane, "methane");
		GameRegistry.registerBlock(nitrogen_ice, "nitrogen_ice");
		GameRegistry.registerBlock(liquid_chocolate, "liquid_chocolate");
	}
}
