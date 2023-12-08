package edu.uoc.pac4;

import java.time.LocalDate;
import java.util.Objects;
import java.time.format.DateTimeFormatter;

public abstract class Superstar {

    // Attributes
    private String birthName;
    private LocalDate birthDate;
    private String birthplace;
    private double height;
    private double weight;
    private String ringName;
    private Gender gender;

    // Constants for validation
    public static final int BIRTH_NAME_MIN_LENGTH = 1;
    public static final int BIRTH_NAME_MAX_LENGTH = 50;
    public static final int BIRTHPLACE_MIN_LENGTH = 1;
    public static final int BIRTHPLACE_MAX_LENGTH = 50;
    public static final int HEIGHT_MIN_VALUE = 1;
    public static final int WEIGHT_MIN_VALUE = 1;
    public static final int RING_NAME_MIN_LENGTH = 1;
    public static final int RING_NAME_MAX_LENGTH = 50;


    // Default constructor
    // Constructor por defecto con valores predeterminados
    protected  Superstar() throws SuperstarException {
        this.birthName = "Anonymous";
        this.birthDate = LocalDate.now().minusDays(1);
        this.birthplace =  "New York";
        this.height = 168;
        this.weight = 54;
        this.ringName = "Superstar";
        this.gender =  Gender.FEMALE;
    }

    // Parameterized constructor
    protected  Superstar(String birthName, LocalDate birthDate, String birthplace, Gender gender, double height, double weight, String ringName) throws SuperstarException {
        setBirthName(birthName);
        setBirthDate(birthDate);
        setBirthplace(birthplace);
        setHeight(height);
        setWeight(weight);
        setRingName(ringName);
    }

    // Getters and setters

    public String getBirthName() {
        return birthName;
    }

    public void setBirthName(String name) throws SuperstarException {
        if (name == null) {
            throw new SuperstarException(SuperstarException.getMsgErrBirthNameNull());
        }

        String trimmedName = name.trim();

        if (trimmedName.isEmpty() || trimmedName.length() > 60) {
            throw new SuperstarException(SuperstarException.getMsgErrBirthNameLength());
        }

        if (trimmedName.matches(".*\\d.*")) {
            throw new SuperstarException(SuperstarException.getMsgErrBirthNameNumbers());
        }

        this.birthName = trimmedName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    // Método para establecer la fecha de nacimiento con validaciones
    public void setBirthDate(LocalDate date) throws SuperstarException {
        if (date == null) {
            throw new SuperstarException(SuperstarException.getMsgErrBirthDate());
        }

        if (date.equals(LocalDate.now()) || date.isAfter(LocalDate.now())) {
            throw new SuperstarException(SuperstarException.getMsgErrBirthDate());
        }

        this.birthDate = date;
    }

    public String getBirthplace() {
        return birthplace;
    }

    // Método para establecer el lugar de nacimiento con validaciones
    public void setBirthplace(String place) throws SuperstarException {
        if (place == null) {
            throw new SuperstarException(SuperstarException.getMsgErrBirthplaceNull());
        }

        String trimmedPlace = place.trim();

        if (trimmedPlace.isEmpty() || trimmedPlace.length() > 80) {
            throw new SuperstarException(SuperstarException.getMsgErrBirthplaceLength());
        }

        this.birthplace = trimmedPlace;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setHeight(double height) throws SuperstarException {
        if (height <= 100) {
            throw new SuperstarException(SuperstarException.getMsgErrHeight());
        }

        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setWeight(double weight) throws SuperstarException {
        if (weight <= 30) {
            throw new SuperstarException(SuperstarException.getMsgErrWeight());
        }

        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setRingName(String name) throws SuperstarException {
        if (name == null) {
            throw new SuperstarException(SuperstarException.getMsgErrRingNameNull());
        }

        String trimmedName = name.trim();

        if (trimmedName.isEmpty() || trimmedName.length() > 60) {
            throw new SuperstarException(SuperstarException.getMsgErrRingNameLength());
        }

        this.ringName = trimmedName;
    }

    public String getRingName() {
        return ringName;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Superstar superstar = (Superstar) obj;

        return Double.compare(superstar.height, height) == 0 &&
                Double.compare(superstar.weight, weight) == 0 &&
                Objects.equals(birthName.trim(), superstar.birthName.trim()) &&
                Objects.equals(birthDate, superstar.birthDate);
    }

    public String toString() {
        return getRingName().toUpperCase() + System.lineSeparator() +
                "\tBirth name: " + getBirthName() + System.lineSeparator() +
                "\tBorn: " + getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + System.lineSeparator() +
                "\t      " + getBirthplace();

    }
}
