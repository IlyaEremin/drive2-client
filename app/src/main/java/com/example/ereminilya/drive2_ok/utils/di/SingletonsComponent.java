package com.example.ereminilya.drive2_ok.utils.di;

import com.example.ereminilya.drive2_ok.login.LoginScreen;
import com.example.ereminilya.drive2_ok.profile.ProfileScreen;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ereminilya on 20/11/16.
 */

@Singleton
@Component(modules = {Singletons.class})
public interface SingletonsComponent {

    void inject(LoginScreen loginScreen);

    void inject(ProfileScreen profileScreen);
}
