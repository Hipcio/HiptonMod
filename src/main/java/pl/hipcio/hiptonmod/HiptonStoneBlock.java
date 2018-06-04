package pl.hipcio.hiptonmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HiptonStoneBlock extends Block {

    public HiptonStoneBlock() {
        super(Material.ROCK);

        setRegistryName("hiptonStoneBlock");
        setUnlocalizedName("hiptonStoneBlock");
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setHardness(15.5f);

    }

    @Override
    public void onBlockClicked(World world, BlockPos position, EntityPlayer player) {
        super.onBlockClicked(world, position, player);
        System.out.println("Jestem tutaj! Kliknęty! " + player.getHeldItemMainhand().getItem().getUnlocalizedName());

        if (player.getHeldItemMainhand().getItem().getUnlocalizedName().equals("item.hatchetDiamond")) {
            world.setBlockState(position, HiptonMod.hiptonEggBlock.getBlockState().getBaseState());
        }
    }
}