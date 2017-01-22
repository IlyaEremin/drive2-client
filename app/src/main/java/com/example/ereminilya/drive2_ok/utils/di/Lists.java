package com.example.ereminilya.drive2_ok.utils.di;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by ereminilya on 21/11/16.
 */
public class Lists {

    public static String toString(@Nullable List<String> list) {
        if (list == null || list.isEmpty()) return null;
        String result = "";
        for (String s : list) {
            result += s;
        }
        return result;
    }

    public static boolean isEmpty(@Nullable List list) {
        return list == null || list.isEmpty();
    }
}
