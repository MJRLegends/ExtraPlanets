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

public class EntityVenusRover extends EntityPoweredVehicleBase {

	public EntityVenusRover(World var1) {
		super(var1);
	}

	public EntityVenusRover(World par2World, float f, float g, float h, int itemDamage) {
		super(par2World, f, g, h, itemDamage);
	}

	@Override
	public String getInventoryName() {
		return "VenusRover";
	}

	public List<ItemStack> getItemsDropped() {
		final List<ItemStack> items = new ArrayList<ItemStack>();

		ItemStack vehicle = new ItemStack(ExtraPlanets_Items.venusRover, 1, this.roverType);
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
		return new ItemStack(ExtraPlanets_Items.venusRover, 1, this.roverType);
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
	public void updateRiderPosition() {
		if (this.riddenByEntity != null) {
			final double var1 = Math.cos(this.rotationYaw * Math.PI / 180.0D + 114.8) * -0.2D;
			final double var3 = Math.sin(this.rotationYaw * Math.PI / 180.0D + 114.8) * -0.9D;
			this.riddenByEntity.setPosition(this.posX + var1, (this.posY - 2.4 + this.riddenByEntity.getYOffset()) + 0.6, this.posZ + var3);
		}
	}

	@Override
	public void featureUpdate() {		
	}
}