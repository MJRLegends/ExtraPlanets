package com.mjr.extraplanets.blocks.fluid;

import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ExtraPlanetsFluids {
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
	salt = new FluidSalt("salt_fluid");
    }

    private static void registerBlocks() {
	GameRegistry.registerBlock(glowstone, "glowstone");
	GameRegistry.registerBlock(magma, "magma");
	GameRegistry.registerBlock(nitrogen, "nitrogen");
	GameRegistry.registerBlock(frozen_water, "frozen_water");
	GameRegistry.registerBlock(salt, "salt");
    }
}
