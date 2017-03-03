package com.mjr.extraplanets.blocks.planetAndMoonBlocks;

import java.util.List;
import java.util.Random;

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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.base.Predicate;
import com.mjr.extraplanets.ExtraPlanets;

public class BlockBasicKepler22b extends Block implements IDetectableResource, IPlantableBlock, ITerraformableBlock, ISortableBlock {
	public static final PropertyEnum BASIC_TYPE = PropertyEnum.create("basicTypeKepler22b", EnumBlockBasic.class);

	public enum EnumBlockBasic implements IStringSerializable {
		DIRT(0, "kepler22b_dirt"), 
		STONE(1, "kepler22b_stone"), 
		ORE_IRON(2, "kepler22b_ore_iron"), 
		ORE_TIN(3, "kepler22b_ore_tin"), 
		ORE_COPPER(4, "kepler22b_ore_copper"), 
		ORE_DENSE_COAL(5, "kepler22b_ore_dense_coal"), 
		ORE_BLUE_DIAMOND(6, "kepler22b_ore_blue_diamond"), 
		ORE_RED_DIAMOND(7, "kepler22b_ore_red_diamond"), 
		ORE_PURPLE_DIAMOND(8, "kepler22b_ore_purple_diamond"), 
		ORE_YELLOW_DIAMOND(9, "kepler22b_ore_yellow_diamond"), 
		ORE_GREEN_DIAMOND(10, "kepler22b_ore_green_diamond"), 
		STONEBRICKS(11, "kepler22b_stonebricks"), 
		COBBLESTONE(12, "kepler22b_cobblestone");

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

	public BlockBasicKepler22b(String assetName) {
		super(Material.rock);
		this.setUnlocalizedName(assetName);
        this.setCreativeTab(ExtraPlanets.BlocksTab);
	}

	@Override
	public MapColor getMapColor(IBlockState state) {
		if (state.getValue(BASIC_TYPE) == EnumBlockBasic.DIRT) {
			return MapColor.dirtColor;
		}

		return MapColor.redColor;
	}

	@Override
	public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion) {
		return super.getExplosionResistance(world, pos, exploder, explosion);
	}

	@Override
	public float getBlockHardness(World worldIn, BlockPos pos) {
		IBlockState state = worldIn.getBlockState(pos);
		return this.blockHardness;
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (EnumBlockBasic blockBasic : EnumBlockBasic.values()) {
			par3List.add(new ItemStack(par1, 1, blockBasic.getMeta()));
		}
	}

	@Override
	public boolean isValueable(IBlockState state) {
		switch (this.getMetaFromState(state)) {
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
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
	public boolean isPlantable(IBlockState arg0)  {
		return false;
	}

	@Override
	public boolean isTerraformable(World world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos);
		return state.getValue(BASIC_TYPE) == EnumBlockBasic.DIRT && !world.getBlockState(pos.up()).getBlock().isFullCube();
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
		IBlockState state = world.getBlockState(pos);
		int metadata = state.getBlock().getMetaFromState(state);
		return super.getPickBlock(target, world, pos, player);
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
		return ((EnumBlockBasic) state.getValue(BASIC_TYPE)).getMeta();
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, BASIC_TYPE);
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
			return EnumSortCategoryBlock.ORE;
		case 11:
			return EnumSortCategoryBlock.BRICKS;
		}
		return EnumSortCategoryBlock.GENERAL;
	}
}
