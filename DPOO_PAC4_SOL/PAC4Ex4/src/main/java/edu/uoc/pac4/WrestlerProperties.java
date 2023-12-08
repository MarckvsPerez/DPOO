package edu.uoc.pac4;

public class WrestlerProperties implements Cloneable{

    double strength;
    double agility;
    double stamina;
    double technique;
    double defense;

    public WrestlerProperties(double strength, double agility, double stamina, double technique, double defense) {
        this.strength = strength;
        this.agility = agility;
        this.stamina = stamina;
        this.technique = technique;
        this.defense = defense;
    }

    public double getStrength() {
        return strength;
    }

    public double getAgility() {
        return agility;
    }

    public double getStamina() {
        return stamina;
    }

    public double getTechnique() {
        return technique;
    }

    public double getDefense() {
        return defense;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
