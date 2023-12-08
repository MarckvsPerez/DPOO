package edu.uoc.pac4.wrestler.properties;

public class StaminaProperties implements WrestlerProperties {

    private double bodyDurability;
    private double armDurability;
    private double legDurability;

    // Constructor
    public StaminaProperties(double bodyDurability, double armDurability, double legDurability) {
        setBodyDurability(bodyDurability);
        setArmDurability(armDurability);
        setLegDurability(legDurability);
    }

    // Setters
    private void setBodyDurability(double bodyDurability) {
        if (bodyDurability >= 0 && bodyDurability <= 100) {
            this.bodyDurability = bodyDurability;
        } else {
            this.bodyDurability = 50;
        }
    }

    private void setArmDurability(double armDurability) {
        if (armDurability >= 0 && armDurability <= 100) {
            this.armDurability = armDurability;
        } else {
            this.armDurability = 50;
        }
    }

    private void setLegDurability(double legDurability) {
        if (legDurability >= 0 && legDurability <= 100) {
            this.legDurability = legDurability;
        } else {
            this.legDurability = 50;
        }
    }

    // Getters
    public double getBodyDurability() {
        return bodyDurability;
    }


    public double getArmDurability() {
        return armDurability;
    }

    public double getLegDurability() {
        return legDurability;
    }

    // Métodos adicionales según las indicaciones
    public double getOverall() {
        return (bodyDurability + armDurability + legDurability) / 3.0;
    }

    public int size() {
        return 3; // Número de propiedades en StaminaProperties
    }


}
