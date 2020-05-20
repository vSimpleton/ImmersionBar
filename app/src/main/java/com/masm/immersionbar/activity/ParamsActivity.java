package com.masm.immersionbar.activity;

import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.masm.immersionbar.R;

public class ParamsActivity extends BaseActivity {

    private TextView mTvStatus;
    private TextView mTvHasNav;
    private TextView mTvNav;
    private TextView mTvNavWidth;
    private TextView mTvAction;
    private TextView mTvHasNotch;
    private TextView mTvInsets;
    private TextView mTvNotchHeight;
    private TextView mTvFits;
    private TextView mTvStatusDark;
    private TextView mTvNavigationDark;

    private Toolbar mToolbar;
    private Button mBtnStatus;

    private boolean mIsHideStatusBar = false;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_params;
    }

    @Override
    protected void initView() {
        mToolbar = findViewById(R.id.mToolbar);
        mTvStatus = findViewById(R.id.mTvStatus);
        mTvHasNav = findViewById(R.id.mTvHasNav);
        mTvNav = findViewById(R.id.mTvNav);
        mTvNavWidth = findViewById(R.id.mTvNavWidth);
        mTvAction = findViewById(R.id.mTvAction);
        mTvHasNotch = findViewById(R.id.mTvHasNotch);
        mTvInsets = findViewById(R.id.mTvInsets);
        mTvNotchHeight = findViewById(R.id.mTvNotchHeight);
        mTvFits = findViewById(R.id.mTvFits);
        mTvStatusDark = findViewById(R.id.mTvStatusDark);
        mTvNavigationDark = findViewById(R.id.mTvNavigationDark);
        mBtnStatus = findViewById(R.id.mBtnStatus);
    }

    @Override
    protected void initData() {
        mToolbar.setTitle(getIntent().getStringExtra("title"));
    }
}
