package com.mjr.extraplanets.client.render.item;

import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.entities.vehicles.EntityMarsRover;

import cpw.mods.fml.client.FMLClientHandler;

public class ItemRendererMarsRover implements IItemRenderer {
	private static final ResourceLocation buggyTextureBody = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket_dark_grey.png");
	private static final ResourceLocation buggyTextureWheel = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket_black.png");
	private static final ResourceLocation buggyTextureStorage = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket.png");
	private static final ResourceLocation buggyTextureOther = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket_white.png");
	private static final ResourceLocation buggyTextureOther2 = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket_orange_textured.png");
	private static final ResourceLocation buggyTextureOther3 = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket_textured.png");
	private static final ResourceLocation buggyTextureOther4 = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket_light_blue_textured.png");
	private static final ResourceLocation buggyTextureOther5 = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket_blue_textured.png");
	private static final ResourceLocation buggyTextureBatteryBolt = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blank_rocket_yellow.png");

	EntityMarsRover spaceship = new EntityMarsRover(FMLClientHandler.instance().getClient().theWorld);

	private final IModelCustom modelRover;
	private final IModelCustom modelRoverWheelLeft = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/MarsRover-Wheel.obj"));
	private final IModelCustom modelRoverWheelRight = AdvancedModelLoader.loadModel(new ResourceLocation(Constants.ASSET_PREFIX, "models/MarsRover-Wheel.obj"));
	
	public ItemRendererMarsRover(IModelCustom modelRover) {
		super();
		this.modelRover = modelRover;
	}

	private void renderPipeItem(ItemRenderType type, RenderBlocks render, ItemStack item, float translateX, float translateY, float translateZ) {
		GL11.glPushMatrix();
		long var10 = this.spaceship.getEntityId() * 493286711L;
		var10 = var10 * var10 * 4392167121L + var10 * 98761L;
		final float var12 = (((var10 >> 16 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
		final float var13 = (((var10 >> 20 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
		final float var14 = (((var10 >> 24 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;

		GL11.glScalef(0.75F, 0.75F, 0.75F);

		if (type == ItemRenderType.EQUIPPED) {
			GL11.glRotatef(150.0F, 0F, 0F, 1F);
			GL11.glScalef(2.2F, 2.2F, 2.2F);
			GL11.glTranslatef(0.0F, -0.65F, 0.9F);
		} else if (type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
			GL11.glTranslatef(0.0F, 1.0F, 0.0F);
		}

		GL11.glTranslatef(var12, var13 - 0.1F, var14);
		GL11.glScalef(-0.4F, -0.4F, 0.4F);
		if (type == ItemRenderType.INVENTORY || type == ItemRenderType.ENTITY) {
			if (type == ItemRenderType.INVENTORY) {
				GL11.glScalef(0.5F, 0.35F, 0.5F);
			} else {
				GL11.glTranslatef(0, -0.9F, 0);
				GL11.glScalef(0.5F, 0.5F, 0.5F);
			}

			GL11.glScalef(1.5F, 1.5F, 1.5F);
			GL11.glTranslatef(0, 1.6F, 0);
			GL11.glRotatef(-45.0F, 0F, 1F, 0F);
		}

		GL11.glRotatef(180, 0, 0, 1);

		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ItemRendererMarsRover.buggyTextureWheel);

		// Front
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, 1.2F, 2.2F);
		GL11.glTranslatef(2.0F, 0.0F, 0.0F);
		this.modelRoverWheelRight.renderPart("Wheel");
		GL11.glTranslatef(-3.9F, 0.0F, 0.0F);
		this.modelRoverWheelLeft.renderPart("Wheel");
		GL11.glPopMatrix();

		// Middle wheels
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, 1.2F, -0.2F);
		GL11.glTranslatef(1.9F, 0.0F, 0.0F);
		this.modelRoverWheelRight.renderPart("Wheel");
		GL11.glTranslatef(-3.7F, 0.0F, 0.0F);
		this.modelRoverWheelLeft.renderPart("Wheel");
		GL11.glPopMatrix();

		// Back wheels
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, 1.2F, -3.7F);
		GL11.glTranslatef(1.9F, 0.0F, 0.0F);
		this.modelRoverWheelRight.renderPart("Wheel");
		GL11.glTranslatef(-3.7F, 0.0F, 0.0F);
		this.modelRoverWheelLeft.renderPart("Wheel");
		GL11.glPopMatrix();

		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ItemRendererMarsRover.buggyTextureBody);
		this.modelRover.renderPart("RoofRover");
		this.modelRover.renderPart("FloorRover");
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ItemRendererMarsRover.buggyTextureOther2);
		this.modelRover.renderPart("Clip1");
		this.modelRover.renderPart("Clip2");
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ItemRendererMarsRover.buggyTextureStorage);
		this.modelRover.renderPart("AxisBack");
		this.modelRover.renderPart("AxisFront");
		this.modelRover.renderPart("AxisFront001");
		this.modelRover.renderPart("AxisMiddle");
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ItemRendererMarsRover.buggyTextureStorage);
		this.modelRover.renderPart("FrameSegment010");
		this.modelRover.renderPart("FrameSegment011");
		this.modelRover.renderPart("FrameSegment012");
		this.modelRover.renderPart("FrameSegment013");
		this.modelRover.renderPart("FrameSegment014");
		this.modelRover.renderPart("FrameSegment015");
		this.modelRover.renderPart("FrameSegment021");
		this.modelRover.renderPart("FrameSegment022");
		this.modelRover.renderPart("FrameSegment023");
		this.modelRover.renderPart("FrameSegment024");
		this.modelRover.renderPart("FrameSegment025");
		this.modelRover.renderPart("FrameSegment026");
		this.modelRover.renderPart("FrameSegment027");
		this.modelRover.renderPart("FrameSegment028");
		this.modelRover.renderPart("FrameSegment029");
		this.modelRover.renderPart("FrameSegment030");
		this.modelRover.renderPart("FrameSegment031");
		this.modelRover.renderPart("FrameSegment032");
		this.modelRover.renderPart("FrameSegment033");
		this.modelRover.renderPart("FrameSegment044");
		this.modelRover.renderPart("FrameSegment045");
		this.modelRover.renderPart("FrameSegment046");
		this.modelRover.renderPart("FrameSegment047");
		this.modelRover.renderPart("FrameSegment048");
		this.modelRover.renderPart("FrameSegment049");
		this.modelRover.renderPart("FrameSegment050");
		this.modelRover.renderPart("FrameSegment051");
		this.modelRover.renderPart("FrameSegment052");
		this.modelRover.renderPart("FrameSegment053");
		this.modelRover.renderPart("FrameSegment054");
		this.modelRover.renderPart("FrameSegment055");
		this.modelRover.renderPart("FrameSegment056");
		this.modelRover.renderPart("FrameSegment057");
		this.modelRover.renderPart("FrameSegment058");
		this.modelRover.renderPart("FrameSegment059");
		this.modelRover.renderPart("Line001");
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ItemRendererMarsRover.buggyTextureWheel);
		this.modelRover.renderPart("HelmKeeper");
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ItemRendererMarsRover.buggyTextureOther);
		this.modelRover.renderPart("Helm");
		this.modelRover.renderPart("Seat");
		this.modelRover.renderPart("Seat001");
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ItemRendererMarsRover.buggyTextureBody);
		this.modelRover.renderPart("SolarPanel");
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ItemRendererMarsRover.buggyTextureOther4);
		this.modelRover.renderPart("PoleSolarPanel");
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ItemRendererMarsRover.buggyTextureWheel);
		this.modelRover.renderPart("SolarPanelBlock");
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ItemRendererMarsRover.buggyTextureOther3);
		this.modelRover.renderPart("Wire");
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ItemRendererMarsRover.buggyTextureOther5);
		this.modelRover.renderPart("Battery");
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ItemRendererMarsRover.buggyTextureBody);
		this.modelRover.renderPart("Line002");
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ItemRendererMarsRover.buggyTextureStorage);
		this.modelRover.renderPart("CaseBack1");
		this.modelRover.renderPart("CaseBack2");
		this.modelRover.renderPart("CaseBack3");
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ItemRendererMarsRover.buggyTextureBody);
		this.modelRover.renderPart("WindowBack");
		this.modelRover.renderPart("WindowFragment3");
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
		this.modelRover.renderPart("WindowFront1");
		this.modelRover.renderPart("WindowFront2");
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);

		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/solar_panel.png"));
		this.modelRover.renderPart("SolarPlane");

		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ItemRendererMarsRover.buggyTextureBatteryBolt);
		this.modelRover.renderPart("Lightning");
		this.modelRover.renderPart("Lightning2");

		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ItemRendererMarsRover.buggyTextureStorage);

		if (item.getItemDamage() > 0) {
			this.modelRover.renderPart("Container");

			if (item.getItemDamage() > 1) {
				this.modelRover.renderPart("Container2");

				if (item.getItemDamage() > 2) {
					this.modelRover.renderPart("Container3");
				}
			}
		}

		GL11.glPopMatrix();
	}

	/**
	 * IItemRenderer implementation *
	 */

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch (type) {
		case ENTITY:
			return true;
		case EQUIPPED:
			return true;
		case EQUIPPED_FIRST_PERSON:
			return true;
		case INVENTORY:
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
		case EQUIPPED:
			this.renderPipeItem(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
			break;
		case EQUIPPED_FIRST_PERSON:
			this.renderPipeItem(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
			break;
		case INVENTORY:
			this.renderPipeItem(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
			break;
		case ENTITY:
			this.renderPipeItem(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
			break;
		default:
		}
	}

}