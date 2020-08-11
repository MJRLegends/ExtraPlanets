package com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b;

import java.util.Random;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.WorldGenKepler22bTree;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings("deprecation")
public class BlockKepler22bMapleTreeSapling extends BlockBush implements IGrowable, IPlantable {
	public static final PropertyEnum<BlockKepler22bMapleTreeSapling.EnumType> VARIANT = PropertyEnum.<BlockKepler22bMapleTreeSapling.EnumType> create("variant", BlockKepler22bMapleTreeSapling.EnumType.class);
	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);

	public static enum EnumType implements IStringSerializable {
		MAPLE_BLUE(0, "maple_blue_sapling", MapColor.BLUE), MAPLE_RED(1, "maple_red_sapling", MapColor.RED), MAPLE_PURPLE(2, "maple_purple_sapling", MapColor.PURPLE), MAPLE_YELLOW(3, "maple_yellow_sapling", MapColor.YELLOW), MAPLE_GREEN(4,
				"maple_green_sapling", MapColor.GREEN), MAPLE_BROWN(5, "maple_brown_sapling", MapColor.BROWN);

		private static final BlockKepler22bMapleTreeSapling.EnumType[] META_LOOKUP = new BlockKepler22bMapleTreeSapling.EnumType[values().length];
		private final int meta;
		private final String name;
		private final MapColor map_color;

		private EnumType(int meta, String name, MapColor map_color) {
			this.meta = meta;
			this.name = name;
			this.map_color = map_color;
		}

		public int getMetadata() {
			return this.meta;
		}

		public MapColor func_181070_c() {
			return this.map_color;
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

		static {
			for (BlockKepler22bMapleTreeSapling.EnumType blockleafs$enumtype : values()) {
				META_LOOKUP[blockleafs$enumtype.getMetadata()] = blockleafs$enumtype;
			}
		}
	}

	public BlockKepler22bMapleTreeSapling() {
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockKepler22bMapleTreeSapling.EnumType.MAPLE_BLUE).withProperty(STAGE, Integer.valueOf(0)));
		this.setCreativeTab(ExtraPlanets.BlocksTab);
		this.setSoundType(SoundType.PLANT);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return SAPLING_AABB;
	}

	@Override
	public String getLocalizedName() {
		return I18n.translateToLocal(this.getUnlocalizedName() + "." + this.getUnlocalizedName() + ".name");
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

	public boolean isTypeAt(World world, BlockPos pos, BlockKepler22bMapleTreeSapling.EnumType type) {
		IBlockState iblockstate = world.getBlockState(pos);
		return iblockstate.getBlock() == this && iblockstate.getValue(VARIANT) == type;
	}

	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(VARIANT).getMetadata();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		for (BlockKepler22bMapleTreeSapling.EnumType blockplanks$enumtype : BlockKepler22bMapleTreeSapling.EnumType.values()) {
			list.add(new ItemStack(this, 1, blockplanks$enumtype.getMetadata()));
		}
	}

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

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, BlockKepler22bMapleTreeSapling.EnumType.byMetadata(meta & 7)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | state.getValue(VARIANT).getMetadata();
		i = i | state.getValue(STAGE).intValue() << 3;
		return i;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { VARIANT, STAGE });
	}
}