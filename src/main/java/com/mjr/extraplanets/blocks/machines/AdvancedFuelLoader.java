package com.mjr.extraplanets.blocks.machines;

import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.blocks.BlockAdvancedTile;
import micdoodle8.mods.galacticraft.core.energy.tile.TileBaseUniversalElectrical;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.proxy.ClientProxy;
import com.mjr.extraplanets.tileEntities.machines.TileEntityAdvancedFuelLoader;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AdvancedFuelLoader extends BlockAdvancedTile {
	private IIcon iconMachineSide;
	private IIcon iconInput;
	private IIcon iconFront;
	private IIcon iconFuelInput;

	public AdvancedFuelLoader(String assetName) {
		super(Material.rock);
		this.setHardness(1.0F);
		this.setStepSound(Block.soundTypeMetal);
		this.setBlockTextureName(GalacticraftCore.TEXTURE_PREFIX + assetName);
		this.setBlockName(assetName);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		return ClientProxy.getBlockRender(this);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.iconInput = par1IconRegister.registerIcon(GalacticraftCore.TEXTURE_PREFIX + "machine_input");
		this.iconMachineSide = par1IconRegister.registerIcon(GalacticraftCore.TEXTURE_PREFIX + "machine_blank");
		this.iconFront = par1IconRegister.registerIcon(Constants.TEXTURE_PREFIX + "machine_advanced_fuelloader");
		this.iconFuelInput = par1IconRegister.registerIcon(GalacticraftCore.TEXTURE_PREFIX + "machine_fuel_input");
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		return new TileEntityAdvancedFuelLoader();
	}

	@Override
	public boolean onMachineActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ) {
		entityPlayer.openGui(ExtraPlanets.instance, -1, world, x, y, z);
		return true;
	}

	@Override
	public IIcon getIcon(int side, int metadata) {
		if (side == 0 || side == 1) {
			return this.iconMachineSide;
		} else if (side == metadata + 2) {
			return this.iconInput;
		} else if (side == ForgeDirection.getOrientation(metadata + 2).getOpposite().ordinal()) {
			return this.iconFuelInput;
		} else {
			return this.iconFront;
		}
	}

	@Override
	public boolean onUseWrench(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int side, float hitX, float hitY, float hitZ) {
		int change = 0;

		// Re-orient the block
		switch (par1World.getBlockMetadata(x, y, z)) {
		case 0:
			change = 3;
			break;
		case 3:
			change = 1;
			break;
		case 1:
			change = 2;
			break;
		case 2:
			change = 0;
			break;
		}

		par1World.setBlockMetadataWithNotify(x, y, z, change, 3);

		TileEntity te = par1World.getTileEntity(x, y, z);
		if (te instanceof TileBaseUniversalElectrical) {
			((TileBaseUniversalElectrical) te).updateFacing();
		}

		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack) {
		final int angle = MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		int change = 0;

		switch (angle) {
		case 0:
			change = 3;
			break;
		case 1:
			change = 1;
			break;
		case 2:
			change = 2;
			break;
		case 3:
			change = 0;
			break;
		}

		world.setBlockMetadataWithNotify(x, y, z, change, 3);

		for (int dX = -2; dX < 3; dX++) {
			for (int dZ = -2; dZ < 3; dZ++) {
				final Block block = world.getBlock(x + dX, y, z + dZ);

				if (block == ExtraPlanets_Blocks.advancedLaunchPadFull) {
					world.markBlockForUpdate(x + dX, y, z + dZ);
				}
			}
		}
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int par5) {
		super.onBlockDestroyedByPlayer(world, x, y, z, par5);

		for (int dX = -2; dX < 3; dX++) {
			for (int dZ = -2; dZ < 3; dZ++) {
				final Block block = world.getBlock(x + dX, y, z + dZ);

				if (block == ExtraPlanets_Blocks.advancedLaunchPadFull) {
					world.markBlockForUpdate(x + dX, y, z + dZ);
				}
			}
		}
	}
}
