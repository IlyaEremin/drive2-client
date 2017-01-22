package com.example.ereminilya.drive2_ok.utils.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Controller;

import butterknife.ButterKnife;

/**
 * Created by ereminilya on 20/11/16.
 */

public abstract class BaseController extends Controller {

    @NonNull @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        if (getScreenParams().needDependencyInjection()) {
            inject();
        }
        View view = inflater.inflate(getScreenParams().getLayout(), container, false);
        ButterKnife.bind(this, view);
        onViewInitialized();
        return view;
    }

    protected void onViewInitialized() {
    }

    protected void inject() {
        throw new IllegalStateException("should be overriden");
    }

    protected abstract ScreenParams getScreenParams();

    protected Context context() {
        return getActivity();
    }
}