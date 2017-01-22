package com.example.ereminilya.drive2_ok.login.models;

import com.example.ereminilya.drive2_ok.models.Car;

import java.util.List;

/**
 * Created by ereminilya on 14/11/16.
 */

public class LoginResponse {

    private InnerResponse response;
    private List<String>  atoms;

    public User getUser() {
        return response.user;
    }

    public List<Car> getCars() {
        return response.cars;
    }

    public List<String> getAtoms() {
        return atoms;
    }

    private static class InnerResponse {
        private User      user;
        private List<Car> cars;
    }
}