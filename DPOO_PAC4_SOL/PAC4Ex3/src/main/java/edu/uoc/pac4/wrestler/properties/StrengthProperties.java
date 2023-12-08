package edu.uoc.pac4.wrestler.properties;

public class StrengthProperties implements WrestlerProperties {

    private double armPower;
    private double legPower;

    // Constructor
    public StrengthProperties(double armPower, double legPower) {
        setArmPower(armPower);
        setLegPower(legPower);
    }

    // Setters
    private void setArmPower(double armPower) {
        if (armPower >= 0 && armPower <= 100) {
            this.armPower = armPower;
        } else {
            this.armPower = 50;
        }
    }

    private void setLegPower(double legPower) {
        if (legPower >= 0 && legPower <= 100) {
            this.legPower = legPower;
        } else {
            this.legPower = 50;
        }
    }

    // Getters
    public double getArmPower() {
        return armPower;
    }

    public double getLegPower() {
        return legPower;
    }

    // Métodos adicionales según las indicaciones
    public double getOverall() {
        return (armPower + legPower) / 2.0;
    }

    public int size() {
        return 2; // Número de propiedades en StrengthProperties
    }


}
