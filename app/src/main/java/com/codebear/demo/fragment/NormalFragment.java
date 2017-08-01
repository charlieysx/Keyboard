package com.codebear.demo.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.codebear.demo.R;
import com.codebear.demo.base.BaseFragment;
import com.codebear.keyboard.CBKeyboard;
import com.codebear.keyboard.listeners.OnKeyboardListener;
import com.codebear.keyboard.listeners.OnNavListener;

/**
 * description:
 * <p>
 * Created by CodeBear on 2017/8/1.
 */

public class NormalFragment extends BaseFragment {

    TextView tvResultKeyboard;
    TextView tvResultNav;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_keyboard;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        tvResultKeyboard = (TextView) mRootView.findViewById(R.id.tv_result_keyboard);
        tvResultNav = (TextView) mRootView.findViewById(R.id.tv_result_nav);

        new CBKeyboard(this)
                .setOnNavListener(new OnNavListener() {
                    @Override
                    public void onNavOpen(int height) {
                        String text = "nav open : " + height;
                        tvResultNav.setText(text);
                    }

                    @Override
                    public void onNavClose() {
                        tvResultNav.setText("nav close");
                    }
                })
                .setOnKeyboardListener(new OnKeyboardListener() {
                    @Override
                    public void onKeyboardOpen(int height) {
                        String text = "keyboard open : " + height;
                        tvResultKeyboard.setText(text);
                    }

                    @Override
                    public void onKeyboardClose() {
                        tvResultKeyboard.setText("keyboard close");
                    }
                })
                .listener();
    }
}
