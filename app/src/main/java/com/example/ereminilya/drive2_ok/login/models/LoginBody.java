package com.example.ereminilya.drive2_ok.login.models;

/**
 * Created by ereminilya on 15/11/16.
 */

public class LoginBody {
    String login;
    String password;
    String apiKey = "dUvrR6k-ky0dLqGMR5yOH950Swys6rK_-AZE48_8ebcM6mGs0yU3dOoPDanYJIASzFFna2rcS1s3505lPyncNQ";
    int apiKeyId = 4;
    String platform = "gcm";

    public LoginBody(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
