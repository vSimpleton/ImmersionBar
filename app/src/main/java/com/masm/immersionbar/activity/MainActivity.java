package com.masm.immersionbar.activity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.masm.immersionbar.R;
import com.masm.immersionbar.activity.BaseActivity;

public class MainActivity extends BaseActivity {

    private RecyclerView mRcyMain;
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {
        mRcyMain = findViewById(R.id.rcyMain);
        mToolBar = findViewById(R.id.toolBar);
    }
}
