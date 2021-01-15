package com.mjr.extraplanets.entities.mobs;

import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityEvolvedMagmaCube extends EntitySlime implements IEntityBreathable
{
    public EntityEvolvedMagmaCube(World worldIn)
    {
        super(worldIn);
        this.isImmuneToFire = true;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return this.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL;
    }

    /**
     * Checks that the entity is not colliding with any blocks / liquids
     */
    public boolean isNotColliding()
    {
        return this.worldObj.checkNoEntityCollision(this.getEntityBoundingBox(), this) && this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.worldObj.isAnyLiquid(this.getEntityBoundingBox());
    }
    
    public void setSlimeSizePublic(int size, float resetHealth)
    {
        this.setSize(size, resetHealth);
    }

    protected void setSize(int size, float resetHealth)
    {
        super.setSize(size, resetHealth);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)(size * 3));
    }

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender()
    {
        return 15728880;
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness()
    {
        return 1.0F;
    }

    protected EnumParticleTypes getParticleType()
    {
        return EnumParticleTypes.FLAME;
    }

    protected EntitySlime createInstance()
    {
        return new EntityEvolvedMagmaCube(this.worldObj);
    }

    protected Item getDropItem()
    {
        return Items.magma_cream;
    }

    /**
     * Returns true if the entity is on fire. Used by render to add the fire effect on rendering.
     */
    public boolean isBurning()
    {
        return false;
    }
    
    /**
     * Sets the Entity inside a web block.
     */
    @Override
    public void setInWeb()
    {
    }

    /**
     * Gets the amount of time the slime needs to wait between jumps.
     */
    protected int getJumpDelay()
    {
        return super.getJumpDelay() * 4;
    }

    protected void alterSquishAmount()
    {
        this.squishAmount *= 0.9F;
    }

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    protected void jump()
    {
        this.motionY = (double)(0.42F + (float)this.getSlimeSize() * 0.1F);
        this.isAirBorne = true;
        net.minecraftforge.common.ForgeHooks.onLivingJump(this);
    }

    protected void handleJumpLava()
    {
        this.motionY = (double)(0.22F + (float)this.getSlimeSize() * 0.05F);
        this.isAirBorne = true;
    }

    public void fall(float distance, float damageMultiplier)
    {
    }

    /**
     * Indicates weather the slime is able to damage the player (based upon the slime's size)
     */
    protected boolean canDamagePlayer()
    {
        return true;
    }

    /**
     * Gets the amount of damage dealt to the player when "attacked" by the slime.
     */
    protected int getAttackStrength()
    {
        return super.getAttackStrength() + 4;
    }

    protected String getJumpSound()
    {
        return this.getSlimeSize() > 1 ? "mob.magmacube.big" : "mob.magmacube.small";
    }

	@Override
	public boolean canBreath() {
		return true;
	}
}