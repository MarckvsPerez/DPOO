package edu.uoc.pac4.brand;

import edu.uoc.pac4.Superstar;
import edu.uoc.pac4.referee.Referee;
import edu.uoc.pac4.wrestler.Wrestler;

import java.util.ArrayList;
import java.util.List;

public class Brand {
    private String name;
    private Day day;
    private String tvChannel;
    private List<Superstar> roster;

    // Constructor
    public Brand(String name, Day day, String tvChannel) {
        this.name = name;
        this.day = day;
        this.tvChannel = tvChannel;
        this.roster = new ArrayList<>();
    }

    // Getter and Setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    // Getter and Setter methods for day
    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        if (day != null) {
            this.day = day;
        }
    }

    // Getter and Setter methods for tvChannel
    public String getTvChannel() {
        return tvChannel;
    }

    public void setTvChannel(String tvChannel) {
        if (tvChannel != null) {
            this.tvChannel = tvChannel;
        }
    }

    // Getter method for roster
    public List<Superstar> getRoster() {
        return roster;
    }

    // Other methods
    public boolean addSuperstar(Superstar superstar) {
        if (superstar != null && !roster.contains(superstar)) {
            return roster.add(superstar);
        }
        return false;
    }

    public boolean isSuperstar(Superstar superstar) {
        return roster.contains(superstar);
    }

    public boolean removeSuperstar(Superstar superstar) {
        return roster.remove(superstar);
    }

    public boolean isEmpty() {
        return roster.isEmpty();
    }

    public int getNumReferees() {
        int numReferees = 0;
        for (Superstar superstar : roster) {
            if (superstar instanceof Referee) {
                numReferees++;
            }
        }
        return numReferees;
    }

    public double getWeightAverage() {
        if (roster.isEmpty()) {
            return 0;
        }

        double totalWeight = 0;
        int totalWrestlers = 0;

        for (Superstar superstar : roster) {

                totalWeight += superstar.getWeight();
                totalWrestlers++;

        }

        if (totalWrestlers == 0) {
            return 0;
        }

        return totalWeight / totalWrestlers;
    }

    public void setDefaultMoves() {
        String defaultSignature = "Superkick";
        String defaultFinisher = "Canadian Destroyer";

        for (Superstar superstar : roster) {
            if (superstar instanceof Wrestler) {
                Wrestler wrestler = (Wrestler) superstar;
                wrestler.setSignature(defaultSignature);
                wrestler.setFinisher(defaultFinisher);
            }
        }
    }

    public List<Wrestler> getTopWrestlers(int num) {
        if (num <= 0) {
            return new ArrayList<>();
        }

        List<Wrestler> topWrestlers = new ArrayList<>();
        roster.stream()
                .filter(superstar -> superstar instanceof Wrestler)
                .map(superstar -> (Wrestler) superstar)
                .sorted((w1, w2) -> Double.compare(w2.getOverall(), w1.getOverall()))
                .limit(num)
                .forEach(topWrestlers::add);

        return topWrestlers;
    }

    @Override
    public String toString() {
        String formattedDay = day.toString().substring(0, 1) + day.toString().substring(1).toLowerCase();
        return name + " every " + formattedDay + " on " + tvChannel;
    }
}
