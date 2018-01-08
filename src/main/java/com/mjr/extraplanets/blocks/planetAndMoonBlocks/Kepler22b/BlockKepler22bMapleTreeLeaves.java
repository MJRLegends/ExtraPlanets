package com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class BlockKepler22bMapleTreeLeaves extends BlockLeaves {
	public static final PropertyEnum<BlockKepler22bMapleTreeLeaves.EnumType> VARIANT = PropertyEnum.<BlockKepler22bMapleTreeLeaves.EnumType> create("variant", BlockKepler22bMapleTreeLeaves.EnumType.class);

	public static enum EnumType implements IStringSerializable {
		MAPLE_BLUE(0, "maple_blue_leaf", MapColor.BLUE), MAPLE_RED(1, "maple_red_leaf", MapColor.RED), MAPLE_PURPLE(2, "maple_purple_leaf", MapColor.PURPLE), MAPLE_YELLOW(3, "maple_yellow_leaf", MapColor.YELLOW);

		private static final BlockKepler22bMapleTreeLeaves.EnumType[] META_LOOKUP = new BlockKepler22bMapleTreeLeaves.EnumType[values().length];
		private final int meta;
		private final String name;
		private final String unlocalizedName;
		private final MapColor field_181071_k;

		private EnumType(int p_i46388_3_, String p_i46388_4_, MapColor p_i46388_5_) {
			this(p_i46388_3_, p_i46388_4_, p_i46388_4_, p_i46388_5_);
		}

		private EnumType(int p_i46389_3_, String p_i46389_4_, String p_i46389_5_, MapColor p_i46389_6_) {
			this.meta = p_i46389_3_;
			this.name = p_i46389_4_;
			this.unlocalizedName = p_i46389_5_;
			this.field_181071_k = p_i46389_6_;
		}

		public int getMetadata() {
			return this.meta;
		}

		public MapColor func_181070_c() {
			return this.field_181071_k;
		}

		@Override
		public String toString() {
			return this.name;
		}

		public static BlockKepler22bMapleTreeLeaves.EnumType byMetadata(int meta) {
			if (meta < 0 || meta >= META_LOOKUP.length) {
				meta = 0;
			}

			return META_LOOKUP[meta];
		}

		@Override
		public String getName() {
			return this.name;
		}

		public String getUnlocalizedName() {
			return this.unlocalizedName;
		}

		static {
			for (BlockKepler22bMapleTreeLeaves.EnumType blockleafs$enumtype : values()) {
				META_LOOKUP[blockleafs$enumtype.getMetadata()] = blockleafs$enumtype;
			}
		}
	}

	public BlockKepler22bMapleTreeLeaves() {
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockKepler22bMapleTreeLeaves.EnumType.MAPLE_BLUE).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
	}

	@Override
	protected int getSaplingDropChance(IBlockState state) {
		return super.getSaplingDropChance(state);
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		if(!(this.getCreativeTabToDisplayOn() == tab)) return;
		list.add(new ItemStack(itemIn, 1, BlockKepler22bMapleTreeLeaves.EnumType.MAPLE_BLUE.getMetadata()));
		list.add(new ItemStack(itemIn, 1, BlockKepler22bMapleTreeLeaves.EnumType.MAPLE_RED.getMetadata()));
		list.add(new ItemStack(itemIn, 1, BlockKepler22bMapleTreeLeaves.EnumType.MAPLE_PURPLE.getMetadata()));
		list.add(new ItemStack(itemIn, 1, BlockKepler22bMapleTreeLeaves.EnumType.MAPLE_YELLOW.getMetadata()));
	}

	protected ItemStack createStackedBlock(IBlockState state) {
		return new ItemStack(Item.getItemFromBlock(this), 1, state.getValue(VARIANT).getMetadata());
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, EnumType.byMetadata((meta & 3) % 4)).withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | state.getValue(VARIANT).getMetadata();

		if (!state.getValue(DECAYABLE).booleanValue()) {
			i |= 4;
		}

		if (state.getValue(CHECK_DECAY).booleanValue()) {
			i |= 8;
		}

		return i;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { VARIANT, CHECK_DECAY, DECAYABLE });
	}

	/**
	 * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It returns the metadata of the dropped item based on the old metadata of the block.
	 */
	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(VARIANT).getMetadata();
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return Blocks.LEAVES.isOpaqueCube(state);
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return Blocks.LEAVES.getBlockLayer();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return !this.leavesFancy && blockAccess.getBlockState(pos.offset(side)).getBlock() == this ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		IBlockState state = world.getBlockState(pos);
		return new java.util.ArrayList<ItemStack>(java.util.Arrays.asList(new ItemStack(this, 1, state.getValue(VARIANT).getMetadata())));
	}

	@Override
	public net.minecraft.block.BlockPlanks.EnumType getWoodType(int meta) {
		return null;
	}

	@Override
	@Nullable
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING);
	}
}