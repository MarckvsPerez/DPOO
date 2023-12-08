package edu.uoc.pac4.wrestler.styles;

import edu.uoc.pac4.Gender;
import edu.uoc.pac4.SuperstarException;
import edu.uoc.pac4.wrestler.Wrestler;
import edu.uoc.pac4.wrestler.WrestlerException;

import java.time.LocalDate;

public class Striker extends Wrestler {

    // Constructor
    public Striker(String birthName, LocalDate birthDate, String birthplace, Gender gender,
                   double height, double weight, String ringName) throws WrestlerException, SuperstarException {
        super(birthName, birthDate, birthplace, gender, height, weight, ringName, 25, 20, 25, 10, 20);
    }

    @Override
    public String toString() {
        String wrestlerString = super.toString();
        int overallIndex = wrestlerString.indexOf("Overall:");

        wrestlerString = wrestlerString.substring(0, overallIndex) +
                "Style: " + "Striker\r\n" +"\t"+
                wrestlerString.substring(overallIndex);

        return wrestlerString;
    }
}
