package com.example.ereminilya.drive2_ok.login.models;

import com.example.ereminilya.drive2_ok.models.Photo;

/**
 * Created by ereminilya on 20/11/16.
 */
public class User {
    private long   id;
    private String name;
    private String url;
    private Photo  avatar;
    private String gender;

    public Photo getAvatar() {
        return avatar;
    }
}
