package com.mjr.extraplanets.api;

/**
 * Implement into entities that can be powered when placed on power docks
 */
public interface IPowerable {
	public float addPower(float amount, boolean doDrain);

	public float removePower(float amount);
}