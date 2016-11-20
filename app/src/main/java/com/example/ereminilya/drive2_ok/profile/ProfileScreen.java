package com.example.ereminilya.drive2_ok.profile;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.ereminilya.drive2_ok.R;
import com.example.ereminilya.drive2_ok.UserInteractor;
import com.example.ereminilya.drive2_ok.utils.di.Injector;
import com.example.ereminilya.drive2_ok.utils.ui.BaseController;
import com.example.ereminilya.drive2_ok.utils.ui.ScreenParams;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by ereminilya on 20/11/16.
 */

public class ProfileScreen extends BaseController {

    @Inject UserInteractor userInteractor;

    @Bind(R.id.avatar) ImageView uiAvatar;

    @Override protected ScreenParams getScreenParams() {
        return new ScreenParams(R.layout.screen_profile).injectDependency();
    }

    @Override protected void inject() {
        Injector.inject(this);
    }

    @Override protected void onViewInitialized() {
        Glide.with(getActivity()).load(userInteractor.getAvatarUrl()).into(uiAvatar);
    }
}
