package com.example.zhouqiong.stackcardview.view;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by ZQiong on 2018/1/19.
 */
public class Util {

    public static int dp2px(Context context, int dip) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((float) dip * scale + 0.5F * (float) (dip >= 0 ? 1 : -1));
    }
}
