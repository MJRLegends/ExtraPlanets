package com.mjr.extraplanets.client.model;

import micdoodle8.mods.galacticraft.api.vector.Vector3;
import net.minecraft.client.particle.ParticleFlame;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ParticleJetpackFlame extends ParticleFlame {

	public ParticleJetpackFlame(World par1World, Vector3 position, Vector3 motion) {
		super(par1World, position.x, position.y, position.z, 0.0D, 0.0D, 0.0D);
	}

	@Override
	public void renderParticle(BufferBuilder worldRendererIn, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
		if (this.particleAge > 0) {
			super.renderParticle(worldRendererIn, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
		}
	}

	@Override
	public int getBrightnessForRender(float par1) {
		return 15728880;
	}
}
