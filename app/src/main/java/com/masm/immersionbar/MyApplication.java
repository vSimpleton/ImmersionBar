package com.masm.immersionbar;

import android.app.Application;
import android.content.Context;

import com.masm.immersionbar.utils.Constants;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * NAME: vSimpleton
 * DATE: 2020/5/18
 * DESC:
 */

public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        //初始化Bugly
        CrashReport.initCrashReport(getApplicationContext(), Constants.BUGLY_APP_ID, BuildConfig.DEBUG);
    }

    public static Context getContext() {
        return mContext;
    }

}
