package edu.uoc.pac4.wrestler.styles;

import edu.uoc.pac4.Gender;
import edu.uoc.pac4.SuperstarException;
import edu.uoc.pac4.wrestler.Wrestler;
import edu.uoc.pac4.wrestler.WrestlerException;

import java.time.LocalDate;

public class Technician extends Wrestler {

    // Constructor con valores predeterminados
    public Technician(String birthName, LocalDate birthDate, String birthplace, Gender gender,
                      double height, double weight, String ringName) throws WrestlerException, SuperstarException {
        // Valores predeterminados para los atributos específicos de Technician
        super(birthName, birthDate, birthplace, gender, height, weight, ringName, 10, 20, 20, 30, 20);
    }

    @Override
    public String toString() {
        String wrestlerString = super.toString();
        int overallIndex = wrestlerString.indexOf("Overall:");

        wrestlerString = wrestlerString.substring(0, overallIndex) +
                "Style: " + "Technician\r\n" +"\t"+
                wrestlerString.substring(overallIndex);

        return wrestlerString;
    }
}