package com.mjr.extraplanets.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.handlers.PlayerRadiationHandler;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class RadiationBarOverlay extends Gui {
	private Minecraft mc;

	public RadiationBarOverlay(Minecraft mc) {
		super();
		this.mc = mc;
	}
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent event) {
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE) {
			return;
		}
		int xPos = 10;
		int yPos = 2;
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		FontRenderer fontRender = this.mc.fontRenderer;
		this.drawRect(xPos-1, yPos-1, xPos + 101, 16, 0xFFFFFFFF);
		this.drawRect(xPos, yPos, xPos + 100, 15, 0xFF000000);
		this.drawRect(xPos, yPos, xPos + PlayerRadiationHandler.getRadiationAmount(), 15, 0xFF0099FF);
		this.drawString(fontRender, PlayerRadiationHandler.getRadiationAmount() + "/100", xPos+ 30, yPos+ 2, 0xFFFFFFFF);
	}
}