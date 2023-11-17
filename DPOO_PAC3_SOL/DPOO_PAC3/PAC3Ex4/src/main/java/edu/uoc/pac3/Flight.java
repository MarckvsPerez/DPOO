package edu.uoc.pac3;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Flight {

    private Passenger[] passengers;
    private int numPassengers;

    public Flight(File file) throws Exception {
        passengers = new Passenger[50];
        populate(file);
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    private void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    private void populate(File file) throws Exception {
        List<Passenger> passengerList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                String name = line[0];
                String passportNumber = line[1];
                int age = Integer.parseInt(line[2]);
                boolean specialNeeds = Boolean.parseBoolean(line[3]);

                Passenger passenger = new Passenger(name, passportNumber, age, specialNeeds);
                passengerList.add(passenger);
            }
        }

        passengers = passengerList.toArray(new Passenger[0]);
        setNumPassengers(passengerList.size());
    }

    public Passenger[] getPassengers() {
        return passengers;
    }
}
