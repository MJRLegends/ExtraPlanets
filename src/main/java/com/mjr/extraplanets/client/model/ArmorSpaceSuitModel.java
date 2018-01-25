package com.mjr.extraplanets.client.model;

import net.minecraft.client.renderer.GlStateManager;
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
import com.mjr.mjrlegendslib.util.ModelUtilities;

@SideOnly(Side.CLIENT)
public class ArmorSpaceSuitModel extends ArmorCustomModel {

	public static OBJModel.OBJBakedModel armourModelHead;
	public static OBJModel.OBJBakedModel armourModelTanks;
	public static OBJModel.OBJBakedModel armourModelPipes;
	public static OBJModel.OBJBakedModel armourModelHeadGlass;
	public static OBJModel.OBJBakedModel armourModelBody;
	public static OBJModel.OBJBakedModel armourModelBodyTank1;
	public static OBJModel.OBJBakedModel armourModelBodyTank2;
	public static OBJModel.OBJBakedModel armourModelBodyTank3;
	public static OBJModel.OBJBakedModel armourModelLeftArm;
	public static OBJModel.OBJBakedModel armourModelRightArm;
	public static OBJModel.OBJBakedModel armourModelLeftArmSpring;
	public static OBJModel.OBJBakedModel armourModelRightArmSpring;
	public static OBJModel.OBJBakedModel armourModelLeftLeg;
	public static OBJModel.OBJBakedModel armourModelRightLeg;
	public static OBJModel.OBJBakedModel armourModelLeftBoot;
	public static OBJModel.OBJBakedModel armourModelRightBoot;
	public static OBJModel.OBJBakedModel armourModelLeftLegPipes;
	public static OBJModel.OBJBakedModel armourModelRightLegPipes;

	private final int partType;

	public ArmorSpaceSuitModel(int armorSlot) {
		partType = armorSlot;
		updateModel();
	}

	@Override
	public void pre() {
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.shadeModel(GL11.GL_SMOOTH);
		updateModel();
	}

	@SuppressWarnings("deprecation")
	private void updateModel() {
		if (armourModelHead == null) {
			OBJModel model;
			try {
				model = (OBJModel) ModelLoaderRegistry.getModel(new ResourceLocation(Constants.ASSET_PREFIX, "space_suit.obj"));
				model = (OBJModel) model.process(ImmutableMap.of("flip-v", "true"));
				Function<ResourceLocation, TextureAtlasSprite> spriteFunction = location -> MCUtilities.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());

				armourModelHead = (OBJModel.OBJBakedModel) model.bake(
						new OBJModel.OBJState(ImmutableList
								.of("HelmetPart1", "HelmetPart2", "HelmetPart4", "HelmetPart5", "HelmetPart6", "HelmetPart7", "HelmetPart8", "HelmetPart9", "HelmetPart10", "HelmetPart11", "MainPartHelmet", "SpacerAntenna2"), false),
						DefaultVertexFormats.ITEM, spriteFunction);

				armourModelTanks = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("HelmetOxygenCapsule1", "HelmetOxygenCapsule2"), false), DefaultVertexFormats.ITEM, spriteFunction);

				armourModelHeadGlass = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("HelmetPart3"), false), DefaultVertexFormats.ITEM, spriteFunction);

				armourModelPipes = (OBJModel.OBJBakedModel) model.bake(
						new OBJModel.OBJState(ImmutableList.of("BodyPart1", "BodyPart10", "BodyPart11", "BodyPart12", "BodyPart13", "BodyPart14", "BodyPart15", "BodyPart16", "BodyPart17", "BodyPart18", "BodyPart3", "BodyPart4", "BodyPart5",
								"BodyPart6", "BodyPart7", "BodyPart8", "BodyPart9"), false), DefaultVertexFormats.ITEM, spriteFunction);

				armourModelBody = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("BodyPart2"), false), DefaultVertexFormats.ITEM, spriteFunction);

				armourModelBodyTank1 = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("NitrogenTank"), false), DefaultVertexFormats.ITEM, spriteFunction);
				armourModelBodyTank2 = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("OxygenTank"), false), DefaultVertexFormats.ITEM, spriteFunction);
				armourModelBodyTank3 = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("HydrogenTank"), false), DefaultVertexFormats.ITEM, spriteFunction);

				armourModelLeftArm = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("LeftHandPart1"), false), DefaultVertexFormats.ITEM, spriteFunction);

				armourModelRightArm = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("RightHandPart4"), false), DefaultVertexFormats.ITEM, spriteFunction);

				armourModelLeftArmSpring = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("LeftHandPart2", "LeftHandPart3", "LeftHandPart4"), false), DefaultVertexFormats.ITEM, spriteFunction);
				armourModelRightArmSpring = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("RightHandPart1", "RightHandPart2", "RightHandPart3"), false), DefaultVertexFormats.ITEM, spriteFunction);

				armourModelLeftLeg = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("LeftLegPart1"), false), DefaultVertexFormats.ITEM, spriteFunction);

				armourModelRightLeg = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("RightLegPart3"), false), DefaultVertexFormats.ITEM, spriteFunction);

				armourModelLeftLegPipes = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("LeftLegPart2", "LeftLegPart3"), false), DefaultVertexFormats.ITEM, spriteFunction);

				armourModelRightLegPipes = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("RightLegPart2", "RightLegPart4"), false), DefaultVertexFormats.ITEM, spriteFunction);

				armourModelLeftBoot = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("left_boot"), false), DefaultVertexFormats.ITEM, spriteFunction);

				armourModelRightBoot = (OBJModel.OBJBakedModel) model.bake(new OBJModel.OBJState(ImmutableList.of("right_boot"), false), DefaultVertexFormats.ITEM, spriteFunction);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void post() {
		GL11.glDisable(GL11.GL_BLEND);
	}

	@Override
	public void partHead() {
		if (partType == 4) {
			GL11.glTranslatef(0F, -1.525F, -0.005F);
			MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_white.png"));
			ModelUtilities.drawBakedModel(armourModelHead);
			MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_dark_red.png"));
			ModelUtilities.drawBakedModel(armourModelTanks);
			MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_blue_textured.png"));
			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
			ModelUtilities.drawBakedModel(armourModelHeadGlass);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		}
	}

	@Override
	public void partBody() {
		if (partType == 3) {
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef(0F, -1.50F, 0F);
			MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_white.png"));
			ModelUtilities.drawBakedModel(armourModelBody);
			MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_textured.png"));
			ModelUtilities.drawBakedModel(armourModelPipes);
			MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/solar_panel.png"));
			ModelUtilities.drawBakedModel(armourModelBodyTank1);
			MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_dark_red.png"));
			ModelUtilities.drawBakedModel(armourModelBodyTank2);
			MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_blue_textured.png"));
			ModelUtilities.drawBakedModel(armourModelBodyTank3);
		}
	}

	@Override
	public void partRightArm() {
		if (partType == 3) {
			GL11.glTranslatef(-0.3525F, -1.375F, 0F);
			MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_white.png"));
			ModelUtilities.drawBakedModel(armourModelRightArm);
			MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_textured.png"));
			ModelUtilities.drawBakedModel(armourModelRightArmSpring);
		}
	}

	@Override
	public void partLeftArm() {
		if (partType == 3) {
			GL11.glTranslatef(0.3525F, -1.375F, 0F);
			MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_white.png"));
			ModelUtilities.drawBakedModel(armourModelLeftArm);
			MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_textured.png"));
			ModelUtilities.drawBakedModel(armourModelLeftArmSpring);
		}
	}

	@Override
	public void partRightLeg() {
		if (partType == 2 || partType == 1) {
			GL11.glScalef(1F, 1F, 1.4F);
			GL11.glTranslatef(-0.125F, -0.7F, -0.01F);
			MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_white.png"));
			ModelUtilities.drawBakedModel(armourModelLeftLeg);
			MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_textured.png"));
			ModelUtilities.drawBakedModel(armourModelLeftLegPipes);
			MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_dark_grey.png"));
			ModelUtilities.drawBakedModel(armourModelLeftBoot);
		}
	}

	@Override
	public void partLeftLeg() {
		if (partType == 2 || partType == 1) {
			GL11.glScalef(1F, 1F, 1.4F);
			GL11.glTranslatef(0.125F, -0.7F, -0.01F);
			MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_white.png"));
			ModelUtilities.drawBakedModel(armourModelRightLeg);
			MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_textured.png"));
			ModelUtilities.drawBakedModel(armourModelRightLegPipes);
			MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_dark_grey.png"));
			ModelUtilities.drawBakedModel(armourModelRightBoot);

		}
	}
}