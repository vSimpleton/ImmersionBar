package com.library.immersionbar;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

/**
 * NAME: 柚子啊
 * DATE: 2020/5/20
 * DESC:
 */
public final class ImmersionBar implements ImmersionCallback{

    public static int getStatusBarHeight(@NonNull Activity activity) {
        BarConfig config = new BarConfig(activity);
        return config.getStatusBarHeight();
    }

    /**
     * 为标题栏marginTop增加状态栏的高度
     * Sets title bar margin top.
     *
     * @param activity the activity
     * @param view     the view
     */
    public static void setTitleBarMarginTop(Activity activity, View... view) {
        setTitleBarMarginTop(activity, getStatusBarHeight(activity), view);
    }

    /**
     * 为标题栏marginTop增加fixHeight的高度
     * Sets title bar margin top.
     *
     * @param activity  the activity
     * @param fixHeight the fix height
     * @param view      the view
     */
    public static void setTitleBarMarginTop(Activity activity, int fixHeight, View... view) {
        if (activity == null) {
            return;
        }
        if (fixHeight < 0) {
            fixHeight = 0;
        }
        for (View v : view) {
            if (v == null) {
                continue;
            }
            Integer fitsHeight = (Integer) v.getTag(R.id.immersion_fits_layout_overlap);
            if (fitsHeight == null) {
                fitsHeight = 0;
            }
            if (fitsHeight != fixHeight) {
                v.setTag(R.id.immersion_fits_layout_overlap, fixHeight);
                ViewGroup.LayoutParams lp = v.getLayoutParams();
                if (lp == null) {
                    lp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                }
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) lp;
                layoutParams.setMargins(layoutParams.leftMargin,
                        layoutParams.topMargin + fixHeight - fitsHeight,
                        layoutParams.rightMargin,
                        layoutParams.bottomMargin);
                v.setLayoutParams(layoutParams);
            }
        }
    }

    @Override
    public void onNavigationBarChange(boolean show) {

    }

    @Override
    public void run() {

    }
}
