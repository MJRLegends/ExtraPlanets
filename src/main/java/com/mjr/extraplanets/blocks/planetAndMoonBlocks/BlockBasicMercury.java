package com.mjr.extraplanets.blocks.planetAndMoonBlocks;

import java.util.List;
import java.util.Random;

import com.google.common.base.Predicate;
import com.mjr.extraplanets.ExtraPlanets;

import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import micdoodle8.mods.galacticraft.api.block.IPlantableBlock;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBasicMercury extends Block implements IDetectableResource, IPlantableBlock, ITerraformableBlock, ISortableBlock {
	public static final PropertyEnum<EnumBlockBasic> BASIC_TYPE = PropertyEnum.create("basictypemercury", EnumBlockBasic.class);

	public enum EnumBlockBasic implements IStringSerializable {
		SURFACE(0, "mercury_surface"), SUB_SURFACE(1, "mercury_sub_surface"), STONE(2, "mercury_stone"), ORE_IRON(3, "mercury_ore_iron"), ORE_TIN(4, "mercury_ore_tin"), ORE_COPPER(5, "mercury_ore_copper"), ORE_MERCURY(6,
				"mercury_ore_mercury"), MERCURY_BLOCK(7, "mercury_mercury_block"), STONEBRICKS(8, "mercury_stonebricks"), DUNGEON_BRICK(9, "mercury_dungeon_brick"), ORE_CARBON(10, "mercury_ore_carbon"), CARBON_BLOCK(11, "mercury_carbon_block");

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

	public BlockBasicMercury(String name) {
		super(Material.rock);
		this.setUnlocalizedName(name);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
	}

	@Override
	public MapColor getMapColor(IBlockState state) {
		if (state.getValue(BASIC_TYPE) == EnumBlockBasic.SURFACE) {
			return MapColor.dirtColor;
		}

		return MapColor.redColor;
	}

	@Override
	public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion) {
		IBlockState state = world.getBlockState(pos);
		if (state.getValue(BASIC_TYPE) == EnumBlockBasic.DUNGEON_BRICK)
			return 40.0F;
		else if (state.getValue(BASIC_TYPE) == EnumBlockBasic.STONE || state.getValue(BASIC_TYPE) == EnumBlockBasic.STONEBRICKS)
			return 6.0F;
		else if (state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_COPPER || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_IRON || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_TIN || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_CARBON
				|| state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_MERCURY)
			return 3.0F;
		return super.getExplosionResistance(world, pos, exploder, explosion);
	}

	@Override
	public float getBlockHardness(World world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos);
		if (state.getValue(BASIC_TYPE) == EnumBlockBasic.SURFACE || state.getValue(BASIC_TYPE) == EnumBlockBasic.SUB_SURFACE)
			return 0.5F;
		else if (state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_COPPER || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_IRON || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_TIN || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_CARBON
				|| state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_MERCURY)
			return 5.0F;
		else if (state.getValue(BASIC_TYPE) == EnumBlockBasic.DUNGEON_BRICK)
			return 4.0F;
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
	public int quantityDropped(IBlockState state, int fortune, Random rand) {
		return 1;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs tabs, List<ItemStack> list) {
		for (EnumBlockBasic blockBasic : EnumBlockBasic.values()) {
			list.add(new ItemStack(item, 1, blockBasic.getMeta()));
		}
	}

	@Override
	public boolean isValueable(IBlockState state) {
		EnumBlockBasic type = state.getValue(BASIC_TYPE);
		switch (type) {
		case ORE_IRON:
		case ORE_TIN:
		case ORE_COPPER:
		case ORE_MERCURY:
		case ORE_CARBON:
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean canSustainPlant(IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
		return false;
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
		IBlockState state = world.getBlockState(pos);
		return state.getValue(BASIC_TYPE) == EnumBlockBasic.SURFACE && !world.getBlockState(pos.up()).getBlock().isFullCube();
	}

	@Override
	public boolean isReplaceableOreGen(World world, BlockPos pos, Predicate<IBlockState> target) {
		if (target != Blocks.stone) {
			return false;
		}
		IBlockState state = world.getBlockState(pos);
		return (state.getValue(BASIC_TYPE) == EnumBlockBasic.STONE);
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return state.getBlock().getMetaFromState(state) == 10;
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
	protected BlockState createBlockState() {
		return new BlockState(this, BASIC_TYPE);
	}

	@Override
	public EnumSortCategoryBlock getCategory(int meta) {
		switch (meta) {
		case 3:
		case 4:
		case 5:
		case 6:
		case 10:
			return EnumSortCategoryBlock.ORE;
		case 7:
		case 11:
			return EnumSortCategoryBlock.INGOT_BLOCK;
		case 8:
		case 9:
			return EnumSortCategoryBlock.BRICKS;
		}
		return EnumSortCategoryBlock.GENERAL;
	}
}
