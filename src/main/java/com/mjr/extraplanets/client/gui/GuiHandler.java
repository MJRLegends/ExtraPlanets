package com.mjr.extraplanets.client.gui;

import micdoodle8.mods.galacticraft.core.client.gui.GuiIdsCore;
import micdoodle8.mods.galacticraft.core.util.PlayerUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.client.gui.machines.GuiAdvancedFuelLoader;
import com.mjr.extraplanets.client.gui.machines.GuiAdvancedOxygenCompressor;
import com.mjr.extraplanets.client.gui.machines.GuiAdvancedOxygenDecompressor;
import com.mjr.extraplanets.client.gui.machines.GuiAdvancedRefinery;
import com.mjr.extraplanets.client.gui.machines.GuiBasicChemicalInjector;
import com.mjr.extraplanets.client.gui.machines.GuiBasicCrystallizer;
import com.mjr.extraplanets.client.gui.machines.GuiBasicDecrystallizer;
import com.mjr.extraplanets.client.gui.machines.GuiBasicSmasher;
import com.mjr.extraplanets.client.gui.machines.GuiBasicSolarEvaporationChamber;
import com.mjr.extraplanets.client.gui.machines.GuiSolar;
import com.mjr.extraplanets.client.gui.machines.GuiUltimateFuelLoader;
import com.mjr.extraplanets.client.gui.machines.GuiUltimateOxygenCompressor;
import com.mjr.extraplanets.client.gui.machines.GuiUltimateOxygenDecompressor;
import com.mjr.extraplanets.client.gui.machines.GuiUltimateRefinery;
import com.mjr.extraplanets.client.gui.machines.GuiVehicleChanger;
import com.mjr.extraplanets.client.gui.rockets.GuiElectricRocketInventory;
import com.mjr.extraplanets.entities.rockets.EntityElectricRocketBase;
import com.mjr.extraplanets.inventory.machines.ContainerAdvancedFuelLoader;
import com.mjr.extraplanets.inventory.machines.ContainerAdvancedOxygenCompressor;
import com.mjr.extraplanets.inventory.machines.ContainerAdvancedOxygenDecompressor;
import com.mjr.extraplanets.inventory.machines.ContainerAdvancedRefinery;
import com.mjr.extraplanets.inventory.machines.ContainerBasicChemicalInjector;
import com.mjr.extraplanets.inventory.machines.ContainerBasicCrystallizer;
import com.mjr.extraplanets.inventory.machines.ContainerBasicDecrystallizer;
import com.mjr.extraplanets.inventory.machines.ContainerBasicSmasher;
import com.mjr.extraplanets.inventory.machines.ContainerBasicSolarEvaporationChamber;
import com.mjr.extraplanets.inventory.machines.ContainerSolar;
import com.mjr.extraplanets.inventory.machines.ContainerUltimateFuelLoader;
import com.mjr.extraplanets.inventory.machines.ContainerUltimateOxygenCompressor;
import com.mjr.extraplanets.inventory.machines.ContainerUltimateOxygenDecompressor;
import com.mjr.extraplanets.inventory.machines.ContainerUltimateRefinery;
import com.mjr.extraplanets.inventory.machines.ContainerVehicleChanger;
import com.mjr.extraplanets.inventory.rockets.ContainerElectricRocketInventory;
import com.mjr.extraplanets.tile.machines.TileEntityAdvancedFuelLoader;
import com.mjr.extraplanets.tile.machines.TileEntityAdvancedOxygenCompressor;
import com.mjr.extraplanets.tile.machines.TileEntityAdvancedOxygenDecompressor;
import com.mjr.extraplanets.tile.machines.TileEntityAdvancedRefinery;
import com.mjr.extraplanets.tile.machines.TileEntityBasicChemicalInjector;
import com.mjr.extraplanets.tile.machines.TileEntityBasicCrystallizer;
import com.mjr.extraplanets.tile.machines.TileEntityBasicDecrystallizer;
import com.mjr.extraplanets.tile.machines.TileEntityBasicSmasher;
import com.mjr.extraplanets.tile.machines.TileEntityBasicSolarEvaporationChamber;
import com.mjr.extraplanets.tile.machines.TileEntitySolar;
import com.mjr.extraplanets.tile.machines.TileEntityUltimateFuelLoader;
import com.mjr.extraplanets.tile.machines.TileEntityUltimateOxygenCompressor;
import com.mjr.extraplanets.tile.machines.TileEntityUltimateOxygenDecompressor;
import com.mjr.extraplanets.tile.machines.TileEntityUltimateRefinery;
import com.mjr.extraplanets.tile.machines.TileEntityVehicleChanger;

public class GuiHandler implements IGuiHandler {
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		EntityPlayerMP playerBase = PlayerUtil.getPlayerBaseServerFromPlayer(player, false);

		if (playerBase == null) {
			player.addChatMessage(new ChatComponentText("ExtraPlanets player instance null server-side. This is a bug."));
			return null;
		}

		if (ID == GuiIdsCore.ROCKET_INVENTORY && player.ridingEntity instanceof EntityElectricRocketBase) {
			return new ContainerElectricRocketInventory(player.inventory, (EntityElectricRocketBase) player.ridingEntity, ((EntityElectricRocketBase) player.ridingEntity).getType(), player);
		}

		BlockPos pos = new BlockPos(x, y, z);
		TileEntity tile = world.getTileEntity(pos);

		if (tile != null) {
			if (tile instanceof TileEntityAdvancedRefinery) {
				return new ContainerAdvancedRefinery(player.inventory, (TileEntityAdvancedRefinery) tile, player);
			} else if (tile instanceof TileEntityUltimateRefinery) {
				return new ContainerUltimateRefinery(player.inventory, (TileEntityUltimateRefinery) tile, player);
			} else if (tile instanceof TileEntitySolar) {
				return new ContainerSolar(player.inventory, (TileEntitySolar) tile);
			} else if (tile instanceof TileEntityAdvancedOxygenCompressor) {
				return new ContainerAdvancedOxygenCompressor(player.inventory, (TileEntityAdvancedOxygenCompressor) tile, player);
			} else if (tile instanceof TileEntityAdvancedOxygenDecompressor) {
				return new ContainerAdvancedOxygenDecompressor(player.inventory, (TileEntityAdvancedOxygenDecompressor) tile, player);
			} else if (tile instanceof TileEntityUltimateOxygenCompressor) {
				return new ContainerUltimateOxygenCompressor(player.inventory, (TileEntityUltimateOxygenCompressor) tile, player);
			} else if (tile instanceof TileEntityUltimateOxygenDecompressor) {
				return new ContainerUltimateOxygenDecompressor(player.inventory, (TileEntityUltimateOxygenDecompressor) tile, player);
			} else if (tile instanceof TileEntityBasicDecrystallizer) {
				return new ContainerBasicDecrystallizer(player.inventory, (TileEntityBasicDecrystallizer) tile, player);
			} else if (tile instanceof TileEntityBasicCrystallizer) {
				return new ContainerBasicCrystallizer(player.inventory, (TileEntityBasicCrystallizer) tile, player);
			} else if (tile instanceof TileEntityBasicSmasher) {
				return new ContainerBasicSmasher(player.inventory, (TileEntityBasicSmasher) tile, player);
			} else if (tile instanceof TileEntityBasicChemicalInjector) {
				return new ContainerBasicChemicalInjector(player.inventory, (TileEntityBasicChemicalInjector) tile, player);
			} else if (tile instanceof TileEntityBasicSolarEvaporationChamber) {
				return new ContainerBasicSolarEvaporationChamber(player.inventory, (TileEntityBasicSolarEvaporationChamber) tile, player);
			} else if (tile instanceof TileEntityAdvancedFuelLoader) {
				return new ContainerAdvancedFuelLoader(player.inventory, (TileEntityAdvancedFuelLoader) tile);
			} else if (tile instanceof TileEntityUltimateFuelLoader) {
				return new ContainerUltimateFuelLoader(player.inventory, (TileEntityUltimateFuelLoader) tile);
			} else if (tile instanceof TileEntityVehicleChanger) {
				return new ContainerVehicleChanger(player.inventory, (TileEntityVehicleChanger) tile);
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
			return this.getClientGuiElement(ID, player, world, new BlockPos(x, y, z));
		}

		return null;
	}

	@SideOnly(Side.CLIENT)
	private Object getClientGuiElement(int ID, EntityPlayer player, World world, BlockPos position) {
		if (ID == GuiIdsCore.ROCKET_INVENTORY && player.ridingEntity instanceof EntityElectricRocketBase) {
            return new GuiElectricRocketInventory(player.inventory, (EntityElectricRocketBase) player.ridingEntity, ((EntityElectricRocketBase) player.ridingEntity).getType());

		}
		TileEntity tile = world.getTileEntity(position);

		if (tile != null) {
			if (tile instanceof TileEntityAdvancedRefinery) {
				return new GuiAdvancedRefinery(player.inventory, (TileEntityAdvancedRefinery) world.getTileEntity(position));
			} else if (tile instanceof TileEntityUltimateRefinery) {
				return new GuiUltimateRefinery(player.inventory, (TileEntityUltimateRefinery) world.getTileEntity(position));
			} else if (tile instanceof TileEntitySolar) {
				return new GuiSolar(player.inventory, (TileEntitySolar) tile);
			} else if (tile instanceof TileEntityAdvancedOxygenCompressor) {
				return new GuiAdvancedOxygenCompressor(player.inventory, (TileEntityAdvancedOxygenCompressor) tile);
			} else if (tile instanceof TileEntityAdvancedOxygenDecompressor) {
				return new GuiAdvancedOxygenDecompressor(player.inventory, (TileEntityAdvancedOxygenDecompressor) tile);
			} else if (tile instanceof TileEntityUltimateOxygenCompressor) {
				return new GuiUltimateOxygenCompressor(player.inventory, (TileEntityUltimateOxygenCompressor) tile);
			} else if (tile instanceof TileEntityUltimateOxygenDecompressor) {
				return new GuiUltimateOxygenDecompressor(player.inventory, (TileEntityUltimateOxygenDecompressor) tile);
			} else if (tile instanceof TileEntityBasicDecrystallizer) {
				return new GuiBasicDecrystallizer(player.inventory, (TileEntityBasicDecrystallizer) tile);
			} else if (tile instanceof TileEntityBasicCrystallizer) {
				return new GuiBasicCrystallizer(player.inventory, (TileEntityBasicCrystallizer) tile);
			} else if (tile instanceof TileEntityBasicSmasher) {
				return new GuiBasicSmasher(player.inventory, (TileEntityBasicSmasher) tile);
			} else if (tile instanceof TileEntityBasicChemicalInjector) {
				return new GuiBasicChemicalInjector(player.inventory, (TileEntityBasicChemicalInjector) tile);
			} else if (tile instanceof TileEntityBasicSolarEvaporationChamber) {
				return new GuiBasicSolarEvaporationChamber(player.inventory, (TileEntityBasicSolarEvaporationChamber) tile);
			} else if (tile instanceof TileEntityAdvancedFuelLoader) {
				return new GuiAdvancedFuelLoader(player.inventory, (TileEntityAdvancedFuelLoader) tile);
			} else if (tile instanceof TileEntityUltimateFuelLoader) {
				return new GuiUltimateFuelLoader(player.inventory, (TileEntityUltimateFuelLoader) tile);
			} else if (tile instanceof TileEntityVehicleChanger) {
				return new GuiVehicleChanger(player.inventory, (TileEntityVehicleChanger) tile);
			}
		}
		return null;
	}
}