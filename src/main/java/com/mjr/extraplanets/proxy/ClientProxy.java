package com.mjr.extraplanets.proxy;

import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.client.handlers.SkyProviderHandler;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		addExtraPlanetsVariants("mercury", "mercury_surface", "mercury_sub_surface", "mercury_stone", "mercury_ore_iron", "mercury_ore_tin", "mercury_ore_copper", "mercury_ore_mercury", "mercury_mercury_block", "mercury_stonebricks");
		addExtraPlanetsVariants("venus", "venus_surface", "venus_sub_surface", "venus_stone", "venus_ore_iron", "venus_ore_tin", "venus_ore_copper", "venus_ore_carbon", "venus_carbon_block", "venus_stonebricks", "venus_dungeon_brick");
		addExtraPlanetsVariants("ceres", "ceres_surface", "ceres_sub_surface", "ceres_stone", "ceres_ore_iron", "ceres_ore_tin", "ceres_ore_copper", "ceres_ore_uranium", "ceres_uranium_block", "ceres_stonebricks");
		addExtraPlanetsVariants("jupiter", "jupiter_surface", "jupiter_sub_surface", "jupiter_stone", "jupiter_ore_iron", "jupiter_ore_tin", "jupiter_ore_copper", "jupiter_ore_red_gem", "jupiter_red_gem_block", "jupiter_stonebricks", "jupiter_dungeon_brick", "jupiter_ore_red_gem", "jupiter_red_gem_block");
		addExtraPlanetsVariants("uranus", "uranus_surface", "uranus_sub_surface", "uranus_stone", "uranus_ore_iron", "uranus_ore_tin", "uranus_ore_copper", "uranus_ore_white_gem", "uranus_white_gem_block", "uranus_stonebricks", "uranus_dungeon_brick", "uranus_ore_red_gem", "uranus_red_gem_block");
		addExtraPlanetsVariants("neptune", "neptune_surface", "neptune_sub_surface", "neptune_stone", "neptune_ore_iron", "neptune_ore_tin", "neptune_ore_copper", "neptune_ore_blue_gem", "neptune_blue_gem_block", "neptune_stonebricks", "neptune_dungeon_brick", "neptune_ore_red_gem", "neptune_red_gem_block");
		addExtraPlanetsVariants("saturn", "saturn_surface", "saturn_sub_surface", "saturn_stone", "saturn_ore_iron", "saturn_ore_tin", "saturn_ore_copper", "saturn_ore_magnesium", "saturn_magnesium_block", "saturn_stonebricks", "saturn_dungeon_brick");
		addExtraPlanetsVariants("pluto", "pluto_surface", "pluto_sub_surface", "pluto_stone", "pluto_ore_iron", "pluto_ore_tin", "pluto_ore_copper", "pluto_ore_tungsten", "pluto_tungsten_block", "pluto_stonebricks", "pluto_dungeon_brick");
		addExtraPlanetsVariants("eris", "eris_surface", "eris_sub_surface", "eris_stone", "eris_ore_iron", "eris_ore_tin", "eris_ore_copper", "eris_ore_dark_iron", "eris_dark_iron_block", "eris_stonebricks", "eris_dungeon_brick");
		
		addExtraPlanetsVariants("callisto", "callisto_surface", "callisto_sub_surface", "callisto_stone", "callisto_ore_iron", "callisto_ore_tin", "callisto_ore_copper");
		addExtraPlanetsVariants("deimos", "deimos_surface", "deimos_sub_surface", "deimos_stone", "deimos_ore_iron", "deimos_ore_tin", "deimos_ore_copper");
		addExtraPlanetsVariants("europa", "europa_surface", "europa_sub_surface", "europa_stone", "europa_ore_iron", "europa_ore_tin", "europa_ore_copper");
		addExtraPlanetsVariants("ganymede", "ganymede_surface", "ganymede_sub_surface", "ganymede_stone", "ganymede_ore_iron", "ganymede_ore_tin", "ganymede_ore_copper");
		addExtraPlanetsVariants("io", "io_surface", "io_sub_surface", "io_stone", "io_ore_iron", "io_ore_tin", "io_ore_copper");
		addExtraPlanetsVariants("phobos", "phobos_surface", "phobos_sub_surface", "phobos_stone", "phobos_ore_iron", "phobos_ore_tin", "phobos_ore_copper");
		addExtraPlanetsVariants("rhea", "rhea_surface", "rhea_sub_surface", "rhea_stone", "rhea_ore_iron", "rhea_ore_tin", "rhea_ore_copper");
		addExtraPlanetsVariants("titan", "titan_surface", "titan_sub_surface", "titan_stone", "titan_ore_iron", "titan_ore_tin", "titan_ore_copper");
		addExtraPlanetsVariants("triton", "triton_surface", "triton_sub_surface", "triton_stone", "triton_ore_iron", "triton_ore_tin", "triton_ore_copper");
        MinecraftForge.EVENT_BUS.register(this);
        registerVariants();
		super.preInit(event);
	}

	private void addExtraPlanetsVariants(String name, String... variants) {
		Item itemBlockVariants = GameRegistry.findItem(Constants.modID, name);
		ResourceLocation[] variants0 = new ResourceLocation[variants.length];
		for (int i = 0; i < variants.length; ++i) {
			variants0[i] = new ResourceLocation(Constants.TEXTURE_PREFIX + variants[i]);
		}
		ModelBakery.registerItemVariants(itemBlockVariants, variants0);
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		SkyProviderHandler clientEventHandler = new SkyProviderHandler();
		MinecraftForge.EVENT_BUS.register(clientEventHandler);
		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
	
	public void registerVariants() {
		ModelResourceLocation modelResourceLocation = new ModelResourceLocation("galacticraftplanets:rocket_t3", "inventory");
		for (int i = 0; i < 5; ++i) {
			ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.tier4Rocket, i, modelResourceLocation);
		}
		for (int i = 0; i < 5; ++i) {
			ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.tier5Rocket, i, modelResourceLocation);
		}
		for (int i = 0; i < 5; ++i) {
			ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.tier6Rocket, i, modelResourceLocation);
		}
		for (int i = 0; i < 5; ++i) {
			ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.tier7Rocket, i, modelResourceLocation);
		}
		for (int i = 0; i < 5; ++i) {
			ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.tier8Rocket, i, modelResourceLocation);
		}
		for (int i = 0; i < 5; ++i) {
			ModelLoader.setCustomModelResourceLocation(ExtraPlanets_Items.tier9Rocket, i, modelResourceLocation);
		}
	}
}
