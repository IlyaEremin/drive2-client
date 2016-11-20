package com.example.ereminilya.drive2_ok.login.models;

import com.example.ereminilya.drive2_ok.models.Photo;

/**
 * Created by ereminilya on 20/11/16.
 */
public class User {
    long   id;
    String name;
    String url;
    Photo  avatar;
    String gender;

    public Photo getAvatar() {
        return avatar;
    }
}
