package com.mjr.extraplanets.client.render.entities.mobs;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.client.model.mobs.ModelEvolvedMagmaCube;
import com.mjr.extraplanets.entities.mobs.EntityEvolvedMagmaCube;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEvolvedMagmaCube extends RenderLiving<EntityEvolvedMagmaCube>
{
	private static final ResourceLocation MAGMA_CUBE_TEXTURES = new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/entity/slime/magmacube.png");

    public RenderEvolvedMagmaCube(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelEvolvedMagmaCube(), 0.25F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityEvolvedMagmaCube entity)
    {
        return MAGMA_CUBE_TEXTURES;
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntityEvolvedMagmaCube entitylivingbaseIn, float partialTickTime)
    {
        int i = entitylivingbaseIn.getSlimeSize();
        float f = (entitylivingbaseIn.prevSquishFactor + (entitylivingbaseIn.squishFactor - entitylivingbaseIn.prevSquishFactor) * partialTickTime) / ((float)i * 0.5F + 1.0F);
        float f1 = 1.0F / (f + 1.0F);
        GlStateManager.scale(f1 * (float)i, 1.0F / f1 * (float)i, f1 * (float)i);
    }
}