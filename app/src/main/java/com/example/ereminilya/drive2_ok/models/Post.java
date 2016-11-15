package com.example.ereminilya.drive2_ok.models;

import java.util.List;

/**
 * Created by ereminilya on 12/11/16.
 */
public class Post {
    private long        id;
    private long        timestamp;
    private String      timestampText;
    private long        userId;
    private String      url;
    private String      text;
    private List<Photo> photos;

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
