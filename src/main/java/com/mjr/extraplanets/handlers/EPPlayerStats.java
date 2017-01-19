package com.mjr.extraplanets.handlers;

import java.lang.ref.WeakReference;

import micdoodle8.mods.galacticraft.core.inventory.InventoryExtended;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class EPPlayerStats implements IExtendedEntityProperties {
	public static final String EP_PLAYER_PROP = "EPPlayerStats";

	public WeakReference<EntityPlayerMP> player;

	public InventoryExtended extendedInventory = new InventoryExtended();

	public double radiationLevel;

	public EPPlayerStats(EntityPlayerMP player) {
		this.player = new WeakReference<EntityPlayerMP>(player);
	}

	@Override
	public void saveNBTData(NBTTagCompound nbt) {
		nbt.setDouble("radiationLevel", this.radiationLevel);
	}

	@Override
	public void loadNBTData(NBTTagCompound nbt) {
		this.radiationLevel = nbt.getDouble("radiationLevel");
	}

	@Override
	public void init(Entity entity, World world) {
	}

	public static void register(EntityPlayerMP player) {
		player.registerExtendedProperties(EPPlayerStats.EP_PLAYER_PROP, new EPPlayerStats(player));
	}

	public static EPPlayerStats get(EntityPlayerMP player) {
		return (EPPlayerStats) player.getExtendedProperties(EPPlayerStats.EP_PLAYER_PROP);
	}

}