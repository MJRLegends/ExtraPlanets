package com.mjr.extraplanets.planets.Jupiter;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.IRenderHandler;

public class CloudRenderJupiter extends IRenderHandler {
	private static final ResourceLocation CLOUDS_TEXTURES = new ResourceLocation("textures/environment/clouds.png");
	public static int cloudTickCounter = 0;

	@Override
	public void render(float partialTicks, WorldClient world, Minecraft mc) {
		GlStateManager.disableCull();
		Entity entity = mc.getRenderViewEntity();
		float f = (float) (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double) partialTicks);
		Tessellator tessellator = Tessellator.getInstance();
		VertexBuffer vertexbuffer = tessellator.getBuffer();
		double d0 = (double) ((float) CloudRenderJupiter.cloudTickCounter + partialTicks);
		double d1 = (entity.prevPosX + (entity.posX - entity.prevPosX) * (double) partialTicks + d0 * 0.029999999329447746D) / 12.0D;
		double d2 = (entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double) partialTicks) / 12.0D + 0.33000001311302185D;
		float f3 = world.provider.getCloudHeight() - 25 - f + 0.33F;
		int i = MathHelper.floor(d1 / 2048.0D);
		int j = MathHelper.floor(d2 / 2048.0D);
		d1 = d1 - (double) (i * 2048);
		d2 = d2 - (double) (j * 2048);
		mc.renderEngine.bindTexture(CLOUDS_TEXTURES);
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		Vec3d vec3d = new Vec3d(0, 0, 0);
		float f4 = (float) vec3d.xCoord + 71;
		float f5 = (float) vec3d.yCoord + 140;
		float f6 = (float) vec3d.zCoord + 170;

		float f26 = f4 * 0.9F;
		float f27 = f5 * 0.9F;
		float f28 = f6 * 0.9F;
		float f10 = f4 * 0.7F;
		float f11 = f5 * 0.7F;
		float f12 = f6 * 0.7F;
		float f13 = f4 * 0.8F;
		float f14 = f5 * 0.8F;
		float f15 = f6 * 0.8F;
		float f17 = (float) MathHelper.floor(d1) * 0.00390625F;
		float f18 = (float) MathHelper.floor(d2) * 0.00390625F;
		float f19 = (float) (d1 - (double) MathHelper.floor(d1));
		float f20 = (float) (d2 - (double) MathHelper.floor(d2));
		GlStateManager.scale(12.0F, 1.0F, 12.0F);

		for (int i1 = 0; i1 < 2; ++i1) {
			if (i1 == 0) {
				GlStateManager.colorMask(false, false, false, false);
			} else {
				switch (2) {
				case 0:
					GlStateManager.colorMask(false, true, true, true);
					break;
				case 1:
					GlStateManager.colorMask(true, false, false, true);
					break;
				case 2:
					GlStateManager.colorMask(true, true, true, true);
				}
			}

			for (int j1 = -3; j1 <= 4; ++j1) {
				for (int k1 = -3; k1 <= 4; ++k1) {
					vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL);
					float f22 = (float) (j1 * 8);
					float f23 = (float) (k1 * 8);
					float f24 = f22 - f19;
					float f25 = f23 - f20;

					if (f3 > -5.0F) {
						vertexbuffer.pos((double) (f24 + 0.0F), (double) (f3 + 0.0F), (double) (f25 + 8.0F)).tex((double) ((f22 + 0.0F) * 0.00390625F + f17), (double) ((f23 + 8.0F) * 0.00390625F + f18)).color(f10, f11, f12, 0.555F)
								.normal(0.0F, -1.0F, 0.0F).endVertex();
						vertexbuffer.pos((double) (f24 + 8.0F), (double) (f3 + 0.0F), (double) (f25 + 8.0F)).tex((double) ((f22 + 8.0F) * 0.00390625F + f17), (double) ((f23 + 8.0F) * 0.00390625F + f18)).color(f10, f11, f12, 0.555F)
								.normal(0.0F, -1.0F, 0.0F).endVertex();
						vertexbuffer.pos((double) (f24 + 8.0F), (double) (f3 + 0.0F), (double) (f25 + 0.0F)).tex((double) ((f22 + 8.0F) * 0.00390625F + f17), (double) ((f23 + 0.0F) * 0.00390625F + f18)).color(f10, f11, f12, 0.555F)
								.normal(0.0F, -1.0F, 0.0F).endVertex();
						vertexbuffer.pos((double) (f24 + 0.0F), (double) (f3 + 0.0F), (double) (f25 + 0.0F)).tex((double) ((f22 + 0.0F) * 0.00390625F + f17), (double) ((f23 + 0.0F) * 0.00390625F + f18)).color(f10, f11, f12, 0.555F)
								.normal(0.0F, -1.0F, 0.0F).endVertex();
					}

					if (f3 <= 5.0F) {
						vertexbuffer.pos((double) (f24 + 0.0F), (double) (f3 + 7.0F - 9.765625E-4F), (double) (f25 + 8.0F)).tex((double) ((f22 + 0.0F) * 0.00390625F + f17), (double) ((f23 + 8.0F) * 0.00390625F + f18)).color(f4, f5, f6, 0.555F)
								.normal(0.0F, 1.0F, 0.0F).endVertex();
						vertexbuffer.pos((double) (f24 + 8.0F), (double) (f3 + 7.0F - 9.765625E-4F), (double) (f25 + 8.0F)).tex((double) ((f22 + 8.0F) * 0.00390625F + f17), (double) ((f23 + 8.0F) * 0.00390625F + f18)).color(f4, f5, f6, 0.555F)
								.normal(0.0F, 1.0F, 0.0F).endVertex();
						vertexbuffer.pos((double) (f24 + 8.0F), (double) (f3 + 7.0F - 9.765625E-4F), (double) (f25 + 0.0F)).tex((double) ((f22 + 8.0F) * 0.00390625F + f17), (double) ((f23 + 0.0F) * 0.00390625F + f18)).color(f4, f5, f6, 0.555F)
								.normal(0.0F, 1.0F, 0.0F).endVertex();
						vertexbuffer.pos((double) (f24 + 0.0F), (double) (f3 + 7.0F - 9.765625E-4F), (double) (f25 + 0.0F)).tex((double) ((f22 + 0.0F) * 0.00390625F + f17), (double) ((f23 + 0.0F) * 0.00390625F + f18)).color(f4, f5, f6, 0.555F)
								.normal(0.0F, 1.0F, 0.0F).endVertex();
					}

					if (j1 > -1) {
						for (int l1 = 0; l1 < 8; ++l1) {
							vertexbuffer.pos((double) (f24 + (float) l1 + 0.0F), (double) (f3 + 0.0F), (double) (f25 + 8.0F)).tex((double) ((f22 + (float) l1 + 0.5F) * 0.00390625F + f17), (double) ((f23 + 8.0F) * 0.00390625F + f18))
									.color(f26, f27, f28, 0.555F).normal(-1.0F, 0.0F, 0.0F).endVertex();
							vertexbuffer.pos((double) (f24 + (float) l1 + 0.0F), (double) (f3 + 7.0F), (double) (f25 + 8.0F)).tex((double) ((f22 + (float) l1 + 0.5F) * 0.00390625F + f17), (double) ((f23 + 8.0F) * 0.00390625F + f18))
									.color(f26, f27, f28, 0.555F).normal(-1.0F, 0.0F, 0.0F).endVertex();
							vertexbuffer.pos((double) (f24 + (float) l1 + 0.0F), (double) (f3 + 7.0F), (double) (f25 + 0.0F)).tex((double) ((f22 + (float) l1 + 0.5F) * 0.00390625F + f17), (double) ((f23 + 0.0F) * 0.00390625F + f18))
									.color(f26, f27, f28, 0.555F).normal(-1.0F, 0.0F, 0.0F).endVertex();
							vertexbuffer.pos((double) (f24 + (float) l1 + 0.0F), (double) (f3 + 0.0F), (double) (f25 + 0.0F)).tex((double) ((f22 + (float) l1 + 0.5F) * 0.00390625F + f17), (double) ((f23 + 0.0F) * 0.00390625F + f18))
									.color(f26, f27, f28, 0.555F).normal(-1.0F, 0.0F, 0.0F).endVertex();
						}
					}

					if (j1 <= 1) {
						for (int i2 = 0; i2 < 8; ++i2) {
							vertexbuffer.pos((double) (f24 + (float) i2 + 1.0F - 9.765625E-4F), (double) (f3 + 0.0F), (double) (f25 + 8.0F)).tex((double) ((f22 + (float) i2 + 0.5F) * 0.00390625F + f17), (double) ((f23 + 8.0F) * 0.00390625F + f18))
									.color(f26, f27, f28, 0.555F).normal(1.0F, 0.0F, 0.0F).endVertex();
							vertexbuffer.pos((double) (f24 + (float) i2 + 1.0F - 9.765625E-4F), (double) (f3 + 7.0F), (double) (f25 + 8.0F)).tex((double) ((f22 + (float) i2 + 0.5F) * 0.00390625F + f17), (double) ((f23 + 8.0F) * 0.00390625F + f18))
									.color(f26, f27, f28, 0.555F).normal(1.0F, 0.0F, 0.0F).endVertex();
							vertexbuffer.pos((double) (f24 + (float) i2 + 1.0F - 9.765625E-4F), (double) (f3 + 7.0F), (double) (f25 + 0.0F)).tex((double) ((f22 + (float) i2 + 0.5F) * 0.00390625F + f17), (double) ((f23 + 0.0F) * 0.00390625F + f18))
									.color(f26, f27, f28, 0.555F).normal(1.0F, 0.0F, 0.0F).endVertex();
							vertexbuffer.pos((double) (f24 + (float) i2 + 1.0F - 9.765625E-4F), (double) (f3 + 0.0F), (double) (f25 + 0.0F)).tex((double) ((f22 + (float) i2 + 0.5F) * 0.00390625F + f17), (double) ((f23 + 0.0F) * 0.00390625F + f18))
									.color(f26, f27, f28, 0.555F).normal(1.0F, 0.0F, 0.0F).endVertex();
						}
					}

					if (k1 > -1) {
						for (int j2 = 0; j2 < 8; ++j2) {
							vertexbuffer.pos((double) (f24 + 0.0F), (double) (f3 + 7.0F), (double) (f25 + (float) j2 + 0.0F)).tex((double) ((f22 + 0.0F) * 0.00390625F + f17), (double) ((f23 + (float) j2 + 0.5F) * 0.00390625F + f18))
									.color(f13, f14, f15, 0.555F).normal(0.0F, 0.0F, -1.0F).endVertex();
							vertexbuffer.pos((double) (f24 + 8.0F), (double) (f3 + 7.0F), (double) (f25 + (float) j2 + 0.0F)).tex((double) ((f22 + 8.0F) * 0.00390625F + f17), (double) ((f23 + (float) j2 + 0.5F) * 0.00390625F + f18))
									.color(f13, f14, f15, 0.555F).normal(0.0F, 0.0F, -1.0F).endVertex();
							vertexbuffer.pos((double) (f24 + 8.0F), (double) (f3 + 0.0F), (double) (f25 + (float) j2 + 0.0F)).tex((double) ((f22 + 8.0F) * 0.00390625F + f17), (double) ((f23 + (float) j2 + 0.5F) * 0.00390625F + f18))
									.color(f13, f14, f15, 0.555F).normal(0.0F, 0.0F, -1.0F).endVertex();
							vertexbuffer.pos((double) (f24 + 0.0F), (double) (f3 + 0.0F), (double) (f25 + (float) j2 + 0.0F)).tex((double) ((f22 + 0.0F) * 0.00390625F + f17), (double) ((f23 + (float) j2 + 0.5F) * 0.00390625F + f18))
									.color(f13, f14, f15, 0.555F).normal(0.0F, 0.0F, -1.0F).endVertex();
						}
					}

					if (k1 <= 1) {
						for (int k2 = 0; k2 < 8; ++k2) {
							vertexbuffer.pos((double) (f24 + 0.0F), (double) (f3 + 7.0F), (double) (f25 + (float) k2 + 1.0F - 9.765625E-4F)).tex((double) ((f22 + 0.0F) * 0.00390625F + f17), (double) ((f23 + (float) k2 + 0.5F) * 0.00390625F + f18))
									.color(f13, f14, f15, 0.555F).normal(0.0F, 0.0F, 1.0F).endVertex();
							vertexbuffer.pos((double) (f24 + 8.0F), (double) (f3 + 7.0F), (double) (f25 + (float) k2 + 1.0F - 9.765625E-4F)).tex((double) ((f22 + 8.0F) * 0.00390625F + f17), (double) ((f23 + (float) k2 + 0.5F) * 0.00390625F + f18))
									.color(f13, f14, f15, 0.555F).normal(0.0F, 0.0F, 1.0F).endVertex();
							vertexbuffer.pos((double) (f24 + 8.0F), (double) (f3 + 0.0F), (double) (f25 + (float) k2 + 1.0F - 9.765625E-4F)).tex((double) ((f22 + 8.0F) * 0.00390625F + f17), (double) ((f23 + (float) k2 + 0.5F) * 0.00390625F + f18))
									.color(f13, f14, f15, 0.555F).normal(0.0F, 0.0F, 1.0F).endVertex();
							vertexbuffer.pos((double) (f24 + 0.0F), (double) (f3 + 0.0F), (double) (f25 + (float) k2 + 1.0F - 9.765625E-4F)).tex((double) ((f22 + 0.0F) * 0.00390625F + f17), (double) ((f23 + (float) k2 + 0.5F) * 0.00390625F + f18))
									.color(f13, f14, f15, 0.555F).normal(0.0F, 0.0F, 1.0F).endVertex();
						}
					}

					tessellator.draw();
				}
			}
		}

		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.disableBlend();
		GlStateManager.enableCull();
	}
}
