package com.mjr.extraplanets.jei.densifier;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fluids.UniversalBucket;

import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class DensifierRecipeMaker {
	public static List<DensifierRecipeWrapper> getRecipesList() {
		List<DensifierRecipeWrapper> recipes = new ArrayList<>();
		List<ItemStack> inputs = new ArrayList<>();
		inputs.add(UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, ExtraPlanets_Fluids.LIQUID_CARAMEL_FLUID));
		DensifierRecipeWrapper wrapper = new DensifierRecipeWrapper(inputs, new ItemStack(ExtraPlanets_Items.CARAMEL_BAR, 6, 0));
		recipes.add(wrapper);
		
		inputs = new ArrayList<>();
		inputs.add(UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, ExtraPlanets_Fluids.LIQUID_CHOCOLATE_FLUID));
		wrapper = new DensifierRecipeWrapper(inputs, new ItemStack(ExtraPlanets_Items.CHOCOLATE_BAR, 6, 0));
		recipes.add(wrapper);
		
		inputs = new ArrayList<>();
		inputs.add(UniversalBucket.getFilledBucket(ForgeModContainer.getInstance().universalBucket, ExtraPlanets_Fluids.NITROGEN_ICE_FLUID));
		wrapper = new DensifierRecipeWrapper(inputs, new ItemStack(Blocks.ICE, 6, 0));
		recipes.add(wrapper);
		return recipes;
	}
}
