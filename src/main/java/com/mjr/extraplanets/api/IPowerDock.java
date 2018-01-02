package com.mjr.extraplanets.api;

import java.util.HashSet;

import micdoodle8.mods.galacticraft.api.tile.ILandingPadAttachable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public interface IPowerDock {
	public HashSet<ILandingPadAttachable> getConnectedTiles();

	public boolean isBlockAttachable(IBlockAccess world, BlockPos pos);

	public IPoweredDockable getDockedEntity();

	void dockEntity(IPoweredDockable entity);
}