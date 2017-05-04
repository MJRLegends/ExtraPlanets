package com.mjr.extraplanets.api;

import micdoodle8.mods.galacticraft.api.entity.IDockable;
import micdoodle8.mods.galacticraft.api.tile.ILandingPadAttachable;
import net.minecraft.world.IBlockAccess;

import java.util.HashSet;

public interface IPowerDock
{
    public HashSet<ILandingPadAttachable> getConnectedTiles();

    public boolean isBlockAttachable(IBlockAccess world, int x, int y, int z);

    public IDockable getDockedEntity();

	void dockEntity(IDockable entity);
}
