package com.example.ereminilya.drive2_ok.models;

import java.util.List;

/**
 * Created by ereminilya on 12/11/16.
 */
public class Post {
    long        id;
    long        timestamp;
    String      timestampText;
    long        userId;
    String      url;
    String      text;
    List<Photo> photos;

    public List<Photo> getPhotos() {
        return photos;
    }

    public String getText() {
        return text;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
