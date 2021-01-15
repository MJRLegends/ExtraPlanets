package com.mjr.extraplanets;

import java.io.File;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.machines.ExtraPlanets_Machines;
import com.mjr.extraplanets.client.gui.GuiHandler;
import com.mjr.extraplanets.client.handlers.capabilities.CapabilityStatsClientHandler;
import com.mjr.extraplanets.compatibility.MorePlanetsCompatibility;
import com.mjr.extraplanets.entities.EntityFireBombPrimed;
import com.mjr.extraplanets.entities.EntityNuclearBombPrimed;
import com.mjr.extraplanets.entities.bosses.*;
import com.mjr.extraplanets.entities.bosses.defaultBosses.*;
import com.mjr.extraplanets.entities.landers.*;
import com.mjr.extraplanets.entities.mobs.EntityEvolvedAncientMagmaCube;
import com.mjr.extraplanets.entities.mobs.EntityEvolvedMagmaCube;
import com.mjr.extraplanets.entities.rockets.*;
import com.mjr.extraplanets.entities.vehicles.EntityMarsRover;
import com.mjr.extraplanets.entities.vehicles.EntityVenusRover;
import com.mjr.extraplanets.handlers.BoneMealHandler;
import com.mjr.extraplanets.handlers.MainHandlerServer;
import com.mjr.extraplanets.handlers.capabilities.CapabilityStatsHandler;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.items.armor.ExtraPlanets_Armor;
import com.mjr.extraplanets.items.armor.modules.ExtraPlanets_Modules;
import com.mjr.extraplanets.items.schematics.*;
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
import com.mjr.extraplanets.recipes.*;
import com.mjr.extraplanets.schematicPages.*;
import com.mjr.mjrlegendslib.recipe.ShapedNBTRecipe;
import com.mjr.mjrlegendslib.util.MessageUtilities;
import com.mjr.mjrlegendslib.util.NetworkUtilities;
import com.mjr.mjrlegendslib.util.RegisterUtilities;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.tile.TileEntityDeconstructor;
import micdoodle8.mods.galacticraft.planets.asteroids.AsteroidsModule;
import micdoodle8.mods.galacticraft.planets.mars.MarsModule;
import micdoodle8.mods.galacticraft.planets.venus.VenusModule;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.oredict.RecipeSorter;

@Mod(modid = Constants.modID, name = Constants.modName, version = Constants.modVersion, dependencies = Constants.DEPENDENCIES_FORGE
		+ Constants.DEPENDENCIES_MODS, guiFactory = Constants.GUIFACTORY, certificateFingerprint = Constants.CERTIFICATEFINGERPRINT)
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

		// Initialization/Registering Methods For SolarSystems/Planets/Moons/SpaceStations
		ExtraPlanets_SolarSystems.init();
		ExtraPlanets_Planets.init();
		ExtraPlanets_Moons.init();
		ExtraPlanets_SpaceStations.init();

		// Initialization/Registering Methods For Entities
		registerNonMobEntities();
		registerCreatures();

		packetPipeline = ExtraPlanetsChannelHandler.init();
		// packetPipeline = NetworkManager.registerNetworkChannel(PacketSimpleEP.class, Constants.modID);

		// Proxy Init Method
		ExtraPlanets.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		ExtraPlanets_Planets.registerMaterialsForGCPlanets();

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

		if (Config.MORE_PLANETS_ROCKET_CRUSHER_SUPPORT)
			MorePlanetsCompatibility.init();

		// Register Custom Recipe Type
		RecipeSorter.register("extraplanets:shapedNBTRecipe", ShapedNBTRecipe.class, RecipeSorter.Category.SHAPED, "before:minecraft:shaped");

		if (Config.GC_PRESSURE || Config.GC_RADIATION) {
			MarsModule.planetMars.addChecklistKeys("space_suit");
			GalacticraftCore.moonMoon.addChecklistKeys("space_suit");
			VenusModule.planetVenus.addChecklistKeys("space_suit");
			AsteroidsModule.planetAsteroids.addChecklistKeys("space_suit");
		}

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
		if (Config.MERCURY) {
			RegisterUtilities.registerMobEntity(ExtraPlanets.instance, EntityEvolvedMagmaCube.class, "EvolvedMagmaCube", 3407872, 16579584);
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerMobEntity(ExtraPlanets.instance, EntityCreeperBossMercury.class, "CreeperBossMercury", 894731, 0);
			else
				RegisterUtilities.registerMobEntity(ExtraPlanets.instance, EntityEvolvedMagmaCubeBoss.class, "EvolvedMagmaCubeBoss", 3407872, 16579584);
		}
		if (Config.JUPITER) {
			RegisterUtilities.registerMobEntity(ExtraPlanets.instance, EntityEvolvedAncientMagmaCube.class, "EvolvedAncientMagmaCube", 3407872, 16579584);
			if (Config.USE_DEFAULT_BOSSES)
				RegisterUtilities.registerMobEntity(ExtraPlanets.instance, EntityCreeperBossJupiter.class, "CreeperBossJupiter", 894731, 0);
			else
				RegisterUtilities.registerMobEntity(ExtraPlanets.instance, EntityEvolvedFireBatBoss.class, "EvolvedFireBatBoss", 16167425, 0);
		}
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
		MessageUtilities.fatalErrorMessageToLog(Constants.modID, "Invalid fingerprint detected! The file " + event.source.getName() + " may have been tampered with. This version will NOT be supported!");
	}

	@EventHandler
	public void onStartAboutToStartEvent(FMLServerAboutToStartEvent event) {
		if (Config.MOVE_ID_DIMENSION_LEGACY) {
			File folder = new File(FMLCommonHandler.instance().getSavesDirectory() + "/" + event.getServer().getFolderName());
			String[] idsOld = new String[12];
			idsOld[0] = "" + Config.IO_ID_LEGACY;
			idsOld[1] = "" + Config.EUROPA_ID_LEGACY;
			idsOld[2] = "" + Config.PHOBOS_ID_LEGACY;
			idsOld[3] = "" + Config.DEIMOS_ID_LEGACY;
			idsOld[4] = "" + Config.TRITON_ID_LEGACY;
			idsOld[5] = "" + Config.CALLISTO_ID_LEGACY;
			idsOld[6] = "" + Config.GANYMEDE_ID_LEGACY;
			idsOld[7] = "" + Config.RHEA_ID_LEGACY;
			idsOld[8] = "" + Config.TITAN_ID_LEGACY;
			idsOld[9] = "" + Config.OBERON_ID_LEGACY;
			idsOld[10] = "" + Config.TITANIA_ID_LEGACY;
			idsOld[11] = "" + Config.IAPETUS_ID_LEGACY;
			String[] idsNew = new String[12];
			idsNew[0] = "" + Config.IO_ID;
			idsNew[1] = "" + Config.EUROPA_ID;
			idsNew[2] = "" + Config.PHOBOS_ID;
			idsNew[3] = "" + Config.DEIMOS_ID;
			idsNew[4] = "" + Config.TRITON_ID;
			idsNew[5] = "" + Config.CALLISTO_ID;
			idsNew[6] = "" + Config.GANYMEDE_ID;
			idsNew[7] = "" + Config.RHEA_ID;
			idsOld[8] = "" + Config.TITAN_ID;
			idsOld[9] = "" + Config.OBERON_ID;
			idsOld[10] = "" + Config.TITANIA;
			idsOld[11] = "" + Config.IAPETUS;
			if (folder.exists()) {
				for (int i = 0; i < idsOld.length; i++) {
					File tempFolder = new File(folder.getPath() + "/" + "DIM" + idsOld[i]);
					File newFolder = new File(folder.getPath() + "/" + "DIM" + idsNew[i]);
					if (tempFolder.exists()) {
						if (newFolder.exists() == false) {
							MessageUtilities.infoMessageToLog(Constants.modID, "Mirgrated Dimension Folder " + idsOld[i] + " to new name of " + idsNew[i]);
							tempFolder.renameTo(newFolder);
						} else
							MessageUtilities.infoMessageToLog(Constants.modID, "Unable to Mrigrate Folder " + idsOld[i] + " to new name of " + idsNew[i] + " Due to this folder already exists");
					}
				}
			}
		}
	}
}
