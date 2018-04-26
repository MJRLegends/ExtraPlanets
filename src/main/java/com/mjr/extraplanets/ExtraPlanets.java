package com.mjr.extraplanets;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.tile.TileEntityDeconstructor;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import micdoodle8.mods.galacticraft.planets.asteroids.AsteroidsModule;
import micdoodle8.mods.galacticraft.planets.mars.MarsModule;
import micdoodle8.mods.galacticraft.planets.venus.VenusModule;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.RecipeSorter;

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
import com.mjr.extraplanets.entities.bosses.EntityEvolvedSpacemanBoss;
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
import com.mjr.extraplanets.handlers.MainHandlerServer;
import com.mjr.extraplanets.handlers.capabilities.CapabilityStatsHandler;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.items.armor.ExtraPlanets_Armor;
import com.mjr.extraplanets.items.armor.modules.ExtraPlanets_Modules;
import com.mjr.extraplanets.items.schematics.ItemSchematicMarsRover;
import com.mjr.extraplanets.items.schematics.ItemSchematicTier10ElectricRocket;
import com.mjr.extraplanets.items.schematics.ItemSchematicTier10Rocket;
import com.mjr.extraplanets.items.schematics.ItemSchematicTier4Rocket;
import com.mjr.extraplanets.items.schematics.ItemSchematicTier5Rocket;
import com.mjr.extraplanets.items.schematics.ItemSchematicTier6Rocket;
import com.mjr.extraplanets.items.schematics.ItemSchematicTier7Rocket;
import com.mjr.extraplanets.items.schematics.ItemSchematicTier8Rocket;
import com.mjr.extraplanets.items.schematics.ItemSchematicTier9Rocket;
import com.mjr.extraplanets.items.schematics.ItemSchematicVenusRover;
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
import com.mjr.extraplanets.planets.Ceres.spacestation.WorldProviderCeresOrbit;
import com.mjr.extraplanets.planets.Ceres.worldgen.CeresBiomes;
import com.mjr.extraplanets.planets.Eris.event.ErisEvents;
import com.mjr.extraplanets.planets.Eris.spacestation.WorldProviderErisOrbit;
import com.mjr.extraplanets.planets.Eris.worldgen.ErisBiomes;
import com.mjr.extraplanets.planets.Jupiter.event.JupiterEvents;
import com.mjr.extraplanets.planets.Jupiter.spacestation.WorldProviderJupiterOrbit;
import com.mjr.extraplanets.planets.Jupiter.worldgen.JupiterBiomes;
import com.mjr.extraplanets.planets.Kepler22b.event.Kepler22bEvents;
import com.mjr.extraplanets.planets.Kepler22b.spacestation.WorldProviderKepler22bOrbit;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.Kepler22bBiomes;
import com.mjr.extraplanets.planets.KuiperBelt.KuiperBeltEvents;
import com.mjr.extraplanets.planets.Mercury.event.MercuryEvents;
import com.mjr.extraplanets.planets.Mercury.spacestation.WorldProviderMercuryOrbit;
import com.mjr.extraplanets.planets.Mercury.worldgen.MercuryBiomes;
import com.mjr.extraplanets.planets.Neptune.event.NeptuneEvents;
import com.mjr.extraplanets.planets.Neptune.spacestation.WorldProviderNeptuneOrbit;
import com.mjr.extraplanets.planets.Neptune.worldgen.NeptuneBiomes;
import com.mjr.extraplanets.planets.Pluto.event.PlutoEvents;
import com.mjr.extraplanets.planets.Pluto.spacestation.WorldProviderPlutoOrbit;
import com.mjr.extraplanets.planets.Pluto.worldgen.PlutoBiomes;
import com.mjr.extraplanets.planets.Saturn.event.SaturnEvents;
import com.mjr.extraplanets.planets.Saturn.spacestation.WorldProviderSaturnOrbit;
import com.mjr.extraplanets.planets.Saturn.worldgen.SaturnBiomes;
import com.mjr.extraplanets.planets.Uranus.event.UranusEvents;
import com.mjr.extraplanets.planets.Uranus.spacestation.WorldProviderUranusOrbit;
import com.mjr.extraplanets.planets.Uranus.worldgen.UranusBiomes;
import com.mjr.extraplanets.planets.mars.spacestation.WorldProviderMarsOrbit;
import com.mjr.extraplanets.planets.venus.spacestation.WorldProviderVenusOrbit;
import com.mjr.extraplanets.proxy.CommonProxy;
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
import com.mjr.extraplanets.schematicPages.SchematicTier10ElectricRocket;
import com.mjr.extraplanets.schematicPages.SchematicTier10Rocket;
import com.mjr.extraplanets.schematicPages.SchematicTier4Rocket;
import com.mjr.extraplanets.schematicPages.SchematicTier5Rocket;
import com.mjr.extraplanets.schematicPages.SchematicTier6Rocket;
import com.mjr.extraplanets.schematicPages.SchematicTier7Rocket;
import com.mjr.extraplanets.schematicPages.SchematicTier8Rocket;
import com.mjr.extraplanets.schematicPages.SchematicTier9Rocket;
import com.mjr.extraplanets.schematicPages.SchematicVenusRover;
import com.mjr.mjrlegendslib.recipe.ShapedNBTRecipe;
import com.mjr.mjrlegendslib.util.MessageUtilities;
import com.mjr.mjrlegendslib.util.NetworkUtilities;
import com.mjr.mjrlegendslib.util.RegisterUtilities;

@Mod(modid = Constants.modID, name = Constants.modName, version = Constants.modVersion, dependencies = Constants.DEPENDENCIES_FORGE + Constants.DEPENDENCIES_MODS, guiFactory = Constants.GUIFACTORY, certificateFingerprint = Constants.CERTIFICATEFINGERPRINT)
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
			if (Config.MERCURY && Config.ITEMS_CARBON)
				return ExtraPlanets_Tools.CARBON_PICKAXE;
			else if (Config.JUPITER && Config.ITEMS_PALLADIUM)
				return ExtraPlanets_Tools.PALLADIUM_PICKAXE;
			else if (Config.SATURN && Config.ITEMS_MAGNESIUM)
				return ExtraPlanets_Tools.MAGNESIUM_PICKAXE;
			else if (Config.URANUS && Config.ITEMS_CRYSTAL)
				return ExtraPlanets_Tools.CRYSTAL_PICKAXE;
			return GCItems.steelPickaxe;
		}
	};
	// Armour Creative Tab
	public static CreativeTabs ArmorTab = new CreativeTabs("SpaceArmorTab") {
		@Override
		public Item getTabIconItem() {
			if (Config.MERCURY && Config.ITEMS_CARBON)
				return ExtraPlanets_Armor.CARBON_CHEST;
			else if (Config.JUPITER && Config.ITEMS_PALLADIUM)
				return ExtraPlanets_Armor.PALLASIUM_CHEST;
			else if (Config.SATURN && Config.ITEMS_MAGNESIUM)
				return ExtraPlanets_Armor.MAGNESIUM_CHEST;
			else if (Config.URANUS && Config.ITEMS_CRYSTAL)
				return ExtraPlanets_Armor.CRYSTAL_CHEST;
			return GCItems.steelChestplate;
		}
	};

	static {
		ExtraPlanets_Fluids.initFluid();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
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

		// Bone Meal Handler
		RegisterUtilities.registerEventHandler(new BoneMealHandler());

		// Proxy PreInit Method
		ExtraPlanets.proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		// Register Fluid Submerged Textures
		registerFluidSubmergedTextures();

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
		// Register Modules
		ExtraPlanets_Modules.init();

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
		NetworkUtilities.registerGuiHandler(ExtraPlanets.instance, new GuiHandler());

		// Register Deconstructor Compatibility
		if (Config.GC_DECONSTRUCTOR_SUPPORT)
			RegisterDeconstructorCompatibility();

		// Register Extreme Reactors Compatibility
		if (Config.EXTREME_REACTORS_SUPPORT)
			ExtremeReactorsCompatibility.init();

		// Register MC MultiPart Compatibility
		if (Config.MC_MULITPART_SUPPORT)
			MCMultiPartCompatibility.init();

		// Register Custom Recipe Type
		RecipeSorter.register("extraplanets:shapedNBTRecipe", ShapedNBTRecipe.class, RecipeSorter.Category.SHAPED, "before:minecraft:shaped");

		if (Config.GC_PRESSURE || Config.GC_RADIATION) {
			MarsModule.planetMars.addChecklistKeys("space_suit");
			GalacticraftCore.moonMoon.addChecklistKeys("space_suit");
			VenusModule.planetVenus.addChecklistKeys("space_suit");
			AsteroidsModule.planetAsteroids.addChecklistKeys("space_suit");
		}

		// Get DimensionTypes from GC Auto Registering
		ExtraPlanetsDimensions.CERES = WorldUtil.getDimensionTypeById(Config.CERES_ID);
		ExtraPlanetsDimensions.ERIS = WorldUtil.getDimensionTypeById(Config.ERIS_ID);
		ExtraPlanetsDimensions.JUPITER = WorldUtil.getDimensionTypeById(Config.JUPITER_ID);
		ExtraPlanetsDimensions.MERCURY = WorldUtil.getDimensionTypeById(Config.MERCURY_ID);
		ExtraPlanetsDimensions.NEPTUNE = WorldUtil.getDimensionTypeById(Config.NEPTUNE_ID);
		ExtraPlanetsDimensions.PLUTO = WorldUtil.getDimensionTypeById(Config.PLUTO_ID);
		ExtraPlanetsDimensions.SATURN = WorldUtil.getDimensionTypeById(Config.SATURN_ID);
		ExtraPlanetsDimensions.URANUS = WorldUtil.getDimensionTypeById(Config.URANUS_ID);
		ExtraPlanetsDimensions.KEPLER22B = WorldUtil.getDimensionTypeById(Config.KEPLER22B_ID);

		ExtraPlanetsDimensions.CALLISTO = WorldUtil.getDimensionTypeById(Config.CALLISTO_ID);
		ExtraPlanetsDimensions.DEIMOS = WorldUtil.getDimensionTypeById(Config.DEIMOS_ID);
		ExtraPlanetsDimensions.EUROPA = WorldUtil.getDimensionTypeById(Config.EUROPA_ID);
		ExtraPlanetsDimensions.GANYMEDE = WorldUtil.getDimensionTypeById(Config.GANYMEDE_ID);
		ExtraPlanetsDimensions.IAPETUS = WorldUtil.getDimensionTypeById(Config.IAPETUS_ID);
		ExtraPlanetsDimensions.IO = WorldUtil.getDimensionTypeById(Config.IO_ID);
		ExtraPlanetsDimensions.OBERON = WorldUtil.getDimensionTypeById(Config.OBERON_ID);
		ExtraPlanetsDimensions.PHOBOS = WorldUtil.getDimensionTypeById(Config.PHOBOS_ID);
		ExtraPlanetsDimensions.RHEA = WorldUtil.getDimensionTypeById(Config.RHEA_ID);
		ExtraPlanetsDimensions.TITAN = WorldUtil.getDimensionTypeById(Config.TITAN_ID);
		ExtraPlanetsDimensions.TITANIA = WorldUtil.getDimensionTypeById(Config.TITANIA_ID);
		ExtraPlanetsDimensions.TRITION = WorldUtil.getDimensionTypeById(Config.TRITON_ID);

		// Register DimensionTypes for Space Stations
		ExtraPlanetsDimensions.CERES_ORBIT = DimensionType.register("Ceres Space Station", "_ceres_orbit", Config.CERES_SPACE_STATION_ID, WorldProviderCeresOrbit.class, false);
		ExtraPlanetsDimensions.ERIS_ORBIT = DimensionType.register("Eris Space Station", "_eris_orbit", Config.ERIS_SPACE_STATION_ID, WorldProviderErisOrbit.class, false);
		ExtraPlanetsDimensions.JUPITER_ORBIT = DimensionType.register("Jupiter Space Station", "_jupiter_orbit", Config.JUPITER_SPACE_STATION_ID, WorldProviderJupiterOrbit.class, false);
		ExtraPlanetsDimensions.MERCURY_ORBIT = DimensionType.register("Mercury Space Station", "_mercury_orbit", Config.MERCURY_SPACE_STATION_ID, WorldProviderMercuryOrbit.class, false);
		ExtraPlanetsDimensions.NEPTUNE_ORBIT = DimensionType.register("Neptune Space Station", "_neptune_orbit", Config.NEPTUNE_SPACE_STATION_ID, WorldProviderNeptuneOrbit.class, false);
		ExtraPlanetsDimensions.PLUTO_ORBIT = DimensionType.register("Pluto Space Station", "_pluto_orbit", Config.PLUTO_SPACE_STATION_ID, WorldProviderPlutoOrbit.class, false);
		ExtraPlanetsDimensions.SATURN_ORBIT = DimensionType.register("Saturn Space Station", "_saturn_orbit", Config.SATURN_SPACE_STATION_ID, WorldProviderSaturnOrbit.class, false);
		ExtraPlanetsDimensions.URANUS_ORBIT = DimensionType.register("Uranus Space Station", "_uranus_orbit", Config.URANUS_SPACE_STATION_ID, WorldProviderUranusOrbit.class, false);
		ExtraPlanetsDimensions.KEPLER22B_ORBIT = DimensionType.register("Kepler22b Space Station", "orbit", Config.KEPLER22B_SPACE_STATION_ID, WorldProviderKepler22bOrbit.class, false);
		ExtraPlanetsDimensions.MARS_ORBIT = DimensionType.register("Mars Space Station", "_mars_orbit", Config.MARS_SPACE_STATION_ID, WorldProviderMarsOrbit.class, false);
		ExtraPlanetsDimensions.VENUS_ORBIT = DimensionType.register("Venus Space Station", "_venus_orbit", Config.VENUS_SPACE_STATION_ID, WorldProviderVenusOrbit.class, false);

		ExtraPlanetsDimensions.CERES_ORBIT = DimensionType.register("Ceres Space Station", "_ceres_orbit", Config.CERES_SPACE_STATION_STATIC_ID, WorldProviderCeresOrbit.class, true);
		ExtraPlanetsDimensions.ERIS_ORBIT = DimensionType.register("Eris Space Station", "_eris_orbit", Config.ERIS_SPACE_STATION_STATIC_ID, WorldProviderErisOrbit.class, true);
		ExtraPlanetsDimensions.JUPITER_ORBIT = DimensionType.register("Jupiter Space Station", "_jupiter_orbit", Config.JUPITER_SPACE_STATION_STATIC_ID, WorldProviderJupiterOrbit.class, true);
		ExtraPlanetsDimensions.MERCURY_ORBIT = DimensionType.register("Mercury Space Station", "_mercury_orbit", Config.MERCURY_SPACE_STATION_STATIC_ID, WorldProviderMercuryOrbit.class, true);
		ExtraPlanetsDimensions.NEPTUNE_ORBIT = DimensionType.register("Neptune Space Station", "_neptune_orbit", Config.NEPTUNE_SPACE_STATION_STATIC_ID, WorldProviderNeptuneOrbit.class, true);
		ExtraPlanetsDimensions.PLUTO_ORBIT = DimensionType.register("Pluto Space Station", "_pluto_orbit", Config.PLUTO_SPACE_STATION_STATIC_ID, WorldProviderPlutoOrbit.class, true);
		ExtraPlanetsDimensions.SATURN_ORBIT = DimensionType.register("Saturn Space Station", "_saturn_orbit", Config.SATURN_SPACE_STATION_STATIC_ID, WorldProviderSaturnOrbit.class, true);
		ExtraPlanetsDimensions.URANUS_ORBIT = DimensionType.register("Uranus Space Station", "_uranus_orbit", Config.URANUS_SPACE_STATION_STATIC_ID, WorldProviderUranusOrbit.class, true);
		ExtraPlanetsDimensions.KEPLER22B_ORBIT = DimensionType.register("Kepler22b Space Station", "orbit", Config.KEPLER22B_SPACE_STATION_STATIC_ID, WorldProviderKepler22bOrbit.class, true);
		ExtraPlanetsDimensions.MARS_ORBIT = DimensionType.register("Mars Space Station", "_mars_orbit", Config.MARS_SPACE_STATION_STATIC_ID, WorldProviderMarsOrbit.class, true);
		ExtraPlanetsDimensions.VENUS_ORBIT = DimensionType.register("Venus Space Station", "_venus_orbit", Config.VENUS_SPACE_STATION_STATIC_ID, WorldProviderVenusOrbit.class, true);

		// Proxy PostInit Method
		ExtraPlanets.proxy.postInit(event);
	}

	private void registerNonMobEntities() {
		if (Config.CERES && Config.NUCLEAR_BOMB)
			RegisterUtilities.registerNonMobEntity(ExtraPlanets.instance, EntityNuclearBombPrimed.class, "NuclearBombPrimed", 150, 1, true);
		if (Config.SATURN && Config.FIRE_BOMB)
			RegisterUtilities.registerNonMobEntity(ExtraPlanets.instance, EntityFireBombPrimed.class, "FireBombPrimed", 150, 1, true);
		if (Config.MERCURY) {
			RegisterUtilities.registerNonMobEntity(ExtraPlanets.instance, EntityTier4Rocket.class, "EntityTier4Rocket", 150, 1, false);
			RegisterUtilities.registerNonMobEntity(ExtraPlanets.instance, EntityMercuryLander.class, "EntityMercuryLander", 150, 5, false);
		}
		if (Config.JUPITER) {
			RegisterUtilities.registerNonMobEntity(ExtraPlanets.instance, EntityTier5Rocket.class, "EntityTier5Rocket", 150, 1, false);
			RegisterUtilities.registerNonMobEntity(ExtraPlanets.instance, EntityJupiterLander.class, "EntityJupiterLander", 150, 5, false);
		}
		if (Config.SATURN) {
			RegisterUtilities.registerNonMobEntity(ExtraPlanets.instance, EntityTier6Rocket.class, "EntityTier6Rocket", 150, 1, false);
			RegisterUtilities.registerNonMobEntity(ExtraPlanets.instance, EntitySaturnLander.class, "EntitySaturnLander", 150, 5, false);
		}
		if (Config.URANUS) {
			RegisterUtilities.registerNonMobEntity(ExtraPlanets.instance, EntityTier7Rocket.class, "EntityTier7Rocket", 150, 1, false);
			RegisterUtilities.registerNonMobEntity(ExtraPlanets.instance, EntityUranusLander.class, "EntityUranusLander", 150, 5, false);
		}
		if (Config.NEPTUNE) {
			RegisterUtilities.registerNonMobEntity(ExtraPlanets.instance, EntityTier8Rocket.class, "EntityTier8Rocket", 150, 1, false);
			RegisterUtilities.registerNonMobEntity(ExtraPlanets.instance, EntityNeptuneLander.class, "EntityNeptuneLander", 150, 5, false);
		}
		if (Config.PLUTO)
			RegisterUtilities.registerNonMobEntity(ExtraPlanets.instance, EntityTier9Rocket.class, "EntityTier9Rocket", 150, 1, false);
		if (Config.ERIS)
			RegisterUtilities.registerNonMobEntity(ExtraPlanets.instance, EntityTier10Rocket.class, "EntityTier10Rocket", 150, 1, false);
		if (Config.ERIS && Config.KEPLER22B && Config.ELECTRIC_ROCKET)
			RegisterUtilities.registerNonMobEntity(ExtraPlanets.instance, EntityElectricRocket.class, "EntityTier10ElectricRocket", 150, 1, false);
		if (Config.MARS_ROVER)
			RegisterUtilities.registerNonMobEntity(ExtraPlanets.instance, EntityMarsRover.class, "EntityMarsRover", 150, 1, false);
		if (Config.VENUS_ROVER)
			RegisterUtilities.registerNonMobEntity(ExtraPlanets.instance, EntityVenusRover.class, "EntityVenusRover", 150, 1, false);
		RegisterUtilities.registerNonMobEntity(ExtraPlanets.instance, EntityGeneralLander.class, "EntityGeneralLander", 150, 5, false);
	}

	private void registerCreatures() {
		// Dungeon Bosses
		if (Config.MERCURY)
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerMobEntity(ExtraPlanets.instance, EntityCreeperBossMercury.class, "CreeperBossMercury", 894731, 0);
			else
				RegisterUtilities.registerMobEntity(ExtraPlanets.instance, EntityEvolvedMagmaCubeBoss.class, "EvolvedMagmaCubeBoss", 3407872, 16579584);
		if (Config.JUPITER)
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerMobEntity(ExtraPlanets.instance, EntityCreeperBossJupiter.class, "CreeperBossJupiter", 894731, 0);
			else
				RegisterUtilities.registerMobEntity(ExtraPlanets.instance, EntityEvolvedFireBatBoss.class, "EvolvedFireBatBoss", 16167425, 0);
		if (Config.SATURN)
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerMobEntity(ExtraPlanets.instance, EntityCreeperBossSaturn.class, "CreeperBossSaturn", 894731, 0);
			else
				RegisterUtilities.registerMobEntity(ExtraPlanets.instance, EntityEvolvedGhastBoss.class, "EvolvedGhastBoss", 894731, 0);
		if (Config.URANUS)
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerMobEntity(ExtraPlanets.instance, EntityCreeperBossUranus.class, "CreeperBossUranus", 894731, 0);
			else
				RegisterUtilities.registerMobEntity(ExtraPlanets.instance, EntityEvolvedIceSlimeBoss.class, "EvolvedIceSlimeBoss", 16382457, 44975);
		if (Config.NEPTUNE)
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerMobEntity(ExtraPlanets.instance, EntityCreeperBossNeptune.class, "CreeperBossNeptune", 894731, 0);
			else
				RegisterUtilities.registerMobEntity(ExtraPlanets.instance, EntityEvolvedSnowmanBoss.class, "EvolvedSnowmanBoss", 894731, 0);
		if (Config.PLUTO)
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerMobEntity(ExtraPlanets.instance, EntityCreeperBossPluto.class, "CreeperBossPluto", 894731, 0);
			else
				RegisterUtilities.registerMobEntity(ExtraPlanets.instance, EntityEvolvedSpacemanBoss.class, "EvolvedSpaceManBoss", 894731, 0);
		if (Config.ERIS)
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerMobEntity(ExtraPlanets.instance, EntityCreeperBossEris.class, "CreeperBossEris", 894731, 0);
			else
				RegisterUtilities.registerMobEntity(ExtraPlanets.instance, EntityEvolvedGiantZombieBoss.class, "EvolvedGiantZombieBoss", 894731, 0);
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

	public static void registerBiomes() {
		// Planets
		if (Config.MERCURY)
			Biome.registerBiome(Config.MERCURY_BIOME_ID, MercuryBiomes.mercury.getBiomeName(), MercuryBiomes.mercury);
		if (Config.CERES)
			Biome.registerBiome(Config.CERES_BIOME_ID, CeresBiomes.ceres.getBiomeName(), CeresBiomes.ceres);
		if (Config.JUPITER) {
			Biome.registerBiome(Config.JUPITER_BIOME_ID, JupiterBiomes.jupiter.getBiomeName(), JupiterBiomes.jupiter);
			Biome.registerBiome(Config.JUPITER_SEA_BIOME_ID, JupiterBiomes.jupiterMagmaSea.getBiomeName(), JupiterBiomes.jupiterMagmaSea);
			Biome.registerBiome(Config.JUPITER_SANDS_BIOME_ID, JupiterBiomes.jupiterSands.getBiomeName(), JupiterBiomes.jupiterSands);
		}
		if (Config.SATURN) {
			Biome.registerBiome(Config.SATURN_BIOME_ID, SaturnBiomes.saturn.getBiomeName(), SaturnBiomes.saturn);
			Biome.registerBiome(Config.SATURN_HYDROCARBON_SEA_BIOME_ID, SaturnBiomes.saturnHydroCarbonSea.getBiomeName(), SaturnBiomes.saturnHydroCarbonSea);
			Biome.registerBiome(Config.SATURN_NUCLEAR_LAND_BIOME_ID, SaturnBiomes.saturnNuclearLand.getBiomeName(), SaturnBiomes.saturnNuclearLand);
		}
		if (Config.URANUS) {
			Biome.registerBiome(Config.URANUS_BIOME_ID, UranusBiomes.uranus.getBiomeName(), UranusBiomes.uranus);
			Biome.registerBiome(Config.URANUS_FROZEN_SEA_BIOME_ID, UranusBiomes.uranusFrozenWater.getBiomeName(), UranusBiomes.uranusFrozenWater);
			Biome.registerBiome(Config.URANUS_SNOW_LANDS_BIOME_ID, UranusBiomes.uranusSnowLands.getBiomeName(), UranusBiomes.uranusSnowLands);
		}
		if (Config.NEPTUNE) {
			Biome.registerBiome(Config.NEPTUNE_BIOME_ID, NeptuneBiomes.neptune.getBiomeName(), NeptuneBiomes.neptune);
			Biome.registerBiome(Config.NEPTUNE_RADIO_ACTIVE_WATER_SEA_BIOME_ID, NeptuneBiomes.neptuneRadioActiveWaterSea.getBiomeName(), NeptuneBiomes.neptuneRadioActiveWaterSea);
			Biome.registerBiome(Config.NEPTUNE_LAYERED_HILLS_BIOME_ID, NeptuneBiomes.neptuneLayeredHills.getBiomeName(), NeptuneBiomes.neptuneLayeredHills);
		}
		if (Config.PLUTO)
			Biome.registerBiome(Config.PLUTO_BIOME_ID, PlutoBiomes.pluto.getBiomeName(), PlutoBiomes.pluto);
		if (Config.ERIS)
			Biome.registerBiome(Config.ERIS_BIOME_ID, ErisBiomes.eris.getBiomeName(), ErisBiomes.eris);
		if (Config.KEPLER22B && Config.KEPLER_SOLAR_SYSTEMS) {
			Biome.registerBiome(Config.KEPLER22B_PLAINS_BIOME_ID, Kepler22bBiomes.kepler22bPlains.getBiomeName(), Kepler22bBiomes.kepler22bPlains);
			Biome.registerBiome(Config.KEPLER22B_BLUE_FOREST_BIOME_ID, Kepler22bBiomes.kepler22bBlueForest.getBiomeName(), Kepler22bBiomes.kepler22bBlueForest);
			Biome.registerBiome(Config.KEPLER22B_RED_FOREST_BIOME_ID, Kepler22bBiomes.kepler22bRedForest.getBiomeName(), Kepler22bBiomes.kepler22bRedForest);
			Biome.registerBiome(Config.KEPLER22B_PURPLE_FOREST_BIOME_ID, Kepler22bBiomes.kepler22bPurpleForest.getBiomeName(), Kepler22bBiomes.kepler22bPurpleForest);
			Biome.registerBiome(Config.KEPLER22B_YELLOW_FOREST_BIOME_ID, Kepler22bBiomes.kepler22bYellowForest.getBiomeName(), Kepler22bBiomes.kepler22bYellowForest);
			Biome.registerBiome(Config.KEPLER22B_RED_DESERT_BIOME_ID, Kepler22bBiomes.kepler22bRedDesert.getBiomeName(), Kepler22bBiomes.kepler22bRedDesert);
			Biome.registerBiome(Config.KEPLER22B_WASTE_LANDS_BIOME_ID, Kepler22bBiomes.kepler22bWasteLands.getBiomeName(), Kepler22bBiomes.kepler22bWasteLands);
			Biome.registerBiome(Config.KEPLER22B_CANDY_LAND_BIOME_ID, Kepler22bBiomes.kepler22bCandyLand.getBiomeName(), Kepler22bBiomes.kepler22bCandyLand);
			Biome.registerBiome(Config.KEPLER22B_DIAMOND_PLAINS_BIOME_ID, Kepler22bBiomes.kepler22bDiamondPlains.getBiomeName(), Kepler22bBiomes.kepler22bDiamondPlains);
			Biome.registerBiome(Config.KEPLER22B_COAL_PLAINS_BIOME_ID, Kepler22bBiomes.kepler22bCoalPlains.getBiomeName(), Kepler22bBiomes.kepler22bCoalPlains);
			Biome.registerBiome(Config.KEPLER22B_IRON_PLAINS_BIOME_ID, Kepler22bBiomes.kepler22bIronPlains.getBiomeName(), Kepler22bBiomes.kepler22bIronPlains);
			Biome.registerBiome(Config.KEPLER22B_GOLD_PLAINS_BIOME_ID, Kepler22bBiomes.kepler22bGoldPlains.getBiomeName(), Kepler22bBiomes.kepler22bGoldPlains);
			Biome.registerBiome(Config.KEPLER22B_EMERALD_PLAINS_BIOME_ID, Kepler22bBiomes.kepler22bEmeraldPlains.getBiomeName(), Kepler22bBiomes.kepler22bEmeraldPlains);
		}
		// Moons
		if (Config.CALLISTO) {
			Biome.registerBiome(Config.CALLISTO_BIOME_ID, CallistoBiomes.callisto.getBiomeName(), CallistoBiomes.callisto);
			Biome.registerBiome(Config.CALLISTO_LARGE_SHALE_MOUNTAINS_BIOME_ID, CallistoBiomes.callistoShaleLargeMountains.getBiomeName(), CallistoBiomes.callistoShaleLargeMountains);
			Biome.registerBiome(Config.CALLISTO_SALT_SEA_BIOME_ID, CallistoBiomes.callistoSaltSea.getBiomeName(), CallistoBiomes.callistoSaltSea);
			Biome.registerBiome(Config.CALLISTO_SMALL_SHALE_MOUNTAINS_BIOME_ID, CallistoBiomes.callistoShaleSmallMountains.getBiomeName(), CallistoBiomes.callistoShaleSmallMountains);
		}
		if (Config.DEIMOS)
			Biome.registerBiome(Config.DEIMOS_BIOME_ID, DeimosBiomes.deimos.getBiomeName(), DeimosBiomes.deimos);
		if (Config.EUROPA) {
			Biome.registerBiome(Config.EUROPA_BIOME_ID, EuropaBiomes.europa.getBiomeName(), EuropaBiomes.europa);
			Biome.registerBiome(Config.EUROPA_SALT_SEA_BIOME_ID, EuropaBiomes.europaSaltSea.getBiomeName(), EuropaBiomes.europaSaltSea);
			Biome.registerBiome(Config.EUROPA_ICE_VALLEYS_BIOME_ID, EuropaBiomes.europaIceValleys.getBiomeName(), EuropaBiomes.europaIceValleys);
		}
		if (Config.GANYMEDE)
			Biome.registerBiome(Config.GANYMEDE_BIOME_ID, GanymedeBiomes.ganymede.getBiomeName(), GanymedeBiomes.ganymede);
		if (Config.IAPETUS)
			Biome.registerBiome(Config.IAPETUS_BIOME_ID, IapetusBiomes.iapetus.getBiomeName(), IapetusBiomes.iapetus);
		if (Config.IO) {
			Biome.registerBiome(Config.IO_BIOME_ID, IoBiomes.io.getBiomeName(), IoBiomes.io);
			Biome.registerBiome(Config.IO_ASH_LANDS_BIOME_ID, IoBiomes.ioAshLands.getBiomeName(), IoBiomes.ioAshLands);
			Biome.registerBiome(Config.IO_BURNING_PLAINS_BIOME_ID, IoBiomes.ioBurningPlains.getBiomeName(), IoBiomes.ioBurningPlains);
		}
		if (Config.OBERON) {
			Biome.registerBiome(Config.OBERON_BIOME_ID, OberonBiomes.oberon.getBiomeName(), OberonBiomes.oberon);
			Biome.registerBiome(Config.OBERON_LARGE_MOUNTAIN_BIOME_ID, OberonBiomes.oberonLargeMountain.getBiomeName(), OberonBiomes.oberonLargeMountain);
			Biome.registerBiome(Config.OBERON_VALLEYS_BIOME_ID, OberonBiomes.oberonValleys.getBiomeName(), OberonBiomes.oberonValleys);
		}
		if (Config.PHOBOS)
			Biome.registerBiome(Config.PHOBOS_BIOME_ID, PhobosBiomes.phobos.getBiomeName(), PhobosBiomes.phobos);
		if (Config.RHEA)
			Biome.registerBiome(Config.RHEA_BIOME_ID, RheaBiomes.rhea.getBiomeName(), RheaBiomes.rhea);
		if (Config.TITAN) {
			Biome.registerBiome(Config.TITAN_BIOME_ID, TitanBiomes.titan.getBiomeName(), TitanBiomes.titan);
			Biome.registerBiome(Config.TITAN_METHANE_HILLS_BIOME_ID, TitanBiomes.titanMethaneHills.getBiomeName(), TitanBiomes.titanMethaneHills);
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
		if (Config.ERIS && Config.KEPLER22B && Config.ELECTRIC_ROCKET)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier10ElectricRocket());
		if (Config.MARS_ROVER)
			SchematicRegistry.registerSchematicRecipe(new SchematicMarsRover());
		if (Config.VENUS_ROVER)
			SchematicRegistry.registerSchematicRecipe(new SchematicVenusRover());
	}

	private void registerSchematicsItems() {
		ItemSchematicTier4Rocket.registerSchematicItems();
		ItemSchematicTier5Rocket.registerSchematicItems();
		ItemSchematicTier6Rocket.registerSchematicItems();
		ItemSchematicTier7Rocket.registerSchematicItems();
		ItemSchematicTier8Rocket.registerSchematicItems();
		ItemSchematicTier9Rocket.registerSchematicItems();
		ItemSchematicTier10Rocket.registerSchematicItems();
		ItemSchematicTier10ElectricRocket.registerSchematicItems();
		ItemSchematicVenusRover.registerSchematicItems();
		ItemSchematicMarsRover.registerSchematicItems();
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
		if (Config.ERIS && Config.KEPLER22B && Config.ELECTRIC_ROCKET)
			GalacticraftRegistry.addDungeonLoot(10, new ItemStack(ExtraPlanets_Items.TIER_10_ELECTRIC_ROCKET_SCHEMATIC, 1, 0));
		if (Config.MARS_ROVER)
			GalacticraftRegistry.addDungeonLoot(2, new ItemStack(ExtraPlanets_Items.MARS_ROVER_SCHEMATIC, 1, 0));
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

	@EventHandler
	public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
		MessageUtilities.fatalErrorMessageToLog(Constants.modID, "Invalid fingerprint detected! The file " + event.getSource().getName() + " may have been tampered with. This version will NOT be supported!");
	}
}
