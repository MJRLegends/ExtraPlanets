package com.mjr.extraplanets.tile.treasureChests;

import micdoodle8.mods.galacticraft.core.tile.TileEntityTreasureChest;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityT9TreasureChest extends TileEntityTreasureChest
{
    public TileEntityT9TreasureChest()
    {
        super(9);
    }

    public TileEntityT9TreasureChest(int tier)
    {
        super(tier);
    }

    public static TileEntityT9TreasureChest findClosest(Entity entity)
    {
        double distance = Double.MAX_VALUE;
        TileEntityT9TreasureChest chest = null;
        for (final TileEntity tile : entity.worldObj.loadedTileEntityList)
        {
            if (tile instanceof TileEntityT9TreasureChest)
            {
                double dist = entity.getDistanceSq(tile.getPos().getX() + 0.5, tile.getPos().getY() + 0.5, tile.getPos().getZ() + 0.5);
                if (dist < distance)
                {
                    distance = dist;
                    chest = (TileEntityT9TreasureChest) tile;
                }
            }
        }

        return chest;
    }
}