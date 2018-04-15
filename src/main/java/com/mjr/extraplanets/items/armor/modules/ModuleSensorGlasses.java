package com.mjr.extraplanets.items.armor.modules;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.client.gui.overlay.OverlaySensorGlasses;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

import com.mjr.mjrlegendslib.util.MCUtilities;

public class ModuleSensorGlasses extends Module {

	public ModuleSensorGlasses(String name) {
		super(name, 3, new ItemStack(GCItems.sensorGlasses), true);
		List<ItemStack> items = new ArrayList<ItemStack>();
		items.add(new ItemStack(GCItems.sensorGlasses));
		this.setRequirements(items);
	}

	@Override
	public void tickClient(EntityPlayerSP player) {

	}

	@Override
	public void tickServer(EntityPlayerMP player) {

	}

	@Override
	public void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks) {
		OverlaySensorGlasses.renderSensorGlassesMain(null, player, new ScaledResolution(MCUtilities.getMinecraft()), 0);
		OverlaySensorGlasses.renderSensorGlassesValueableBlocks(null, player, new ScaledResolution(MCUtilities.getMinecraft()), 0);
	}
}
