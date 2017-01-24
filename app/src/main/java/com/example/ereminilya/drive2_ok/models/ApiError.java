package com.example.ereminilya.drive2_ok.models;

/**
 * Created by ereminilya on 24/1/17.
 */
public class ApiError extends RuntimeException {

    private final String message;

    public ApiError(String message) {
        this.message = message;
    }

    @Override public String getMessage() {
        return message;
    }
}
