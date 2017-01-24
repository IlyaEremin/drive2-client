package com.example.ereminilya.drive2_ok;

import android.app.Application;

import com.example.ereminilya.drive2_ok.utils.di.DaggerSingletonsComponent;
import com.example.ereminilya.drive2_ok.utils.di.Singletons;
import com.example.ereminilya.drive2_ok.utils.di.SingletonsComponent;

/**
 * Created by ereminilya on 20/11/16.
 */

public class App extends Application {

    private SingletonsComponent component;

    @Override public void onCreate() {
        super.onCreate();
        component = DaggerSingletonsComponent.builder().singletons(new Singletons(this)).build();
    }

    public SingletonsComponent getComponent() {
        return component;
    }
}
