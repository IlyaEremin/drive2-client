package com.example.ereminilya.drive2_ok.login.models;

import com.example.ereminilya.drive2_ok.utils.Api;

/**
 * Created by ereminilya on 15/11/16.
 */

public class LoginBody {
    private String login;
    private String password;
    private String apiKey   = Api.API_KEY;
    private int    apiKeyId = 4;
    private String platform = "gcm";

    public LoginBody(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
