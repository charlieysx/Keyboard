package com.codebear.keyboard;

import android.app.Activity;
import android.graphics.Rect;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewTreeObserver;

import com.codebear.keyboard.listeners.OnKeyboardListener;
import com.codebear.keyboard.listeners.OnNavListener;
import com.codebear.keyboard.utils.KeyboardUtil;

/**
 * description: Listening to the keyboard
 * <p>
 * Created by CodeBear on 2017/8/1.
 */

public class CBKeyboard {
    private OnKeyboardListener onKeyboardListener;
    private OnNavListener onNavListener;

    public CBKeyboard setOnKeyboardListener(OnKeyboardListener onKeyboardListener) {
        this.onKeyboardListener = onKeyboardListener;
        return this;
    }

    public CBKeyboard setOnNavListener(OnNavListener onNavListener) {
        this.onNavListener = onNavListener;
        return this;
    }

    private Activity activity;
    private View rootView;
    private int nowHeight = -1;
    private int screenHeight = 0;
    private boolean keyboardOpen = false;
    private boolean navOpen = false;

    public CBKeyboard(Activity activity) {
        if (activity == null) {
            return;
        }
        this.activity = activity;
        rootView = activity.getWindow().getDecorView();
    }

    public CBKeyboard(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        activity = fragment.getActivity();
        rootView = activity.getWindow().getDecorView();
    }

    public CBKeyboard(android.app.Fragment fragment) {
        if (fragment == null) {
            return;
        }
        activity = fragment.getActivity();
        rootView = activity.getWindow().getDecorView();
    }

    public void listener() {
        if (rootView == null) {
            return;
        }
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                rootView.getWindowVisibleDisplayFrame(r);
                int navHeight = KeyboardUtil.getNavHeight(activity);
                if (screenHeight == 0) {
                    screenHeight = r.bottom + navHeight;
                }
                nowHeight = screenHeight - r.bottom;

                int keyboardHeight = nowHeight - navHeight;
                if(navHeight == 0 && navOpen) {
                    navOpen = false;
                    if(onNavListener != null) {
                        onNavListener.onNavClose();
                    }
                } else if(navHeight > 0 && !navOpen) {
                    navOpen = true;
                    if(onNavListener != null) {
                        onNavListener.onNavOpen(navHeight);
                    }
                }

                if(keyboardHeight == 0 && keyboardOpen) {
                    keyboardOpen = false;
                    if(onKeyboardListener != null) {
                        onKeyboardListener.onKeyboardClose();
                    }
                } else if(keyboardHeight > 0 && !keyboardOpen) {
                    keyboardOpen = true;
                    if(onKeyboardListener != null) {
                        onKeyboardListener.onKeyboardOpen(keyboardHeight);
                    }
                }
            }
        });
    }
}
