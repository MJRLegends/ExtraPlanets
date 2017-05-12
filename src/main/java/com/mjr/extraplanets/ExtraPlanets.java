package com.mjr.extraplanets;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import com.mjr.extraplanets.armor.ExtraPlanets_Armor;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.ExtraPlanets_MicroBlocks;
import com.mjr.extraplanets.blocks.ExtraPlanets_SlabsStairsBlocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.machines.ExtraPlanets_Machines;
import com.mjr.extraplanets.client.gui.GuiHandler;
import com.mjr.extraplanets.entities.EntityFireBombPrimed;
import com.mjr.extraplanets.entities.EntityNuclearBombPrimed;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedGhastBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedIceSlimeBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedMagmaCubeBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedSnowmanBoss;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossEris;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossJupiter;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossNeptune;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossPluto;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossSaturn;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossUranus;
import com.mjr.extraplanets.entities.bosses.defaultBosses.EntityCreeperBossVenus;
import com.mjr.extraplanets.entities.monsters.EntityBlueCreeper;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedBlaze;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedEnderman;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedGiantSpider;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedIceSlime;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedMagmaCube;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedMiniEnderman;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedPowerSkeleton;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedRedCreeper;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedWitch;
import com.mjr.extraplanets.entities.projectiles.EntitySmallSnowball;
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
import com.mjr.extraplanets.items.ExtraPlanets_Items;
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
import com.mjr.extraplanets.planets.Venus.event.VenusEvents;
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
import com.mjr.extraplanets.schematic.SchematicVenusRover;
import com.mjr.extraplanets.util.RegisterHelper;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Constants.modID, name = Constants.modName, version = Constants.modVersion, dependencies = "required-after:GalacticraftCore;required-after:GalacticraftMars;;required-after:Forge@[10.13.4.1558,);")
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
			if (Config.advancedRefinery)
				return Item.getItemFromBlock(ExtraPlanets_Machines.advancedRefinery);
			else
				return Item.getItemFromBlock(ExtraPlanets_Blocks.denseIce);
		}
	};

	// Items Creative Tab
	public static CreativeTabs ItemsTab = new CreativeTabs("SpaceItemsTab") {
		@Override
		public Item getTabIconItem() {
			if (Config.venus)
				return ExtraPlanets_Items.tier4Rocket;
			else if (Config.jupiter)
				return ExtraPlanets_Items.tier5Rocket;
			else if (Config.saturn && Config.morePlanetsCompatibility == false)
				return ExtraPlanets_Items.tier6Rocket;
			else if (Config.uranus && Config.morePlanetsCompatibility == false)
				return ExtraPlanets_Items.tier7Rocket;
			else if (Config.neptune && Config.morePlanetsCompatibility == false)
				return ExtraPlanets_Items.tier8Rocket;
			else if (Config.pluto)
				return ExtraPlanets_Items.tier9Rocket;
			else if (Config.eris && Config.morePlanetsCompatibility == false)
				return ExtraPlanets_Items.tier10Rocket;
			return GCItems.rocketTier1;
		}
	};
	// Tools Creative Tab
	public static CreativeTabs ToolsTab = new CreativeTabs("SpaceToolsTab") {
		@Override
		public Item getTabIconItem() {
			if (Config.venus)
				return ExtraPlanets_Tools.carbonPickaxe;
			else if (Config.jupiter)
				return ExtraPlanets_Tools.palladiumPickaxe;
			else if (Config.saturn)
				return ExtraPlanets_Tools.magnesiumPickaxe;
			else if (Config.uranus)
				return ExtraPlanets_Tools.crystalPickaxe;
			return GCItems.steelPickaxe;
		}
	};
	// Armour Creative Tab
	public static CreativeTabs ArmorTab = new CreativeTabs("SpaceArmorTab") {
		@Override
		public Item getTabIconItem() {
			if (Config.venus)
				return ExtraPlanets_Armor.carbonChest;
			else if (Config.jupiter)
				return ExtraPlanets_Armor.palladiumChest;
			else if (Config.saturn)
				return ExtraPlanets_Armor.magnesiumChest;
			else if (Config.uranus)
				return ExtraPlanets_Armor.crystalChest;
			return GCItems.steelChestplate;
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		GalacticraftVersionChecker.run();
		Config.load();
		// Planets Events
		if (Config.mercury)
			MinecraftForge.EVENT_BUS.register(new MercuryEvents());
		if (Config.venus)
			MinecraftForge.EVENT_BUS.register(new VenusEvents());
		if (Config.ceres)
			MinecraftForge.EVENT_BUS.register(new CeresEvents());
		if (Config.jupiter)
			MinecraftForge.EVENT_BUS.register(new JupiterEvents());
		if (Config.saturn)
			MinecraftForge.EVENT_BUS.register(new SaturnEvents());
		if (Config.uranus)
			MinecraftForge.EVENT_BUS.register(new UranusEvents());
		if (Config.neptune)
			MinecraftForge.EVENT_BUS.register(new NeptuneEvents());
		if (Config.pluto)
			MinecraftForge.EVENT_BUS.register(new PlutoEvents());
		if (Config.eris)
			MinecraftForge.EVENT_BUS.register(new ErisEvents());
		if (Config.kepler22b && Config.keplerSolarSystems)
			MinecraftForge.EVENT_BUS.register(new Kepler22bEvents());

		// Moons Events
		if (Config.callisto)
			MinecraftForge.EVENT_BUS.register(new CallistoEvents());
		if (Config.deimos)
			MinecraftForge.EVENT_BUS.register(new DeimosEvents());
		if (Config.europa)
			MinecraftForge.EVENT_BUS.register(new EuropaEvents());
		if (Config.ganymede)
			MinecraftForge.EVENT_BUS.register(new GanymedeEvents());
		if (Config.io)
			MinecraftForge.EVENT_BUS.register(new IoEvents());
		if (Config.phobos)
			MinecraftForge.EVENT_BUS.register(new PhobosEvents());
		if (Config.triton)
			MinecraftForge.EVENT_BUS.register(new TritonEvents());
		if (Config.rhea)
			MinecraftForge.EVENT_BUS.register(new RheaEvents());
		if (Config.titan)
			MinecraftForge.EVENT_BUS.register(new TitanEvents());
		if (Config.oberon)
			MinecraftForge.EVENT_BUS.register(new OberonEvents());
		if (Config.iapetus)
			MinecraftForge.EVENT_BUS.register(new IapetusEvents());
		if (Config.titania)
			MinecraftForge.EVENT_BUS.register(new TitaniaEvents());
		if (Config.kuiperBelt)
			MinecraftForge.EVENT_BUS.register(new KuiperBeltEvents());

		NetworkRegistry.INSTANCE.registerGuiHandler(ExtraPlanets.instance, new GuiHandler());

		// Initialization/Registering Methods For Blocks/Items
		ExtraPlanets_Blocks.init();
		if (Config.slabsAndStairs)
			ExtraPlanets_SlabsStairsBlocks.init();
		ExtraPlanets_Machines.init();
		ExtraPlanets_Fluids.init();
		ExtraPlanets_Tools.init();
		ExtraPlanets_Armor.init();
		ExtraPlanets_Items.init();

		// Registering fluids with Bucket Handler
		if (Config.ceres)
			BucketHandler.INSTANCE.buckets.put(ExtraPlanets_Fluids.salt, ExtraPlanets_Items.salt_bucket);
		if (Config.jupiter)
			BucketHandler.INSTANCE.buckets.put(ExtraPlanets_Fluids.magma, ExtraPlanets_Items.magma_bucket);
		if (Config.saturn)
			BucketHandler.INSTANCE.buckets.put(ExtraPlanets_Fluids.glowstone, ExtraPlanets_Items.glowstone_bucket);
		if (Config.uranus)
			BucketHandler.INSTANCE.buckets.put(ExtraPlanets_Fluids.frozen_water, ExtraPlanets_Items.frozen_water_bucket);
		if (Config.neptune)
			BucketHandler.INSTANCE.buckets.put(ExtraPlanets_Fluids.nitrogen, ExtraPlanets_Items.nitrogen_bucket);

		// Bucket Handler
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);

		// Bone Meal Handler
		MinecraftForge.EVENT_BUS.register(new BoneMealHandler());

		// Proxy PreInit Method
		ExtraPlanets.proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		// Initialization/Registering Methods For SolarSystems/Planets/Moons/SpaceStations
		ExtraPlanets_SolarSystems.init();
		ExtraPlanets_Planets.init();
		ExtraPlanets_Moons.init();
		ExtraPlanets_SpaceStations.init();

		// Compatibility Methods
		if (Config.microBlock)
			ExtraPlanets_MicroBlocks.init();

		// Initialization/Registering Methods For Entities
		registerNonMobEntities();
		registerCreatures();

		packetPipeline = ExtraPlanetsChannelHandler.init();

		// Proxy Init Method
		ExtraPlanets.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Register Schematics Recipes
		if (Config.morePlanetsCompatibility == false)
			registerSchematicsRecipes();

		// Register/Add Dungeon Loot
		if (Config.morePlanetsCompatibility == false)
			addDungeonLoot();

		// Register Recipes
		ExtraPlanets_Recipes.init();

		// Initialize/Register Achievements
		if (Config.achievements)
			ExtraPlanets_Achievements.init();

		// Proxy PostInit Method
		ExtraPlanets.proxy.postInit(event);
	}

	private void registerNonMobEntities() {
		if (Config.nuclearBomb)
			RegisterHelper.registerExtraPlanetsNonMobEntity(EntityNuclearBombPrimed.class, Constants.modName + "NuclearBombPrimed", 150, 1, true);
		RegisterHelper.registerExtraPlanetsNonMobEntity(EntityFireBombPrimed.class, Constants.modName + "FireBombPrimed", 150, 1, true);

		if (Config.morePlanetsCompatibility == false) {
			if (Config.venus)
				RegisterHelper.registerExtraPlanetsNonMobEntity(EntityTier4Rocket.class, Constants.modName + "EntityTier4Rocket", 150, 1, false);
			if (Config.jupiter)
				RegisterHelper.registerExtraPlanetsNonMobEntity(EntityTier5Rocket.class, Constants.modName + "EntityTier5Rocket", 150, 1, false);
			if (Config.saturn)
				RegisterHelper.registerExtraPlanetsNonMobEntity(EntityTier6Rocket.class, Constants.modName + "EntityTier6Rocket", 150, 1, false);
			if (Config.uranus)
				RegisterHelper.registerExtraPlanetsNonMobEntity(EntityTier7Rocket.class, Constants.modName + "EntityTier7Rocket", 150, 1, false);
			if (Config.neptune)
				RegisterHelper.registerExtraPlanetsNonMobEntity(EntityTier8Rocket.class, Constants.modName + "EntityTier8Rocket", 150, 1, false);
			if (Config.pluto)
				RegisterHelper.registerExtraPlanetsNonMobEntity(EntityTier9Rocket.class, Constants.modName + "EntityTier9Rocket", 150, 1, false);
			if (Config.eris)
				RegisterHelper.registerExtraPlanetsNonMobEntity(EntityTier10Rocket.class, Constants.modName + "EntityTier10Rocket", 150, 1, false);
			RegisterHelper.registerExtraPlanetsNonMobEntity(EntitySmallSnowball.class, Constants.modName + "SmallSnowBall", 150, 1, true);
		}
		RegisterHelper.registerExtraPlanetsNonMobEntity(EntityMarsRover.class, "EntityMarsRover", 150, 1, false);
		RegisterHelper.registerExtraPlanetsNonMobEntity(EntityVenusRover.class, "EntityVenusRover", 150, 1, false);
	}

	private void registerCreatures() {
		// Dungeon Bosses
		if (Config.venus)
			if (Config.useDefaultBosses)
				RegisterHelper.registerExtraPlanetsCreature(EntityCreeperBossVenus.class, "CreeperBossVenus", 894731, 0);
			else
				RegisterHelper.registerExtraPlanetsCreature(EntityEvolvedMagmaCubeBoss.class, Constants.modName + "EvolvedMagmaCubeBoss", 3407872, 16579584);
		if (Config.jupiter)
			RegisterHelper.registerExtraPlanetsCreature(EntityCreeperBossJupiter.class, Constants.modName + "CreeperBossJupiter", 894731, 0);
		if (Config.saturn)

			if (Config.useDefaultBosses)
				RegisterHelper.registerExtraPlanetsCreature(EntityCreeperBossSaturn.class, Constants.modName + "CreeperBossSaturn", 894731, 0);
			else
				RegisterHelper.registerExtraPlanetsCreature(EntityEvolvedGhastBoss.class, Constants.modName + "EvolvedGhastBoss", 894731, 0);
		if (Config.uranus)
			if (Config.useDefaultBosses)
				RegisterHelper.registerExtraPlanetsCreature(EntityCreeperBossUranus.class, "CreeperBossUranus", 894731, 0);
			else
				RegisterHelper.registerExtraPlanetsCreature(EntityEvolvedIceSlimeBoss.class, Constants.modName + "EvolvedIceSlimeBoss", 16382457, 44975);
		if (Config.neptune)
			if (Config.useDefaultBosses)
				RegisterHelper.registerExtraPlanetsCreature(EntityCreeperBossNeptune.class, Constants.modName + "CreeperBossNeptune", 894731, 0);
			else
				RegisterHelper.registerExtraPlanetsCreature(EntityEvolvedSnowmanBoss.class, Constants.modName + "EvolvedSnowmanBoss", 894731, 0);
		if (Config.pluto)
			RegisterHelper.registerExtraPlanetsCreature(EntityCreeperBossPluto.class, Constants.modName + "CreeperBossPluto", 894731, 0);
		if (Config.eris)
			RegisterHelper.registerExtraPlanetsCreature(EntityCreeperBossEris.class, Constants.modName + "CreeperBossEris", 894731, 0);

		// Entities
		if (Config.evolvedMagmaCube)
			RegisterHelper.registerExtraPlanetsCreature(EntityEvolvedMagmaCube.class, Constants.modName + "EvolvedMagmaCube", 3407872, 16579584);
		if (Config.evolvedIceSlime)
			RegisterHelper.registerExtraPlanetsCreature(EntityEvolvedIceSlime.class, Constants.modName + "EvolvedIceSlime", 16382457, 44975);
		if (Config.evolvedWitch)
			RegisterHelper.registerExtraPlanetsCreature(EntityEvolvedWitch.class, Constants.modName + "EvolvedWitch", 3407872, 5349438);
		if (Config.evolvedEnderman)
			RegisterHelper.registerExtraPlanetsCreature(EntityEvolvedEnderman.class, Constants.modName + "EvolvedEnderman", 1447446, 0);
		if (Config.evolvedBlaze)
			RegisterHelper.registerExtraPlanetsCreature(EntityEvolvedBlaze.class, Constants.modName + "EvolvedBlaze", 16167425, 16775294);
		if (Config.evolvedBlueCreeper)
			RegisterHelper.registerExtraPlanetsCreature(EntityBlueCreeper.class, Constants.modName + "EvolvedBlueCreeper", 44975, 0);
		if (Config.evolvedRedCreeper)
			RegisterHelper.registerExtraPlanetsCreature(EntityEvolvedRedCreeper.class, Constants.modName + "EvolvedRedCreeper", 11013646, 0);
		if (Config.evolvedPowerSkeleton)
			RegisterHelper.registerExtraPlanetsCreature(EntityEvolvedPowerSkeleton.class, Constants.modName + "EvolvedPowerSkeleton", 12698049, 4802889);
		if (Config.evolvedGiantSpider)
			RegisterHelper.registerExtraPlanetsCreature(EntityEvolvedGiantSpider.class, Constants.modName + "EvolvedGiantSpider", 12698049, 4802889);
		if (Config.evolvedMiniEnderman)
			RegisterHelper.registerExtraPlanetsCreature(EntityEvolvedMiniEnderman.class, Constants.modName + "EvolvedMiniEnderman", 1447446, 0);
	}

	private void registerSchematicsRecipes() {
		if (Config.venus)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier4Rocket());
		if (Config.jupiter)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier5Rocket());
		if (Config.saturn)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier6Rocket());
		if (Config.uranus)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier7Rocket());
		if (Config.neptune)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier8Rocket());
		if (Config.pluto)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier9Rocket());
		if (Config.eris)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier10Rocket());
		SchematicRegistry.registerSchematicRecipe(new SchematicMarsRover());
		SchematicRegistry.registerSchematicRecipe(new SchematicVenusRover());
	}

	private void addDungeonLoot() {
		GalacticraftRegistry.addDungeonLoot(2, new ItemStack(ExtraPlanets_Items.schematicMarsRover, 1, 0));
		if (Config.venus) {
			GalacticraftRegistry.addDungeonLoot(4, new ItemStack(ExtraPlanets_Items.schematicTier4, 1, 0));
			GalacticraftRegistry.addDungeonLoot(4, new ItemStack(ExtraPlanets_Items.schematicVenusRover, 1, 0));
		}
		if (Config.jupiter)
			GalacticraftRegistry.addDungeonLoot(5, new ItemStack(ExtraPlanets_Items.schematicTier5, 1, 0));
		if (Config.saturn)
			GalacticraftRegistry.addDungeonLoot(6, new ItemStack(ExtraPlanets_Items.schematicTier6, 1, 0));
		if (Config.uranus)
			GalacticraftRegistry.addDungeonLoot(7, new ItemStack(ExtraPlanets_Items.schematicTier7, 1, 0));
		if (Config.neptune)
			GalacticraftRegistry.addDungeonLoot(8, new ItemStack(ExtraPlanets_Items.schematicTier8, 1, 0));
		if (Config.pluto)
			GalacticraftRegistry.addDungeonLoot(9, new ItemStack(ExtraPlanets_Items.schematicTier9, 1, 0));
		if (Config.eris)
			GalacticraftRegistry.addDungeonLoot(10, new ItemStack(ExtraPlanets_Items.schematicTier10, 1, 0));
	}
}
