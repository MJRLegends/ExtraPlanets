package com.mjr.extraplanets.client.gui.overlay;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.Constants;
import com.mjr.mjrlegendslib.util.MCUtilities;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

import micdoodle8.mods.galacticraft.core.client.gui.overlay.Overlay;
import micdoodle8.mods.galacticraft.core.util.ClientUtil;
import micdoodle8.mods.galacticraft.core.util.ColorUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class OverlaySolarRadiation extends Overlay {
	private final static ResourceLocation guiTexture = new ResourceLocation(Constants.ASSET_PREFIX, "textures/gui/gui.png");

	private static Minecraft minecraft = MCUtilities.getClient();

	public static void renderSolarRadiationIndicator(int radiationLevel, boolean right, boolean top) {
		final ScaledResolution scaledresolution = ClientUtil.getScaledRes(OverlaySolarRadiation.minecraft, OverlaySolarRadiation.minecraft.displayWidth, OverlaySolarRadiation.minecraft.displayHeight);
		final int i = scaledresolution.getScaledWidth();
		final int j = scaledresolution.getScaledHeight();

		GlStateManager.disableAlpha();
		MCUtilities.getClient().renderEngine.bindTexture(OverlaySolarRadiation.guiTexture);
		final Tessellator tessellator = Tessellator.getInstance();
		VertexBuffer worldRenderer = tessellator.getBuffer();
		GlStateManager.enableDepth();
		GlStateManager.enableAlpha();
		GlStateManager.disableLighting();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

		int minLeftX = 0;
		double bottomY = 0;
		double topY = 0;
		double zLevel = -190.0D;

		if (right) {
			minLeftX = i - 46;
		} else {
			minLeftX = 22;
		}

		if (top) {
			topY = 10.5 + 50;
		} else {
			topY = j - 107;
		}

		bottomY = topY + 46.5;

		float texMod = 0.00390625F;
		worldRenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
		worldRenderer.pos(minLeftX, bottomY, zLevel).tex(66 * texMod, 47 * texMod).endVertex();
		worldRenderer.pos(minLeftX + 9 + 5, bottomY, zLevel).tex((66 + 9) * texMod, 47 * texMod).endVertex();
		worldRenderer.pos(minLeftX + 9 + 5, topY, zLevel).tex((66 + 9) * texMod, 47 * 2 * texMod).endVertex();
		worldRenderer.pos(minLeftX, topY, zLevel).tex(66 * texMod, 47 * 2 * texMod).endVertex();
		tessellator.draw();

		int radiationLevelScaled = Math.min(Math.max(radiationLevel / 2, 1), 45);
		int radiationLevelScaledMax = Math.min(radiationLevelScaled + 2, 45);
		int radiationLevelScaledMin = Math.max(radiationLevelScaledMax - 2, 0);

		worldRenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
		worldRenderer.pos(minLeftX + 1, bottomY - radiationLevelScaledMin, zLevel).tex(76 * texMod, (48 + 45 - radiationLevelScaled) * texMod).endVertex();
		worldRenderer.pos(minLeftX + 13, bottomY - radiationLevelScaledMin, zLevel).tex((76 + 7) * texMod, (48 + 45 - radiationLevelScaled) * texMod).endVertex();
		worldRenderer.pos(minLeftX + 13, bottomY - radiationLevelScaledMax, zLevel).tex((76 + 7) * texMod, (48 + 45 - radiationLevelScaled) * texMod).endVertex();
		worldRenderer.pos(minLeftX + 1, bottomY - radiationLevelScaledMax, zLevel).tex(76 * texMod, (48 + 45 - radiationLevelScaled) * texMod).endVertex();
		tessellator.draw();

		String value = "";

		if (Math.abs(radiationLevel) >= 80)
			value = TranslateUtilities.translate("gui.warning.high.radiation");
		else if (Math.abs(radiationLevel) >= 50)
			value = TranslateUtilities.translate("gui.warning.med.radiation");
		else
			value = TranslateUtilities.translate("gui.warning.low.radiation");
		int addX = 0;
		int addY = 0;
		if (top) {
			if (right) {
				addX = Math.abs(radiationLevel) >= 80 ? 40 : 40;
				addY = Math.abs(radiationLevel) >= 80 ? 60 : 30;
				addY = Math.abs(radiationLevel) < 50 ? addY : Math.abs(radiationLevel) >= 80 ? addY + 10 : addY + 20;
			} else {
				addX = Math.abs(radiationLevel) >= 80 ? 150 : 130;
				addX = Math.abs(radiationLevel) >= 50 && Math.abs(radiationLevel) < 80 ? addX - 13 : addX;
				addY = 30;
				addY = Math.abs(radiationLevel) >= 20 && Math.abs(radiationLevel) < 40 ? addY + 10 : Math.abs(radiationLevel) >= 40 && Math.abs(radiationLevel) < 80 ? addY + 20 : addY;
				addY = Math.abs(radiationLevel) >= 60 && Math.abs(radiationLevel) < 80 ? addY + 10 : Math.abs(radiationLevel) >= 80 ? addY + 40 : addY;
				;
			}
		} else {
			if (right) {
				addX = Math.abs(radiationLevel) >= 80 ? 40 : 35;
				addX = Math.abs(radiationLevel) >= 50 && Math.abs(radiationLevel) < 80 ? addX + 3 : addX;
				addY = Math.abs(radiationLevel) >= 80 ? -40 : -40;
				addY = Math.abs(radiationLevel) < 50 ? addY - 10 : Math.abs(radiationLevel) >= 80 ? addY + 10 : addY;
			} else {
				addX = Math.abs(radiationLevel) >= 80 ? 205 : 190;
				addX = Math.abs(radiationLevel) >= 50 && Math.abs(radiationLevel) < 80 ? addX - 15 : addX;
				addY = Math.abs(radiationLevel) >= 80 ? 60 : 50;
				addY = Math.abs(radiationLevel) < 50 ? addY - 10 : Math.abs(radiationLevel) >= 80 ? addY + 10 : Math.abs(radiationLevel) >= 50 && Math.abs(radiationLevel) < 80 ? addY + 10 : addY;
			}
		}
		OverlaySolarRadiation.minecraft.fontRendererObj.drawString(value, minLeftX + addX - OverlaySolarRadiation.minecraft.fontRendererObj.getStringWidth(value),
				(int) bottomY - radiationLevelScaled - OverlaySolarRadiation.minecraft.fontRendererObj.FONT_HEIGHT / 2 + addY, ColorUtil.to32BitColor(255, 255, 10, 10));

		GlStateManager.disableBlend();
	}
}
