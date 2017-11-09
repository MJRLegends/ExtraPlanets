package com.mjr.extraplanets.blocks;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;

public class BlockCakeBlocks extends Block implements IDetectableResource, ISortableBlock {
	public static final PropertyEnum<EnumBlockBasic> BASIC_TYPE = PropertyEnum.create("basictypecakeblocks", EnumBlockBasic.class);

	public enum EnumBlockBasic implements IStringSerializable {
		CAKE_BLOCK(0, "cake_block"), CAKE_BLOCK_RED_VERVET(1, "cake_block_red_velvet"), CAKE_BLOCK_CHOCOLATE(2, "cake_block_chocolate"), WHITE_ICING_RED_DOTS(3, "white_icing_red_dots"), WHITE_ICING_GREEN_DOTS(4, "white_icing_green_dots"), WHITE_ICING_PINK_DOTS(
				5, "white_icing_pink_dots"), WHITE_ICING_ORANGE_DOTS(6, "white_icing_orange_dots"), COOKIE_ROCKS(7, "cookie_rocks");

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

	public BlockCakeBlocks(String assetName) {
		super(Material.rock);
		this.setUnlocalizedName(assetName);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
	}

	@Override
	public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion) {
		return super.getExplosionResistance(world, pos, exploder, explosion);
	}

	@Override
	public float getBlockHardness(World worldIn, BlockPos pos) {
		return 1.5F;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if (state == this.getDefaultState().withProperty(BASIC_TYPE, EnumBlockBasic.COOKIE_ROCKS))
			return Items.cookie;
		return Item.getItemFromBlock(this);
	}

	@Override
	public int damageDropped(IBlockState state) {
		int meta = state.getBlock().getMetaFromState(state);
		return meta;
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		if (state == this.getDefaultState().withProperty(BASIC_TYPE, EnumBlockBasic.COOKIE_ROCKS))
			return 6;
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
		return false;
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
		return super.getPickBlock(target, world, pos, player);
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
		return EnumSortCategoryBlock.GENERAL;
	}
}
