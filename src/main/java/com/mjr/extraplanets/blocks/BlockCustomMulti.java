package com.mjr.extraplanets.blocks;

import java.util.Collection;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.block.IPartialSealableBlock;
import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.blocks.BlockAdvanced;
import micdoodle8.mods.galacticraft.core.tile.TileEntityMulti;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCustomMulti extends BlockAdvanced implements IPartialSealableBlock, ITileEntityProvider {
	public static final PropertyEnum MULTI_TYPE = PropertyEnum.create("type", EnumBlockMultiType.class);
	public static final PropertyInteger RENDER_TYPE = PropertyInteger.create("rendertype", 0, 7);

	protected static final AxisAlignedBB AABB_PAD = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.2F, 1.0F);

	public enum EnumBlockMultiType implements IStringSerializable {
		TIER_2_ROCKET_PAD(0, "tier2_rocket_pad"), TIER_3_ROCKET_PAD(1, "tier3_rocket_pad"), POWER_CHARGING_PAD(2, "powered_charging_pad"), ROCKET_POWER_CHARGING_PAD(3, "rocket_powered_charging_pad");
		private final int meta;
		private final String name;

		EnumBlockMultiType(int meta, String name) {
			this.meta = meta;
			this.name = name;
		}

		public int getMeta() {
			return this.meta;
		}

		public static EnumBlockMultiType byMetadata(int meta) {
			return values()[meta];
		}

		@Override
		public String getName() {
			return this.name;
		}
	}

	public BlockCustomMulti(String assetName) {
		super(GCBlocks.machine);
		this.setHardness(1.0F);
		this.setSoundType(SoundType.METAL);
		this.setUnlocalizedName(assetName);
		this.setResistance(1000000000000000.0F);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		switch ((EnumBlockMultiType) state.getValue(MULTI_TYPE)) {
		case TIER_2_ROCKET_PAD:
		case TIER_3_ROCKET_PAD:
		case POWER_CHARGING_PAD:
			return AABB_PAD;
		default:
			return FULL_BLOCK_AABB;
		}
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean canDropFromExplosion(Explosion par1Explosion) {
		return false;
	}

	@Override
	public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
		TileEntity tileEntity = worldIn.getTileEntity(pos);

		if (tileEntity instanceof TileEntityMulti) {
			BlockPos mainBlockPosition = ((TileEntityMulti) tileEntity).mainBlockPosition;

			if (mainBlockPosition != null && !mainBlockPosition.equals(pos)) {
				return worldIn.getBlockState(mainBlockPosition).getBlock().getBlockHardness(blockState, worldIn, pos);
			}
		}

		return this.blockHardness;
	}

	@Override
	public boolean isSealed(World worldIn, BlockPos pos, EnumFacing direction) {
		int metadata = getMetaFromState(worldIn.getBlockState(pos));

		// Landing pad and refueling pad
		if (metadata == 0 || metadata == 1) {
			return direction == EnumFacing.DOWN;
		}
		return false;
	}

	public void makeFakeBlock(World worldObj, BlockPos pos, BlockPos mainBlock, int meta) {
		worldObj.setBlockState(pos, GCBlocks.fakeBlock.getStateFromMeta(meta), meta == 5 ? 3 : 0);
		worldObj.setTileEntity(pos, new TileEntityMulti(mainBlock));
	}

	public void makeFakeBlock(World worldObj, Collection<BlockPos> posList, BlockPos mainBlock, EnumBlockMultiType type) {
		for (BlockPos pos : posList) {
			worldObj.setBlockState(pos, this.getDefaultState().withProperty(MULTI_TYPE, type), 0);
			worldObj.setTileEntity(pos, new TileEntityMulti(mainBlock));
		}
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntity tileEntity = worldIn.getTileEntity(pos);

		if (tileEntity instanceof TileEntityMulti) {
			((TileEntityMulti) tileEntity).onBlockRemoval();
		}

		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public boolean onMachineActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityMulti tileEntity = (TileEntityMulti) worldIn.getTileEntity(pos);
		if (tileEntity == null) {
			return false;
		}
		return tileEntity.onBlockActivated(worldIn, pos, playerIn);
	}

	@Override
	public boolean onUseWrench(World world, BlockPos pos, EntityPlayer entityPlayer, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityMulti tileEntity = (TileEntityMulti) world.getTileEntity(pos);
        return tileEntity.onBlockWrenched(world, pos, entityPlayer, hand, side, hitX, hitY, hitZ);
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random par1Random) {
		return 0;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int meta) {
		return null;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		TileEntity tileEntity = world.getTileEntity(pos);
		if (tileEntity instanceof TileEntityMulti) {
			BlockPos mainBlockPosition = ((TileEntityMulti) tileEntity).mainBlockPosition;

			if (mainBlockPosition != null && !mainBlockPosition.equals(pos)) {
				IBlockState mainBlockState = world.getBlockState(mainBlockPosition);

				if (Blocks.AIR != mainBlockState.getBlock()) {
					return mainBlockState.getBlock().getPickBlock(mainBlockState, target, world, mainBlockPosition, player);
				}
			}
		}

		return null;
	}

	@Override
	public boolean addHitEffects(IBlockState state, World worldObj, RayTraceResult target, ParticleManager manager) {
		TileEntity tileEntity = worldObj.getTileEntity(target.getBlockPos());

		if (tileEntity instanceof TileEntityMulti) {
			BlockPos mainBlockPosition = ((TileEntityMulti) tileEntity).mainBlockPosition;

			if (mainBlockPosition != null && !mainBlockPosition.equals(target.getBlockPos())) {
				manager.addBlockHitEffects(mainBlockPosition, target);
			}
		}

		return super.addHitEffects(state, worldObj, target, manager);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(MULTI_TYPE, EnumBlockMultiType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumBlockMultiType) state.getValue(MULTI_TYPE)).getMeta();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, MULTI_TYPE, RENDER_TYPE);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		EnumBlockMultiType type = (EnumBlockMultiType) state.getValue(MULTI_TYPE);
		int renderType = 0;

		switch (type) {
		default:
			break;
		}

		return state.withProperty(RENDER_TYPE, renderType);
	}
}
