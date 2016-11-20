package com.example.ereminilya.drive2_ok.main.models;

import com.example.ereminilya.drive2_ok.models.CarOfTheDay;
import com.example.ereminilya.drive2_ok.models.Post;
import com.example.ereminilya.drive2_ok.utils.LinkParser;

import java.util.List;

/**
 * Created by ereminilya on 12/11/16.
 */

public class MainResponse {

    private InnerResponse response;
    private List<String>  atoms;

    public void makeProperImagesUrls() {
        for (Post topPost : response.topPosts) {
            LinkParser.makeProperUrl(atoms, topPost.getPhotos());
        }
        LinkParser.makeProperUrl(atoms, response.carOfTheDay.getPhoto());
    }

    public List<Post> getTopPosts() {
        return response.topPosts;
    }

    public static class InnerResponse {
        private CarOfTheDay carOfTheDay;
        private List<Post>  topPosts;
    }
}