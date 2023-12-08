package edu.uoc.pac4;

public class SuperstarException extends Exception {

    // Mensajes de error
    public static final String MSG_ERR_BIRTH_NAME_NULL = "El nombre de nacimiento no puede ser nulo";
    public static final String MSG_ERR_BIRTH_NAME_LENGTH = "Longitud de nombre de nacimiento no válida";
    public static final String MSG_ERR_BIRTH_NAME_NUMBERS = "El nombre de nacimiento no puede contener números";
    public static final String MSG_ERR_BIRTH_DATE = "Fecha de nacimiento no válida";
    public static final String MSG_ERR_BIRTHPLACE_NULL = "El lugar de nacimiento no puede ser nulo";
    public static final String MSG_ERR_BIRTHPLACE_LENGTH = "Longitud de lugar de nacimiento no válida";
    public static final String MSG_ERR_HEIGHT = "Altura no válida";
    public static final String MSG_ERR_WEIGHT = "Peso no válido";
    public static final String MSG_ERR_RING_NAME_NULL = "El nombre artístico no puede ser nulo";
    public static final String MSG_ERR_RING_NAME_LENGTH = "Longitud de nombre artístico no válida";

    // Constructores

    // Constructor parametrizado
    public SuperstarException(String mensaje) {
        super(mensaje);
    }

    // Métodos getter para los mensajes de error

    public static String getMsgErrBirthNameNull() {
        return MSG_ERR_BIRTH_NAME_NULL;
    }

    public static String getMsgErrBirthNameLength() {
        return MSG_ERR_BIRTH_NAME_LENGTH;
    }

    public static String getMsgErrBirthNameNumbers() {
        return MSG_ERR_BIRTH_NAME_NUMBERS;
    }

    public static String getMsgErrBirthDate() {
        return MSG_ERR_BIRTH_DATE;
    }

    public static String getMsgErrBirthplaceNull() {
        return MSG_ERR_BIRTHPLACE_NULL;
    }

    public static String getMsgErrBirthplaceLength() {
        return MSG_ERR_BIRTHPLACE_LENGTH;
    }

    public static String getMsgErrHeight() {
        return MSG_ERR_HEIGHT;
    }

    public static String getMsgErrWeight() {
        return MSG_ERR_WEIGHT;
    }

    public static String getMsgErrRingNameNull() {
        return MSG_ERR_RING_NAME_NULL;
    }

    public static String getMsgErrRingNameLength() {
        return MSG_ERR_RING_NAME_LENGTH;
    }
}
