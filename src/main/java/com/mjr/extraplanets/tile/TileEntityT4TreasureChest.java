package com.mjr.extraplanets.tile;

import micdoodle8.mods.galacticraft.core.tile.TileEntityTreasureChest;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityT4TreasureChest extends TileEntityTreasureChest
{
    public TileEntityT4TreasureChest()
    {
        super(4);
    }

    public TileEntityT4TreasureChest(int tier)
    {
        super(tier);
    }

    public static TileEntityT4TreasureChest findClosest(Entity entity)
    {
        double distance = Double.MAX_VALUE;
        TileEntityT4TreasureChest chest = null;
        for (final TileEntity tile : entity.worldObj.loadedTileEntityList)
        {
            if (tile instanceof TileEntityT4TreasureChest)
            {
                double dist = entity.getDistanceSq(tile.getPos().getX() + 0.5, tile.getPos().getY() + 0.5, tile.getPos().getZ() + 0.5);
                if (dist < distance)
                {
                    distance = dist;
                    chest = (TileEntityT4TreasureChest) tile;
                }
            }
        }

        return chest;
    }
}