package com.mjr.extraplanets.blocks.planetAndMoonBlocks;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import micdoodle8.mods.galacticraft.api.block.IPlantableBlock;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;
import micdoodle8.mods.galacticraft.planets.GalacticraftPlanets;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.base.Predicate;
import com.mjr.extraplanets.ExtraPlanets;

public class BlockBasicVenus extends Block implements IDetectableResource, IPlantableBlock, ITerraformableBlock, ISortableBlock
{
    public static final PropertyEnum BASIC_TYPE = PropertyEnum.create("basicTypeVenus", EnumBlockBasic.class);

    public enum EnumBlockBasic implements IStringSerializable
    {
        SURFACE(0, "venus_surface"),
        SUB_SURFACE(1, "venus_sub_surface"),
        STONE(2, "venus_stone"),
        ORE_IRON(3, "venus_ore_iron"),
        ORE_TIN(4, "venus_ore_tin"),
        ORE_COPPER(5, "venus_ore_copper"),
        ORE_CARBON(6, "venus_ore_carbon"),
        CARBON_BLOCK(7, "venus_carbon_block"),
        STONEBRICKS(8, "venus_stonebricks"),
        DUNGEON_BRICK(9, "venus_dungeon_brick");

        private final int meta;
        private final String name;

        private EnumBlockBasic(int meta, String name)
        {
            this.meta = meta;
            this.name = name;
        }

        public int getMeta()
        {
            return this.meta;
        }

        public static EnumBlockBasic byMetadata(int meta)
        {
            return values()[meta];
        }

        @Override
        public String getName()
        {
            return this.name;
        }
    }

    public BlockBasicVenus(String assetName)
    {
        super(Material.rock);
        this.setUnlocalizedName(assetName);
        this.setCreativeTab(ExtraPlanets.BlocksTab);
    }

    @Override
    public MapColor getMapColor(IBlockState state)
    {
        if (state.getValue(BASIC_TYPE) == EnumBlockBasic.DUNGEON_BRICK)
        {
            return MapColor.greenColor;
        }
        else if (state.getValue(BASIC_TYPE) == EnumBlockBasic.SURFACE)
        {
            return MapColor.dirtColor;
        }

        return MapColor.redColor;
    }

    @Override
    public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion)
    {
        IBlockState state = world.getBlockState(pos);

        if (state.getValue(BASIC_TYPE) == EnumBlockBasic.DUNGEON_BRICK)
        {
            return 40.0F;
        }

        return super.getExplosionResistance(world, pos, exploder, explosion);
    }
    
    @Override
    public float getBlockHardness(World worldIn, BlockPos pos)
    {
        IBlockState state = worldIn.getBlockState(pos);

        if (state.getValue(BASIC_TYPE) == EnumBlockBasic.DUNGEON_BRICK)
        {
            return 4.0F;
        }

        return this.blockHardness;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }

    @Override
    public int damageDropped(IBlockState state)
    {
    	int meta = state.getBlock().getMetaFromState(state);
    	return meta;
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random)
    {
        return 1;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (EnumBlockBasic blockBasic : EnumBlockBasic.values())
        {
            par3List.add(new ItemStack(par1, 1, blockBasic.getMeta()));
        }
    }

    @Override
    public boolean isValueable(IBlockState state)
    {
        switch (this.getMetaFromState(state))
        {
        case 0:
        case 1:
        case 2:
        case 3:
            return true;
        default:
            return false;
        }
    }

    @Override
    public boolean canSustainPlant(IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable)
    {
        return false;
    }

    @Override
    public int requiredLiquidBlocksNearby()
    {
        return 4;
    }

    @Override
    public boolean isPlantable(IBlockState arg0) 
    {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (rand.nextInt(10) == 0)
        {
            if (state.getValue(BASIC_TYPE) == EnumBlockBasic.DUNGEON_BRICK)
            {
                GalacticraftPlanets.spawnParticle("sludgeDrip", new Vector3(pos.getX() + rand.nextDouble(), pos.getY(), pos.getZ() + rand.nextDouble()), new Vector3(0, 0, 0));

                if (rand.nextInt(100) == 0)
                {
                    worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(), Constants.TEXTURE_PREFIX + "ambience.singledrip", 1, 0.8F + rand.nextFloat() / 5.0F, false);
                }
            }
        }
    }

    @Override
    public boolean isTerraformable(World world, BlockPos pos)
    {
        IBlockState state = world.getBlockState(pos);
        return state.getValue(BASIC_TYPE) == EnumBlockBasic.SURFACE && !world.getBlockState(pos.up()).getBlock().isFullCube();
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player)
    {
        IBlockState state = world.getBlockState(pos);
        int metadata = state.getBlock().getMetaFromState(state);
        return super.getPickBlock(target, world, pos, player);
    }

    @Override
    public boolean isReplaceableOreGen(World world, BlockPos pos, Predicate<IBlockState> target)
    {
        if (target != Blocks.stone)
        {
            return false;
        }
        IBlockState state = world.getBlockState(pos);
        return (state.getValue(BASIC_TYPE) == EnumBlockBasic.STONE);
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return state.getBlock().getMetaFromState(state) == 10;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(BASIC_TYPE, EnumBlockBasic.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumBlockBasic) state.getValue(BASIC_TYPE)).getMeta();
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, BASIC_TYPE);
    }

    @Override
    public EnumSortCategoryBlock getCategory(int meta)
    {
        switch (meta)
        {
        case 3:
        case 4:
        case 5:
        case 6:
            return EnumSortCategoryBlock.ORE;
        case 7:
            return EnumSortCategoryBlock.INGOT_BLOCK;
        case 8:
        case 9:
            return EnumSortCategoryBlock.BRICKS;
        }
        return EnumSortCategoryBlock.GENERAL;
    }
}
