package pl.hipcio.hiptonmod;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHipton extends ModelBase {

    private List<ModelRenderer> elements;

    private long lastReloadTime = 0;
    private long reloadPeriodInSeconds = 2;

    private List<ModelRenderer> reloadModel() {
        List<ModelRenderer> elements = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("../model.csv"));
            for (String line : lines) {
                String[] values = line.split(",");

                String name = values[0].trim();

                int x = parseInt(values[1]);
                int y = parseInt(values[2]);
                int z = parseInt(values[3]);

                int sizeX = parseInt(values[4]);
                int sizeY = parseInt(values[5]);
                int sizeZ = parseInt(values[6]);

                int rotX = parseInt(values[7]);
                int rotY = parseInt(values[8]);
                int rotZ = parseInt(values[9]);

                int rotAlpha = parseInt(values[10]);
                int rotBeta = parseInt(values[11]);
                int rotGamma = parseInt(values[12]);

                System.out.println("Adding element " + name);

                ModelRenderer element = new ModelRenderer(this, 0, 0);
                element.addBox(x, y, z, sizeX, sizeY, sizeZ);
                element.setRotationPoint(rotX, rotY, rotZ);
                element.rotateAngleX = getAngle(rotAlpha);
                element.rotateAngleY = getAngle(rotBeta);
                element.rotateAngleZ = getAngle(rotGamma);

                elements.add(element);
            }

            return elements;
        } catch (Exception ex) {
            throw new RuntimeException("Failed to reload model: " + ex.getMessage() + ": " + ex.getMessage());
        }
    }

    private int parseInt(String s) {
        return Integer.parseInt(s.trim());
    }

    @Override
    public void render(Entity parEntity, float parTime, float parSwingSuppress, float par4, float parHeadAngleY, float parHeadAngleX, float par7) {
        long currentTime = new Date().getTime();
        if (currentTime - lastReloadTime > reloadPeriodInSeconds * 1000) {
            System.out.println("Reloading model");
            elements = reloadModel();
            lastReloadTime = currentTime;
        }

        for (ModelRenderer element : elements) {
            element.render(par7);
        }
    }

    private float getAngle(double angleInDegrees) {
        return (float) (angleInDegrees * Math.PI / 180);
    }
}