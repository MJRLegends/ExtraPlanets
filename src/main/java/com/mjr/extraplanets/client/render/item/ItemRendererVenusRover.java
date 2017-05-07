package com.mjr.extraplanets.client.render.item;

import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.entities.vehicles.EntityVenusRover;

import cpw.mods.fml.client.FMLClientHandler;

public class ItemRendererVenusRover implements IItemRenderer {
	private static final ResourceLocation buggyTextureBody = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blankRocketDarkGrey.png");
	private static final ResourceLocation buggyTextureWheel = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blankRocket.png");
	private static final ResourceLocation buggyTextureStorage = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blankRocket.png");
	private static final ResourceLocation buggyTextureOther = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blankRocketWhite.png");

	EntityVenusRover spaceship = new EntityVenusRover(FMLClientHandler.instance().getClient().theWorld);

	private final IModelCustom modelRover;

	public ItemRendererVenusRover(IModelCustom modelRover) {
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

		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ItemRendererVenusRover.buggyTextureWheel);

		// Front wheels
		GL11.glPushMatrix();
		this.modelRover.renderPart("WheelFrontRight");
		this.modelRover.renderPart("WheelFrontLeft");
		GL11.glPopMatrix();

		// Middle wheels
		GL11.glPushMatrix();
		this.modelRover.renderPart("WheelMiddleRight");
		this.modelRover.renderPart("WheelMiddleLeft");
		GL11.glPopMatrix();

		// Back wheels
		GL11.glPushMatrix();
		this.modelRover.renderPart("WheelBackRight");
		this.modelRover.renderPart("WheelBackLeft");
		GL11.glPopMatrix();

		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ItemRendererVenusRover.buggyTextureBody);
		this.modelRover.renderPart("BraceFrontWheelLeft");
		this.modelRover.renderPart("BraceFrontWheelLeft2");
		this.modelRover.renderPart("BraceFrontWheelLeft003");
		this.modelRover.renderPart("BraceFrontWheelLeft004");
		this.modelRover.renderPart("BraceFrontWheelRight");
		this.modelRover.renderPart("BraceFrontWheelRight2");
		this.modelRover.renderPart("BraceFrontWheelRight003");
		this.modelRover.renderPart("BraceFrontWheelRight004");
		this.modelRover.renderPart("BraceFrontWheelRight005");
		this.modelRover.renderPart("BraceFrontWheelRight006");
		this.modelRover.renderPart("Frame");
		this.modelRover.renderPart("Frame2");
		this.modelRover.renderPart("GlassFront");
		this.modelRover.renderPart("GlassPaneRoof");
		this.modelRover.renderPart("Helm");

		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(ItemRendererVenusRover.buggyTextureStorage);

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