package com.mjr.extraplanets.planets.Mercury.spacestation;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class OrbitSpinSaveDataMercury extends WorldSavedData
{
	public static final String saveDataID = "EPMercurySpinData";
	public NBTTagCompound datacompound;
	private NBTTagCompound alldata;
	private int dim = 0;

	public OrbitSpinSaveDataMercury(String s)
	{
		super(OrbitSpinSaveDataMercury.saveDataID);
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

	public static OrbitSpinSaveDataMercury initWorldData(World world)
	{
		OrbitSpinSaveDataMercury worldData = (OrbitSpinSaveDataMercury) world.loadItemData(OrbitSpinSaveDataMercury.class, OrbitSpinSaveDataMercury.saveDataID);

		if (worldData == null)
		{
			worldData = new OrbitSpinSaveDataMercury("");
			world.setItemData(OrbitSpinSaveDataMercury.saveDataID, worldData);
			if (world.provider instanceof WorldProviderMercuryOrbit)
			{
				worldData.dim = world.provider.dimensionId;
				((WorldProviderMercuryOrbit) world.provider).writeToNBT(worldData.datacompound);
			}
			worldData.markDirty();
		}
		else if (world.provider instanceof WorldProviderMercuryOrbit)
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