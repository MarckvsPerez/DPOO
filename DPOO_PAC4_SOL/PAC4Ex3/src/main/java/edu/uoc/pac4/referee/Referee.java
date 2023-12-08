package edu.uoc.pac4.referee;

import edu.uoc.pac4.Gender;
import edu.uoc.pac4.Superstar;
import edu.uoc.pac4.SuperstarException;
import edu.uoc.pac4.wrestler.Wrestler;

import java.time.LocalDate;

public class Referee extends Superstar {

    // Constructor por defecto
    public Referee() throws SuperstarException {
        super();
    }

    // Constructor con argumentos
    public Referee(String birthName, LocalDate birthDate, String birthplace, Gender gender,
                   double height, double weight, String ringName) throws SuperstarException {
        super(birthName, birthDate, birthplace, gender, height, weight, ringName);
    }

    private boolean countPinfall(Wrestler wrestler1, Wrestler wrestler2) {
        return (wrestler1.getEnergy() > wrestler2.getEnergy() * 1.2 &&
                wrestler1.getWeight() > wrestler2.getWeight()) ||
                (wrestler1.getEnergy() > wrestler2.getEnergy() * 1.5);
    }

    private boolean decideKnockout(Wrestler wrestler) {
        return wrestler.getEnergy() < 5;
    }

    public boolean decide(Wrestler wrestler1, Wrestler wrestler2) {
        return countPinfall(wrestler1, wrestler2) || decideKnockout(wrestler2);
    }
}
