package edu.uoc.pac4.wrestler.styles;

import edu.uoc.pac4.Gender;
import edu.uoc.pac4.SuperstarException;
import edu.uoc.pac4.wrestler.Wrestler;
import edu.uoc.pac4.wrestler.WrestlerException;

import java.time.LocalDate;

public class Powerhouse extends Wrestler {

    // Constructor
    public Powerhouse(String birthName, LocalDate birthDate, String birthplace, Gender gender,
                      double height, double weight, String ringName) throws WrestlerException, SuperstarException {
        super(birthName, birthDate, birthplace, gender, height, weight, ringName, 30, 10, 25, 15, 20);
    }

    @Override
    public String toString() {
        String wrestlerString = super.toString();
        int overallIndex = wrestlerString.indexOf("Overall:");

        wrestlerString = wrestlerString.substring(0, overallIndex) +
                "Style: Powerhouse\n" +"\t"+
                wrestlerString.substring(overallIndex);

        return wrestlerString;
    }
}
