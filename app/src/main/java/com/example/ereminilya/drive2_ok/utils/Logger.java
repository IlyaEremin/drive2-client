package com.example.ereminilya.drive2_ok.utils;

import android.util.Log;

/**
 * Created by ereminilya on 24/1/17.
 */

public class Logger {

    private static final String TAG = "TOP_DRIVE2_CLIENT";

    public static void e(Object object) {
        Log.e(TAG, object.toString());
    }
}