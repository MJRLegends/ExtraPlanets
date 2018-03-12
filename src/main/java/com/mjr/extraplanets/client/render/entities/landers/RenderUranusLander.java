package com.mjr.extraplanets.client.render.entities.landers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IFlexibleBakedModel;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.google.common.collect.ImmutableList;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.entities.landers.EntityUranusLander;
import com.mjr.mjrlegendslib.util.ModelUtilities;

@SideOnly(Side.CLIENT)
public class RenderUranusLander extends Render<EntityUranusLander> {
	private IFlexibleBakedModel landerModel;

	public RenderUranusLander(RenderManager manager) {
		super(manager);
		this.shadowSize = 3F;
	}

	private void updateModels() {
		if (landerModel == null) {
			try {
				landerModel = ModelUtilities.modelFromOBJForge(new ResourceLocation(Constants.ASSET_PREFIX, "uranus_lander.obj"), ImmutableList.of("Capsule001", "OneLeg", "TwoLeg", "ThreeLeg", "FourLeg"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityUranusLander par1Entity) {
		return TextureMap.locationBlocksTexture;
	}

	@Override
	public void doRender(EntityUranusLander lander, double x, double y, double z, float entityYaw, float partialTicks) {
		float pitch = lander.prevRotationPitch + (lander.rotationPitch - lander.prevRotationPitch) * partialTicks;
		GlStateManager.disableRescaleNormal();
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x - 0.20, (float) y + 1.25F, (float) z - 0.20);
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
		this.bindTexture(TextureMap.locationBlocksTexture);

		if (Minecraft.isAmbientOcclusionEnabled()) {
			GlStateManager.shadeModel(GL11.GL_SMOOTH);
		} else {
			GlStateManager.shadeModel(GL11.GL_FLAT);
		}

		ModelUtilities.drawBakedModel(this.landerModel);

		GlStateManager.popMatrix();
	}

	@Override
	public boolean shouldRender(EntityUranusLander lander, ICamera camera, double camX, double camY, double camZ) {
		AxisAlignedBB axisalignedbb = lander.getEntityBoundingBox().expand(2D, 1D, 2D);
		return lander.isInRangeToRender3d(camX, camY, camZ) && camera.isBoundingBoxInFrustum(axisalignedbb);
	}
}