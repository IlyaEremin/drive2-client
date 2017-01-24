package com.example.ereminilya.drive2_ok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.example.ereminilya.drive2_ok.login.LoginScreen;
import com.example.ereminilya.drive2_ok.profile.ProfileScreen;
import com.example.ereminilya.drive2_ok.utils.SessionManager;
import com.example.ereminilya.drive2_ok.utils.di.Injector;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Inject SessionManager sessionManager;

    @Bind(R.id.controller_container) ViewGroup uiCotrollerContainer;

    private Router router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Injector.inject(this);
        router = Conductor.attachRouter(this, uiCotrollerContainer, savedInstanceState);
        if (!router.hasRootController()) {
            if (sessionManager.userAuthorized()) {
                router.setRoot(RouterTransaction.with(new ProfileScreen()));
            } else {
                router.setRoot(RouterTransaction.with(new LoginScreen()));
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed();
        }
    }
}