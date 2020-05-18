package com.masm.immersionbar;

import android.app.Application;
import android.content.Context;

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
        CrashReport.initCrashReport(getApplicationContext(), "fedd985d15", true);
    }

    public static Context getContext() {
        return mContext;
    }

}
