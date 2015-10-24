package com.mjr.extraplanets.planets.Venus.spacestation;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class OrbitSpinSaveDataVenus extends WorldSavedData
{
    public static final String saveDataID = "EPVenusSpinData";
    public NBTTagCompound datacompound;
    private NBTTagCompound alldata;
    private int dim = 0;

    public OrbitSpinSaveDataVenus(String s)
    {
        super(OrbitSpinSaveDataVenus.saveDataID);
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

    public static OrbitSpinSaveDataVenus initWorldData(World world)
    {
        OrbitSpinSaveDataVenus worldData = (OrbitSpinSaveDataVenus) world.loadItemData(OrbitSpinSaveDataVenus.class, OrbitSpinSaveDataVenus.saveDataID);

        if (worldData == null)
        {
            worldData = new OrbitSpinSaveDataVenus("");
            world.setItemData(OrbitSpinSaveDataVenus.saveDataID, worldData);
            if (world.provider instanceof WorldProviderVenusOrbit)
            {
                worldData.dim = world.provider.dimensionId;
                ((WorldProviderVenusOrbit) world.provider).writeToNBT(worldData.datacompound);
            }
            worldData.markDirty();
        }
        else if (world.provider instanceof WorldProviderVenusOrbit)
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