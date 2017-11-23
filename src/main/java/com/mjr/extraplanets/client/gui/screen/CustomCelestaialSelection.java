package com.mjr.extraplanets.client.gui.screen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.galaxies.Satellite;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.core.client.gui.screen.GuiCelestialSelection;
import micdoodle8.mods.galacticraft.core.util.ColorUtil;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.world.WorldProvider;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.world.CustomWorldProviderSpace;

public class CustomCelestaialSelection extends GuiCelestialSelection {

	public CustomCelestaialSelection(boolean mapMode, List<CelestialBody> possibleBodies, boolean canCreateStations) {
		super(mapMode, possibleBodies, canCreateStations);
	}

	@Override
	public void drawButtons(int mousePosX, int mousePosY) {
		if (this.viewState != EnumView.PROFILE) {
			if (this.selectedBody != null) {
				GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);
				this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain1);
				int yOffset = 35;
				int widthSizeOffset = 75;
				int xOffset = 100 + (GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE);
				this.drawTexturedModalRect(xOffset, yOffset, 93 + widthSizeOffset, 4, 159, 102, 93, 4, false, false);
				for (int barY = 0; barY < 25; ++barY) {
					this.drawTexturedModalRect(xOffset, yOffset + barY * this.fontRendererObj.FONT_HEIGHT + 4, 93 + widthSizeOffset, this.fontRendererObj.FONT_HEIGHT, 159, 106, 93, this.fontRendererObj.FONT_HEIGHT, false, false);
				}
				if (!(this.selectedBody instanceof Star)) {
					WorldProvider temp = null;
					if (this.selectedBody.getReachable() && !this.selectedBody.getName().contains("overworld") && !(this.selectedBody instanceof Satellite))
						temp = (WorldProviderSpace) WorldUtil.getProviderForDimensionClient(this.selectedBody.getDimensionID());
					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 2, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, "General Details: ", xOffset + 10, yOffset + 8, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 14, ColorUtil.to32BitColor(255, 0, 150, 255));
					String type;
					if (GalaxyRegistry.getRegisteredPlanets().containsValue(this.selectedBody))
						type = "Planet";
					else if (GalaxyRegistry.getRegisteredMoons().containsValue(this.selectedBody))
						type = "Moon";
					else if (GalaxyRegistry.getRegisteredSatellites().containsValue(this.selectedBody))
						type = "Satellite";
					else
						type = "Unknown";

					this.drawString(this.fontRendererObj, "Type: " + type, xOffset + 10, yOffset + 23, 14737632);
					if ((this.selectedBody instanceof Planet))
						this.drawString(this.fontRendererObj, "Amount of Moons: " + this.getChildren(this.selectedBody).size(), xOffset + 10, yOffset + 33, 14737632);
					yOffset = yOffset + 45;
					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 2, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, "Celestaial Details: ", xOffset + 10, yOffset + 8, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 14, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, "Orbit Time: " + this.selectedBody.getRelativeOrbitTime() * 24 + " days", xOffset + 10, yOffset + 23, 14737632);
					float gravity = 0;
					long dayLengh = 0;
					if (this.selectedBody.getReachable() && !(this.selectedBody instanceof Satellite) && !this.selectedBody.getName().contains("overworld")) {
						gravity = ((WorldProviderSpace) temp).getGravity();
						dayLengh = ((WorldProviderSpace) temp).getDayLength() / 1000;
					} else if (this.selectedBody.getName().contains("overworld")) {
						gravity = 1;
						dayLengh = 24;
					}
					this.drawString(this.fontRendererObj, "Gravity: " + (this.selectedBody.getReachable() ? gravity : "Unknown"), xOffset + 10, yOffset + 33, 14737632);
					this.drawString(this.fontRendererObj, "Day Lengh: " + (this.selectedBody.getReachable() ? dayLengh + " hours" : "Unknown"), xOffset + 10, yOffset + 43, 14737632);
					yOffset = yOffset + 60;
					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 2, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, "General Feature Details: ", xOffset + 10, yOffset + 8, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 14, ColorUtil.to32BitColor(255, 0, 150, 255));
					double meteorFrequency = 0;
					if (temp != null && !(this.selectedBody instanceof Satellite) && !this.selectedBody.getName().contains("overworld")) {
						double number = ((WorldProviderSpace) temp).getMeteorFrequency();
						BigDecimal bd = new BigDecimal(number).setScale(7, RoundingMode.DOWN);
						meteorFrequency = bd.doubleValue();
					} else {
						meteorFrequency = 0;
					}
					this.drawString(this.fontRendererObj, "Meteor Frequency: " + (this.selectedBody.getReachable() ? meteorFrequency : "Unknown"), xOffset + 10, yOffset + 23, 14737632);

					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 39, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, "Atmosphere Details: ", xOffset + 10, yOffset + 45, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 51, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, "Wind Level: " + (this.selectedBody.getReachable() ? this.selectedBody.atmosphere.windLevel() * 10 + "%" : "Unknown"), xOffset + 10, yOffset + 60, 14737632);
					float temperature = 0;
					if (this.selectedBody.getReachable() && !this.selectedBody.getName().contains("overworld") && !(this.selectedBody instanceof Satellite))
						temperature = ((WorldProviderSpace) temp).getThermalLevelModifier();
					this.drawString(this.fontRendererObj, "Temperature: " + (this.selectedBody.getReachable() ? temperature + " C" : "Unknown"), xOffset + 10, yOffset + 70, 14737632);
					this.drawString(this.fontRendererObj, "Breathable: " + (this.selectedBody.getReachable() ? this.selectedBody.atmosphere.isBreathable() : "Unknown"), xOffset + 10, yOffset + 80, 14737632);
					this.drawString(this.fontRendererObj, "Corrosive Atmosphere: " + (this.selectedBody.getReachable() ? this.selectedBody.atmosphere.isCorrosive() : "Unknown"), xOffset + 10, yOffset + 90, 14737632);
					int radiationLevel = 0;
					int pressureLevel = 0;
					try {
						radiationLevel = ((CustomWorldProviderSpace) temp).getSolarRadiationLevel();
						pressureLevel = ((CustomWorldProviderSpace) temp).getPressureLevel();
					} catch (Exception ex) {
					}

					this.drawString(this.fontRendererObj, "Radiation Level: " + (this.selectedBody.getReachable() ? radiationLevel + "%" : "Unknown"), xOffset + 10, yOffset + 100, 14737632);
					this.drawString(this.fontRendererObj, "Pressure Level: " + (this.selectedBody.getReachable() ? pressureLevel + "%" : "Unknown"), xOffset + 10, yOffset + 110, 14737632);
				} else if (this.selectedBody instanceof Star) {
					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 2, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, "General Details: ", xOffset + 10, yOffset + 8, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 14, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, "Type: " + "Star", xOffset + 10, yOffset + 23, 14737632);
					List<CelestialBody> planets = this.getChildren(((Star) this.selectedBody).getParentSolarSystem());
					int amountofPlanets = planets.size();
					this.drawString(this.fontRendererObj, "Amount of Planets: " + amountofPlanets, xOffset + 10, yOffset + 33, 14737632);

					yOffset = yOffset + 50;

					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 2, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, "Parent Solar System Details: ", xOffset + 10, yOffset + 8, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 14, ColorUtil.to32BitColor(255, 0, 150, 255));

					int amountofMoons = 0;
					for (int i = 0; i < amountofPlanets; i++) {
						amountofMoons += this.getChildren(planets.get(i)).size();
					}
					this.drawString(this.fontRendererObj, "Amount of Moons: " + amountofMoons, xOffset + 10, yOffset + 23, 14737632);
				}
			}
		}
		super.drawButtons(mousePosX, mousePosY);
	}
}
