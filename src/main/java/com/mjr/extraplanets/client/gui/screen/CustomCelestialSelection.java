package com.mjr.extraplanets.client.gui.screen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.List;

import micdoodle8.mods.galacticraft.api.event.client.CelestialBodyRenderEvent;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.IChildBody;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.galaxies.Satellite;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.core.client.gui.screen.GuiCelestialSelection;
import micdoodle8.mods.galacticraft.core.util.ColorUtil;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import com.google.common.collect.Maps;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class CustomCelestialSelection extends GuiCelestialSelection {

	public CustomCelestialSelection(boolean mapMode, List<CelestialBody> possibleBodies) {
		super(mapMode, possibleBodies);
	}

	@Override
	public HashMap<CelestialBody, Matrix4f> drawCelestialBodies(Matrix4f worldMatrix) {
		GL11.glColor3f(1, 1, 1);
		FloatBuffer fb = BufferUtils.createFloatBuffer(16 * Float.SIZE);
		HashMap<CelestialBody, Matrix4f> matrixMap = Maps.newHashMap();

		for (SolarSystem solarSystem : GalaxyRegistry.getRegisteredSolarSystems().values()) {
			Star star = solarSystem.getMainStar();

			if (star != null && star.getBodyIcon() != null) {
				GL11.glPushMatrix();
				Matrix4f worldMatrix0 = new Matrix4f(worldMatrix);

				Matrix4f.translate(this.getCelestialBodyPosition(star), worldMatrix0, worldMatrix0);

				Matrix4f worldMatrix1 = new Matrix4f();
				Matrix4f.rotate((float) Math.toRadians(45), new Vector3f(0, 0, 1), worldMatrix1, worldMatrix1);
				Matrix4f.rotate((float) Math.toRadians(-55), new Vector3f(1, 0, 0), worldMatrix1, worldMatrix1);
				worldMatrix1 = Matrix4f.mul(worldMatrix0, worldMatrix1, worldMatrix1);

				fb.rewind();
				worldMatrix1.store(fb);
				fb.flip();
				GL11.glMultMatrix(fb);

				float alpha = 1.0F;

				if (this.selectedBody != null && this.selectedBody != star && this.selectionCount >= 2) {
					alpha = 1.0F - Math.min(this.ticksSinceSelection / 25.0F, 1.0F);
				}

				if (this.selectedBody != null && this.selectionCount >= 2) {
					if (star != this.selectedBody) {
						alpha = 1.0F - Math.min(this.ticksSinceSelection / 25.0F, 1.0F);

						if (!(this.lastSelectedBody instanceof Star) && this.lastSelectedBody != null) {
							alpha = 0.0F;
						}
					}
				}

				if (alpha != 0) {
					CelestialBodyRenderEvent.Pre preEvent = new CelestialBodyRenderEvent.Pre(star, star.getBodyIcon(), 8);
					MinecraftForge.EVENT_BUS.post(preEvent);

					GL11.glColor4f(1, 1, 1, alpha);
					if (preEvent.celestialBodyTexture != null) {
						this.mc.renderEngine.bindTexture(preEvent.celestialBodyTexture);
					}

					if (!preEvent.isCanceled()) {
						int size = GuiCelestialSelection.getWidthForCelestialBodyStatic(star);
						if (star == this.selectedBody && this.selectionCount == 1) {
							size /= 2;
							size *= 3;
						}
						this.drawTexturedModalRect(-size / 2, -size / 2, size, size, 0, 0, preEvent.textureSize, preEvent.textureSize, false, false, preEvent.textureSize, preEvent.textureSize);
						matrixMap.put(star, worldMatrix1);
					}

					CelestialBodyRenderEvent.Post postEvent = new CelestialBodyRenderEvent.Post(star);
					MinecraftForge.EVENT_BUS.post(postEvent);
				}

				fb.clear();
				GL11.glPopMatrix();
			}
		}

		for (Planet planet : GalaxyRegistry.getRegisteredPlanets().values()) {
			if (planet.getBodyIcon() != null) {
				GL11.glPushMatrix();
				Matrix4f worldMatrix0 = new Matrix4f(worldMatrix);

				Matrix4f.translate(this.getCelestialBodyPosition(planet), worldMatrix0, worldMatrix0);

				Matrix4f worldMatrix1 = new Matrix4f();
				Matrix4f.rotate((float) Math.toRadians(45), new Vector3f(0, 0, 1), worldMatrix1, worldMatrix1);
				Matrix4f.rotate((float) Math.toRadians(-55), new Vector3f(1, 0, 0), worldMatrix1, worldMatrix1);
				worldMatrix1 = Matrix4f.mul(worldMatrix0, worldMatrix1, worldMatrix1);

				fb.rewind();
				worldMatrix1.store(fb);
				fb.flip();
				GL11.glMultMatrix(fb);

				float alpha = 1.0F;

				if ((this.selectedBody instanceof IChildBody && ((IChildBody) this.selectedBody).getParentPlanet() != planet) || (this.selectedBody instanceof Planet && this.selectedBody != planet && this.selectionCount >= 2)) {
					if (this.lastSelectedBody == null && !(this.selectedBody instanceof IChildBody)) {
						alpha = 1.0F - Math.min(this.ticksSinceSelection / 25.0F, 1.0F);
					} else {
						alpha = 0.0F;
					}
				}

				if (alpha != 0) {
					if (!(this.selectedBody instanceof Planet)) {
						this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain1);
						this.drawCenteredString(this.fontRendererObj, planet.getLocalizedName(), 0, 5, 14737632);
					}
					CelestialBodyRenderEvent.Pre preEvent = new CelestialBodyRenderEvent.Pre(planet, planet.getBodyIcon(), 12);
					MinecraftForge.EVENT_BUS.post(preEvent);

					GL11.glColor4f(1, 1, 1, alpha);
					if (preEvent.celestialBodyTexture != null) {
						this.mc.renderEngine.bindTexture(preEvent.celestialBodyTexture);
					}

					if (!preEvent.isCanceled()) {
						int size = GuiCelestialSelection.getWidthForCelestialBodyStatic(planet);
						this.drawTexturedModalRect(-size / 2, -size / 2, size, size, 0, 0, preEvent.textureSize, preEvent.textureSize, false, false, preEvent.textureSize, preEvent.textureSize);
						matrixMap.put(planet, worldMatrix1);
					}

					CelestialBodyRenderEvent.Post postEvent = new CelestialBodyRenderEvent.Post(planet);
					MinecraftForge.EVENT_BUS.post(postEvent);
				}

				fb.clear();
				GL11.glPopMatrix();
			}
		}

		if (this.selectedBody != null) {
			Matrix4f worldMatrix0 = new Matrix4f(worldMatrix);

			for (Moon moon : GalaxyRegistry.getRegisteredMoons().values()) {
				if ((moon == this.selectedBody || (moon.getParentPlanet() == this.selectedBody && this.selectionCount != 1))
						&& (this.ticksSinceSelection > 35 || this.selectedBody == moon || (this.lastSelectedBody instanceof Moon && GalaxyRegistry.getMoonsForPlanet(((Moon) this.lastSelectedBody).getParentPlanet()).contains(moon)))
						|| getSiblings(this.selectedBody).contains(moon)) {
					GL11.glPushMatrix();
					Matrix4f worldMatrix1 = new Matrix4f(worldMatrix0);
					Matrix4f.translate(this.getCelestialBodyPosition(moon), worldMatrix1, worldMatrix1);

					Matrix4f worldMatrix2 = new Matrix4f();
					Matrix4f.rotate((float) Math.toRadians(45), new Vector3f(0, 0, 1), worldMatrix2, worldMatrix2);
					Matrix4f.rotate((float) Math.toRadians(-55), new Vector3f(1, 0, 0), worldMatrix2, worldMatrix2);
					Matrix4f.scale(new Vector3f(0.25F, 0.25F, 1.0F), worldMatrix2, worldMatrix2);
					worldMatrix2 = Matrix4f.mul(worldMatrix1, worldMatrix2, worldMatrix2);

					fb.rewind();
					worldMatrix2.store(fb);
					fb.flip();
					GL11.glMultMatrix(fb);

					CelestialBodyRenderEvent.Pre preEvent = new CelestialBodyRenderEvent.Pre(moon, moon.getBodyIcon(), 8);
					MinecraftForge.EVENT_BUS.post(preEvent);

					GL11.glColor4f(1, 1, 1, 1);
					if (preEvent.celestialBodyTexture != null) {
						this.mc.renderEngine.bindTexture(preEvent.celestialBodyTexture);
					}

					if (!preEvent.isCanceled()) {
						int size = GuiCelestialSelection.getWidthForCelestialBodyStatic(moon);
						this.drawTexturedModalRect(-size / 2, -size / 2, size, size, 0, 0, preEvent.textureSize, preEvent.textureSize, false, false, preEvent.textureSize, preEvent.textureSize);
						matrixMap.put(moon, worldMatrix1);
					}

					CelestialBodyRenderEvent.Post postEvent = new CelestialBodyRenderEvent.Post(moon);
					MinecraftForge.EVENT_BUS.post(postEvent);
					fb.clear();
					GL11.glPopMatrix();
				}
			}
		}

		if (this.selectedBody != null) {
			Matrix4f worldMatrix0 = new Matrix4f(worldMatrix);

			for (Satellite satellite : GalaxyRegistry.getRegisteredSatellites().values()) {
				if (this.possibleBodies != null && this.possibleBodies.contains(satellite)) {
					if ((satellite == this.selectedBody || (satellite.getParentPlanet() == this.selectedBody && this.selectionCount != 1))
							&& (this.ticksSinceSelection > 35 || this.selectedBody == satellite || (this.lastSelectedBody instanceof Satellite && GalaxyRegistry.getSatellitesForCelestialBody(((Satellite) this.lastSelectedBody).getParentPlanet())
									.contains(satellite)))) {
						GL11.glPushMatrix();
						Matrix4f worldMatrix1 = new Matrix4f(worldMatrix0);
						Matrix4f.translate(this.getCelestialBodyPosition(satellite), worldMatrix1, worldMatrix1);

						Matrix4f worldMatrix2 = new Matrix4f();
						Matrix4f.rotate((float) Math.toRadians(45), new Vector3f(0, 0, 1), worldMatrix2, worldMatrix2);
						Matrix4f.rotate((float) Math.toRadians(-55), new Vector3f(1, 0, 0), worldMatrix2, worldMatrix2);
						Matrix4f.scale(new Vector3f(0.25F, 0.25F, 1.0F), worldMatrix2, worldMatrix2);
						worldMatrix2 = Matrix4f.mul(worldMatrix1, worldMatrix2, worldMatrix2);

						fb.rewind();
						worldMatrix2.store(fb);
						fb.flip();
						GL11.glMultMatrix(fb);

						CelestialBodyRenderEvent.Pre preEvent = new CelestialBodyRenderEvent.Pre(satellite, satellite.getBodyIcon(), 8);
						MinecraftForge.EVENT_BUS.post(preEvent);

						GL11.glColor4f(1, 1, 1, 1);
						this.mc.renderEngine.bindTexture(preEvent.celestialBodyTexture);

						if (!preEvent.isCanceled()) {
							int size = GuiCelestialSelection.getWidthForCelestialBodyStatic(satellite);
							this.drawTexturedModalRect(-size / 2, -size / 2, size, size, 0, 0, preEvent.textureSize, preEvent.textureSize, false, false, preEvent.textureSize, preEvent.textureSize);
							matrixMap.put(satellite, worldMatrix1);
						}

						CelestialBodyRenderEvent.Post postEvent = new CelestialBodyRenderEvent.Post(satellite);
						MinecraftForge.EVENT_BUS.post(postEvent);
						fb.clear();
						GL11.glPopMatrix();
					}
				}
			}
		}

		return matrixMap;
	}

	@Override
	public void drawButtons(int mousePosX, int mousePosY) {
		if (!(this.selectionState == EnumSelectionState.PROFILE)) {
			if (this.selectedBody != null) {
				GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);
				this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain1);
				int yOffset = 35;
				int widthSizeOffset = 75;
				int xOffset = 100 + (GuiCelestialSelection.BORDER_WIDTH + GuiCelestialSelection.BORDER_EDGE_WIDTH);
				this.drawTexturedModalRect(xOffset, yOffset, 93 + widthSizeOffset, 4, 159, 102, 93, 4, false, false);
				for (int barY = 0; barY < 25; ++barY) {
					this.drawTexturedModalRect(xOffset, yOffset + barY * this.fontRendererObj.FONT_HEIGHT + 4, 93 + widthSizeOffset, this.fontRendererObj.FONT_HEIGHT, 159, 106, 93, this.fontRendererObj.FONT_HEIGHT, false, false);
				}
				if (!(this.selectedBody instanceof Star)) {
					WorldProvider temp = null;
					if (this.selectedBody.getReachable() && !this.selectedBody.getUnlocalizedName().contains("overworld") && !(this.selectedBody instanceof Satellite))
						if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
							temp = WorldUtil.getProviderForDimensionClient(this.selectedBody.getDimensionID());
						else
							temp = WorldUtil.getProviderForDimensionServer(this.selectedBody.getDimensionID());
					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 2, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, GCCoreUtil.translate("gui.general_details.name") + ": ", xOffset + 10, yOffset + 8, ColorUtil.to32BitColor(255, 0, 150, 255));
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

					this.drawString(this.fontRendererObj, GCCoreUtil.translate("gui.celestial_body_type.name") + ": " + type, xOffset + 10, yOffset + 23, 14737632);
					if ((this.selectedBody instanceof Planet))
						this.drawString(this.fontRendererObj, GCCoreUtil.translate("gui.celestial_body_amount_of_moons.name") + ": " + this.getChildren(this.selectedBody).size(), xOffset + 10, yOffset + 33, 14737632);
					yOffset = yOffset + 45;
					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 2, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, GCCoreUtil.translate("gui.celestial_details.name") + ": ", xOffset + 10, yOffset + 8, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 14, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, GCCoreUtil.translate("gui.celestial_body_orbit_time.name") + ": " + this.selectedBody.getRelativeOrbitTime() * 24 + " days", xOffset + 10, yOffset + 23, 14737632);
					float gravity = 0;
					long dayLength = 0;
					if (this.selectedBody.getReachable() && !(this.selectedBody instanceof Satellite) && !this.selectedBody.getUnlocalizedName().toLowerCase().contains("overworld")) {
						gravity = ((WorldProviderSpace) temp).getGravity();
						dayLength = ((WorldProviderSpace) temp).getDayLength() / 1000;
					} else if (this.selectedBody.getUnlocalizedName().toLowerCase().contains("overworld")) {
						gravity = 1;
						dayLength = 24;
					}
					this.drawString(this.fontRendererObj, GCCoreUtil.translate("gui.celestial_body_gravity.name") + ": " + (this.selectedBody.getReachable() ? gravity : "Unknown"), xOffset + 10, yOffset + 33, 14737632);
					this.drawString(this.fontRendererObj, GCCoreUtil.translate("gui.celestial_body_day_lengh.name") + ": " + (this.selectedBody.getReachable() ? dayLength + " hours" : "Unknown"), xOffset + 10, yOffset + 43, 14737632);
					yOffset = yOffset + 55;
					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 2, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, GCCoreUtil.translate("gui.general_features_details.name") + ": ", xOffset + 10, yOffset + 8, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 14, ColorUtil.to32BitColor(255, 0, 150, 255));
					double meteorFrequency = 0;
					if (temp != null && !(this.selectedBody instanceof Satellite) && !this.selectedBody.getUnlocalizedName().contains("overworld")) {
						double number = ((WorldProviderSpace) temp).getMeteorFrequency();
						BigDecimal bd = new BigDecimal(number).setScale(7, RoundingMode.DOWN);
						meteorFrequency = bd.doubleValue();
					} else {
						meteorFrequency = 0;
					}
					this.drawString(this.fontRendererObj, GCCoreUtil.translate("gui.celestial_body_meteor_frequency.name") + ": " + (this.selectedBody.getReachable() ? meteorFrequency : "Unknown"), xOffset + 10, yOffset + 23, 14737632);

					String name = this.selectedBody.getUnlocalizedName().toLowerCase();
					String hasDungeon = "Unknown";
					if (name.contains("moon") || name.contains("venus") || name.contains("mars") || name.contains("jupiter") || name.contains("saturn") || name.contains("uranus") || name.contains("neptune")
							|| name.contains("pluto") || name.contains("eris"))
						hasDungeon = "true";
					if (name.contains("overworld") || name.contains("ceres") || name.contains("kepler22b") || name.contains("asteroids") || name.contains("phobos") || name.contains("deimos") || name.contains("io") || name.contains("europa") || name.contains("ganymede")
							|| name.contains("callisto") || name.contains("rhea") || name.contains("titan") || name.contains("iapetus") || name.contains("titania") || name.contains("oberon") || name.contains("triton") || name.contains("mercury"))
						hasDungeon = "false";
					this.drawString(this.fontRendererObj, "Has Dungeon: " + hasDungeon, xOffset + 10, yOffset + 32, 14737632);
					yOffset = yOffset + 5;
					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 39, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, GCCoreUtil.translate("gui.atmosphere_details.name") + ": ", xOffset + 10, yOffset + 45, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 51, ColorUtil.to32BitColor(255, 0, 150, 255));
					float windLevel = 0;
					if (this.selectedBody.getReachable() && !this.selectedBody.getUnlocalizedName().toLowerCase().contains("overworld") && !(this.selectedBody instanceof Satellite))
						windLevel = ((WorldProviderSpace) temp).getWindLevel() * 10;

					this.drawString(this.fontRendererObj, GCCoreUtil.translate("gui.celestial_body_wind_level.name") + ": " + (this.selectedBody.getReachable() ? windLevel + "%" : "Unknown"), xOffset + 10,
							yOffset + 60, 14737632);
					float temperature = 0;
					if (this.selectedBody.getReachable() && !this.selectedBody.getUnlocalizedName().toLowerCase().contains("overworld") && !(this.selectedBody instanceof Satellite))
						try {
							temperature = ((WorldProviderSpace) temp).getThermalLevelModifier();
						} catch (Exception e) {
						}
					this.drawString(this.fontRendererObj, GCCoreUtil.translate("gui.celestial_body_temperature.name") + ": " + (this.selectedBody.getReachable() ? temperature + "°C" : "Unknown"), xOffset + 10, yOffset + 70, 14737632);
					boolean breathable = false;
					try {
						if (temp != null && !(this.selectedBody instanceof Satellite))
							breathable = ((WorldProviderSpace) temp).hasBreathableAtmosphere();
						if (this.selectedBody.getUnlocalizedName().contains("overworld"))
							breathable = true;
					} catch (Exception e) {
					}
					this.drawString(this.fontRendererObj, GCCoreUtil.translate("gui.celestial_body_breathable.name") + ": " + (this.selectedBody.getReachable() ? breathable : "Unknown"), xOffset + 10, yOffset + 80, 14737632);
				} else if (this.selectedBody instanceof Star) {
					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 2, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, GCCoreUtil.translate("gui.general_details.name") + ": ", xOffset + 10, yOffset + 8, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 14, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, GCCoreUtil.translate("gui.celestial_body_type.name") + ": " + "Star", xOffset + 10, yOffset + 23, 14737632);
					List<CelestialBody> planets = this.getChildren(((Star) this.selectedBody).getParentSolarSystem());
					int amountofPlanets = planets.size();
					this.drawString(this.fontRendererObj, GCCoreUtil.translate("gui.celestial_body_amount_of_planets.name") + ": " + amountofPlanets, xOffset + 10, yOffset + 33, 14737632);

					yOffset = yOffset + 50;

					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 2, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, GCCoreUtil.translate("gui.parent_solar_system_details.name") + ": ", xOffset + 10, yOffset + 8, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRendererObj, "------------------------", xOffset + 10, yOffset + 14, ColorUtil.to32BitColor(255, 0, 150, 255));

					int amountofMoons = 0;
					for (int i = 0; i < amountofPlanets; i++) {
						amountofMoons += this.getChildren(planets.get(i)).size();
					}
					this.drawString(this.fontRendererObj, GCCoreUtil.translate("gui.celestial_body_amount_of_moons.name") + ": " + amountofMoons, xOffset + 10, yOffset + 23, 14737632);
				}
			}
		}
		super.drawButtons(mousePosX, mousePosY);
	}
}
