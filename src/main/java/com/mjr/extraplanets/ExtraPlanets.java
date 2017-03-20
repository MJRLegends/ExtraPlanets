package com.mjr.extraplanets;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.GCItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import com.mjr.extraplanets.armor.ExtraPlanets_Armor;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.blocks.machines.ExtraPlanets_Machines;
import com.mjr.extraplanets.client.gui.GuiHandler;
import com.mjr.extraplanets.entities.EntityNuclearBombPrimed;
import com.mjr.extraplanets.entities.rockets.EntityTier10Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier4Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier5Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier6Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier7Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier8Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier9Rocket;
import com.mjr.extraplanets.handlers.BoneMealHandler;
import com.mjr.extraplanets.handlers.BucketHandler;
import com.mjr.extraplanets.handlers.MainHandlerServer;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.items.tools.ExtraPlanets_Tools;
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
import com.mjr.extraplanets.recipes.ExtraPlanets_Recipes;
import com.mjr.extraplanets.schematic.SchematicTier10Rocket;
import com.mjr.extraplanets.schematic.SchematicTier4Rocket;
import com.mjr.extraplanets.schematic.SchematicTier5Rocket;
import com.mjr.extraplanets.schematic.SchematicTier6Rocket;
import com.mjr.extraplanets.schematic.SchematicTier7Rocket;
import com.mjr.extraplanets.schematic.SchematicTier8Rocket;
import com.mjr.extraplanets.schematic.SchematicTier9Rocket;
import com.mjr.extraplanets.util.RegisterHelper;

@Mod(modid = Constants.modID, name = Constants.modName, version = Constants.modVersion, dependencies = "required-after:galacticraftcore;required-after:galacticraftplanets;required-after:Forge@[12.18.3.2239,);")
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
			if (Config.mercury)
				return ExtraPlanets_Items.tier4Rocket;
			else if (Config.jupiter)
				return ExtraPlanets_Items.tier5Rocket;
			else if (Config.saturn)
				return ExtraPlanets_Items.tier6Rocket;
			else if (Config.uranus)
				return ExtraPlanets_Items.tier7Rocket;
			else if (Config.neptune)
				return ExtraPlanets_Items.tier8Rocket;
			else if (Config.pluto)
				return ExtraPlanets_Items.tier9Rocket;
			else if (Config.eris)
				return ExtraPlanets_Items.tier10Rocket;
			return GCItems.rocketTier1;
		}
	};
	// Tools Creative Tab
	public static CreativeTabs ToolsTab = new CreativeTabs("SpaceToolsTab") {
		@Override
		public Item getTabIconItem() {
			if (Config.mercury)
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
			if (Config.mercury)
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
		Config.load();

		// Main Events
		MinecraftForge.EVENT_BUS.register(new MainHandlerServer());

		// Planets Events
		if (Config.mercury)
			MinecraftForge.EVENT_BUS.register(new MercuryEvents());
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

		// Initialization/Registering Methods For Blocks/Items
		ExtraPlanets_Blocks.init();
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
		BucketHandler.INSTANCE.buckets.put(ExtraPlanets_Fluids.cleanWater, ExtraPlanets_Items.clean_water_bucket);
		BucketHandler.INSTANCE.buckets.put(ExtraPlanets_Fluids.radioactiveWater, ExtraPlanets_Items.radioactive_bucket);

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
		// ExtraPlanets_Moons.init();
		// ExtraPlanets_SpaceStations.init();

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
		registerSchematicsRecipes();

		// Register/Add Dungeon Loot
		addDungeonLoot();

		// Register Recipes
		ExtraPlanets_Recipes.init();

		// Initialize/Register Achievements
		if (Config.achievements)
			ExtraPlanets_Achievements.init();

		// Register GUI Handler
		NetworkRegistry.INSTANCE.registerGuiHandler(ExtraPlanets.instance, new GuiHandler());

		// Proxy PostInit Method
		ExtraPlanets.proxy.postInit(event);
	}

	private void registerNonMobEntities() {
		if (Config.nuclearBomb)
			RegisterHelper.registerExtraPlanetsNonMobEntity(EntityNuclearBombPrimed.class, Constants.modName + "NuclearBombPrimed", 150, 1, true);
		if (Config.mercury)
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
	}

	private void registerCreatures() {
		// Dungeon Bosses
		// if (Config.mercury)
		// RegisterHelper.registerGalacticraftCreature(EntityEvolvedMagmaCubeBoss.class, Constants.modName + "EvolvedMagmaCubeBoss", 3407872, 16579584);
		// if (Config.jupiter)
		// GCCoreUtil.registerGalacticraftCreature(EntityCreeperBossJupiter.class, Constants.modName + "CreeperBossJupiter", 894731, 0);
		// if (Config.saturn)
		// RegisterHelper.registerGalacticraftCreature(EntityEvolvedGhastBoss.class, Constants.modName + "EvolvedGhastBoss", 894731, 0);
		// if (Config.uranus)
		// RegisterHelper.registerGalacticraftCreature(EntityEvolvedIceSlimeBoss.class, Constants.modName + "EvolvedIceSlimeBoss", 16382457, 44975);
		// if (Config.neptune)
		// RegisterHelper.registerGalacticraftCreature(EntityEvolvedSnowmanBoss.class, Constants.modName + "EvolvedSnowmanBoss", 894731, 0);
		// if (Config.pluto)
		// GCCoreUtil.registerGalacticraftCreature(EntityCreeperBossPluto.class, Constants.modName + "CreeperBossPluto", 894731, 0);
		// if (Config.eris)
		// GCCoreUtil.registerGalacticraftCreature(EntityCreeperBossEris.class, Constants.modName + "CreeperBossEris", 894731, 0);

	}

	private void registerSchematicsRecipes() {
		if (Config.mercury)
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
	}

	private void addDungeonLoot() {
		if (Config.mercury)
			GalacticraftRegistry.addDungeonLoot(4, new ItemStack(ExtraPlanets_Items.schematicTier4, 1, 0));
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
