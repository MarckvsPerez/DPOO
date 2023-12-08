package edu.uoc.pac4.wrestler;

import edu.uoc.pac4.Gender;
import edu.uoc.pac4.Speakable;
import edu.uoc.pac4.Superstar;
import edu.uoc.pac4.SuperstarException;
import edu.uoc.pac4.wrestler.properties.*;

import java.time.LocalDate;

public abstract class Wrestler extends Superstar implements Speakable, Comparable<Wrestler>{
    public static final int ATTRIBUTES_MIN_VALUE = 1;
    public static final int ATTRIBUTES_MAX_VALUE = 96;
    private static final int ATTRIBUTES_SUM_VALUE = 100;
    private static final String DEFAULT_SIGNATURE = "Superkick";
    private static final String DEFAULT_FINISHER = "Canadian Destroyer";


    private double strength = 20;
    private double agility = 20;
    private double stamina = 20;
    private double technique = 20;
    private double energy = 100;
    private double defense = 20;
    private String signature = DEFAULT_SIGNATURE;
    private String finisher = DEFAULT_FINISHER;
    private boolean isFace = true;
    private WrestlerProperties[] properties;

    protected Wrestler(
            String birthName, LocalDate birthDate, String birthplace, Gender gender,
            double height, double weight, String ringName, double strength,
            double agility, double stamina, double technique, double defense) throws SuperstarException, WrestlerException {

        super( birthName,  birthDate,  birthplace,  gender, height,  weight,  ringName);

        try {
            setStrength(strength);
            setAgility(agility);
            setStamina(stamina);
            setTechnique(technique);
            setDefense(defense);
        } catch (WrestlerException e) {
            throw new WrestlerException(WrestlerException.getErrMsgAttributesValues() + e.getMessage());
        }

        if (!areAttributesSumInRange()) {
            if(ATTRIBUTES_SUM_VALUE > 100){
                throw new WrestlerException(WrestlerException.getErrMsgAttributesMaxValue());
            } else {
                throw new WrestlerException(WrestlerException.getErrMsgAttributesMaxValue());
            }
        }
    }

    private void setDefense(double defense) throws WrestlerException {
        if (!isAttributeInRange(defense)) {
            throw new WrestlerException("defense");
        }
        this.defense = defense;
    }

    public double getStrength() {
        return strength;
    }

    private void setStrength(double strength) throws WrestlerException {
        if (!isAttributeInRange(strength)) {
            throw new WrestlerException("strength");
        }
        this.strength = strength;
    }

    public double getAgility() {
        return agility;
    }

    private void setAgility(double agility) throws WrestlerException {
        if (!isAttributeInRange(agility)) {
            throw new WrestlerException("agility");
        }
        this.agility = agility;
    }

    public double getStamina() {
        return stamina;
    }

    private void setStamina(double stamina) throws WrestlerException {
        if (!isAttributeInRange(stamina)) {
            throw new WrestlerException("stamina");
        }
        this.stamina = stamina;
    }

    public double getTechnique() {
        return technique;
    }

    private void setTechnique(double technique) throws WrestlerException {
        if (!isAttributeInRange(technique)) {
            throw new WrestlerException("technique");
        }
        this.technique = technique;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = Math.max(0, Math.min(100, energy));
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = (signature != null) ? signature : DEFAULT_SIGNATURE;
    }

    public String getFinisher() {
        return finisher;
    }

    public void setFinisher(String finisher) {
        this.finisher = (finisher != null) ? finisher : DEFAULT_FINISHER;
    }

    public boolean isFace() {
        return isFace;
    }

    public void setFace(boolean isFace) {
        this.isFace = isFace;
    }


    public void setProperties(WrestlerProperties[] properties) throws WrestlerException {
        if (properties == null || properties.length != 5) {
            throw new WrestlerException(WrestlerException.getErrMsgPropertiesNull());
        }

        for (WrestlerProperties property : properties) {
            if (property == null) {
                throw new WrestlerException(WrestlerException.getErrMsgPropertiesNull());
            }
        }

        this.properties = properties;
    }

    public double getOverall() {
        double overall = 0;

        if (properties != null) {
            for (WrestlerProperties property : properties) {
                if (property != null) {
                    overall += property.getOverall();
                }
            }
        }

        return Math.round(overall/5);
    }

    public WeightClass getWeightClass() {
        return WeightClass.LIGHT_HEAVYWEIGHT;
    }

    public void speak() {
        System.out.print("I'm the best wrestler in the world!!\n");
    }

    @Override
    public String toString() {
        String superstarString = super.toString();

        return superstarString + System.lineSeparator() +
                "\tSignature: " + getSignature() + System.lineSeparator() +
                "\tFinisher: " + getFinisher() + System.lineSeparator() +
                "\tOverall: " + getOverall();
    }


    public int compareTo(Wrestler wrestler) {
        if (wrestler == null) {
            throw new NullPointerException();
        }
        return Double.compare(this.getOverall(), wrestler.getOverall()) * 11;
    }

    private boolean isAttributeInRange(double value) {
        return value >= ATTRIBUTES_MIN_VALUE && value <= ATTRIBUTES_MAX_VALUE;
    }

    private boolean areAttributesSumInRange() {
        return (strength + agility + stamina + technique + defense) == ATTRIBUTES_SUM_VALUE;
    }

    public double getDefense() {

        return  defense;
    }
}
