package pl.hipcio.hiptonmod;

import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(modid = HiptonMod.MODID, name = HiptonMod.NAME, version = HiptonMod.VERSION)
public class HiptonMod {

    public static final String MODID = "hiptonmod";
    public static final String NAME = "Hipton Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;

    private HiptonOreBlock hiptonOreBlock;
    private ItemBlock hiptonOreItemBlock;
    private HiptonStoneBlock hiptonStoneBlock;
    private ItemBlock hiptonStoneItemBlock;
    public static HiptonEggBlock hiptonEggBlock;
    private ItemBlock hiptonEggItemBlock;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        createBlocks();
        createEntities();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void createBlocks() {
        hiptonOreBlock = new HiptonOreBlock();
        hiptonStoneBlock = new HiptonStoneBlock();
        hiptonEggBlock = new HiptonEggBlock();

        hiptonOreItemBlock = new ItemBlock(hiptonOreBlock);
        hiptonOreItemBlock.setRegistryName(hiptonOreBlock.getRegistryName());

        hiptonStoneItemBlock = new ItemBlock(hiptonStoneBlock);
        hiptonStoneItemBlock.setRegistryName(hiptonStoneBlock.getRegistryName());

        hiptonEggItemBlock = new ItemBlock(hiptonEggBlock);
        hiptonEggItemBlock.setRegistryName(hiptonEggBlock.getRegistryName());
    }

    private void createEntities() {
        logger.info("*** Registering Hipton entity");
        EntityRegistry.registerModEntity(new ResourceLocation(HiptonMod.MODID, "Hipton"), Hipton.class, HiptonMod.MODID + ".Hipton", 0, this, 80, 3, true, 0x3F3024, 0xFFFFFF);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("*** Initializing Hipton Mod");
    }

    @EventHandler
    public void init(FMLPostInitializationEvent event) {
        logger.info("*** Registering Hipton model and renderer");
        RenderingRegistry.registerEntityRenderingHandler(Hipton.class, new RenderHipton(Minecraft.getMinecraft().getRenderManager(), new ModelHipton(), 0));
    }
    
    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        logger.info("*** Registering Hipton Ore block");
        event.getRegistry().register(hiptonOreBlock);
        event.getRegistry().register(hiptonStoneBlock);
        event.getRegistry().register(hiptonEggBlock);
    }

    @SubscribeEvent
    public void registerItemBlocks(RegistryEvent.Register<Item> event) {
        logger.info("*** Registering Hipton Ore item block");
        event.getRegistry().register(hiptonOreItemBlock);
        event.getRegistry().register(hiptonStoneItemBlock);
        event.getRegistry().register(hiptonEggItemBlock);

        ModelResourceLocation oreBlockResourceLocation = new ModelResourceLocation(MODID + ":" + hiptonOreItemBlock.getUnlocalizedName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(hiptonOreItemBlock, 0, oreBlockResourceLocation);

        ModelResourceLocation stoneBlockResourceLocation = new ModelResourceLocation(MODID + ":" + hiptonStoneItemBlock.getUnlocalizedName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(hiptonStoneItemBlock, 0, stoneBlockResourceLocation);

        ModelResourceLocation eggBlockResourceLocation = new ModelResourceLocation(MODID + ":" + hiptonEggItemBlock.getUnlocalizedName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(hiptonEggItemBlock, 0, eggBlockResourceLocation);
    }
}
