package com.mjr.extraplanets.blocks.planetAndMoonBlocks;

import java.util.List;
import java.util.Random;

import com.google.common.base.Predicate;
import com.mjr.extraplanets.ExtraPlanets;

import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import micdoodle8.mods.galacticraft.api.block.IPlantableBlock;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;
import micdoodle8.mods.galacticraft.planets.GalacticraftPlanets;

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
import net.minecraft.init.Items;
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

public class BlockBasicSaturn extends Block implements IDetectableResource, IPlantableBlock, ITerraformableBlock, ISortableBlock {
	public static final PropertyEnum<EnumBlockBasic> BASIC_TYPE = PropertyEnum.create("basictypesaturn", EnumBlockBasic.class);

	public enum EnumBlockBasic implements IStringSerializable {
		SURFACE(0, "saturn_surface"), SUB_SURFACE(1, "saturn_sub_surface"), STONE(2, "saturn_stone"), ORE_IRON(3, "saturn_ore_iron"), ORE_TIN(4, "saturn_ore_tin"), ORE_COPPER(5, "saturn_ore_copper"), ORE_MAGNESIUM(6,
				"saturn_ore_magnesium"), MAGNESIUM_BLOCK(7, "saturn_magnesium_block"), STONEBRICKS(8,
						"saturn_stonebricks"), DUNGEON_BRICK(9, "saturn_dungeon_brick"), BROKEN_INFECTED_STONE(10, "broken_infected_stone"), INFECTED_STONE(11, "infected_stone"), ORE_SLIME(12, "saturn_ore_slime");

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

	public BlockBasicSaturn(String name) {
		super(Material.rock);
		this.setUnlocalizedName(name);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
	}

	@Override
	public MapColor getMapColor(IBlockState state) {
		if (state.getValue(BASIC_TYPE) == EnumBlockBasic.DUNGEON_BRICK) {
			return MapColor.greenColor;
		} else if (state.getValue(BASIC_TYPE) == EnumBlockBasic.SURFACE) {
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
		else if (state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_COPPER || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_IRON || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_TIN || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_MAGNESIUM
				|| state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_SLIME)
			return 3.0F;
		return super.getExplosionResistance(world, pos, exploder, explosion);
	}

	@Override
	public float getBlockHardness(World world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos);
		if (state.getValue(BASIC_TYPE) == EnumBlockBasic.SURFACE || state.getValue(BASIC_TYPE) == EnumBlockBasic.SUB_SURFACE)
			return 0.5F;
		else if (state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_COPPER || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_IRON || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_TIN || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_MAGNESIUM
				|| state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_SLIME)
			return 5.0F;
		else if (state.getValue(BASIC_TYPE) == EnumBlockBasic.DUNGEON_BRICK)
			return 4.0F;
		else
			return 1.5F;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if (state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_SLIME)
			return Items.slime_ball;
		return Item.getItemFromBlock(this);
	}

	@Override
	public int damageDropped(IBlockState state) {
		if (state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_SLIME)
			return 0;
		else
			return state.getBlock().getMetaFromState(state);
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random rand) {
		if (state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_SLIME)
			return 12;
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
		case ORE_MAGNESIUM:
		case ORE_SLIME:
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
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random rand) {
		if (rand.nextInt(10) == 0) {
			if (state.getBlock() == this && state.getValue(BASIC_TYPE) == EnumBlockBasic.DUNGEON_BRICK) {
				GalacticraftPlanets.spawnParticle("sludgeDrip", new Vector3(pos.getX() + rand.nextDouble(), pos.getY(), pos.getZ() + rand.nextDouble()), new Vector3(0, 0, 0));

				if (rand.nextInt(100) == 0) {
					world.playSound(pos.getX(), pos.getY(), pos.getZ(), Constants.TEXTURE_PREFIX + "ambience.singledrip", 1, 0.8F + rand.nextFloat() / 5.0F, false);
				}
			}
		}
	}

	@Override
	public boolean isTerraformable(World world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos);
		return state.getValue(BASIC_TYPE) == EnumBlockBasic.SURFACE && !world.getBlockState(pos.up()).getBlock().isFullCube();
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
		if (world.getBlockState(pos).getValue(BASIC_TYPE) == EnumBlockBasic.ORE_SLIME)
			return new ItemStack(Item.getItemFromBlock(this), 1, 12);
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
		case 12:
			return EnumSortCategoryBlock.ORE;
		case 7:
			return EnumSortCategoryBlock.INGOT_BLOCK;
		case 8:
		case 9:
			return EnumSortCategoryBlock.BRICKS;
		}
		return EnumSortCategoryBlock.GENERAL;
	}
}
