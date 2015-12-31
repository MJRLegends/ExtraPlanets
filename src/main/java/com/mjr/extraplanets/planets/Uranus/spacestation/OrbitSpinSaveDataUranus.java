package com.mjr.extraplanets.planets.Uranus.spacestation;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class OrbitSpinSaveDataUranus extends WorldSavedData
{
	public static final String saveDataID = "EPUranusSpinData";
	public NBTTagCompound datacompound;
	private NBTTagCompound alldata;
	private int dim = 0;

	public OrbitSpinSaveDataUranus(String s)
	{
		super(OrbitSpinSaveDataUranus.saveDataID);
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

	public static OrbitSpinSaveDataUranus initWorldData(World world)
	{
		OrbitSpinSaveDataUranus worldData = (OrbitSpinSaveDataUranus) world.loadItemData(OrbitSpinSaveDataUranus.class, OrbitSpinSaveDataUranus.saveDataID);

		if (worldData == null)
		{
			worldData = new OrbitSpinSaveDataUranus("");
			world.setItemData(OrbitSpinSaveDataUranus.saveDataID, worldData);
			if (world.provider instanceof WorldProviderUranusOrbit)
			{
				worldData.dim = world.provider.dimensionId;
				((WorldProviderUranusOrbit) world.provider).writeToNBT(worldData.datacompound);
			}
			worldData.markDirty();
		}
		else if (world.provider instanceof WorldProviderUranusOrbit)
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