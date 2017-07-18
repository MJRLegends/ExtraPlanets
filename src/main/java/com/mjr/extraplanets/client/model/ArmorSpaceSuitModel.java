package com.mjr.extraplanets.client.model;

import micdoodle8.mods.galacticraft.core.util.ClientUtil;
import net.minecraft.client.Minecraft;
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
	public static OBJModel.OBJBakedModel armourModelBody;

	private final EntityEquipmentSlot partType;

	public ArmorSpaceSuitModel(EntityEquipmentSlot armorSlot) {
		partType = armorSlot;
		if (armourModelHead == null) {
			OBJModel model;
			try {
				model = (OBJModel) ModelLoaderRegistry.getModel(new ResourceLocation(Constants.ASSET_PREFIX, "space_suit.obj"));
				model = (OBJModel) model.process(ImmutableMap.of("flip-v", "true"));
				Function<ResourceLocation, TextureAtlasSprite> spriteFunction = location -> Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString());

				armourModelHead = (OBJModel.OBJBakedModel) model.bake(
						new OBJModel.OBJState(ImmutableList.of(
								"SpaceHelmet1",
								"GlassHelmet"), false),
						DefaultVertexFormats.ITEM, spriteFunction);
				armourModelBody = (OBJModel.OBJBakedModel) model.bake(
						new OBJModel.OBJState(ImmutableList.of(
								"right_boot",
								"Amplifier",
								"Amplifier2",
								"Amplifier3",
								"Amplifier4",
								"Antenna",
								"AntennaDetector",
								"DecorationDetail1",
								"DecorationDetail3",
								"decorationpipe",
								"Helix001",
								"HydrogenPipe",
								"HydrogenTank"), false),
						DefaultVertexFormats.ITEM, spriteFunction);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void pre() {
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
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
		if (partType == EntityEquipmentSlot.MAINHAND) {
			GL11.glTranslatef(0.3125F, -1.375F, 0F);
		}
	}

	@Override
	public void partLeftArm() {
		if (partType == EntityEquipmentSlot.OFFHAND) {
			GL11.glTranslatef(-0.3125F, -1.375F, 0F);
		}
	}

	@Override
	public void partRightLeg() {
		GL11.glTranslatef(0.125F, -0.75F, 0F);
		if (partType == EntityEquipmentSlot.LEGS) {
		}
	}

	@Override
	public void partLeftLeg() {
		GL11.glTranslatef(-0.125F, -0.75F, 0F);
		if (partType == EntityEquipmentSlot.LEGS) {

		}
	}

}