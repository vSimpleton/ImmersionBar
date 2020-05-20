package com.masm.immersionbar.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.masm.immersionbar.R;

import java.util.ArrayList;
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

    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager manager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = manager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    public static ArrayList<String> getPics() {
        return getPics(4);
    }

    public static ArrayList<String> getPics(int num) {
        ArrayList<String> pics = new ArrayList<>();
        Random random = new Random();

        do {
            String s = "http://106.14.135.179/ImmersionBar/" + random.nextInt(40) + ".jpg";
            if (!pics.contains(s)) {
                pics.add(s);
            }
        } while (pics.size() < num);
        return pics;
    }

}
