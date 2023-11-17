package edu.uoc.pac3;

import java.time.LocalDate;

public class Passport {
    /**
     * Missatges d'error
     */
    public static final String PASSPORT_NUMBER_ERROR = "Invalid passport number";
    public static final String ISSUE_DATE_ERROR = "Invalid issue date";
    public static final String EXPIRATION_DATE_ERROR = "Invalid expiration date";
    public static final String VISA_TYPE_ERROR = "Invalid visa type";

    /**
     * Atributs
     */
    private String passportNumber;
    private LocalDate issueDate;
    private LocalDate expirationDate;
    private int visaType;


    /**
     * Constructor de la classe Passport
     *
     * @param passportNumber El número de passaport
     * @param issueDate      Data d'expedició
     * @param expirationDate Data d'expiració
     * @param visaType       Tipus de Visa
     * @throws IllegalArgumentException si hi ha algun error
     */
    public Passport(String passportNumber, LocalDate issueDate, LocalDate expirationDate, int visaType) {

        if (!isValidPassportNumber(passportNumber)) {
            throw new IllegalArgumentException(PASSPORT_NUMBER_ERROR);
        }
        if (!isValidIssueDate(issueDate)) {
            throw new IllegalArgumentException(ISSUE_DATE_ERROR);
        }
        if (!isValidExpirationDate(expirationDate, issueDate)) {
            throw new IllegalArgumentException(EXPIRATION_DATE_ERROR);
        }
        if (!isValidVisaType(visaType)) {
            throw new IllegalArgumentException(VISA_TYPE_ERROR);
        }

        this.passportNumber = passportNumber;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
        this.visaType = visaType;
    }

    /**
     * Getters
     */
    public String getPassportNumber() {
        return passportNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public int getVisaType() {
        return visaType;
    }

    /**
     * Setters
     */
    private void setExpirationDate(LocalDate expirationDate) {
        if (isValidExpirationDate(expirationDate, this.issueDate)) {
            this.expirationDate = expirationDate;
        } else {
            throw new IllegalArgumentException(EXPIRATION_DATE_ERROR);
        }
    }

    private void setVisaType(int visaType) {
        if (isValidVisaType(visaType)) {
            this.visaType = visaType;
        } else {
            throw new IllegalArgumentException(VISA_TYPE_ERROR);
        }
    }

    private void setIssueDate(LocalDate issueDate) {
        if (isValidIssueDate(issueDate)) {
            this.issueDate = issueDate;
        } else {
            throw new IllegalArgumentException(ISSUE_DATE_ERROR);
        }
    }

    private void setPassportNumber(String passportNumber) {
        if (isValidPassportNumber(passportNumber)) {
            this.passportNumber = passportNumber;
        } else {
            throw new IllegalArgumentException(PASSPORT_NUMBER_ERROR);
        }
    }

    /**
     * Funcions anónimes
     */
    private boolean isValidPassportNumber(String passportNumber) {
        return !passportNumber.isBlank();
    }

    private boolean isValidIssueDate(LocalDate issueDate) {
        LocalDate currentDate = LocalDate.now();
        return issueDate != null &&
                !issueDate.isBefore(currentDate.minusDays(3650)) &&
                !issueDate.isAfter(currentDate);
    }

    private boolean isValidExpirationDate(LocalDate expirationDate, LocalDate issueDate) {
        return expirationDate != null &&
                !expirationDate.isBefore(issueDate) &&
                !expirationDate.isAfter(issueDate.plusYears(10));
    }

    private boolean isValidVisaType(int visaType) {
        return visaType >= 0;
    }
}
