package de.cadoculus.ocxviewer.models.threed;

import de.cadoculus.ocxviewer.models.InformationProvider;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;

public class Sphere3D extends Group implements InformationProvider {


    private final double radius;
    private final double x;
    private final double y;
    private final double z;
    private final String information;
    private Color colour = Color.RED;
    private final PhongMaterial material = new PhongMaterial();

    public Sphere3D(String name, double radius, double x, double y, double z,
                    String information,  Color colour) {
        setId(name);
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.z = z;
        this.information = information;

        this.colour = colour != null ? colour : this.colour;

        updateMaterial();

        var box = new javafx.scene.shape.Sphere(radius);
        box.setMaterial(material);
        getChildren().add(box);
        setTranslateX(x);
        setTranslateY(y);
        setTranslateZ(z);

    }


    public Color getColour() {
        return colour;
    }

    public void setColour(Color colour) {
        if (colour == null) {
            throw new IllegalArgumentException("color must not be null");
        }
        this.colour = colour;
        updateMaterial();
    }

    private void updateMaterial() {

        material.setDiffuseColor(colour);
        material.setSpecularColor(Color.gray(0.1));
        material.setSpecularPower(8);
    }


    @Override
    public String getName() {
        return getId();
    }

    @Override
    public String getInformation() {
        return information;
    }
}
