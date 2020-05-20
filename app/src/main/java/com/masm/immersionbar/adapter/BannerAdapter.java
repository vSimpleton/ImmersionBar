package com.masm.immersionbar.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masm.immersionbar.R;
import com.masm.immersionbar.utils.GlideUtils;

import java.util.ArrayList;

/**
 * NAME: 柚子啊
 * DATE: 2020/5/20
 * DESC:
 */
public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {

    private ArrayList<String> mData;

    public BannerAdapter(ArrayList<String> data) {
        this.mData = data;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner_pic, parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        String s = mData.get(position % mData.size());
        GlideUtils.load(s, holder.ivPic);
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public ArrayList<String> getData() {
        return mData;
    }

    public void setData(ArrayList<String> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    static class BannerViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivPic;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPic = itemView.findViewById(R.id.iv_pic);
        }
    }

}
