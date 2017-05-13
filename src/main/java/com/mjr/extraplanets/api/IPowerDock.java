package com.mjr.extraplanets.api;

import java.util.HashSet;

import micdoodle8.mods.galacticraft.api.tile.ILandingPadAttachable;
import net.minecraft.world.IBlockAccess;

public interface IPowerDock
{
    public HashSet<ILandingPadAttachable> getConnectedTiles();

    public boolean isBlockAttachable(IBlockAccess world, int x, int y, int z);

    public IPoweredDockable getDockedEntity();

	void dockEntity(IPoweredDockable entity);
}
