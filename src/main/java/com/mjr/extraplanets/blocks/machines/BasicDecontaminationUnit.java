package com.mjr.extraplanets.blocks.machines;

import java.util.List;

import micdoodle8.mods.galacticraft.core.blocks.BlockTileGC;
import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.tile.IMultiBlock;
import micdoodle8.mods.galacticraft.core.util.EnumColor;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicDecontaminationUnit;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class BasicDecontaminationUnit extends BlockTileGC implements ISortableBlock {
	protected BasicDecontaminationUnit(String assetName) {
		super(Material.iron);
		this.blockHardness = 3.0F;
		this.setUnlocalizedName(assetName);
		this.setStepSound(Block.soundTypeMetal);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ExtraPlanets.BlocksTab;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBasicDecontaminationUnit();
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

	@SuppressWarnings("rawtypes")
	@Override
	public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List list, Entity collidingEntity) {
		this.setBlockBounds(-0.0F, 0.0F, -0.0F, 1.0F, 1.4F, 1.0F);
		super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);

		TileEntity tile = worldIn.getTileEntity(pos);

		boolean validSpot = true;

		for (int x = -1; x <= 1; x++) {
			for (int y = 0; y < 3; y += 2) {
				for (int z = -1; z <= 1; z++) {
					if (!(x == 0 && y == 0 && z == 0)) {
						IBlockState stateAt = worldIn.getBlockState(pos.add(x, y, z));

						if (!stateAt.getBlock().getMaterial().isReplaceable()) {
							validSpot = false;
						}
					}
				}
			}
		}

		if (!validSpot) {
			worldIn.setBlockToAir(pos);

			if (placer instanceof EntityPlayer) {
				if (!worldIn.isRemote) {
					((EntityPlayer) placer).addChatMessage(new ChatComponentText(EnumColor.RED + TranslateUtilities.translate("gui.warning.noroom")));
				}
				((EntityPlayer) placer).inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(this), 1, 0));
			}

			return;
		}

		if (tile instanceof TileEntityBasicDecontaminationUnit) {
			((TileEntityBasicDecontaminationUnit) tile).onCreate(worldIn, pos);
		}
	}

	@Override
	public boolean onMachineActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		return ((IMultiBlock) worldIn.getTileEntity(pos)).onActivated(playerIn);
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		final TileEntity tileAt = worldIn.getTileEntity(pos);

		int fakeBlockCount = 0;

		for (int x = -1; x <= 1; x++) {
			for (int y = 0; y < 3; y += 2) {
				for (int z = -1; z <= 1; z++) {
					if (!(x == 0 && y == 0 && z == 0)) {
						if (worldIn.getBlockState(pos.add(x, y, z)).getBlock() == ExtraPlanets_Blocks.FAKE_BLOCK_DECONTAMINATION_UNIT) {
							fakeBlockCount++;
						}
					}
				}
			}
		}

		if (tileAt instanceof TileEntityBasicDecontaminationUnit) {
			if (fakeBlockCount > 0) {
				((TileEntityBasicDecontaminationUnit) tileAt).onDestroy(tileAt);
			}
		}

		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public EnumSortCategoryBlock getCategory(int meta) {
		return EnumSortCategoryBlock.MACHINE;
	}
}
