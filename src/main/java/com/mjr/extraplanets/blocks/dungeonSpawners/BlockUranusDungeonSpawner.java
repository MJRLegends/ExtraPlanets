package com.mjr.extraplanets.blocks.dungeonSpawners;

import micdoodle8.mods.galacticraft.core.blocks.BlockBossSpawner;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.mjr.extraplanets.tile.dungeonSpawners.TileEntityDungeonSpawnerUranus;

public class BlockUranusDungeonSpawner extends BlockBossSpawner {
	public BlockUranusDungeonSpawner(String assetName) {
		super(assetName);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityDungeonSpawnerUranus();
	}
}