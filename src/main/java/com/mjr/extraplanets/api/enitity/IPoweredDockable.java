package com.mjr.extraplanets.api.enitity;

import com.mjr.extraplanets.api.block.IPowerDock;
import com.mjr.extraplanets.api.block.IPowerable;

import micdoodle8.mods.galacticraft.api.entity.ICargoEntity;

/**
 * Implement into entities that are placed on fuel docks to load with cargo and fuel
 */
public interface IPoweredDockable extends IPowerable, ICargoEntity {
	/**
	 * Sets the current fuel dock for this entity
	 */
	public void setPad(IPowerDock pad);

	/**
	 * Gets the power dock when required. Must return the same one that was set.
	 */
	public IPowerDock getLandingPad();

	/**
	 * When the power dock is destroyed. Most likely kills the entity and drops it's containing items.
	 */
	public void onPadDestroyed();

	/**
	 * Whether or not the power dock this entity is on is valid.
	 * <p/>
	 * Returning false will not let setPad be called.
	 */
	public boolean isDockValid(IPowerDock dock);

	boolean inFlight();
}