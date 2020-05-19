package com.masm.immersionbar.activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.masm.immersionbar.utils.AppManager;

/**
 * NAME: vSimpleton
 * DATE: 2020/5/18
 * DESC: Activity基类
 */

public class BaseActivity extends AppCompatActivity {

    protected String TAG = "youzi";
    protected Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);
        mActivity = this;

        initView();
        initData();
        initListener();
    }

    protected void initView() {

    }

    protected void initData() {

    }

    protected void initListener() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().removeActivity(this);
    }
}
