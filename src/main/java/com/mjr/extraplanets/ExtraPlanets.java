package com.mjr.extraplanets;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.galacticraft.planets.mars.MarsModule;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
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
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossEris;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossJupiter;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossNeptune;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossPluto;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossSaturn;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossUranus;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossVenus;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedIceSlimeBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedMagmaCubeBoss;
import com.mjr.extraplanets.entities.rockets.EntityTier10Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier4Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier5Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier6Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier7Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier8Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier9Rocket;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.moons.ExtraPlanets_Moons;
import com.mjr.extraplanets.moons.Callisto.event.CallistoEvents;
import com.mjr.extraplanets.moons.Deimos.event.DeimosEvents;
import com.mjr.extraplanets.moons.Europa.event.EuropaEvents;
import com.mjr.extraplanets.moons.Ganymede.event.GanymedeEvents;
import com.mjr.extraplanets.moons.Io.event.IoEvents;
import com.mjr.extraplanets.moons.Phobos.event.PhobosEvents;
import com.mjr.extraplanets.moons.Rhea.event.RheaEvents;
import com.mjr.extraplanets.moons.Titan.event.TitanEvents;
import com.mjr.extraplanets.moons.Triton.event.TritonEvents;
import com.mjr.extraplanets.planets.ExtraPlanets_Planets;
import com.mjr.extraplanets.planets.ExtraPlanets_SpaceStations;
import com.mjr.extraplanets.planets.Ceres.event.CeresEvents;
import com.mjr.extraplanets.planets.Eris.event.ErisEvents;
import com.mjr.extraplanets.planets.Jupiter.event.JupiterEvents;
import com.mjr.extraplanets.planets.KuiperBelt.KuiperBeltEvents;
import com.mjr.extraplanets.planets.Mercury.event.MercuryEvents;
import com.mjr.extraplanets.planets.Neptune.event.NeptuneEvents;
import com.mjr.extraplanets.planets.Pluto.event.PlutoEvents;
import com.mjr.extraplanets.planets.Saturn.event.SaturnEvents;
import com.mjr.extraplanets.planets.Uranus.event.UranusEvents;
import com.mjr.extraplanets.planets.Venus.event.VenusEvents;
import com.mjr.extraplanets.proxy.CommonProxy;
import com.mjr.extraplanets.recipes.ExtraPlanets_Recipes;
import com.mjr.extraplanets.schematic.SchematicTier10Rocket;
import com.mjr.extraplanets.schematic.SchematicTier4Rocket;
import com.mjr.extraplanets.schematic.SchematicTier5Rocket;
import com.mjr.extraplanets.schematic.SchematicTier6Rocket;
import com.mjr.extraplanets.schematic.SchematicTier7Rocket;
import com.mjr.extraplanets.schematic.SchematicTier8Rocket;
import com.mjr.extraplanets.schematic.SchematicTier9Rocket;

@Mod(modid = Constants.modID, name = Constants.modName, version = Constants.modVersion, dependencies = "required-after:GalacticraftCore;required-after:GalacticraftPlanets;;required-after:Forge@[10.13.4.1558,);")
public class ExtraPlanets {

	@SidedProxy(clientSide = "com.mjr.extraplanets.proxy.ClientProxy", serverSide = "com.mjr.extraplanets.proxy.CommonProxy")
	public static CommonProxy proxy;

	@Instance(Constants.modID)
	public static ExtraPlanets instance;

	// Blocks Creative Tab
	public static CreativeTabs BlocksTab = new CreativeTabs("SpaceBlocksTab") {
		@Override
		public Item getTabIconItem() {
			// return Item.getItemFromBlock(ExtraPlanets_Blocks.denseIce);
			return Item.getItemFromBlock(GCBlocks.basicBlock);
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
			// if (Config.venus)
			// return ExtraPlanets_Tools.carbonPickaxe;
			// else if (Config.jupiter)
			// return ExtraPlanets_Tools.palladiumPickaxe;
			// else if (Config.saturn)
			// return ExtraPlanets_Tools.magnesiumPickaxe;
			// else if (Config.uranus)
			// return ExtraPlanets_Tools.crystalPickaxe;
			return GCItems.steelPickaxe;
		}
	};
	// Armour Creative Tab
	public static CreativeTabs ArmorTab = new CreativeTabs("SpaceArmorTab") {
		@Override
		public Item getTabIconItem() {
			// if (Config.venus)
			// return ExtraPlanets_Armor.carbonChest;
			// else if (Config.jupiter)
			// return ExtraPlanets_Armor.palladiumChest;
			// else if (Config.saturn)
			// return ExtraPlanets_Armor.magnesiumChest;
			// else if (Config.uranus)
			// return ExtraPlanets_Armor.crystalChest;
			return GCItems.steelChestplate;
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
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
		if (Config.kuiperBelt)
			MinecraftForge.EVENT_BUS.register(new KuiperBeltEvents());

		// Initialization/Registering Methods For Blocks/Items
		ExtraPlanets_Blocks.init();
		// ExtraPlanets_Tools.init();
		// ExtraPlanets_Armor.init();
		ExtraPlanets_Items.init();

		// Proxy PreInit Method
		ExtraPlanets.proxy.preInit(event);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		// Initialization/Registering Methods For
		// SolarSystems/Planets/Moons/SpaceStations
		ExtraPlanets_SolarSystems.init();
		ExtraPlanets_Planets.init();
		ExtraPlanets_Moons.init();
		ExtraPlanets_SpaceStations.init();

		// Initialization/Registering Methods For Entities
		registerNonMobEntities();
		registerCreatures();

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

		// Proxy PostInit Method
		ExtraPlanets.proxy.postInit(event);
	}

	private void registerNonMobEntities() {
		// registerExtraPlanetsNonMobEntity(EntityNuclearBombPrimed.class,
		// Constants.modName + "NuclearBombPrimed", 150, 1, true);
		if (Config.venus)
			registerExtraPlanetsNonMobEntity(EntityTier4Rocket.class, Constants.modName + "EntityTier4Rocket", 150, 1, false);
		if (Config.jupiter)
			registerExtraPlanetsNonMobEntity(EntityTier5Rocket.class, Constants.modName + "EntityTier5Rocket", 150, 1, false);
		if (Config.saturn)
			registerExtraPlanetsNonMobEntity(EntityTier6Rocket.class, Constants.modName + "EntityTier6Rocket", 150, 1, false);
		if (Config.uranus)
			registerExtraPlanetsNonMobEntity(EntityTier7Rocket.class, Constants.modName + "EntityTier7Rocket", 150, 1, false);
		if (Config.neptune)
			registerExtraPlanetsNonMobEntity(EntityTier8Rocket.class, Constants.modName + "EntityTier8Rocket", 150, 1, false);
		if (Config.pluto)
			registerExtraPlanetsNonMobEntity(EntityTier9Rocket.class, Constants.modName + "EntityTier9Rocket", 150, 1, false);
		if (Config.eris)
			registerExtraPlanetsNonMobEntity(EntityTier10Rocket.class, Constants.modName + "EntityTier10Rocket", 150, 1, false);
	}

	private void registerCreatures() {
		// Dungeon Bosses
		if (Config.venus)
			if (Config.useDefaultBosses)
				GCCoreUtil.registerGalacticraftCreature(EntityCreeperBossVenus.class, "CreeperBossVenus", 894731, 0);
			else
				GCCoreUtil.registerGalacticraftCreature(EntityEvolvedMagmaCubeBoss.class, Constants.modName + "EvolvedMagmaCubeBoss", 3407872, 16579584);
		if (Config.jupiter)
			GCCoreUtil.registerGalacticraftCreature(EntityCreeperBossJupiter.class, Constants.modName + "CreeperBossJupiter", 894731, 0);
		if (Config.saturn)
			GCCoreUtil.registerGalacticraftCreature(EntityCreeperBossSaturn.class, Constants.modName + "CreeperBossSaturn", 894731, 0);
		if (Config.uranus)
			if (Config.useDefaultBosses)
				GCCoreUtil.registerGalacticraftCreature(EntityCreeperBossUranus.class, "CreeperBossUranus", 894731, 0);
			else
				GCCoreUtil.registerGalacticraftCreature(EntityEvolvedIceSlimeBoss.class, Constants.modName + "EntityEvolvedIceSlimeBoss", 16382457, 44975);
		if (Config.neptune)
			GCCoreUtil.registerGalacticraftCreature(EntityCreeperBossNeptune.class, Constants.modName + "CreeperBossNeptune", 894731, 0);
		if (Config.pluto)
			GCCoreUtil.registerGalacticraftCreature(EntityCreeperBossPluto.class, Constants.modName + "CreeperBossPluto", 894731, 0);
		if (Config.eris)
			GCCoreUtil.registerGalacticraftCreature(EntityCreeperBossEris.class, Constants.modName + "CreeperBossEris", 894731, 0);

		// Entities
		// if (Config.evolvedMagmaCube)
		// registerExtraPlanetsCreature(EntityEvolvedMagmaCube.class,
		// Constants.modName + "EvolvedMagmaCube", 3407872, 16579584);
		// if (Config.evolvedIceSlime)
		// registerExtraPlanetsCreature(EntityEvolvedIceSlime.class,
		// Constants.modName + "EvolvedIceSlime", 16382457, 44975);
		// if (Config.evolvedWitch)
		// registerExtraPlanetsCreature(EntityEvolvedWitch.class,
		// Constants.modName + "EvolvedWitch", 3407872, 5349438);
		// if (Config.evolvedEnderman)
		// registerExtraPlanetsCreature(EntityEvolvedEnderman.class,
		// Constants.modName + "EvolvedEnderman", 1447446, 0);
		// if (Config.evolvedBlaze)
		// registerExtraPlanetsCreature(EntityEvolvedBlaze.class,
		// Constants.modName + "EvolvedBlaze", 16167425, 16775294);
		// if (Config.evolvedBlueCreeper)
		// registerExtraPlanetsCreature(EntityBlueCreeper.class,
		// Constants.modName + "EvolvedBlueCreeper", 44975, 0);
		// if (Config.evolvedRedCreeper)
		// registerExtraPlanetsCreature(EntityEvolvedRedCreeper.class,
		// Constants.modName + "EvolvedRedCreeper", 11013646, 0);
		// if (Config.evolvedPowerSkeleton)
		// registerExtraPlanetsCreature(EntityEvolvedPowerSkeleton.class,
		// Constants.modName + "EvolvedPowerSkeleton", 12698049, 4802889);
		// if (Config.evolvedGiantSpider)
		// registerExtraPlanetsCreature(EntityEvolvedGiantSpider.class,
		// Constants.modName + "EvolvedGiantSpider", 12698049, 4802889);
		// if (Config.evolvedMiniEnderman)
		// registerExtraPlanetsCreature(EntityEvolvedMiniEnderman.class,
		// Constants.modName + "EvolvedMiniEnderman", 1447446, 0);
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
	}

	private void addDungeonLoot() {
		if (Config.venus)
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

	public static void registerExtraPlanetsNonMobEntity(Class<? extends Entity> var0, String var1, int trackingDistance, int updateFreq, boolean sendVel) {
		EntityRegistry.registerModEntity(var0, var1, GCCoreUtil.nextInternalID(), ExtraPlanets.instance, trackingDistance, updateFreq, sendVel);
	}
}
