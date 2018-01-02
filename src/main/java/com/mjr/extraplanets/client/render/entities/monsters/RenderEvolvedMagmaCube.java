package com.mjr.extraplanets.client.render.entities.monsters;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.client.model.monsters.ModelEvolvedMagmaCube;
import com.mjr.extraplanets.entities.monsters.EntityEvolvedMagmaCube;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEvolvedMagmaCube extends RenderLiving {
	private static final ResourceLocation magmaCubeTextures = new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/entity/slime/magmacube.png");

	public RenderEvolvedMagmaCube() {
		super(new ModelEvolvedMagmaCube(), 0.25F);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntityEvolvedMagmaCube p_110775_1_) {
		return magmaCubeTextures;
	}

	/**
	 * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args: entityLiving, partialTickTime
	 */
	protected void preRenderCallback(EntityEvolvedMagmaCube p_77041_1_, float p_77041_2_) {
		int i = p_77041_1_.getSlimeSize();
		float f1 = (p_77041_1_.prevSquishFactor + (p_77041_1_.squishFactor - p_77041_1_.prevSquishFactor) * p_77041_2_) / (i * 0.5F + 1.0F);
		float f2 = 1.0F / (f1 + 1.0F);
		float f3 = i;
		GL11.glScalef(f2 * f3, 1.0F / f2 * f3, f2 * f3);
	}

	/**
	 * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args: entityLiving, partialTickTime
	 */
	@Override
	protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
		this.preRenderCallback((EntityEvolvedMagmaCube) p_77041_1_, p_77041_2_);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return this.getEntityTexture((EntityEvolvedMagmaCube) p_110775_1_);
	}
}