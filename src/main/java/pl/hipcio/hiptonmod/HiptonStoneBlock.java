package pl.hipcio.hiptonmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;



public class HiptonStoneBlock extends Block {

    public HiptonStoneBlock() {
        super(Material.ROCK);
       
        setRegistryName("hiptonStoneBlock");
        setUnlocalizedName("hiptonStoneBlock");
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setHardness(15.5f);
        
      
      }
    }


