package com.mjr.extraplanets.planets.Pluto.spacestation;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class OrbitSpinSaveDataPluto extends WorldSavedData
{
	public static final String saveDataID = "EPPlutoSpinData";
	public NBTTagCompound datacompound;
	private NBTTagCompound alldata;
	private int dim = 0;

	public OrbitSpinSaveDataPluto(String s)
	{
		super(OrbitSpinSaveDataPluto.saveDataID);
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

	public static OrbitSpinSaveDataPluto initWorldData(World world)
	{
		OrbitSpinSaveDataPluto worldData = (OrbitSpinSaveDataPluto) world.loadItemData(OrbitSpinSaveDataPluto.class, OrbitSpinSaveDataPluto.saveDataID);

		if (worldData == null)
		{
			worldData = new OrbitSpinSaveDataPluto("");
			world.setItemData(OrbitSpinSaveDataPluto.saveDataID, worldData);
			if (world.provider instanceof WorldProviderPlutoOrbit)
			{
				worldData.dim = world.provider.dimensionId;
				((WorldProviderPlutoOrbit) world.provider).writeToNBT(worldData.datacompound);
			}
			worldData.markDirty();
		}
		else if (world.provider instanceof WorldProviderPlutoOrbit)
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