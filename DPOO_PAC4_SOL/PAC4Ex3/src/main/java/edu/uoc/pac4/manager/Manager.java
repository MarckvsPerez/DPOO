package edu.uoc.pac4.manager;

import edu.uoc.pac4.Gender;
import edu.uoc.pac4.Superstar;
import edu.uoc.pac4.SuperstarException;
import edu.uoc.pac4.Speakable;

public class Manager extends Superstar implements Speakable {

    // Default constructor
    public Manager() throws SuperstarException {
        super(); // Call the default constructor of the Superstar class
    }

    // Parameterized constructor
    public Manager(String birthName, java.time.LocalDate birthDate, String birthplace, Gender gender, double height, double weight, String ringName) throws SuperstarException {
        super(birthName, birthDate, birthplace, gender, height, weight, ringName); // Call the parameterized constructor of the Superstar class
    }

    // Implementation of the Speakable interface
    @Override
    public void speak() {
        System.out.print("I'm a manager!!");
    }
}