package com.mjr.extraplanets.handlers;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BoneMealHandler {
	@SubscribeEvent
	public void usedBonemeal(BonemealEvent event) {
		if (event.block == ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING) {
			if (!event.world.isRemote) {
				// ((BlockKepler22bMapleTreeSapling) ExtraPlanets_Blocks.KEPLER22B_MAPLE_SAPLING).markOrGrowMarked(event.world, event.x, event.y, event.z, event.world.rand);
				// event.setResult(Result.ALLOW);
			}
		}
	}
}
