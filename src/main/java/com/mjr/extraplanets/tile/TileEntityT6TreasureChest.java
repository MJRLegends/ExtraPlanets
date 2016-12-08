package com.mjr.extraplanets.tile;

import micdoodle8.mods.galacticraft.core.tile.TileEntityTreasureChest;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityT6TreasureChest extends TileEntityTreasureChest
{
    public TileEntityT6TreasureChest()
    {
        super(2);
    }

    public TileEntityT6TreasureChest(int tier)
    {
        super(tier);
    }

    public static TileEntityT6TreasureChest findClosest(Entity entity)
    {
        double distance = Double.MAX_VALUE;
        TileEntityT6TreasureChest chest = null;
        for (final TileEntity tile : entity.worldObj.loadedTileEntityList)
        {
            if (tile instanceof TileEntityT6TreasureChest)
            {
                double dist = entity.getDistanceSq(tile.getPos().getX() + 0.5, tile.getPos().getY() + 0.5, tile.getPos().getZ() + 0.5);
                if (dist < distance)
                {
                    distance = dist;
                    chest = (TileEntityT6TreasureChest) tile;
                }
            }
        }

        return chest;
    }
}