package com.masm.immersionbar.adapter;

import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.masm.immersionbar.R;
import com.masm.immersionbar.bean.MainBean;

/**
 * NAME: 柚子啊
 * DATE: 2020/5/19
 * DESC:
 */
public class MainAdapter extends BaseQuickAdapter<MainBean, BaseViewHolder> {

    public MainAdapter() {
        super(R.layout.item_main);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainBean item) {
        CardView cardView = helper.getView(R.id.card);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) cardView.getLayoutParams();
        layoutParams.setMarginStart(item.getMarginStart());
        layoutParams.setMarginEnd(item.getMarginEnd());
        helper.setText(R.id.tvName, item.getName());
        ImageView ivIcon = helper.getView(R.id.ivIcon);
        ImageView ivFlower = helper.getView(R.id.ivFlower);
        ivFlower.setImageResource(item.getFlower());
        Glide.with(mContext).load(item.getPic()).into(ivIcon);
    }
}
