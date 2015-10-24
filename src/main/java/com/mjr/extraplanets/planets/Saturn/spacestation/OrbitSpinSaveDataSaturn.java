package com.mjr.extraplanets.planets.Saturn.spacestation;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class OrbitSpinSaveDataSaturn extends WorldSavedData
{
    public static final String saveDataID = "EPSaturnSpinData";
    public NBTTagCompound datacompound;
    private NBTTagCompound alldata;
    private int dim = 0;

    public OrbitSpinSaveDataSaturn(String s)
    {
        super(OrbitSpinSaveDataSaturn.saveDataID);
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

    public static OrbitSpinSaveDataSaturn initWorldData(World world)
    {
        OrbitSpinSaveDataSaturn worldData = (OrbitSpinSaveDataSaturn) world.loadItemData(OrbitSpinSaveDataSaturn.class, OrbitSpinSaveDataSaturn.saveDataID);

        if (worldData == null)
        {
            worldData = new OrbitSpinSaveDataSaturn("");
            world.setItemData(OrbitSpinSaveDataSaturn.saveDataID, worldData);
            if (world.provider instanceof WorldProviderSaturnOrbit)
            {
                worldData.dim = world.provider.dimensionId;
                ((WorldProviderSaturnOrbit) world.provider).writeToNBT(worldData.datacompound);
            }
            worldData.markDirty();
        }
        else if (world.provider instanceof WorldProviderSaturnOrbit)
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