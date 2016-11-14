package com.example.ereminilya.drive2_ok.utils;

import com.example.ereminilya.drive2_ok.BuildConfig;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ereminilya on 12/11/16.
 */

public class Deps {

    public static Api providesApi() {
        return new Retrofit.Builder()
            .client(getHttpClient())
            .baseUrl(Api.BASE_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(new Gson()))
            .build()
            .create(Api.class);
    }

    public static OkHttpClient getHttpClient() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
//        httpClientBuilder.cache(new Cache(cachedDir, 20 * 1024 * 1024));
        httpClientBuilder.readTimeout(30, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.addInterceptor(interceptor);
        }
//        httpClientBuilder.addInterceptor(new Interceptor() {
//            @Override public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request().newBuilder()
//                    .addHeader("X-User-Phone-Number", userSettings.getPhone())
//                    .build();
//                return chain.proceed(request);
//            }
//        });
        return httpClientBuilder.build();
    }
}
