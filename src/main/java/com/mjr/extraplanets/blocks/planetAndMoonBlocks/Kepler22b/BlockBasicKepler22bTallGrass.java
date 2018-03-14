package com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.BlockBasicGanymede.EnumBlockBasic;

public class BlockBasicKepler22bTallGrass extends BlockBush implements IGrowable, net.minecraftforge.common.IShearable {
	public static final PropertyEnum<BlockBasicKepler22bTallGrass.EnumType> TYPE = PropertyEnum.<BlockBasicKepler22bTallGrass.EnumType> create("type", BlockBasicKepler22bTallGrass.EnumType.class);

	public BlockBasicKepler22bTallGrass() {
		super(Material.VINE);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, BlockBasicKepler22bTallGrass.EnumType.MAPLE_BLUE_SHORT));
		this.setCreativeTab(ExtraPlanets.BlocksTab);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return FULL_BLOCK_AABB;
	}

	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
		return super.canBlockStay(worldIn, pos, state);
	}

	public boolean isReplaceable(World worldIn, BlockPos pos) {
		return true;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return null;
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		return 1 + random.nextInt(fortune * 2 + 1);
	}

	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te) {
		super.harvestBlock(worldIn, player, pos, state, te, null);

	}

	public int getDamageValue(World worldIn, BlockPos pos) {
		IBlockState iblockstate = worldIn.getBlockState(pos);
		return iblockstate.getBlock().getMetaFromState(iblockstate);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> par3List) {
		for (EnumBlockBasic blockBasic : EnumBlockBasic.values()) {
			par3List.add(new ItemStack(this, 1, blockBasic.getMeta()));
		}
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return true;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		BlockDoublePlant.EnumPlantType blockdoubleplant$enumplanttype = BlockDoublePlant.EnumPlantType.GRASS;

		if (Blocks.DOUBLE_PLANT.canPlaceBlockAt(worldIn, pos)) {
			Blocks.DOUBLE_PLANT.placeAt(worldIn, pos, blockdoubleplant$enumplanttype, 2);
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(TYPE, BlockBasicKepler22bTallGrass.EnumType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(TYPE).getMeta();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { TYPE });
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Block.EnumOffsetType getOffsetType() {
		return Block.EnumOffsetType.XYZ;
	}

	public static enum EnumType implements IStringSerializable {
		MAPLE_BLUE_SHORT(0, "maple_blue_short"), MAPLE_BLUE_MED(1, "maple_blue_med"), MAPLE_BLUE_TALL(2, "maple_blue_tall"),

		MAPLE_RED_SHORT(3, "maple_red_short"), MAPLE_RED_MED(4, "maple_red_med"), MAPLE_RED_TALL(5, "maple_red_tall"),

		MAPLE_PURPLE_SHORT(6, "maple_purple_short"), MAPLE_PURPLE_MED(7, "maple_purple_med"), MAPLE_PURPLE_TALL(8, "maple_purple_tall"),

		MAPLE_YELLOW_SHORT(9, "maple_yellow_short"), MAPLE_YELLOW_MED(10, "maple_yellow_med"), MAPLE_YELLOW_TALL(11, "maple_yellow_tall"),

		MAPLE_GREEN_SHORT(12, "maple_green_short"), MAPLE_GREEN_MED(13, "maple_green_med"), MAPLE_GREEN_TALL(14, "maple_green_tall");

		private static final BlockBasicKepler22bTallGrass.EnumType[] META_LOOKUP = new BlockBasicKepler22bTallGrass.EnumType[values().length];
		private final int meta;
		private final String name;

		private EnumType(int meta, String name) {
			this.meta = meta;
			this.name = name;
		}

		public int getMeta() {
			return this.meta;
		}

		@Override
		public String toString() {
			return this.name;
		}

		public static BlockBasicKepler22bTallGrass.EnumType byMetadata(int meta) {
			if (meta < 0 || meta >= META_LOOKUP.length) {
				meta = 0;
			}

			return META_LOOKUP[meta];
		}

		@Override
		public String getName() {
			return this.name;
		}

		static {
			for (BlockBasicKepler22bTallGrass.EnumType blocktallgrass$enumtype : values()) {
				META_LOOKUP[blocktallgrass$enumtype.getMeta()] = blocktallgrass$enumtype;
			}
		}
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		List<ItemStack> ret = new java.util.ArrayList<ItemStack>();
		ret.add(new ItemStack(Blocks.TALLGRASS, 1, world.getBlockState(pos).getValue(TYPE).getMeta()));
		return ret;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> ret = new java.util.ArrayList<ItemStack>();
		if (RANDOM.nextInt(8) != 0)
			return ret;
		ItemStack seed = net.minecraftforge.common.ForgeHooks.getGrassSeed(RANDOM, fortune);
		if (seed != null)
			ret.add(seed);
		return ret;
	}
}