package com.mjr.extraplanets.client.render.entities.bosses;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.client.model.bosses.ModelEvolvedSnowmanBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedSnowmanBoss;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEvolvedSnowmanBoss extends RenderLiving {
	private static final ResourceLocation snowManTextures = new ResourceLocation("textures/entity/snowman.png");

	public RenderEvolvedSnowmanBoss() {
		super(new ModelEvolvedSnowmanBoss(), 0.5F);
	}

	protected void preRenderCallback(EntityEvolvedSnowmanBoss p_77041_1_, float p_77041_2_) {
		float f1 = 6F;
		float f2 = 0.1F;
		float f3 = 1.0F / (f2 + 1.0F);
		GL11.glScalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
		this.preRenderCallback((EntityEvolvedSnowmanBoss) p_77041_1_, p_77041_2_);
	}

	protected ResourceLocation getEntityTexture(EntityEvolvedSnowmanBoss p_110775_1_) {
		return snowManTextures;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return this.getEntityTexture((EntityEvolvedSnowmanBoss) p_110775_1_);
	}
}