package com.example.ereminilya.drive2_ok.utils;

import android.support.annotation.NonNull;
import android.widget.TextView;

/**
 * Created by ereminilya on 15/11/16.
 */

public class TextUtils {

    public static String textOf(@NonNull TextView textView) {
        return textView.getText().toString();
    }
}
