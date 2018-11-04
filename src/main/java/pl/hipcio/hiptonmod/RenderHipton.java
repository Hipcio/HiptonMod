package pl.hipcio.hiptonmod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderHipton extends RenderLiving<Hipton>{
    
    private ResourceLocation hiptonTexture;

    public RenderHipton(RenderManager renderManager, ModelBase modelBase, float p) {
        super(renderManager, modelBase, p);
        setEntityTexture();
    }
    
    private void setEntityTexture() {
        hiptonTexture = new ResourceLocation(HiptonMod.MODID+":textures/entity/hipton/hipton.png");
    }

    @Override
    protected ResourceLocation getEntityTexture(Hipton hipton) {
        return hiptonTexture;
    }
}