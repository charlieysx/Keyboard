package com.codebear.demo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * description:
 * <p>
 * Created by CodeBear on 17/6/6.
 */

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        afterCreate(savedInstanceState);
    }

    protected abstract int getLayoutId();

    protected abstract void afterCreate(Bundle savedInstanceState);

}
