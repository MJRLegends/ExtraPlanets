package com.mjr.extraplanets.blocks;

import java.util.Random;

import com.mjr.extraplanets.tileEntities.blocks.TileEntityBasicDecontaminationUnitFake;

import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.blocks.BlockAdvancedTile;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyBool;
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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDecontaminationUnitFake extends BlockAdvancedTile implements ITileEntityProvider {
	public static final PropertyBool TOP = PropertyBool.create("top");
	public static final PropertyBool CONNECTABLE = PropertyBool.create("connectable");

	public BlockDecontaminationUnitFake(String name) {
		super(GCBlocks.machine);
		this.setSoundType(SoundType.METAL);
		this.setUnlocalizedName(name);
		this.setResistance(1000000000000000.0F);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return FULL_BLOCK_AABB;
	}

	@Override
	public boolean canDropFromExplosion(Explosion par1Explosion) {
		return false;
	}

	public void makeFakeBlock(World world, BlockPos pos, BlockPos mainBlock, IBlockState state) {
		world.setBlockState(pos, state, 3);
		((TileEntityBasicDecontaminationUnitFake) world.getTileEntity(pos)).setMainBlock(mainBlock);
	}

	@Override
	public float getBlockHardness(IBlockState state, World world, BlockPos pos) {
		TileEntity tileEntity = world.getTileEntity(pos);

		if (tileEntity instanceof TileEntityBasicDecontaminationUnitFake) {
			BlockPos mainBlockPosition = ((TileEntityBasicDecontaminationUnitFake) tileEntity).mainBlockPosition;

			if (mainBlockPosition != null) {
				return world.getBlockState(mainBlockPosition).getBlock().getBlockHardness(state, world, pos);
			}
		}

		return this.blockHardness;
	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntity tileEntity = world.getTileEntity(pos);

		if (tileEntity instanceof TileEntityBasicDecontaminationUnitFake) {
			((TileEntityBasicDecontaminationUnitFake) tileEntity).onBlockRemoval();
		}

		super.breakBlock(world, pos, state);
	}

	@Override
	public boolean onMachineActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entityPlayer, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityBasicDecontaminationUnitFake tileEntity = (TileEntityBasicDecontaminationUnitFake) world.getTileEntity(pos);
		return tileEntity.onActivated(entityPlayer);
	}

	@Override
	public int quantityDropped(Random rand) {
		return 0;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.INVISIBLE;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBasicDecontaminationUnitFake();
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		TileEntity tileEntity = world.getTileEntity(pos);
		BlockPos mainBlockPosition = ((TileEntityBasicDecontaminationUnitFake) tileEntity).mainBlockPosition;

		if (mainBlockPosition != null) {
			Block mainBlockID = world.getBlockState(mainBlockPosition).getBlock();

			if (Blocks.AIR != mainBlockID) {
				return mainBlockID.getPickBlock(world.getBlockState(mainBlockPosition), target, world, mainBlockPosition, player);
			}
		}

		return ItemStack.EMPTY;
	}

	@Override
	public boolean addHitEffects(IBlockState state, World worldObj, RayTraceResult target, ParticleManager manager) {
		TileEntity tileEntity = worldObj.getTileEntity(target.getBlockPos());

		if (tileEntity instanceof TileEntityBasicDecontaminationUnitFake) {
			BlockPos mainBlockPosition = ((TileEntityBasicDecontaminationUnitFake) tileEntity).mainBlockPosition;

			if (mainBlockPosition != null) {
				manager.addBlockHitEffects(mainBlockPosition, target);
			}
		}

		return super.addHitEffects(state, worldObj, target, manager);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, TOP, CONNECTABLE);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(TOP, meta % 2 == 1).withProperty(CONNECTABLE, meta > 1);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return (state.getValue(TOP) ? 1 : 0) + (state.getValue(CONNECTABLE) ? 2 : 0);
	}
}