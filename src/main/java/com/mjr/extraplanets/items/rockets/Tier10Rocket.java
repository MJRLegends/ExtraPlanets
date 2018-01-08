package com.mjr.extraplanets.items.rockets;

import java.util.List;

import javax.annotation.Nullable;

import micdoodle8.mods.galacticraft.api.entity.IRocketType.EnumRocketType;
import micdoodle8.mods.galacticraft.api.item.IHoldableItem;
import micdoodle8.mods.galacticraft.core.GCFluids;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.util.EnumColor;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
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
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		boolean padFound = false;
		TileEntity tile = null;
		ItemStack stack = playerIn.getHeldItem(hand);

		if (worldIn.isRemote && playerIn instanceof EntityPlayerSP) {
			ClientProxyCore.playerClientHandler.onBuild(8, (EntityPlayerSP) playerIn);
			return EnumActionResult.FAIL;
		} else {
			float centerX = -1;
			float centerY = -1;
			float centerZ = -1;

			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					BlockPos pos1 = pos.add(i, 0, j);
					IBlockState state = worldIn.getBlockState(pos1);
					final Block id = state.getBlock();
					int meta = id.getMetaFromState(state);

					if (id == ExtraPlanets_Blocks.ADVANCED_LAUCHPAD_FULL && meta == 1) {
						padFound = true;
						tile = worldIn.getTileEntity(pos.add(i, 0, j));

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
						return EnumActionResult.FAIL;
					}
				} else {
					return EnumActionResult.FAIL;
				}

				final EntityTier10Rocket spaceship = new EntityTier10Rocket(worldIn, centerX, centerY, centerZ, EnumRocketType.values()[stack.getItemDamage()]);

				spaceship.setPosition(spaceship.posX, spaceship.posY + spaceship.getOnPadYOffset(), spaceship.posZ);
				worldIn.spawnEntity(spaceship);

				if (stack.hasTagCompound() && stack.getTagCompound().hasKey("RocketFuel")) {
					spaceship.fuelTank.fill(new FluidStack(GCFluids.fluidFuel, stack.getTagCompound().getInteger("RocketFuel")), true);
				}

				if (!playerIn.capabilities.isCreativeMode) {
					stack.shrink(1);
				}

				if (spaceship.rocketType.getPreFueled()) {
					spaceship.fuelTank.fill(new FluidStack(GCFluids.fluidFuel, spaceship.getMaxFuel()), true);
				}
			} else {
				return EnumActionResult.FAIL;
			}
		}
		return EnumActionResult.SUCCESS;
	}

	@Override
	public void getSubItems(CreativeTabs par2CreativeTabs, NonNullList<ItemStack> par3List) {
		if(!this.isInCreativeTab(par2CreativeTabs)) return;
		for (int i = 0; i < EnumRocketType.values().length; i++) {
			par3List.add(new ItemStack(this, 1, i));
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, @Nullable World worldIn, List<String> par2List, ITooltipFlag flagIn) {
		EnumRocketType type;

		if (par1ItemStack.getItemDamage() < 10) {
			type = EnumRocketType.values()[par1ItemStack.getItemDamage()];
		} else {
			type = EnumRocketType.values()[par1ItemStack.getItemDamage() - 10];
		}

		if (!type.getTooltip().isEmpty()) {
			par2List.add(type.getTooltip());
		}

		if (type.getPreFueled()) {
			par2List.add(EnumColor.RED + "\u00a7o" + TranslateUtilities.translate("gui.creative_only.desc"));
		}

		if (par1ItemStack.hasTagCompound() && par1ItemStack.getTagCompound().hasKey("RocketFuel")) {
			EntityTier10Rocket rocket = new EntityTier10Rocket(FMLClientHandler.instance().getWorldClient(), 0, 0, 0, EnumRocketType.values()[par1ItemStack.getItemDamage()]);
			par2List.add(TranslateUtilities.translate("gui.message.fuel.name") + ": " + par1ItemStack.getTagCompound().getInteger("RocketFuel") + " / " + rocket.fuelTank.getCapacity());
		}

		par2List.add(EnumColor.DARK_AQUA + TranslateUtilities.translate("rocket_pad.tier3.desc"));
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return super.getUnlocalizedName(par1ItemStack) + ".t10Rocket";
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