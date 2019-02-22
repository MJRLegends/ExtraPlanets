package com.mjr.extraplanets.client.gui;

import com.mjr.extraplanets.api.prefabs.entity.EntityElectricRocketBase;
import com.mjr.extraplanets.client.gui.machines.GuiAdvancedFuelLoader;
import com.mjr.extraplanets.client.gui.machines.GuiAdvancedOxygenCompressor;
import com.mjr.extraplanets.client.gui.machines.GuiAdvancedOxygenDecompressor;
import com.mjr.extraplanets.client.gui.machines.GuiAdvancedRefinery;
import com.mjr.extraplanets.client.gui.machines.GuiBasicChemicalInjector;
import com.mjr.extraplanets.client.gui.machines.GuiBasicCrystallizer;
import com.mjr.extraplanets.client.gui.machines.GuiBasicDecontaminationUnit;
import com.mjr.extraplanets.client.gui.machines.GuiBasicDecrystallizer;
import com.mjr.extraplanets.client.gui.machines.GuiBasicDensifier;
import com.mjr.extraplanets.client.gui.machines.GuiBasicPurifier;
import com.mjr.extraplanets.client.gui.machines.GuiBasicSmasher;
import com.mjr.extraplanets.client.gui.machines.GuiBasicSolarEvaporationChamber;
import com.mjr.extraplanets.client.gui.machines.GuiSolar;
import com.mjr.extraplanets.client.gui.machines.GuiUltimateFuelLoader;
import com.mjr.extraplanets.client.gui.machines.GuiUltimateOxygenCompressor;
import com.mjr.extraplanets.client.gui.machines.GuiUltimateOxygenDecompressor;
import com.mjr.extraplanets.client.gui.machines.GuiUltimateRefinery;
import com.mjr.extraplanets.client.gui.machines.GuiVehicleChanger;
import com.mjr.extraplanets.client.gui.rockets.GuiElectricRocketInventory;
import com.mjr.extraplanets.inventory.machines.ContainerAdvancedFuelLoader;
import com.mjr.extraplanets.inventory.machines.ContainerAdvancedOxygenCompressor;
import com.mjr.extraplanets.inventory.machines.ContainerAdvancedOxygenDecompressor;
import com.mjr.extraplanets.inventory.machines.ContainerAdvancedRefinery;
import com.mjr.extraplanets.inventory.machines.ContainerBasicChemicalInjector;
import com.mjr.extraplanets.inventory.machines.ContainerBasicCrystallizer;
import com.mjr.extraplanets.inventory.machines.ContainerBasicDecontaminationUnit;
import com.mjr.extraplanets.inventory.machines.ContainerBasicDecrystallizer;
import com.mjr.extraplanets.inventory.machines.ContainerBasicDensifier;
import com.mjr.extraplanets.inventory.machines.ContainerBasicPurifier;
import com.mjr.extraplanets.inventory.machines.ContainerBasicSmasher;
import com.mjr.extraplanets.inventory.machines.ContainerBasicSolarEvaporationChamber;
import com.mjr.extraplanets.inventory.machines.ContainerSolar;
import com.mjr.extraplanets.inventory.machines.ContainerUltimateFuelLoader;
import com.mjr.extraplanets.inventory.machines.ContainerUltimateOxygenCompressor;
import com.mjr.extraplanets.inventory.machines.ContainerUltimateOxygenDecompressor;
import com.mjr.extraplanets.inventory.machines.ContainerUltimateRefinery;
import com.mjr.extraplanets.inventory.machines.ContainerVehicleChanger;
import com.mjr.extraplanets.inventory.rockets.ContainerElectricRocketInventory;
import com.mjr.extraplanets.tileEntities.machines.TileEntityAdvancedFuelLoader;
import com.mjr.extraplanets.tileEntities.machines.TileEntityAdvancedOxygenCompressor;
import com.mjr.extraplanets.tileEntities.machines.TileEntityAdvancedOxygenDecompressor;
import com.mjr.extraplanets.tileEntities.machines.TileEntityAdvancedRefinery;
import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicChemicalInjector;
import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicCrystallizer;
import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicDecontaminationUnit;
import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicDecrystallizer;
import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicDensifier;
import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicPurifier;
import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicSmasher;
import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicSolarEvaporationChamber;
import com.mjr.extraplanets.tileEntities.machines.TileEntitySolar;
import com.mjr.extraplanets.tileEntities.machines.TileEntityUltimateFuelLoader;
import com.mjr.extraplanets.tileEntities.machines.TileEntityUltimateOxygenCompressor;
import com.mjr.extraplanets.tileEntities.machines.TileEntityUltimateOxygenDecompressor;
import com.mjr.extraplanets.tileEntities.machines.TileEntityUltimateRefinery;
import com.mjr.extraplanets.tileEntities.machines.TileEntityVehicleChanger;
import com.mjr.mjrlegendslib.util.MCUtilities;
import com.mjr.mjrlegendslib.util.PlayerUtilties;

import micdoodle8.mods.galacticraft.core.client.gui.GuiIdsCore;
import micdoodle8.mods.galacticraft.core.util.PlayerUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiHandler implements IGuiHandler {
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer entityPlayer, World world, int x, int y, int z) {
		EntityPlayerMP playerBase = PlayerUtil.getPlayerBaseServerFromPlayer(entityPlayer, false);

		if (playerBase == null) {
			PlayerUtilties.sendMessage(entityPlayer, "ExtraPlanets entityPlayer instance null server-side. This is a bug.");
			return null;
		}

		if (ID == GuiIdsCore.ROCKET_INVENTORY && entityPlayer.getRidingEntity() instanceof EntityElectricRocketBase) {
			return new ContainerElectricRocketInventory(entityPlayer.inventory, (EntityElectricRocketBase) entityPlayer.getRidingEntity(), ((EntityElectricRocketBase) entityPlayer.getRidingEntity()).getType(), entityPlayer);
		}

		BlockPos pos = new BlockPos(x, y, z);
		TileEntity tile = world.getTileEntity(pos);

		if (tile != null) {
			if (tile instanceof TileEntityAdvancedRefinery) {
				return new ContainerAdvancedRefinery(entityPlayer.inventory, (TileEntityAdvancedRefinery) tile, entityPlayer);
			} else if (tile instanceof TileEntityUltimateRefinery) {
				return new ContainerUltimateRefinery(entityPlayer.inventory, (TileEntityUltimateRefinery) tile, entityPlayer);
			} else if (tile instanceof TileEntitySolar) {
				return new ContainerSolar(entityPlayer.inventory, (TileEntitySolar) tile);
			} else if (tile instanceof TileEntityAdvancedOxygenCompressor) {
				return new ContainerAdvancedOxygenCompressor(entityPlayer.inventory, (TileEntityAdvancedOxygenCompressor) tile, entityPlayer);
			} else if (tile instanceof TileEntityAdvancedOxygenDecompressor) {
				return new ContainerAdvancedOxygenDecompressor(entityPlayer.inventory, (TileEntityAdvancedOxygenDecompressor) tile, entityPlayer);
			} else if (tile instanceof TileEntityUltimateOxygenCompressor) {
				return new ContainerUltimateOxygenCompressor(entityPlayer.inventory, (TileEntityUltimateOxygenCompressor) tile, entityPlayer);
			} else if (tile instanceof TileEntityUltimateOxygenDecompressor) {
				return new ContainerUltimateOxygenDecompressor(entityPlayer.inventory, (TileEntityUltimateOxygenDecompressor) tile, entityPlayer);
			} else if (tile instanceof TileEntityBasicDecrystallizer) {
				return new ContainerBasicDecrystallizer(entityPlayer.inventory, (TileEntityBasicDecrystallizer) tile, entityPlayer);
			} else if (tile instanceof TileEntityBasicCrystallizer) {
				return new ContainerBasicCrystallizer(entityPlayer.inventory, (TileEntityBasicCrystallizer) tile, entityPlayer);
			} else if (tile instanceof TileEntityBasicSmasher) {
				return new ContainerBasicSmasher(entityPlayer.inventory, (TileEntityBasicSmasher) tile, entityPlayer);
			} else if (tile instanceof TileEntityBasicChemicalInjector) {
				return new ContainerBasicChemicalInjector(entityPlayer.inventory, (TileEntityBasicChemicalInjector) tile, entityPlayer);
			} else if (tile instanceof TileEntityBasicSolarEvaporationChamber) {
				return new ContainerBasicSolarEvaporationChamber(entityPlayer.inventory, (TileEntityBasicSolarEvaporationChamber) tile, entityPlayer);
			} else if (tile instanceof TileEntityAdvancedFuelLoader) {
				return new ContainerAdvancedFuelLoader(entityPlayer.inventory, (TileEntityAdvancedFuelLoader) tile);
			} else if (tile instanceof TileEntityUltimateFuelLoader) {
				return new ContainerUltimateFuelLoader(entityPlayer.inventory, (TileEntityUltimateFuelLoader) tile);
			} else if (tile instanceof TileEntityVehicleChanger) {
				return new ContainerVehicleChanger(entityPlayer.inventory, (TileEntityVehicleChanger) tile);
			} else if (tile instanceof TileEntityBasicPurifier) {
				return new ContainerBasicPurifier(entityPlayer.inventory, (TileEntityBasicPurifier) tile, entityPlayer);
			} else if (tile instanceof TileEntityBasicDensifier) {
				return new ContainerBasicDensifier(entityPlayer.inventory, (TileEntityBasicDensifier) tile, entityPlayer);
			} else if (tile instanceof TileEntityBasicDecontaminationUnit) {
				return new ContainerBasicDecontaminationUnit(entityPlayer.inventory, (TileEntityBasicDecontaminationUnit) tile, entityPlayer);
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer entityPlayer, World world, int x, int y, int z) {
		if (MCUtilities.isClient()) {
			return this.getClientGuiElement(ID, entityPlayer, world, new BlockPos(x, y, z));
		}

		return null;
	}

	@SideOnly(Side.CLIENT)
	private Object getClientGuiElement(int ID, EntityPlayer entityPlayer, World world, BlockPos position) {
		if (ID == GuiIdsCore.ROCKET_INVENTORY && entityPlayer.getRidingEntity() instanceof EntityElectricRocketBase) {
			return new GuiElectricRocketInventory(entityPlayer.inventory, (EntityElectricRocketBase) entityPlayer.getRidingEntity(), ((EntityElectricRocketBase) entityPlayer.getRidingEntity()).getType());
		}
		TileEntity tile = world.getTileEntity(position);

		if (tile != null) {
			if (tile instanceof TileEntityAdvancedRefinery) {
				return new GuiAdvancedRefinery(entityPlayer.inventory, (TileEntityAdvancedRefinery) world.getTileEntity(position));
			} else if (tile instanceof TileEntityUltimateRefinery) {
				return new GuiUltimateRefinery(entityPlayer.inventory, (TileEntityUltimateRefinery) world.getTileEntity(position));
			} else if (tile instanceof TileEntitySolar) {
				return new GuiSolar(entityPlayer.inventory, (TileEntitySolar) tile);
			} else if (tile instanceof TileEntityAdvancedOxygenCompressor) {
				return new GuiAdvancedOxygenCompressor(entityPlayer.inventory, (TileEntityAdvancedOxygenCompressor) tile);
			} else if (tile instanceof TileEntityAdvancedOxygenDecompressor) {
				return new GuiAdvancedOxygenDecompressor(entityPlayer.inventory, (TileEntityAdvancedOxygenDecompressor) tile);
			} else if (tile instanceof TileEntityUltimateOxygenCompressor) {
				return new GuiUltimateOxygenCompressor(entityPlayer.inventory, (TileEntityUltimateOxygenCompressor) tile);
			} else if (tile instanceof TileEntityUltimateOxygenDecompressor) {
				return new GuiUltimateOxygenDecompressor(entityPlayer.inventory, (TileEntityUltimateOxygenDecompressor) tile);
			} else if (tile instanceof TileEntityBasicDecrystallizer) {
				return new GuiBasicDecrystallizer(entityPlayer.inventory, (TileEntityBasicDecrystallizer) tile);
			} else if (tile instanceof TileEntityBasicCrystallizer) {
				return new GuiBasicCrystallizer(entityPlayer.inventory, (TileEntityBasicCrystallizer) tile);
			} else if (tile instanceof TileEntityBasicSmasher) {
				return new GuiBasicSmasher(entityPlayer.inventory, (TileEntityBasicSmasher) tile);
			} else if (tile instanceof TileEntityBasicChemicalInjector) {
				return new GuiBasicChemicalInjector(entityPlayer.inventory, (TileEntityBasicChemicalInjector) tile);
			} else if (tile instanceof TileEntityBasicSolarEvaporationChamber) {
				return new GuiBasicSolarEvaporationChamber(entityPlayer.inventory, (TileEntityBasicSolarEvaporationChamber) tile);
			} else if (tile instanceof TileEntityAdvancedFuelLoader) {
				return new GuiAdvancedFuelLoader(entityPlayer.inventory, (TileEntityAdvancedFuelLoader) tile);
			} else if (tile instanceof TileEntityUltimateFuelLoader) {
				return new GuiUltimateFuelLoader(entityPlayer.inventory, (TileEntityUltimateFuelLoader) tile);
			} else if (tile instanceof TileEntityVehicleChanger) {
				return new GuiVehicleChanger(entityPlayer.inventory, (TileEntityVehicleChanger) tile);
			} else if (tile instanceof TileEntityBasicPurifier) {
				return new GuiBasicPurifier(entityPlayer.inventory, (TileEntityBasicPurifier) tile);
			} else if (tile instanceof TileEntityBasicDensifier) {
				return new GuiBasicDensifier(entityPlayer.inventory, (TileEntityBasicDensifier) tile);
			} else if (tile instanceof TileEntityBasicDecontaminationUnit) {
				return new GuiBasicDecontaminationUnit(entityPlayer.inventory, (TileEntityBasicDecontaminationUnit) tile);
			}
		}
		return null;
	}
}