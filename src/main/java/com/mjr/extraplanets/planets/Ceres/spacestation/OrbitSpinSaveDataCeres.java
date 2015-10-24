package com.mjr.extraplanets.planets.Ceres.spacestation;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class OrbitSpinSaveDataCeres extends WorldSavedData
{
    public static final String saveDataID = "EPCeresSpinData";
    public NBTTagCompound datacompound;
    private NBTTagCompound alldata;
    private int dim = 0;

    public OrbitSpinSaveDataCeres(String s)
    {
        super(OrbitSpinSaveDataCeres.saveDataID);
        this.datacompound = new NBTTagCompound();
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        this.alldata = nbt;
        //world.loadItemData calls this but can't extract from alldata until we know the dimension ID
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        if (this.dim != 0)
        {
            nbt.setTag("" + this.dim, this.datacompound);
        }
    }

    public static OrbitSpinSaveDataCeres initWorldData(World world)
    {
        OrbitSpinSaveDataCeres worldData = (OrbitSpinSaveDataCeres) world.loadItemData(OrbitSpinSaveDataCeres.class, OrbitSpinSaveDataCeres.saveDataID);

        if (worldData == null)
        {
            worldData = new OrbitSpinSaveDataCeres("");
            world.setItemData(OrbitSpinSaveDataCeres.saveDataID, worldData);
            if (world.provider instanceof WorldProviderCeresOrbit)
            {
                worldData.dim = world.provider.dimensionId;
                ((WorldProviderCeresOrbit) world.provider).writeToNBT(worldData.datacompound);
            }
            worldData.markDirty();
        }
        else if (world.provider instanceof WorldProviderCeresOrbit)
        {
            worldData.dim = world.provider.dimensionId;

            worldData.datacompound = null;
            if (worldData.alldata != null)
            {
                worldData.datacompound = worldData.alldata.getCompoundTag("" + worldData.dim);
            }
            if (worldData.datacompound == null)
            {
                worldData.datacompound = new NBTTagCompound();
            }
        }

        return worldData;
    }
}