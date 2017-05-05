package com.mjr.extraplanets.entities.vehicles;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.mjr.extraplanets.api.IPowerDock;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.tile.machines.TileEntityPoweredChargingPad;

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

		ItemStack vehicle = new ItemStack(ExtraPlanets_Items.marsRover, 1, this.roverType);
		vehicle.setTagCompound(new NBTTagCompound());
		vehicle.getTagCompound().setFloat("currentPowerCapacity", 0);
		items.add(vehicle);

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
		return dock instanceof TileEntityPoweredChargingPad;
	}

	@Override
	public float addPower(float amount, boolean doDrain) {
		float beforePower = this.getCurrentPowerCapacity();
		if (this.getCurrentPowerCapacity() >= this.getPowerMaxCapacity())
			this.setCurrentPowerCapacity(this.getPowerMaxCapacity());
		else
			this.setCurrentPowerCapacity(this.getCurrentPowerCapacity() + amount);
		return this.getCurrentPowerCapacity() - beforePower;
	}

	@Override
	public float removePower(float amount) {
		float beforePower = this.getCurrentPowerCapacity();
		if ((this.getCurrentPowerCapacity() - amount) <= 0)
			this.setCurrentPowerCapacity(0);
		else
			this.setCurrentPowerCapacity(this.getCurrentPowerCapacity() - amount);
		return beforePower - this.getCurrentPowerCapacity();
	}
}