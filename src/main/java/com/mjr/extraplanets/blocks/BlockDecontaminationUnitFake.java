package com.mjr.extraplanets.blocks;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.blocks.BlockAdvancedTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.tileEntities.blocks.TileEntityBasicDecontaminationUnitFake;

public class BlockDecontaminationUnitFake extends BlockAdvancedTile implements ITileEntityProvider {
	public static final PropertyBool TOP = PropertyBool.create("top");
	public static final PropertyBool CONNECTABLE = PropertyBool.create("connectable");

	public BlockDecontaminationUnitFake(String assetName) {
		super(GCBlocks.machine);
		this.setStepSound(Block.soundTypeMetal);
		this.setUnlocalizedName(assetName);
		this.setResistance(1000000000000000.0F);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
		return AxisAlignedBB.fromBounds((double) pos.getX() + -0.0F, (double) pos.getY() + 0.0F, (double) pos.getZ() + -0.0F, (double) pos.getX() + 1.0F, (double) pos.getY() + 1.4F, (double) pos.getZ() + 1.0F);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos) {
		return this.getCollisionBoundingBox(worldIn, pos, worldIn.getBlockState(pos));
	}

	@Override
	public MovingObjectPosition collisionRayTrace(World worldIn, BlockPos pos, Vec3 start, Vec3 end) {
		this.setBlockBounds(-0.0F, 0.0F, -0.0F, 1.0F, 1.4F, 1.0F);

		final MovingObjectPosition r = super.collisionRayTrace(worldIn, pos, start, end);

		this.setBlockBounds(-0.0F, 0.0F, -0.0F, 1.0F, 1.4F, 1.0F);

		return r;
	}

	@Override
	public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List<AxisAlignedBB> list, Entity collidingEntity) {
		this.setBlockBounds(-0.0F, 0.0F, -0.0F, 1.0F, 1.4F, 1.0F);
		super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
	}

	@Override
	public boolean canDropFromExplosion(Explosion par1Explosion) {
		return false;
	}

	public void makeFakeBlock(World worldObj, BlockPos pos, BlockPos mainBlock, IBlockState state) {
		worldObj.setBlockState(pos, state, 3);
		((TileEntityBasicDecontaminationUnitFake) worldObj.getTileEntity(pos)).setMainBlock(mainBlock);
	}

	@Override
	public float getBlockHardness(World worldIn, BlockPos pos) {
		TileEntity tileEntity = worldIn.getTileEntity(pos);

		if (tileEntity instanceof TileEntityBasicDecontaminationUnitFake) {
			BlockPos mainBlockPosition = ((TileEntityBasicDecontaminationUnitFake) tileEntity).mainBlockPosition;

			if (mainBlockPosition != null) {
				return worldIn.getBlockState(mainBlockPosition).getBlock().getBlockHardness(worldIn, mainBlockPosition);
			}
		}

		return this.blockHardness;
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntity tileEntity = worldIn.getTileEntity(pos);

		if (tileEntity instanceof TileEntityBasicDecontaminationUnitFake) {
			((TileEntityBasicDecontaminationUnitFake) tileEntity).onBlockRemoval();
		}

		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityBasicDecontaminationUnitFake tileEntity = (TileEntityBasicDecontaminationUnitFake) worldIn.getTileEntity(pos);
		return tileEntity.onActivated(playerIn);
	}

	@Override
	public int quantityDropped(Random par1Random) {
		return 0;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int meta) {
		return new TileEntityBasicDecontaminationUnitFake();
	}

	@Override
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
		TileEntity tileEntity = world.getTileEntity(pos);
		BlockPos mainBlockPosition = ((TileEntityBasicDecontaminationUnitFake) tileEntity).mainBlockPosition;

		if (mainBlockPosition != null) {
			Block mainBlockID = world.getBlockState(mainBlockPosition).getBlock();

			if (Blocks.air != mainBlockID) {
				return mainBlockID.getPickBlock(target, world, mainBlockPosition, player);
			}
		}

		return null;
	}

	@Override
	public EnumFacing getBedDirection(IBlockAccess world, BlockPos pos) {
		TileEntity tileEntity = world.getTileEntity(pos);
		BlockPos mainBlockPosition = ((TileEntityBasicDecontaminationUnitFake) tileEntity).mainBlockPosition;

		if (mainBlockPosition != null) {
			return world.getBlockState(pos).getBlock().getBedDirection(world, mainBlockPosition);
		}

		return getActualState(world.getBlockState(pos), world, pos).getValue(BlockDirectional.FACING);
	}

	@Override
	public boolean isBed(IBlockAccess world, BlockPos pos, Entity player) {
		TileEntity tileEntity = world.getTileEntity(pos);
		BlockPos mainBlockPosition = ((TileEntityBasicDecontaminationUnitFake) tileEntity).mainBlockPosition;

		if (mainBlockPosition != null) {
			return world.getBlockState(pos).getBlock().isBed(world, mainBlockPosition, player);
		}

		return super.isBed(world, pos, player);
	}

	@Override
	public void setBedOccupied(IBlockAccess world, BlockPos pos, EntityPlayer player, boolean occupied) {
		TileEntity tileEntity = world.getTileEntity(pos);
		BlockPos mainBlockPosition = ((TileEntityBasicDecontaminationUnitFake) tileEntity).mainBlockPosition;

		if (mainBlockPosition != null) {
			world.getBlockState(pos).getBlock().setBedOccupied(world, mainBlockPosition, player, occupied);
		} else {
			super.setBedOccupied(world, pos, player, occupied);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean addHitEffects(World worldObj, MovingObjectPosition target, EffectRenderer effectRenderer) {
		TileEntity tileEntity = worldObj.getTileEntity(target.getBlockPos());

		if (tileEntity instanceof TileEntityBasicDecontaminationUnitFake) {
			BlockPos mainBlockPosition = ((TileEntityBasicDecontaminationUnitFake) tileEntity).mainBlockPosition;

			if (mainBlockPosition != null) {
				effectRenderer.addBlockHitEffects(mainBlockPosition, target);
			}
		}

		return super.addHitEffects(worldObj, target, effectRenderer);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean addDestroyEffects(World world, BlockPos pos, EffectRenderer effectRenderer) {
		return super.addDestroyEffects(world, pos, effectRenderer);
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, TOP, CONNECTABLE);
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