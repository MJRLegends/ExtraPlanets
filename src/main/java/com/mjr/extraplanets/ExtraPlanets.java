package com.mjr.extraplanets;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.GCItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.machines.ExtraPlanets_Machines;
import com.mjr.extraplanets.client.gui.GuiHandler;
import com.mjr.extraplanets.client.handlers.capabilities.CapabilityStatsClientHandler;
import com.mjr.extraplanets.entities.EntityFireBombPrimed;
import com.mjr.extraplanets.entities.EntityNuclearBombPrimed;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedFireBatBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedGhastBoss;
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
import com.mjr.extraplanets.handlers.BucketHandler;
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
import com.mjr.extraplanets.planets.Kepler22b.worldgen.biome.BiomeGenBaseKepler22b;
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
import com.mjr.extraplanets.recipes.ExtraPlanets_Recipes;
import com.mjr.extraplanets.schematic.SchematicMarsRover;
import com.mjr.extraplanets.schematic.SchematicTier10Rocket;
import com.mjr.extraplanets.schematic.SchematicTier4Rocket;
import com.mjr.extraplanets.schematic.SchematicTier5Rocket;
import com.mjr.extraplanets.schematic.SchematicTier6Rocket;
import com.mjr.extraplanets.schematic.SchematicTier7Rocket;
import com.mjr.extraplanets.schematic.SchematicTier8Rocket;
import com.mjr.extraplanets.schematic.SchematicTier9Rocket;
import com.mjr.extraplanets.schematic.SchematicTierElectricRocket;
import com.mjr.extraplanets.schematic.SchematicVenusRover;
import com.mjr.extraplanets.util.RegisterHelper;

@Mod(modid = Constants.modID, name = Constants.modName, version = Constants.modVersion, dependencies = Constants.DEPENDENCIES_FORGE + Constants.DEPENDENCIES_MODS)
public class ExtraPlanets {

	@SidedProxy(clientSide = "com.mjr.extraplanets.proxy.ClientProxy", serverSide = "com.mjr.extraplanets.proxy.CommonProxy")
	public static CommonProxy proxy;

	@Instance(Constants.modID)
	public static ExtraPlanets instance;

	public static ExtraPlanetsChannelHandler packetPipeline;

	// Blocks Creative Tab
	public static CreativeTabs BlocksTab = new CreativeTabs("SpaceBlocksTab") {
		@Override
		public Item getTabIconItem() {
			if (Config.REFINERY_ADVANCED)
				return Item.getItemFromBlock(ExtraPlanets_Machines.REFINERY_ADVANCED);
			else
				return Item.getItemFromBlock(ExtraPlanets_Blocks.DENSE_ICE);
		}
	};
	// Items Creative Tab
	public static CreativeTabs ItemsTab = new CreativeTabs("SpaceItemsTab") {
		@Override
		public Item getTabIconItem() {
			if (Config.MERCURY)
				return ExtraPlanets_Items.TIER_4_ROCKET;
			else if (Config.JUPITER)
				return ExtraPlanets_Items.TIER_5_ROCKET;
			else if (Config.SATURN)
				return ExtraPlanets_Items.TIER_6_ROCKET;
			else if (Config.URANUS)
				return ExtraPlanets_Items.TIER_7_ROCKET;
			else if (Config.NEPTUNE)
				return ExtraPlanets_Items.TIER_8_ROCKET;
			else if (Config.PLUTO)
				return ExtraPlanets_Items.TIER_9_ROCKET;
			else if (Config.ERIS)
				return ExtraPlanets_Items.TIER_10_ROCKET;
			return GCItems.rocketTier1;
		}
	};
	// Tools Creative Tab
	public static CreativeTabs ToolsTab = new CreativeTabs("SpaceToolsTab") {
		@Override
		public Item getTabIconItem() {
			if (Config.MERCURY)
				return ExtraPlanets_Tools.CARBON_PICKAXE;
			else if (Config.JUPITER)
				return ExtraPlanets_Tools.PALLADIUM_PICKAXE;
			else if (Config.SATURN)
				return ExtraPlanets_Tools.MAGNESIUM_PICKAXE;
			else if (Config.URANUS)
				return ExtraPlanets_Tools.CRYSTAL_PICKAXE;
			return GCItems.steelPickaxe;
		}
	};
	// Armour Creative Tab
	public static CreativeTabs ArmorTab = new CreativeTabs("SpaceArmorTab") {
		@Override
		public Item getTabIconItem() {
			if (Config.MERCURY)
				return ExtraPlanets_Armor.CARBON_CHEST;
			else if (Config.JUPITER)
				return ExtraPlanets_Armor.PALLASIUM_CHEST;
			else if (Config.SATURN)
				return ExtraPlanets_Armor.MAGNESIUM_CHEST;
			else if (Config.URANUS)
				return ExtraPlanets_Armor.CRYSTAL_CHEST;
			return GCItems.steelChestplate;
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		GalacticraftVersionChecker.run();
		Config.load();

		// Main Events
		MinecraftForge.EVENT_BUS.register(new MainHandlerServer());

		// Planets Events
		if (Config.MERCURY)
			MinecraftForge.EVENT_BUS.register(new MercuryEvents());
		if (Config.CERES)
			MinecraftForge.EVENT_BUS.register(new CeresEvents());
		if (Config.JUPITER)
			MinecraftForge.EVENT_BUS.register(new JupiterEvents());
		if (Config.SATURN)
			MinecraftForge.EVENT_BUS.register(new SaturnEvents());
		if (Config.URANUS)
			MinecraftForge.EVENT_BUS.register(new UranusEvents());
		if (Config.NEPTUNE)
			MinecraftForge.EVENT_BUS.register(new NeptuneEvents());
		if (Config.PLUTO)
			MinecraftForge.EVENT_BUS.register(new PlutoEvents());
		if (Config.ERIS)
			MinecraftForge.EVENT_BUS.register(new ErisEvents());
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS)
			MinecraftForge.EVENT_BUS.register(new Kepler22bEvents());

		// Moons Events
		if (Config.CALLISTO)
			MinecraftForge.EVENT_BUS.register(new CallistoEvents());
		if (Config.DEIMOS)
			MinecraftForge.EVENT_BUS.register(new DeimosEvents());
		if (Config.EUROPA)
			MinecraftForge.EVENT_BUS.register(new EuropaEvents());
		if (Config.GANYMEDE)
			MinecraftForge.EVENT_BUS.register(new GanymedeEvents());
		if (Config.IO)
			MinecraftForge.EVENT_BUS.register(new IoEvents());
		if (Config.PHOBOS)
			MinecraftForge.EVENT_BUS.register(new PhobosEvents());
		if (Config.TRITON)
			MinecraftForge.EVENT_BUS.register(new TritonEvents());
		if (Config.RHEA)
			MinecraftForge.EVENT_BUS.register(new RheaEvents());
		if (Config.TITAN)
			MinecraftForge.EVENT_BUS.register(new TitanEvents());
		if (Config.OBERON)
			MinecraftForge.EVENT_BUS.register(new OberonEvents());
		if (Config.IAPETUS)
			MinecraftForge.EVENT_BUS.register(new IapetusEvents());
		if (Config.TITANIA)
			MinecraftForge.EVENT_BUS.register(new TitaniaEvents());
		if (Config.KUIPER_BELT)
			MinecraftForge.EVENT_BUS.register(new KuiperBeltEvents());

		// Initialization/Registering Methods For Blocks/Items
		ExtraPlanets_Blocks.init();
		ExtraPlanets_Machines.init();
		ExtraPlanets_Fluids.init();
		ExtraPlanets_Tools.init();
		ExtraPlanets_Armor.init();
		ExtraPlanets_Items.init();

		// Registering fluids with Bucket Handler
		if (Config.CERES)
			BucketHandler.INSTANCE.buckets.put(ExtraPlanets_Fluids.SALT, ExtraPlanets_Items.BUCKET_SALT);
		if (Config.JUPITER)
			BucketHandler.INSTANCE.buckets.put(ExtraPlanets_Fluids.MAGMA, ExtraPlanets_Items.BUCKET_MAGMA);
		if (Config.SATURN)
			BucketHandler.INSTANCE.buckets.put(ExtraPlanets_Fluids.GLOWSTONE, ExtraPlanets_Items.BUCKET_GLOWSTONE);
		if (Config.URANUS)
			BucketHandler.INSTANCE.buckets.put(ExtraPlanets_Fluids.FROZEN_WATER, ExtraPlanets_Items.BUCKET_FROZEN_WATER);
		if (Config.NEPTUNE)
			BucketHandler.INSTANCE.buckets.put(ExtraPlanets_Fluids.NITROGEN, ExtraPlanets_Items.BUCKET_NITROGEN);
		BucketHandler.INSTANCE.buckets.put(ExtraPlanets_Fluids.CLEAN_WATER, ExtraPlanets_Items.BUCKET_CLEAN_WATER);
		BucketHandler.INSTANCE.buckets.put(ExtraPlanets_Fluids.INFECTED_WATER, ExtraPlanets_Items.BUCKET_INFECTED_WATER);
		BucketHandler.INSTANCE.buckets.put(ExtraPlanets_Fluids.RADIO_ACTIVE_WATER, ExtraPlanets_Items.BUCKET_RADIOACTIVE_WATER);
		BucketHandler.INSTANCE.buckets.put(ExtraPlanets_Fluids.METHANE, ExtraPlanets_Items.BUCKET_METHANE);
		BucketHandler.INSTANCE.buckets.put(ExtraPlanets_Fluids.NITROGEN_ICE, ExtraPlanets_Items.BUCKET_NITROGEN_ICE);
		BucketHandler.INSTANCE.buckets.put(ExtraPlanets_Fluids.LIQUID_HYDROCARBON, ExtraPlanets_Items.BUCKET_LIQUID_HYDROCARBON);

		// Bucket Handler
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);

		// Bone Meal Handler
		MinecraftForge.EVENT_BUS.register(new BoneMealHandler());

		// Proxy PreInit Method
		ExtraPlanets.proxy.preInit(event);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		// Register Biomes
		registerBiomes();

		// Initialization/Registering Methods For SolarSystems/Planets/Moons/SpaceStations
		ExtraPlanets_SolarSystems.init();
		ExtraPlanets_Planets.init();
		ExtraPlanets_Moons.init();
		ExtraPlanets_SpaceStations.init();

		// Initialization/Registering Methods For Entities
		registerNonMobEntities();
		registerCreatures();

		packetPipeline = ExtraPlanetsChannelHandler.init();

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

		// Register Recipes
		ExtraPlanets_Recipes.init();

		// Initialize/Register Achievements
		if (Config.ACHIEVEMENTS)
			ExtraPlanets_Achievements.init();

		// Register GUI Handler
		NetworkRegistry.INSTANCE.registerGuiHandler(ExtraPlanets.instance, new GuiHandler());

		// Proxy PostInit Method
		ExtraPlanets.proxy.postInit(event);
	}

	private void registerNonMobEntities() {
		if (Config.CERES && Config.NUCLEAR_BOMB)
			RegisterHelper.registerExtraPlanetsNonMobEntity(EntityNuclearBombPrimed.class, "NuclearBombPrimed", 150, 1, true);
		if (Config.SATURN && Config.FIRE_BOMB)
			RegisterHelper.registerExtraPlanetsNonMobEntity(EntityFireBombPrimed.class, "FireBombPrimed", 150, 1, true);
		if (Config.MERCURY)
			RegisterHelper.registerExtraPlanetsNonMobEntity(EntityTier4Rocket.class, "EntityTier4Rocket", 150, 1, false);
		if (Config.JUPITER)
			RegisterHelper.registerExtraPlanetsNonMobEntity(EntityTier5Rocket.class, "EntityTier5Rocket", 150, 1, false);
		if (Config.SATURN)
			RegisterHelper.registerExtraPlanetsNonMobEntity(EntityTier6Rocket.class, "EntityTier6Rocket", 150, 1, false);
		if (Config.URANUS)
			RegisterHelper.registerExtraPlanetsNonMobEntity(EntityTier7Rocket.class, "EntityTier7Rocket", 150, 1, false);
		if (Config.NEPTUNE)
			RegisterHelper.registerExtraPlanetsNonMobEntity(EntityTier8Rocket.class, "EntityTier8Rocket", 150, 1, false);
		if (Config.PLUTO)
			RegisterHelper.registerExtraPlanetsNonMobEntity(EntityTier9Rocket.class, "EntityTier9Rocket", 150, 1, false);
		if (Config.ERIS)
			RegisterHelper.registerExtraPlanetsNonMobEntity(EntityTier10Rocket.class, "EntityTier10Rocket", 150, 1, false);
		if (Config.ERIS && Config.KEPLER22B)
			RegisterHelper.registerExtraPlanetsNonMobEntity(EntityElectricRocket.class, "EntityTier10ElectricRocket", 150, 1, false);
		if (Config.MARS_ROVER)
			RegisterHelper.registerExtraPlanetsNonMobEntity(EntityMarsRover.class, "EntityMarsRover", 150, 1, false);
		if (Config.VENUS_ROVER)
			RegisterHelper.registerExtraPlanetsNonMobEntity(EntityVenusRover.class, "EntityVenusRover", 150, 1, false);
	}

	private void registerCreatures() {
		// Dungeon Bosses
		if (Config.MERCURY)
			if (Config.USE_DEFAULT_BOSSES)
				RegisterHelper.registerExtraPlanetsMobEntity(EntityCreeperBossMercury.class, "CreeperBossMercury", 894731, 0);
			else
				RegisterHelper.registerExtraPlanetsMobEntity(EntityEvolvedMagmaCubeBoss.class, "EvolvedMagmaCubeBoss", 3407872, 16579584);
		if (Config.JUPITER)
			if (Config.USE_DEFAULT_BOSSES)
				RegisterHelper.registerExtraPlanetsMobEntity(EntityCreeperBossJupiter.class, "CreeperBossJupiter", 894731, 0);
			else
				RegisterHelper.registerExtraPlanetsMobEntity(EntityEvolvedFireBatBoss.class, "EvolvedFireBatBoss", 16167425, 0);
		if (Config.SATURN)
			if (Config.USE_DEFAULT_BOSSES)
				RegisterHelper.registerExtraPlanetsMobEntity(EntityCreeperBossSaturn.class, "CreeperBossSaturn", 894731, 0);
			else
				RegisterHelper.registerExtraPlanetsMobEntity(EntityEvolvedGhastBoss.class, "EvolvedGhastBoss", 894731, 0);
		if (Config.URANUS)
			if (Config.USE_DEFAULT_BOSSES)
				RegisterHelper.registerExtraPlanetsMobEntity(EntityCreeperBossUranus.class, "CreeperBossUranus", 894731, 0);
			else
				RegisterHelper.registerExtraPlanetsMobEntity(EntityEvolvedIceSlimeBoss.class, "EvolvedIceSlimeBoss", 16382457, 44975);
		if (Config.NEPTUNE)
			if (Config.USE_DEFAULT_BOSSES)
				RegisterHelper.registerExtraPlanetsMobEntity(EntityCreeperBossNeptune.class, "CreeperBossNeptune", 894731, 0);
			else
				RegisterHelper.registerExtraPlanetsMobEntity(EntityEvolvedSnowmanBoss.class, "EvolvedSnowmanBoss", 894731, 0);
		if (Config.PLUTO)
			RegisterHelper.registerExtraPlanetsMobEntity(EntityCreeperBossPluto.class, "CreeperBossPluto", 894731, 0);
		if (Config.ERIS)
			RegisterHelper.registerExtraPlanetsMobEntity(EntityCreeperBossEris.class, "CreeperBossEris", 894731, 0);
	}

	public static void registerBiomes() {
		// Planets
		if (Config.MERCURY)
			Biome.registerBiome(Config.MERCURY_BIOME_ID, MercuryBiomes.mercury.getBiomeName(), MercuryBiomes.mercury);
		if (Config.CERES)
			Biome.registerBiome(Config.CERES_BIOME_ID, CeresBiomes.ceres.getBiomeName(), CeresBiomes.ceres);
		if (Config.JUPITER) {
			Biome.registerBiome(Config.JUPITER_BIOME_ID, JupiterBiomes.jupiter.getBiomeName(), JupiterBiomes.jupiter);
			Biome.registerBiome(Config.JUPITER_SEA_BIOME_ID, JupiterBiomes.jupiterMagmaSea.getBiomeName(), JupiterBiomes.jupiterMagmaSea);
		}
		if (Config.SATURN)
			Biome.registerBiome(Config.SATURN_BIOME_ID, SaturnBiomes.saturn.getBiomeName(), SaturnBiomes.saturn);
		if (Config.URANUS) {
			Biome.registerBiome(Config.URANUS_BIOME_ID, UranusBiomes.uranus.getBiomeName(), UranusBiomes.uranus);
			Biome.registerBiome(Config.URANUS_FROZEN_SEA_BIOME_ID, UranusBiomes.uranusFrozenWater.getBiomeName(), UranusBiomes.uranusFrozenWater);
			Biome.registerBiome(Config.URANUS_SNOW_LANDS_BIOME_ID, UranusBiomes.uranusSnowLands.getBiomeName(), UranusBiomes.uranusSnowLands);
		}
		if (Config.NEPTUNE)
			Biome.registerBiome(Config.NEPTUNE_BIOME_ID, NeptuneBiomes.neptune.getBiomeName(), NeptuneBiomes.neptune);
		if (Config.PLUTO)
			Biome.registerBiome(Config.PLUTO_BIOME_ID, PlutoBiomes.pluto.getBiomeName(), PlutoBiomes.pluto);
		if (Config.ERIS)
			Biome.registerBiome(Config.ERIS_BIOME_ID, ErisBiomes.eris.getBiomeName(), ErisBiomes.eris);
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			Biome.registerBiome(Config.KEPLER22B_PLAINS_BIOME_ID, BiomeGenBaseKepler22b.kepler22bPlains.getBiomeName(), BiomeGenBaseKepler22b.kepler22bPlains);
			Biome.registerBiome(Config.KEPLER22B_BLUE_FOREST_BIOME_ID, BiomeGenBaseKepler22b.kepler22bBlueForest.getBiomeName(), BiomeGenBaseKepler22b.kepler22bBlueForest);
			Biome.registerBiome(Config.KEPLER22B_RED_FOREST_BIOME_ID, BiomeGenBaseKepler22b.kepler22bRedForest.getBiomeName(), BiomeGenBaseKepler22b.kepler22bRedForest);
			Biome.registerBiome(Config.KEPLER22B_PURPLE_FOREST_BIOME_ID, BiomeGenBaseKepler22b.kepler22bPurpleForest.getBiomeName(), BiomeGenBaseKepler22b.kepler22bPurpleForest);
			Biome.registerBiome(Config.KEPLER22B_YELLOW_FOREST_BIOME_ID, BiomeGenBaseKepler22b.kepler22bYellowForest.getBiomeName(), BiomeGenBaseKepler22b.kepler22bYellowForest);
			Biome.registerBiome(Config.KEPLER22B_RED_DESERT_BIOME_ID, BiomeGenBaseKepler22b.kepler22bRedDesert.getBiomeName(), BiomeGenBaseKepler22b.kepler22bRedDesert);
		}
		// Moons
		if (Config.CALLISTO)
			Biome.registerBiome(Config.CALLISTO_BIOME_ID, CallistoBiomes.callisto.getBiomeName(), CallistoBiomes.callisto);
		if (Config.DEIMOS)
			Biome.registerBiome(Config.DEIMOS_BIOME_ID, DeimosBiomes.deimos.getBiomeName(), DeimosBiomes.deimos);
		if (Config.EUROPA)
			Biome.registerBiome(Config.EUROPA_BIOME_ID, EuropaBiomes.europa.getBiomeName(), EuropaBiomes.europa);
		if (Config.GANYMEDE)
			Biome.registerBiome(Config.GANTMEDE_BIOME_ID, GanymedeBiomes.ganymede.getBiomeName(), GanymedeBiomes.ganymede);
		if (Config.IAPETUS)
			Biome.registerBiome(Config.IAPETUS_BIOME_ID, IapetusBiomes.iapetus.getBiomeName(), IapetusBiomes.iapetus);
		if (Config.IO) {
			Biome.registerBiome(Config.IO_BIOME_ID, IoBiomes.io.getBiomeName(), IoBiomes.io);
			Biome.registerBiome(Config.IO_ASH_LANDS_BIOME_ID, IoBiomes.ioAshLands.getBiomeName(), IoBiomes.ioAshLands);
		}
		if (Config.OBERON) {
			Biome.registerBiome(Config.OBERON_BIOME_ID, OberonBiomes.oberon.getBiomeName(), OberonBiomes.oberon);
			Biome.registerBiome(Config.OBERON_LARGE_MOUNTAIN_BIOME_ID, OberonBiomes.oberonLargeMountain.getBiomeName(), OberonBiomes.oberonLargeMountain);
			Biome.registerBiome(Config.OBERON_LARGE_MOUNTAIN_BIOME_ID, OberonBiomes.oberonValleys.getBiomeName(), OberonBiomes.oberonValleys);
		}
		if (Config.PHOBOS)
			Biome.registerBiome(Config.PHOBOS_BIOME_ID, PhobosBiomes.phobos.getBiomeName(), PhobosBiomes.phobos);
		if (Config.RHEA)
			Biome.registerBiome(Config.RHEA_BIOME_ID, RheaBiomes.rhea.getBiomeName(), RheaBiomes.rhea);
		if (Config.TITAN) {
			Biome.registerBiome(Config.TITAN_BIOME_ID, TitanBiomes.titan.getBiomeName(), TitanBiomes.titan);
			Biome.registerBiome(Config.TITAN_SEA_BIOME_ID, TitanBiomes.titanMethaneSea.getBiomeName(), TitanBiomes.titanMethaneSea);
		}
		if (Config.TITANIA)
			Biome.registerBiome(Config.TITANIA_BIOME_ID, TitaniaBiomes.titania.getBiomeName(), TitaniaBiomes.titania);
		if (Config.TRITON) {
			Biome.registerBiome(Config.TRITON_BIOME_ID, TritonBiomes.triton.getBiomeName(), TritonBiomes.triton);
			Biome.registerBiome(Config.TRITON_ICE_LANDS_BIOME_ID, TritonBiomes.tritonIceLands.getBiomeName(), TritonBiomes.tritonIceLands);
			Biome.registerBiome(Config.TRITON_ICE_SEA_BIOME_ID, TritonBiomes.tritonIceSea.getBiomeName(), TritonBiomes.tritonIceSea);
		}
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
		if (Config.MERCURY)
			GalacticraftRegistry.addDungeonLoot(4, new ItemStack(ExtraPlanets_Items.TIER_4_SCHEMATIC, 1, 0));
		if (Config.JUPITER)
			GalacticraftRegistry.addDungeonLoot(5, new ItemStack(ExtraPlanets_Items.TIER_5_SCHEMATIC, 1, 0));
		if (Config.SATURN)
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
}
