package com.mjr.extraplanets.tile;

import micdoodle8.mods.galacticraft.core.tile.TileEntityTreasureChest;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityT7TreasureChest extends TileEntityTreasureChest
{
    public TileEntityT7TreasureChest()
    {
        super(7);
    }

    public TileEntityT7TreasureChest(int tier)
    {
        super(tier);
    }

    public static TileEntityT7TreasureChest findClosest(Entity entity)
    {
        double distance = Double.MAX_VALUE;
        TileEntityT7TreasureChest chest = null;
        for (final TileEntity tile : entity.worldObj.loadedTileEntityList)
        {
            if (tile instanceof TileEntityT7TreasureChest)
            {
                double dist = entity.getDistanceSq(tile.getPos().getX() + 0.5, tile.getPos().getY() + 0.5, tile.getPos().getZ() + 0.5);
                if (dist < distance)
                {
                    distance = dist;
                    chest = (TileEntityT7TreasureChest) tile;
                }
            }
        }

        return chest;
    }
}