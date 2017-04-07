package com.mjr.extraplanets.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.entities.EntityNuclearBombPrimed;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNuclearBomb extends Block {
	@SideOnly(Side.CLIENT)
	private IIcon field_150116_a;
	@SideOnly(Side.CLIENT)
	private IIcon field_150115_b;

	public BlockNuclearBomb() {
		super(Material.tnt);
		this.setCreativeTab(ExtraPlanets.BlocksTab);
		this.setBlockName("nuclearBomb");
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		return p_149691_1_ == 0 ? this.field_150115_b : (p_149691_1_ == 1 ? this.field_150116_a : this.blockIcon);
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	@Override
	public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
		super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);

		if (p_149726_1_.isBlockIndirectlyGettingPowered(p_149726_2_, p_149726_3_, p_149726_4_)) {
			this.onBlockDestroyedByPlayer(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_, 1);
			p_149726_1_.setBlockToAir(p_149726_2_, p_149726_3_, p_149726_4_);
		}
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are their own) Args: x, y, z, neighbor Block
	 */
	@Override
	public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
		if (p_149695_1_.isBlockIndirectlyGettingPowered(p_149695_2_, p_149695_3_, p_149695_4_)) {
			this.onBlockDestroyedByPlayer(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, 1);
			p_149695_1_.setBlockToAir(p_149695_2_, p_149695_3_, p_149695_4_);
		}
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random p_149745_1_) {
		return 1;
	}

	/**
	 * Called upon the block being destroyed by an explosion
	 */
	@Override
	public void onBlockDestroyedByExplosion(World p_149723_1_, int p_149723_2_, int p_149723_3_, int p_149723_4_, Explosion p_149723_5_) {
		if (!p_149723_1_.isRemote) {
			EntityNuclearBombPrimed entitynuclearBombprimed = new EntityNuclearBombPrimed(p_149723_1_, p_149723_2_ + 0.5F, p_149723_3_ + 0.5F, p_149723_4_ + 0.5F, p_149723_5_.getExplosivePlacedBy());
			entitynuclearBombprimed.fuse = p_149723_1_.rand.nextInt(entitynuclearBombprimed.fuse / 4) + entitynuclearBombprimed.fuse / 8;
			p_149723_1_.spawnEntityInWorld(entitynuclearBombprimed);
		}
	}

	/**
	 * Called right before the block is destroyed by a player. Args: world, x, y, z, metaData
	 */
	@Override
	public void onBlockDestroyedByPlayer(World p_149664_1_, int p_149664_2_, int p_149664_3_, int p_149664_4_, int p_149664_5_) {
		this.primeTnt(p_149664_1_, p_149664_2_, p_149664_3_, p_149664_4_, p_149664_5_, (EntityLivingBase) null);
	}

	public void primeTnt(World p_150114_1_, int p_150114_2_, int p_150114_3_, int p_150114_4_, int p_150114_5_, EntityLivingBase p_150114_6_) {
		if (!p_150114_1_.isRemote) {
			if ((p_150114_5_ & 1) == 1) {
				EntityNuclearBombPrimed entitynuclearBombprimed = new EntityNuclearBombPrimed(p_150114_1_, p_150114_2_ + 0.5F, p_150114_3_ + 0.5F, p_150114_4_ + 0.5F, p_150114_6_);
				p_150114_1_.spawnEntityInWorld(entitynuclearBombprimed);
				p_150114_1_.playSoundAtEntity(entitynuclearBombprimed, "game.tnt.primed", 1.0F, 1.0F);
			}
		}
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		if (p_149727_5_.getCurrentEquippedItem() != null && p_149727_5_.getCurrentEquippedItem().getItem() == Items.flint_and_steel) {
			this.primeTnt(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, 1, p_149727_5_);
			p_149727_1_.setBlockToAir(p_149727_2_, p_149727_3_, p_149727_4_);
			p_149727_5_.getCurrentEquippedItem().damageItem(1, p_149727_5_);
			return true;
		} else {
			return super.onBlockActivated(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_5_, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
		}
	}

	/**
	 * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
	 */
	@Override
	public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
		if (p_149670_5_ instanceof EntityArrow && !p_149670_1_.isRemote) {
			EntityArrow entityarrow = (EntityArrow) p_149670_5_;

			if (entityarrow.isBurning()) {
				this.primeTnt(p_149670_1_, p_149670_2_, p_149670_3_, p_149670_4_, 1, entityarrow.shootingEntity instanceof EntityLivingBase ? (EntityLivingBase) entityarrow.shootingEntity : null);
				p_149670_1_.setBlockToAir(p_149670_2_, p_149670_3_, p_149670_4_);
			}
		}
	}

	/**
	 * Return whether this block can drop from an explosion.
	 */
	@Override
	public boolean canDropFromExplosion(Explosion p_149659_1_) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		this.blockIcon = p_149651_1_.registerIcon(Constants.TEXTURE_PREFIX + "nuclearBomb" + "_side");
		this.field_150116_a = p_149651_1_.registerIcon(Constants.TEXTURE_PREFIX + "nuclearBomb" + "_top");
		this.field_150115_b = p_149651_1_.registerIcon(Constants.TEXTURE_PREFIX + "nuclearBomb" + "_bottom");
	}
}
