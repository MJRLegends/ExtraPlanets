package com.mjr.extraplanets.client.handlers.capabilities;

public class StatsClientCapability implements IStatsClientCapability {
	public double radiationLevel;

	@Override
	public double getRadiationLevel() {
		return radiationLevel;
	}

	@Override
	public void setRadiationLevel(double radiationLevel) {
		this.radiationLevel = radiationLevel;
	}
}
