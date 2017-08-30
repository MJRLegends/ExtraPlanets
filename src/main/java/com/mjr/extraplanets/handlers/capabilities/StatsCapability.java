package com.mjr.extraplanets.handlers.capabilities;

import java.lang.ref.WeakReference;

import micdoodle8.mods.galacticraft.core.util.GCLog;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;

public class StatsCapability implements IStatsCapability {
	public WeakReference<EntityPlayerMP> player;
	public double radiationLevel;
	public int buildFlags = 0;

	@Override
	public double getRadiationLevel() {
		return radiationLevel;
	}

	@Override
	public void setRadiationLevel(double radiationLevel) {
		this.radiationLevel = radiationLevel;
	}

	@Override
	public void saveNBTData(NBTTagCompound nbt) {
		nbt.setDouble("radiationLevel", this.radiationLevel);
	}

	@Override
	public void loadNBTData(NBTTagCompound nbt) {
		try {
			this.radiationLevel = nbt.getDouble("radiationLevel");
		} catch (Exception e) {
			GCLog.severe("Found error in saved ExtraPlanets player data for " + player.get().getGameProfile().getName() + " - this should fix itself next relog.");
			e.printStackTrace();
		}

		GCLog.debug("Finished loading ExtraPlanets player data for " + player.get().getGameProfile().getName() + " : " + this.buildFlags);
	}

	@Override
	public void copyFrom(IStatsCapability oldData, boolean keepInv) {
		this.radiationLevel = oldData.getRadiationLevel();
	}

	@Override
	public WeakReference<EntityPlayerMP> getPlayer() {
		return player;
	}

	@Override
	public void setPlayer(WeakReference<EntityPlayerMP> player) {
		this.player = player;
	}
}
