package com.mjr.extraplanets.client.render.entities.rockets;

import micdoodle8.mods.galacticraft.api.prefab.entity.EntitySpaceshipBase;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.util.ClientUtil;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTier7Rocket extends Render
{
	private ResourceLocation rocketTexture;
	private ResourceLocation rocketTexture2;
	private ResourceLocation rocketTexture3;
	private ResourceLocation rocketTexture4;

	protected IModelCustom rocketModelObj;

	public RenderTier7Rocket(IModelCustom spaceshipModel, String textureDomain, String texture) {
		this.rocketModelObj = spaceshipModel;
		this.rocketTexture = new ResourceLocation(textureDomain, "textures/model/" + texture + ".png");
		this.rocketTexture2 = new ResourceLocation(textureDomain, "textures/model/blank_rocket.png");
		this.rocketTexture3 = new ResourceLocation(textureDomain, "textures/model/blank_rocket_grey.png");
		this.rocketTexture4 = new ResourceLocation(textureDomain, "textures/model/blank_rocket_dark_grey.png");

		this.shadowSize = 2F;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.rocketTexture;
	}

	@SuppressWarnings("unused")
	public void renderSpaceship(EntitySpaceshipBase entity, double par2, double par4, double par6, float par8, float par9)
	{
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPushMatrix();
		final float var24 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * par9 + 180;
		final float var25 = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * par9 + 45;

		GL11.glTranslatef((float) par2, (float) par4 - 1.6F, (float) par6);
		GL11.glRotatef(180.0F - par8, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-var24, 0.0F, 0.0F, 1.0F);
		final float var28 = entity.rollAmplitude / 3 - par9;
		float var30 = entity.shipDamage - par9;

		if (var30 < 0.0F)
		{
			var30 = 0.0F;
		}

		if (var28 > 0.0F)
		{
			final float i = entity.getLaunched() ? (5 - MathHelper.floor_double(entity.timeUntilLaunch / 85)) / 10F : 0.3F;
			GL11.glRotatef(MathHelper.sin(var28) * var28 * i * par9, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(MathHelper.sin(var28) * var28 * i * par9, 1.0F, 0.0F, 1.0F);
		}

		this.bindEntityTexture(entity);
		GL11.glScalef(-1.0F, -1.0F, 1.0F);
		GL11.glScalef(0.9F, 0.9F, 0.9F);

		this.bindTexture(rocketTexture2);
		this.rocketModelObj.renderPart("Nozzle");
		this.bindTexture(rocketTexture);
		this.rocketModelObj.renderPart("Body_Rocket");
		this.bindTexture(rocketTexture4);
		this.rocketModelObj.renderPart("CorrectedWind1");
		this.rocketModelObj.renderPart("CorrectedWind2");
		this.rocketModelObj.renderPart("CorrectedWind3");
		this.rocketModelObj.renderPart("CorrectedWind4");
		this.rocketModelObj.renderPart("Rocket_stabilizer1");
		this.rocketModelObj.renderPart("Rocket_stabilizer2");
		this.rocketModelObj.renderPart("Rocket_stabilizer3");
		this.rocketModelObj.renderPart("Rocket_stabilizer4");
		this.bindTexture(rocketTexture3);
		this.rocketModelObj.renderPart("Tip");
		this.rocketModelObj.renderPart("Ring");
		this.bindTexture(rocketTexture);
		this.rocketModelObj.renderPart("FrameWindow1");
		this.rocketModelObj.renderPart("FrameWindow2");
		this.rocketModelObj.renderPart("FrameWindow3");
		this.rocketModelObj.renderPart("FrameWindow4");
		this.rocketModelObj.renderPart("GlassWindow");
		this.bindTexture(rocketTexture4);
		this.rocketModelObj.renderPart("CorrectedWind005");
		this.rocketModelObj.renderPart("CorrectedWind006");
		this.rocketModelObj.renderPart("CorrectedWind007");
		this.rocketModelObj.renderPart("CorrectedWind008");
		this.rocketModelObj.renderPart("Cylinder001");
		this.rocketModelObj.renderPart("Cylinder002");
		this.rocketModelObj.renderPart("Cylinder003");
		this.rocketModelObj.renderPart("Cylinder004");
		this.rocketModelObj.renderPart("Cylinder005");
		this.rocketModelObj.renderPart("Cylinder006");
//		this.rocketModelObj.renderPart("Cylinder007");
//		this.rocketModelObj.renderPart("Cylinder008");
		this.bindTexture(rocketTexture);
		this.rocketModelObj.renderPart("Helix001");
		this.rocketModelObj.renderPart("SplinePathDeform");
		this.rocketModelObj.renderPart("Pipe004");
		this.rocketModelObj.renderPart("Pipe005");
		this.rocketModelObj.renderPart("Pipe006");
		this.rocketModelObj.renderPart("Pipe007");
		this.bindTexture(rocketTexture2);
		this.rocketModelObj.renderPart("RocketEngine");
		this.rocketModelObj.renderPart("RocketEngine001");
		this.rocketModelObj.renderPart("RocketEngine002");
		this.rocketModelObj.renderPart("RocketEngine003");
		this.bindTexture(rocketTexture);
		this.rocketModelObj.renderPart("RocketEngineBottom");
		this.rocketModelObj.renderPart("RocketEngineBottom001");
		this.rocketModelObj.renderPart("RocketEngineBottom002");
		this.rocketModelObj.renderPart("RocketEngineBottom003");
		this.rocketModelObj.renderPart("PathDeform2");
		this.rocketModelObj.renderPart("Wire1");
		this.rocketModelObj.renderPart("Wire2");
		this.rocketModelObj.renderPart("WireLight");

		Vector3 teamColor = ClientUtil.updateTeamColor(FMLClientHandler.instance().getClient().thePlayer.getCommandSenderName(), true);
		if (teamColor != null)
		{
			GL11.glColor3f(teamColor.floatX(), teamColor.floatY(), teamColor.floatZ());
		}
		this.rocketModelObj.renderPart("RocketEnginePlut");
		this.rocketModelObj.renderPart("RocketEnginePlut001");
		this.rocketModelObj.renderPart("RocketEnginePlut002");
		this.rocketModelObj.renderPart("RocketEnginePlut003");

		if (FMLClientHandler.instance().getClient().thePlayer.ticksExisted / 10 % 2 < 1)
		{
			GL11.glColor3f(1, 0, 0);
		}
		else
		{
			GL11.glColor3f(0, 1, 0);
		}

		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.rocketModelObj.renderPart("Light");
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LIGHTING);

		GL11.glColor3f(1,1,1);

		GL11.glPopMatrix();
	}

	@Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderSpaceship((EntitySpaceshipBase) par1Entity, par2, par4, par6, par8, par9);
	}
}