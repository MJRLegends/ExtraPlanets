package com.mjr.extraplanets.client.gui;

import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStats;
import micdoodle8.mods.galacticraft.core.util.PlayerUtil;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.mjr.extraplanets.inventory.ContainerAdvancedRefinery;
import com.mjr.extraplanets.inventory.ContainerSolar;
import com.mjr.extraplanets.tile.TileEntityAdvancedRefinery;
import com.mjr.extraplanets.tile.TileEntitySolar;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		EntityPlayerMP playerBase = PlayerUtil.getPlayerBaseServerFromPlayer(player, false);

		if (playerBase == null)
		{
			player.addChatMessage(new ChatComponentText("ExtraPlanets player instance null server-side. This is a bug."));
			return null;
		}

		GCPlayerStats stats = GCPlayerStats.get(playerBase);


		TileEntity tile = world.getTileEntity(x, y, z);

		if (tile != null)
		{
			if (tile instanceof TileEntityAdvancedRefinery)
			{
				return new ContainerAdvancedRefinery(player.inventory, (TileEntityAdvancedRefinery) tile);
			}
			else if (tile instanceof TileEntitySolar)
			{
				return new ContainerSolar(player.inventory, (TileEntitySolar) tile);
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
		{
			return this.getClientGuiElement(ID, player, world, new Vector3(x, y, z));
		}

		return null;
	}

	@SideOnly(Side.CLIENT)
	private Object getClientGuiElement(int ID, EntityPlayer player, World world, Vector3 position)
	{
		EntityClientPlayerMP playerClient = PlayerUtil.getPlayerBaseClientFromPlayer(player, false);

		TileEntity tile = world.getTileEntity(position.intX(), position.intY(), position.intZ());

		if (tile != null)
		{
			if (tile instanceof TileEntityAdvancedRefinery)
			{
				return new GuiAdvancedRefinery(player.inventory, (TileEntityAdvancedRefinery) world.getTileEntity(position.intX(), position.intY(), position.intZ()));
			}
			else if (tile instanceof TileEntitySolar)
			{
				return new GuiSolar(player.inventory, (TileEntitySolar) tile);
			}
		}
		return null;
	}
}