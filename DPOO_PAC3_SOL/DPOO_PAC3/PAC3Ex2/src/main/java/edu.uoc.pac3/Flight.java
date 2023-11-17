package edu.uoc.pac3;

import java.time.Duration;
import java.time.LocalDateTime;

public class Flight {
    public static final String ERROR_DATES = "Invalid dates";
    public static final String ERROR_ORIGIN = "Invalid origin";
    public static final String ERROR_DESTINATION = "Invalid destination";
    public static final String ERROR_NULL = "Parameter cannot be null";
    public static final String ERROR_NO_PASSPORT = "Passenger must have a passport";
    public static final String ERROR_PASSENGER_ALREADY_IN_FLIGHT = "Passenger is already in the flight";
    public static final int NUM_MAX_PASSENGERS = 160;

    private static int nextId = 1;

    private int id;
    private String origin;
    private String destination;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private Passenger[] passengers;

    /**
     * Constructor
     *
     * @param origin
     * @param destination
     * @param departureDate
     * @param arrivalDate
     * @param maxPassengers
     */
    public Flight(String origin, String destination, LocalDateTime departureDate, LocalDateTime arrivalDate, int maxPassengers) {
        if (origin == null || origin.isBlank()) {
            throw new IllegalArgumentException(ERROR_ORIGIN);
        }
        if (destination == null || destination.isBlank()) {
            throw new IllegalArgumentException(ERROR_DESTINATION);
        }
        if (departureDate == null || arrivalDate == null || departureDate.isAfter(arrivalDate)) {
            throw new IllegalArgumentException(ERROR_DATES);
        }

        this.id = nextId++;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.passengers = new Passenger[maxPassengers];
    }

    public int getId() {
        return id;
    }

    private void setId() {

    }

    public static int getNextId() {
        return nextId;
    }

    private static void incNextId() {
        nextId++;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        if (origin == null || origin.isBlank()) {
            throw new IllegalArgumentException(ERROR_ORIGIN);
        }
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        if (destination == null || destination.isBlank()) {
            throw new IllegalArgumentException(ERROR_DESTINATION);
        }
        this.destination = destination;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        if (arrivalDate != null && departureDate != null && (departureDate.isAfter(arrivalDate) || departureDate.isEqual(arrivalDate))) {
            throw new IllegalArgumentException(ERROR_DATES);
        }
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        if (departureDate != null && arrivalDate != null && !arrivalDate.isAfter(departureDate)) {
            throw new IllegalArgumentException(ERROR_DATES);
        }
        this.arrivalDate = arrivalDate;
    }


    public Passenger[] getPassengers() {
        return passengers;
    }

    public double getDuration() {
        // Asegurarse de que arrivalDate y departureDate no sean nulos
        if (arrivalDate == null || departureDate == null) {
            throw new IllegalStateException("Both arrivalDate and departureDate must be set.");
        }

        // Calcular la duración solo si departureDate es anterior a arrivalDate
        if (departureDate.isBefore(arrivalDate)) {
            // Obtener la duración en minutos y convertirla a horas
            long minutes = Duration.between(departureDate, arrivalDate).toMinutes();
            return minutes / 60.0; // Convertir minutos a horas como un valor decimal
        } else {
            throw new IllegalStateException("Departure date must be before arrival date.");
        }
    }

    private int findPassenger(Passenger passenger) {
        if (passenger == null) {
            throw new NullPointerException(ERROR_NULL);
        }
        if (passenger.getPassport() == null) {
            throw new NullPointerException(ERROR_NO_PASSPORT);
        }

        for (int i = 0; i < passengers.length; i++) {
            if (passenger.equals(passengers[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean containsPassenger(Passenger passenger) {
        if (passenger == null) {
            throw new NullPointerException(ERROR_NULL);
        }
        if (passenger.getPassport() == null) {
            throw new NullPointerException(ERROR_NO_PASSPORT);
        }

        return findPassenger(passenger) != -1;
    }

    public boolean addPassenger(Passenger passenger) {
        if (passenger == null) {
            throw new NullPointerException(ERROR_NULL);
        }
        if (passenger.getPassport() == null) {
            throw new NullPointerException(ERROR_NO_PASSPORT);
        }
        if (containsPassenger(passenger)) {
            throw new IllegalStateException(ERROR_PASSENGER_ALREADY_IN_FLIGHT);
        }

        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] == null) {
                passengers[i] = passenger;
                return true;
            }
        }
        return false;
    }

    public boolean removePassenger(Passenger passenger) {
        if (passenger == null) {
            throw new NullPointerException(ERROR_NULL);
        }
        if (passenger.getPassport() == null) {
            throw new NullPointerException(ERROR_NO_PASSPORT);
        }

        int index = findPassenger(passenger);
        if (index != -1) {
            passengers[index] = null;
            return true;
        }
        return false;
    }

    public int getNumPassengers() {
        int count = 0;
        for (Passenger passenger : passengers) {
            if (passenger != null) {
                count++;
            }
        }
        return count;
    }
}
