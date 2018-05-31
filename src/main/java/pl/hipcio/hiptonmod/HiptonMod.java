package pl.hipcio.hiptonmod;

import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = HiptonMod.MODID, name = HiptonMod.NAME, version = HiptonMod.VERSION)
public class HiptonMod {

    public static final String MODID = "hiptonmod";
    public static final String NAME = "Hipton Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;

    private Block hiptonOreBlock;
    private ItemBlock hiptonOreItemBlock;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        createBlocks();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void createBlocks() {
        hiptonOreBlock = new Block(Material.ROCK);
        hiptonOreBlock.setRegistryName("hiptonOreBlock");
        hiptonOreBlock.setUnlocalizedName("hiptonOreBlock");
        hiptonOreBlock.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        hiptonOreItemBlock = new ItemBlock(hiptonOreBlock);
        hiptonOreItemBlock.setRegistryName(hiptonOreBlock.getRegistryName());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("*** Initializing Hipton Mod");
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        logger.info("*** Registering Hipton Ore block");
        event.getRegistry().register(hiptonOreBlock);
    }

    @SubscribeEvent
    public void registerItemBlocks(RegistryEvent.Register<Item> event) {
        logger.info("*** Registering Hipton Ore item block");
        event.getRegistry().register(hiptonOreItemBlock);
        
        ModelResourceLocation location = new ModelResourceLocation(MODID + ":" + hiptonOreItemBlock.getUnlocalizedName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(hiptonOreItemBlock, 0, location);        
    }
}