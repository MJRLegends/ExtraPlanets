package com.mjr.extraplanets.api.enitity;

import net.minecraft.util.BlockPos;

/**
 * An entity which requires a hook into landing pad events should implement this interface
 */
public interface IPoweredLandable extends IPoweredDockable {
	/**
	 * Called when the entity lands on a dock
	 * 
	 * @param pos
	 *            coordinates of the dock
	 */
	void landEntity(BlockPos pos);
}
