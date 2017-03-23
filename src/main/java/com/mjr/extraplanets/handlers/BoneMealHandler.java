package com.mjr.extraplanets.handlers;

import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class BoneMealHandler {
	@SubscribeEvent
	public void usedBonemeal(BonemealEvent event) {
		if (event.block == ExtraPlanets_Blocks.kepler22bMapleSapling) {
			if (!event.world.isRemote) {
				// ((BlockKepler22bMapleTreeSapling) ExtraPlanets_Blocks.kepler22bMapleSapling).markOrGrowMarked(event.world, event.x, event.y, event.z, event.world.rand);
				// event.setResult(Result.ALLOW);
			}
		}
	}
}
