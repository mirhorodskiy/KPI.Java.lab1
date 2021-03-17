package com.kpi.model.exсeptions;

public class InvalidInputRuntimeException extends RuntimeException{
    public static final String WRONG_INPUT_TYPE = "Wrong input type";
    public static final String NEGATIVE_VALUE = "Value can't be negative";

    public InvalidInputRuntimeException() {
        super();
    }

    public InvalidInputRuntimeException(String message) {
        super(message);
    }

    public InvalidInputRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputRuntimeException(Throwable cause) {
        super(cause);
    }
}
