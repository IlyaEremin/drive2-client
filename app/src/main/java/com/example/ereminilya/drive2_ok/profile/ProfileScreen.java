package com.example.ereminilya.drive2_ok.profile;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ereminilya.drive2_ok.R;
import com.example.ereminilya.drive2_ok.UserInteractor;
import com.example.ereminilya.drive2_ok.login.models.User;
import com.example.ereminilya.drive2_ok.models.Car;
import com.example.ereminilya.drive2_ok.utils.di.Injector;
import com.example.ereminilya.drive2_ok.utils.di.Lists;
import com.example.ereminilya.drive2_ok.utils.ui.BaseController;
import com.example.ereminilya.drive2_ok.utils.ui.ScreenParams;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by ereminilya on 20/11/16.
 */

public class ProfileScreen extends BaseController {

    @Inject UserInteractor userInteractor;

    @Bind(R.id.avatar) ImageView uiAvatar;
    @Bind(R.id.name)   TextView  uiName;
    @Bind(R.id.city)   TextView  uiCity;
    @Bind(R.id.car)    TextView  uiCar;

    @Override protected ScreenParams getScreenParams() {
        return new ScreenParams(R.layout.screen_profile).injectDependency();
    }

    @Override protected void inject() {
        Injector.inject(this);
    }

    @Override protected void onViewInitialized() {
        User user = userInteractor.getUser();
        Glide.with(context()).load(user.getBestProfileImageUrl()).into(uiAvatar);
        uiName.setText(user.getName());
        uiCity.setText(user.getCity());
        List<Car> userCars = userInteractor.getUserCars();
        if (Lists.isEmpty(userCars)) {
            uiCar.setText(R.string.profile_no_cars);
        } else {
            uiCar.setText(userCars.get(0).getName());
        }
    }
}
