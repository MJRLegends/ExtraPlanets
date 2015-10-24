package com.mjr.extraplanets.planets.Jupiter.spacestation;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class OrbitSpinSaveDataJupiter extends WorldSavedData
{
    public static final String saveDataID = "EPJupiterSpinData";
    public NBTTagCompound datacompound;
    private NBTTagCompound alldata;
    private int dim = 0;

    public OrbitSpinSaveDataJupiter(String s)
    {
        super(OrbitSpinSaveDataJupiter.saveDataID);
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

    public static OrbitSpinSaveDataJupiter initWorldData(World world)
    {
        OrbitSpinSaveDataJupiter worldData = (OrbitSpinSaveDataJupiter) world.loadItemData(OrbitSpinSaveDataJupiter.class, OrbitSpinSaveDataJupiter.saveDataID);

        if (worldData == null)
        {
            worldData = new OrbitSpinSaveDataJupiter("");
            world.setItemData(OrbitSpinSaveDataJupiter.saveDataID, worldData);
            if (world.provider instanceof WorldProviderJupiterOrbit)
            {
                worldData.dim = world.provider.dimensionId;
                ((WorldProviderJupiterOrbit) world.provider).writeToNBT(worldData.datacompound);
            }
            worldData.markDirty();
        }
        else if (world.provider instanceof WorldProviderJupiterOrbit)
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