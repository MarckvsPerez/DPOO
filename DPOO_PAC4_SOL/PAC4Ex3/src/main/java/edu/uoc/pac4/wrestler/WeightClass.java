package edu.uoc.pac4.wrestler;

public enum WeightClass {
    LIGHT_HEAVYWEIGHT(0, 85),
    CRUISERWEIGHT(85.01, 99),
    HEAVYWEIGHT(99.01, 120),
    SUPER_HEAVYWEIGHT(120.01, Double.POSITIVE_INFINITY);

    private double min;
    private double max;

    // Constructor con dos parámetros de tipo double
    WeightClass(double min, double max) {
        this.min = min;
        this.max = max;
    }

    // Método setMin
    public void setMin(double value) {
        this.min = Math.max(0, value);
    }

    // Método setMax
    public void setMax(double value) {
        this.max = Math.max(0, Math.max(this.min, value));
    }

    // Métodos getMin y getMax
    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    // Método getWeightClass
    public static WeightClass getWeightClass(double weight) {
        for (WeightClass weightClass : WeightClass.values()) {
            if (weight >= weightClass.min && weight <= weightClass.max) {
                return weightClass;
            }
        }
        return null; // Puedes manejar este caso según tus necesidades
    }

    // Método isHeavier
    public boolean isHeavier(WeightClass otherClass) {
        return this.max > otherClass.min;
    }
}
