package com.mjr.extraplanets.blocks;

import java.util.Random;

import com.mjr.extraplanets.tileEntities.blocks.TileEntityPoweredChargingPad;
import com.mjr.extraplanets.tileEntities.blocks.TileEntityRocketChargingPad;
import com.mjr.extraplanets.tileEntities.blocks.TileEntityTier2LandingPad;
import com.mjr.extraplanets.tileEntities.blocks.TileEntityTier3LandingPad;

import micdoodle8.mods.galacticraft.api.block.IPartialSealableBlock;
import micdoodle8.mods.galacticraft.core.blocks.BlockAdvancedTile;
import micdoodle8.mods.galacticraft.core.tile.IMultiBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCustomLandingPadFull extends BlockAdvancedTile implements IPartialSealableBlock {
	public static final PropertyEnum<EnumLandingPadFullType> PAD_TYPE = PropertyEnum.create("type", EnumLandingPadFullType.class);
	private final AxisAlignedBB AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.1875D, 1.0D);

	public enum EnumLandingPadFullType implements IStringSerializable {
		TIER_2_ROCKET_PAD(0, "tier_2_rocket"), TIER_3_ROCKET_PAD(1, "tier_3_rocket"), POWER_CHARGING_PAD(2, "powered_charging_pad"), ROCKET_POWER_CHARGING_PAD(3, "rocket_powered_charging_pad");

		private final int meta;
		private final String name;

		EnumLandingPadFullType(int meta, String name) {
			this.meta = meta;
			this.name = name;
		}

		public int getMeta() {
			return this.meta;
		}

		public static EnumLandingPadFullType byMetadata(int meta) {
			return values()[meta];
		}

		@Override
		public String getName() {
			return this.name;
		}
	}

	public BlockCustomLandingPadFull(String name) {
		super(Material.ROCK);
		this.setHardness(1.0F);
		this.setResistance(10.0F);
		this.setSoundType(SoundType.METAL);
		this.setUnlocalizedName(name);
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@Override
	public int quantityDropped(Random par1Random) {
		return 25;
	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		final TileEntity var9 = world.getTileEntity(pos);

		if (var9 instanceof IMultiBlock) {
			((IMultiBlock) var9).onDestroy(var9);
		}

		super.breakBlock(world, pos, state);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ExtraPlanets_Blocks.ADVANCED_LAUCHPAD);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
		return this.AABB;
	}

	@Override
	public boolean canPlaceBlockAt(World world, BlockPos pos) {
		for (int x2 = -2; x2 < 3; ++x2) {
			for (int z2 = -2; z2 < 3; ++z2) {
				if (!super.canPlaceBlockAt(world, new BlockPos(pos.getX() + x2, pos.getY(), pos.getZ() + z2))) {
					return false;
				}
			}

		}

		return true;
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		switch (getMetaFromState(state)) {
		case 0:
			return new TileEntityTier2LandingPad();
		case 1:
			return new TileEntityTier3LandingPad();
		case 2:
			return new TileEntityPoweredChargingPad();
		case 3:
			return new TileEntityRocketChargingPad();
		default:
			return null;
		}
	}

	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos) {
		world.notifyBlockUpdate(pos, state, state, 3);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean shouldSideBeRendered(IBlockState state, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return true;
	}

	@Override
	public boolean isSealed(World world, BlockPos pos, EnumFacing direction) {
		return direction == EnumFacing.UP;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		int metadata = getMetaFromState(world.getBlockState(pos));
		return new ItemStack(Item.getItemFromBlock(ExtraPlanets_Blocks.ADVANCED_LAUCHPAD), 1, metadata);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(PAD_TYPE, EnumLandingPadFullType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(PAD_TYPE).getMeta();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, PAD_TYPE);
	}
}
