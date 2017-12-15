package com.mjr.extraplanets.client.gui.screen;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collections;
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
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.client.gui.screen.GuiCelestialSelection;
import micdoodle8.mods.galacticraft.core.util.ColorUtil;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mjr.extraplanets.ExtraPlanets_SolarSystems;
import com.mjr.extraplanets.world.CustomWorldProviderSpace;

public class CustomCelestaialSelection extends GuiCelestialSelection {
	private List<String> galaxies = new ArrayList<String>();
	private String currentGalaxyName = "";

	private int mousePosX = 0;
	private int mousePosY = 0;
	private float partialTicks = 0;

	public CustomCelestaialSelection(boolean mapMode, List<CelestialBody> possibleBodies, boolean canCreateStations) {
		super(mapMode, possibleBodies, canCreateStations);
		this.galaxies.add("galaxy.milky_way");
		this.galaxies.add("galaxy.whirlpool");
		this.galaxies.add("galaxy.test2");
		this.galaxies.add("galaxy.test3");
		this.galaxies.add("galaxy.test4");
		this.galaxies.add("galaxy.test5");
		this.currentGalaxyName = "galaxy.milky_way";
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
						if(!this.isZoomed()){
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

	@Override
	public void drawButtons(int mousePosX, int mousePosY) {
		if (this.viewState != EnumView.PROFILE) {
			if (this.selectedBody != null) {
				GL11.glColor4f(0.0F, 0.6F, 1.0F, 1);
				this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain1);
				int yOffset = 27;
				int widthSizeOffset = 75;
				int xOffset = (this.width - 270) - (GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE);
				this.drawTexturedModalRect(xOffset, yOffset, 93 + widthSizeOffset, 4, 159, 102, 93, 4, false, false);
				for (int barY = 0; barY < 25; ++barY) {
					this.drawTexturedModalRect(xOffset, yOffset + barY * this.fontRendererObj.FONT_HEIGHT + 4, 93 + widthSizeOffset, this.fontRendererObj.FONT_HEIGHT, 159, 106, 93, this.fontRendererObj.FONT_HEIGHT, false, false);
				}
				for (int barx = 0; barx < 1; ++barx) {
					this.drawTexturedModalRect(xOffset + barx, yOffset * this.fontRendererObj.FONT_HEIGHT + 10, 93 + widthSizeOffset, this.fontRendererObj.FONT_HEIGHT / 2, 159, 106, 1, this.fontRendererObj.FONT_HEIGHT, false, false);
				}
				if (!(this.selectedBody instanceof Star)) {
					WorldProvider temp = null;
					if (this.selectedBody.getReachable() && !this.selectedBody.getName().contains("overworld") && !(this.selectedBody instanceof Satellite))
						temp = WorldUtil.getProviderForDimensionClient(this.selectedBody.getDimensionID());
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
					this.drawString(this.fontRendererObj, "Temperature: " + (this.selectedBody.getReachable() ? temperature + "°C" : "Unknown"), xOffset + 10, yOffset + 70, 14737632);
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

			int scale = (int) Math.min(95, this.ticksSinceMenuOpen * 12.0F);
			String str;

			for (int i = 0; i < this.galaxies.size(); i++) {
				String child = this.galaxies.get(i);
				int xOffset = 100;

				scale = (int) Math.min(95.0F, Math.max(0.0F, (this.ticksSinceMenuOpen * 25.0F) - 95 * i));

				this.mc.renderEngine.bindTexture(GuiCelestialSelection.guiMain0);
				GL11.glColor4f(0.0F, 0.6F, 0.0F, scale / 95.0F);
				this.drawTexturedModalRect(GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 3 + xOffset, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 6 + i * 14, 86, 10, 0, 489, 86, 10,
						false, false);
				GL11.glColor4f(0.0F, 0.6F, 1.0F, scale / 95.0F);
				this.drawTexturedModalRect(GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 2 + xOffset, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 5 + i * 14, 93, 12, 95, 464, 93, 12,
						false, false);

				if (scale > 0) {
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					str = child;
					int color = 14737632;
					this.fontRendererObj.drawString(str, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 7 + xOffset, GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 8 + i * 14, color);
				}
			}

		}
		super.drawButtons(mousePosX, mousePosY);
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
		super.mouseClicked(x, y, button);
		int xPos;
		int yPos;

		for (int i = 0; i < this.galaxies.size(); i++) {
			int xOffset = 100;

			xPos = GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 2 + xOffset;
			yPos = GuiCelestialSelection.BORDER_SIZE + GuiCelestialSelection.BORDER_EDGE_SIZE + 5 + i * 14;

			if (x >= xPos && x <= xPos + 93 && y >= yPos && y <= yPos + 12) {
				boolean clicked = false;
				if (i == 0) {
					this.selectedParent = GalacticraftCore.solarSystemSol;
					clicked = true;
				}
				if (i == 1) {
					this.selectedParent = ExtraPlanets_SolarSystems.test;
					clicked = true;
				}
				if (clicked) {
					this.currentGalaxyName = this.galaxies.get(i);
					this.drawScreen(this.mousePosX, this.mousePosY, this.partialTicks);
				}
			}
		}
	}

	private boolean isZoomed() {
		return this.selectionState == EnumSelection.ZOOMED;
	}
}
