package com.mjr.extraplanets.jei.purifier;

import javax.annotation.Nonnull;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import micdoodle8.mods.galacticraft.core.util.GCLog;

import com.mjr.extraplanets.jei.RecipeCategories;

public class PurifierRecipeHandler implements IRecipeHandler<PurifierRecipeWrapper>
{
    @Nonnull
    @Override
    public Class<PurifierRecipeWrapper> getRecipeClass()
    {
        return PurifierRecipeWrapper.class;
    }

    @Nonnull
    @Override
    public String getRecipeCategoryUid()
    {
        return RecipeCategories.PURIFIER_ID;
    }

    @Override
    public String getRecipeCategoryUid(PurifierRecipeWrapper recipe)
    {
        return this.getRecipeCategoryUid();
    }

    @Nonnull
    @Override
    public IRecipeWrapper getRecipeWrapper(@Nonnull PurifierRecipeWrapper recipe)
    {
        return recipe;
    }

    @Override
    public boolean isRecipeValid(@Nonnull PurifierRecipeWrapper recipe)
    {
        if (recipe.getInputs().size() != 3)
        {
            GCLog.severe(this.getClass().getSimpleName() + " JEI recipe has wrong number of inputs!");
        }
        if (recipe.getOutputs().size() != 2)
        {
            GCLog.severe(this.getClass().getSimpleName() + " JEI recipe has wrong number of outputs!");
        }
        return true;
    }
}
