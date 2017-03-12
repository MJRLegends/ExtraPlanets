package com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;
import com.mjr.extraplanets.blocks.ExtraPlanets_Blocks;
import com.mjr.extraplanets.planets.Kepler22b.worldgen.features.WorldGenKepler22bTree;

public class BlockKepler22bMapleTreeSapling extends BlockBush implements IGrowable, IPlantable
{
    public static final PropertyEnum<BlockBasicKepler22bPlanks.EnumType> TYPE = PropertyEnum.<BlockBasicKepler22bPlanks.EnumType>create("type", BlockBasicKepler22bPlanks.EnumType.class);
    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);

    public BlockKepler22bMapleTreeSapling()
    {
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, BlockBasicKepler22bPlanks.EnumType.MAPLE_BLUE).withProperty(STAGE, Integer.valueOf(0)));
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setCreativeTab(ExtraPlanets.BlocksTab);
    }

    /**
     * Gets the localized name of this block. Used for the statistics page.
     */
    public String getLocalizedName()
    {
        return StatCollector.translateToLocal(this.getUnlocalizedName() + "." + BlockBasicKepler22bPlanks.EnumType.MAPLE_BLUE.getUnlocalizedName() + ".name");
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            super.updateTick(worldIn, pos, state, rand);

            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
            {
                this.grow(worldIn, pos, state, rand);
            }
        }
    }

    public void grow(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (((Integer)state.getValue(STAGE)).intValue() == 0)
        {
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        }
        else
        {
            this.generateTree(worldIn, pos, state, rand);
        }
    }

    public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;
        WorldGenerator worldgenerator = (WorldGenerator)(rand.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true));
        int i = 0;
        int j = 0;
        boolean flag = false;

        switch ((BlockBasicKepler22bPlanks.EnumType)state.getValue(TYPE))
        {
            case MAPLE_BLUE:
                worldgenerator = new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.kepler22bMapleLog.getStateFromMeta(0), ExtraPlanets_Blocks.kepler22bMapleLeaf.getStateFromMeta(0), false);
                break;
            case MAPLE_RED:
                worldgenerator = new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.kepler22bMapleLog.getStateFromMeta(1), ExtraPlanets_Blocks.kepler22bMapleLeaf.getStateFromMeta(1), false);
                break;
            case MAPLE_PURPLE:
                worldgenerator = new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.kepler22bMapleLog.getStateFromMeta(2), ExtraPlanets_Blocks.kepler22bMapleLeaf.getStateFromMeta(2), false);
                break;
            case MAPLE_YELLOW:
                worldgenerator = new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.kepler22bMapleLog.getStateFromMeta(3), ExtraPlanets_Blocks.kepler22bMapleLeaf.getStateFromMeta(3), false);
                break;
            case MAPLE_GREEN:
                worldgenerator = new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.kepler22bMapleLog2.getStateFromMeta(0), ExtraPlanets_Blocks.kepler22bMapleLeaf.getStateFromMeta(4), false);
                break;
            case MAPLE_BROWN:
                worldgenerator = new WorldGenKepler22bTree(true, 8, ExtraPlanets_Blocks.kepler22bMapleLog2.getStateFromMeta(1), ExtraPlanets_Blocks.kepler22bMapleLeaf.getStateFromMeta(5), false);
                break;
        }
        worldIn.setBlockToAir(pos);

        if (!((WorldGenerator)worldgenerator).generate(worldIn, rand, pos))
        {
        	worldIn.setBlockState(pos, state, 2);
        }
    }

    private boolean func_181624_a(World p_181624_1_, BlockPos p_181624_2_, int p_181624_3_, int p_181624_4_, BlockBasicKepler22bPlanks.EnumType p_181624_5_)
    {
        return this.isTypeAt(p_181624_1_, p_181624_2_.add(p_181624_3_, 0, p_181624_4_), p_181624_5_) && this.isTypeAt(p_181624_1_, p_181624_2_.add(p_181624_3_ + 1, 0, p_181624_4_), p_181624_5_) && this.isTypeAt(p_181624_1_, p_181624_2_.add(p_181624_3_, 0, p_181624_4_ + 1), p_181624_5_) && this.isTypeAt(p_181624_1_, p_181624_2_.add(p_181624_3_ + 1, 0, p_181624_4_ + 1), p_181624_5_);
    }

    /**
     * Check whether the given BlockPos has a Sapling of the given type
     */
    public boolean isTypeAt(World worldIn, BlockPos pos, BlockBasicKepler22bPlanks.EnumType type)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        return iblockstate.getBlock() == this && iblockstate.getValue(TYPE) == type;
    }

    /**
     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
    public int damageDropped(IBlockState state)
    {
        return ((BlockBasicKepler22bPlanks.EnumType)state.getValue(TYPE)).getMetadata();
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (BlockBasicKepler22bPlanks.EnumType blockplanks$enumtype : BlockBasicKepler22bPlanks.EnumType.values())
        {
            list.add(new ItemStack(itemIn, 1, blockplanks$enumtype.getMetadata()));
        }
    }

    /**
     * Whether this IGrowable can grow
     */
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
        return true;
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        return (double)worldIn.rand.nextFloat() < 0.45D;
    }

    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        this.grow(worldIn, pos, state, rand);
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(TYPE, BlockBasicKepler22bPlanks.EnumType.byMetadata(meta & 7)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((BlockBasicKepler22bPlanks.EnumType)state.getValue(TYPE)).getMetadata();
        i = i | ((Integer)state.getValue(STAGE)).intValue() << 3;
        return i;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {TYPE, STAGE});
    }
}