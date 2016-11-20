package com.example.ereminilya.drive2_ok.utils.ui;

import android.support.annotation.LayoutRes;

/**
 * Created by ereminilya on 20/11/16.
 */

public class ScreenParams {

    @LayoutRes private final int layout;
    private boolean injectDependency;

    public ScreenParams(@LayoutRes int layout) {
        this.layout = layout;
    }

    public ScreenParams injectDependency() {
        this.injectDependency = true;
        return this;
    }

    public @LayoutRes int getLayout() {
        return layout;
    }

    public boolean needDependencyInjection() {
        return injectDependency;
    }
}