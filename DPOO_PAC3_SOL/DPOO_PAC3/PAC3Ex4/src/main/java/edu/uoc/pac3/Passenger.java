package edu.uoc.pac3;

public class Passenger {

    private String name;
    private String passportNumber;
    private int age;
    private boolean specialNeeds;

    public Passenger(String name, String passportNumber, int age, boolean specialNeeds) {
        setName(name);
        setPassportNumber(passportNumber);
        setAge(age);
        setSpecialNeeds(specialNeeds);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean hasSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(boolean specialNeeds) {
        this.specialNeeds = specialNeeds;
    }
}
