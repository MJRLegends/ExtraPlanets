package com.mjr.extraplanets.client.render.entities.rockets;

import micdoodle8.mods.galacticraft.core.util.ClientUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.client.model.rockets.ItemModelRocketT8;
import com.mjr.extraplanets.entities.rockets.EntityTier8Rocket;

@SideOnly(Side.CLIENT)
public class RenderTier8Rocket extends Render<EntityTier8Rocket> {
	private ItemModelRocketT8 rocketModel;

	public RenderTier8Rocket(RenderManager manager) {
		super(manager);
		this.shadowSize = 2F;
	}

	private void updateModel() {
		if (this.rocketModel == null) {
			ModelResourceLocation modelResourceLocation = new ModelResourceLocation(Constants.TEXTURE_PREFIX + "rocket_t8", "inventory");
			this.rocketModel = (ItemModelRocketT8) FMLClientHandler.instance().getClient().getRenderItem().getItemModelMesher().getModelManager().getModel(modelResourceLocation);
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityTier8Rocket par1Entity) {
		return TextureMap.LOCATION_BLOCKS_TEXTURE;
	}

	@Override
	public void doRender(EntityTier8Rocket entity, double x, double y, double z, float entityYaw, float partialTicks) {
		GlStateManager.disableRescaleNormal();
		GlStateManager.pushMatrix();
		final float pitch = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks + 180;

		GlStateManager.translate((float) x, (float) y, (float) z);
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
		this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

		if (Minecraft.isAmbientOcclusionEnabled()) {
			GlStateManager.shadeModel(GL11.GL_SMOOTH);
		} else {
			GlStateManager.shadeModel(GL11.GL_FLAT);
		}

		GlStateManager.scale(-1.0F, -1.0F, 1.0F);
		GlStateManager.scale(0.9F, 0.9F, 0.9F);

		ClientUtil.drawBakedModel(this.rocketModel);
		GlStateManager.popMatrix();

		RenderHelper.enableStandardItemLighting();
	}
}