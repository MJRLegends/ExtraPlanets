package com.mjr.extraplanets;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;

import com.mjr.extraplanets.armor.ExtraPlanetsArmor;
import com.mjr.extraplanets.blocks.ExtraPlanetsBlocks;
import com.mjr.extraplanets.blocks.ExtraPlanetsMachines;
import com.mjr.extraplanets.blocks.ExtraPlanetsSlabsStairsBlocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanetsFluids;
import com.mjr.extraplanets.client.gui.GuiHandler;
import com.mjr.extraplanets.entities.EntityBlueCreeper;
import com.mjr.extraplanets.entities.EntityEvolvedBlaze;
import com.mjr.extraplanets.entities.EntityEvolvedEnderman;
import com.mjr.extraplanets.entities.EntityEvolvedIceSlime;
import com.mjr.extraplanets.entities.EntityEvolvedMagmaCube;
import com.mjr.extraplanets.entities.EntityEvolvedPowerSkeleton;
import com.mjr.extraplanets.entities.EntityEvolvedRedCreeper;
import com.mjr.extraplanets.entities.EntityEvolvedWitch;
import com.mjr.extraplanets.entities.EntityNuclearBombPrimed;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossJupiter;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossNeptune;
import com.mjr.extraplanets.entities.bosses.EntityCreeperBossSaturn;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedIceSlimeBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedMagmaCubeBoss;
import com.mjr.extraplanets.entities.rockets.EntityTier4Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier5Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier6Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier7Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier8Rocket;
import com.mjr.extraplanets.entities.rockets.EntityTier9Rocket;
import com.mjr.extraplanets.handlers.BucketHandler;
import com.mjr.extraplanets.items.ExtraPlanetsItems;
import com.mjr.extraplanets.items.tools.ExtraPlanetsTools;
import com.mjr.extraplanets.moons.MoonsMain;
import com.mjr.extraplanets.moons.Callisto.event.CallistoEvents;
import com.mjr.extraplanets.moons.Deimos.event.DeimosEvents;
import com.mjr.extraplanets.moons.Europa.event.EuropaEvents;
import com.mjr.extraplanets.moons.Ganymede.event.GanymedeEvents;
import com.mjr.extraplanets.moons.Io.event.IoEvents;
import com.mjr.extraplanets.moons.Phobos.event.PhobosEvents;
import com.mjr.extraplanets.moons.Rhea.event.RheaEvents;
import com.mjr.extraplanets.moons.Titan.event.TitanEvents;
import com.mjr.extraplanets.moons.triton.event.TritonEvents;
import com.mjr.extraplanets.planets.PlanetsMain;
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
import com.mjr.extraplanets.recipes.Recipes;
import com.mjr.extraplanets.schematic.SchematicTier4Rocket;
import com.mjr.extraplanets.schematic.SchematicTier5Rocket;
import com.mjr.extraplanets.schematic.SchematicTier6Rocket;
import com.mjr.extraplanets.schematic.SchematicTier7Rocket;
import com.mjr.extraplanets.schematic.SchematicTier8Rocket;
import com.mjr.extraplanets.schematic.SchematicTier9Rocket;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

@Mod(modid = Constants.modID, name = Constants.modName, version = Constants.modVersion, dependencies = "required-after:GalacticraftCore;required-after:GalacticraftMars;")
public class ExtraPlanets {

	@SidedProxy(clientSide = "com.mjr.extraplanets.proxy.ClientProxy", serverSide = "com.mjr.extraplanets.proxy.CommonProxy")
	public static CommonProxy proxy;

	@Instance(Constants.modID)
	public static ExtraPlanets instance;

	public static CreativeTabs BlocksTab = new CreativeTabs("SpaceBlocksTab") {
		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(ExtraPlanetsMachines.advancedRefinery);
		}
	};
	public static CreativeTabs ItemsTab = new CreativeTabs("SpaceItemsTab") {
		@Override
		public Item getTabIconItem() {
			return ExtraPlanetsItems.tier7Rocket;
		}
	};
	public static CreativeTabs ToolsTab = new CreativeTabs("SpaceToolsTab") {
		@Override
		public Item getTabIconItem() {
			return ExtraPlanetsTools.carbonPickaxe;
		}
	};
	public static CreativeTabs ArmorTab = new CreativeTabs("SpaceArmorTab") {
		@Override
		public Item getTabIconItem() {
			return ExtraPlanetsArmor.crystalChest;
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Config.load();
		// Planets
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

		// Moons
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
			//MinecraftForge.EVENT_BUS.register(new RheaEvents());
		if (Config.titan)
			//MinecraftForge.EVENT_BUS.register(new TitanEvents());

		MinecraftForge.EVENT_BUS.register(new KuiperBeltEvents());
		NetworkRegistry.INSTANCE.registerGuiHandler(ExtraPlanets.instance, new GuiHandler());
		// MinecraftForge.EVENT_BUS.register(new
		// RadiationBarOverlay(Minecraft.getMinecraft()));

		ExtraPlanetsBlocks.init();
		ExtraPlanetsSlabsStairsBlocks.init();
		ExtraPlanetsMachines.init();
		ExtraPlanetsFluids.init();
		ExtraPlanetsTools.init();
		ExtraPlanetsArmor.init();
		ExtraPlanetsItems.init();

		if (Config.ceres)
			BucketHandler.INSTANCE.buckets.put(ExtraPlanetsFluids.salt, ExtraPlanetsItems.salt_bucket);
		if (Config.jupiter)
			BucketHandler.INSTANCE.buckets.put(ExtraPlanetsFluids.magma, ExtraPlanetsItems.magma_bucket);
		if (Config.saturn)
			BucketHandler.INSTANCE.buckets.put(ExtraPlanetsFluids.glowstone, ExtraPlanetsItems.glowstone_bucket);
		if (Config.uranus)
			BucketHandler.INSTANCE.buckets.put(ExtraPlanetsFluids.frozen_water, ExtraPlanetsItems.frozen_water_bucket);
		if (Config.neptune)
			BucketHandler.INSTANCE.buckets.put(ExtraPlanetsFluids.nitrogen, ExtraPlanetsItems.nitrogen_bucket);

		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
		ExtraPlanets.proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		PlanetsMain.init();
		MoonsMain.init();
		registerNonMobEntities();
		registerCreatures();
		ExtraPlanets.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		registerSchematics();
		addDungeonLoot();
		Recipes.init();
		Achievements.init();
		ExtraPlanets.proxy.postInit(event);
	}

	private void registerNonMobEntities() {
		registerExtraPlanetsNonMobEntity(EntityNuclearBombPrimed.class, "NuclearBombPrimed", 150, 1, true);
		if (Config.venus)
			registerExtraPlanetsNonMobEntity(EntityTier4Rocket.class, "EntityTier4Rocket", 150, 1, false);
		if (Config.jupiter)
			registerExtraPlanetsNonMobEntity(EntityTier5Rocket.class, "EntityTier5Rocket", 150, 1, false);
		if (Config.saturn)
			registerExtraPlanetsNonMobEntity(EntityTier6Rocket.class, "EntityTier6Rocket", 150, 1, false);
		if (Config.uranus)
			registerExtraPlanetsNonMobEntity(EntityTier7Rocket.class, "EntityTier7Rocket", 150, 1, false);
		if (Config.neptune)
			registerExtraPlanetsNonMobEntity(EntityTier8Rocket.class, "EntityTier8Rocket", 150, 1, false);
		/*if (Config.pluto)
			registerExtraPlanetsNonMobEntity(EntityTier9Rocket.class, "EntityTier9Rocket", 150, 1, false);*/
	}

	private void registerCreatures() {
		// Default Bosses
		if (Config.venus)
			// registerExtraPlanetsCreature(EntityCreeperBossVenus.class,
			// "CreeperBossVenus", 894731, 0);
			registerExtraPlanetsCreature(EntityEvolvedMagmaCubeBoss.class, "EvolvedMagmaCubeBoss", 3407872, 16579584);
		if (Config.jupiter)
			registerExtraPlanetsCreature(EntityCreeperBossJupiter.class, "CreeperBossJupiter", 894731, 0);
		if (Config.saturn)
			registerExtraPlanetsCreature(EntityCreeperBossSaturn.class, "CreeperBossSaturn", 894731, 0);
		if (Config.uranus)
			// registerExtraPlanetsCreature(EntityCreeperBossUranus.class,"CreeperBossUranus",
			// 894731, 0);
			registerExtraPlanetsCreature(EntityEvolvedIceSlimeBoss.class, "EntityEvolvedIceSlimeBoss", 16382457, 44975);
		if (Config.neptune)
			registerExtraPlanetsCreature(EntityCreeperBossNeptune.class, "CreeperBossNeptune", 894731, 0);

		// Entities
		registerExtraPlanetsCreature(EntityEvolvedMagmaCube.class, "EvolvedMagmaCube", 3407872, 16579584);
		registerExtraPlanetsCreature(EntityEvolvedIceSlime.class, "EvolvedIceSlime", 16382457, 44975);
		// registerExtraPlanetsCreature(EvolvedIceBlaze.class,
		// "EvolvedIceBlaze", 3407872, 16579584);
		registerExtraPlanetsCreature(EntityEvolvedWitch.class, "EvolvedWitch", 3407872, 5349438);
		registerExtraPlanetsCreature(EntityEvolvedEnderman.class, "EvolvedEnderman", 1447446, 0);
		registerExtraPlanetsCreature(EntityEvolvedBlaze.class, "EvolvedBlaze", 16167425, 16775294);
		registerExtraPlanetsCreature(EntityBlueCreeper.class, "EvolvedBlueCreeper", 44975, 0);
		registerExtraPlanetsCreature(EntityEvolvedRedCreeper.class, "EvolvedRedCreeper", 11013646, 0);
		registerExtraPlanetsCreature(EntityEvolvedPowerSkeleton.class, "EvolvedPowerSkeleton", 12698049, 4802889);
	}

	private void registerSchematics() {
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
		/*if (Config.pluto)
			SchematicRegistry.registerSchematicRecipe(new SchematicTier9Rocket());*/
	}

	private void addDungeonLoot(){
		if (Config.venus)
			GalacticraftRegistry.addDungeonLoot(4, new ItemStack(ExtraPlanetsItems.schematicTier4, 1, 0));
		if (Config.jupiter)
			GalacticraftRegistry.addDungeonLoot(5, new ItemStack(ExtraPlanetsItems.schematicTier5, 1, 0));
		if (Config.saturn)
			GalacticraftRegistry.addDungeonLoot(6, new ItemStack(ExtraPlanetsItems.schematicTier6, 1, 0));
		if (Config.uranus)
			GalacticraftRegistry.addDungeonLoot(7, new ItemStack(ExtraPlanetsItems.schematicTier7, 1, 0));
		if (Config.neptune)
			GalacticraftRegistry.addDungeonLoot(8, new ItemStack(ExtraPlanetsItems.schematicTier8, 1, 0));
		/*if (Config.pluto)
			GalacticraftRegistry.addDungeonLoot(9, new ItemStack(ExtraPlanetsItems.schematicTier9, 1, 0));*/
	}

	public static void registerExtraPlanetsNonMobEntity(Class<? extends Entity> var0, String var1, int trackingDistance, int updateFreq, boolean sendVel) {
		EntityRegistry.registerModEntity(var0, var1, GCCoreUtil.nextInternalID(), ExtraPlanets.instance, trackingDistance, updateFreq, sendVel);
	}

	public void registerExtraPlanetsCreature(Class<? extends Entity> var0, String var1, int back, int fore) {
		EntityRegistry.instance();
		int newID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(var0, var1, newID, back, fore);
		EntityRegistry.registerModEntity(var0, var1, GCCoreUtil.nextInternalID(), ExtraPlanets.instance, 80, 3, true);
	}
}
