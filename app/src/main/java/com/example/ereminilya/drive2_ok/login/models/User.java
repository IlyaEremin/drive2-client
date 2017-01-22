package com.example.ereminilya.drive2_ok.login.models;

import com.example.ereminilya.drive2_ok.models.CarGeneration;
import com.example.ereminilya.drive2_ok.models.Image;
import com.example.ereminilya.drive2_ok.models.Photo;

/**
 * Created by ereminilya on 20/11/16.
 */
public class User {
    private long          id;
    private String        realName;
    private String        location;
    private String        url;
    private Photo         avatar;
    private String        gender;
    private CarGeneration carGeneration;

    public Photo getAvatar() {
        return avatar;
    }

    public String getBestProfileImageUrl() {
        int bestSize = 0;
        Image bestImage = null;
        for (Image image : avatar.getImages()) {
            if (image.getWidth() > bestSize) {
                bestImage = image;
            }
        }
        return bestImage == null ? null : bestImage.getUrl();
    }

    public String getName() {
        return realName;
    }

    public String getCity() {
        return location;
    }
}