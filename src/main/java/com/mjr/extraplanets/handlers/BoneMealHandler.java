package com.mjr.extraplanets.handlers;

import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b.BlockKepler22bMapleTreeSapling;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class BoneMealHandler {
	@SubscribeEvent
	public void usedBonemeal(BonemealEvent event) {
		if (event.block == ExtraPlanets_Blocks.kepler22bMapleSapling) {
			if (!event.world.isRemote) {
				((BlockKepler22bMapleTreeSapling) ExtraPlanets_Blocks.kepler22bMapleSapling).markOrGrowMarked(event.world, event.x, event.y, event.z, event.world.rand);
				event.setResult(Result.ALLOW);
			}
		}
	}
}
