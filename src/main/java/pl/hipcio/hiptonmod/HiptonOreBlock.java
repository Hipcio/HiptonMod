package pl.hipcio.hiptonmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class HiptonOreBlock extends Block {

    public HiptonOreBlock() {
        super(Material.ROCK);
            
        setRegistryName("hiptonOreBlock");
        setUnlocalizedName("hiptonOreBlock");
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setHardness(26.5f);
        
    }

}
