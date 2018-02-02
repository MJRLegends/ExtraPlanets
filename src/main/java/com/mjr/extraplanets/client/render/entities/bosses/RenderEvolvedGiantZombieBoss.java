package com.mjr.extraplanets.client.render.entities.bosses;

import java.util.List;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.model.ModelZombieVillager;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.layers.LayerVillagerArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.collect.Lists;
import com.mjr.extraplanets.entities.bosses.EntityEvolvedGiantZombieBoss;

@SideOnly(Side.CLIENT)
public class RenderEvolvedGiantZombieBoss extends RenderBiped<EntityEvolvedGiantZombieBoss> {
	private static final ResourceLocation ZOMBIE_TEXTURES = new ResourceLocation("textures/entity/zombie/zombie.png");
	private final ModelBiped defaultModel;
	private final ModelZombieVillager zombieVillagerModel;
	@SuppressWarnings("unused")
	private final List<LayerRenderer<EntityEvolvedGiantZombieBoss>> villagerLayers;
	private final List<LayerRenderer<EntityEvolvedGiantZombieBoss>> defaultLayers;

	public RenderEvolvedGiantZombieBoss(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelZombie(), 0.5F, 1.0F);
		LayerRenderer<?> layerrenderer = this.layerRenderers.get(0);
		this.defaultModel = this.modelBipedMain;
		this.zombieVillagerModel = new ModelZombieVillager();
		this.addLayer(new LayerHeldItem(this));
		LayerBipedArmor layerbipedarmor = new LayerBipedArmor(this) {
			@Override
			protected void initArmor() {
				this.modelLeggings = new ModelZombie(0.5F, true);
				this.modelArmor = new ModelZombie(1.0F, true);
			}
		};
		this.addLayer(layerbipedarmor);
		this.defaultLayers = Lists.newArrayList(this.layerRenderers);

		if (layerrenderer instanceof LayerCustomHead) {
			this.removeLayer(layerrenderer);
			this.addLayer(new LayerCustomHead(this.zombieVillagerModel.bipedHead));
		}

		this.removeLayer(layerbipedarmor);
		this.addLayer(new LayerVillagerArmor(this));
		this.villagerLayers = Lists.newArrayList(this.layerRenderers);
	}

	/**
	 * Allows the render to do state modifications necessary before the model is rendered.
	 */
	@Override
	protected void preRenderCallback(EntityEvolvedGiantZombieBoss entitylivingbaseIn, float partialTickTime) {
		super.preRenderCallback(entitylivingbaseIn, partialTickTime);
		GlStateManager.scale(4.35F, 4.35F, 4.35F);
		GlStateManager.rotate((float) (Math.pow(entitylivingbaseIn.deathTicks, 2) / 5.0F + (Math.pow(entitylivingbaseIn.deathTicks, 2) / 5.0F - Math.pow(entitylivingbaseIn.deathTicks - 1, 2) / 5.0F) * partialTickTime), 0.0F, 1.0F, 0.0F);
	}

	/**
	 * Renders the desired {@code T} type Entity.
	 */
	@Override
	public void doRender(EntityEvolvedGiantZombieBoss entity, double x, double y, double z, float entityYaw, float partialTicks) {
		this.swapArmor(entity);
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	@Override
	protected ResourceLocation getEntityTexture(EntityEvolvedGiantZombieBoss entity) {
		return ZOMBIE_TEXTURES;
	}

	private void swapArmor(EntityEvolvedGiantZombieBoss zombie) {
		this.mainModel = this.defaultModel;
		this.layerRenderers = this.defaultLayers;

		this.modelBipedMain = (ModelBiped) this.mainModel;
	}

	@Override
	protected void rotateCorpse(EntityEvolvedGiantZombieBoss entityLiving, float p_77043_2_, float p_77043_3_, float partialTicks) {
		super.rotateCorpse(entityLiving, p_77043_2_, p_77043_3_, partialTicks);
	}
}