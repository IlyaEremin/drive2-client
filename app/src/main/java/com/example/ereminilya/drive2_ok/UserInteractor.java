package com.example.ereminilya.drive2_ok;

import android.support.annotation.NonNull;

import com.example.ereminilya.drive2_ok.login.models.LoginBody;
import com.example.ereminilya.drive2_ok.login.models.User;
import com.example.ereminilya.drive2_ok.utils.Api;
import com.example.ereminilya.drive2_ok.utils.LinkParser;
import com.example.ereminilya.drive2_ok.utils.storage.Storage;

import rx.Observable;

/**
 * Created by ereminilya on 20/11/16.
 */

public class UserInteractor {

    private static final String KEY_USER = "user";

    private final Storage storage;
    private final Api api;

    public UserInteractor(@NonNull Api api, @NonNull Storage sessionStorage) {
        this.api = api;
        this.storage = sessionStorage;
    }

    public Observable<Boolean> login(LoginBody loginBody) {
        return api.login(loginBody)
            .map(result -> {
                LinkParser.makeProperUrl(result.getAtoms(), result.getUser().getAvatar());
                storage.put(KEY_USER, result.getUser());
                return true;
            });
    }

    public String getAvatarUrl() {
        User user = storage.get(KEY_USER, User.class);
        return user.getAvatar().getImages().get(0).getUrl();
    }
}