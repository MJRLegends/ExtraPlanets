package com.mjr.extraplanets.jei.densifier;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.fluid.ExtraPlanets_Fluids;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class DensifierRecipeMaker {
	public static List<DensifierRecipeWrapper> getRecipesList() {
		List<DensifierRecipeWrapper> recipes = new ArrayList<>();
		List<ItemStack> inputs = new ArrayList<>();
		inputs.add(FluidUtil.getFilledBucket(new FluidStack(ExtraPlanets_Fluids.LIQUID_CARAMEL_FLUID, 0)));
		DensifierRecipeWrapper wrapper = new DensifierRecipeWrapper(inputs, new ItemStack(ExtraPlanets_Items.CARAMEL_BAR, 6, 0));
		recipes.add(wrapper);

		inputs = new ArrayList<>();
		inputs.add(FluidUtil.getFilledBucket(new FluidStack(ExtraPlanets_Fluids.LIQUID_CHOCOLATE_FLUID, 0)));
		wrapper = new DensifierRecipeWrapper(inputs, new ItemStack(ExtraPlanets_Items.CHOCOLATE_BAR, 6, 0));
		recipes.add(wrapper);

		inputs = new ArrayList<>();
		inputs.add(FluidUtil.getFilledBucket(new FluidStack(ExtraPlanets_Fluids.NITROGEN_ICE_FLUID, 0)));
		wrapper = new DensifierRecipeWrapper(inputs, new ItemStack(Blocks.ICE, 6, 0));
		recipes.add(wrapper);

		inputs = new ArrayList<>();
		inputs.add(FluidUtil.getFilledBucket(new FluidStack(ExtraPlanets_Fluids.GLOWSTONE_FLUID, 0)));
		wrapper = new DensifierRecipeWrapper(inputs, new ItemStack(Blocks.GLOWSTONE, 1, 0));
		recipes.add(wrapper);

		inputs = new ArrayList<>();
		inputs.add(FluidUtil.getFilledBucket(new FluidStack(ExtraPlanets_Fluids.NITROGEN_FLUID, 0)));
		wrapper = new DensifierRecipeWrapper(inputs, new ItemStack(ExtraPlanets_Blocks.FROZEN_NITROGEN, 2, 0));
		recipes.add(wrapper);

		inputs = new ArrayList<>();
		inputs.add(FluidUtil.getFilledBucket(new FluidStack(ExtraPlanets_Fluids.FROZEN_WATER_FLUID, 0)));
		wrapper = new DensifierRecipeWrapper(inputs, new ItemStack(Blocks.ICE, 3, 0));
		recipes.add(wrapper);

		inputs = new ArrayList<>();
		inputs.add(FluidUtil.getFilledBucket(new FluidStack(ExtraPlanets_Fluids.LIQUID_HYDROCARBON_FLUID, 0)));
		wrapper = new DensifierRecipeWrapper(inputs, new ItemStack(Items.COAL, 3, 0));
		recipes.add(wrapper);
		return recipes;
	}
}
