package com.mjr.extraplanets.entities.bosses.ai;

import net.minecraft.entity.ai.EntityAIAttackMelee;

import com.mjr.extraplanets.entities.bosses.EntityEvolvedGiantZombieBoss;

public class EntityAIBossZombieAttack extends EntityAIAttackMelee {
	private final EntityEvolvedGiantZombieBoss zombie;
	private int raiseArmTicks;

	public EntityAIBossZombieAttack(EntityEvolvedGiantZombieBoss zombieIn, double speedIn, boolean longMemoryIn) {
		super(zombieIn, speedIn, longMemoryIn);
		this.zombie = zombieIn;
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	@Override
	public void startExecuting() {
		super.startExecuting();
		this.raiseArmTicks = 0;
	}

	/**
	 * Resets the task
	 */
	@Override
	public void resetTask() {
		super.resetTask();
		this.zombie.setArmsRaised(false);
	}

	/**
	 * Updates the task
	 */
	@Override
	public void updateTask() {
		super.updateTask();
		++this.raiseArmTicks;

		if (this.raiseArmTicks >= 5 && this.attackTick < 10) {
			this.zombie.setArmsRaised(true);
		} else {
			this.zombie.setArmsRaised(false);
		}
	}
}