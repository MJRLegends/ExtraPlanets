package com.mjr.extraplanets.entities.vehicles;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.api.IPowerDock;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.tileEntities.blocks.TileEntityPoweredChargingPad;

public class EntityVenusRover extends EntityPoweredVehicleBase {

	public EntityVenusRover(World var1) {
		super(var1);
		this.invertControls = true;
	}

	public EntityVenusRover(World par2World, float f, float g, float h, int itemDamage) {
		super(par2World, f, g, h, itemDamage);
		this.invertControls = true;
	}

	@Override
	public String getInventoryName() {
		return "VenusRover";
	}

	@Override
	public List<ItemStack> getItemsDropped() {
		final List<ItemStack> items = new ArrayList<ItemStack>();

		ItemStack vehicle = new ItemStack(ExtraPlanets_Items.VENUS_ROVER, 1, this.roverType);
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
	public ItemStack getPickedResult(RayTraceResult target) {
		return new ItemStack(ExtraPlanets_Items.VENUS_ROVER, 1, this.roverType);
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
	public void featureUpdate() {
	}
	
	@Override
	public void updatePassenger(Entity passenger) {
		if (this.isPassenger(passenger)) {
			final double offsetX = Math.cos(this.rotationYaw / Constants.RADIANS_TO_DEGREES_D + 114.8) * -0.5D;
			final double offsetZ = Math.sin(this.rotationYaw / Constants.RADIANS_TO_DEGREES_D + 114.8) * -0.5D;
			passenger.setPosition(this.posX + offsetX - 0.1F, this.posY + 0.5F + passenger.getYOffset(), this.posZ + offsetZ + 1.0F);
		}
	}
}