package com.example.ereminilya.drive2_ok.utils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Rxs {

    public static <T> Observable.Transformer<T, T> doInBackgroundDeliverToUI() {
        return observable -> observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

}