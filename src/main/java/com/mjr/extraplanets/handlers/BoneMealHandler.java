package com.mjr.extraplanets.handlers;

import net.minecraftforge.event.entity.player.BonemealEvent;

import com.mjr.extraplanets.blocks.BlockBasicTreeSapling;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BoneMealHandler {
	@SubscribeEvent
	public void usedBonemeal(BonemealEvent event){
		if (event.block == ExtraPlanets_Blocks.blueMapleSapling) {
			if (!event.world.isRemote) {
				((BlockBasicTreeSapling) ExtraPlanets_Blocks.blueMapleSapling).markOrGrowMarked(event.world, event.x, event.y, event.z, event.world.rand);
				event.setResult(Result.ALLOW);
			}
		} else if (event.block == ExtraPlanets_Blocks.redMapleSapling) {
			if (!event.world.isRemote) {
				((BlockBasicTreeSapling) ExtraPlanets_Blocks.redMapleSapling).markOrGrowMarked(event.world, event.x, event.y, event.z, event.world.rand);
				event.setResult(Result.ALLOW);
			}
		} else if (event.block == ExtraPlanets_Blocks.purpleMapleSapling) {
			if (!event.world.isRemote) {
				((BlockBasicTreeSapling) ExtraPlanets_Blocks.purpleMapleSapling).markOrGrowMarked(event.world, event.x, event.y, event.z, event.world.rand);
				event.setResult(Result.ALLOW);
			}
		} else if (event.block == ExtraPlanets_Blocks.yellowMapleSapling) {
			if (!event.world.isRemote) {
				((BlockBasicTreeSapling) ExtraPlanets_Blocks.yellowMapleSapling).markOrGrowMarked(event.world, event.x, event.y, event.z, event.world.rand);
				event.setResult(Result.ALLOW);
			}
		}
	}
}
