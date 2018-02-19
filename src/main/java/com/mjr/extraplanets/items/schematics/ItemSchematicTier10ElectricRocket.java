package com.mjr.extraplanets.items.schematics;

import java.util.List;

import micdoodle8.mods.galacticraft.api.recipe.ISchematicItem;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.core.entities.EntityHangingSchematic;
import micdoodle8.mods.galacticraft.core.items.ISortableItem;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.util.EnumColor;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemHangingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.items.ExtraPlanets_Items;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class ItemSchematicTier10ElectricRocket extends ItemHangingEntity implements ISchematicItem, ISortableItem {
	private static int indexOffset = 0;

	public ItemSchematicTier10ElectricRocket(String assetName) {
		super(EntityHangingSchematic.class);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setMaxStackSize(1);
		this.setUnlocalizedName(assetName);
		this.setCreativeTab(ExtraPlanets.ItemsTab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return ClientProxyCore.galacticraftItem;
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> list, boolean par4) {
		if (player.worldObj.isRemote) {
			list.add(EnumColor.GREY + TranslateUtilities.translate("schematic.tier10.electric.rocket.name"));
		}
	}

	@Override
	public EnumSortCategoryItem getCategory(int meta) {
		return EnumSortCategoryItem.SCHEMATIC;
	}

	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		BlockPos blockpos = pos.offset(facing);

		if (facing != EnumFacing.DOWN && facing != EnumFacing.UP && playerIn.canPlayerEdit(blockpos, facing, stack)) {
			EntityHangingSchematic entityhanging = this.createEntity(worldIn, blockpos, facing, this.getIndex(stack.getItemDamage()));

			if (entityhanging != null && entityhanging.onValidSurface()) {
				if (!worldIn.isRemote) {
					worldIn.spawnEntityInWorld(entityhanging);
					entityhanging.sendToClient(worldIn, blockpos);
				}

				--stack.stackSize;
			}

			return EnumActionResult.SUCCESS;
		} else {
			return EnumActionResult.FAIL;
		}
	}

	private EntityHangingSchematic createEntity(World worldIn, BlockPos pos, EnumFacing clickedSide, int index) {
		return new EntityHangingSchematic(worldIn, pos, clickedSide, index);
	}

	/**
	 * Higher tiers should use this form and make sure they have set up the indexOffset correctly in registerSchematicItems()
	 */
	protected int getIndex(int damage) {
		return damage + indexOffset;
	}

	/**
	 * Make sure the number of these will match the index values
	 */
	public static void registerSchematicItems() {
		indexOffset = SchematicRegistry.registerSchematicItem(new ItemStack(ExtraPlanets_Items.TIER_10_ELECTRIC_ROCKET_SCHEMATIC));
	}

	/**
	 * Make sure the order of these will match the index values
	 */
	@SideOnly(value = Side.CLIENT)
	public static void registerTextures() {
		SchematicRegistry.registerTexture(new ResourceLocation(Constants.ASSET_PREFIX, "textures/items/tier10_schematic_electric_rocket.png"));
	}
}
