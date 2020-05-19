package com.masm.immersionbar.utils;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.masm.immersionbar.R;
import com.masm.immersionbar.bean.MainBean;

import java.util.ArrayList;

public class DataUtils {
    public static ArrayList<MainBean> getMainData(Context context) {
        ArrayList<MainBean> mainBeans = new ArrayList<>();
        mainBeans.add(new MainBean(context.getString(R.string.text_params), ContextCompat.getDrawable(context, R.drawable.icon_1)));
        mainBeans.add(new MainBean(context.getString(R.string.text_params_kotlin), ContextCompat.getDrawable(context, R.drawable.icon_2)));
        mainBeans.add(new MainBean(context.getString(R.string.text_pic_color), ContextCompat.getDrawable(context, R.drawable.icon_3)));
        mainBeans.add(new MainBean(context.getString(R.string.text_pic), ContextCompat.getDrawable(context, R.drawable.icon_4)));
        mainBeans.add(new MainBean(context.getString(R.string.text_color), ContextCompat.getDrawable(context, R.drawable.icon_5)));
        mainBeans.add(new MainBean(context.getString(R.string.text_shape), ContextCompat.getDrawable(context, R.drawable.icon_6)));
        mainBeans.add(new MainBean(context.getString(R.string.text_swipe_back), ContextCompat.getDrawable(context, R.drawable.icon_7)));
        mainBeans.add(new MainBean(context.getString(R.string.text_fragment), ContextCompat.getDrawable(context, R.drawable.icon_8)));
        mainBeans.add(new MainBean(context.getString(R.string.text_dialog), ContextCompat.getDrawable(context, R.drawable.icon_9)));
        mainBeans.add(new MainBean(context.getString(R.string.text_popup), ContextCompat.getDrawable(context, R.drawable.icon_10)));
        mainBeans.add(new MainBean(context.getString(R.string.text_drawer), ContextCompat.getDrawable(context, R.drawable.icon_11)));
        mainBeans.add(new MainBean(context.getString(R.string.text_coordinator), ContextCompat.getDrawable(context, R.drawable.icon_12)));
        mainBeans.add(new MainBean(context.getString(R.string.text_tab), ContextCompat.getDrawable(context, R.drawable.icon_13)));
        mainBeans.add(new MainBean(context.getString(R.string.text_tab_two), ContextCompat.getDrawable(context, R.drawable.icon_14)));
        mainBeans.add(new MainBean(context.getString(R.string.text_web), ContextCompat.getDrawable(context, R.drawable.icon_15)));
        mainBeans.add(new MainBean(context.getString(R.string.text_action_bar), ContextCompat.getDrawable(context, R.drawable.icon_16)));
        mainBeans.add(new MainBean(context.getString(R.string.text_flyme), ContextCompat.getDrawable(context, R.drawable.icon_17)));
        mainBeans.add(new MainBean(context.getString(R.string.text_over), ContextCompat.getDrawable(context, R.drawable.icon_18)));
        mainBeans.add(new MainBean(context.getString(R.string.text_key_board), ContextCompat.getDrawable(context, R.drawable.icon_19)));
        mainBeans.add(new MainBean(context.getString(R.string.text_all_edit), ContextCompat.getDrawable(context, R.drawable.icon_20)));
        mainBeans.add(new MainBean(context.getString(R.string.text_login), ContextCompat.getDrawable(context, R.drawable.icon_21)));
        mainBeans.add(new MainBean(context.getString(R.string.text_white_bar), ContextCompat.getDrawable(context, R.drawable.icon_22)));
        mainBeans.add(new MainBean(context.getString(R.string.text_auto_status_font), ContextCompat.getDrawable(context, R.drawable.icon_23)));
        mainBeans.add(new MainBean(context.getString(R.string.text_status_hide), ContextCompat.getDrawable(context, R.drawable.icon_24)));
        mainBeans.add(new MainBean(context.getString(R.string.text_navigation_hide), ContextCompat.getDrawable(context, R.drawable.icon_25)));
        mainBeans.add(new MainBean(context.getString(R.string.text_bar_hide), ContextCompat.getDrawable(context, R.drawable.icon_26)));
        mainBeans.add(new MainBean(context.getString(R.string.text_bar_show), ContextCompat.getDrawable(context, R.drawable.icon_27)));
        mainBeans.add(new MainBean(context.getString(R.string.text_full), ContextCompat.getDrawable(context, R.drawable.icon_28)));
        mainBeans.add(new MainBean(context.getString(R.string.text_bar_font_dark), ContextCompat.getDrawable(context, R.drawable.icon_29)));
        mainBeans.add(new MainBean(context.getString(R.string.text_bar_font_light), ContextCompat.getDrawable(context, R.drawable.icon_30)));
        return mainBeans;
    }
}
