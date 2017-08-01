package com.codebear.keyboard.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * description: KeyboardUtil
 * <p>
 * Created by CodeBear on 2017/8/1.
 */

public class KeyboardUtil {

    public static void openKeyboard(EditText et) {
        if (et != null) {
            et.setFocusable(true);
            et.setFocusableInTouchMode(true);
            et.requestFocus();
            InputMethodManager inputManager = (InputMethodManager) et.getContext()
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.showSoftInput(et, 0);
        }
    }

    public static void closeKeyboard(Context context) {
        if (context == null || !(context instanceof Activity) || ((Activity) context).getCurrentFocus() == null) {
            return;
        }
        try {
            View view = ((Activity) context).getCurrentFocus();
            if(view == null) {
                return;
            }
            InputMethodManager imm = (InputMethodManager) view.getContext()
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            view.clearFocus();
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static int getNavHeight(Context context) {
        if(context == null) {
            return 0;
        }

        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        DisplayMetrics defaultDisplayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(defaultDisplayMetrics);
        int usableHeight = defaultDisplayMetrics.heightPixels;

        DisplayMetrics realDisplayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(realDisplayMetrics);
        int realHeight = realDisplayMetrics.heightPixels;

        return realHeight > usableHeight ? realHeight - usableHeight : 0;
    }
}
