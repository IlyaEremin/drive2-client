package com.example.ereminilya.drive2_ok.login;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.bluelinelabs.conductor.Controller;
import com.example.ereminilya.drive2_ok.R;
import com.example.ereminilya.drive2_ok.login.models.LoginBody;
import com.example.ereminilya.drive2_ok.utils.Deps;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.example.ereminilya.drive2_ok.utils.TextUtils.textOf;

/**
 * Created by ereminilya on 15/11/16.
 */

public class LoginScreen extends Controller {

    @Bind(R.id.et_login)    EditText uiLoginEt;
    @Bind(R.id.et_password) EditText uiPasswordEt;

    @NonNull @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.screen_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.enter) void onEnterClick() {
        LoginBody loginBody = new LoginBody(textOf(uiLoginEt), textOf(uiPasswordEt));
        Deps.providesApi().login(loginBody)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(result -> {
                Toast.makeText(getActivity(), "Successfully logged in", Toast.LENGTH_SHORT).show();
            }, error -> { });
    }
}
