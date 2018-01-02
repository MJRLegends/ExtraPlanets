package com.mjr.extraplanets.blocks;

import java.util.List;

import micdoodle8.mods.galacticraft.api.block.IPartialSealableBlock;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.blocks.BlockAdvancedTile;
import micdoodle8.mods.galacticraft.core.items.ItemBlockDesc;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.tileEntities.machines.TileEntityPoweredChargingPadSingle;
import com.mjr.extraplanets.tileEntities.machines.TileEntityTier2LandingPadSingle;
import com.mjr.extraplanets.tileEntities.machines.TileEntityTier3LandingPadSingle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCustomLandingPad extends BlockAdvancedTile implements IPartialSealableBlock, ItemBlockDesc.IBlockShiftDesc {
	private IIcon[] icons = new IIcon[3];

	public BlockCustomLandingPad(String assetName) {
		super(Material.iron);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.2F, 1.0F);
		this.setHardness(1.0F);
		this.setResistance(10.0F);
		this.setStepSound(Block.soundTypeMetal);
		this.setBlockTextureName(GalacticraftCore.TEXTURE_PREFIX + assetName);
		this.setBlockName(assetName);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < 3; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.icons[0] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + "tier2_landing_pad");
		this.icons[1] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + "tier3_landing_pad");
		this.icons[2] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + "powered_charging_pad_blank");
		this.blockIcon = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + "tier2_landing_pad");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		if (par2 < 0 || par2 > this.icons.length) {
			return this.blockIcon;
		}

		return this.icons[par2];
	}

	@Override
	public boolean canPlaceBlockOnSide(World par1World, int par2, int par3, int par4, int par5) {
		final Block id = ExtraPlanets_Blocks.advancedLaunchPad;

		if (par1World.getBlock(par2 + 1, par3, par4) == id && par1World.getBlock(par2 + 4, par3, par4) == id && par1World.getBlock(par2 + 5, par3, par4) == id) {
			return false;
		}

		if (par1World.getBlock(par2 - 1, par3, par4) == id && par1World.getBlock(par2 - 4, par3, par4) == id && par1World.getBlock(par2 - 5, par3, par4) == id) {
			return false;
		}

		if (par1World.getBlock(par2, par3, par4 + 1) == id && par1World.getBlock(par2, par3, par4 + 4) == id && par1World.getBlock(par2, par3, par4 + 5) == id) {
			return false;
		}

		if (par1World.getBlock(par2, par3, par4 - 1) == id && par1World.getBlock(par2, par3, par4 - 4) == id && par1World.getBlock(par2, par3, par4 - 5) == id) {
			return false;
		}

		if (par1World.getBlock(par2, par3 - 1, par4) == ExtraPlanets_Blocks.advancedLaunchPad && par5 == 3) {
			return false;
		} else {
			return this.canPlaceBlockAt(par1World, par2, par3, par4);
		}
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		if (world.isRemote)
			return null;

		switch (metadata) {
		case 0:
			return new TileEntityTier2LandingPadSingle();
		case 1:
			return new TileEntityTier3LandingPadSingle();
		case 2:
			return new TileEntityPoweredChargingPadSingle();
		default:
			return null;
		}
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return null;
	}

	@Override
	public boolean isSealed(World world, int x, int y, int z, ForgeDirection direction) {
		return direction == ForgeDirection.UP;
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@Override
	public String getShiftDescription(int meta) {
		if (meta == 0)
			return GCCoreUtil.translate(this.getUnlocalizedName() + ".tier2.desc");
		else if (meta == 1)
			return GCCoreUtil.translate(this.getUnlocalizedName() + ".tier3.desc");
		else if (meta == 2)
			return GCCoreUtil.translate(this.getUnlocalizedName() + ".powered.desc");
		else
			return "";
	}

	@Override
	public boolean showDescription(int meta) {
		return true;
	}
}
