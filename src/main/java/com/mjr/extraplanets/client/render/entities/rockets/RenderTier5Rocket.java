package com.mjr.extraplanets.client.render.entities.rockets;

import java.util.List;

import micdoodle8.mods.galacticraft.core.util.ClientUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.model.pipeline.LightUtil;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.client.model.rockets.ItemModelRocketT5;
import com.mjr.extraplanets.entities.rockets.EntityTier5Rocket;

@SideOnly(Side.CLIENT)
public class RenderTier5Rocket extends Render<EntityTier5Rocket> {
	private ItemModelRocketT5 rocketModel;

	public RenderTier5Rocket(RenderManager manager) {
		super(manager);
		this.shadowSize = 2F;
	}

	private void updateModel() {
		if (rocketModel == null) {
			ModelResourceLocation modelResourceLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "rocket_t5", "inventory");
			rocketModel = (ItemModelRocketT5) FMLClientHandler.instance().getClient().getRenderItem().getItemModelMesher().getModelManager().getModel(modelResourceLocation);
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityTier5Rocket par1Entity) {
		return new ResourceLocation("missing");
	}

	@Override
	public void doRender(EntityTier5Rocket entity, double par2, double par4, double par6, float par8, float par9) {
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPushMatrix();
		final float var24 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * par9 + 180;
		final float var25 = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * par9 + 45;

		GL11.glTranslatef((float) par2, (float) par4, (float) par6);
		GL11.glRotatef(180.0F - par8, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-var24, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(0.0F, entity.getRenderOffsetY(), 0.0F);
		final float var28 = entity.rollAmplitude / 3 - par9;

		if (var28 > 0.0F) {
			final float i = entity.getLaunched() ? (5 - MathHelper.floor(entity.timeUntilLaunch / 85)) / 10F : 0.3F;
			GL11.glRotatef(MathHelper.sin(var28) * var28 * i * par9, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(MathHelper.sin(var28) * var28 * i * par9, 1.0F, 0.0F, 1.0F);
		}

		updateModel();

		//RenderHelper.disableStandardItemLighting();
		this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

		if (Minecraft.isAmbientOcclusionEnabled()) {
			GlStateManager.shadeModel(GL11.GL_SMOOTH);
		} else {
			GlStateManager.shadeModel(GL11.GL_FLAT);
		}

		GL11.glScalef(-1.0F, -1.0F, 1.0F);
		GL11.glScalef(0.9F, 0.9F, 0.9F);

		ClientUtil.drawBakedModel(rocketModel);

		// Vector3 teamColor = ClientUtil.updateTeamColor(FMLClientHandler.instance().getClient().thePlayer.getName(), true);
		// if (teamColor != null) {
		// GL11.glColor3f(teamColor.floatX(), teamColor.floatY(), teamColor.floatZ());
		// }
		//
		// if (FMLClientHandler.instance().getClient().thePlayer.ticksExisted / 10 % 2 < 1) {
		// GL11.glColor3f(1, 0, 0);
		// } else {
		// GL11.glColor3f(0, 1, 0);
		// }
		//
		// GL11.glDisable(GL11.GL_TEXTURE_2D);
		// GL11.glDisable(GL11.GL_LIGHTING);
		//
		// GL11.glEnable(GL11.GL_TEXTURE_2D);
		// GL11.glEnable(GL11.GL_LIGHTING);

		GL11.glColor3f(1, 0, 1);

		GL11.glPopMatrix();

		RenderHelper.enableStandardItemLighting();
	}

	private void renderQuads(VertexBuffer renderer, List<BakedQuad> quads, int color) {
		for (BakedQuad bakedquad : quads) {
			LightUtil.renderQuadColor(renderer, bakedquad, color);
		}
	}
}