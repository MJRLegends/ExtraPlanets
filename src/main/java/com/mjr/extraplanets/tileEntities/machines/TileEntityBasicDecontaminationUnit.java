package com.mjr.extraplanets.tileEntities.machines;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.core.blocks.BlockMulti;
import micdoodle8.mods.galacticraft.core.blocks.BlockMulti.EnumBlockMultiType;
import micdoodle8.mods.galacticraft.core.energy.item.ItemElectricBase;
import micdoodle8.mods.galacticraft.core.energy.tile.TileBaseElectricBlock;
import micdoodle8.mods.galacticraft.core.inventory.IInventoryDefaults;
import micdoodle8.mods.galacticraft.core.tile.IMultiBlock;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.miccore.Annotations.NetworkedField;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.blocks.BlockDecontaminationUnitFake;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.handlers.capabilities.CapabilityStatsHandler;
import com.mjr.extraplanets.handlers.capabilities.IStatsCapability;

public class TileEntityBasicDecontaminationUnit extends TileBaseElectricBlock implements IMultiBlock, IInventoryDefaults, ISidedInventory {
	private ItemStack[] containingItems = new ItemStack[1];
	@NetworkedField(targetSide = Side.CLIENT)
	private AxisAlignedBB renderAABB;

	public TileEntityBasicDecontaminationUnit() {
		super();
		this.storage.setCapacity(1000000);
	}

	@Override
	public void update() {
		if (!this.worldObj.isRemote) {
			List containedEntities = worldObj.getEntitiesWithinAABB(EntityPlayerMP.class, new AxisAlignedBB(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), this.getPos().getX() + 1, this.getPos().getY() + 2, this.getPos()
					.getZ() + 1));
			if (this.storage.getEnergyStoredGC() >= 1000000 && containedEntities.size() == 1) {
				this.storage.setEnergyStored(0);
				EntityPlayerMP player = ((EntityPlayerMP) containedEntities.get(0));
				IStatsCapability stats = null;
				if (player != null) {
					stats = (player.getCapability(CapabilityStatsHandler.EP_STATS_CAPABILITY, null));
				}
				double temp = stats.getRadiationLevel();
				double level = (temp * 10) / 100;
				if (level <= 0)
					stats.setRadiationLevel(0);
				else {
					stats.setRadiationLevel(stats.getRadiationLevel() - level);
					player.addChatMessage(new TextComponentString("" + TextFormatting.AQUA + TextFormatting.BOLD + player.getName() + TextFormatting.GOLD + ", Your Radiation Level has been reduced by 10%"));
					player.addChatMessage(new TextComponentString("" + TextFormatting.AQUA + TextFormatting.BOLD + player.getName() + TextFormatting.DARK_AQUA + ", Your Current Radiation Level is: " + (int) stats.getRadiationLevel() + "%"));
				}
			}
		}
		super.update();
	}
    
	@Override
	public void slowDischarge()
    {
    }

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		NBTTagList var2 = nbt.getTagList("Items", 10);
		this.containingItems = new ItemStack[this.getSizeInventory()];

		for (int var3 = 0; var3 < var2.tagCount(); ++var3) {
			NBTTagCompound var4 = var2.getCompoundTagAt(var3);
			int var5 = var4.getByte("Slot") & 255;

			if (var5 < this.containingItems.length) {
				this.containingItems[var5] = ItemStack.loadItemStackFromNBT(var4);
			}
		}
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		NBTTagList var2 = new NBTTagList();

		for (int var3 = 0; var3 < this.containingItems.length; ++var3) {
			if (this.containingItems[var3] != null) {
				NBTTagCompound var4 = new NBTTagCompound();
				var4.setByte("Slot", (byte) var3);
				this.containingItems[var3].writeToNBT(var4);
				var2.appendTag(var4);
			}
		}

		nbt.setTag("Items", var2);
		return nbt;
	}

	@Override
	public boolean onActivated(EntityPlayer entityPlayer) {
		entityPlayer.openGui(ExtraPlanets.instance, -1, this.worldObj, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ());
		return true;
	}

	@Override
	public void onCreate(World world, BlockPos placedPosition) {
		List<BlockPos> positions = new LinkedList();
		this.getPositions(placedPosition, positions);
		for (BlockPos vecToAdd : positions)
			((BlockDecontaminationUnitFake) ExtraPlanets_Blocks.FAKE_BLOCK_DECONTAMINATION_UNIT).makeFakeBlock(world, vecToAdd, placedPosition,
					ExtraPlanets_Blocks.FAKE_BLOCK_DECONTAMINATION_UNIT.getDefaultState().withProperty(BlockDecontaminationUnitFake.TOP, vecToAdd.getY() == placedPosition.getY() + 2));
	}

	@Override
	public BlockMulti.EnumBlockMultiType getMultiType() {
		// Not actually used - maybe this shouldn't be an IMultiBlock at all?
		return EnumBlockMultiType.MINER_BASE;
	}

	@Override
	public void getPositions(BlockPos placedPosition, List<BlockPos> positions) {
		positions.add(placedPosition.add(-2, 2, 0));
		positions.add(placedPosition.add(-2, 3, 0));
		positions.add(placedPosition.add(-2, 1, 0));
		positions.add(placedPosition.add(-2, 0, 0));
		positions.add(placedPosition.add(-2, 2, -1));
		positions.add(placedPosition.add(-2, 3, -1));
		positions.add(placedPosition.add(-2, 1, -1));
		positions.add(placedPosition.add(-2, 0, -1));
		positions.add(placedPosition.add(-1, 2, 0));
		positions.add(placedPosition.add(-1, 3, 0));
		positions.add(placedPosition.add(-1, 1, 0));
		positions.add(placedPosition.add(-1, 0, 0));
		positions.add(placedPosition.add(-1, 1, -1));
		positions.add(placedPosition.add(-1, 2, -1));
		positions.add(placedPosition.add(-1, 3, -1));
		positions.add(placedPosition.add(-1, 0, -1));
		positions.add(placedPosition.add(0, 3, 0));
		positions.add(placedPosition.add(0, 0, -1));
		positions.add(placedPosition.add(0, 1, -1));
		positions.add(placedPosition.add(0, 2, -1));
		positions.add(placedPosition.add(0, 3, -1));
		positions.add(placedPosition.add(1, 1, -1));
		positions.add(placedPosition.add(1, 0, -1));
		positions.add(placedPosition.add(1, 2, -1));
		positions.add(placedPosition.add(1, 3, -1));
		positions.add(placedPosition.add(1, 2, 0));
		positions.add(placedPosition.add(1, 3, 0));
		positions.add(placedPosition.add(1, 1, 0));
		positions.add(placedPosition.add(1, 0, 0));
		positions.add(placedPosition.add(2, 2, 0));
		positions.add(placedPosition.add(2, 3, 0));
		positions.add(placedPosition.add(2, 1, 0));
		positions.add(placedPosition.add(2, 0, 0));
		positions.add(placedPosition.add(2, 2, -1));
		positions.add(placedPosition.add(2, 3, -1));
		positions.add(placedPosition.add(2, 1, -1));
		positions.add(placedPosition.add(2, 0, -1));
	}

	@Override
	public void onDestroy(TileEntity callingBlock) {
		final BlockPos thisBlock = getPos();
		List<BlockPos> positions = new LinkedList();
		this.getPositions(thisBlock, positions);

		for (BlockPos pos : positions) {
			IBlockState stateAt = this.worldObj.getBlockState(pos);

			if (stateAt.getBlock() == ExtraPlanets_Blocks.FAKE_BLOCK_DECONTAMINATION_UNIT) {
				this.worldObj.destroyBlock(pos, false);
			}
		}
		this.worldObj.destroyBlock(thisBlock, true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox() {
		if (this.renderAABB == null) {
			this.renderAABB = new AxisAlignedBB(getPos().getX() - 1, getPos().getY(), getPos().getZ() - 1, getPos().getX() + 2, getPos().getY() + 4, getPos().getZ() + 2);
		}
		return this.renderAABB;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public double getMaxRenderDistanceSquared() {
		return Constants.RENDERDISTANCE_MEDIUM;
	}

	@Override
	public String getName() {
		return GCCoreUtil.translate("container.basic.decontamination.unit.name");
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return new int[] { 0 };
	}

	@Override
	public boolean hasCustomName() {
		return true;
	}

	@Override
	public ITextComponent getDisplayName() {
		return (this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]));
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
		return this.worldObj.getTileEntity(getPos()) == this && par1EntityPlayer.getDistanceSq(this.getPos().getX() + 0.5D, this.getPos().getY() + 0.5D, this.getPos().getZ() + 0.5D) <= 64.0D;
	}

	@Override
	public boolean isItemValidForSlot(int slotID, ItemStack itemStack) {
		return slotID == 0 && ItemElectricBase.isElectricItem(itemStack.getItem());
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return index == 0;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return this.isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public EnumSet<EnumFacing> getElectricalOutputDirections() {
		return EnumSet.noneOf(EnumFacing.class);
	}

	@Override
	public boolean shouldUseEnergy() {
		return false;
	}

	@Override
	public EnumFacing getElectricInputDirection() {
		return EnumFacing.getFront((this.getBlockMetadata() & 3) + 2);
	}

	@Override
	public ItemStack getBatteryInSlot() {
		return this.getStackInSlot(0);
	}

	@Override
	public void setDisabled(int index, boolean disabled) {
		if (this.disableCooldown == 0) {
			switch (index) {
			case 0:
				this.disabled = disabled;
				this.disableCooldown = 10;
				break;
			default:
				break;
			}
		}
	}

	@Override
	public boolean getDisabled(int index) {
		switch (index) {
		case 0:
			return this.disabled;
		default:
			break;
		}

		return true;
	}

	@Override
	public int getSizeInventory() {
		return this.containingItems.length;
	}

	@Override
	public ItemStack getStackInSlot(int par1) {
		return this.containingItems[par1];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		if (this.containingItems[par1] != null) {
			ItemStack var3;

			if (this.containingItems[par1].stackSize <= par2) {
				var3 = this.containingItems[par1];
				this.containingItems[par1] = null;
				return var3;
			} else {
				var3 = this.containingItems[par1].splitStack(par2);

				if (this.containingItems[par1].stackSize == 0) {
					this.containingItems[par1] = null;
				}

				return var3;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack removeStackFromSlot(int par1) {
		if (this.containingItems[par1] != null) {
			ItemStack var2 = this.containingItems[par1];
			this.containingItems[par1] = null;
			return var2;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
		this.containingItems[par1] = par2ItemStack;

		if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit()) {
			par2ItemStack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public EnumFacing getFront() {
		return EnumFacing.NORTH;
	}
}
