package com.example.ereminilya.drive2_ok.utils.storage;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.reflect.Type;

/**
 * Created by ereminilya on 20/11/16.
 */

public interface Storage {
    void put(String key, @NonNull Object item);

    @Nullable <T> T get(@NonNull String key, @NonNull Type clazz);

    boolean contains(@NonNull String key);

    void putLong(@NonNull String key, long number);

    long getLong(@NonNull String key, long defaultValue);

    void putInt(@NonNull String key, int number);

    int getInt(@NonNull String key, int defaultValue);

    void putBoolean(@NonNull String key, boolean value);

    boolean getBoolean(@NonNull String key, boolean defaultValue);

    void putString(@NonNull final String key, @NonNull String str);

    @Nullable String getString(@NonNull String key);

    void remove(@NonNull String key);

    void clear();
}
