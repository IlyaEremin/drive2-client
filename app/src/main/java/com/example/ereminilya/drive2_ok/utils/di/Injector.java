package com.example.ereminilya.drive2_ok.utils.di;

import com.example.ereminilya.drive2_ok.App;
import com.example.ereminilya.drive2_ok.login.LoginScreen;
import com.example.ereminilya.drive2_ok.profile.ProfileScreen;

/**
 * Created by ereminilya on 20/11/16.
 */

public class Injector {

    public static void inject(LoginScreen loginScreen) {
        ((App) loginScreen.getApplicationContext()).getComponent().inject(loginScreen);
    }

    public static void inject(ProfileScreen profileScreen) {
        ((App) profileScreen.getApplicationContext()).getComponent().inject(profileScreen);
    }
}