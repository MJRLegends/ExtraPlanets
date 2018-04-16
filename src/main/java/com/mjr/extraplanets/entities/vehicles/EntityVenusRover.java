package com.mjr.extraplanets.entities.vehicles;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.api.block.IPowerDock;
import com.mjr.extraplanets.api.prefabs.entity.EntityPoweredVehicleBase;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.extraplanets.tileEntities.blocks.TileEntityPoweredChargingPad;

public class EntityVenusRover extends EntityPoweredVehicleBase {

	public EntityVenusRover(World var1) {
		super(var1);
		this.invertControls = true;
	}

	public EntityVenusRover(World world, float f, float g, float h, int itemDamage) {
		super(world, f, g, h, itemDamage);
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
	public ItemStack getPickedResult(MovingObjectPosition target) {
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
	public void updateRiderPosition() {
		if (this.riddenByEntity != null) {
			final double var1 = Math.cos(this.rotationYaw / Constants.RADIANS_TO_DEGREES_D + 114.8) * -0.5D;
			this.riddenByEntity.setPosition(this.posX + var1 - 0.1F, this.posY + 0.5F + this.riddenByEntity.getYOffset(), this.posZ + var1 + 1.0F);
		}
	}
}