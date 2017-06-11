package com.mjr.extraplanets.blocks.planetAndMoonBlocks.Kepler22b;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mjr.extraplanets.ExtraPlanets;

public class BlockBasicKepler22bPlanks extends Block
{
	public static final PropertyEnum<BlockBasicKepler22bPlanks.EnumType> VARIANT = PropertyEnum.<BlockBasicKepler22bPlanks.EnumType> create("variant", BlockBasicKepler22bPlanks.EnumType.class);

    public BlockBasicKepler22bPlanks()
    {
        super(Material.WOOD);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockBasicKepler22bPlanks.EnumType.MAPLE_BLUE));
        this.setCreativeTab(ExtraPlanets.BlocksTab);
    }

    /**
     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
    @Override
	public int damageDropped(IBlockState state)
    {
        return state.getValue(VARIANT).getMetadata();
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @Override
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list)
    {
        for (BlockBasicKepler22bPlanks.EnumType blockplanks$enumtype : BlockBasicKepler22bPlanks.EnumType.values())
        {
            list.add(new ItemStack(itemIn, 1, blockplanks$enumtype.getMetadata()));
        }
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    @Override
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BlockBasicKepler22bPlanks.EnumType.byMetadata(meta));
    }

    /**
     * Get the MapColor for this Block and the given BlockState
     */
    @Override
	public MapColor getMapColor(IBlockState state)
    {
        return state.getValue(VARIANT).func_181070_c();
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    @Override
	public int getMetaFromState(IBlockState state)
    {
        return state.getValue(VARIANT).getMetadata();
    }

    @Override
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }

    public static enum EnumType implements IStringSerializable
    {
    	MAPLE_BLUE(0, "maple_blue_plank", MapColor.BLUE),
        MAPLE_RED(1, "maple_red_plank", MapColor.RED),
        MAPLE_PURPLE(2, "maple_purple_plank", MapColor.PURPLE),
        MAPLE_YELLOW(3, "maple_yellow_plank", MapColor.YELLOW),
        MAPLE_GREEN(4, "maple_green_plank", MapColor.GREEN),
        MAPLE_BROWN(5, "maple_brown_plank", MapColor.BROWN);

        private static final BlockBasicKepler22bPlanks.EnumType[] META_LOOKUP = new BlockBasicKepler22bPlanks.EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;
        private final MapColor field_181071_k;

        private EnumType(int p_i46388_3_, String p_i46388_4_, MapColor p_i46388_5_)
        {
            this(p_i46388_3_, p_i46388_4_, p_i46388_4_, p_i46388_5_);
        }

        private EnumType(int p_i46389_3_, String p_i46389_4_, String p_i46389_5_, MapColor p_i46389_6_)
        {
            this.meta = p_i46389_3_;
            this.name = p_i46389_4_;
            this.unlocalizedName = p_i46389_5_;
            this.field_181071_k = p_i46389_6_;
        }

        public int getMetadata()
        {
            return this.meta;
        }

        public MapColor func_181070_c()
        {
            return this.field_181071_k;
        }

        @Override
		public String toString()
        {
            return this.name;
        }

        public static BlockBasicKepler22bPlanks.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        @Override
		public String getName()
        {
            return this.name;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }

        static
        {
            for (BlockBasicKepler22bPlanks.EnumType blockplanks$enumtype : values())
            {
                META_LOOKUP[blockplanks$enumtype.getMetadata()] = blockplanks$enumtype;
            }
        }
    }
}