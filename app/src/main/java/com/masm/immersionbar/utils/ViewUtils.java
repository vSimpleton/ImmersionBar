package com.masm.immersionbar.utils;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import com.library.immersionbar.ImmersionBar;


public class ViewUtils {
    public static void increaseViewHeightByStatusBarHeight(Activity activity, View view) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        if (lp == null) {
            lp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) lp;
        layoutParams.height += ImmersionBar.getStatusBarHeight(activity);
        view.setLayoutParams(layoutParams);
    }
}