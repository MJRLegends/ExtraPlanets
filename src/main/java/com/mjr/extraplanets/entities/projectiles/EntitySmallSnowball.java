package com.mjr.extraplanets.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntitySmallSnowball extends EntityThrowable {

    public static double accelMultiplier = 0.2D;

    public EntitySmallSnowball(World paramWorld) {
	super(paramWorld);
    }

    public EntitySmallSnowball(World paramWorld,
	    EntityLivingBase paramEntityLivingBase) {
	super(paramWorld, paramEntityLivingBase);
    }

    public EntitySmallSnowball(World paramWorld, double paramDouble1,
	    double paramDouble2, double paramDouble3) {
	super(paramWorld, paramDouble1, paramDouble2, paramDouble3);
    }

    @Override
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
	if (!this.worldObj.isRemote)
	{
	    if (par1MovingObjectPosition.entityHit != null)
	    {
		byte b0 = 0;
		if (par1MovingObjectPosition.entityHit instanceof EntityPlayer)
		{
		    b0 = 3;
		}
		par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), b0);
	    }
	    for (int i = 0; i < 8; ++i)
	    {
		this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
	    }
	    if (!this.worldObj.isRemote)
	    {
		this.setDead();
	    }
	}
    }

    @SideOnly(Side.CLIENT)
    public int func_70070_b(float paramFloat) {
	return 15728880;
    }
}
