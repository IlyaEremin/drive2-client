package com.example.ereminilya.drive2_ok.main.models;

import com.example.ereminilya.drive2_ok.models.CarOfTheDay;
import com.example.ereminilya.drive2_ok.models.Image;
import com.example.ereminilya.drive2_ok.models.Photo;
import com.example.ereminilya.drive2_ok.models.Post;

import java.util.List;

/**
 * Created by ereminilya on 12/11/16.
 */

public class MainResponse {

    private InnerResponse response;
    private List<String>  atoms;

    public void makeProperImagesUrls() {
        for (Post topPost : response.topPosts) {
            for (Photo photo : topPost.getPhotos()) {
                for (Image image : photo.getImages()) {
                    makeProperUrl(image);
                }
            }
        }
        for (Image image : response.carOfTheDay.getPhoto().getImages()) {
            makeProperUrl(image);
        }
    }

    private void makeProperUrl(Image image) {
        for (int i = 0; i < atoms.size(); i++) {
            if (image.getUrl().contains("$" + i)) {
                image.setUrl(image.getUrl().replace("$" + i, atoms.get(i)));
                break;
            }
        }
    }

    public List<Post> getTopPosts() {
        return response.topPosts;
    }

    public static class InnerResponse {
        private CarOfTheDay carOfTheDay;
        private List<Post>  topPosts;
    }
}