package ru.gpbi.requestprocessing.exception;

public class LimitExceedingException extends RuntimeException {

    public LimitExceedingException(String message) {
        super(message);
    }

}
