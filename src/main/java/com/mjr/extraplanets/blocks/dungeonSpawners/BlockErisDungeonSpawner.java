package com.mjr.extraplanets.blocks.dungeonSpawners;

import micdoodle8.mods.galacticraft.core.blocks.BlockBossSpawner;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockErisDungeonSpawner extends BlockBossSpawner {
	public BlockErisDungeonSpawner(String assetName) {
		super(assetName);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return null;
		//return new TileEntityDungeonSpawnerEris();
	}
}