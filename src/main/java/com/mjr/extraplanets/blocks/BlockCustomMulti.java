package com.mjr.extraplanets.blocks;

import java.util.Collection;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.block.IPartialSealableBlock;
import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.blocks.BlockAdvanced;
import micdoodle8.mods.galacticraft.core.tile.TileEntityMulti;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCustomMulti extends BlockAdvanced implements IPartialSealableBlock, ITileEntityProvider {
	public static final PropertyEnum<EnumBlockMultiType> MULTI_TYPE = PropertyEnum.create("type", EnumBlockMultiType.class);
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
		this.setStepSound(Block.soundTypeMetal);
		this.setUnlocalizedName(assetName);
		this.setResistance(1000000000000000.0F);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean canDropFromExplosion(Explosion par1Explosion) {
		return false;
	}

	@Override
	public float getBlockHardness(World world, BlockPos pos) {
		TileEntity tileEntity = world.getTileEntity(pos);

		if (tileEntity instanceof TileEntityMulti) {
			BlockPos mainBlockPosition = ((TileEntityMulti) tileEntity).mainBlockPosition;

			if (mainBlockPosition != null && !mainBlockPosition.equals(pos)) {
				return world.getBlockState(mainBlockPosition).getBlock().getBlockHardness(world, pos);
			}
		}

		return this.blockHardness;
	}

	@Override
	public boolean isSealed(World world, BlockPos pos, EnumFacing direction) {
		int metadata = getMetaFromState(world.getBlockState(pos));

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
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntity tileEntity = world.getTileEntity(pos);

		if (tileEntity instanceof TileEntityMulti) {
			((TileEntityMulti) tileEntity).onBlockRemoval();
		}

		super.breakBlock(world, pos, state);
	}

	@Override
	public boolean onMachineActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityMulti tileEntity = (TileEntityMulti) world.getTileEntity(pos);
		if (tileEntity == null) {
			return false;
		}
		return tileEntity.onBlockActivated(world, pos, player);
	}

	@Override
	public boolean onUseWrench(World world, BlockPos pos, EntityPlayer entityPlayer, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityMulti tileEntity = (TileEntityMulti) world.getTileEntity(pos);
		return tileEntity.onBlockWrenched(world, pos, entityPlayer, side, hitX, hitY, hitZ);
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random par1Random) {
		return 0;
	}

	@Override
	public int getRenderType() {
		return 3;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int meta) {
		return null;
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
		TileEntity tileEntity = world.getTileEntity(pos);
		if (tileEntity instanceof TileEntityMulti) {
			BlockPos mainBlockPosition = ((TileEntityMulti) tileEntity).mainBlockPosition;

			if (mainBlockPosition != null && !mainBlockPosition.equals(pos)) {
				Block mainBlockID = world.getBlockState(mainBlockPosition).getBlock();

				if (Blocks.air != mainBlockID) {
					return mainBlockID.getPickBlock(target, world, mainBlockPosition, player);
				}
			}
		}

		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean addHitEffects(World worldObj, MovingObjectPosition target, EffectRenderer effectRenderer) {
		TileEntity tileEntity = worldObj.getTileEntity(target.getBlockPos());

		if (tileEntity instanceof TileEntityMulti) {
			BlockPos mainBlockPosition = ((TileEntityMulti) tileEntity).mainBlockPosition;

			if (mainBlockPosition != null && !mainBlockPosition.equals(target.getBlockPos())) {
				effectRenderer.addBlockHitEffects(mainBlockPosition, target);
			}
		}

		return super.addHitEffects(worldObj, target, effectRenderer);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(MULTI_TYPE, EnumBlockMultiType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(MULTI_TYPE).getMeta();
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, MULTI_TYPE, RENDER_TYPE);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
		EnumBlockMultiType type = state.getValue(MULTI_TYPE);
		int renderType = 0;

		switch (type) {
		default:
			break;
		}

		return state.withProperty(RENDER_TYPE, renderType);
	}
}
