package com.example.ereminilya.drive2_ok.utils;

import android.support.annotation.NonNull;

import com.example.ereminilya.drive2_ok.models.Image;
import com.example.ereminilya.drive2_ok.models.Photo;

import java.util.List;

/**
 * Created by ereminilya on 20/11/16.
 */

public class LinkParser {

    public static void makeProperUrl(@NonNull List<String> atoms, @NonNull List<Photo> photos) {
        for (Photo photo : photos) {
            makeProperUrl(atoms, photo);
        }
    }

    public static void makeProperUrl(@NonNull List<String> atoms, @NonNull Photo photo) {
        for (Image image : photo.getImages()) {
            makeProperUrl(atoms, image);
        }
    }

    public static void makeProperUrl(@NonNull List<String> atoms, Image image) {
        for (int i = 0; i < atoms.size(); i++) {
            if (image.getUrl().contains("$" + i)) {
                image.setUrl(image.getUrl().replace("$" + i, atoms.get(i)));
                break;
            }
        }
    }
}
