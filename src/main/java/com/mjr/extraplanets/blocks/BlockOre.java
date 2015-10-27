package com.mjr.extraplanets.blocks;

import java.util.List;

import ibxm.Player;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import com.mjr.extraplanets.ExtraPlanets;

public class BlockOre extends Block {
	protected BlockOre(Material p_i45394_1_) {
		super(p_i45394_1_);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
		this.setHardness(3F);
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta)
    {
        if(block == ExtraPlanetsBlocks.OreUranium){
        	EntityPlayer entity = world.getClosestPlayer(x + 0.5D, y + 0.5D, z + 0.5D, 10.0);
        	if (entity != null) {
				entity.addPotionEffect(new PotionEffect(Potion.poison.getId(), 50, 1));
			}
        }
    }
}
