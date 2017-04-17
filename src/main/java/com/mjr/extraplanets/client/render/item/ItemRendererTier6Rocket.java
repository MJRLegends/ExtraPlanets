package com.mjr.extraplanets.client.render.item;
import micdoodle8.mods.galacticraft.api.entity.IRocketType.EnumRocketType;
import micdoodle8.mods.galacticraft.core.entities.EntityTier1Rocket;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.Sys;
import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.Constants;

import cpw.mods.fml.client.FMLClientHandler;

public class ItemRendererTier6Rocket implements IItemRenderer
{
	protected static final ResourceLocation chestTexture = new ResourceLocation("textures/entity/chest/normal.png");

	protected IModelCustom modelSpaceship;
	protected final ModelChest chestModel = new ModelChest();

	protected static RenderItem drawItems = new RenderItem();

	protected ResourceLocation texture = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blankRocket.png");
	protected ResourceLocation texture2 = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blankRocketWhite.png");
	protected ResourceLocation texture3 = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blankRocketGrey.png");
	protected ResourceLocation texture4 = new ResourceLocation(Constants.ASSET_PREFIX, "textures/model/blankRocketDarkGrey.png");
	
	public ItemRendererTier6Rocket(IModelCustom model)
	{
		this.modelSpaceship = model;
	}

	protected void renderSpaceship(ItemRenderType type, RenderBlocks render, ItemStack item, float translateX, float translateY, float translateZ)
	{
		GL11.glPushMatrix();

		this.transform(item, type);

		FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.texture);
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture4);
		this.modelSpaceship.renderPart("Nozzle");
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture);
		this.modelSpaceship.renderPart("Body_Rocket");
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture4);
		this.modelSpaceship.renderPart("CorrectedWind1");
		this.modelSpaceship.renderPart("CorrectedWind2");
		this.modelSpaceship.renderPart("CorrectedWind3");
		this.modelSpaceship.renderPart("CorrectedWind4");
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture3);
		this.modelSpaceship.renderPart("Rocket_stabilizer1");
		this.modelSpaceship.renderPart("Rocket_stabilizer2");
		this.modelSpaceship.renderPart("Rocket_stabilizer3");
		this.modelSpaceship.renderPart("Rocket_stabilizer4");
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture4);
		this.modelSpaceship.renderPart("Tip");
		this.modelSpaceship.renderPart("Ring");
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture);
		this.modelSpaceship.renderPart("FrameWindow1");
		this.modelSpaceship.renderPart("FrameWindow2");
		this.modelSpaceship.renderPart("FrameWindow3");
		this.modelSpaceship.renderPart("FrameWindow4");
		this.modelSpaceship.renderPart("GlassWindow");
		this.modelSpaceship.renderPart("CorrectedWind005");
		this.modelSpaceship.renderPart("CorrectedWind006");
		this.modelSpaceship.renderPart("CorrectedWind007");
		this.modelSpaceship.renderPart("CorrectedWind008");
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture3);
		this.modelSpaceship.renderPart("Cylinder001");
		this.modelSpaceship.renderPart("Cylinder002");
		this.modelSpaceship.renderPart("Cylinder003");
		this.modelSpaceship.renderPart("Cylinder004");
		this.modelSpaceship.renderPart("Cylinder005");
		this.modelSpaceship.renderPart("Cylinder006");
//		this.modelSpaceship.renderPart("Cylinder007");
//		this.modelSpaceship.renderPart("Cylinder008");
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture2);
		this.modelSpaceship.renderPart("Helix001");
		this.modelSpaceship.renderPart("SplinePathDeform");
		this.modelSpaceship.renderPart("Pipe004");
		this.modelSpaceship.renderPart("Pipe005");
		this.modelSpaceship.renderPart("Pipe006");
		this.modelSpaceship.renderPart("Pipe007");
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture4);
		this.modelSpaceship.renderPart("RocketEngine");
		this.modelSpaceship.renderPart("RocketEngine001");
		this.modelSpaceship.renderPart("RocketEngine002");
		this.modelSpaceship.renderPart("RocketEngine003");
		GL11.glPopMatrix();

		if (type == ItemRenderType.INVENTORY)
		{
			int index = Math.min(Math.max(item.getItemDamage(), 0), EnumRocketType.values().length - 1);
			if (EnumRocketType.values()[index].getInventorySpace() > 3)
			{
				final ModelChest modelChest = this.chestModel;
				FMLClientHandler.instance().getClient().renderEngine.bindTexture(ItemRendererTier6Rocket.chestTexture);

				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_DEPTH_TEST);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				GL11.glScalef(0.5F, -0.5F, -0.5F);
				GL11.glTranslatef(1.5F, 1.95F, 1.7F);
				final short short1 = 0;

				GL11.glRotatef(short1, 0.0F, 1.0F, 0.0F);
				GL11.glTranslatef(-1.5F, -1.5F, -1.5F);
				float f1 = 0;
				f1 = 1.0F - f1;
				f1 = 1.0F - f1 * f1 * f1;
				modelChest.chestLid.rotateAngleX = -(f1 * (float) Math.PI / 2.0F);

				modelChest.chestBelow.render(0.0625F);
				modelChest.chestLid.render(0.0625F);
				modelChest.chestKnob.render(0.0625F);
				GL11.glEnable(GL11.GL_DEPTH_TEST);
				GL11.glPopMatrix();
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}
	}

	public void transform(ItemStack itemstack, ItemRenderType type)
	{
		final EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;

		if (type == ItemRenderType.EQUIPPED)
		{
			GL11.glRotatef(70, 1.0F, 0, 0);
			GL11.glRotatef(-10, 0.0F, 1, 0);
			GL11.glRotatef(50, 0.0F, 1, 1);
			GL11.glTranslatef(-1.1F, -8.2F, 0F);
			GL11.glScalef(5.2F, 5.2F, 5.2F);

			if (player != null && player.ridingEntity != null && player.ridingEntity instanceof EntityTier1Rocket)
			{
				GL11.glScalef(0.0F, 0.0F, 0.0F);
			}
		}

		if (type == ItemRenderType.EQUIPPED_FIRST_PERSON)
		{
			GL11.glTranslatef(7.0F, 6.4F, 5.9F);
			GL11.glRotatef(28, 0.0F, 0, 1);
			GL11.glRotatef(50 + 180, 0.0F, 1, 0);
			GL11.glRotatef(73, 1.0F, 0, 0);
			GL11.glScalef(5.2F, 5.2F, 5.2F);

			if (player != null && player.ridingEntity != null && player.ridingEntity instanceof EntityTier1Rocket)
			{
				GL11.glScalef(0.0F, 0.0F, 0.0F);
			}
		}

		GL11.glTranslatef(0, 0.1F, 0);
		GL11.glScalef(-0.4F, -0.4F, 0.4F);

		if (type == ItemRenderType.INVENTORY || type == ItemRenderType.ENTITY)
		{
			if (type == ItemRenderType.INVENTORY)
			{
				GL11.glRotatef(85F, 1F, 0F, 1F);
				GL11.glRotatef(20F, 1F, 0F, 0F);
				GL11.glScalef(0.6F, 0.6F, 0.6F);
				GL11.glTranslatef(0.9F, 2.0F, -0.4F);
			}
			else
			{
				GL11.glTranslatef(0, -0.9F, 0);
				GL11.glScalef(0.5F, 0.5F, 0.5F);
			}

			GL11.glScalef(1.3F, 1.3F, 1.3F);
			GL11.glTranslatef(0, -0.6F, 0);
			GL11.glRotatef(Sys.getTime() / 30F % 360F + 45, 0F, 1F, 0F);
		}

		GL11.glRotatef(180, 0, 0, 1);
	}

	/**
	 * IItemRenderer implementation *
	 */

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch (type)
		{
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
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		switch (type)
		{
		case EQUIPPED:
			this.renderSpaceship(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
			break;
		case EQUIPPED_FIRST_PERSON:
			this.renderSpaceship(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
			break;
		case INVENTORY:
			this.renderSpaceship(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
			break;
		case ENTITY:
			this.renderSpaceship(type, (RenderBlocks) data[0], item, -0.5f, -0.5f, -0.5f);
			break;
		default:
		}
	}

}