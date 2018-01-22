package com.mjr.extraplanets;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.tile.TileEntityDeconstructor;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.machines.ExtraPlanets_Machines;
import com.mjr.extraplanets.client.gui.GuiHandler;
import com.mjr.extraplanets.client.handlers.capabilities.CapabilityStatsClientHandler;
import com.mjr.extraplanets.compatibility.ExtremeReactorsCompatibility;
import com.mjr.extraplanets.compatibility.MCMultiPartCompatibility;
import com.mjr.extraplanets.entities.EntityFireBombPrimed;
import com.mjr.extraplanets.entities.EntityNuclearBombPrimed;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedFireBatBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedGhastBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedGiantZombieBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedIceSlimeBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedMagmaCubeBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedSnowmanBoss;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossEris;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossJupiter;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossMercury;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossNeptune;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossPluto;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossSaturn;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossUranus;
import com.mjr.extraplanets.entities.landers.EntityGeneralLander;
import com.mjr.extraplanets.entities.landers.EntityJupiterLander;
import com.mjr.extraplanets.entities.landers.EntityMercuryLander;
import com.mjr.extraplanets.entities.landers.EntityNeptuneLander;
import com.mjr.extraplanets.entities.landers.EntitySaturnLander;
import com.mjr.extraplanets.entities.landers.EntityUranusLander;
import com.mjr.extraplanets.entities.rockets.EntityElectricRocket;
import com.mjr.extraplanets.entities.rockets.EntityTier10Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier4Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier5Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier6Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier7Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier8Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier9Rocket;
import com.mjr.extraplanets.entities.vehicles.EntityMarsRover;
import com.mjr.extraplanets.entities.vehicles.EntityVenusRover;
import com.mjr.extraplanets.handlers.BoneMealHandler;
import com.mjr.extraplanets.handlers.GalacticraftVersionChecker;
import com.mjr.extraplanets.handlers.MainHandlerServer;
import com.mjr.extraplanets.handlers.capabilities.CapabilityStatsHandler;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.items.armor.ExtraPlanets_Armor;
import com.mjr.extraplanets.items.schematics.SchematicTier10;
import com.mjr.extraplanets.items.schematics.SchematicTier4;
import com.mjr.extraplanets.items.schematics.SchematicTier5;
import com.mjr.extraplanets.items.schematics.SchematicTier6;
import com.mjr.extraplanets.items.schematics.SchematicTier7;
import com.mjr.extraplanets.items.schematics.SchematicTier8;
import com.mjr.extraplanets.items.schematics.SchematicTier9;
import com.mjr.extraplanets.items.tools.ExtraPlanets_Tools;
import com.mjr.extraplanets.moons.ExtraPlanets_Moons;
import com.mjr.extraplanets.moons.Callisto.event.CallistoEvents;
import com.mjr.extraplanets.moons.Callisto.worldgen.CallistoBiomes;
import com.mjr.extraplanets.moons.Deimos.event.DeimosEvents;
import com.mjr.extraplanets.moons.Deimos.worldgen.DeimosBiomes;
import com.mjr.extraplanets.moons.Europa.event.EuropaEvents;
import com.mjr.extraplanets.moons.Europa.worldgen.EuropaBiomes;
import com.mjr.extraplanets.moons.Ganymede.event.GanymedeEvents;
import com.mjr.extraplanets.moons.Ganymede.worldgen.GanymedeBiomes;
import com.mjr.extraplanets.moons.Iapetus.event.IapetusEvents;
import com.mjr.extraplanets.moons.Iapetus.worldgen.IapetusBiomes;
import com.mjr.extraplanets.moons.Io.event.IoEvents;
import com.mjr.extraplanets.moons.Io.worldgen.IoBiomes;
import com.mjr.extraplanets.moons.Oberon.event.OberonEvents;
import com.mjr.extraplanets.moons.Oberon.worldgen.OberonBiomes;
import com.mjr.extraplanets.moons.Phobos.event.PhobosEvents;
import com.mjr.extraplanets.moons.Phobos.worldgen.PhobosBiomes;
import com.mjr.extraplanets.moons.Rhea.event.RheaEvents;
import com.mjr.extraplanets.moons.Rhea.worldgen.RheaBiomes;
import com.mjr.extraplanets.moons.Titan.event.TitanEvents;
import com.mjr.extraplanets.moons.Titan.worldgen.TitanBiomes;
import com.mjr.extraplanets.moons.Titania.event.TitaniaEvents;
import com.mjr.extraplanets.moons.Titania.worldgen.TitaniaBiomes;
import com.mjr.extraplanets.moons.Triton.event.TritonEvents;
import com.mjr.extraplanets.moons.Triton.worldgen.TritonBiomes;
import com.mjr.extraplanets.network.ExtraPlanetsChannelHandler;
import com.mjr.extraplanets.planets.ExtraPlanets_Planets;
import com.mjr.extraplanets.planets.ExtraPlanets_SpaceStations;
import com.mjr.extraplanets.planets.Ceres.event.CeresEvents;
import com.mjr.extraplanets.planets.Ceres.worldgen.CeresBiomes;
import com.mjr.extraplanets.planets.Eris.event.ErisEvents;
import com.mjr.extraplanets.planets.Eris.worldgen.ErisBiomes;
import com.mjr.extraplanets.planets.Jupiter.event.JupiterEvents;
import com.mjr.extraplanets.planets.Jupiter.worldgen.JupiterBiomes;
import com.mjr.extraplanets.planets.Kepler22b.event.Kepler22bEvents;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.Kepler22bBiomes;
import com.mjr.extraplanets.planets.KuiperBelt.KuiperBeltEvents;
import com.mjr.extraplanets.planets.Mercury.event.MercuryEvents;
import com.mjr.extraplanets.planets.Mercury.worldgen.MercuryBiomes;
import com.mjr.extraplanets.planets.Neptune.event.NeptuneEvents;
import com.mjr.extraplanets.planets.Neptune.worldgen.NeptuneBiomes;
import com.mjr.extraplanets.planets.Pluto.event.PlutoEvents;
import com.mjr.extraplanets.planets.Pluto.worldgen.PlutoBiomes;
import com.mjr.extraplanets.planets.Saturn.event.SaturnEvents;
import com.mjr.extraplanets.planets.Saturn.worldgen.SaturnBiomes;
import com.mjr.extraplanets.planets.Uranus.event.UranusEvents;
import com.mjr.extraplanets.planets.Uranus.worldgen.UranusBiomes;
import com.mjr.extraplanets.proxy.CommonProxy;
import com.mjr.extraplanets.recipes.ExtraPlanets_RecipeGeneration;
import com.mjr.extraplanets.recipes.ExtraPlanets_Recipes;
import com.mjr.extraplanets.recipes.MarsRoverRecipes;
import com.mjr.extraplanets.recipes.Tier10ElectricRocketRecipes;
import com.mjr.extraplanets.recipes.Tier10RocketRecipes;
import com.mjr.extraplanets.recipes.Tier4RocketRecipes;
import com.mjr.extraplanets.recipes.Tier5RocketRecipes;
import com.mjr.extraplanets.recipes.Tier6RocketRecipes;
import com.mjr.extraplanets.recipes.Tier7RocketRecipes;
import com.mjr.extraplanets.recipes.Tier8RocketRecipes;
import com.mjr.extraplanets.recipes.Tier9RocketRecipes;
import com.mjr.extraplanets.recipes.VenusRoverRecipes;
import com.mjr.extraplanets.schematicPages.SchematicMarsRover;
import com.mjr.extraplanets.schematicPages.SchematicTier10Rocket;
import com.mjr.extraplanets.schematicPages.SchematicTier4Rocket;
import com.mjr.extraplanets.schematicPages.SchematicTier5Rocket;
import com.mjr.extraplanets.schematicPages.SchematicTier6Rocket;
import com.mjr.extraplanets.schematicPages.SchematicTier7Rocket;
import com.mjr.extraplanets.schematicPages.SchematicTier8Rocket;
import com.mjr.extraplanets.schematicPages.SchematicTier9Rocket;
import com.mjr.extraplanets.schematicPages.SchematicTierElectricRocket;
import com.mjr.extraplanets.schematicPages.SchematicVenusRover;
import com.mjr.mjrlegendslib.util.RegisterUtilities;
import com.mjr.mjrlegendslib.world.biomes.BiomeGenBase;

@Mod(modid = Constants.modID, name = Constants.modName, version = Constants.modVersion, dependencies = Constants.DEPENDENCIES_FORGE + Constants.DEPENDENCIES_MODS, guiFactory = "com.mjr.extraplanets.client.gui.screen.ConfigGuiFactory")
public class ExtraPlanets {

	@SidedProxy(clientSide = "com.mjr.extraplanets.proxy.ClientProxy", serverSide = "com.mjr.extraplanets.proxy.CommonProxy")
	public static CommonProxy proxy;

	@Instance(Constants.modID)
	public static ExtraPlanets instance;
	public static ExtraPlanetsChannelHandler packetPipeline;

	// Generate recipe JSON's (For use in Dev Workspace Only)
	public static boolean generateRecipes = false;

	// Block/Item/Biome Events Registering Lists
	public static List<Item> itemList = new ArrayList<>();
	public static List<Block> blocksList = new ArrayList<>();
	public static List<BiomeGenBase> biomesList = new ArrayList<>();

	// Blocks Creative Tab
	public static CreativeTabs BlocksTab = new CreativeTabs("SpaceBlocksTab") {
		@Override
		public ItemStack getTabIconItem() {
			if (Config.REFINERY_ADVANCED)
				return new ItemStack(ExtraPlanets_Machines.REFINERY_ADVANCED);
			else
				return new ItemStack(ExtraPlanets_Blocks.DENSE_ICE);
		}
	};
	// Items Creative Tab
	public static CreativeTabs ItemsTab = new CreativeTabs("SpaceItemsTab") {
		@Override
		public ItemStack getTabIconItem() {
			if (Config.MERCURY)
				return new ItemStack(ExtraPlanets_Items.TIER_4_ROCKET);
			else if (Config.JUPITER)
				return new ItemStack(ExtraPlanets_Items.TIER_5_ROCKET);
			else if (Config.SATURN)
				return new ItemStack(ExtraPlanets_Items.TIER_6_ROCKET);
			else if (Config.URANUS)
				return new ItemStack(ExtraPlanets_Items.TIER_7_ROCKET);
			else if (Config.NEPTUNE)
				return new ItemStack(ExtraPlanets_Items.TIER_8_ROCKET);
			else if (Config.PLUTO)
				return new ItemStack(ExtraPlanets_Items.TIER_9_ROCKET);
			else if (Config.ERIS)
				return new ItemStack(ExtraPlanets_Items.TIER_10_ROCKET);
			return new ItemStack(GCItems.rocketTier1);
		}
	};

	static {
		ExtraPlanets_Fluids.initFluid();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		GalacticraftVersionChecker.run();
		Config.load();

		// Main Events
		RegisterUtilities.registerEventHandler(new MainHandlerServer());

		// Planets Events
		if (Config.MERCURY)
			RegisterUtilities.registerEventHandler(new MercuryEvents());
		if (Config.CERES)
			RegisterUtilities.registerEventHandler(new CeresEvents());
		if (Config.JUPITER)
			RegisterUtilities.registerEventHandler(new JupiterEvents());
		if (Config.SATURN)
			RegisterUtilities.registerEventHandler(new SaturnEvents());
		if (Config.URANUS)
			RegisterUtilities.registerEventHandler(new UranusEvents());
		if (Config.NEPTUNE)
			RegisterUtilities.registerEventHandler(new NeptuneEvents());
		if (Config.PLUTO)
			RegisterUtilities.registerEventHandler(new PlutoEvents());
		if (Config.ERIS)
			RegisterUtilities.registerEventHandler(new ErisEvents());
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS)
			RegisterUtilities.registerEventHandler(new Kepler22bEvents());

		// Moons Events
		if (Config.CALLISTO)
			RegisterUtilities.registerEventHandler(new CallistoEvents());
		if (Config.DEIMOS)
			RegisterUtilities.registerEventHandler(new DeimosEvents());
		if (Config.EUROPA)
			RegisterUtilities.registerEventHandler(new EuropaEvents());
		if (Config.GANYMEDE)
			RegisterUtilities.registerEventHandler(new GanymedeEvents());
		if (Config.IO)
			RegisterUtilities.registerEventHandler(new IoEvents());
		if (Config.PHOBOS)
			RegisterUtilities.registerEventHandler(new PhobosEvents());
		if (Config.TRITON)
			RegisterUtilities.registerEventHandler(new TritonEvents());
		if (Config.RHEA)
			RegisterUtilities.registerEventHandler(new RheaEvents());
		if (Config.TITAN)
			RegisterUtilities.registerEventHandler(new TitanEvents());
		if (Config.OBERON)
			RegisterUtilities.registerEventHandler(new OberonEvents());
		if (Config.IAPETUS)
			RegisterUtilities.registerEventHandler(new IapetusEvents());
		if (Config.TITANIA)
			RegisterUtilities.registerEventHandler(new TitaniaEvents());
		if (Config.KUIPER_BELT)
			RegisterUtilities.registerEventHandler(new KuiperBeltEvents());

		// Initialization/Registering Methods For Blocks/Items
		ExtraPlanets_Blocks.init();
		ExtraPlanets_Machines.init();
		ExtraPlanets_Fluids.init();
		ExtraPlanets_Tools.init();
		ExtraPlanets_Armor.init();
		ExtraPlanets_Items.init();

		// Register RegistrationHandler
		RegisterUtilities.registerEventHandler(new RegistrationHandler());

		// Bone Meal Handler
		RegisterUtilities.registerEventHandler(new BoneMealHandler());

		// Proxy PreInit Method
		ExtraPlanets.proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		// Register Fluid Submerged Textures
		registerFluidSubmergedTextures();

		// Initialization/Registering Methods For SolarSystems/Planets/Moons/SpaceStations
		ExtraPlanets_SolarSystems.init();
		ExtraPlanets_Planets.init();
		ExtraPlanets_Moons.init();
		ExtraPlanets_SpaceStations.init();

		// Initialization/Registering Methods For Entities
		registerNonMobEntities();
		registerCreatures();

		packetPipeline = ExtraPlanetsChannelHandler.init();

		// Register Recipes
		ExtraPlanets_Recipes.init();

		// Proxy Init Method
		ExtraPlanets.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Register Capability Handlers
		CapabilityStatsHandler.register();
		CapabilityStatsClientHandler.register();

		// Register Schematics Recipes
		registerSchematicsRecipes();

		// Register Schematics (For Handing Enities versions)
		registerSchematicsItems();

		// Register/Add Dungeon Loot
		addDungeonLoot();

		// Initialize/Register Achievements
		// if (Config.ACHIEVEMENTS)
		// ExtraPlanets_Achievements.init();

		// Register GUI Handler
		NetworkRegistry.INSTANCE.registerGuiHandler(ExtraPlanets.instance, new GuiHandler());

		// Register Deconstructor Compatibility
		if (Config.GC_DECONSTRUCTOR_SUPPORT)
			RegisterDeconstructorCompatibility();

		// Register Extreme Reactors Compatibility
		if (Config.EXTREME_REACTORS_SUPPORT)
			ExtremeReactorsCompatibility.init();

		// Register MC MultiPart Compatibility
		if (Config.MC_MULITPART_SUPPORT)
			MCMultiPartCompatibility.init();

		// Generate recipe JSON's (For use in Dev Workspace Only)
		if (generateRecipes) {
			ExtraPlanets_RecipeGeneration.generate();
			ExtraPlanets_RecipeGeneration.generateConstants();
		}

		// Proxy PostInit Method
		ExtraPlanets.proxy.postInit(event);
	}

	public static void registerBiomes() {
		// Planets
		if (Config.MERCURY) {
			MercuryBiomes.mercury.setRegistryName(Constants.TEXTURE_PREFIX + "mercury");
			ExtraPlanets.biomesList.add(MercuryBiomes.mercury);
		}
		if (Config.CERES) {
			CeresBiomes.ceres.setRegistryName(Constants.TEXTURE_PREFIX + "ceres");
			ExtraPlanets.biomesList.add(CeresBiomes.ceres);
		}
		if (Config.JUPITER) {
			JupiterBiomes.jupiter.setRegistryName(Constants.TEXTURE_PREFIX + "jupiter");
			JupiterBiomes.jupiterMagmaSea.setRegistryName(Constants.TEXTURE_PREFIX + "jupiter_magma_sea");
			JupiterBiomes.jupiterSands.setRegistryName(Constants.TEXTURE_PREFIX + "jupiter_sands");
			ExtraPlanets.biomesList.add(JupiterBiomes.jupiter);
			ExtraPlanets.biomesList.add(JupiterBiomes.jupiterMagmaSea);
			ExtraPlanets.biomesList.add(JupiterBiomes.jupiterSands);
		}
		if (Config.SATURN) {
			SaturnBiomes.saturn.setRegistryName(Constants.TEXTURE_PREFIX + "saturn");
			SaturnBiomes.saturnHydroCarbonSea.setRegistryName(Constants.TEXTURE_PREFIX + "saturn_hydrocarbon_sea");
			SaturnBiomes.saturnNuclearLand.setRegistryName(Constants.TEXTURE_PREFIX + "saturn_nuclear_lands");
			ExtraPlanets.biomesList.add(SaturnBiomes.saturn);
			ExtraPlanets.biomesList.add(SaturnBiomes.saturnHydroCarbonSea);
			ExtraPlanets.biomesList.add(SaturnBiomes.saturnNuclearLand);
		}
		if (Config.URANUS) {
			UranusBiomes.uranus.setRegistryName(Constants.TEXTURE_PREFIX + "uranus");
			UranusBiomes.uranusFrozenWaterSea.setRegistryName(Constants.TEXTURE_PREFIX + "uranus_frozen_water_sea");
			UranusBiomes.uranusSnowLands.setRegistryName(Constants.TEXTURE_PREFIX + "uranus_snow_lands");
			ExtraPlanets.biomesList.add(UranusBiomes.uranus);
			ExtraPlanets.biomesList.add(UranusBiomes.uranusFrozenWaterSea);
			ExtraPlanets.biomesList.add(UranusBiomes.uranusSnowLands);
		}
		if (Config.NEPTUNE) {
			NeptuneBiomes.neptune.setRegistryName(Constants.TEXTURE_PREFIX + "neptune");
			NeptuneBiomes.neptuneRadioActiveWaterSea.setRegistryName(Constants.TEXTURE_PREFIX + "neptune_radioactive_water_sea");
			NeptuneBiomes.neptuneLayeredHills.setRegistryName(Constants.TEXTURE_PREFIX + "neptune_layered_hills");
			ExtraPlanets.biomesList.add(NeptuneBiomes.neptune);
			ExtraPlanets.biomesList.add(NeptuneBiomes.neptuneRadioActiveWaterSea);
			ExtraPlanets.biomesList.add(NeptuneBiomes.neptuneLayeredHills);
		}
		if (Config.PLUTO) {
			PlutoBiomes.pluto.setRegistryName(Constants.TEXTURE_PREFIX + "pluto");
			ExtraPlanets.biomesList.add(PlutoBiomes.pluto);
		}
		if (Config.ERIS) {
			ErisBiomes.eris.setRegistryName(Constants.TEXTURE_PREFIX + "eris");
			ExtraPlanets.biomesList.add(ErisBiomes.eris);
		}
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			Kepler22bBiomes.kepler22bPlains.setRegistryName(Constants.TEXTURE_PREFIX + "kepler22b_plains");
			Kepler22bBiomes.kepler22bBlueForest.setRegistryName(Constants.TEXTURE_PREFIX + "kepler22b_blue_forest");
			Kepler22bBiomes.kepler22bRedForest.setRegistryName(Constants.TEXTURE_PREFIX + "kepler22b_red_forest");
			Kepler22bBiomes.kepler22bPurpleForest.setRegistryName(Constants.TEXTURE_PREFIX + "kepler22b_purple_forest");
			Kepler22bBiomes.kepler22bYellowForest.setRegistryName(Constants.TEXTURE_PREFIX + "kepler22b_yellow_forest");
			Kepler22bBiomes.kepler22bRedDesert.setRegistryName(Constants.TEXTURE_PREFIX + "kepler22b_red_desert");
			Kepler22bBiomes.kepler22bWasteLands.setRegistryName(Constants.TEXTURE_PREFIX + "kepler22b_waste_lands");
			Kepler22bBiomes.kepler22bCandyLand.setRegistryName(Constants.TEXTURE_PREFIX + "kepler22b_candy_land");
			Kepler22bBiomes.kepler22bDiamondPlains.setRegistryName(Constants.TEXTURE_PREFIX + "kepler22b_diamond_plains");
			ExtraPlanets.biomesList.add(Kepler22bBiomes.kepler22bPlains);
			ExtraPlanets.biomesList.add(Kepler22bBiomes.kepler22bBlueForest);
			ExtraPlanets.biomesList.add(Kepler22bBiomes.kepler22bRedForest);
			ExtraPlanets.biomesList.add(Kepler22bBiomes.kepler22bPurpleForest);
			ExtraPlanets.biomesList.add(Kepler22bBiomes.kepler22bYellowForest);
			ExtraPlanets.biomesList.add(Kepler22bBiomes.kepler22bRedDesert);
			ExtraPlanets.biomesList.add(Kepler22bBiomes.kepler22bWasteLands);
			ExtraPlanets.biomesList.add(Kepler22bBiomes.kepler22bCandyLand);
			ExtraPlanets.biomesList.add(Kepler22bBiomes.kepler22bDiamondPlains);
		}
		// Moons
		if (Config.CALLISTO) {
			CallistoBiomes.callisto.setRegistryName(Constants.TEXTURE_PREFIX + "callisto");
			ExtraPlanets.biomesList.add(CallistoBiomes.callisto);
		}
		if (Config.DEIMOS) {
			DeimosBiomes.deimos.setRegistryName(Constants.TEXTURE_PREFIX + "deimos");
			ExtraPlanets.biomesList.add(DeimosBiomes.deimos);
		}
		if (Config.EUROPA) {
			EuropaBiomes.europa.setRegistryName(Constants.TEXTURE_PREFIX + "europa");
			ExtraPlanets.biomesList.add(EuropaBiomes.europa);
		}
		if (Config.GANYMEDE) {
			GanymedeBiomes.ganymede.setRegistryName(Constants.TEXTURE_PREFIX + "ganymede");
			ExtraPlanets.biomesList.add(GanymedeBiomes.ganymede);
		}
		if (Config.IAPETUS) {
			IapetusBiomes.iapetus.setRegistryName(Constants.TEXTURE_PREFIX + "iapetus");
			ExtraPlanets.biomesList.add(IapetusBiomes.iapetus);
		}
		if (Config.IO) {
			IoBiomes.io.setRegistryName(Constants.TEXTURE_PREFIX + "io");
			IoBiomes.ioAshLands.setRegistryName(Constants.TEXTURE_PREFIX + "io_ash_lands");
			IoBiomes.ioBurningPlains.setRegistryName(Constants.TEXTURE_PREFIX + "io_burning_plains");
			ExtraPlanets.biomesList.add(IoBiomes.io);
			ExtraPlanets.biomesList.add(IoBiomes.ioAshLands);
			ExtraPlanets.biomesList.add(IoBiomes.ioBurningPlains);
		}
		if (Config.OBERON) {
			OberonBiomes.oberon.setRegistryName(Constants.TEXTURE_PREFIX + "oberon");
			OberonBiomes.oberonLargeMountain.setRegistryName(Constants.TEXTURE_PREFIX + "oberon_large_mountain");
			OberonBiomes.oberonValleys.setRegistryName(Constants.TEXTURE_PREFIX + "oberon_valleys");
			ExtraPlanets.biomesList.add(OberonBiomes.oberon);
			ExtraPlanets.biomesList.add(OberonBiomes.oberonLargeMountain);
			ExtraPlanets.biomesList.add(OberonBiomes.oberonValleys);
		}
		if (Config.PHOBOS) {
			PhobosBiomes.phobos.setRegistryName(Constants.TEXTURE_PREFIX + "phobos");
			ExtraPlanets.biomesList.add(PhobosBiomes.phobos);
		}
		if (Config.RHEA) {
			RheaBiomes.rhea.setRegistryName(Constants.TEXTURE_PREFIX + "rhea");
			ExtraPlanets.biomesList.add(RheaBiomes.rhea);
		}
		if (Config.TITAN) {
			TitanBiomes.titan.setRegistryName(Constants.TEXTURE_PREFIX + "titan");
			TitanBiomes.titanMethaneHills.setRegistryName(Constants.TEXTURE_PREFIX + "titan_methane_hills");
			TitanBiomes.titanMethaneSea.setRegistryName(Constants.TEXTURE_PREFIX + "titan_methane_sea");
			ExtraPlanets.biomesList.add(TitanBiomes.titan);
			ExtraPlanets.biomesList.add(TitanBiomes.titanMethaneHills);
			ExtraPlanets.biomesList.add(TitanBiomes.titanMethaneSea);
		}
		if (Config.TITANIA) {
			TitaniaBiomes.titania.setRegistryName(Constants.TEXTURE_PREFIX + "titania");
			ExtraPlanets.biomesList.add(TitaniaBiomes.titania);
		}
		if (Config.TRITON) {
			TritonBiomes.triton.setRegistryName(Constants.TEXTURE_PREFIX + "triton");
			TritonBiomes.tritonIceLands.setRegistryName(Constants.TEXTURE_PREFIX + "triton_ice_lands");
			TritonBiomes.tritonIceSea.setRegistryName(Constants.TEXTURE_PREFIX + "triton_ice_sea");
			ExtraPlanets.biomesList.add(TritonBiomes.triton);
			ExtraPlanets.biomesList.add(TritonBiomes.tritonIceLands);
			ExtraPlanets.biomesList.add(TritonBiomes.tritonIceSea);
		}
	}

	private void registerFluidSubmergedTextures() {
		GalacticraftCore.proxy.registerFluidTexture(ExtraPlanets_Fluids.CLEAN_WATER_FLUID, new ResourceLocation(Constants.ASSET_PREFIX, "textures/misc/under_clean_water.png"));
		GalacticraftCore.proxy.registerFluidTexture(ExtraPlanets_Fluids.FROZEN_WATER_FLUID, new ResourceLocation(Constants.ASSET_PREFIX, "textures/misc/under_frozen_water.png"));
		GalacticraftCore.proxy.registerFluidTexture(ExtraPlanets_Fluids.GLOWSTONE_FLUID, new ResourceLocation(Constants.ASSET_PREFIX, "textures/misc/under_glowstone.png"));
		GalacticraftCore.proxy.registerFluidTexture(ExtraPlanets_Fluids.INFECTED_WATER_FLUID, new ResourceLocation(Constants.ASSET_PREFIX, "textures/misc/under_infected_water.png"));
		GalacticraftCore.proxy.registerFluidTexture(ExtraPlanets_Fluids.LIQUID_CARAMEL_FLUID, new ResourceLocation(Constants.ASSET_PREFIX, "textures/misc/under_liquid_caramel.png"));
		GalacticraftCore.proxy.registerFluidTexture(ExtraPlanets_Fluids.LIQUID_CHOCOLATE_FLUID, new ResourceLocation(Constants.ASSET_PREFIX, "textures/misc/under_liquid_chocolate.png"));
		GalacticraftCore.proxy.registerFluidTexture(ExtraPlanets_Fluids.LIQUID_HYDROCARBON_FLUID, new ResourceLocation(Constants.ASSET_PREFIX, "textures/misc/under_liquid_hydrocarbon.png"));
		GalacticraftCore.proxy.registerFluidTexture(ExtraPlanets_Fluids.MAGMA_FLUID, new ResourceLocation(Constants.ASSET_PREFIX, "textures/misc/under_magma.png"));
		GalacticraftCore.proxy.registerFluidTexture(ExtraPlanets_Fluids.METHANE_FLUID, new ResourceLocation(Constants.ASSET_PREFIX, "textures/misc/under_methane.png"));
		GalacticraftCore.proxy.registerFluidTexture(ExtraPlanets_Fluids.NITROGEN_FLUID, new ResourceLocation(Constants.ASSET_PREFIX, "textures/misc/under_nitrogen.png"));
		GalacticraftCore.proxy.registerFluidTexture(ExtraPlanets_Fluids.NITROGEN_ICE_FLUID, new ResourceLocation(Constants.ASSET_PREFIX, "textures/misc/under_nitrogen_ice.png"));
		GalacticraftCore.proxy.registerFluidTexture(ExtraPlanets_Fluids.RADIO_ACTIVE_WATER_FLUID, new ResourceLocation(Constants.ASSET_PREFIX, "textures/misc/under_radio_active_water.png"));
		GalacticraftCore.proxy.registerFluidTexture(ExtraPlanets_Fluids.SALT_FLUID, new ResourceLocation(Constants.ASSET_PREFIX, "textures/misc/under_salt.png"));
	}

	private void registerNonMobEntities() {
		if (Config.CERES && Config.NUCLEAR_BOMB)
			RegisterUtilities.registerNonMobEntity(Constants.modID, ExtraPlanets.instance, EntityNuclearBombPrimed.class, Constants.modID + "." + "NuclearBombPrimed", 150, 1, true);
		if (Config.SATURN && Config.FIRE_BOMB)
			RegisterUtilities.registerNonMobEntity(Constants.modID, ExtraPlanets.instance, EntityFireBombPrimed.class, Constants.modID + "." + "FireBombPrimed", 150, 1, true);
		if (Config.MERCURY) {
			RegisterUtilities.registerNonMobEntity(Constants.modID, ExtraPlanets.instance, EntityTier4Rocket.class, Constants.modID + "." + "EntityTier4Rocket", 150, 1, false);
			RegisterUtilities.registerNonMobEntity(Constants.modID, ExtraPlanets.instance, EntityMercuryLander.class, Constants.modID + "." + "EntityMercuryLander", 150, 5, false);
		}
		if (Config.JUPITER) {
			RegisterUtilities.registerNonMobEntity(Constants.modID, ExtraPlanets.instance, EntityTier5Rocket.class, Constants.modID + "." + "EntityTier5Rocket", 150, 1, false);
			RegisterUtilities.registerNonMobEntity(Constants.modID, ExtraPlanets.instance, EntityJupiterLander.class, Constants.modID + "." + "EntityJupiterLander", 150, 5, false);
		}
		if (Config.SATURN) {
			RegisterUtilities.registerNonMobEntity(Constants.modID, ExtraPlanets.instance, EntityTier6Rocket.class, Constants.modID + "." + "EntityTier6Rocket", 150, 1, false);
			RegisterUtilities.registerNonMobEntity(Constants.modID, ExtraPlanets.instance, EntitySaturnLander.class, Constants.modID + "." + "EntitSaturnLander", 150, 5, false);
		}
		if (Config.URANUS) {
			RegisterUtilities.registerNonMobEntity(Constants.modID, ExtraPlanets.instance, EntityTier7Rocket.class, Constants.modID + "." + "EntityTier7Rocket", 150, 1, false);
			RegisterUtilities.registerNonMobEntity(Constants.modID, ExtraPlanets.instance, EntityUranusLander.class, Constants.modID + "." + "EntityUranusLander", 150, 5, false);
		}
		if (Config.NEPTUNE) {
			RegisterUtilities.registerNonMobEntity(Constants.modID, ExtraPlanets.instance, EntityTier8Rocket.class, Constants.modID + "." + "EntityTier8Rocket", 150, 1, false);
			RegisterUtilities.registerNonMobEntity(Constants.modID, ExtraPlanets.instance, EntityNeptuneLander.class, Constants.modID + "." + "EntityNeptuneLander", 150, 5, false);
		}
		if (Config.PLUTO)
			RegisterUtilities.registerNonMobEntity(Constants.modID, ExtraPlanets.instance, EntityTier9Rocket.class, Constants.modID + "." + "EntityTier9Rocket", 150, 1, false);
		if (Config.ERIS)
			RegisterUtilities.registerNonMobEntity(Constants.modID, ExtraPlanets.instance, EntityTier10Rocket.class, Constants.modID + "." + "EntityTier10Rocket", 150, 1, false);
		if (Config.ERIS && Config.KEPLER22B)
			RegisterUtilities.registerNonMobEntity(Constants.modID, ExtraPlanets.instance, EntityElectricRocket.class, Constants.modID + "." + "EntityTier10ElectricRocket", 150, 1, false);
		if (Config.MARS_ROVER)
			RegisterUtilities.registerNonMobEntity(Constants.modID, ExtraPlanets.instance, EntityMarsRover.class, Constants.modID + "." + "EntityMarsRover", 150, 1, false);
		if (Config.VENUS_ROVER)
			RegisterUtilities.registerNonMobEntity(Constants.modID, ExtraPlanets.instance, EntityVenusRover.class, Constants.modID + "." + "EntityVenusRover", 150, 1, false);
		RegisterUtilities.registerNonMobEntity(Constants.modID, ExtraPlanets.instance, EntityGeneralLander.class, "EntityGeneralLander", 150, 5, false);
	}

	private void registerCreatures() {
		// Dungeon Bosses
		if (Config.MERCURY)
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerMobEntity(Constants.modID, ExtraPlanets.instance, EntityCreeperBossMercury.class, Constants.modID + "." + "CreeperBossMercury", 894731, 0);
			else
				RegisterUtilities.registerMobEntity(Constants.modID, ExtraPlanets.instance, EntityEvolvedMagmaCubeBoss.class, Constants.modID + "." + "EvolvedMagmaCubeBoss", 3407872, 16579584);
		if (Config.JUPITER)
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerMobEntity(Constants.modID, ExtraPlanets.instance, EntityCreeperBossJupiter.class, Constants.modID + "." + "CreeperBossJupiter", 894731, 0);
			else
				RegisterUtilities.registerMobEntity(Constants.modID, ExtraPlanets.instance, EntityEvolvedFireBatBoss.class, Constants.modID + "." + "EvolvedFireBatBoss", 16167425, 0);
		if (Config.SATURN)

			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerMobEntity(Constants.modID, ExtraPlanets.instance, EntityCreeperBossSaturn.class, Constants.modID + "." + "CreeperBossSaturn", 894731, 0);
			else
				RegisterUtilities.registerMobEntity(Constants.modID, ExtraPlanets.instance, EntityEvolvedGhastBoss.class, Constants.modID + "." + "EvolvedGhastBoss", 894731, 0);
		if (Config.URANUS)
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerMobEntity(Constants.modID, ExtraPlanets.instance, EntityCreeperBossUranus.class, Constants.modID + "." + "CreeperBossUranus", 894731, 0);
			else
				RegisterUtilities.registerMobEntity(Constants.modID, ExtraPlanets.instance, EntityEvolvedIceSlimeBoss.class, Constants.modID + "." + "EvolvedIceSlimeBoss", 16382457, 44975);
		if (Config.NEPTUNE)
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerMobEntity(Constants.modID, ExtraPlanets.instance, EntityCreeperBossNeptune.class, Constants.modID + "." + "CreeperBossNeptune", 894731, 0);
			else
				RegisterUtilities.registerMobEntity(Constants.modID, ExtraPlanets.instance, EntityEvolvedSnowmanBoss.class, Constants.modID + "." + "EvolvedSnowmanBoss", 894731, 0);
		if (Config.PLUTO)
			RegisterUtilities.registerMobEntity(Constants.modID, ExtraPlanets.instance, EntityCreeperBossPluto.class, Constants.modID + "." + "CreeperBossPluto", 894731, 0);
		if (Config.ERIS)
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerMobEntity(Constants.modID, ExtraPlanets.instance, EntityCreeperBossEris.class, "CreeperBossEris", 894731, 0);
			else
				RegisterUtilities.registerMobEntity(Constants.modID, ExtraPlanets.instance, EntityEvolvedGiantZombieBoss.class, "EvolvedGiantZombieBoss", 894731, 0);
	}

	private void registerSchematicsRecipes() {
		if (Config.MERCURY)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier4Rocket());
		if (Config.JUPITER)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier5Rocket());
		if (Config.SATURN)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier6Rocket());
		if (Config.URANUS)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier7Rocket());
		if (Config.NEPTUNE)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier8Rocket());
		if (Config.PLUTO)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier9Rocket());
		if (Config.ERIS)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier10Rocket());
		if (Config.ERIS && Config.KEPLER22B)
			SchematicRegistry.registerSchematicRecipe(new SchematicTierElectricRocket());
		if (Config.MARS_ROVER)
			SchematicRegistry.registerSchematicRecipe(new SchematicMarsRover());
		if (Config.VENUS_ROVER)
			SchematicRegistry.registerSchematicRecipe(new SchematicVenusRover());
	}

	private void registerSchematicsItems() {
		SchematicTier4.registerSchematicItems();
		SchematicTier5.registerSchematicItems();
		SchematicTier6.registerSchematicItems();
		SchematicTier7.registerSchematicItems();
		SchematicTier8.registerSchematicItems();
		SchematicTier9.registerSchematicItems();
		SchematicTier10.registerSchematicItems();
	}

	private void addDungeonLoot() {
		if (Config.MERCURY) {
			if (Config.MORE_PLANETS_COMPATIBILITY) {
				GalacticraftRegistry.addDungeonLoot(11, new ItemStack(ExtraPlanets_Items.TIER_4_SCHEMATIC, 1, 0));
				GalacticraftRegistry.addDungeonLoot(11, new ItemStack(ExtraPlanets_Items.GEIGER_COUNTER, 1, 0));
			} else {
				GalacticraftRegistry.addDungeonLoot(4, new ItemStack(ExtraPlanets_Items.TIER_4_SCHEMATIC, 1, 0));
				GalacticraftRegistry.addDungeonLoot(4, new ItemStack(ExtraPlanets_Items.GEIGER_COUNTER, 1, 0));
			}
		}
		if (Config.JUPITER)
			if (Config.MORE_PLANETS_COMPATIBILITY)
				GalacticraftRegistry.addDungeonLoot(4, new ItemStack(ExtraPlanets_Items.TIER_5_SCHEMATIC, 1, 0));
			else
				GalacticraftRegistry.addDungeonLoot(5, new ItemStack(ExtraPlanets_Items.TIER_5_SCHEMATIC, 1, 0));
		if (Config.SATURN)
			if (Config.MORE_PLANETS_COMPATIBILITY)
				GalacticraftRegistry.addDungeonLoot(5, new ItemStack(ExtraPlanets_Items.TIER_6_SCHEMATIC, 1, 0));
			else
				GalacticraftRegistry.addDungeonLoot(6, new ItemStack(ExtraPlanets_Items.TIER_6_SCHEMATIC, 1, 0));
		if (Config.URANUS)
			GalacticraftRegistry.addDungeonLoot(7, new ItemStack(ExtraPlanets_Items.TIER_7_SCHEMATIC, 1, 0));
		if (Config.NEPTUNE)
			GalacticraftRegistry.addDungeonLoot(8, new ItemStack(ExtraPlanets_Items.TIER_8_SCHEMATIC, 1, 0));
		if (Config.PLUTO)
			GalacticraftRegistry.addDungeonLoot(9, new ItemStack(ExtraPlanets_Items.TIER_9_SCHEMATIC, 1, 0));
		if (Config.ERIS)
			GalacticraftRegistry.addDungeonLoot(10, new ItemStack(ExtraPlanets_Items.TIER_10_SCHEMATIC, 1, 0));
		if (Config.ERIS && Config.KEPLER22B)
			GalacticraftRegistry.addDungeonLoot(10, new ItemStack(ExtraPlanets_Items.TIER_10_ELECTRIC_ROCKET_SCHEMATIC, 1, 0));
		if (Config.MARS_ROVER)
			GalacticraftRegistry.addDungeonLoot(1, new ItemStack(ExtraPlanets_Items.MARS_ROVER_SCHEMATIC, 1, 0));
		if (Config.VENUS_ROVER)
			GalacticraftRegistry.addDungeonLoot(3, new ItemStack(ExtraPlanets_Items.VENUS_ROVER_SCHEMATIC, 1, 0));
	}

	private void RegisterDeconstructorCompatibility() {
		TileEntityDeconstructor.knownRecipes.addAll(Tier4RocketRecipes.getTier4RocketRecipes());
		TileEntityDeconstructor.knownRecipes.addAll(Tier5RocketRecipes.getTier5RocketRecipes());
		TileEntityDeconstructor.knownRecipes.addAll(Tier6RocketRecipes.getTier6RocketRecipes());
		TileEntityDeconstructor.knownRecipes.addAll(Tier7RocketRecipes.getTier7RocketRecipes());
		TileEntityDeconstructor.knownRecipes.addAll(Tier8RocketRecipes.getTier8RocketRecipes());
		TileEntityDeconstructor.knownRecipes.addAll(Tier9RocketRecipes.getTier9RocketRecipes());
		TileEntityDeconstructor.knownRecipes.addAll(Tier10RocketRecipes.getTier10RocketRecipes());
		TileEntityDeconstructor.knownRecipes.addAll(Tier10ElectricRocketRecipes.getTier10ElectricRocketRecipes());
		TileEntityDeconstructor.knownRecipes.addAll(MarsRoverRecipes.getMarsRoverRecipes());
		TileEntityDeconstructor.knownRecipes.addAll(VenusRoverRecipes.getVenusRoverRecipes());

		TileEntityDeconstructor.addSalvage(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 3));
		TileEntityDeconstructor.addSalvage(new ItemStack(ExtraPlanets_Items.TIER_4_ITEMS, 1, 4));
		TileEntityDeconstructor.addSalvage(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 3));
		TileEntityDeconstructor.addSalvage(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 4));
		TileEntityDeconstructor.addSalvage(new ItemStack(ExtraPlanets_Items.TIER_5_ITEMS, 1, 6));
		TileEntityDeconstructor.addSalvage(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 3));
		TileEntityDeconstructor.addSalvage(new ItemStack(ExtraPlanets_Items.TIER_6_ITEMS, 1, 4));
		TileEntityDeconstructor.addSalvage(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 3));
		TileEntityDeconstructor.addSalvage(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 4));
		TileEntityDeconstructor.addSalvage(new ItemStack(ExtraPlanets_Items.TIER_7_ITEMS, 1, 6));
		TileEntityDeconstructor.addSalvage(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 3));
		TileEntityDeconstructor.addSalvage(new ItemStack(ExtraPlanets_Items.TIER_8_ITEMS, 1, 4));
		TileEntityDeconstructor.addSalvage(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 3));
		TileEntityDeconstructor.addSalvage(new ItemStack(ExtraPlanets_Items.TIER_9_ITEMS, 1, 4));
		TileEntityDeconstructor.addSalvage(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 3));
		TileEntityDeconstructor.addSalvage(new ItemStack(ExtraPlanets_Items.TIER_10_ITEMS, 1, 4));
		TileEntityDeconstructor.addSalvage(new ItemStack(ExtraPlanets_Items.TIER_11_ITEMS, 1, 6));
	}

	@Mod.EventBusSubscriber(modid = Constants.modID)
	public static class RegistrationHandler {
		@SubscribeEvent
		public static void registerBlocksEvent(RegistryEvent.Register<Block> event) {
			for (Block block : ExtraPlanets.blocksList) {
				event.getRegistry().register(block);
			}
		}

		@SubscribeEvent
		public static void registerItemsEvent(RegistryEvent.Register<Item> event) {
			for (Item item : ExtraPlanets.itemList) {
				event.getRegistry().register(item);
			}
			// Register Ore Dict
			if (Config.ORE_DICTIONARY_INGOTS)
				ExtraPlanets_Items.OreDictionaryIngotsRegister();
			if (Config.ORE_DICTIONARY_OTHER)
				ExtraPlanets_Items.OreDictionaryItemsRegister();
			if (Config.ORE_DICTIONARY)
				ExtraPlanets_Blocks.OreDictionaryRegister();
		}

		@SubscribeEvent
		public static void registerBiomesEvent(RegistryEvent.Register<Biome> event) {
			// Register Biomes
			ExtraPlanets.registerBiomes();

			for (BiomeGenBase biome : ExtraPlanets.biomesList) {
				event.getRegistry().register(biome);
				if (!ConfigManagerCore.disableBiomeTypeRegistrations) {
					biome.registerTypes();
				}
			}
		}

		@SubscribeEvent(priority = EventPriority.LOWEST)
		public static void registerRecipesEvent(RegistryEvent.Register<IRecipe> event) {
			ExtraPlanets_Recipes.initEvent();
		}
	}
}
