package com.mjr.extraplanets.client.render.entities.landers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.google.common.collect.ImmutableList;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.entities.landers.EntityNeptuneLander;
import com.mjr.mjrlegendslib.util.ModelUtilities;

@SideOnly(Side.CLIENT)
public class RenderNeptuneLander extends Render<EntityNeptuneLander> {
	private IBakedModel landerModel;

	public RenderNeptuneLander(RenderManager manager) {
		super(manager);
		this.shadowSize = 3F;
	}

	@SuppressWarnings("deprecation")
	private void updateModels() {
		if (landerModel == null) {
			try {
				landerModel = ModelUtilities.modelFromOBJForge(new ResourceLocation(Constants.ASSET_PREFIX, "neptune_lander.obj"), ImmutableList.of("Body", "Door", "OneLeg", "TwoLeg", "ThreeLeg", "FourLeg"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityNeptuneLander par1Entity) {
		return TextureMap.LOCATION_BLOCKS_TEXTURE;
	}

	@Override
	public void doRender(EntityNeptuneLander lander, double x, double y, double z, float entityYaw, float partialTicks) {
		float pitch = lander.prevRotationPitch + (lander.rotationPitch - lander.prevRotationPitch) * partialTicks;
		GlStateManager.disableRescaleNormal();
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x, (float) y + 2.80F, (float) z + 0.35);
		GlStateManager.scale(0.2F, 0.2F, 0.2F);
		GlStateManager.rotate(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(-pitch, 0.0F, 0.0F, 1.0F);

		float f6 = lander.timeSinceHit - partialTicks;
		float f7 = lander.currentDamage - partialTicks;

		if (f7 < 0.0F) {
			f7 = 0.0F;
		}

		if (f6 > 0.0F) {
			GL11.glRotatef((float) Math.sin(f6) * 0.2F * f6 * f7 / 25.0F, 1.0F, 0.0F, 0.0F);
		}

		this.updateModels();
		this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

		if (Minecraft.isAmbientOcclusionEnabled()) {
			GlStateManager.shadeModel(GL11.GL_SMOOTH);
		} else {
			GlStateManager.shadeModel(GL11.GL_FLAT);
		}

		ModelUtilities.drawBakedModel(this.landerModel);

		GlStateManager.popMatrix();
	}
}