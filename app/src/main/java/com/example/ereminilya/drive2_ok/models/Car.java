package com.example.ereminilya.drive2_ok.models;

/**
 * Created by ereminilya on 22/1/17.
 */

public class Car {
    private String id;
    private String name;
    private String url;
    private Photo  photo;
    private int    drive;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Photo getPhoto() {
        return photo;
    }

    public String getUrl() {
        return url;
    }
}
