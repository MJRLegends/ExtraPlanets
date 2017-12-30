package com.mjr.extraplanets.blocks.machines;

import micdoodle8.mods.galacticraft.core.blocks.BlockTileGC;
import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.items.IShiftDescription;
import micdoodle8.mods.galacticraft.core.tile.IMultiBlock;
import micdoodle8.mods.galacticraft.core.util.EnumColor;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.galacticraft.planets.asteroids.blocks.AsteroidBlocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.tileEntities.machines.TileEntityBasicDecontaminationUnit;

public class BasicDecontaminationUnit extends BlockTileGC implements IShiftDescription, ISortableBlock {
	protected static final AxisAlignedBB AABB_UNIT = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.45F, 1.0F);

	protected BasicDecontaminationUnit(String assetName) {
		super(Material.IRON);
		this.blockHardness = 3.0F;
		this.setUnlocalizedName(assetName);
		this.setSoundType(SoundType.METAL);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ExtraPlanets.BlocksTab;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.INVISIBLE;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBasicDecontaminationUnit();
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return AABB_UNIT;
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

						if (!stateAt.getMaterial().isReplaceable()) {
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
					((EntityPlayer) placer).addChatMessage(new TextComponentString(EnumColor.RED + GCCoreUtil.translate("gui.warning.noroom")));
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
	public boolean onMachineActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
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
	public String getShiftDescription(int meta) {
		return GCCoreUtil.translate(this.getUnlocalizedName() + ".description");
	}

	@Override
	public boolean showDescription(int meta) {
		return true;
	}

	@Override
	public EnumSortCategoryBlock getCategory(int meta) {
		return EnumSortCategoryBlock.MACHINE;
	}
}
