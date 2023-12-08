package edu.uoc.pac4.wrestler;

public class WrestlerException extends Exception {

    public static final String MSG_ERR_PROPERTIES_NULL = "Wrestler's properties mustn't be null";
    // Atributos con mensajes de error
    public static final String MSG_ERR_ATTRIBUTES_VALUES = "Wrestler's attributes must be in range [1,96]. Error in ";
    public static final String MSG_ERR_ATTRIBUTES_MAX_VALUE = "The sum of the wrestler's attributes mustn't be greater than 100";


    // Constructor con un parámetro de tipo String
    public WrestlerException(String message) {
        super(message);
    }

    // Métodos para acceder a los mensajes de error
    public static String getErrMsgAttributesValues() {
        return MSG_ERR_ATTRIBUTES_VALUES;
    }

    public static String getErrMsgAttributesMaxValue() {
        return MSG_ERR_ATTRIBUTES_MAX_VALUE;
    }

    public static String getErrMsgPropertiesNull() {
        return MSG_ERR_PROPERTIES_NULL;
    }

    public static String getMsgErrAttributesValues(String agility) {
        return agility;
    }

    public static String getMsgErrPropertiesNull() {
        return null;
    }
}
