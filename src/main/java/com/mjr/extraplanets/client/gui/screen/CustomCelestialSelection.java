package com.mjr.extraplanets.client.gui.screen;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import micdoodle8.mods.galacticraft.api.recipe.SpaceStationRecipe;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.client.gui.screen.GuiCelestialSelection;
import micdoodle8.mods.galacticraft.core.util.ColorUtil;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.world.WorldProviderRealisticSpace;
import com.mjr.mjrlegendslib.util.MCUtilities;
import com.mjr.mjrlegendslib.util.TranslateUtilities;

public class CustomCelestialSelection extends GuiCelestialSelection {
	private List<String> galaxies = new ArrayList<String>();
	private String currentGalaxyName = "";
	private SolarSystem currentGalaxyMainSystem;
	private int mousePosX = 0;
	private int mousePosY = 0;
	private float partialTicks = 0;
	private boolean showGalaxies = false;

	public CustomCelestialSelection(boolean mapMode, List<CelestialBody> possibleBodies, boolean canCreateStations) {
		super(mapMode, possibleBodies, canCreateStations);
		for (SolarSystem system : GalaxyRegistry.getRegisteredSolarSystems().values()) {
			String name = system.getUnlocalizedParentGalaxyName();
			if (!this.galaxies.contains(name))
				this.galaxies.add(name);
		}
		this.currentGalaxyName = "galaxy.milky_way";
		this.currentGalaxyMainSystem = GalacticraftCore.solarSystemSol;
	}

	@Override
	protected List<CelestialBody> getChildren(Object object) {
		List<CelestialBody> bodyList = Lists.newArrayList();

		if (object instanceof Planet) {
			for (Planet planet : GalaxyRegistry.getRegisteredPlanets().values()) {
				if (planet.equals(object))
					if (planet.getParentSolarSystem().getUnlocalizedParentGalaxyName().equalsIgnoreCase(this.currentGalaxyName)) {
						List<Moon> moons = GalaxyRegistry.getMoonsForPlanet((Planet) object);
						bodyList.addAll(moons);
					}
			}
		} else if (object instanceof SolarSystem) {
			for (SolarSystem solarSystems : GalaxyRegistry.getRegisteredSolarSystems().values()) {
				if (solarSystems.equals(object))
					if (solarSystems.getUnlocalizedParentGalaxyName().equalsIgnoreCase(this.currentGalaxyName)) {
						List<Planet> planets = GalaxyRegistry.getPlanetsForSolarSystem((SolarSystem) object);
						bodyList.addAll(planets);
					}
			}
		}

		Collections.sort(bodyList);

		return bodyList;
	}

	@Override
	public HashMap<CelestialBody, Matrix4f> drawCelestialBodies(Matrix4f worldMatrix) {
		GL11.glColor3f(1, 1, 1);
		FloatBuffer fb = BufferUtils.createFloatBuffer(16 * Float.SIZE);
		HashMap<CelestialBody, Matrix4f> matrixMap = Maps.newHashMap();

		for (SolarSystem solarSystem : GalaxyRegistry.getRegisteredSolarSystems().values()) {
			if (solarSystem.getUnlocalizedParentGalaxyName().equalsIgnoreCase(this.currentGalaxyName)) {
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

					if (this.selectedBody != null && this.selectedBody != star && this.isZoomed()) {
						alpha = 1.0F - Math.min(this.ticksSinceSelection / 25.0F, 1.0F);
					}

					if (this.selectedBody != null && this.isZoomed()) {
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
							int size = getWidthForCelestialBodyStatic(star);
							if (star == this.selectedBody && this.selectionState == EnumSelection.SELECTED) {
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
		}

		for (Planet planet : GalaxyRegistry.getRegisteredPlanets().values()) {
			if (planet.getParentSolarSystem().getUnlocalizedParentGalaxyName().equalsIgnoreCase(this.currentGalaxyName)) {

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

					if ((this.selectedBody instanceof IChildBody && ((IChildBody) this.selectedBody).getParentPlanet() != planet) || (this.selectedBody instanceof Planet && this.selectedBody != planet && this.isZoomed())) {
						if (this.lastSelectedBody == null && !(this.selectedBody instanceof IChildBody)) {
							alpha = 1.0F - Math.min(this.ticksSinceSelection / 25.0F, 1.0F);
						} else {
							alpha = 0.0F;
						}
					}

					if (alpha != 0) {
						if (!this.isZoomed() && !(this.selectedBody instanceof Moon) && !(this.selectedBody instanceof Satellite)) {
							this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain1);
							this.drawCenteredString(this.fontRenderer, planet.getLocalizedName(), 0, 5, 14737632);
						}
						CelestialBodyRenderEvent.Pre preEvent = new CelestialBodyRenderEvent.Pre(planet, planet.getBodyIcon(), 12);
						MinecraftForge.EVENT_BUS.post(preEvent);

						GL11.glColor4f(1, 1, 1, alpha);
						if (preEvent.celestialBodyTexture != null) {
							this.mc.renderEngine.bindTexture(preEvent.celestialBodyTexture);
						}

						if (!preEvent.isCanceled()) {
							int size = getWidthForCelestialBodyStatic(planet);
							matrixMap.put(planet, worldMatrix1);
							this.drawTexturedModalRect(-size / 2, -size / 2, size, size, 0, 0, preEvent.textureSize, preEvent.textureSize, false, false, preEvent.textureSize, preEvent.textureSize);
						}

						CelestialBodyRenderEvent.Post postEvent = new CelestialBodyRenderEvent.Post(planet);
						MinecraftForge.EVENT_BUS.post(postEvent);
					}

					fb.clear();
					GL11.glPopMatrix();
				}
			}
		}

		if (this.selectedBody != null) {
			Matrix4f worldMatrix0 = new Matrix4f(worldMatrix);

			for (Moon moon : GalaxyRegistry.getRegisteredMoons().values()) {
				if (moon.getParentPlanet().getParentSolarSystem().getUnlocalizedParentGalaxyName().equalsIgnoreCase(this.currentGalaxyName)) {

					if ((moon == this.selectedBody || (moon.getParentPlanet() == this.selectedBody && this.selectionState != EnumSelection.SELECTED))
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
							int size = getWidthForCelestialBodyStatic(moon);
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
		}

		if (this.selectedBody != null) {
			Matrix4f worldMatrix0 = new Matrix4f(worldMatrix);

			for (Satellite satellite : GalaxyRegistry.getRegisteredSatellites().values()) {
				if (satellite.getParentPlanet().getParentSolarSystem().getUnlocalizedParentGalaxyName().equalsIgnoreCase(this.currentGalaxyName)) {

					if (this.possibleBodies != null && this.possibleBodies.contains(satellite)) {
						if ((satellite == this.selectedBody || (satellite.getParentPlanet() == this.selectedBody && this.selectionState != EnumSelection.SELECTED))
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
								int size = getWidthForCelestialBodyStatic(satellite);
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
		}

		return matrixMap;
	}

	@Override
	public void drawCircles() {
		GL11.glColor4f(1, 1, 1, 1);
		GL11.glLineWidth(3);
		int count = 0;

		final float theta = (float) (2 * Math.PI / 90);
		final float cos = (float) Math.cos(theta);
		final float sin = (float) Math.sin(theta);

		for (Planet planet : GalaxyRegistry.getRegisteredPlanets().values()) {
			if (planet.getParentSolarSystem() != null) {
				if (planet.getParentSolarSystem().getUnlocalizedParentGalaxyName().equalsIgnoreCase(this.currentGalaxyName)) {
					Vector3f systemOffset = this.getCelestialBodyPosition(planet.getParentSolarSystem().getMainStar());

					float x = this.getScale(planet);
					float y = 0;

					float alpha = 1.0F;

					if ((this.selectedBody instanceof IChildBody && ((IChildBody) this.selectedBody).getParentPlanet() != planet) || (this.selectedBody instanceof Planet && this.selectedBody != planet && this.isZoomed())) {
						if (this.lastSelectedBody == null && !(this.selectedBody instanceof IChildBody) && !(this.selectedBody instanceof Satellite)) {
							alpha = 1.0F - Math.min(this.ticksSinceSelection / 25.0F, 1.0F);
						} else {
							alpha = 0.0F;
						}
					}

					if (alpha != 0) {
						switch (count % 2) {
						case 0:
							GL11.glColor4f(0.0F / 1.4F, 0.6F / 1.4F, 1.0F / 1.4F, alpha / 1.4F);
							break;
						case 1:
							GL11.glColor4f(0.4F / 1.4F, 0.9F / 1.4F, 1.0F / 1.4F, alpha / 1.4F);
							break;
						}

						CelestialBodyRenderEvent.CelestialRingRenderEvent.Pre preEvent = new CelestialBodyRenderEvent.CelestialRingRenderEvent.Pre(planet, systemOffset);
						MinecraftForge.EVENT_BUS.post(preEvent);

						if (!preEvent.isCanceled()) {
							GL11.glTranslatef(systemOffset.x, systemOffset.y, systemOffset.z);

							GL11.glBegin(GL11.GL_LINE_LOOP);

							float temp;
							for (int i = 0; i < 90; i++) {
								GL11.glVertex2f(x, y);

								temp = x;
								x = cos * x - sin * y;
								y = sin * temp + cos * y;
							}

							GL11.glEnd();

							GL11.glTranslatef(-systemOffset.x, -systemOffset.y, -systemOffset.z);

							count++;
						}

						CelestialBodyRenderEvent.CelestialRingRenderEvent.Post postEvent = new CelestialBodyRenderEvent.CelestialRingRenderEvent.Post(planet);
						MinecraftForge.EVENT_BUS.post(postEvent);
					}
				}
			}
		}

		count = 0;

		if (this.selectedBody != null) {
			Vector3f planetPos = this.getCelestialBodyPosition(this.selectedBody);

			if (this.selectedBody instanceof IChildBody) {
				planetPos = this.getCelestialBodyPosition(((IChildBody) this.selectedBody).getParentPlanet());
			} else if (this.selectedBody instanceof Satellite) {
				planetPos = this.getCelestialBodyPosition(((Satellite) this.selectedBody).getParentPlanet());
			}

			GL11.glTranslatef(planetPos.x, planetPos.y, 0);

			for (Moon moon : GalaxyRegistry.getRegisteredMoons().values()) {
				if ((moon.getParentPlanet() == this.selectedBody && this.selectionState != EnumSelection.SELECTED) || moon == this.selectedBody || getSiblings(this.selectedBody).contains(moon)) {
					if (this.drawCircle(moon, count, sin, cos)) {
						count++;
					}
				}
			}

			for (Satellite satellite : GalaxyRegistry.getRegisteredSatellites().values()) {
				if (this.possibleBodies != null && this.possibleBodies.contains(satellite)) {
					if ((satellite.getParentPlanet() == this.selectedBody && this.selectionState != EnumSelection.SELECTED) && this.ticksSinceSelection > 24 || satellite == this.selectedBody || this.lastSelectedBody instanceof IChildBody) {
						if (this.drawCircle(satellite, count, sin, cos)) {
							count++;
						}
					}
				}
			}
		}

		GL11.glLineWidth(1);
	}

	@Override
	public boolean drawCircle(CelestialBody body, int count, float sin, float cos) {
		if (!this.isZoomed() && body.getUnlocalizedName().contains("planet")) {
			if (((Planet) body).getParentSolarSystem().getUnlocalizedParentGalaxyName().equalsIgnoreCase(this.currentGalaxyName))
				return false;
		}
		float x = this.getScale(body);
		float y = 0;

		float alpha = 1;

		if (this.isZoomed()) {
			alpha = this.selectedBody instanceof IChildBody ? 1.0F : Math.min(Math.max((this.ticksSinceSelection - 30) / 15.0F, 0.0F), 1.0F);

			if (this.lastSelectedBody instanceof Moon && body instanceof Moon) {
				if (GalaxyRegistry.getMoonsForPlanet(((Moon) this.lastSelectedBody).getParentPlanet()).contains(body)) {
					alpha = 1.0F;
				}
			} else if (this.lastSelectedBody instanceof Satellite && body instanceof Satellite) {
				if (GalaxyRegistry.getSatellitesForCelestialBody(((Satellite) this.lastSelectedBody).getParentPlanet()).contains(body)) {
					alpha = 1.0F;
				}
			}
		}

		if (alpha != 0) {
			switch (count % 2) {
			case 0:
				GL11.glColor4f(0.0F, 0.6F, 1.0F, alpha);
				break;
			case 1:
				GL11.glColor4f(0.4F, 0.9F, 1.0F, alpha);
				break;
			}

			CelestialBodyRenderEvent.CelestialRingRenderEvent.Pre preEvent = new CelestialBodyRenderEvent.CelestialRingRenderEvent.Pre(body, new Vector3f(0.0F, 0.0F, 0.0F));
			MinecraftForge.EVENT_BUS.post(preEvent);

			if (!preEvent.isCanceled()) {
				GL11.glBegin(GL11.GL_LINE_LOOP);

				float temp;
				for (int i = 0; i < 90; i++) {
					GL11.glVertex2f(x, y);

					temp = x;
					x = cos * x - sin * y;
					y = sin * temp + cos * y;
				}

				GL11.glEnd();
				return true;
			}

			CelestialBodyRenderEvent.CelestialRingRenderEvent.Post postEvent = new CelestialBodyRenderEvent.CelestialRingRenderEvent.Post(body);
			MinecraftForge.EVENT_BUS.post(postEvent);
		}

		return false;
	}

	@Override
	protected Vector3f getCelestialBodyPosition(CelestialBody cBody) {
		if (cBody instanceof Star) {
			if (cBody.getUnlocalizedName().equalsIgnoreCase("star.sol"))
			// Return zero vector for Sol, different location for other solar systems
			{
				return new Vector3f();
			}
			return ((Star) cBody).getParentSolarSystem().getMapPosition().toVector3f();
		}

		if (this.celestialBodyTicks.get(cBody) != null) {
			int cBodyTicks = this.celestialBodyTicks.get(cBody);
			float timeScale = cBody instanceof Planet ? 200.0F : 2.0F;
			float distanceFromCenter = this.getScale(cBody);
			Vector3f cBodyPos = new Vector3f((float) Math.sin(cBodyTicks / (timeScale * cBody.getRelativeOrbitTime()) + cBody.getPhaseShift()) * distanceFromCenter, (float) Math.cos(cBodyTicks / (timeScale * cBody.getRelativeOrbitTime())
					+ cBody.getPhaseShift())
					* distanceFromCenter, 0);

			if (cBody instanceof Planet) {
				Vector3f parentVec = this.getCelestialBodyPosition(((Planet) cBody).getParentSolarSystem().getMainStar());
				return Vector3f.add(cBodyPos, parentVec, null);
			}

			if (cBody instanceof IChildBody) {
				Vector3f parentVec = this.getCelestialBodyPosition(((IChildBody) cBody).getParentPlanet());
				return Vector3f.add(cBodyPos, parentVec, null);
			}

			return cBodyPos;

		}
		return new Vector3f(0, 0, 0);
	}

	public void drawCustomButtons(int mousePosX, int mousePosY) {
		if (this.viewState != EnumView.PROFILE) {
			if (this.selectedBody != null) {
				GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);
				this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain1);
				int yOffset = 27;
				int widthSizeOffset = 75;
				int xOffset = (this.width - 270) - (GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE);
				this.drawTexturedModalRect(xOffset, yOffset, 93 + widthSizeOffset, 4, 159, 102, 93, 4, false, false);
				for (int barY = 0; barY < 25; ++barY) {
					this.drawTexturedModalRect(xOffset, yOffset + barY * this.fontRenderer.FONT_HEIGHT + 4, 93 + widthSizeOffset, this.fontRenderer.FONT_HEIGHT, 159, 106, 93, this.fontRenderer.FONT_HEIGHT, false, false);
				}
				for (int barx = 0; barx < 1; ++barx) {
					this.drawTexturedModalRect(xOffset + barx, yOffset * this.fontRenderer.FONT_HEIGHT + 10, 93 + widthSizeOffset, this.fontRenderer.FONT_HEIGHT / 2, 159, 106, 1, this.fontRenderer.FONT_HEIGHT, false, false);
				}
				if (!(this.selectedBody instanceof Star)) {
					WorldProvider temp = null;
					if (this.selectedBody.getReachable() && !this.selectedBody.getUnlocalizedName().contains("overworld") && !(this.selectedBody instanceof Satellite))
						if (MCUtilities.isClient())
							temp = WorldUtil.getProviderForDimensionClient(this.selectedBody.getDimensionID());
						else
							temp = WorldUtil.getProviderForDimensionServer(this.selectedBody.getDimensionID());
					this.drawString(this.fontRenderer, "------------------------", xOffset + 10, yOffset + 2, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRenderer, TranslateUtilities.translate("gui.general_details.name") + ": ", xOffset + 10, yOffset + 8, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRenderer, "------------------------", xOffset + 10, yOffset + 14, ColorUtil.to32BitColor(255, 0, 150, 255));
					String type;
					if (GalaxyRegistry.getRegisteredPlanets().containsValue(this.selectedBody))
						type = TranslateUtilities.translate("gui.type_planet.name");
					else if (GalaxyRegistry.getRegisteredMoons().containsValue(this.selectedBody))
						type = TranslateUtilities.translate("gui.type_moon.name");
					else if (GalaxyRegistry.getRegisteredSatellites().containsValue(this.selectedBody))
						type = TranslateUtilities.translate("gui.type_satellite.name");
					else
						type = TranslateUtilities.translate("gui.type_unknown.name");

					this.drawString(this.fontRenderer, TranslateUtilities.translate("gui.celestial_body_type.name") + ": " + type, xOffset + 10, yOffset + 23, 14737632);
					if ((this.selectedBody instanceof Planet))
						this.drawString(this.fontRenderer, TranslateUtilities.translate("gui.celestial_body_amount_of_moons.name") + ": " + this.getChildren(this.selectedBody).size(), xOffset + 10, yOffset + 33, 14737632);
					yOffset = yOffset + 45;
					this.drawString(this.fontRenderer, "------------------------", xOffset + 10, yOffset + 2, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRenderer, TranslateUtilities.translate("gui.celestial_details.name") + ": ", xOffset + 10, yOffset + 8, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRenderer, "------------------------", xOffset + 10, yOffset + 14, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRenderer, TranslateUtilities.translate("gui.celestial_body_orbit_time.name") + ": " + this.selectedBody.getRelativeOrbitTime() * 24 + " " + TranslateUtilities.translate("gui.type_days.name"),
							xOffset + 10, yOffset + 23, 14737632);
					float gravity = 0;
					long dayLength = 0;
					if (this.selectedBody.getReachable() && !(this.selectedBody instanceof Satellite) && !this.selectedBody.getUnlocalizedName().toLowerCase().contains("overworld")) {
						gravity = ((WorldProviderSpace) temp).getGravity();
						dayLength = ((WorldProviderSpace) temp).getDayLength() / 1000;
					} else if (this.selectedBody.getUnlocalizedName().toLowerCase().contains("overworld")) {
						gravity = 1;
						dayLength = 24;
					}
					this.drawString(this.fontRenderer, TranslateUtilities.translate("gui.celestial_body_gravity.name") + ": " + (this.selectedBody.getReachable() ? gravity : TranslateUtilities.translate("gui.type_unknown.name")), xOffset + 10,
							yOffset + 33, 14737632);
					this.drawString(this.fontRenderer, TranslateUtilities.translate("gui.celestial_body_day_lengh.name") + ": "
							+ (this.selectedBody.getReachable() ? dayLength + " " + TranslateUtilities.translate("gui.type_hours.name") : TranslateUtilities.translate("gui.type_unknown.name")), xOffset + 10, yOffset + 43, 14737632);
					yOffset = yOffset + 55;
					this.drawString(this.fontRenderer, "------------------------", xOffset + 10, yOffset + 2, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRenderer, TranslateUtilities.translate("gui.general_features_details.name") + ": ", xOffset + 10, yOffset + 8, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRenderer, "------------------------", xOffset + 10, yOffset + 14, ColorUtil.to32BitColor(255, 0, 150, 255));
					double meteorFrequency = 0;
					if (temp != null && !(this.selectedBody instanceof Satellite) && !this.selectedBody.getUnlocalizedName().contains("overworld")) {
						double number = ((WorldProviderSpace) temp).getMeteorFrequency();
						BigDecimal bd = new BigDecimal(number).setScale(7, RoundingMode.DOWN);
						meteorFrequency = bd.doubleValue();
					} else {
						meteorFrequency = 0;
					}
					this.drawString(this.fontRenderer, TranslateUtilities.translate("gui.celestial_body_meteor_frequency.name") + ": " + (this.selectedBody.getReachable() ? meteorFrequency : TranslateUtilities.translate("gui.type_unknown.name")),
							xOffset + 10, yOffset + 23, 14737632);

					String name = this.selectedBody.getUnlocalizedName().toLowerCase();
					String hasDungeon = TranslateUtilities.translate("gui.type_unknown.name");
					if (name.contains("moon") || name.contains("venus") || name.contains("mars") || name.contains("mercury") || name.contains("jupiter") || name.contains("saturn") || name.contains("uranus") || name.contains("neptune")
							|| name.contains("pluto") || name.contains("eris"))
						hasDungeon = "true";
					if (name.contains("overworld") || name.contains("ceres") || name.contains("kepler22b") || name.contains("asteroids") || name.contains("phobos") || name.contains("deimos") || name.contains("io") || name.contains("europa")
							|| name.contains("ganymede") || name.contains("callisto") || name.contains("rhea") || name.contains("titan") || name.contains("iapetus") || name.contains("titania") || name.contains("oberon") || name.contains("triton"))
						hasDungeon = "false";
					this.drawString(this.fontRenderer, TranslateUtilities.translate("gui.celestial_body_has_dungeon.name") + ": " + hasDungeon, xOffset + 10, yOffset + 32, 14737632);
					yOffset = yOffset + 5;
					this.drawString(this.fontRenderer, "------------------------", xOffset + 10, yOffset + 39, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRenderer, TranslateUtilities.translate("gui.atmosphere_details.name") + ": ", xOffset + 10, yOffset + 45, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRenderer, "------------------------", xOffset + 10, yOffset + 51, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRenderer,
							TranslateUtilities.translate("gui.celestial_body_wind_level.name") + ": " + (this.selectedBody.getReachable() ? this.selectedBody.atmosphere.windLevel() * 10 + "%" : TranslateUtilities.translate("gui.type_unknown.name")),
							xOffset + 10, yOffset + 60, 14737632);
					float temperature = 0;
					if (this.selectedBody.getReachable() && !this.selectedBody.getUnlocalizedName().toLowerCase().contains("overworld") && !(this.selectedBody instanceof Satellite))
						try {
							temperature = ((WorldProviderSpace) temp).getThermalLevelModifier();
						} catch (Exception e) {
						}
					this.drawString(this.fontRenderer, TranslateUtilities.translate("gui.celestial_body_temperature.name") + ": " + (this.selectedBody.getReachable() ? temperature + "°C" : TranslateUtilities.translate("gui.type_unknown.name")),
							xOffset + 10, yOffset + 70, 14737632);
					boolean breathable = false;
					if (temp != null && !(this.selectedBody instanceof Satellite))
						breathable = ((WorldProviderSpace) temp).hasBreathableAtmosphere();
					if (this.selectedBody.getUnlocalizedName().contains("overworld"))
						breathable = true;
					this.drawString(this.fontRenderer, TranslateUtilities.translate("gui.celestial_body_breathable.name") + ": " + (this.selectedBody.getReachable() ? breathable : TranslateUtilities.translate("gui.type_unknown.name")), xOffset + 10,
							yOffset + 80, 14737632);
					this.drawString(
							this.fontRenderer,
							TranslateUtilities.translate("gui.celestial_body_corrosive_atmosphere.name") + ": " + (this.selectedBody.getReachable() ? this.selectedBody.atmosphere.isCorrosive() : TranslateUtilities.translate("gui.type_unknown.name")),
							xOffset + 10, yOffset + 90, 14737632);
					int radiationLevel = 0;
					int pressureLevel = 0;
					try {
						radiationLevel = ((WorldProviderRealisticSpace) temp).getSolarRadiationLevel();
						pressureLevel = ((WorldProviderRealisticSpace) temp).getPressureLevel();
					} catch (Exception ex) {
					}

					this.drawString(this.fontRenderer,
							TranslateUtilities.translate("gui.celestial_body_radiation_level.name") + ": " + (this.selectedBody.getReachable() ? radiationLevel + "%" : TranslateUtilities.translate("gui.type_unknown.name")), xOffset + 10,
							yOffset + 100, 14737632);
					this.drawString(this.fontRenderer, TranslateUtilities.translate("gui.celestial_body_pressure_level.name") + ": " + (this.selectedBody.getReachable() ? pressureLevel + "%" : TranslateUtilities.translate("gui.type_unknown.name")),
							xOffset + 10, yOffset + 110, 14737632);
				} else if (this.selectedBody instanceof Star) {
					this.drawString(this.fontRenderer, "------------------------", xOffset + 10, yOffset + 2, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRenderer, TranslateUtilities.translate("gui.general_details.name") + ": ", xOffset + 10, yOffset + 8, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRenderer, "------------------------", xOffset + 10, yOffset + 14, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRenderer, TranslateUtilities.translate("gui.celestial_body_type.name") + ": " + "Star", xOffset + 10, yOffset + 23, 14737632);
					List<CelestialBody> planets = this.getChildren(((Star) this.selectedBody).getParentSolarSystem());
					int amountofPlanets = planets.size();
					this.drawString(this.fontRenderer, TranslateUtilities.translate("gui.celestial_body_amount_of_planets.name") + ": " + amountofPlanets, xOffset + 10, yOffset + 33, 14737632);

					yOffset = yOffset + 50;

					this.drawString(this.fontRenderer, "------------------------", xOffset + 10, yOffset + 2, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRenderer, TranslateUtilities.translate("gui.parent_solar_system_details.name") + ": ", xOffset + 10, yOffset + 8, ColorUtil.to32BitColor(255, 0, 150, 255));
					this.drawString(this.fontRenderer, "------------------------", xOffset + 10, yOffset + 14, ColorUtil.to32BitColor(255, 0, 150, 255));

					int amountofMoons = 0;
					for (int i = 0; i < amountofPlanets; i++) {
						amountofMoons += this.getChildren(planets.get(i)).size();
					}
					this.drawString(this.fontRenderer, TranslateUtilities.translate("gui.celestial_body_amount_of_moons.name") + ": " + amountofMoons, xOffset + 10, yOffset + 23, 14737632);
				}
			}

			int scale = (int) Math.min(95, this.ticksSinceMenuOpen * 12.0F);
			String str;

			if (this.showGalaxies) {
				this.drawString(this.fontRenderer, "-", GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 80, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 16, 8087790);
				for (int i = 0; i < this.galaxies.size(); i++) {
					String child = TranslateUtilities.translate(this.galaxies.get(i));
					int xOffset = 0;
					int yOffset = 45;

					scale = (int) Math.min(95.0F, Math.max(0.0F, (this.ticksSinceMenuOpen * 25.0F) - 95 * i));

					this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain0);
					GL11.glColor4f(0.0F, 0.6F, 0.0F, scale / 95.0F);
					this.drawTexturedModalRect(GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 3 + xOffset, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 6 + i * 14 + yOffset, 86, 10, 0,
							489, 86, 10, false, false);
					GL11.glColor4f(0.0F, 0.6F, 1.0F, scale / 95.0F);
					this.drawTexturedModalRect(GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 2 + xOffset, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 5 + i * 14 + yOffset, 93, 12, 95,
							464, 93, 12, false, false);

					if (scale > 0) {
						GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
						str = child;
						int color = 14737632;
						this.fontRenderer.drawString(str, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 7 + xOffset, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 8 + i * 14 + yOffset,
								color);
					}
				}
			} else if (!this.showGalaxies && Config.CUSTOM_GALAXIES) {
				this.drawString(this.fontRenderer, "+", GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 80, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 16, 8087790);
				this.drawString(this.fontRenderer, "< " + TranslateUtilities.translate("gui.new_galaxies.name") + "!", GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 100, GuiCelestialSelection.BORDER_SIZE
						+ GuiCelestialSelection.BORDER_EDGE_SIZE + 16, 8087790);
			}
		}
	}

	@Override
	public void drawButtons(int mousePosX, int mousePosY) {
		this.drawCustomButtons(mousePosX, mousePosY);
		this.zLevel = 0.0F;
		boolean handledSliderPos = false;

		if (this.viewState == EnumView.PROFILE) {
			this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain0);
			GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);
			this.drawTexturedModalRect(width / 2 - 43, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE, 86, 15, 266, 0, 172, 29, false, false);
			String str = TranslateUtilities.translate("gui.message.catalog.name").toUpperCase();
			this.fontRenderer.drawString(str, width / 2 - this.fontRenderer.getStringWidth(str) / 2, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + this.fontRenderer.FONT_HEIGHT / 2,
					ColorUtil.to32BitColor(255, 255, 255, 255));

			if (this.selectedBody != null) {
				this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain0);

				if (mousePosX > BORDER_SIZE + BORDER_EDGE_SIZE && mousePosX < BORDER_SIZE + BORDER_EDGE_SIZE + 88 && mousePosY > BORDER_SIZE + BORDER_EDGE_SIZE && mousePosY < BORDER_SIZE + BORDER_EDGE_SIZE + 13) {
					GL11.glColor3f(3.0F, 0.0F, 0.0F);
				} else {
					GL11.glColor3f(0.9F, 0.2F, 0.2F);
				}

				this.drawTexturedModalRect(BORDER_SIZE + BORDER_EDGE_SIZE, BORDER_SIZE + BORDER_EDGE_SIZE, 88, 13, 0, 392, 148, 22, false, false);
				str = TranslateUtilities.translate("gui.message.back.name").toUpperCase();
				this.fontRenderer.drawString(str, BORDER_SIZE + BORDER_EDGE_SIZE + 45 - this.fontRenderer.getStringWidth(str) / 2, BORDER_SIZE + BORDER_EDGE_SIZE + this.fontRenderer.FONT_HEIGHT / 2 - 2, ColorUtil.to32BitColor(255, 255, 255, 255));

				this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain0);
				if (mousePosX > width - BORDER_SIZE - BORDER_EDGE_SIZE - 88 && mousePosX < width - BORDER_SIZE - BORDER_EDGE_SIZE && mousePosY > BORDER_SIZE + BORDER_EDGE_SIZE && mousePosY < BORDER_SIZE + BORDER_EDGE_SIZE + 13) {
					GL11.glColor3f(0.0F, 3.0F, 0.0F);
				} else {
					GL11.glColor3f(0.2F, 0.9F, 0.2F);
				}

				this.drawTexturedModalRect(width - BORDER_SIZE - BORDER_EDGE_SIZE - 88, BORDER_SIZE + BORDER_EDGE_SIZE, 88, 13, 0, 392, 148, 22, true, false);

				GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);
				this.drawTexturedModalRect(BORDER_SIZE + BORDER_EDGE_SIZE, height - BORDER_SIZE - BORDER_EDGE_SIZE - 13, 88, 13, 0, 392, 148, 22, false, true);
				this.drawTexturedModalRect(width - BORDER_SIZE - BORDER_EDGE_SIZE - 88, height - BORDER_SIZE - BORDER_EDGE_SIZE - 13, 88, 13, 0, 392, 148, 22, true, true);
				int menuTopLeft = GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE - 115 + height / 2 - 4;
				int posX = GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + Math.min(this.ticksSinceSelection * 10, 133) - 134;
				int posX2 = (int) (GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + Math.min(this.ticksSinceSelection * 1.25F, 15) - 15);
				int fontPosY = menuTopLeft + GuiCelestialSelection.BORDER_EDGE_SIZE + this.fontRenderer.FONT_HEIGHT / 2 - 2;
				this.drawTexturedModalRect(posX, menuTopLeft + 12, 133, 196, 0, 0, 266, 392, false, false);

				// str = this.selectedBody.getLocalizedName();
				// this.fontRendererObj.drawString(str, posX + 20, fontPosY, GCCoreUtil.to32BitColor(255, 255, 255, 255));

				str = TranslateUtilities.translate("gui.message.daynightcycle.name") + ":";
				this.fontRenderer.drawString(str, posX + 5, fontPosY + 14, ColorUtil.to32BitColor(255, 150, 200, 255));
				str = TranslateUtilities.translate("gui.message." + this.selectedBody.getName() + ".daynightcycle.0.name");
				this.fontRenderer.drawString(str, posX + 10, fontPosY + 25, ColorUtil.to32BitColor(255, 255, 255, 255));
				str = TranslateUtilities.translate("gui.message." + this.selectedBody.getName() + ".daynightcycle.1.name");
				if (!str.isEmpty()) {
					this.fontRenderer.drawString(str, posX + 10, fontPosY + 36, ColorUtil.to32BitColor(255, 255, 255, 255));
				}

				str = TranslateUtilities.translate("gui.message.surfacegravity.name") + ":";
				this.fontRenderer.drawString(str, posX + 5, fontPosY + 50, ColorUtil.to32BitColor(255, 150, 200, 255));
				str = TranslateUtilities.translate("gui.message." + this.selectedBody.getName() + ".surfacegravity.0.name");
				this.fontRenderer.drawString(str, posX + 10, fontPosY + 61, ColorUtil.to32BitColor(255, 255, 255, 255));
				str = TranslateUtilities.translate("gui.message." + this.selectedBody.getName() + ".surfacegravity.1.name");
				if (!str.isEmpty()) {
					this.fontRenderer.drawString(str, posX + 10, fontPosY + 72, ColorUtil.to32BitColor(255, 255, 255, 255));
				}

				str = TranslateUtilities.translate("gui.message.surfacecomposition.name") + ":";
				this.fontRenderer.drawString(str, posX + 5, fontPosY + 88, ColorUtil.to32BitColor(255, 150, 200, 255));
				str = TranslateUtilities.translate("gui.message." + this.selectedBody.getName() + ".surfacecomposition.0.name");
				this.fontRenderer.drawString(str, posX + 10, fontPosY + 99, ColorUtil.to32BitColor(255, 255, 255, 255));
				str = TranslateUtilities.translate("gui.message." + this.selectedBody.getName() + ".surfacecomposition.1.name");
				if (!str.isEmpty()) {
					this.fontRenderer.drawString(str, posX + 10, fontPosY + 110, ColorUtil.to32BitColor(255, 255, 255, 255));
				}

				str = TranslateUtilities.translate("gui.message.atmosphere.name") + ":";
				this.fontRenderer.drawString(str, posX + 5, fontPosY + 126, ColorUtil.to32BitColor(255, 150, 200, 255));
				str = TranslateUtilities.translate("gui.message." + this.selectedBody.getName() + ".atmosphere.0.name");
				this.fontRenderer.drawString(str, posX + 10, fontPosY + 137, ColorUtil.to32BitColor(255, 255, 255, 255));
				str = TranslateUtilities.translate("gui.message." + this.selectedBody.getName() + ".atmosphere.1.name");
				if (!str.isEmpty()) {
					this.fontRenderer.drawString(str, posX + 10, fontPosY + 148, ColorUtil.to32BitColor(255, 255, 255, 255));
				}

				str = TranslateUtilities.translate("gui.message.meansurfacetemp.name") + ":";
				this.fontRenderer.drawString(str, posX + 5, fontPosY + 165, ColorUtil.to32BitColor(255, 150, 200, 255));
				str = TranslateUtilities.translate("gui.message." + this.selectedBody.getName() + ".meansurfacetemp.0.name");
				this.fontRenderer.drawString(str, posX + 10, fontPosY + 176, ColorUtil.to32BitColor(255, 255, 255, 255));
				str = TranslateUtilities.translate("gui.message." + this.selectedBody.getName() + ".meansurfacetemp.1.name");
				if (!str.isEmpty()) {
					this.fontRenderer.drawString(str, posX + 10, fontPosY + 187, ColorUtil.to32BitColor(255, 255, 255, 255));
				}

				this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain0);
				GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);
				this.drawTexturedModalRect(posX2, menuTopLeft + 12, 17, 199, 439, 0, 32, 399, false, false);
				// this.drawRectD(posX2 + 16.5, menuTopLeft + 13, posX + 131, menuTopLeft + 14, GCCoreUtil.to32BitColor(120, 0, (int) (0.6F * 255), 255));
			}
		} else {
			String str;
			// Catalog:
			this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain0);
			GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);
			this.drawTexturedModalRect(GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE, 74, 11, 0, 392, 148, 22, false, false);
			str = TranslateUtilities.translate("gui.message.catalog.name").toUpperCase();
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.fontRenderer.drawString(str, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 40 - fontRenderer.getStringWidth(str) / 2, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 1,
					ColorUtil.to32BitColor(255, 255, 255, 255));

			int scale = (int) Math.min(95, this.ticksSinceMenuOpen * 12.0F);

			// Parent frame:
			GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);
			this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain0);
			this.drawTexturedModalRect(GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE - 95 + scale, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 12, 95, 41, 0, 436, 95, 41, false, false);
			str = this.isZoomed() ? this.selectedBody.getLocalizedName() : this.getParentName();
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.fontRenderer.drawString(str, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 9 - 95 + scale, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 34,
					ColorUtil.to32BitColor(255, 255, 255, 255));
			GL11.glColor4f(1, 1, 0, 1);
			this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain0);

			// Grandparent frame:
			this.drawTexturedModalRect(GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 2 - 95 + scale, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 14, 93, 17, 95, 436, 93, 17, false,
					false);
			str = this.isZoomed() ? this.getParentName() : this.getGrandparentName();
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.fontRenderer.drawString(str, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 7 - 95 + scale, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 16,
					ColorUtil.to32BitColor(255, 120, 120, 120));
			GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);

			List<CelestialBody> children = this.getChildren(this.isZoomed() ? this.selectedBody : this.selectedParent);

			if (showGalaxies == false) {
				drawChildren(children, 0, 0);
			}

			if (this.mapMode) {
				this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain0);
				GL11.glColor4f(1.0F, 0.0F, 0.0F, 1);
				this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain0);
				this.drawTexturedModalRect(width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 74, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE, 74, 11, 0, 392, 148, 22, true, false);
				str = TranslateUtilities.translate("gui.message.exit.name").toUpperCase();
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				this.fontRenderer.drawString(str, width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 40 - fontRenderer.getStringWidth(str) / 2, GuiCelestialSelection.BORDER_SIZE
						+ GuiCelestialSelection.BORDER_EDGE_SIZE + 1, ColorUtil.to32BitColor(255, 255, 255, 255));
			}

			if (this.selectedBody != null) {
				// Right-hand bar (basic selectionState info)
				this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain1);
				GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);

				if (this.selectedBody instanceof Satellite) {
					Satellite selectedSatellite = (Satellite) this.selectedBody;
					int stationListSize = this.spaceStationMap.get(getSatelliteParentID(selectedSatellite)).size();

					this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain1);
					int max = Math.min((this.height / 2) / 14, stationListSize);
					this.drawTexturedModalRect(width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 95, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE, 95, 53,
							this.selectedStationOwner.length() == 0 ? 95 : 0, 186, 95, 53, false, false);
					if (this.spaceStationListOffset <= 0) {
						GL11.glColor4f(0.65F, 0.65F, 0.65F, 1);
					} else {
						GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);
					}
					this.drawTexturedModalRect(width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 85, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 45, 61, 4, 0, 239, 61, 4, false,
							false);
					if (max + spaceStationListOffset >= stationListSize) {
						GL11.glColor4f(0.65F, 0.65F, 0.65F, 1);
					} else {
						GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);
					}
					this.drawTexturedModalRect(width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 85, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 49 + max * 14, 61, 4, 0, 239, 61, 4,
							false, true);
					GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);

					if (this.spaceStationMap.get(getSatelliteParentID(selectedSatellite)).get(this.selectedStationOwner) == null) {
						str = TranslateUtilities.translate("gui.message.select_ss.name");
						this.drawSplitString(str, width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 47, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 20, 91,
								ColorUtil.to32BitColor(255, 255, 255, 255), false, false);
					} else {
						str = TranslateUtilities.translate("gui.message.ss_owner.name");
						this.fontRenderer.drawString(str, width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 85, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 18,
								ColorUtil.to32BitColor(255, 255, 255, 255));
						str = this.selectedStationOwner;
						this.fontRenderer.drawString(str, width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 47 - this.fontRenderer.getStringWidth(str) / 2, GuiCelestialSelection.BORDER_SIZE
								+ GuiCelestialSelection.BORDER_EDGE_SIZE + 30, ColorUtil.to32BitColor(255, 255, 255, 255));
					}

					Iterator<Map.Entry<String, StationDataGUI>> it = this.spaceStationMap.get(getSatelliteParentID(selectedSatellite)).entrySet().iterator();
					int i = 0;
					int j = 0;
					while (it.hasNext() && i < max) {
						Map.Entry<String, StationDataGUI> e = it.next();

						if (j >= this.spaceStationListOffset) {
							this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain0);
							GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);
							int xOffset = 0;

							if (e.getKey().equalsIgnoreCase(this.selectedStationOwner)) {
								xOffset -= 5;
							}

							this.drawTexturedModalRect(width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 95 + xOffset, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 50 + i * 14, 93,
									12, 95, 464, 93, 12, true, false);
							str = "";
							String str0 = e.getValue().getStationName();
							int point = 0;
							while (this.fontRenderer.getStringWidth(str) < 80 && point < str0.length()) {
								str = str + str0.substring(point, point + 1);
								point++;
							}
							if (this.fontRenderer.getStringWidth(str) >= 80) {
								str = str.substring(0, str.length() - 3);
								str = str + "...";
							}
							this.fontRenderer.drawString(str, width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 88 + xOffset,
									GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 52 + i * 14, ColorUtil.to32BitColor(255, 255, 255, 255));
							i++;
						}
						j++;
					}
				} else {
					this.drawTexturedModalRect(width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 96, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE, 96, 139, 63, 0, 96, 139, false, false);
				}

				if (this.canCreateSpaceStation(this.selectedBody) && (!(this.selectedBody instanceof Satellite))) {
					GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);
					this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain1);
					int canCreateLength = Math.max(0, this.drawSplitString(TranslateUtilities.translate("gui.message.can_create_space_station.name"), 0, 0, 91, 0, true, true) - 2);
					canCreateOffset = canCreateLength * this.fontRenderer.FONT_HEIGHT;

					this.drawTexturedModalRect(width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 95, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 134, 93, 4, 159, 102, 93, 4, false,
							false);
					for (int barY = 0; barY < canCreateLength; ++barY) {
						this.drawTexturedModalRect(width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 95, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 138 + barY
								* this.fontRenderer.FONT_HEIGHT, 93, this.fontRenderer.FONT_HEIGHT, 159, 106, 93, this.fontRenderer.FONT_HEIGHT, false, false);
					}
					this.drawTexturedModalRect(width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 95, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 138 + canCreateOffset, 93, 43, 159,
							106, 93, 43, false, false);
					this.drawTexturedModalRect(width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 79, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 129, 61, 4, 0, 170, 61, 4, false,
							false);

					SpaceStationRecipe recipe = WorldUtil.getSpaceStationRecipe(this.selectedBody.getDimensionID());
					if (recipe != null) {
						GL11.glColor4f(0.0F, 1.0F, 0.1F, 1);
						boolean validInputMaterials = true;

						int i = 0;
						for (Map.Entry<Object, Integer> e : recipe.getInput().entrySet()) {
							Object next = e.getKey();
							int xPos = (int) (width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 95 + i * 93 / (double) recipe.getInput().size() + 5);
							int yPos = GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 154 + canCreateOffset;

							if (next instanceof ItemStack) {
								int amount = getAmountInInventory((ItemStack) next);
								RenderHelper.enableGUIStandardItemLighting();
								ItemStack toRender = ((ItemStack) next).copy();
								this.itemRender.renderItemAndEffectIntoGUI(toRender, xPos, yPos);
								this.itemRender.renderItemOverlayIntoGUI(mc.fontRenderer, toRender, xPos, yPos, null);
								RenderHelper.disableStandardItemLighting();
								GL11.glEnable(GL11.GL_BLEND);

								if (mousePosX >= xPos && mousePosX <= xPos + 16 && mousePosY >= yPos && mousePosY <= yPos + 16) {
									GL11.glDepthMask(true);
									GL11.glEnable(GL11.GL_DEPTH_TEST);
									GL11.glPushMatrix();
									GL11.glTranslatef(0, 0, 300);
									int k = this.fontRenderer.getStringWidth(((ItemStack) next).getDisplayName());
									int j2 = mousePosX - k / 2;
									int k2 = mousePosY - 12;
									int i1 = 8;

									if (j2 + k > this.width) {
										j2 -= (j2 - this.width + k);
									}

									if (k2 + i1 + 6 > this.height) {
										k2 = this.height - i1 - 6;
									}

									int j1 = ColorUtil.to32BitColor(190, 0, 153, 255);
									this.drawGradientRect(j2 - 3, k2 - 4, j2 + k + 3, k2 - 3, j1, j1);
									this.drawGradientRect(j2 - 3, k2 + i1 + 3, j2 + k + 3, k2 + i1 + 4, j1, j1);
									this.drawGradientRect(j2 - 3, k2 - 3, j2 + k + 3, k2 + i1 + 3, j1, j1);
									this.drawGradientRect(j2 - 4, k2 - 3, j2 - 3, k2 + i1 + 3, j1, j1);
									this.drawGradientRect(j2 + k + 3, k2 - 3, j2 + k + 4, k2 + i1 + 3, j1, j1);
									int k1 = ColorUtil.to32BitColor(170, 0, 153, 255);
									int l1 = (k1 & 16711422) >> 1 | k1 & -16777216;
									this.drawGradientRect(j2 - 3, k2 - 3 + 1, j2 - 3 + 1, k2 + i1 + 3 - 1, k1, l1);
									this.drawGradientRect(j2 + k + 2, k2 - 3 + 1, j2 + k + 3, k2 + i1 + 3 - 1, k1, l1);
									this.drawGradientRect(j2 - 3, k2 - 3, j2 + k + 3, k2 - 3 + 1, k1, k1);
									this.drawGradientRect(j2 - 3, k2 + i1 + 2, j2 + k + 3, k2 + i1 + 3, l1, l1);

									this.fontRenderer.drawString(((ItemStack) next).getDisplayName(), j2, k2, ColorUtil.to32BitColor(255, 255, 255, 255));

									GL11.glPopMatrix();
								}

								str = "" + e.getValue();
								boolean valid = amount >= e.getValue();
								if (!valid && validInputMaterials) {
									validInputMaterials = false;
								}
								int color = valid | this.mc.player.capabilities.isCreativeMode ? ColorUtil.to32BitColor(255, 0, 255, 0) : ColorUtil.to32BitColor(255, 255, 0, 0);
								this.fontRenderer.drawString(str, xPos + 8 - this.fontRenderer.getStringWidth(str) / 2, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 170 + canCreateOffset, color);
							} else if (next instanceof Collection) {
								Collection<ItemStack> items = (Collection<ItemStack>) next;

								int amount = 0;

								for (ItemStack stack : items) {
									amount += getAmountInInventory(stack);
								}

								RenderHelper.enableGUIStandardItemLighting();

								Iterator<ItemStack> it = items.iterator();
								int count = 0;
								int toRenderIndex = (this.ticksSinceMenuOpen / 20) % items.size();
								ItemStack toRender = null;
								while (it.hasNext()) {
									ItemStack stack = it.next();
									if (count == toRenderIndex) {
										toRender = stack;
										break;
									}
									count++;
								}

								if (toRender == null) {
									continue;
								}

								this.itemRender.renderItemAndEffectIntoGUI(toRender, xPos, yPos);
								this.itemRender.renderItemOverlayIntoGUI(mc.fontRenderer, toRender, xPos, yPos, null);
								RenderHelper.disableStandardItemLighting();
								GL11.glEnable(GL11.GL_BLEND);

								if (mousePosX >= xPos && mousePosX <= xPos + 16 && mousePosY >= yPos && mousePosY <= yPos + 16) {
									GL11.glDepthMask(true);
									GL11.glEnable(GL11.GL_DEPTH_TEST);
									GL11.glPushMatrix();
									GL11.glTranslatef(0, 0, 300);
									int k = this.fontRenderer.getStringWidth(toRender.getDisplayName());
									int j2 = mousePosX - k / 2;
									int k2 = mousePosY - 12;
									int i1 = 8;

									if (j2 + k > this.width) {
										j2 -= (j2 - this.width + k);
									}

									if (k2 + i1 + 6 > this.height) {
										k2 = this.height - i1 - 6;
									}

									int j1 = ColorUtil.to32BitColor(190, 0, 153, 255);
									this.drawGradientRect(j2 - 3, k2 - 4, j2 + k + 3, k2 - 3, j1, j1);
									this.drawGradientRect(j2 - 3, k2 + i1 + 3, j2 + k + 3, k2 + i1 + 4, j1, j1);
									this.drawGradientRect(j2 - 3, k2 - 3, j2 + k + 3, k2 + i1 + 3, j1, j1);
									this.drawGradientRect(j2 - 4, k2 - 3, j2 - 3, k2 + i1 + 3, j1, j1);
									this.drawGradientRect(j2 + k + 3, k2 - 3, j2 + k + 4, k2 + i1 + 3, j1, j1);
									int k1 = ColorUtil.to32BitColor(170, 0, 153, 255);
									int l1 = (k1 & 16711422) >> 1 | k1 & -16777216;
									this.drawGradientRect(j2 - 3, k2 - 3 + 1, j2 - 3 + 1, k2 + i1 + 3 - 1, k1, l1);
									this.drawGradientRect(j2 + k + 2, k2 - 3 + 1, j2 + k + 3, k2 + i1 + 3 - 1, k1, l1);
									this.drawGradientRect(j2 - 3, k2 - 3, j2 + k + 3, k2 - 3 + 1, k1, k1);
									this.drawGradientRect(j2 - 3, k2 + i1 + 2, j2 + k + 3, k2 + i1 + 3, l1, l1);

									this.fontRenderer.drawString(toRender.getDisplayName(), j2, k2, ColorUtil.to32BitColor(255, 255, 255, 255));

									GL11.glPopMatrix();
								}

								str = "" + e.getValue();
								boolean valid = amount >= e.getValue();
								if (!valid && validInputMaterials) {
									validInputMaterials = false;
								}
								int color = valid | this.mc.player.capabilities.isCreativeMode ? ColorUtil.to32BitColor(255, 0, 255, 0) : ColorUtil.to32BitColor(255, 255, 0, 0);
								this.fontRenderer.drawString(str, xPos + 8 - this.fontRenderer.getStringWidth(str) / 2, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 170 + canCreateOffset, color);
							}

							i++;
						}

						if (validInputMaterials || this.mc.player.capabilities.isCreativeMode) {
							GL11.glColor4f(0.0F, 1.0F, 0.1F, 1);
						} else {
							GL11.glColor4f(1.0F, 0.0F, 0.0F, 1);
						}

						this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain1);

						if (!this.mapMode) {
							if (mousePosX >= width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 95 && mousePosX <= width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE
									&& mousePosY >= GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 182 + canCreateOffset
									&& mousePosY <= GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 182 + 12 + canCreateOffset) {
								this.drawTexturedModalRect(width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 95, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 182 + canCreateOffset,
										93, 12, 0, 174, 93, 12, false, false);
							}
						}

						this.drawTexturedModalRect(width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 95, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 182 + canCreateOffset, 93, 12,
								0, 174, 93, 12, false, false);

						int color = (int) ((Math.sin(this.ticksSinceMenuOpen / 5.0) * 0.5 + 0.5) * 255);
						this.drawSplitString(TranslateUtilities.translate("gui.message.can_create_space_station.name"), width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 48, GuiCelestialSelection.BORDER_SIZE
								+ GuiCelestialSelection.BORDER_EDGE_SIZE + 137, 91, ColorUtil.to32BitColor(255, color, 255, color), true, false);

						if (!mapMode) {
							this.drawSplitString(TranslateUtilities.translate("gui.message.create_ss.name").toUpperCase(), width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 48, GuiCelestialSelection.BORDER_SIZE
									+ GuiCelestialSelection.BORDER_EDGE_SIZE + 185 + canCreateOffset, 91, ColorUtil.to32BitColor(255, 255, 255, 255), false, false);
						}
					} else {
						this.drawSplitString(TranslateUtilities.translate("gui.message.cannot_create_space_station.name"), width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 48, GuiCelestialSelection.BORDER_SIZE
								+ GuiCelestialSelection.BORDER_EDGE_SIZE + 138, 91, ColorUtil.to32BitColor(255, 255, 255, 255), true, false);
					}
				}

				// Catalog overlay
				this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain0);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.3F - Math.min(0.3F, this.ticksSinceSelection / 50.0F));
				this.drawTexturedModalRect(GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE, 74, 11, 0, 392, 148, 22, false, false);
				str = TranslateUtilities.translate("gui.message.catalog.name").toUpperCase();
				this.fontRenderer.drawString(str, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 40 - fontRenderer.getStringWidth(str) / 2, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 1,
						ColorUtil.to32BitColor(255, 255, 255, 255));

				// Top bar title:
				this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain0);
				GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);
				if (this.selectedBody instanceof Satellite) {
					if (this.selectedStationOwner.length() == 0 || !this.selectedStationOwner.equalsIgnoreCase(this.mc.player.getGameProfile().getName())) {
						GL11.glColor4f(1.0F, 0.0F, 0.0F, 1);
					} else {
						GL11.glColor4f(0.0F, 1.0F, 0.0F, 1);
					}
					this.drawTexturedModalRect(width / 2 - 47, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE, 94, 11, 0, 414, 188, 22, false, false);
				} else {
					this.drawTexturedModalRect(width / 2 - 47, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE, 94, 11, 0, 414, 188, 22, false, false);
				}
				if (this.selectedBody.getTierRequirement() >= 0 && (!(this.selectedBody instanceof Satellite))) {
					boolean canReach;
					if (!this.selectedBody.getReachable() || (this.possibleBodies != null && !this.possibleBodies.contains(this.selectedBody))) {
						canReach = false;
						GL11.glColor4f(1.0F, 0.0F, 0.0F, 1);
					} else {
						canReach = true;
						GL11.glColor4f(0.0F, 1.0F, 0.0F, 1);
					}
					this.drawTexturedModalRect(width / 2 - 30, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 11, 30, 11, 0, 414, 60, 22, false, false);
					this.drawTexturedModalRect(width / 2, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 11, 30, 11, 128, 414, 60, 22, false, false);
					str = GCCoreUtil.translateWithFormat("gui.message.tier.name", this.selectedBody.getTierRequirement() == 0 ? "?" : this.selectedBody.getTierRequirement());
					this.fontRenderer.drawString(str, width / 2 - this.fontRenderer.getStringWidth(str) / 2, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 13, canReach ? ColorUtil.to32BitColor(255, 140, 140, 140)
							: ColorUtil.to32BitColor(255, 255, 100, 100));
				}

				str = this.selectedBody.getLocalizedName();

				if (this.selectedBody instanceof Satellite) {
					str = TranslateUtilities.translate("gui.message.rename.name").toUpperCase();
				}

				this.fontRenderer.drawString(str, width / 2 - this.fontRenderer.getStringWidth(str) / 2, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 2, ColorUtil.to32BitColor(255, 255, 255, 255));

				// Catalog wedge:
				this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain0);
				GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);
				this.drawTexturedModalRect(GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 4, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE, 83, 12, 0, 477, 83, 12, false, false);

				if (!this.mapMode) {
					if (!this.selectedBody.getReachable() || (this.possibleBodies != null && !this.possibleBodies.contains(this.selectedBody)) || (this.selectedBody instanceof Satellite && this.selectedStationOwner.equals(""))) {
						GL11.glColor4f(1.0F, 0.0F, 0.0F, 1);
					} else {
						GL11.glColor4f(0.0F, 1.0F, 0.0F, 1);
					}

					this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain0);
					this.drawTexturedModalRect(width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 74, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE, 74, 11, 0, 392, 148, 22, true, false);
					str = TranslateUtilities.translate("gui.message.launch.name").toUpperCase();
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					this.fontRenderer.drawString(str, width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 40 - fontRenderer.getStringWidth(str) / 2, GuiCelestialSelection.BORDER_SIZE
							+ GuiCelestialSelection.BORDER_EDGE_SIZE + 2, ColorUtil.to32BitColor(255, 255, 255, 255));
				}

				if (this.selectionState == EnumSelection.SELECTED && !(this.selectedBody instanceof Satellite)) {
					handledSliderPos = true;

					int sliderPos = this.zoomTooltipPos;
					if (zoomTooltipPos != 38) {
						sliderPos = Math.min(this.ticksSinceSelection * 2, 38);
						this.zoomTooltipPos = sliderPos;
					}

					GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);
					this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain0);
					this.drawTexturedModalRect(width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 182, height - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - sliderPos, 83, 38,
							512 - 166, 512 - 76, 166, 76, true, false);

					boolean flag0 = GalaxyRegistry.getSatellitesForCelestialBody(this.selectedBody).size() > 0;
					boolean flag1 = this.selectedBody instanceof Planet && GalaxyRegistry.getMoonsForPlanet((Planet) this.selectedBody).size() > 0;
					if (flag0 && flag1) {
						this.drawSplitString(TranslateUtilities.translate("gui.message.click_again.0.name"), width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 182 + 41, height - GuiCelestialSelection.BORDER_SIZE
								- GuiCelestialSelection.BORDER_EDGE_SIZE + 2 - sliderPos, 79, ColorUtil.to32BitColor(255, 150, 150, 150), false, false);
					} else if (!flag0 && flag1) {
						this.drawSplitString(TranslateUtilities.translate("gui.message.click_again.1.name"), width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 182 + 41, height - GuiCelestialSelection.BORDER_SIZE
								- GuiCelestialSelection.BORDER_EDGE_SIZE + 6 - sliderPos, 79, ColorUtil.to32BitColor(255, 150, 150, 150), false, false);
					} else if (flag0) {
						this.drawSplitString(TranslateUtilities.translate("gui.message.click_again.2.name"), width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 182 + 41, height - GuiCelestialSelection.BORDER_SIZE
								- GuiCelestialSelection.BORDER_EDGE_SIZE + 6 - sliderPos, 79, ColorUtil.to32BitColor(255, 150, 150, 150), false, false);
					} else {
						this.drawSplitString(TranslateUtilities.translate("gui.message.click_again.3.name"), width - GuiCelestialSelection.BORDER_SIZE - GuiCelestialSelection.BORDER_EDGE_SIZE - 182 + 41, height - GuiCelestialSelection.BORDER_SIZE
								- GuiCelestialSelection.BORDER_EDGE_SIZE + 11 - sliderPos, 79, ColorUtil.to32BitColor(255, 150, 150, 150), false, false);
					}

				}

				if (this.selectedBody instanceof Satellite && renamingSpaceStation) {
					this.drawDefaultBackground();
					GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);
					this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain1);
					this.drawTexturedModalRect(width / 2 - 90, this.height / 2 - 38, 179, 67, 159, 0, 179, 67, false, false);
					this.drawTexturedModalRect(width / 2 - 90 + 4, this.height / 2 - 38 + 2, 171, 10, 159, 92, 171, 10, false, false);
					this.drawTexturedModalRect(width / 2 - 90 + 8, this.height / 2 - 38 + 18, 161, 13, 159, 67, 161, 13, false, false);
					this.drawTexturedModalRect(width / 2 - 90 + 17, this.height / 2 - 38 + 59, 72, 12, 159, 80, 72, 12, true, false);
					this.drawTexturedModalRect(width / 2, this.height / 2 - 38 + 59, 72, 12, 159, 80, 72, 12, false, false);
					str = TranslateUtilities.translate("gui.message.assign_name.name");
					this.fontRenderer.drawString(str, width / 2 - this.fontRenderer.getStringWidth(str) / 2, this.height / 2 - 35, ColorUtil.to32BitColor(255, 255, 255, 255));
					str = TranslateUtilities.translate("gui.message.apply.name");
					this.fontRenderer.drawString(str, width / 2 - this.fontRenderer.getStringWidth(str) / 2 - 36, this.height / 2 + 23, ColorUtil.to32BitColor(255, 255, 255, 255));
					str = TranslateUtilities.translate("gui.message.cancel.name");
					this.fontRenderer.drawString(str, width / 2 + 36 - this.fontRenderer.getStringWidth(str) / 2, this.height / 2 + 23, ColorUtil.to32BitColor(255, 255, 255, 255));

					if (this.renamingString == null) {
						Satellite selectedSatellite = (Satellite) this.selectedBody;
						String playerName = MCUtilities.getClient().player.getGameProfile().getName();
						this.renamingString = this.spaceStationMap.get(getSatelliteParentID(selectedSatellite)).get(playerName).getStationName();
						if (this.renamingString == null) {
							this.renamingString = this.spaceStationMap.get(getSatelliteParentID(selectedSatellite)).get(playerName.toLowerCase()).getStationName();
						}
						if (this.renamingString == null) {
							this.renamingString = "";
						}
					}

					str = this.renamingString;
					String str0 = this.renamingString;

					if ((this.ticksSinceMenuOpen / 10) % 2 == 0) {
						str0 += "_";
					}

					this.fontRenderer.drawString(str0, width / 2 - this.fontRenderer.getStringWidth(str) / 2, this.height / 2 - 17, ColorUtil.to32BitColor(255, 255, 255, 255));
				}

				// this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain0);
				// GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);
			}
		}

		if (!handledSliderPos) {
			this.zoomTooltipPos = 0;
		}
	}

	@Override
	public void drawScreen(int mousePosX, int mousePosY, float partialTicks) {
		this.mousePosX = mousePosX;
		this.mousePosY = mousePosY;
		this.partialTicks = partialTicks;
		super.drawScreen(mousePosX, mousePosY, partialTicks);
	}

	@Override
	protected void mouseClicked(int x, int y, int button) throws IOException {
		if (Config.CUSTOM_GALAXIES) {
			int xPos;
			int yPos;

			xPos = GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 0;
			yPos = GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 10;
			if (this.showGalaxies == false && x >= xPos && x <= xPos + 100 && y >= yPos && y <= yPos + 25)
				this.showGalaxies = true;
			else if (this.showGalaxies && x >= xPos && x <= xPos + 100 && y >= yPos && y <= yPos + 25)
				this.showGalaxies = false;

			if (this.showGalaxies == false) {
				super.mouseClicked(x, y, button);
				this.selectedParent = this.currentGalaxyMainSystem;
			}

			if (this.showGalaxies) {
				for (int i = 0; i < this.galaxies.size(); i++) {
					int xOffset = 0;
					int yOffset = 45;

					xPos = GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 2 + xOffset;
					yPos = GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 5 + i * 14 + yOffset;

					if (x >= xPos && x <= xPos + 93 && y >= yPos && y <= yPos + 12) {
						boolean clicked = false;
						if (i == 0) {
							this.currentGalaxyName = this.galaxies.get(i);
							currentGalaxyMainSystem = GalacticraftCore.solarSystemSol;
							clicked = true;
						} else {
							this.currentGalaxyName = this.galaxies.get(i);
							for (SolarSystem system : GalaxyRegistry.getRegisteredSolarSystems().values())
								if (system.getUnlocalizedParentGalaxyName().equalsIgnoreCase(this.currentGalaxyName))
									this.currentGalaxyMainSystem = system;
							clicked = true;
						}
						if (clicked) {
							this.drawScreen(this.mousePosX, this.mousePosY, this.partialTicks);
							this.selectedParent = this.currentGalaxyMainSystem;
							this.selectedBody = null;
							this.showGalaxies = false;
						}
					}
				}
			}
		} else
			super.mouseClicked(x, y, button);
	}
}
