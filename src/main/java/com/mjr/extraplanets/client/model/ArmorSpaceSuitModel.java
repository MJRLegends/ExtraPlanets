package com.mjr.extraplanets.client.model;

import micdoodle8.mods.galacticraft.core.util.ClientUtil;
import micdoodle8.mods.galacticraft.core.util.ColorUtil;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
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
import com.mjr.mjrlegendslib.util.MCUtilities;

@SideOnly(Side.CLIENT)
public class ArmorSpaceSuitModel extends ArmorCustomModel {

	public static OBJModel.OBJBakedModel armourModelHead;
	public static OBJModel.OBJBakedModel armourModelBody;

	private final int partType;

	public ArmorSpaceSuitModel(int armorType) {
		partType = armorType;
		updateModel();
	}

	@Override
	public void pre() {
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.shadeModel(GL11.GL_SMOOTH);
		updateModel();
	}

	private void updateModel() {
		if (armourModelHead == null) {
			OBJModel model;
			try {
				model = (OBJModel) ModelLoaderRegistry.getModel(new ResourceLocation(Constants.ASSET_PREFIX, "space_suit.obj"));
				model = (OBJModel) model.process(ImmutableMap.of("flip-v", "true"));
				Function<ResourceLocation, TextureAtlasSprite> spriteFunction = location -> MCUtilities.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());

				armourModelHead = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("SpaceHelmet1", "GlassHelmet"), false), DefaultVertexFormats.ITEM, spriteFunction);
				armourModelBody = (OBJModel.OBJBakedModel) model.bake(
						new OBJModel.OBJState(ImmutableList.of("Amplifier", "Amplifier2", "Amplifier3", "Amplifier4", "Antenna", "AntennaDetector", "DecorationDetail1", "DecorationDetail3", "decorationpipe", "GlassHelmet", "Helix001",
								"HydrogenPipe", "HydrogenTank", "leftboot", "leftsleeve", "leftTrouserleg", "Line001", "NitrogenPipe", "NitrogenTank", "OxygenCapsule1", "OxygenCapsule2", "OxygenPipe", "OxygenTank", "Pipe1", "Pipe2", "Pipe3",
								"Pipe4", "Pipe5", "Pipe6", "Pipe7", "Pipe8", "Pipe9", "Piston1Part1", "Piston1Part2", "Piston2Part1", "Piston2Part2", "Piston3Part1", "Piston3Part2", "Piston4Part1", "Piston4Part2", "rightboot", "Rightsleeve",
								"rightTrouserleg", "SolarDectector", "Spacebreatplate", "SpaceHelmet1", "SpacerAntenna1", "SpacerAntenna2", "SpacerAntenna4", "Spring", "Spring2", "Valvepiston 2", "Valvepiston1"), false), DefaultVertexFormats.ITEM,
						spriteFunction);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void post() {
		GL11.glDisable(GL11.GL_BLEND);
		RenderHelper.enableStandardItemLighting();
	}

	@Override
	public void partHead() {
		if (partType == 0) {
			GL11.glTranslatef(0F, -1.5F, 0F);
			ClientUtil.drawBakedModelColored(armourModelHead, ColorUtil.to32BitColor(255, 255, 255, 255));
		}
	}

	@Override
	public void partBody() {
		if (partType == 1) {
			GL11.glTranslatef(0F, -1.5F, 0F);
			ClientUtil.drawBakedModelColored(armourModelBody, ColorUtil.to32BitColor(255, 255, 255, 255));
		}
	}

	@Override
	public void partRightArm() {
		if (partType == 1) {
			GL11.glTranslatef(0.3125F, -1.375F, 0F);
		}
	}

	@Override
	public void partLeftArm() {
		if (partType == 1) {
			GL11.glTranslatef(-0.3125F, -1.375F, 0F);
		}
	}

	@Override
	public void partRightLeg() {
		GL11.glTranslatef(0.125F, -0.75F, 0F);
		if (partType == 2) {
		}
	}

	@Override
	public void partLeftLeg() {
		GL11.glTranslatef(-0.125F, -0.75F, 0F);
		if (partType == 2) {

		}
	}

}