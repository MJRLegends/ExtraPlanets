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
