package com.masm.immersionbar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.library.immersionbar.ImmersionBar;
import com.masm.immersionbar.R;
import com.masm.immersionbar.adapter.BannerAdapter;
import com.masm.immersionbar.adapter.MainAdapter;
import com.masm.immersionbar.bean.MainBean;
import com.masm.immersionbar.utils.DataUtils;
import com.masm.immersionbar.utils.GlideUtils;
import com.masm.immersionbar.utils.Utils;
import com.masm.immersionbar.utils.ViewUtils;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private RecyclerView mRcyMain;
    private MainAdapter mMainAdapter;
    private ArrayList<MainBean> mMainData;

    private Toolbar mToolBar;
    private ImageView mIvBanner;
    private LinearLayoutManager mLayoutManager;
    private BannerAdapter mBannerAdapter;

    private int mBannerPosition = -1;

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

    @Override
    protected void initRecyclerView() {
        mMainAdapter = new MainAdapter();
        mMainAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
        mMainAdapter.isFirstOnly(false);
        mRcyMain.setAdapter(mMainAdapter);
        mMainAdapter.setNewData(mMainData);

        addHeaderView();
    }

    private void addHeaderView() {
        View bannerView = LayoutInflater.from(this).inflate(R.layout.item_banner, mRcyMain, false);
        mIvBanner = bannerView.findViewById(R.id.ivBanner);
        RecyclerView recyclerView = bannerView.findViewById(R.id.rcyContent);
        ViewUtils.increaseViewHeightByStatusBarHeight(this, mIvBanner);
        ImmersionBar.setTitleBarMarginTop(this, recyclerView);

        mLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        //限制RecyclerView横向滑动时一次只能滑一页
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        mBannerAdapter = new BannerAdapter(Utils.getPics());
        recyclerView.setAdapter(mBannerAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (mBannerPosition != mLayoutManager.findFirstVisibleItemPosition()) {
                    mBannerPosition = mLayoutManager.findFirstVisibleItemPosition();
                    ArrayList<String> data = mBannerAdapter.getData();
                    String s = data.get(mBannerPosition % data.size());
                    GlideUtils.loadBlurry(mIvBanner, s);
                }
            }
        });

        mMainAdapter.addHeaderView(bannerView);
    }

    @Override
    protected void initListener() {
        mMainAdapter.setOnItemClickListener((adapter, view, position) -> {
            MainBean mainBean = (MainBean) adapter.getData().get(position);
            Intent intent = null;
            switch (position) {
                case 0:
                    intent = new Intent(this, ParamsActivity.class);
                    intent.putExtra("title", mainBean.getName());
                    break;
                case 1:
                    break;
            }
            if (intent != null) {
                startActivity(intent);
            }
        });
    }
}
