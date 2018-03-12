package com.mjr.extraplanets.client.render.entities.rockets;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.client.model.rockets.ItemModelRocketElectricRocket;
import com.mjr.extraplanets.entities.rockets.EntityElectricRocket;
import com.mjr.mjrlegendslib.util.ModelUtilities;

@SideOnly(Side.CLIENT)
public class RenderElectricRocket extends Render<EntityElectricRocket> {
	private ItemModelRocketElectricRocket rocketModel;

	public RenderElectricRocket(RenderManager manager) {
		super(manager);
		this.shadowSize = 2F;
	}

	private void updateModel() {
		if (this.rocketModel == null) {
			this.rocketModel = (ItemModelRocketElectricRocket) ModelUtilities.getModelFromRegistry(Constants.TEXTURE_PREFIX, "electric_rocket");
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityElectricRocket par1Entity) {
		return TextureMap.locationBlocksTexture;
	}

	@Override
	public void doRender(EntityElectricRocket entity, double x, double y, double z, float entityYaw, float partialTicks) {
		GlStateManager.disableRescaleNormal();
		GlStateManager.pushMatrix();
		final float pitch = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks + 180;

		GlStateManager.translate((float) x, (float) y - 0.6, (float) z);
		GlStateManager.rotate(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(-pitch, 0.0F, 0.0F, 1.0F);
		GlStateManager.translate(0.0F, entity.getRenderOffsetY(), 0.0F);
		final float var28 = entity.rollAmplitude / 3 - partialTicks;

		if (var28 > 0.0F) {
			final float i = entity.getLaunched() ? (5 - MathHelper.floor_double(entity.timeUntilLaunch / 85)) / 10F : 0.3F;
			GlStateManager.rotate(MathHelper.sin(var28) * var28 * i * partialTicks, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(MathHelper.sin(var28) * var28 * i * partialTicks, 1.0F, 0.0F, 1.0F);
		}

		updateModel();
		this.bindTexture(TextureMap.locationBlocksTexture);

		if (Minecraft.isAmbientOcclusionEnabled()) {
			GlStateManager.shadeModel(GL11.GL_SMOOTH);
		} else {
			GlStateManager.shadeModel(GL11.GL_FLAT);
		}

		GlStateManager.scale(-1.0F, -1.0F, 1.0F);
		GlStateManager.scale(2.2F, 2.2F, 2.2F);

		ModelUtilities.drawBakedModel(this.rocketModel);
		GlStateManager.popMatrix();
	}

	@Override
	public boolean shouldRender(EntityElectricRocket rocket, ICamera camera, double camX, double camY, double camZ) {
		AxisAlignedBB axisalignedbb = rocket.getEntityBoundingBox().expand(0.6D, 0, 0.6D);

		return rocket.isInRangeToRender3d(camX, camY, camZ) && camera.isBoundingBoxInFrustum(axisalignedbb);
	}
}