package com.mjr.extraplanets.blocks.dungeonSpawners;

import micdoodle8.mods.galacticraft.core.blocks.BlockBossSpawner;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.tile.dungeonSpawners.TileEntityDungeonSpawnerSaturn;
import com.mjr.extraplanets.tile.dungeonSpawners.TileEntityDungeonSpawnerSaturnDefault;

public class BlockSaturnDungeonSpawner extends BlockBossSpawner {
	public BlockSaturnDungeonSpawner(String assetName) {
		super(assetName);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		if (Config.useDefaultBosses)
			return new TileEntityDungeonSpawnerSaturnDefault();
		else
			return new TileEntityDungeonSpawnerSaturn();
	}
}