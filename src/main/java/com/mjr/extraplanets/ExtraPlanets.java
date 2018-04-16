package com.mjr.extraplanets;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.tile.TileEntityDeconstructor;
import micdoodle8.mods.galacticraft.planets.asteroids.AsteroidsModule;
import micdoodle8.mods.galacticraft.planets.mars.MarsModule;
import micdoodle8.mods.galacticraft.planets.venus.VenusModule;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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
import com.mjr.extraplanets.moons.Deimos.event.DeimosEvents;
import com.mjr.extraplanets.moons.Europa.event.EuropaEvents;
import com.mjr.extraplanets.moons.Ganymede.event.GanymedeEvents;
import com.mjr.extraplanets.moons.Iapetus.event.IapetusEvents;
import com.mjr.extraplanets.moons.Io.event.IoEvents;
import com.mjr.extraplanets.moons.Oberon.event.OberonEvents;
import com.mjr.extraplanets.moons.Phobos.event.PhobosEvents;
import com.mjr.extraplanets.moons.Rhea.event.RheaEvents;
import com.mjr.extraplanets.moons.Titan.event.TitanEvents;
import com.mjr.extraplanets.moons.Titania.event.TitaniaEvents;
import com.mjr.extraplanets.moons.Triton.event.TritonEvents;
import com.mjr.extraplanets.network.ExtraPlanetsChannelHandler;
import com.mjr.extraplanets.planets.ExtraPlanets_Planets;
import com.mjr.extraplanets.planets.ExtraPlanets_SpaceStations;
import com.mjr.extraplanets.planets.Ceres.event.CeresEvents;
import com.mjr.extraplanets.planets.Eris.event.ErisEvents;
import com.mjr.extraplanets.planets.Jupiter.event.JupiterEvents;
import com.mjr.extraplanets.planets.Kepler22b.event.Kepler22bEvents;
import com.mjr.extraplanets.planets.KuiperBelt.KuiperBeltEvents;
import com.mjr.extraplanets.planets.Mercury.event.MercuryEvents;
import com.mjr.extraplanets.planets.Neptune.event.NeptuneEvents;
import com.mjr.extraplanets.planets.Pluto.event.PlutoEvents;
import com.mjr.extraplanets.planets.Saturn.event.SaturnEvents;
import com.mjr.extraplanets.planets.Uranus.event.UranusEvents;
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
import com.mjr.extraplanets.schematicPages.SchematicTier10ElectricRocket;
import com.mjr.extraplanets.schematicPages.SchematicTier10Rocket;
import com.mjr.extraplanets.schematicPages.SchematicTier4Rocket;
import com.mjr.extraplanets.schematicPages.SchematicTier5Rocket;
import com.mjr.extraplanets.schematicPages.SchematicTier6Rocket;
import com.mjr.extraplanets.schematicPages.SchematicTier7Rocket;
import com.mjr.extraplanets.schematicPages.SchematicTier8Rocket;
import com.mjr.extraplanets.schematicPages.SchematicTier9Rocket;
import com.mjr.extraplanets.schematicPages.SchematicVenusRover;
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

	// Generate recipe JSON's (For use in Dev Workspace Only)
	public static boolean generateRecipes = false;

	// Block/Item/Biome Events Registering Lists
	public static List<Item> itemList = new ArrayList<>();
	public static List<Block> blocksList = new ArrayList<>();
	public static List<BiomeGenBaseGC> biomesList = new ArrayList<>();

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

		// Initialization/Registering Methods For SolarSystems/Planets/Moons/SpaceStations
		ExtraPlanets_SolarSystems.init();
		ExtraPlanets_Planets.init();
		ExtraPlanets_Moons.init();
		ExtraPlanets_SpaceStations.init();

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

		// Initialize/Register Achievements
		// if (Config.ACHIEVEMENTS)
		// ExtraPlanets_Achievements.init();

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

		// Generate recipe JSON's (For use in Dev Workspace Only)
		if (generateRecipes) {
			ExtraPlanets_RecipeGeneration.generate();
			ExtraPlanets_RecipeGeneration.generateConstants();
		}

		if (Config.GC_PRESSURE || Config.GC_RADIATION) {
			MarsModule.planetMars.addChecklistKeys("space_suit");
			GalacticraftCore.moonMoon.addChecklistKeys("space_suit");
			VenusModule.planetVenus.addChecklistKeys("space_suit");
			AsteroidsModule.planetAsteroids.addChecklistKeys("space_suit");
		}

		// Proxy PostInit Method
		ExtraPlanets.proxy.postInit(event);
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
		if (Config.ERIS && Config.KEPLER22B && Config.ELECTRIC_ROCKET)
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
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerMobEntity(Constants.modID, ExtraPlanets.instance, EntityCreeperBossPluto.class, Constants.modID + "." + "CreeperBossPluto", 894731, 0);
			else
				RegisterUtilities.registerMobEntity(Constants.modID, ExtraPlanets.instance, EntityEvolvedSpacemanBoss.class, Constants.modID + "." + "EvolvedSpaceManBoss", 894731, 0);
		if (Config.ERIS)
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerMobEntity(Constants.modID, ExtraPlanets.instance, EntityCreeperBossEris.class, Constants.modID + "." + "CreeperBossEris", 894731, 0);
			else
				RegisterUtilities.registerMobEntity(Constants.modID, ExtraPlanets.instance, EntityEvolvedGiantZombieBoss.class, Constants.modID + "." + "EvolvedGiantZombieBoss", 894731, 0);
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

		@SubscribeEvent(priority = EventPriority.LOWEST)
		public static void registerRecipesEvent(RegistryEvent.Register<IRecipe> event) {
			ExtraPlanets_Recipes.initEvent();
		}
	}

	@EventHandler
	public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
		MessageUtilities.fatalErrorMessageToLog(Constants.modID, "Invalid fingerprint detected! The file " + event.getSource().getName() + " may have been tampered with. This version will NOT be supported!");
	}
}
