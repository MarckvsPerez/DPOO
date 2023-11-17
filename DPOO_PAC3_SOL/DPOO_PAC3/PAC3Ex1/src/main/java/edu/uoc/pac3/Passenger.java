package edu.uoc.pac3;

import java.time.LocalDate;

public class Passenger {
    public static final String INVALID_NAME = "INVALID_NAME";
    public static final String INVALID_BIRTHDAY = "INVALID_BIRTHDAY";
    public static final String INVALID_ADDRESS = "INVALID_ADDRESS";
    public static final String INVALID_PHONE_NUMBER_FORMAT = "INVALID_PHONE_NUMBER_FORMAT";
    public static final String INVALID_HEIGHT = "INVALID_HEIGHT";
    public static final String INVALID_OCCUPATION = "INVALID_OCCUPATION";
    public static final String INVALID_NATIONALITY = "INVALID_NATIONALITY";

    private static final int NAME_MAX_LENGTH = 50;

    private String name;
    private LocalDate birthday;
    private String address;
    private String phoneNumber;
    private String nationality;
    private double height;
    private boolean specialNeeds;
    private String occupation;
    private Passport passport;

    public Passenger(String name, LocalDate birthday, String address, String phoneNumber, double height, boolean specialNeeds, String occupation, String nationality) {
        setName(name);
        setBirthday(birthday);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setNationality(nationality);
        setHeight(height);
        setSpecialNeeds(specialNeeds);
        setOccupation(occupation);
    }

    public Passenger(String name, LocalDate birthday, String address, String phoneNumber, double height, boolean specialNeeds, String occupation, String nationality, String passportNumber, LocalDate passportIssueDate, LocalDate passportExpirationDate, int visaType) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.height = height;
        this.specialNeeds = specialNeeds;
        this.occupation = occupation;
        this.nationality = nationality;
        if (isValidPassportDetails(passportNumber, passportIssueDate, passportExpirationDate)) {
            this.passport = new Passport(passportNumber, passportIssueDate, passportExpirationDate, visaType);
        } else {
            this.passport = null;
        }
    }

    public Passport getPassport() {
        return this.passport;
    }

    private boolean isValidPassportDetails(String passportNumber, LocalDate issueDate, LocalDate expirationDate) {
        return passportNumber != null && !passportNumber.isBlank() &&
                issueDate != null && expirationDate != null &&
                !issueDate.isAfter(LocalDate.now()) &&
                !expirationDate.isBefore(LocalDate.now()) &&
                !expirationDate.isBefore(issueDate) &&
                !expirationDate.isAfter(issueDate.plusYears(10));
    }

    public void setPassport(String passportNumber, LocalDate issueDate, LocalDate expirationDate, int visaType) {
        this.passport = new Passport(passportNumber, issueDate, expirationDate, visaType);
    }


    public void setName(String name) {
        if (name == null || name.isBlank() || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        if (birthday == null || birthday.isAfter(LocalDate.now()) || birthday.isBefore(LocalDate.now().minusYears(110))) {
            throw new IllegalArgumentException(INVALID_BIRTHDAY);
        }
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException(INVALID_ADDRESS);
        }
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("^\\+\\d{1,3}-\\d{1,12}$")) {
            throw new IllegalArgumentException(INVALID_PHONE_NUMBER_FORMAT);
        }
        this.phoneNumber = phoneNumber;
    }

    public void setNationality(String nationality) {
        if (nationality == null || nationality.isBlank()) {
            throw new IllegalArgumentException(INVALID_NATIONALITY);
        }
        this.nationality = nationality;
    }

    public void setHeight(double height) {
        if (height < 50 || height > 250) {
            throw new IllegalArgumentException(INVALID_HEIGHT);
        }
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public double getHeight() {
        return height;
    }

    public void setSpecialNeeds(boolean specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public boolean hasSpecialNeeds() {
        return specialNeeds;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        if (occupation == null || occupation.isBlank()) {
            throw new IllegalArgumentException(INVALID_OCCUPATION);
        }
        this.occupation = occupation;
    }
}
