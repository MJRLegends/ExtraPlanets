package com.mjr.extraplanets.blocks.dungeonSpawners;

import micdoodle8.mods.galacticraft.core.blocks.BlockBossSpawner;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerEris;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerErisDefault;

public class BlockErisDungeonSpawner extends BlockBossSpawner {
	public BlockErisDungeonSpawner(String assetName) {
		super(assetName);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		if (Config.USE_DEFAULT_BOSSES)
			return new TileEntityDungeonSpawnerErisDefault();
		else
			return new TileEntityDungeonSpawnerEris();
	}
}