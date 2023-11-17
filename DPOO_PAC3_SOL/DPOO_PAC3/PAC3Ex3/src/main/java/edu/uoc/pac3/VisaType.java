package edu.uoc.pac3;

public enum VisaType {
    TOURIST("Tourist Visa", "T", 123),
    BUSINESS("Business Visa", "B", 456),
    STUDENT("Student Visa", "S", 789),
    WORK("Work Visa", "W", 321),
    TRANSIT("Transit Visa", "TR", 654),
    FAMILY("Family Visa", "F", 987),
    JOURNALIST("Journalist Visa", "J", 234),
    MEDICAL("Medical Visa", "M", 567),
    RETIREMENT("Retirement Visa", "R", 890),
    INVESTOR("Investor Visa", "I", 432),
    DIPLOMATIC("Diplomatic Visa", "D", 765),
    SCHENGEN("Schengen Visa", "SCH", 198),
    EMPLOYMENT("Employment Visa", "E", 543),
    VISITING_FRIENDS("Visiting Friends Visa", "VF", 876),
    RELIGIOUS("Religious Visa", "RL", 321),
    OTHER("Other Visa", "O", 654);

    private final String description;
    private final String stringIdentifier;
    private final int intIdentifier;

    VisaType(String description, String stringIdentifier, int intIdentifier) {
        this.description = description;
        this.stringIdentifier = stringIdentifier;
        this.intIdentifier = intIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public String getStringIdentifier() {
        return stringIdentifier;
    }

    public int getIntIdentifier() {
        return intIdentifier;
    }

    public static VisaType getVisaTypeByStringIdentifier(String stringIdentifier) {
        for (VisaType visaType : VisaType.values()) {
            if (visaType.stringIdentifier.equals(stringIdentifier)) {
                return visaType;
            }
        }
        return null;
    }

    public VisaType next() {
        int nextIndex = (this.ordinal() + 1) % VisaType.values().length;
        return VisaType.values()[nextIndex];
    }


}