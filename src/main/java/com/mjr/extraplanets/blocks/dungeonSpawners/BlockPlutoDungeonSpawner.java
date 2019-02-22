package com.mjr.extraplanets.blocks.dungeonSpawners;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerPluto;
import com.mjr.extraplanets.tileEntities.dungeonSpawners.TileEntityDungeonSpawnerPlutoDefault;

import micdoodle8.mods.galacticraft.core.blocks.BlockBossSpawner;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPlutoDungeonSpawner extends BlockBossSpawner {
	public BlockPlutoDungeonSpawner(String name) {
		super(name);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		if (Config.USE_DEFAULT_BOSSES)
			return new TileEntityDungeonSpawnerPlutoDefault();
		else
			return new TileEntityDungeonSpawnerPluto();
	}
}