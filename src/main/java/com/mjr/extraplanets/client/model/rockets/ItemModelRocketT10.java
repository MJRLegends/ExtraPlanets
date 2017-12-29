package com.mjr.extraplanets.client.model.rockets;

import javax.vecmath.Matrix4f;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

import micdoodle8.mods.galacticraft.core.util.ClientUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraftforge.common.model.TRSRTransformation;

import org.lwjgl.opengl.GL11;

import com.mjr.extraplanets.Constants;
import com.mjr.mjrlegendslib.client.model.ModelTransformWrapper;

public class ItemModelRocketT10 extends ModelTransformWrapper {
	public ItemModelRocketT10(IBakedModel modelToWrap) {
		super(modelToWrap);
	}

    @Override
    protected Matrix4f getTransformForPerspective(TransformType cameraTransformType)
    {
        if (cameraTransformType == TransformType.GUI)
        {
    		if (Minecraft.isAmbientOcclusionEnabled()) {
    			GlStateManager.shadeModel(GL11.GL_SMOOTH);
    		} else {
    			GlStateManager.shadeModel(GL11.GL_FLAT);
    		}
    		RenderHelper.enableStandardItemLighting();
            Vector3f trans = new Vector3f(-0.12F, 0.0F, -0.12F);
            Matrix4f ret = new Matrix4f();
            ret.setIdentity();
            Matrix4f mul = new Matrix4f();
            mul.setIdentity();
            Quat4f rot = TRSRTransformation.quatFromXYZDegrees(new Vector3f(30, 225, 0));
            mul.setRotation(rot);
            ret.mul(mul);
            mul.setIdentity();
            mul.setScale(0.25F);
            ret.mul(mul);
            mul.setIdentity();
            mul.setTranslation(new Vector3f(-1.55F, -1.30F, 0.0F));
            ret.mul(mul);
            mul.setIdentity();
            mul.rotY(Constants.halfPI);
            ret.mul(mul);
            mul.setIdentity();
            mul.rotX((float) (Math.PI / 4.0F));
            ret.mul(mul);
            mul.setIdentity();
            mul.setTranslation(trans);
            ret.mul(mul);
            mul.setIdentity();
            mul.rotY(ClientUtil.getMilliseconds() / 1000.0F);
            ret.mul(mul);
            mul.setIdentity();
            trans.scale(-1.0F);
            mul.setTranslation(trans);
            ret.mul(mul);
            mul.setIdentity();
            mul.setScale(0.3F);
            ret.mul(mul);
            return ret;
        }

		if (cameraTransformType == TransformType.FIRST_PERSON_RIGHT_HAND) {
			if (Minecraft.isAmbientOcclusionEnabled()) {
				GlStateManager.shadeModel(GL11.GL_SMOOTH);
			} else {
				GlStateManager.shadeModel(GL11.GL_FLAT);
			}
			Vector3f trans = new Vector3f(2.5F, 6.2F, -3.9F);
			Matrix4f ret = new Matrix4f();
			ret.setIdentity();
			Matrix4f mul = new Matrix4f();
			mul.setIdentity();
			Quat4f rot = TRSRTransformation.quatFromXYZDegrees(new Vector3f(0, 45, 0));
			mul.setRotation(rot);
			ret.mul(mul);
			mul.setIdentity();
			mul.setScale(0.45F);
			ret.mul(mul);
			mul.setIdentity();
			mul.rotX(Constants.halfPI);
			ret.mul(mul);
			mul.setIdentity();
			mul.rotZ((float) (-0.65F + Math.PI));
			ret.mul(mul);
			mul.setIdentity();
			mul.setTranslation(trans);
			ret.mul(mul);
			mul.setIdentity();
			mul.rotX((float) (Math.PI));
			ret.mul(mul);
			return ret;
		}

		if (cameraTransformType == TransformType.THIRD_PERSON_RIGHT_HAND || cameraTransformType == TransformType.THIRD_PERSON_LEFT_HAND) {
			if (Minecraft.isAmbientOcclusionEnabled()) {
				GlStateManager.shadeModel(GL11.GL_SMOOTH);
			} else {
				GlStateManager.shadeModel(GL11.GL_FLAT);
			}
			Vector3f trans = new Vector3f(6.5F, -8.4F, -1.2F);
			Matrix4f ret = new Matrix4f();
			ret.setIdentity();
			Matrix4f mul = new Matrix4f();
			mul.setIdentity();
			Quat4f rot = TRSRTransformation.quatFromXYZDegrees(new Vector3f(75, 15, 0));
			mul.setRotation(rot);
			ret.mul(mul);
			mul.setIdentity();
			mul.setScale(0.6F);
			ret.mul(mul);
			mul.setIdentity();
			mul.rotX((float) (Math.PI / 3.0F));
			ret.mul(mul);
			mul.setIdentity();
			mul.rotZ((float) (-Math.PI / 2.0F));
			ret.mul(mul);
			mul.setIdentity();
			mul.rotX(0.3F);
			ret.mul(mul);
			mul.setIdentity();
			mul.setTranslation(trans);
			ret.mul(mul);
			return ret;
		}

		if (cameraTransformType == TransformType.GROUND) {
			if (Minecraft.isAmbientOcclusionEnabled()) {
				GlStateManager.shadeModel(GL11.GL_SMOOTH);
			} else {
				GlStateManager.shadeModel(GL11.GL_FLAT);
			}
			Matrix4f ret = new Matrix4f();
			ret.setIdentity();
			Matrix4f mul = new Matrix4f();
			mul.setIdentity();
			mul.setScale(0.1F);
			ret.mul(mul);
			return ret;
		}

		return null;
	}
}
