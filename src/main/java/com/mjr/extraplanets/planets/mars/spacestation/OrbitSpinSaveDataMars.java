package com.mjr.extraplanets.planets.mars.spacestation;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class OrbitSpinSaveDataMars extends WorldSavedData
{
	public static final String saveDataID = "EPMarsSpinData";
	public NBTTagCompound datacompound;
	private NBTTagCompound alldata;
	private int dim = 0;

	public OrbitSpinSaveDataMars(String s)
	{
		super(OrbitSpinSaveDataMars.saveDataID);
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

	public static OrbitSpinSaveDataMars initWorldData(World world)
	{
		OrbitSpinSaveDataMars worldData = (OrbitSpinSaveDataMars) world.loadItemData(OrbitSpinSaveDataMars.class, OrbitSpinSaveDataMars.saveDataID);

		if (worldData == null)
		{
			worldData = new OrbitSpinSaveDataMars("");
			world.setItemData(OrbitSpinSaveDataMars.saveDataID, worldData);
			if (world.provider instanceof WorldProviderMarsOrbit)
			{
				worldData.dim = world.provider.dimensionId;
				((WorldProviderMarsOrbit) world.provider).writeToNBT(worldData.datacompound);
			}
			worldData.markDirty();
		}
		else if (world.provider instanceof WorldProviderMarsOrbit)
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