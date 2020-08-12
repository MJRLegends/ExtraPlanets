package com.mjr.extraplanets.blocks.planetAndMoonBlocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import micdoodle8.mods.galacticraft.api.block.IPlantableBlock;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBasicKepler22b extends Block implements IDetectableResource, IPlantableBlock, ITerraformableBlock, ISortableBlock {
	public static final PropertyEnum<EnumBlockBasic> BASIC_TYPE = PropertyEnum.create("basictypekepler22b", EnumBlockBasic.class);

	public enum EnumBlockBasic implements IStringSerializable {
		DIRT(0, "kepler22b_dirt"), STONE(1, "kepler22b_stone"), ORE_IRON(2, "kepler22b_ore_iron"), ORE_TIN(3, "kepler22b_ore_tin"), ORE_COPPER(4, "kepler22b_ore_copper"), ORE_DENSE_COAL(5, "kepler22b_ore_dense_coal"), ORE_BLUE_DIAMOND(6,
				"kepler22b_ore_blue_diamond"), ORE_RED_DIAMOND(7, "kepler22b_ore_red_diamond"), ORE_PURPLE_DIAMOND(8, "kepler22b_ore_purple_diamond"), ORE_YELLOW_DIAMOND(9, "kepler22b_ore_yellow_diamond"), ORE_GREEN_DIAMOND(10,
						"kepler22b_ore_green_diamond"), STONEBRICKS(11, "kepler22b_stonebricks"), COBBLESTONE(12, "kepler22b_cobblestone"), ORE_PLATINUM(13, "kepler22b_ore_platinum"), PLATINUM_BLOCK(14, "kepler22b_platinum_block");

		private final int meta;
		private final String name;

		private EnumBlockBasic(int meta, String name) {
			this.meta = meta;
			this.name = name;
		}

		public int getMeta() {
			return this.meta;
		}

		public static EnumBlockBasic byMetadata(int meta) {
			return values()[meta];
		}

		@Override
		public String getName() {
			return this.name;
		}
	}

	public BlockBasicKepler22b(String name) {
		super(Material.ROCK);
		this.setUnlocalizedName(name);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
	}

	@Override
	public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion) {
		IBlockState state = world.getBlockState(pos);
		if (state.getValue(BASIC_TYPE) == EnumBlockBasic.STONE || state.getValue(BASIC_TYPE) == EnumBlockBasic.STONEBRICKS)
			return 6.0F;
		else if (state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_COPPER || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_IRON || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_TIN || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_DENSE_COAL
				|| state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_BLUE_DIAMOND || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_GREEN_DIAMOND || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_PURPLE_DIAMOND
				|| state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_YELLOW_DIAMOND || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_PLATINUM)
			return 3.0F;
		return super.getExplosionResistance(world, pos, exploder, explosion);
	}

	@Override
	public float getBlockHardness(IBlockState state, World world, BlockPos pos) {
		if (state.getValue(BASIC_TYPE) == EnumBlockBasic.DIRT)
			return 0.5F;
		else if (state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_COPPER || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_IRON || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_TIN || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_DENSE_COAL
				|| state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_BLUE_DIAMOND || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_GREEN_DIAMOND || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_PURPLE_DIAMOND
				|| state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_YELLOW_DIAMOND || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_PLATINUM)
			return 5.0F;
		else
			return 1.5F;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}

	@Override
	public int damageDropped(IBlockState state) {
		int meta = state.getBlock().getMetaFromState(state);
		return meta;
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return 1;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		for (EnumBlockBasic blockBasic : EnumBlockBasic.values()) {
			list.add(new ItemStack(this, 1, blockBasic.getMeta()));
		}
	}

	@Override
	public boolean isValueable(IBlockState state) {
		EnumBlockBasic type = state.getValue(BASIC_TYPE);
		switch (type) {
		case ORE_IRON:
		case ORE_TIN:
		case ORE_COPPER:
		case ORE_DENSE_COAL:
		case ORE_BLUE_DIAMOND:
		case ORE_RED_DIAMOND:
		case ORE_PURPLE_DIAMOND:
		case ORE_YELLOW_DIAMOND:
		case ORE_GREEN_DIAMOND:
		case ORE_PLATINUM:
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
		Block block = plantable.getPlant(world, pos).getBlock();
		return block == ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING;
	}

	@Override
	public int requiredLiquidBlocksNearby() {
		return 4;
	}

	@Override
	public boolean isPlantable(IBlockState arg0) {
		return false;
	}

	@Override
	public boolean isTerraformable(World world, BlockPos pos) {
		return false;
	}

	@Override
	public boolean isReplaceableOreGen(IBlockState state, IBlockAccess world, BlockPos pos, Predicate<IBlockState> target) {
		if (target != Blocks.STONE) {
			return false;
		}
		return (state.getValue(BASIC_TYPE) == EnumBlockBasic.STONE);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(BASIC_TYPE, EnumBlockBasic.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(BASIC_TYPE).getMeta();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, BASIC_TYPE);
	}

	@Override
	public EnumSortCategoryBlock getCategory(int meta) {
		switch (meta) {
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
		case 13:
			return EnumSortCategoryBlock.ORE;
		case 14:
			return EnumSortCategoryBlock.INGOT_BLOCK;
		case 11:
			return EnumSortCategoryBlock.BRICKS;
		}
		return EnumSortCategoryBlock.GENERAL;
	}

	public SoundType getSoundType(IBlockState state, World world, BlockPos pos, @Nullable Entity entity) {
		return state.getValue(BASIC_TYPE) == EnumBlockBasic.DIRT ? SoundType.PLANT : super.getSoundType(state, world, pos, entity);
	}
}
