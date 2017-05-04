package com.mjr.extraplanets.entities.vehicles;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.tile.IFuelDock;
import micdoodle8.mods.galacticraft.core.tile.TileEntityBuggyFueler;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

import com.mjr.extraplanets.api.IPowerDock;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class EntityMarsRover extends EntityPoweredVehicleBase {

	public EntityMarsRover(World var1) {
		super(var1);
	}

	public EntityMarsRover(World par2World, float f, float g, float h, int itemDamage) {
		super(par2World, f, g, h, itemDamage);
	}

	@Override
	public String getInventoryName() {
		return "MarsRover";
	}

	public List<ItemStack> getItemsDropped() {
		final List<ItemStack> items = new ArrayList<ItemStack>();

		ItemStack buggy = new ItemStack(ExtraPlanets_Items.marsRover, 1, this.roverType);
		buggy.setTagCompound(new NBTTagCompound());
		buggy.getTagCompound().setInteger("MarsRoverFuel", 0);
		items.add(buggy);

		for (ItemStack item : this.cargoItems) {
			if (item != null) {
				items.add(item);
			}
		}

		return items;
	}

	@Override
	public ItemStack getPickedResult(MovingObjectPosition target) {
		return new ItemStack(ExtraPlanets_Items.marsRover, 1, this.roverType);
	}

	@Override
	public void setPad(IPowerDock pad) {
		this.landingPad = pad;
	}

	@Override
	public IPowerDock getLandingPad() {
		return this.landingPad;
	}

	@Override
	public boolean isDockValid(IPowerDock dock) {
		return dock instanceof TileEntityBuggyFueler;
	}

	@Override
	public float addPower(float amount, boolean doDrain) {
		this.setCurrentPowerCapacity(this.getCurrentPowerCapacity() + amount);
		return this.getCurrentPowerCapacity();
	}

	@Override
	public float removePower(float amount){
		this.setCurrentPowerCapacity(this.getCurrentPowerCapacity() - amount);
		return this.getCurrentPowerCapacity();
	}
}