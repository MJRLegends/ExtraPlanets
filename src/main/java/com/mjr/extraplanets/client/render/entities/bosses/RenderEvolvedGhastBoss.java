package com.mjr.extraplanets.client.render.entities.bosses;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.client.model.bosses.ModelEvolvedGhastBoss;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedGhastBoss;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEvolvedGhastBoss extends RenderLiving
{
    private static final ResourceLocation ghastTextures = new ResourceLocation("textures/entity/ghast/ghast.png");
    private static final ResourceLocation ghastShootingTextures = new ResourceLocation("textures/entity/ghast/ghast_shooting.png");

    public RenderEvolvedGhastBoss()
    {
        super(new ModelEvolvedGhastBoss(), 0.5F);
    }

    protected ResourceLocation getEntityTexture(EntityEvolvedGhastBoss p_110775_1_)
    {
        return p_110775_1_.func_110182_bF() ? ghastShootingTextures : ghastTextures;
    }

    protected void preRenderCallback(EntityEvolvedGhastBoss p_77041_1_, float p_77041_2_)
    {
        float f1 = 10F;
		float f2 = (p_77041_1_.prevAttackCounter + (p_77041_1_.attackCounter - p_77041_1_.prevAttackCounter) * p_77041_2_) / 20.0F;
		float f3 = 1.0F / (f2 + 1.0F);
		GL11.glScalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    @Override
	protected void preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_)
    {
        this.preRenderCallback((EntityEvolvedGhastBoss)p_77041_1_, p_77041_2_);
    }

    @Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityEvolvedGhastBoss)p_110775_1_);
    }
}