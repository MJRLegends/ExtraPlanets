package com.mjr.extraplanets.client.model;

import micdoodle8.mods.galacticraft.core.util.ClientUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.inventory.EntityEquipmentSlot;
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

@SideOnly(Side.CLIENT)
public class ArmorSpaceSuitModel extends ArmorCustomModel {

	public static OBJModel.OBJBakedModel armourModelHead;
	public static OBJModel.OBJBakedModel armourModelHead2;
	public static OBJModel.OBJBakedModel armourModelBody;
	public static OBJModel.OBJBakedModel armourModelLeftArm;
	public static OBJModel.OBJBakedModel armourModelRightArm;
	public static OBJModel.OBJBakedModel armourModelLeftLeg;
	public static OBJModel.OBJBakedModel armourModelRightLeg;
	private final EntityEquipmentSlot partType;

	public ArmorSpaceSuitModel(EntityEquipmentSlot armorSlot) {
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
				Function<ResourceLocation, TextureAtlasSprite> spriteFunction = location -> Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());

				armourModelHead = (OBJModel.OBJBakedModel) model.bake(
						new OBJModel.OBJState(ImmutableList.of("HelmetOxygenCapsule1", "HelmetOxygenCapsule2", "HelmetPart1", "HelmetPart2", "HelmetPart4", "HelmetPart5", "HelmetPart6", "HelmetPart7", "HelmetPart8", "HelmetPart9", "HelmetPart10",
								"HelmetPart11", "MainPartHelmet"), false), DefaultVertexFormats.ITEM, spriteFunction);
				
				armourModelHead2 = (OBJModel.OBJBakedModel) model.bake(
						new OBJModel.OBJState(ImmutableList.of("HelmetPart3"), false), DefaultVertexFormats.ITEM, spriteFunction);
				
				armourModelBody = (OBJModel.OBJBakedModel) model.bake(
						new OBJModel.OBJState(ImmutableList.of("BodyPart1", "BodyPart2", "BodyPart3", "BodyPart4", "BodyPart5", "BodyPart6", "BodyPart7", "BodyPart8", "BodyPart9", "BodyPart10", "BodyPart11", "BodyPart12", "BodyPart13", "BodyPart14",
								"BodyPart15", "BodyPart16", "BodyPart17", "BodyPart18"), false), DefaultVertexFormats.ITEM, spriteFunction);
				
				armourModelLeftArm = (OBJModel.OBJBakedModel) model.bake(
						new OBJModel.OBJState(ImmutableList.of("LeftHandPart1", "LeftHandPart2", "LeftHandPart3", "LeftHandPart4"), false), DefaultVertexFormats.ITEM, spriteFunction);
				
				armourModelRightArm = (OBJModel.OBJBakedModel) model.bake(
						new OBJModel.OBJState(ImmutableList.of("RightHandPart1", "RightHandPart2", "RightHandPart3", "RightHandPart4"), false), DefaultVertexFormats.ITEM, spriteFunction);
				
				armourModelLeftLeg = (OBJModel.OBJBakedModel) model.bake(
						new OBJModel.OBJState(ImmutableList.of("LeftLegPart1", "LeftLegPart2", "LeftLegPart3", "LeftLegPart4"), false), DefaultVertexFormats.ITEM, spriteFunction);
				
				armourModelRightLeg = (OBJModel.OBJBakedModel) model.bake(
						new OBJModel.OBJState(ImmutableList.of("RightLegPart1", "RightLegPart2", "RightLegPart3", "RightLegPart4"), false), DefaultVertexFormats.ITEM, spriteFunction);
				
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
		if (partType == EntityEquipmentSlot.HEAD) {
			GL11.glTranslatef(0F, -1.5F, 0F);
			ClientUtil.drawBakedModel(armourModelHead);
			GL11.glEnable(GL11.GL_BLEND);
			ClientUtil.drawBakedModel(armourModelHead2);
			GL11.glDisable(GL11.GL_BLEND);
		}
	}

	@Override
	public void partBody() {
		if (partType == EntityEquipmentSlot.CHEST) {
			GL11.glTranslatef(0F, -1.5F, 0F);
			ClientUtil.drawBakedModel(armourModelBody);
		}
	}

	@Override
	public void partRightArm() {
		if (partType == EntityEquipmentSlot.CHEST) {
			GL11.glTranslatef(-0.3125F, -1.375F, 0F);
			ClientUtil.drawBakedModel(armourModelRightArm);
		}
	}

	@Override
	public void partLeftArm() {
		if (partType == EntityEquipmentSlot.CHEST) {
			GL11.glTranslatef(0.3125F, -1.375F, 0F);
			ClientUtil.drawBakedModel(armourModelLeftArm);
		}
	}

	@Override
	public void partRightLeg() {
		GL11.glTranslatef(-0.125F, -0.75F, 0F);
		if (partType == EntityEquipmentSlot.LEGS) {
			ClientUtil.drawBakedModel(armourModelRightLeg);
		}
	}

	@Override
	public void partLeftLeg() {
		GL11.glTranslatef(0.125F, -0.75F, 0F);
		if (partType == EntityEquipmentSlot.LEGS) {
			ClientUtil.drawBakedModel(armourModelLeftLeg);

		}
	}
}