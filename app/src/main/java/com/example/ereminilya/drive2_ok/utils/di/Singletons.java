package com.example.ereminilya.drive2_ok.utils.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import com.example.ereminilya.drive2_ok.BuildConfig;
import com.example.ereminilya.drive2_ok.UserInteractor;
import com.example.ereminilya.drive2_ok.utils.Api;
import com.example.ereminilya.drive2_ok.utils.SessionManager;
import com.example.ereminilya.drive2_ok.utils.Strings;
import com.example.ereminilya.drive2_ok.utils.storage.SharedPrefsStorage;
import com.example.ereminilya.drive2_ok.utils.storage.Storage;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ereminilya on 20/11/16.
 */

@Module
public class Singletons {

    private Application mApplication;

    public Singletons(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton Context providesApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Api provideApi(@NonNull OkHttpClient httpClient) {
        return new Retrofit.Builder()
            .client(httpClient)
            .baseUrl(Api.BASE_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(new Gson()))
            .build()
            .create(Api.class);
    }

    @Provides
    @Singleton
    OkHttpClient providesHttpClient(@NonNull SessionManager sessionManager) {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
//        httpClientBuilder.cache(new Cache(cachedDir, 20 * 1024 * 1024));
        httpClientBuilder.readTimeout(30, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.addInterceptor(interceptor);
        }
        httpClientBuilder.addInterceptor(chain -> {
            String cookie = sessionManager.getCookie();
            if (Strings.notEmpty(cookie)) {
                Request request = chain.request().newBuilder()
                    .addHeader("Cookie", cookie)
                    .build();
                return chain.proceed(request);
            } else {
                Response response = chain.proceed(chain.request());
                sessionManager.saveCookie(Lists.toString(response.headers("Set-Cookie")));
                return response;
            }
        });
        return httpClientBuilder.build();
    }

    @Provides @Singleton
    public UserInteractor provideUserInteractor(@NonNull Api api, @NonNull Storage storage) {
        return new UserInteractor(api, storage);
    }

    @Provides @Singleton public Gson getMapper() {
        return new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();
    }

    @Provides @Singleton public SharedPreferences providesSharedPrefs(@NonNull Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides @Singleton
    public Storage provideStorage(@NonNull SharedPreferences sp, @NonNull Gson mapper) {
        return new SharedPrefsStorage(sp, mapper);
    }

    @Provides @Singleton
    SessionManager provideSessionManager(@NonNull Storage storage) {
        return new SessionManager(storage);
    }
}