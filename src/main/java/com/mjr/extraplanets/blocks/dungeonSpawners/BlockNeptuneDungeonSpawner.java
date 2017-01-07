package com.mjr.extraplanets.blocks.dungeonSpawners;

import micdoodle8.mods.galacticraft.core.blocks.BlockBossSpawner;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.mjr.extraplanets.tile.dungeonSpawners.TileEntityDungeonSpawnerNeptune;

public class BlockNeptuneDungeonSpawner extends BlockBossSpawner {
	public BlockNeptuneDungeonSpawner(String assetName) {
		super(assetName);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityDungeonSpawnerNeptune();
	}
}