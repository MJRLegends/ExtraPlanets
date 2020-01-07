package com.mjr.extraplanets.client.model;

import com.mjr.mjrlegendslib.util.MCUtilities;

import micdoodle8.mods.galacticraft.api.vector.Vector3;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SpaceSuitJetPackFlame {

	public static Vector3 rotateYaw(float yaw, Vector3 vec) {
		double yawRadians = Math.toRadians(yaw);
		if (yaw != 0) {
			vec.x = vec.x * Math.cos(yawRadians) - vec.z * Math.sin(yawRadians);
			vec.z = vec.z * Math.cos(yawRadians) + vec.x * Math.sin(yawRadians);
		}
		return vec;
	}

	@SideOnly(Side.CLIENT)
	public static void spawnFlames(World world, EntityPlayer player, ItemStack stack) {

		Vector3 right = new Vector3(-0.48, -0.12, -0.30);
		right = rotateYaw(player.renderYawOffset, right);
		
		Vector3 left = new Vector3(0.48, -0.12, 0.30);
		left = rotateYaw(player.renderYawOffset, left);

		Vector3 motion = new Vector3(player.motionX, player.motionY, player.motionZ);
		Vector3 posleft = new Vector3(player.posX, player.posY, player.posZ).translate(left).translate(motion);
		Vector3 posRight = new Vector3(player.posX, player.posY, player.posZ).translate(right).translate(motion);

		ParticleJetpackFlame particle = new ParticleJetpackFlame(world, posleft, new Vector3(0, 0, 0));
		MCUtilities.getMinecraft().effectRenderer.addEffect(particle);
		particle = new ParticleJetpackFlame(world, posRight, new Vector3(0, 0, 0));
		MCUtilities.getMinecraft().effectRenderer.addEffect(particle);
	}
}
