package com.example.ereminilya.drive2_ok.utils;

import android.support.annotation.Nullable;

import com.example.ereminilya.drive2_ok.utils.storage.Storage;

/**
 * Created by ereminilya on 20/11/16.
 */
public class SessionManager {

    private static final String KEY_COOKIE = "cookie";

    private final Storage storage;

    public SessionManager(Storage storage) {
        this.storage = storage;
    }

    public void saveCookie(String cookie) {
        storage.putString(KEY_COOKIE, cookie);
    }

    @Nullable public String getCookie() {
        return storage.getString(KEY_COOKIE);
    }

    public boolean containsCookie() {
        return false;
    }
}