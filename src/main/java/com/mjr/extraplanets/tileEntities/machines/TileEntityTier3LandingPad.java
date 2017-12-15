package com.mjr.extraplanets.tileEntities.machines;

import java.util.HashSet;
import java.util.List;

import micdoodle8.mods.galacticraft.api.entity.IDockable;
import micdoodle8.mods.galacticraft.api.entity.IFuelable;
import micdoodle8.mods.galacticraft.api.entity.ILandable;
import micdoodle8.mods.galacticraft.api.tile.IFuelDock;
import micdoodle8.mods.galacticraft.api.tile.ILandingPadAttachable;
import micdoodle8.mods.galacticraft.api.vector.BlockVec3;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.blocks.BlockMulti;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.core.tile.IMultiBlock;
import micdoodle8.mods.galacticraft.core.tile.TileEntityMulti;
import micdoodle8.mods.galacticraft.planets.mars.tile.TileEntityLaunchController;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.FluidStack;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityTier3LandingPad extends TileEntityMulti implements IMultiBlock, IFuelable, IFuelDock {
	private IDockable dockedEntity;

	@Override
	public void updateEntity() {
		super.updateEntity();

		if (!this.worldObj.isRemote) {
			final List<?> list = this.worldObj.getEntitiesWithinAABB(IFuelable.class, AxisAlignedBB.getBoundingBox(this.xCoord - 1.5D, this.yCoord, this.zCoord - 1.5D, this.xCoord + 1.5D, this.yCoord + 1.0D, this.zCoord + 1.5D));

			boolean docked = false;

			for (final Object o : list) {
				if (o instanceof IDockable && !((Entity) o).isDead) {
					docked = true;

					final IDockable fuelable = (IDockable) o;

					if (fuelable != this.dockedEntity && fuelable.isDockValid(this)) {
						if (fuelable instanceof ILandable) {
							((ILandable) fuelable).landEntity(this.xCoord, this.yCoord, this.zCoord);
						} else {
							fuelable.setPad(this);
						}
					}

					break;
				}
			}

			if (!docked) {
				this.dockedEntity = null;
			}
		}
	}

	@Override
	public boolean canUpdate() {
		return true;
	}

	@Override
	public boolean onActivated(EntityPlayer entityPlayer) {
		return false;
	}

	@Override
	public void onCreate(BlockVec3 placedPosition) {
		this.mainBlockPosition = placedPosition;
		this.markDirty();

		for (int x = -1; x < 4; x++) {
			for (int z = -1; z < 4; z++) {
				final BlockVec3 vecToAdd = new BlockVec3(placedPosition.x + x, placedPosition.y, placedPosition.z + z);

				if (!vecToAdd.equals(placedPosition)) {
					((BlockMulti) GCBlocks.fakeBlock).makeFakeBlock(this.worldObj, vecToAdd, placedPosition, 2);
				}
			}
		}
	}

	@Override
	public void onDestroy(TileEntity callingBlock) {
		final BlockVec3 thisBlock = new BlockVec3(this);

		this.worldObj.func_147480_a(thisBlock.x, thisBlock.y, thisBlock.z, true);

		for (int x = -1; x < 4; x++) {
			for (int z = -1; z < 4; z++) {
				if (this.worldObj.isRemote && this.worldObj.rand.nextDouble() < 0.1D) {
					FMLClientHandler.instance().getClient().effectRenderer.addBlockDestroyEffects(thisBlock.x + x, thisBlock.y, thisBlock.z + z, ExtraPlanets_Blocks.advancedLaunchPad,
							Block.getIdFromBlock(ExtraPlanets_Blocks.advancedLaunchPad) >> 12 & 255);
				}

				this.worldObj.func_147480_a(thisBlock.x + x, thisBlock.y, thisBlock.z + z, false);
			}
		}

		if (this.dockedEntity != null) {
			this.dockedEntity.onPadDestroyed();
			this.dockedEntity = null;
		}

	}

	@Override
	public int addFuel(FluidStack liquid, boolean doFill) {
		if (this.dockedEntity != null) {
			return this.dockedEntity.addFuel(liquid, doFill);
		}

		return 0;
	}

	@Override
	public FluidStack removeFuel(int amount) {
		if (this.dockedEntity != null) {
			return this.dockedEntity.removeFuel(amount);
		}

		return null;
	}

	@Override
	public HashSet<ILandingPadAttachable> getConnectedTiles() {
		HashSet<ILandingPadAttachable> connectedTiles = new HashSet<ILandingPadAttachable>();

		for (int x = this.xCoord - 1; x < this.xCoord + 4; x++) {
			this.testConnectedTile(x, this.zCoord - 2, connectedTiles);
			this.testConnectedTile(x, this.zCoord + 2, connectedTiles);
		}

		for (int z = this.zCoord - 1; z < this.zCoord + 4; z++) {
			this.testConnectedTile(this.xCoord - 2, z, connectedTiles);
			this.testConnectedTile(this.xCoord + 2, z, connectedTiles);
		}

		return connectedTiles;
	}

	private void testConnectedTile(int x, int z, HashSet<ILandingPadAttachable> connectedTiles) {
		if (!this.worldObj.blockExists(x, this.yCoord, z))
			return;

		final TileEntity tile = this.worldObj.getTileEntity(x, this.yCoord, z);

		if (tile instanceof ILandingPadAttachable && ((ILandingPadAttachable) tile).canAttachToLandingPad(this.worldObj, this.xCoord, this.yCoord, this.zCoord)) {
			connectedTiles.add((ILandingPadAttachable) tile);
			if (GalacticraftCore.isPlanetsLoaded && tile instanceof TileEntityLaunchController)
				((TileEntityLaunchController) tile).setAttachedPad(this);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox() {
		return AxisAlignedBB.getBoundingBox(xCoord - 1, yCoord, zCoord - 1, xCoord + 2, yCoord + 0.4D, zCoord + 2);
	}

	@Override
	public boolean isBlockAttachable(IBlockAccess world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);

		if (tile != null && tile instanceof ILandingPadAttachable) {
			return ((ILandingPadAttachable) tile).canAttachToLandingPad(world, this.xCoord, this.yCoord, this.zCoord + 1);
		}

		return false;
	}

	@Override
	public IDockable getDockedEntity() {
		return this.dockedEntity;
	}

	@Override
	public void dockEntity(IDockable entity) {
		this.dockedEntity = entity;
	}
}
