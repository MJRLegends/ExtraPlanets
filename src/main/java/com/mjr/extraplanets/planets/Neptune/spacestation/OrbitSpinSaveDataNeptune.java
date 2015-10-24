package com.mjr.extraplanets.planets.Neptune.spacestation;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class OrbitSpinSaveDataNeptune extends WorldSavedData
{
    public static final String saveDataID = "EPNeptuneSpinData";
    public NBTTagCompound datacompound;
    private NBTTagCompound alldata;
    private int dim = 0;

    public OrbitSpinSaveDataNeptune(String s)
    {
        super(OrbitSpinSaveDataNeptune.saveDataID);
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

    public static OrbitSpinSaveDataNeptune initWorldData(World world)
    {
        OrbitSpinSaveDataNeptune worldData = (OrbitSpinSaveDataNeptune) world.loadItemData(OrbitSpinSaveDataNeptune.class, OrbitSpinSaveDataNeptune.saveDataID);

        if (worldData == null)
        {
            worldData = new OrbitSpinSaveDataNeptune("");
            world.setItemData(OrbitSpinSaveDataNeptune.saveDataID, worldData);
            if (world.provider instanceof WorldProviderNeptuneOrbit)
            {
                worldData.dim = world.provider.dimensionId;
                ((WorldProviderNeptuneOrbit) world.provider).writeToNBT(worldData.datacompound);
            }
            worldData.markDirty();
        }
        else if (world.provider instanceof WorldProviderNeptuneOrbit)
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