package com.example.ereminilya.drive2_ok.login;

import android.app.ProgressDialog;
import android.support.annotation.Nullable;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler;
import com.example.ereminilya.drive2_ok.R;
import com.example.ereminilya.drive2_ok.UserInteractor;
import com.example.ereminilya.drive2_ok.login.models.LoginBody;
import com.example.ereminilya.drive2_ok.profile.ProfileScreen;
import com.example.ereminilya.drive2_ok.utils.Keyboard;
import com.example.ereminilya.drive2_ok.utils.Rxs;
import com.example.ereminilya.drive2_ok.utils.di.Injector;
import com.example.ereminilya.drive2_ok.utils.ui.BaseController;
import com.example.ereminilya.drive2_ok.utils.ui.DialogHelper;
import com.example.ereminilya.drive2_ok.utils.ui.ScreenParams;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import rx.Subscription;

import static com.example.ereminilya.drive2_ok.utils.TextUtils.textOf;

/**
 * Created by ereminilya on 15/11/16.
 */

public class LoginScreen extends BaseController {

    @Inject UserInteractor userInteractor;

    @Bind(R.id.et_login)    EditText uiLoginEt;
    @Bind(R.id.et_password) EditText uiPasswordEt;

    @Nullable private Subscription   loginSubscription;
    @Nullable private ProgressDialog progressDialog;

    @Override protected ScreenParams getScreenParams() {
        return new ScreenParams(R.layout.screen_login).injectDependency();
    }

    @Override protected void inject() {
        Injector.inject(this);
    }

    @OnClick(R.id.enter) void onEnterClick() {
        performLogin();
    }

    private void performLogin() {
        LoginBody loginBody = new LoginBody(textOf(uiLoginEt), textOf(uiPasswordEt));
        showProgressDialog();
        loginSubscription = userInteractor.login(loginBody)
            .compose(Rxs.doInBackgroundDeliverToUI())
            .doOnTerminate(() -> {
                loginSubscription = null;
                hideProgressDialog();
            })
            .subscribe(result -> {
                getRouter().setRoot(RouterTransaction
                    .with(new ProfileScreen())
                    .pushChangeHandler(new HorizontalChangeHandler())
                    .popChangeHandler(new HorizontalChangeHandler())
                );
            }, error -> {
                // TODO parse error
            });
    }

    @OnEditorAction(value = R.id.et_password) boolean onEditActionOnMessageText(int actionCode) {
        if (actionCode == EditorInfo.IME_ACTION_DONE) {
            Keyboard.hide(uiPasswordEt);
            performLogin();
            return true;
        }
        return false;
    }

    private void showProgressDialog() {
        hideProgressDialog();
        progressDialog = DialogHelper.loadingDialog(context(), R.string.loading,
            R.string.login_progress, this::cancelLoginRequest);
    }

    private void hideProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    private void cancelLoginRequest() {
        if (loginSubscription != null && !loginSubscription.isUnsubscribed()) {
            loginSubscription.unsubscribe();
            loginSubscription = null;
        }
    }
}