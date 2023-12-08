package edu.uoc.pac4.wrestler.properties;

public class AgilityProperties implements WrestlerProperties {

    private double speed;
    private double jump;
    private double acrobatics;

    // Constructor
    public AgilityProperties(double speed, double jump, double acrobatics) {
        setSpeed(speed);
        setJump(jump);
        setAcrobatics(acrobatics);
    }

    // Setters
    private void setSpeed(double speed) {
        if (speed >= 0 && speed <= 100) {
            this.speed = speed;
        } else {
            this.speed = 50;
        }
    }

    private void setJump(double jump) {
        if (jump >= 0 && jump <= 100) {
            this.jump = jump;
        } else {
            this.jump = 50;
        }
    }

    private void setAcrobatics(double acrobatics) {
        if (acrobatics >= 0 && acrobatics <= 100) {
            this.acrobatics = acrobatics;
        } else {
            this.acrobatics = 50;
        }
    }

    // Getters
    public double getJump() {
        return jump;
    }

    public double getAcrobatics() {
        return acrobatics;
    }

    public double getSpeed() {
        return speed;
    }


    public double getOverall() {
        return (speed + jump + acrobatics) / 3.0;
    }

    public int size() {
        return 3;
    }

}
