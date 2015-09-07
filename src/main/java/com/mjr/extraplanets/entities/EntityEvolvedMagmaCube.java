package com.mjr.extraplanets.entities;

import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityEvolvedMagmaCube extends EntitySlime implements IEntityBreathable {
	private static final String __OBFID = "CL_00001691";

	public EntityEvolvedMagmaCube(World p_i1737_1_) {
		super(p_i1737_1_);
		this.isImmuneToFire = true;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
	}

	/**
	 * Checks if the entity's current position is a valid location to spawn this
	 * entity.
	 */
	@Override
	public boolean getCanSpawnHere() {
		return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.checkNoEntityCollision(this.boundingBox)
				&& this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty()
				&& !this.worldObj.isAnyLiquid(this.boundingBox);
	}

	/**
	 * Returns the current armor value as determined by a call to
	 * InventoryPlayer.getTotalArmorValue
	 */
	@Override
	public int getTotalArmorValue() {
		return this.getSlimeSize() * 3;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender(float p_70070_1_) {
		return 15728880;
	}

	/**
	 * Gets how bright this entity is.
	 */
	@Override
	public float getBrightness(float p_70013_1_) {
		return 1.0F;
	}

	/**
	 * Returns the name of a particle effect that may be randomly created by
	 * EntitySlime.onUpdate()
	 */
	@Override
	protected String getSlimeParticle() {
		return "flame";
	}

	@Override
	protected EntitySlime createInstance() {
		return new EntityEvolvedMagmaCube(this.worldObj);
	}

	@Override
	protected Item getDropItem() {
		return Items.magma_cream;
	}

	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	@Override
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		Item item = this.getDropItem();

		if (item != null && this.getSlimeSize() > 1) {
			int j = this.rand.nextInt(4) - 2;

			if (p_70628_2_ > 0) {
				j += this.rand.nextInt(p_70628_2_ + 1);
			}

			for (int k = 0; k < j; ++k) {
				this.dropItem(item, 1);
			}
		}
	}

	/**
	 * Returns true if the entity is on fire. Used by render to add the fire
	 * effect on rendering.
	 */
	@Override
	public boolean isBurning() {
		return false;
	}

	/**
	 * Gets the amount of time the slime needs to wait between jumps.
	 */
	@Override
	protected int getJumpDelay() {
		return super.getJumpDelay() * 4;
	}

	@Override
	protected void alterSquishAmount() {
		this.squishAmount *= 0.9F;
	}

	/**
	 * Causes this entity to do an upwards motion (jumping).
	 */
	@Override
	protected void jump() {
		this.motionY = 0.42F + this.getSlimeSize() * 0.1F;
		this.isAirBorne = true;
		net.minecraftforge.common.ForgeHooks.onLivingJump(this);
	}

	/**
	 * Called when the mob is falling. Calculates and applies fall damage.
	 */
	@Override
	protected void fall(float p_70069_1_) {
	}

	/**
	 * Indicates weather the slime is able to damage the player (based upon the
	 * slime's size)
	 */
	@Override
	protected boolean canDamagePlayer() {
		return true;
	}

	/**
	 * Gets the amount of damage dealt to the player when "attacked" by the
	 * slime.
	 */
	@Override
	protected int getAttackStrength() {
		return super.getAttackStrength() + 2;
	}

	/**
	 * Returns the name of the sound played when the slime jumps.
	 */
	@Override
	protected String getJumpSound() {
		return this.getSlimeSize() > 1 ? "mob.magmacube.big" : "mob.magmacube.small";
	}

	/**
	 * Whether or not the current entity is in lava
	 */
	@Override
	public boolean handleLavaMovement() {
		return false;
	}

	/**
	 * Returns true if the slime makes a sound when it lands after a jump (based
	 * upon the slime's size)
	 */
	@Override
	protected boolean makesSoundOnLand() {
		return true;
	}

	@Override
	public boolean canBreath() {
		return true;
	}
}