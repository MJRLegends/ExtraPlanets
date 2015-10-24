package com.mjr.extraplanets.planets.Eris.spacestation;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class OrbitSpinSaveDataEris extends WorldSavedData
{
    public static final String saveDataID = "EPErisSpinData";
    public NBTTagCompound datacompound;
    private NBTTagCompound alldata;
    private int dim = 0;

    public OrbitSpinSaveDataEris(String s)
    {
        super(OrbitSpinSaveDataEris.saveDataID);
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

    public static OrbitSpinSaveDataEris initWorldData(World world)
    {
        OrbitSpinSaveDataEris worldData = (OrbitSpinSaveDataEris) world.loadItemData(OrbitSpinSaveDataEris.class, OrbitSpinSaveDataEris.saveDataID);

        if (worldData == null)
        {
            worldData = new OrbitSpinSaveDataEris("");
            world.setItemData(OrbitSpinSaveDataEris.saveDataID, worldData);
            if (world.provider instanceof WorldProviderErisOrbit)
            {
                worldData.dim = world.provider.dimensionId;
                ((WorldProviderErisOrbit) world.provider).writeToNBT(worldData.datacompound);
            }
            worldData.markDirty();
        }
        else if (world.provider instanceof WorldProviderErisOrbit)
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