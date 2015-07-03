package com.mjr.extraplanets.entities;

import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class EntityEvolvedPowerSkeleton extends EntitySkeleton implements IEntityBreathable
{
    public EntityEvolvedPowerSkeleton(World par1World)
    {
	super(par1World);
	this.tasks.addTask(1, new EntityAISwimming(this));
	this.tasks.addTask(2, new EntityAIRestrictSun(this));
	this.tasks.addTask(3, new EntityAIFleeSun(this, 0.25F));
	this.tasks.addTask(4, new EntityAIArrowAttack(this, 0.85F, 25, 20));
	this.tasks.addTask(5, new EntityAIWander(this, 0.25F));
	this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 15.0F));
	this.tasks.addTask(6, new EntityAILookIdle(this));
	this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
    }

    @Override
    protected void applyEntityAttributes()
    {
	super.applyEntityAttributes();
	this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25);
	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.55F);
    }

    @Override
    public boolean canBreath()
    {
	return true;
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2)
    {
	EntityArrow entityarrow = new EntityArrow(this.worldObj, this, par1EntityLivingBase, 0.4F, 17 - this.worldObj.difficultySetting.getDifficultyId() * 4);
	int i = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, this.getHeldItem());
	int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, this.getHeldItem());
	entityarrow.setDamage(par2 * 2.0F + this.rand.nextGaussian() * 0.25D + this.worldObj.difficultySetting.getDifficultyId() * 0.11F);

	if (i > 0)
	{
	    entityarrow.setDamage(entityarrow.getDamage() + i * 0.8D + 0.8D);
	}

	if (j > 0)
	{
	    entityarrow.setKnockbackStrength(j);
	}

	if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, this.getHeldItem()) > 0 || this.getSkeletonType() == 1)
	{
	    entityarrow.setFire(100);
	}

	this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
	this.worldObj.spawnEntityInWorld(entityarrow);
    }

    @Override
    protected void jump()
    {
	this.motionY = 0.45D / WorldUtil.getGravityFactor(this);
	if (this.motionY < 0.24D) this.motionY = 0.24D;

	if (this.isPotionActive(Potion.jump))
	{
	    this.motionY += (this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F;
	}

	if (this.isSprinting())
	{
	    float f = this.rotationYaw * 0.017453292F;
	    this.motionX -= MathHelper.sin(f) * 0.2F;
	    this.motionZ += MathHelper.cos(f) * 0.2F;
	}

	this.isAirBorne = true;
	ForgeHooks.onLivingJump(this);
    }

    @Override
    protected void dropRareDrop(int p_70600_1_)
    {
	if (this.getSkeletonType() == 1)
	{
	    this.entityDropItem(new ItemStack(Items.skull, 1, 1), 0.0F);
	    return;
	}

	switch (this.rand.nextInt(10))
	{
	case 0:
	case 1:
	case 9:
	    this.dropItem(Items.arrow, 1);
	    break;
	case 2:
	case 3:
	    this.dropItem(Items.arrow, 2);
	    break;
	case 4:
	case 5:
	    this.dropItem(Items.arrow, 3);
	    break;
	case 6:
	    //Oxygen tank half empty or less
	    this.entityDropItem(new ItemStack(GCItems.oxTankMedium, 1, 901 + this.rand.nextInt(900)), 0.0F);
	    break;
	case 7:
	    this.dropItem(GCItems.canister, 1);
	    break;
	case 8:
	    this.entityDropItem(new ItemStack(GCBlocks.oxygenPipe), 0.0F);
	    break;
	}
    }
}
