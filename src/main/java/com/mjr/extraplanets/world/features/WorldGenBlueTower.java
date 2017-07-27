package com.mjr.extraplanets.world.features;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.storage.loot.LootTableList;

import com.mjr.extraplanets.Config;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

public class WorldGenBlueTower extends WorldGenerator {

	public WorldGenBlueTower() {

	}

	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				try {
					if (world.getBlockState(new BlockPos(x + i, y - 3, z + j)) == Blocks.AIR)
						return false;
				} catch (Exception ex) {
					System.out.println("ExtraPlanets: " + ex.getMessage());
				}
			}
		}
		if (!world.isAreaLoaded(new BlockPos(x + 10, y, z + 10), 10))
			return false;
		else {
			if (Config.DEBUG_MODE)
				System.out.println("Spawning Blue Tower at (x, y, z)" + x + " " + y + " " + z);
			y = y - 2;
			generate_r0(world, rand, x, y, z);
			fillChests(world, rand, x, y, z);
			return true;
		}
	}

	public boolean generate_r0(World world, Random rand, int x, int y, int z) {
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 3), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 3), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 3), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 3), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 3), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 4), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 4), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 4), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 4), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 4), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 5), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 5), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 5), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 5), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 5), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 0, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 0, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 0, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 0, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 0, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 3), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		if(Config.NUCLEAR_BOMB){
			world.setBlockState(new BlockPos(x + 3, y + 1, z + 3), ExtraPlanets_Blocks.NUCLEAR_BOMB.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 4, y + 1, z + 3), ExtraPlanets_Blocks.NUCLEAR_BOMB.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 5, y + 1, z + 3), ExtraPlanets_Blocks.NUCLEAR_BOMB.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 3, y + 1, z + 4), ExtraPlanets_Blocks.NUCLEAR_BOMB.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 5, y + 1, z + 4), ExtraPlanets_Blocks.NUCLEAR_BOMB.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 3, y + 1, z + 5), ExtraPlanets_Blocks.NUCLEAR_BOMB.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 4, y + 1, z + 5), ExtraPlanets_Blocks.NUCLEAR_BOMB.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 5, y + 1, z + 5), ExtraPlanets_Blocks.NUCLEAR_BOMB.getDefaultState(), 3);
		}
		else if(Config.FIRE_BOMB){
			world.setBlockState(new BlockPos(x + 3, y + 1, z + 3), ExtraPlanets_Blocks.FIRE_BOMB.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 4, y + 1, z + 3), ExtraPlanets_Blocks.FIRE_BOMB.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 5, y + 1, z + 3), ExtraPlanets_Blocks.FIRE_BOMB.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 3, y + 1, z + 4), ExtraPlanets_Blocks.FIRE_BOMB.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 5, y + 1, z + 4), ExtraPlanets_Blocks.FIRE_BOMB.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 3, y + 1, z + 5), ExtraPlanets_Blocks.FIRE_BOMB.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 4, y + 1, z + 5), ExtraPlanets_Blocks.FIRE_BOMB.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 5, y + 1, z + 5), ExtraPlanets_Blocks.FIRE_BOMB.getDefaultState(), 3);
		}
		else{
			world.setBlockState(new BlockPos(x + 3, y + 1, z + 3), Blocks.TNT.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 4, y + 1, z + 3), Blocks.TNT.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 5, y + 1, z + 3), Blocks.TNT.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 3, y + 1, z + 4), Blocks.TNT.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 5, y + 1, z + 4), Blocks.TNT.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 3, y + 1, z + 5), Blocks.TNT.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 4, y + 1, z + 5), Blocks.TNT.getDefaultState(), 3);
			world.setBlockState(new BlockPos(x + 5, y + 1, z + 5), Blocks.TNT.getDefaultState(), 3);
		}
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 3), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 4), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 4), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 4), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 5), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 5), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 1, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 1, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 1, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 1, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 1, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 3), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 3), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 3), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 3), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 3), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 4), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 4), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 4), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 4), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 4), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 5), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 5), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 5), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 5), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 5), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 2, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 2, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 2, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 2, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 2, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 4), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 7, y + 3, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 3, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 6, y + 3, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 4), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 4, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 6, y + 4, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 1, y + 4, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 4, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 5, z + 1), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 5, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 3, y + 5, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 4, y + 5, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 5, y + 5, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 6, y + 5, z + 2), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 7, y + 5, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 5, z + 3), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 3, y + 5, z + 3), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 5, y + 5, z + 3), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 6, y + 5, z + 3), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 7, y + 5, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 5, z + 4), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 3, y + 5, z + 4), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 4, y + 5, z + 4), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 5, y + 5, z + 4), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 6, y + 5, z + 4), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 7, y + 5, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 1, y + 5, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 5, z + 5), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 3, y + 5, z + 5), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 4, y + 5, z + 5), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 5, y + 5, z + 5), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 6, y + 5, z + 5), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 7, y + 5, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 5, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 5, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 3, y + 5, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 4, y + 5, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 5, y + 5, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 6, y + 5, z + 6), ExtraPlanets_Blocks.KEPLER22B_BLOCKS.getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(x + 1, y + 5, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 5, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 5, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 5, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 5, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 5, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 5, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 5, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 6, z + 0), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 6, z + 0), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 0), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 6, z + 1), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 6, z + 1), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 6, z + 1), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 6, z + 1), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 1), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 6, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 6, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 6, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 4, y + 6, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 5, y + 6, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 7, y + 6, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 6, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 6, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 7, y + 6, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 6, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 6, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 6, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 3, y + 6, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 5, y + 6, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 7, y + 6, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 6, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 6, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 6, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 4, y + 6, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 5, y + 6, z + 5), Blocks.CHEST.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 7, y + 6, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 8, y + 6, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 0, y + 6, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 6, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 6, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 6, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 4, y + 6, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 5, y + 6, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LOG.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 7, y + 6, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 1, y + 6, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 6, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 6, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 6, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 6, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 6, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 6, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 7, z + 0), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 7, z + 0), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 7, z + 1), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 7, z + 1), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 7, z + 1), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 7, z + 1), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 7, z + 1), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 7, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 7, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 7, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 7, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 7, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 7, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 7, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 7, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 6, y + 7, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 7, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 2, y + 7, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 7, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 5, y + 7, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 6, y + 7, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 7, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 7, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 7, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 4, y + 7, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 5, y + 7, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 7, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 7, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 8, y + 7, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 7, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 3, y + 7, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 7, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 7, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 7, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 7, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 7, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 7, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 7, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 7, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 7, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 7, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 7, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 7, z + 8), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 8, z + 1), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 8, z + 1), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 8, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 8, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 8, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 8, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 8, z + 2), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 8, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 8, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 8, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 8, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 8, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 7, y + 8, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getStateFromMeta(8), 3);
		world.setBlockState(new BlockPos(x + 2, y + 8, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 8, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 8, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 8, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 8, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 8, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 2, y + 8, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 8, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 8, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 8, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 8, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 8, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 8, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 8, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 8, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 7, y + 8, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 8, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 8, z + 7), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 9, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 9, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 9, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 9, z + 3), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 9, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 9, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 9, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 9, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 9, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 9, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 9, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 9, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 9, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 6, y + 9, z + 6), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 10, z + 4), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 10, z + 5), ExtraPlanets_Blocks.KEPLER22B_MAPLE_LEAF.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 4, z + 3), Blocks.LADDER.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 4, y + 5, z + 3), Blocks.LADDER.getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 3), Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 3), Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 3), Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 4), Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 4), Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 3, y + 3, z + 5), Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 4, y + 3, z + 5), Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), 3);
		world.setBlockState(new BlockPos(x + 5, y + 3, z + 5), Blocks.WOODEN_PRESSURE_PLATE.getDefaultState(), 3);
		return true;
	}

	public boolean fillChests(World world, Random rand, int x, int y, int z) {
		// Determined if loot should be generated using a 1/2 chance
		int random = rand.nextInt(10) + 1;
		if (random <= 6) {
			TileEntityChest chest = (TileEntityChest) world.getTileEntity(new BlockPos(x + 5, y + 6, z + 5));

			if (chest != null) {
				for (int j = 0; j < chest.getSizeInventory(); j++) {
					chest.setInventorySlotContents(j, ItemStack.EMPTY);
				}
				chest.setLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, rand.nextLong());
			}
		}
		return false;
	}
}