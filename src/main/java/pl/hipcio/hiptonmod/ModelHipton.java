package pl.hipcio.hiptonmod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHipton extends ModelBase {

    private ModelRenderer body;
    private ModelRenderer head;

    private ModelRenderer frontLeftLeg;
    private ModelRenderer frontRightLeg;

    private ModelRenderer frontMiddleLeftLeg;
    private ModelRenderer frontMiddleRightLeg;

    private ModelRenderer backMiddleLeftLeg;
    private ModelRenderer backMiddleRightLeg;

    private ModelRenderer backLeftLeg;
    private ModelRenderer backRightLeg;

    public ModelHipton() {
        body = new ModelRenderer(this, 0, 0);
        body.addBox(6, 13, 5, 10, 5, 13);
        body.setRotationPoint(0, 0, 0);
        body.setTextureSize(16, 16);

        head = new ModelRenderer(this, 0, 0);
        head.addBox(6, 16, 2, 10, 6, 5);
        head.setRotationPoint(0, 0, 0);
        head.setTextureSize(16, 16);

        frontLeftLeg = new ModelRenderer(this, 0, 0);
        frontLeftLeg.addBox(0, 0, 0, 7, 2, 2);
        frontLeftLeg.setRotationPoint(16, 18, 7);
        frontLeftLeg.setTextureSize(16, 16);
        
        frontLeftLeg.rotateAngleX = getAngle(90);
        frontLeftLeg.rotateAngleY = getAngle(0);
        frontLeftLeg.rotateAngleZ = getAngle(30);

        frontRightLeg = new ModelRenderer(this, 0, 0);
        frontRightLeg.addBox(0, 0, 0, 7, 2, 2);
        frontRightLeg.setRotationPoint(6, 18, 7);
        frontRightLeg.setTextureSize(16, 16);
        
        frontRightLeg.rotateAngleX = getAngle(180);
        frontRightLeg.rotateAngleY = getAngle(180);
        frontRightLeg.rotateAngleZ = getAngle(-30);   
        
        frontMiddleLeftLeg = new ModelRenderer(this, 0, 0);
        frontMiddleLeftLeg.addBox(0, 0, 0, 7, 2, 2);
        frontMiddleLeftLeg.setRotationPoint(16, 18, 10);
        frontMiddleLeftLeg.setTextureSize(16, 16);

        frontMiddleLeftLeg.rotateAngleX = getAngle(90);
        frontMiddleLeftLeg.rotateAngleY = getAngle(0);
        frontMiddleLeftLeg.rotateAngleZ = getAngle(30);
        
        frontMiddleRightLeg = new ModelRenderer(this, 0, 0);
        frontMiddleRightLeg.addBox(0, 0, 0, 7, 2, 2);
        frontMiddleRightLeg.setRotationPoint(6, 18, 13);
        frontMiddleRightLeg.setTextureSize(16, 16);

        frontMiddleRightLeg.rotateAngleX = getAngle(180);
        frontMiddleRightLeg.rotateAngleY = getAngle(180);
        frontMiddleRightLeg.rotateAngleZ = getAngle(-30);   

        backMiddleLeftLeg = new ModelRenderer(this, 0, 0);
        backMiddleLeftLeg.addBox(0, 0, 0, 7, 2, 2);
        backMiddleLeftLeg.setRotationPoint(16, 18, 13);
        backMiddleLeftLeg.setTextureSize(16, 16);

        backMiddleLeftLeg.rotateAngleX = getAngle(90);
        backMiddleLeftLeg.rotateAngleY = getAngle(0);
        backMiddleLeftLeg.rotateAngleZ = getAngle(30);
        
        backMiddleRightLeg = new ModelRenderer(this, 0, 0);
        backMiddleRightLeg.addBox(0, 0, 0, 7, 2, 2);
        backMiddleRightLeg.setRotationPoint(6, 18, 10);
        backMiddleRightLeg.setTextureSize(16, 16);

        backMiddleRightLeg.rotateAngleX = getAngle(180);
        backMiddleRightLeg.rotateAngleY = getAngle(180);
        backMiddleRightLeg.rotateAngleZ = getAngle(-30);   
    
        backLeftLeg = new ModelRenderer(this, 0, 0);
        backLeftLeg.addBox(0, 0, 0, 7, 2, 2);
        backLeftLeg.setRotationPoint(16, 18, 16);
        backLeftLeg.setTextureSize(16, 16);

        backLeftLeg.rotateAngleX = getAngle(90);
        backLeftLeg.rotateAngleY = getAngle(0);
        backLeftLeg.rotateAngleZ = getAngle(30);
        
        backRightLeg = new ModelRenderer(this, 0, 0);
        backRightLeg.addBox(0, 0, 0, 7, 2, 2);
        backRightLeg.setRotationPoint(6, 18, 16);
        backRightLeg.setTextureSize(16, 16);

        backRightLeg.rotateAngleX = getAngle(180);
        backRightLeg.rotateAngleY = getAngle(180);
        backRightLeg.rotateAngleZ = getAngle(-30);   

    }

    @Override
    public void render(Entity parEntity, float parTime, float parSwingSuppress, float par4, float parHeadAngleY, float parHeadAngleX, float par7) {
        body.render(par7);
        head.render(par7);

        frontLeftLeg.render(par7);
        frontRightLeg.render(par7);
        frontMiddleLeftLeg.render(par7);
        frontMiddleRightLeg.render(par7);
        backMiddleLeftLeg.render(par7);
        backMiddleRightLeg.render(par7);
        backLeftLeg.render(par7);
        backRightLeg.render(par7);
        
    }
    
    private float getAngle(double angleInDegrees) {
        return (float) (angleInDegrees * Math.PI / 180);
    }
}