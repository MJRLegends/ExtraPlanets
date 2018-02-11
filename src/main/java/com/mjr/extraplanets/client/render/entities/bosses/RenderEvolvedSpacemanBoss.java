package com.mjr.extraplanets.client.render.entities.bosses;

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
import com.mjr.extraplanets.entities.bosses.EntityEvolvedSpacemanBoss;
import com.mjr.mjrlegendslib.util.MCUtilities;
import com.mjr.mjrlegendslib.util.ModelUtilities;

@SideOnly(Side.CLIENT)
public class RenderEvolvedSpacemanBoss extends Render<EntityEvolvedSpacemanBoss> {
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

	public RenderEvolvedSpacemanBoss(RenderManager renderManager) {
		super(renderManager);
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
	protected ResourceLocation getEntityTexture(EntityEvolvedSpacemanBoss par1Entity) {
		return TextureMap.LOCATION_BLOCKS_TEXTURE;
	}

	@Override
	public void doRender(EntityEvolvedSpacemanBoss entity, double x, double y, double z, float entityYaw, float partialTicks) {
		// float pitch = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks;
		GlStateManager.disableRescaleNormal();
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x, (float) y, (float) z);
		GlStateManager.scale(4.2F, 4.2F, 4.2F);
		GlStateManager.rotate(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
		// GlStateManager.rotate(-pitch, 0.0F, 0.0F, 1.0F);

		this.updateModel();
		this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

		if (Minecraft.isAmbientOcclusionEnabled()) {
			GlStateManager.shadeModel(GL11.GL_SMOOTH);
		} else {
			GlStateManager.shadeModel(GL11.GL_FLAT);
		}
		this.partBody();
		this.partHead();
		this.partLeftArm();
		this.partLeftLeg();
		this.partRightArm();
		this.partRightLeg();
		GlStateManager.popMatrix();
	}

	public void partHead() {
		MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_white.png"));
		ModelUtilities.drawBakedModel(armourModelHead);
		MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_dark_red.png"));
		ModelUtilities.drawBakedModel(armourModelTanks);
		MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_blue_textured.png"));
		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
		ModelUtilities.drawBakedModel(armourModelHeadGlass);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	}

	public void partBody() {
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

	public void partRightArm() {
		MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_white.png"));
		ModelUtilities.drawBakedModel(armourModelRightArm);
		MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_textured.png"));
		ModelUtilities.drawBakedModel(armourModelRightArmSpring);
	}

	public void partLeftArm() {
		MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_white.png"));
		ModelUtilities.drawBakedModel(armourModelLeftArm);
		MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_textured.png"));
		ModelUtilities.drawBakedModel(armourModelLeftArmSpring);
	}

	public void partRightLeg() {
		MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_white.png"));
		ModelUtilities.drawBakedModel(armourModelLeftLeg);
		MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_textured.png"));
		ModelUtilities.drawBakedModel(armourModelLeftLegPipes);
		MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_dark_grey.png"));
		ModelUtilities.drawBakedModel(armourModelLeftBoot);
	}

	public void partLeftLeg() {
		MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_white.png"));
		ModelUtilities.drawBakedModel(armourModelRightLeg);
		MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_textured.png"));
		ModelUtilities.drawBakedModel(armourModelRightLegPipes);
		MCUtilities.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.TEXTURE_PREFIX + "textures/model/blank_rocket_dark_grey.png"));
		ModelUtilities.drawBakedModel(armourModelRightBoot);
	}
}