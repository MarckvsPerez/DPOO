package edu.uoc.pac4.wrestler.properties;

public class DefenseProperties implements WrestlerProperties {

    private double strikeReversal;
    private double grappleReversal;
    private double aerialReversal;
    private double submissionDefense;

    // Constructor
    public DefenseProperties(double strikeReversal, double grappleReversal, double aerialReversal, double submissionDefense) {
        setStrikeReversal(strikeReversal);
        setGrappleReversal(grappleReversal);
        setAerialReversal(aerialReversal);
        setSubmissionDefense(submissionDefense);
    }

    // Setters
    private void setStrikeReversal(double strikeReversal) {
        if (strikeReversal >= 0 && strikeReversal <= 100) {
            this.strikeReversal = strikeReversal;
        } else {
            this.strikeReversal = 50;
        }
    }

    private void setGrappleReversal(double grappleReversal) {
        if (grappleReversal >= 0 && grappleReversal <= 100) {
            this.grappleReversal = grappleReversal;
        } else {
            this.grappleReversal = 50;
        }
    }

    private void setAerialReversal(double aerialReversal) {
        if (aerialReversal >= 0 && aerialReversal <= 100) {
            this.aerialReversal = aerialReversal;
        } else {
            this.aerialReversal = 50;
        }
    }

    private void setSubmissionDefense(double submissionDefense) {
        if (submissionDefense >= 0 && submissionDefense <= 100) {
             this.submissionDefense = submissionDefense;
        } else {
            this.submissionDefense = 50;
        }
    }

    // Getters
    public double getStrikeReversal() {
        return strikeReversal;
    }

    public double getGrappleReversal() {
        return grappleReversal;
    }

    public double getAerialReversal() {
        return aerialReversal;
    }

    public double getSubmissionDefense() {
        return submissionDefense;
    }

    public double getOverall() {
        return (strikeReversal + grappleReversal + aerialReversal + submissionDefense) / 4.0;
    }

    public int size() {
        return 4;
    }
}
