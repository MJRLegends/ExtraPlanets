package com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.WorldGenKepler22bTree;

public class BlockKepler22bMapleTreeSapling extends BlockBush implements IGrowable, IPlantable {
	public static final PropertyEnum<BlockKepler22bMapleTreeSapling.EnumType> VARIANT = PropertyEnum.<BlockKepler22bMapleTreeSapling.EnumType> create("variant", BlockKepler22bMapleTreeSapling.EnumType.class);
	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);

	public static enum EnumType implements IStringSerializable {
		MAPLE_BLUE(0, "maple_blue_sapling", MapColor.blueColor), MAPLE_RED(1, "maple_red_sapling", MapColor.redColor), MAPLE_PURPLE(2, "maple_purple_sapling", MapColor.purpleColor), MAPLE_YELLOW(3, "maple_yellow_sapling", MapColor.yellowColor), MAPLE_GREEN(
				4, "maple_green_sapling", MapColor.greenColor), MAPLE_BROWN(5, "maple_brown_sapling", MapColor.brownColor);

		private static final BlockKepler22bMapleTreeSapling.EnumType[] META_LOOKUP = new BlockKepler22bMapleTreeSapling.EnumType[values().length];
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

		public static BlockKepler22bMapleTreeSapling.EnumType byMetadata(int meta) {
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
			for (BlockKepler22bMapleTreeSapling.EnumType blockleafs$enumtype : values()) {
				META_LOOKUP[blockleafs$enumtype.getMetadata()] = blockleafs$enumtype;
			}
		}
	}

	public BlockKepler22bMapleTreeSapling() {
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockKepler22bMapleTreeSapling.EnumType.MAPLE_BLUE).withProperty(STAGE, Integer.valueOf(0)));
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
	}

	/**
	 * Gets the localized name of this block. Used for the statistics page.
	 */
	@Override
	public String getLocalizedName() {
		return StatCollector.translateToLocal(this.getUnlocalizedName() + "." + BlockKepler22bMapleTreeSapling.EnumType.MAPLE_BLUE.getUnlocalizedName() + ".name");
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		if (!world.isRemote) {
			super.updateTick(world, pos, state, rand);

			if (world.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0) {
				this.grow(world, pos, state, rand);
			}
		}
	}

	public void grow(World world, BlockPos pos, IBlockState state, Random rand) {
		if (state.getValue(STAGE).intValue() == 0) {
			world.setBlockState(pos, state.cycleProperty(STAGE), 4);
		} else {
			this.generateTree(world, pos, state, rand);
		}
	}

	public void generateTree(World world, BlockPos pos, IBlockState state, Random rand) {
		if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, rand, pos))
			return;
		WorldGenerator worldgenerator = rand.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true);

		switch (state.getValue(VARIANT)) {
		case MAPLE_BLUE:
			worldgenerator = new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(0), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(0), false);
			break;
		case MAPLE_RED:
			worldgenerator = new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(1), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(1), false);
			break;
		case MAPLE_PURPLE:
			worldgenerator = new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(2), false);
			break;
		case MAPLE_YELLOW:
			worldgenerator = new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(3), false);
			break;
		case MAPLE_GREEN:
			worldgenerator = new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG_2.getStateFromMeta(0), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF2.getStateFromMeta(1), false);
			break;
		case MAPLE_BROWN:
			worldgenerator = new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG_2.getStateFromMeta(1), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF2.getStateFromMeta(0), false);
			break;
		}
		world.setBlockToAir(pos);

		if (!worldgenerator.generate(world, rand, pos)) {
			world.setBlockState(pos, state, 2);
		}
	}

	/**
	 * Check whether the given BlockPos has a Sapling of the given type
	 */
	public boolean isTypeAt(World world, BlockPos pos, BlockKepler22bMapleTreeSapling.EnumType type) {
		IBlockState iblockstate = world.getBlockState(pos);
		return iblockstate.getBlock() == this && iblockstate.getValue(VARIANT) == type;
	}

	/**
	 * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It returns the metadata of the dropped item based on the old metadata of the block.
	 */
	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(VARIANT).getMetadata();
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		for (BlockKepler22bMapleTreeSapling.EnumType blockplanks$enumtype : BlockKepler22bMapleTreeSapling.EnumType.values()) {
			list.add(new ItemStack(itemIn, 1, blockplanks$enumtype.getMetadata()));
		}
	}

	/**
	 * Whether this IGrowable can grow
	 */
	@Override
	public boolean canGrow(World world, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World world, Random rand, BlockPos pos, IBlockState state) {
		return world.rand.nextFloat() < 0.45D;
	}

	@Override
	public void grow(World world, Random rand, BlockPos pos, IBlockState state) {
		this.grow(world, pos, state, rand);
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, BlockKepler22bMapleTreeSapling.EnumType.byMetadata(meta & 7)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | state.getValue(VARIANT).getMetadata();
		i = i | state.getValue(STAGE).intValue() << 3;
		return i;
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] { VARIANT, STAGE });
	}
}