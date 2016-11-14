package com.example.ereminilya.drive2_ok.utils;

import android.support.annotation.NonNull;

import com.example.ereminilya.drive2_ok.main.models.MainResponse;
import com.example.ereminilya.drive2_ok.models.LoginResponse;

import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by ereminilya on 12/11/16.
 */

public interface Api {

    String API_KEY = "dUvrR6k-ky0dLqGMR5yOH950Swys6rK_-AZE48_8ebcM6mGs0yU3dOoPDanYJIASzFFna2rcS1s3505lPyncNQ";

    String BASE_URL = "https://api.drive2.ru/v2.8/";

    @GET("public/main.cshtml") Observable<MainResponse> getMain();

    @POST("public/login") Observable<LoginResponse> login(@NonNull @Field("loign") String login,
                                                   @NonNull @Field("password") String password,
                                                   @Field("apiKeyId") int apiKeyId,
                                                   @NonNull @Field("apiKey") String apiKey,
                                                   @NonNull @Field("platform") String platform);


    String ABOUT_CAR      = "aboutCar";
    String ABOUT_USER     = "aboutUser";
    String ALERTS         = "redalerts";
    String BLOG           = "readPosts";
    String BRAND          = "public/brand";
    String CAR            = "car";
    String COMMENTS       = "public/readComments";
    String CONTACTS       = "contacts";
    String CREATE_COMMENT = "createComment";
    String CREATE_POST    = "createPost";
    String EVENTS         = "events";
    String GENERATION     = "public/generation";
    String GUESTS         = "guests";
    String LOGOUT         = "public/logout";
    String MESSAGES       = "messages";
    String MODEL          = "public/model";
    String POPULAR        = "public/main";
    String READ_POST      = "public/readPost";
    String SEND_PROMO     = "countPromo";
    String SUBSCRIPTION   = "subscription";
    String UPDATE         = "update";
    String UPLOAD_IMAGE   = "uploadImage";
    String USER           = "user";

}
