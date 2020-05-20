package com.library.immersionbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import static com.library.immersionbar.Constants.IMMERSION_STATUS_BAR_HEIGHT;

/**
 * NAME: 柚子啊
 * DATE: 2020/5/20
 * DESC:
 */
public class BarConfig {

    private final int mStatusBarHeight;

    BarConfig(Activity activity) {
        Resources res = activity.getResources();
        mStatusBarHeight = getInternalDimensionSize(activity, IMMERSION_STATUS_BAR_HEIGHT);
    }

    private int getInternalDimensionSize(Context context, String key) {
        int result = 0;
        try {
            int resourceId = Resources.getSystem().getIdentifier(key, "dimen", "android");
            if (resourceId > 0) {
                int sizeOne = context.getResources().getDimensionPixelSize(resourceId);
                int sizeTwo = Resources.getSystem().getDimensionPixelSize(resourceId);

                if (sizeTwo >= sizeOne) {
                    return sizeTwo;
                } else {
                    float densityOne = context.getResources().getDisplayMetrics().density;
                    float densityTwo = Resources.getSystem().getDisplayMetrics().density;
                    float f = sizeOne * densityTwo / densityOne;
                    return (int) ((f >= 0) ? (f + 0.5f) : (f - 0.5f));
                }
            }
        } catch (Resources.NotFoundException ignored) {
            return 0;
        }
        return result;
    }

    int getStatusBarHeight() {
        return mStatusBarHeight;
    }

}
