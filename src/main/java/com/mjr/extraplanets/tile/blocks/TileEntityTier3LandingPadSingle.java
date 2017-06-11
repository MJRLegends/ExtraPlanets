package com.mjr.extraplanets.tile.blocks;

import java.util.ArrayList;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.mjr.extraplanets.blocks.BlockCustomLandingPadFull;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class TileEntityTier3LandingPadSingle extends TileEntity implements ITickable {
	@Override
	public void update() {
		if (!this.world.isRemote) {
			final ArrayList<TileEntity> attachedLaunchPads = new ArrayList<TileEntity>();

			for (int x = this.getPos().getX() - 2; x < this.getPos().getX() + 3; x++) {
				for (int z = this.getPos().getZ() - 2; z < this.getPos().getZ() + 3; z++) {
					final TileEntity tile = this.world.getTileEntity(new BlockPos(x, this.getPos().getY(), z));

					if (tile instanceof TileEntityTier3LandingPadSingle) {
						attachedLaunchPads.add(tile);
					}
				}
			}

			if (attachedLaunchPads.size() == 25) {
				for (final TileEntity tile : attachedLaunchPads) {
					this.world.markTileEntityForRemoval(tile);
				}
				
				this.getPos().south(1);
				this.getPos().east(1);

				this.world.setBlockState(this.getPos(), ExtraPlanets_Blocks.ADVANCED_LAUCHPAD_FULL.getStateFromMeta(BlockCustomLandingPadFull.EnumLandingPadFullType.TIER_3_ROCKET_PAD.getMeta()), 2);
			}
		}
	}

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		return oldState.getBlock() != newSate.getBlock();
	}
}