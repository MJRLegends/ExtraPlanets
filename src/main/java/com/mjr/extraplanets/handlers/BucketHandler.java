package com.mjr.extraplanets.handlers;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BucketHandler {

	public static BucketHandler INSTANCE = new BucketHandler();
	public Map<Block, Item> buckets = new HashMap<Block, Item>();

	private BucketHandler() {
	}

	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event) {
		RayTraceResult pos = event.getTarget();
		if (pos == null) {
			return;
		}

		ItemStack ret = fillCustomBucket(event.getWorld(), pos);

		if (ret == null) {
			return;
		}

		event.setFilledBucket(ret);
		event.setResult(Result.ALLOW);
	}

	private ItemStack fillCustomBucket(World world, RayTraceResult position) {
		IBlockState state = world.getBlockState(position.getBlockPos());
		Block block = state.getBlock();

		Item bucket = buckets.get(block);

		if (bucket != null && block.getMetaFromState(state) == 0) {
			world.setBlockToAir(position.getBlockPos());
			return new ItemStack(bucket);
		}

		return null;
	}
}
