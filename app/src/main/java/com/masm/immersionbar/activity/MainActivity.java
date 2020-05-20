package com.masm.immersionbar.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

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
    private Toolbar mToolBar;
    private MainAdapter mAdapter;
    private ArrayList<MainBean> mMainData;
    private ImageView mIvBanner;
    private LinearLayoutManager mLayoutManager;
    private BannerAdapter mBannerAdapter;
    private int mBannerPosition = -1;

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

        mAdapter.addHeaderView(bannerView);
    }
}
