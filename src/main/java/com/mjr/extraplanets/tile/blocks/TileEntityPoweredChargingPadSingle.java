package com.mjr.extraplanets.tile.blocks;

import java.util.ArrayList;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.mjr.extraplanets.blocks.BlockCustomLandingPadFull;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class TileEntityPoweredChargingPadSingle extends TileEntity implements ITickable {
	@Override
	public void update() {
		if (!this.worldObj.isRemote) {
			final ArrayList<TileEntity> attachedLaunchPads = new ArrayList<TileEntity>();

			for (int x = this.getPos().getX() - 2; x < this.getPos().getX() + 3; x++) {
				for (int z = this.getPos().getZ() - 2; z < this.getPos().getZ() + 3; z++) {
					final TileEntity tile = this.worldObj.getTileEntity(new BlockPos(x, this.getPos().getY(), z));

					if (tile instanceof TileEntityPoweredChargingPadSingle) {
						attachedLaunchPads.add(tile);
					}
				}
			}

			if (attachedLaunchPads.size() == 25) {
				for (final TileEntity tile : attachedLaunchPads) {
					this.worldObj.markTileEntityForRemoval(tile);
				}
				
				this.getPos().south(1);
				this.getPos().east(1);
				this.worldObj.setBlockState(this.getPos(), ExtraPlanets_Blocks.ADVANCED_LAUCHPAD_FULL.getDefaultState().withProperty(BlockCustomLandingPadFull.PAD_TYPE, BlockCustomLandingPadFull.EnumLandingPadFullType.POWER_CHARGING_PAD));
			}
		}
	}

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		return oldState.getBlock() != newSate.getBlock();
	}
}