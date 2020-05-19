package com.masm.immersionbar.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.masm.immersionbar.R;
import com.masm.immersionbar.adapter.MainAdapter;
import com.masm.immersionbar.bean.MainBean;
import com.masm.immersionbar.utils.DataUtils;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private RecyclerView mRcyMain;
    private Toolbar mToolBar;
    private MainAdapter mAdapter;
    private ArrayList<MainBean> mMainData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRecyclerView();
    }

    @Override
    protected void initView() {
        mRcyMain = findViewById(R.id.rcyMain);
        mToolBar = findViewById(R.id.toolBar);
    }

    @Override
    protected void initData() {
        mMainData = DataUtils.getMainData(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private void initRecyclerView() {
        mAdapter = new MainAdapter();
        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
        mAdapter.isFirstOnly(false);
        mRcyMain.setAdapter(mAdapter);
        mAdapter.setNewData(mMainData);
    }
}
