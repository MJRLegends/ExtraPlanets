package com.mjr.extraplanets.blocks.dungeonSpawners;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerMercury;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerMercuryDefault;

import micdoodle8.mods.galacticraft.core.blocks.BlockBossSpawner;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMercuryDungeonSpawner extends BlockBossSpawner {
	public BlockMercuryDungeonSpawner(String name) {
		super(name);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		if (Config.USE_DEFAULT_BOSSES)
			return new TileEntityDungeonSpawnerMercuryDefault();
		else
			return new TileEntityDungeonSpawnerMercury();
	}
}