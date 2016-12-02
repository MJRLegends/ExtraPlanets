package com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.common.util.ForgeDirection;

import com.mjr.extraplanets.Constants;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockKepler22bMapleTreeLeaves extends BlockLeavesBase implements IShearable {

	private static String[] leaves = { "blue_maple", "red_maple", "purple_maple", "yellow_maple", "green_maple", "brown_maple" };
	@SideOnly(Side.CLIENT)
	private IIcon[][] leafTextures;
	int[] field_150128_a;
	protected int field_150127_b;
	int[] adjacentTreeBlocks;
	private String name;

	public BlockKepler22bMapleTreeLeaves(String name) {
		super(Material.leaves, false);
		this.setHardness(0.1F);
		this.setTickRandomly(true);
		this.setLightOpacity(1);
		this.setBlockName(name);
		this.name = name;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconReg) {
		this.leafTextures = new IIcon[3][leaves.length];
		for (int i = 0; i < leaves.length; ++i) {
			this.leafTextures[0][i] = iconReg.registerIcon(Constants.TEXTURE_PREFIX + name + "_leaves_" + leaves[i]);
			this.leafTextures[1][i] = iconReg.registerIcon(Constants.TEXTURE_PREFIX + name + "_leaves_" + leaves[i] + "_opaque");
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		setGraphicsLevel(Minecraft.getMinecraft().gameSettings.fancyGraphics);
		return (meta & 3) == 1 ? this.leafTextures[this.field_150127_b][1] : ((meta & 3) == 3 ? this.leafTextures[this.field_150127_b][3] : ((meta & 3) == 2 ? this.leafTextures[this.field_150127_b][2] : this.leafTextures[this.field_150127_b][0]));

	}

	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, net.minecraftforge.common.util.ForgeDirection face) {
		return true;
	}

	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
		return 40;
	}

	public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
		return 10;
	}

	@Override
	public int damageDropped(int meta) {
		return meta & 3;
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
		return ret;
	}

	@Override
	public boolean isLeaves(IBlockAccess world, int x, int y, int z) {
		return true;
	}

	public boolean isOpaqueCube() {
		return !this.field_150121_P;
	}

	@SideOnly(Side.CLIENT)
	public void setGraphicsLevel(boolean par1) {
		this.field_150121_P = par1;
		this.field_150127_b = (par1 ? 0 : 1);
	}

	protected ItemStack createStackedBlock(int par1) {
		return new ItemStack(Item.getItemFromBlock(this), 1, par1 & 3);
	}

	private void removeLeaves(World world, int x, int y, int z) {
		this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
		world.setBlockToAir(x, y, z);
	}

	public int quantityDropped(Random parRandom1) {
		return parRandom1.nextInt(40) == 0 ? 1 : 0;
	}

	public Item getItemDropped(int x, Random yRandom, int z) {
		return Item.getItemFromBlock(ExtraPlanets_Blocks.kepler22bMapleSapling);
	}

	protected void func_150124_c(World world, int x, int y, int z, int meta, int par1) {
		if ((meta & 3) == 0 && world.rand.nextInt(par1) == 0) {
			// this.dropBlockAsItem(world, x, y, z, new
			// ItemStack(MJRTech.examplefood, 1, 0));
		}
	}

	protected int func_150123_b(int par1) {
		int j = par1;

		if ((par1 & 8) == 8) {
			j = 20;
		}

		return j;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List listLeaves) {
		for (int i = 0; i < leaves.length; i++) {
			listLeaves.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public void beginLeavesDecay(World world, int x, int y, int z) {
		int i2 = world.getBlockMetadata(x, y, z);

		if ((i2 & 8) == 0) {
			world.setBlockMetadataWithNotify(x, y, z, i2 | 8, 4);
		}
		world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) | 8, 4);
	}

	public void dropBlockAsItemWithChance(World world, int x, int y, int z, int meta, float par1, int par2) {
		if (!world.isRemote) {
			int j1 = this.func_150123_b(meta);

			if (par2 > 0) {
				j1 -= 2 << par2;

				if (j1 < 10) {
					j1 = 10;
				}
			}
			if (j1 <= 0)
				j1 = 20;

			if (world.rand.nextInt(j1) == 0) {
				Item item = this.getItemDropped(meta, world.rand, par2);
				this.dropBlockAsItem(world, x, y, z, new ItemStack(item, 1, this.damageDropped(meta)));
			}

			j1 = 20;

			if (par2 > 0) {
				j1 -= 10 << par2;

				if (j1 < 10) {
					j1 = 10;
				}
			}

			this.func_150124_c(world, x, y, z, meta, j1);
		}
	}

	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int meta) {
		super.harvestBlock(world, player, x, y, z, meta);
	}

	public void breakBlock(World world, int x, int y, int z, Block bloque, int meta) {
		byte b0 = 1;
		int i1 = b0 + 1;

		if (world.checkChunksExist(x - i1, y - i1, z - i1, x + i1, y + i1, z + i1)) {
			for (int j1 = -b0; j1 <= b0; ++j1) {
				for (int k1 = -b0; k1 <= b0; ++k1) {
					for (int l1 = -b0; l1 <= b0; ++l1) {
						Block block = world.getBlock(x + j1, y + k1, z + l1);
						if (block.isLeaves(world, x + j1, y + k1, z + l1)) {
							block.beginLeavesDecay(world, x + j1, y + k1, z + l1);
						}
					}
				}
			}
		}
	}

	public void updateTick(World world, int x, int y, int z, Random parRandom1) {
		if (!world.isRemote) {
			int l = world.getBlockMetadata(x, y, z);

			if ((l & 8) != 0 && (l & 4) == 0) {
				byte b0 = 4;
				int i1 = b0 + 1;
				byte b1 = 32;
				int j1 = b1 * b1;
				int k1 = b1 / 2;

				if (this.field_150128_a == null) {
					this.field_150128_a = new int[b1 * b1 * b1];
				}

				int l1;

				if (world.checkChunksExist(x - i1, y - i1, z - i1, x + i1, y + i1, z + i1)) {
					int i2;
					int j2;

					for (l1 = -b0; l1 <= b0; ++l1) {
						for (i2 = -b0; i2 <= b0; ++i2) {
							for (j2 = -b0; j2 <= b0; ++j2) {
								Block block = world.getBlock(x + l1, y + i2, z + j2);

								if (!block.canSustainLeaves(world, x + l1, y + i2, z + j2)) {
									if (block.isLeaves(world, x + l1, y + i2, z + j2)) {
										this.field_150128_a[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -2;
									} else {
										this.field_150128_a[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -1;
									}
								} else {
									this.field_150128_a[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = 0;
								}
							}
						}
					}

					for (l1 = 1; l1 <= 4; ++l1) {
						for (i2 = -b0; i2 <= b0; ++i2) {
							for (j2 = -b0; j2 <= b0; ++j2) {
								for (int k2 = -b0; k2 <= b0; ++k2) {
									if (this.field_150128_a[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1] == l1 - 1) {
										if (this.field_150128_a[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2) {
											this.field_150128_a[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
										}

										if (this.field_150128_a[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2) {
											this.field_150128_a[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
										}

										if (this.field_150128_a[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] == -2) {
											this.field_150128_a[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] = l1;
										}

										if (this.field_150128_a[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] == -2) {
											this.field_150128_a[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] = l1;
										}

										if (this.field_150128_a[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] == -2) {
											this.field_150128_a[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] = l1;
										}

										if (this.field_150128_a[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] == -2) {
											this.field_150128_a[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] = l1;
										}
									}
								}
							}
						}
					}
				}

				l1 = this.field_150128_a[k1 * j1 + k1 * b1 + k1];

				if (l1 >= 0) {
					world.setBlockMetadataWithNotify(x, y, z, l & -9, 4);
				} else {
					this.removeLeaves(world, x, y, z);
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random parRandom1) {
		if (world.canLightningStrikeAt(x, y + 1, z) && !World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && parRandom1.nextInt(15) == 1) {
			double d0 = (double) ((float) x + parRandom1.nextFloat());
			double d1 = (double) y - 0.05D;
			double d2 = (double) ((float) z + parRandom1.nextFloat());
			world.spawnParticle("dripWater", d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}

}