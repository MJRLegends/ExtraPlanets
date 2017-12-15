package com.mjr.extraplanets.blocks;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.block.IPartialSealableBlock;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.blocks.BlockAdvancedTile;
import micdoodle8.mods.galacticraft.core.tile.IMultiBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.proxy.ClientProxy;
import com.mjr.extraplanets.tileEntities.machines.TileEntityPoweredChargingPad;
import com.mjr.extraplanets.tileEntities.machines.TileEntityTier2LandingPad;
import com.mjr.extraplanets.tileEntities.machines.TileEntityTier3LandingPad;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCustomLandingPadFull extends BlockAdvancedTile implements IPartialSealableBlock {
	private IIcon[] icons = new IIcon[3];

	public BlockCustomLandingPadFull(String assetName) {
		super(Material.rock);
		this.setHardness(1.0F);
		this.setResistance(10.0F);
		this.setStepSound(Block.soundTypeMetal);
		this.setBlockTextureName(GalacticraftCore.TEXTURE_PREFIX + "launchPad");
		this.setBlockName(assetName);
		this.maxY = 0.39D;
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@Override
	public int quantityDropped(Random par1Random) {
		return 25;
	}

	@Override
	public void breakBlock(World var1, int var2, int var3, int var4, Block var5, int var6) {
		final TileEntity var9 = var1.getTileEntity(var2, var3, var4);

		if (var9 instanceof IMultiBlock) {
			((IMultiBlock) var9).onDestroy(var9);
		}

		super.breakBlock(var1, var2, var3, var4, var5, var6);
	}

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3) {
		return Item.getItemFromBlock(ExtraPlanets_Blocks.advancedLaunchPad);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		switch (world.getBlockMetadata(x, y, z)) {
		case 0:
			return AxisAlignedBB.getBoundingBox(x + this.minX + 1, y + this.minY, z + this.minZ + 1, x + this.maxX + 1, y + this.maxY, z + this.maxZ + 1);
		case 1:
			return AxisAlignedBB.getBoundingBox(x + this.minX + 1, y + this.minY, z + this.minZ + 1, x + this.maxX + 1, y + this.maxY, z + this.maxZ + 1);
		default:
			return AxisAlignedBB.getBoundingBox(x + 0.0D, y + 0.0D, z + 0.0D, x + 1.0D, y + 0.2D, z + 1.0D);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		switch (world.getBlockMetadata(x, y, z)) {
		case 0:
			return AxisAlignedBB.getBoundingBox(x + this.minX + 1, y + this.minY, z + this.minZ + 1, x + this.maxX + 1, y + this.maxY, z + this.maxZ + 1);
		case 1:
			return AxisAlignedBB.getBoundingBox(x + this.minX + 1, y + this.minY, z + this.minZ + 1, x + this.maxX + 1, y + this.maxY, z + this.maxZ + 1);
		default:
			return AxisAlignedBB.getBoundingBox(x + 0.0D, y + 0.0D, z + 0.0D, x + 1.0D, y + 0.2D, z + 1.0D);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		return ClientProxy.getBlockRender(this);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.icons[0] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + "tier2_landing_pad");
		this.icons[1] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + "tier3_landing_pad");
		this.icons[2] = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + "powered_charging_pad");
		this.blockIcon = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + "tier2_landing_pad");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		switch (par2) {
		case 0:
			return this.icons[0];
		case 1:
			return this.icons[1];
		case 2:
			return this.icons[2];
		}

		return this.blockIcon;
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		for (int x2 = -1; x2 < 4; ++x2) {
			for (int z2 = -1; z2 < 4; ++z2) {
				if (!super.canPlaceBlockAt(world, x + x2, y, z + z2)) {
					return false;
				}
			}

		}

		return true;
	}

	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		switch (metadata) {
		case 0:
			return new TileEntityTier2LandingPad();
		case 1:
			return new TileEntityTier3LandingPad();
		case 2:
			return new TileEntityPoweredChargingPad();
		default:
			return null;
		}
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5) {
		par1World.markBlockForUpdate(par2, par3, par4);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		return true;
	}

	@Override
	public boolean isSealed(World world, int x, int y, int z, ForgeDirection direction) {
		return direction == ForgeDirection.UP;
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		int metadata = world.getBlockMetadata(x, y, z);
		return new ItemStack(Item.getItemFromBlock(ExtraPlanets_Blocks.advancedLaunchPad), 1, metadata);
	}
}
