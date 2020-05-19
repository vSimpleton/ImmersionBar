package com.masm.immersionbar.utils;

import android.content.Context;

import com.masm.immersionbar.R;

import java.util.Random;

/**
 * NAME: 柚子啊
 * DATE: 2020/5/19
 * DESC: 工具类
 */
public class Utils {

    public static int getFlowerIcon() {
        Random random = new Random();
        int i = random.nextInt(99);
        if (i < 33) {
            return R.drawable.icon_flower_1;
        } else if (i < 66) {
            return R.drawable.icon_flower_2;
        } else {
            return R.drawable.icon_flower_3;
        }
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
