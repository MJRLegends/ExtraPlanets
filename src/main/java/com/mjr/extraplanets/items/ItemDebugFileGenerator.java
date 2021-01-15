package com.mjr.extraplanets.items;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Nullable;

import com.mjr.mjrlegendslib.item.BasicItem;

import micdoodle8.mods.galacticraft.core.util.EnumColor;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDebugFileGenerator extends BasicItem {

	public ItemDebugFileGenerator(String name) {
		super(name);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if (!world.isRemote) {
			ItemStack itemStack = player.getHeldItem(hand);
			if (player.isSneaking()) {
				NBTTagCompound nbt = itemStack.getTagCompound();
				player.sendMessage(new TextComponentString(EnumColor.DARK_GREEN + "Attempting to Generating code!"));

				if (nbt != null) {
					if (nbt.hasKey("pos1x")) {
						if (nbt.hasKey("pos2x")) {
							try {
								BlockPos pos1 = new BlockPos(nbt.getInteger("pos1x"), nbt.getInteger("pos1y"), nbt.getInteger("pos1z"));
								BlockPos pos2 = new BlockPos(nbt.getInteger("pos2x"), nbt.getInteger("pos2y"), nbt.getInteger("pos2z"));

								int minX = Math.min(pos1.getX(), pos2.getX());
								int minY = Math.min(pos1.getY(), pos2.getY());
								int minZ = Math.min(pos1.getZ(), pos2.getZ());
								int maxX = Math.max(pos1.getX(), pos2.getX());
								int maxY = Math.max(pos1.getY(), pos2.getY());
								int maxZ = Math.max(pos1.getZ(), pos2.getZ());

								File file = new File(FMLCommonHandler.instance().getSavesDirectory().getParent() + "\\ExtraPlanets-Exports\\");
								if (file.mkdir()) {
									System.out.println("Folder created: " + file.getName());
								} else {
									System.out.println("Folder already exists. " + file.getName());
								}

								FileWriter writer = new FileWriter(FMLCommonHandler.instance().getSavesDirectory().getParent() + "/ExtraPlanets-Exports/" + "export-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + ".txt");

								for (int x = minX; x <= maxX; x++) {
									for (int y = minY; y <= maxY; y++) {
										for (int z = minZ; z <= maxZ; z++) {
											IBlockState state = world.getBlockState(new BlockPos(x, y, z));
											writer.append("world.setBlockState(new BlockPos(" + x + ", " + y + ", " + z + "), " + state.toString() + ", 3);");
											writer.append("\n");

										}
									}
								}
								writer.close();
							} catch (Exception e) {
								e.printStackTrace();
							}
						} else
							player.sendMessage(new TextComponentString(EnumColor.DARK_RED + "Position 2 must be set!"));
					} else
						player.sendMessage(new TextComponentString(EnumColor.DARK_RED + "Position 1 must be set!"));
				} else
					player.sendMessage(new TextComponentString(EnumColor.DARK_RED + "Position 1 & 2 must be set!"));
			}
		}

		return super.onItemRightClick(world, player, hand);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			ItemStack itemStack = player.getHeldItem(hand);
			if (player.isSneaking() == false) {
				NBTTagCompound nbt;
				if (itemStack.hasTagCompound())
					nbt = itemStack.getTagCompound();
				else
					nbt = new NBTTagCompound();
				nbt.setInteger("pos2x", pos.getX());
				nbt.setInteger("pos2y", pos.getY());
				nbt.setInteger("pos2z", pos.getZ());
				itemStack.setTagCompound(nbt);
				player.sendMessage(new TextComponentString(EnumColor.DARK_AQUA + "Position 2 has been Set!"));
			}
		}
		return EnumActionResult.PASS;
	}

	@Override
	public boolean onBlockStartBreak(ItemStack itemStack, BlockPos pos, EntityPlayer player) {
		if (!player.world.isRemote) {
			if (player.isSneaking() == false) {
				NBTTagCompound nbt;
				if (itemStack.hasTagCompound())
					nbt = itemStack.getTagCompound();
				else
					nbt = new NBTTagCompound();
				nbt.setInteger("pos1x", pos.getX());
				nbt.setInteger("pos1y", pos.getY());
				nbt.setInteger("pos1z", pos.getZ());
				itemStack.setTagCompound(nbt);
				player.sendMessage(new TextComponentString(EnumColor.DARK_AQUA + "Position 1 has been Set!"));
			} else {
				itemStack.setTagCompound(new NBTTagCompound());
				player.sendMessage(new TextComponentString(EnumColor.DARK_GREEN + "Position 1 & 2 has been cleared!"));

			}
		}
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, @Nullable World world, List<String> list, ITooltipFlag flagIn) {
		list.add(EnumColor.YELLOW + "----------Controls----------");
		list.add(EnumColor.DARK_AQUA + "Left Click on Block - Set Pos 1");
		list.add(EnumColor.DARK_AQUA + "Right Click on Block - Set Pos 2");
		list.add(EnumColor.DARK_RED + "Shift Left Click on Block - Clear Pos 1 & 2");
		list.add(EnumColor.DARK_GREEN + "Right Click - Generate Export Text File");
	}

}
