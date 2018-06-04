package pl.hipcio.hiptonmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class HiptonEggBlock extends Block {

    public HiptonEggBlock() {
        super(Material.ROCK);

        setRegistryName("hiptonEggBlock");
        setUnlocalizedName("hiptonEggBlock");
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setHardness(10.5f);

    }

    @Override
    public boolean isOpaqueCube(IBlockState p_isOpaqueCube_1_) {
        return false;
    }
}