package com.mjr.extraplanets.blocks.dungeonSpawners;

import micdoodle8.mods.galacticraft.core.blocks.BlockBossSpawner;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.tile.dungeonSpawners.TileEntityDungeonSpawnerMercury;
import com.mjr.extraplanets.tile.dungeonSpawners.TileEntityDungeonSpawnerMercuryDefault;

public class BlockMercuryDungeonSpawner extends BlockBossSpawner {
	public BlockMercuryDungeonSpawner(String assetName) {
		super(assetName);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		if (Config.USE_DEFAULT_BOSSES)
			return new TileEntityDungeonSpawnerMercuryDefault();
		else
			return new TileEntityDungeonSpawnerMercury();
	}
}