package com.mjr.extraplanets.blocks.planetAndMoonBlocks;

import java.util.Random;

import com.google.common.base.Predicate;
import com.mjr.extraplanets.ExtraPlanets;

import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import micdoodle8.mods.galacticraft.api.block.IPlantableBlock;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.client.sounds.GCSounds;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;
import micdoodle8.mods.galacticraft.planets.GalacticraftPlanets;

import net.minecraft.block.Block;
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
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBasicJupiter extends Block implements IDetectableResource, IPlantableBlock, ITerraformableBlock, ISortableBlock {
	public static final PropertyEnum<EnumBlockBasic> BASIC_TYPE = PropertyEnum.create("basictypejupiter", EnumBlockBasic.class);

	public enum EnumBlockBasic implements IStringSerializable {
		SURFACE(0, "jupiter_surface"), SUB_SURFACE(1, "jupiter_sub_surface"), STONE(2, "jupiter_stone"), ORE_IRON(3, "jupiter_ore_iron"), ORE_TIN(4, "jupiter_ore_tin"), ORE_COPPER(5, "jupiter_ore_copper"), ORE_PALLADIUM(6,
				"jupiter_ore_palladium"), ORE_NICKEL(7, "jupiter_ore_nickel"), PALLADIUM_BLOCK(8, "jupiter_palladium_block"), STONEBRICKS(9,
						"jupiter_stonebricks"), DUNGEON_BRICK(10, "jupiter_dungeon_brick"), ORE_RED_GEM(11, "jupiter_ore_red_gem"), RED_GEM_BLOCK(12, "jupiter_red_gem_block"), NICKEL_BLOCK(13, "jupiter_nickel_block");

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

	public BlockBasicJupiter(String name) {
		super(Material.ROCK);
		this.setUnlocalizedName(name);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
	}

	@Override
	public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion) {
		IBlockState state = world.getBlockState(pos);
		if (state.getValue(BASIC_TYPE) == EnumBlockBasic.DUNGEON_BRICK)
			return 40.0F;
		else if (state.getValue(BASIC_TYPE) == EnumBlockBasic.STONE || state.getValue(BASIC_TYPE) == EnumBlockBasic.STONEBRICKS)
			return 6.0F;
		else if (state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_COPPER || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_IRON || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_TIN || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_PALLADIUM
				|| state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_NICKEL || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_RED_GEM)
			return 3.0F;
		return super.getExplosionResistance(world, pos, exploder, explosion);
	}

	@Override
	public float getBlockHardness(IBlockState state, World world, BlockPos pos) {
		if (state.getValue(BASIC_TYPE) == EnumBlockBasic.SURFACE || state.getValue(BASIC_TYPE) == EnumBlockBasic.SUB_SURFACE)
			return 0.5F;
		else if (state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_COPPER || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_IRON || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_TIN || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_PALLADIUM
				|| state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_NICKEL || state.getValue(BASIC_TYPE) == EnumBlockBasic.ORE_RED_GEM)
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
		case ORE_PALLADIUM:
		case ORE_NICKEL:
		case ORE_RED_GEM:
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
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
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
		if (rand.nextInt(10) == 0) {
			if (state.getBlock() == this && state.getValue(BASIC_TYPE) == EnumBlockBasic.DUNGEON_BRICK) {
				GalacticraftPlanets.spawnParticle("sludgeDrip", new Vector3(pos.getX() + rand.nextDouble(), pos.getY(), pos.getZ() + rand.nextDouble()), new Vector3(0, 0, 0));

				if (rand.nextInt(100) == 0) {
					world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), GCSounds.singleDrip, SoundCategory.AMBIENT, 1, 0.8F + rand.nextFloat() / 5.0F);
				}
			}
		}
	}

	@Override
	public boolean isTerraformable(World world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos);
		IBlockState stateAbove = world.getBlockState(pos.up());
		return state.getValue(BASIC_TYPE) == EnumBlockBasic.SURFACE && !stateAbove.isFullCube();
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
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 11:
			return EnumSortCategoryBlock.ORE;
		case 8:
		case 12:
		case 13:
			return EnumSortCategoryBlock.INGOT_BLOCK;
		case 10:
		case 9:
			return EnumSortCategoryBlock.BRICKS;
		}
		return EnumSortCategoryBlock.GENERAL;
	}
}
