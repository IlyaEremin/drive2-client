package com.example.ereminilya.drive2_ok.login;

import android.widget.EditText;

import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler;
import com.example.ereminilya.drive2_ok.R;
import com.example.ereminilya.drive2_ok.UserInteractor;
import com.example.ereminilya.drive2_ok.login.models.LoginBody;
import com.example.ereminilya.drive2_ok.profile.ProfileScreen;
import com.example.ereminilya.drive2_ok.utils.Rxs;
import com.example.ereminilya.drive2_ok.utils.di.Injector;
import com.example.ereminilya.drive2_ok.utils.ui.BaseController;
import com.example.ereminilya.drive2_ok.utils.ui.ScreenParams;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

import static com.example.ereminilya.drive2_ok.utils.TextUtils.textOf;

/**
 * Created by ereminilya on 15/11/16.
 */

public class LoginScreen extends BaseController {

    @Inject UserInteractor userInteractor;

    @Bind(R.id.et_login)    EditText uiLoginEt;
    @Bind(R.id.et_password) EditText uiPasswordEt;

    @Override protected ScreenParams getScreenParams() {
        return new ScreenParams(R.layout.screen_login).injectDependency();
    }

    @Override protected void inject() {
        Injector.inject(this);
    }

    @OnClick(R.id.enter) void onEnterClick() {
        LoginBody loginBody = new LoginBody(textOf(uiLoginEt), textOf(uiPasswordEt));
        userInteractor.login(loginBody)
            .compose(Rxs.doInBackgroundDeliverToUI())
            .subscribe(result -> {
                getRouter().pushController(RouterTransaction
                    .with(new ProfileScreen())
                    .pushChangeHandler(new HorizontalChangeHandler())
                    .popChangeHandler(new HorizontalChangeHandler())
                );
            }, error -> { });
    }
}
