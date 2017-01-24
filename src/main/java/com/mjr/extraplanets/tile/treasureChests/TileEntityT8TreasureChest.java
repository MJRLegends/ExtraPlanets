package com.mjr.extraplanets.tile.treasureChests;

import micdoodle8.mods.galacticraft.core.tile.TileEntityTreasureChest;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityT8TreasureChest extends TileEntityTreasureChest
{
    public TileEntityT8TreasureChest()
    {
        super(8);
    }

    public TileEntityT8TreasureChest(int tier)
    {
        super(tier);
    }

    public static TileEntityT8TreasureChest findClosest(Entity entity)
    {
        double distance = Double.MAX_VALUE;
        TileEntityT8TreasureChest chest = null;
        for (final TileEntity tile : entity.worldObj.loadedTileEntityList)
        {
            if (tile instanceof TileEntityT8TreasureChest)
            {
                double dist = entity.getDistanceSq(tile.getPos().getX() + 0.5, tile.getPos().getY() + 0.5, tile.getPos().getZ() + 0.5);
                if (dist < distance)
                {
                    distance = dist;
                    chest = (TileEntityT8TreasureChest) tile;
                }
            }
        }

        return chest;
    }
}