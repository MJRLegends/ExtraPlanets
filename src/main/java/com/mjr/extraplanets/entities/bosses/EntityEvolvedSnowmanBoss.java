package com.mjr.extraplanets.entities.bosses;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.core.entities.EntityAIArrowAttack;
import micdoodle8.mods.galacticraft.core.entities.EntityBossBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

import com.mjr.extraplanets.entities.projectiles.EntitySmallSnowball;
import com.mjr.extraplanets.items.ExtraPlanets_Items;

public class EntityEvolvedSnowmanBoss extends EntityBossBase implements IRangedAttackMob, IEntityBreathable {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EntityEvolvedSnowmanBoss(World p_i1692_1_) {
		super(p_i1692_1_);
		this.setSize(0.4F * 8, 1.8F * 6.5F);
		this.tasks.addTask(1, new EntityAIArrowAttack(this, 0.75D, 20, 5F));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 12.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false, true));
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled() {
		return true;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(500.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
	}

//	@Override
//	protected String getLivingSound() {
//		return null;
//	}
//
//	@Override
//	protected String getHurtSound() {
//		this.playSound(Constants.TEXTURE_PREFIX + "entity.bossliving", this.getSoundVolume(), this.getSoundPitch() + 6.0F);
//		return null;
//	}
//
//	@Override
//	protected String getDeathSound() {
//		return null;
//	}

	@Override
	protected Item getDropItem() {
		return Items.SNOWBALL;
	}

	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param par2 - Level of Looting used to kill this mob.
	 */
	@Override
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		int j = this.rand.nextInt(16);

		for (int k = 0; k < j; ++k) {
			this.dropItem(Items.SNOWBALL, 1);
		}
	}

	/**
	 * Attack the specified entity using a ranged attack.
	 */
	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_) {
		EntitySmallSnowball entitysnowball = new EntitySmallSnowball(this.worldObj, this);
		double d0 = p_82196_1_.posX - this.posX;
		double d1 = p_82196_1_.posY + p_82196_1_.getEyeHeight() - 1.100000023841858D - entitysnowball.posY;
		double d2 = p_82196_1_.posZ - this.posZ;
		entitysnowball.setThrowableHeading(d0, d1, d2, 1.6F, 1.0F);
		//this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.worldObj.spawnEntityInWorld(entitysnowball);
	}

	@Override
	public boolean canBreath() {
		return true;
	}

	@Override
	public int getChestTier() {
		return 8;
	}

	@Override
	public void dropKey() {
		this.entityDropItem(new ItemStack(ExtraPlanets_Items.TIER_8_KEY, 1, 0), 0.5F);
	}

	@Override
	public ItemStack getGuaranteedLoot(Random rand) {
		List<ItemStack> stackList = GalacticraftRegistry.getDungeonLoot(9);
		return stackList.get(rand.nextInt(stackList.size())).copy();
	}

	@Override
	public Color getHealthBarColor() {
		return Color.BLUE;
	}
}