package edu.uoc.pac4.wrestler.properties;

public class TechniqueProperties implements WrestlerProperties {

    private double holds;

    // Constructor
    public TechniqueProperties(double holds) {
        if (holds >= 0 && holds <= 100) {
            this.holds = holds;
        } else {
            this.holds = 50;
        }
    }

    // Setter
    private void setHolds(double holds) {
        if (holds >= 0 && holds <= 100) {
            this.holds = holds;
        } else {
            this.holds = 50;
        }
    }

    // Getter
    public double getHolds() {
        return holds;
    }

    // Métodos adicionales según las indicaciones
    public double getOverall() {
        return holds;
    }

    public int size() {
        return 1; // Número de propiedades en TechniqueProperties
    }

}
