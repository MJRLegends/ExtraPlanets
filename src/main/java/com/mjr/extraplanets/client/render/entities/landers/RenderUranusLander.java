package com.mjr.extraplanets.client.render.entities.landers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJModel;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.entities.landers.EntityUranusLander;
import com.mjr.mjrlegendslib.util.MCUtilities;
import com.mjr.mjrlegendslib.util.ModelUtilities;

@SideOnly(Side.CLIENT)
public class RenderUranusLander extends Render<EntityUranusLander> {
	private OBJModel.OBJBakedModel landerModel;

	public RenderUranusLander(RenderManager manager) {
		super(manager);
		this.shadowSize = 3F;
	}

	private void updateModels() {
		if (landerModel == null) {
			OBJModel model;
			try {
				model = (OBJModel) ModelLoaderRegistry.getModel(new ResourceLocation(Constants.ASSET_PREFIX, "uranus_lander.obj"));
				model = (OBJModel) model.process(ImmutableMap.of("flip-v", "true"));
				Function<ResourceLocation, TextureAtlasSprite> spriteFunction = location -> MCUtilities.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());

				landerModel = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("Capsule001", "OneLeg", "TwoLeg", "ThreeLeg", "FourLeg"), false), DefaultVertexFormats.ITEM, spriteFunction);

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
}