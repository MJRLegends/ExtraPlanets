package com.mjr.extraplanets.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySmallSnowball extends EntityThrowable
{
    public EntitySmallSnowball(World p_i1773_1_)
    {
        super(p_i1773_1_);
    }

    public EntitySmallSnowball(World p_i1774_1_, EntityLivingBase p_i1774_2_)
    {
        super(p_i1774_1_, p_i1774_2_);
        this.setSize(3F, 3F);
    }

    public EntitySmallSnowball(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_)
    {
        super(p_i1775_1_, p_i1775_2_, p_i1775_4_, p_i1775_6_);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    @Override
	protected void onImpact(MovingObjectPosition p_70184_1_)
    {
        if (p_70184_1_.entityHit != null)
        {
            byte b0 = 0;

            if (p_70184_1_.entityHit instanceof EntityBlaze)
            {
                b0 = 3;
            }
            else if (p_70184_1_.entityHit instanceof EntityPlayer)
            {
                b0 = 8;
            }
            p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), b0);
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