package com.mjr.extraplanets.tile;

import java.util.ArrayList;

import micdoodle8.mods.galacticraft.api.vector.BlockVec3;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class TileEntityPoweredChargingPadSingle extends TileEntity {
	@Override
	public void updateEntity() {
		if (!this.worldObj.isRemote) {
			final ArrayList<TileEntity> attachedLaunchPads = new ArrayList<TileEntity>();

			for (int x = this.xCoord - 1; x < this.xCoord + 4; x++) {
				for (int z = this.zCoord - 1; z < this.zCoord + 4; z++) {
					final TileEntity tile = this.worldObj.getTileEntity(x, this.yCoord, z);

					if (tile instanceof TileEntityPoweredChargingPadSingle) {
						attachedLaunchPads.add(tile);
					}
				}
			}

			if (attachedLaunchPads.size() == 25) {
				for (final TileEntity tile : attachedLaunchPads) {
					tile.invalidate();
					tile.getWorldObj().setBlock(tile.xCoord, tile.yCoord, tile.zCoord, Blocks.air, 0, 3);
				}

				this.worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, ExtraPlanets_Blocks.advancedLaunchPadFull, 2, 3);
				final TileEntityPoweredChargingPad tilePadFull = (TileEntityPoweredChargingPad) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord);

				if (tilePadFull != null) {
					tilePadFull.onCreate(new BlockVec3(this.xCoord, this.yCoord, this.zCoord));
				}
			}
		}
	}
}
