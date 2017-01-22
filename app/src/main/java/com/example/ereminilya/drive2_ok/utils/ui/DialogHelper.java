package com.example.ereminilya.drive2_ok.utils.ui;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import com.example.ereminilya.drive2_ok.R;

import rx.functions.Action0;

/**
 * Created by ereminilya on 22/1/17.
 */

public class DialogHelper {

    public static void networkProblem(Context context) {
        show(context, null, context.getString(R.string.error_network_unavailable), null);
    }

    public static void show(
        @NonNull Context context,
        @Nullable String title, String message,
        @Nullable Action0 onOkPressAction) {
        DialogInterface.OnClickListener dialogClickListener = (dialog, which) -> {
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    if (onOkPressAction != null) {
                        onOkPressAction.call();
                    }
                    dialog.dismiss();
                    break;
                default:
                    break;
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder
            .setTitle(title)
            .setCancelable(false)
            .setMessage(message)
            .setPositiveButton(android.R.string.yes, dialogClickListener)
            .show();
    }

    public static void somethingWentWrong(@NonNull Context context) {
        show(context, null, context.getString(R.string.error_something_went_wrong), null);
    }

    public static void errorWithOkBtn(@NonNull Context context, @NonNull String message) {
        show(context, context.getString(R.string.error), message, null);
    }

    public static void errorWithOkBtn(@NonNull Context context, @StringRes int messageRes) {
        show(context, context.getString(R.string.error), context.getString(messageRes), null);
    }

    public static ProgressDialog loadingDialog(@NonNull Context context, @StringRes int titleRes,
                                               @StringRes int messageRes, Action0 onCancel) {
        return ProgressDialog.show(context, context.getString(titleRes),
            context.getString(messageRes),
            true, true, doOnCancel -> onCancel.call());
    }
}