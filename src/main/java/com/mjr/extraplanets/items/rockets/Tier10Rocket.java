package com.mjr.extraplanets.items.rockets;

import java.util.List;

import micdoodle8.mods.galacticraft.api.entity.IRocketType.EnumRocketType;
import micdoodle8.mods.galacticraft.api.item.IHoldableItem;
import micdoodle8.mods.galacticraft.core.GCFluids;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.util.EnumColor;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.entities.rockets.EntityTier10Rocket;
import com.mjr.extraplanets.tileEntities.blocks.TileEntityTier3LandingPad;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class Tier10Rocket extends Item implements IHoldableItem {
	public Tier10Rocket(String assetName) {
		super();
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setMaxStackSize(1);
		this.setUnlocalizedName(assetName);
		this.setCreativeTab(ExtraPlanets.ItemsTab);
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		boolean padFound = false;
		TileEntity tile = null;

		if (world.isRemote && player instanceof EntityPlayerSP) {
			ClientProxyCore.playerClientHandler.onBuild(8, (EntityPlayerSP) player);
			return false;
		} else {
			float centerX = -1;
			float centerY = -1;
			float centerZ = -1;

			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					BlockPos pos1 = pos.add(i, 0, j);
					IBlockState state = world.getBlockState(pos1);
					final Block id = state.getBlock();
					int meta = id.getMetaFromState(state);

					if (id == ExtraPlanets_Blocks.ADVANCED_LAUCHPAD_FULL && meta == 1) {
						padFound = true;
						tile = world.getTileEntity(pos.add(i, 0, j));

						centerX = pos.getX() + i + 0.5F;
						centerY = pos.getY() + 0.4F;
						centerZ = pos.getZ() + j + 0.5F;

						break;
					}
				}

				if (padFound) {
					break;
				}
			}

			if (padFound) {
				// Check whether there is already a rocket on the pad
				if (tile instanceof TileEntityTier3LandingPad) {
					if (((TileEntityTier3LandingPad) tile).getDockedEntity() != null) {
						return false;
					}
				} else {
					return false;
				}

				final EntityTier10Rocket spaceship = new EntityTier10Rocket(world, centerX, centerY, centerZ, EnumRocketType.values()[itemStack.getItemDamage()]);

				spaceship.setPosition(spaceship.posX, spaceship.posY + spaceship.getOnPadYOffset(), spaceship.posZ);
				world.spawnEntityInWorld(spaceship);

				if (itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey("RocketFuel")) {
					spaceship.fuelTank.fill(new FluidStack(GCFluids.fluidFuel, itemStack.getTagCompound().getInteger("RocketFuel")), true);
				}

				if (!player.capabilities.isCreativeMode) {
					itemStack.stackSize--;

					if (itemStack.stackSize <= 0) {
						itemStack = null;
					}
				}

				if (spaceship.rocketType.getPreFueled()) {
					spaceship.fuelTank.fill(new FluidStack(GCFluids.fluidFuel, spaceship.getMaxFuel()), true);
				}
			} else {
				return false;
			}
		}
		return true;
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tabs, List<ItemStack> list) {
		for (int i = 0; i < EnumRocketType.values().length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> par2List, boolean b) {
		EnumRocketType type;

		if (itemStack.getItemDamage() < 10) {
			type = EnumRocketType.values()[itemStack.getItemDamage()];
		} else {
			type = EnumRocketType.values()[itemStack.getItemDamage() - 10];
		}

		if (!type.getTooltip().isEmpty()) {
			par2List.add(type.getTooltip());
		}

		if (type.getPreFueled()) {
			par2List.add(EnumColor.RED + "\u00a7o" + TranslateUtilities.translate("gui.creative_only.desc"));
		}

		if (itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey("RocketFuel")) {
			EntityTier10Rocket rocket = new EntityTier10Rocket(FMLClientHandler.instance().getWorldClient(), 0, 0, 0, EnumRocketType.values()[itemStack.getItemDamage()]);
			par2List.add(TranslateUtilities.translate("gui.message.fuel.name") + ": " + itemStack.getTagCompound().getInteger("RocketFuel") + " / " + rocket.fuelTank.getCapacity());
		}

		par2List.add(EnumColor.DARK_AQUA + TranslateUtilities.translate("rocket_pad.tier3.desc"));
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return super.getUnlocalizedName(itemStack) + ".t10Rocket";
	}

	@Override
	public boolean shouldHoldLeftHandUp(EntityPlayer player) {
		return true;
	}

	@Override
	public boolean shouldHoldRightHandUp(EntityPlayer player) {
		return true;
	}

	@Override
	public boolean shouldCrouch(EntityPlayer player) {
		return true;
	}
}