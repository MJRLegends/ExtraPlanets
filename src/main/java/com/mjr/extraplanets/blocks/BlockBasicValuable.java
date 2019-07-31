package com.mjr.extraplanets.blocks;

import com.mjr.mjrlegendslib.block.BlockBasic;

import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockBasicValuable extends BlockBasic implements IDetectableResource {

	private boolean valuableResource;
	
	public BlockBasicValuable(Material material) {
		super(material);
		this.valuableResource = true;
	}

	public BlockBasicValuable(Material material, boolean valuableResource) {
		super(material);
		this.valuableResource = valuableResource;
	}

	@Override
	public boolean isValueable(IBlockState metadata) {
		return valuableResource;
	}

}
