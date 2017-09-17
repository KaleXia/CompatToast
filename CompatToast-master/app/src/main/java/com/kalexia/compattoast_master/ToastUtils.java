package com.kalexia.compattoast_master;

import android.annotation.SuppressLint;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.AppOpsManagerCompat;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.kalexia.compattoast_master.app.App;
import com.kalexia.toastlib.toast.CompatToast;


/**
 * 屏幕Toast显示工具类
 *
 * @author linkai
 */
public class ToastUtils {
    private static CompatToast compatToast;
    private static CompatToast compatToastImg;

    private static long mLastTime;
    private static String mLastStr = "";
    private static int mDrawable;


    /**
     * 取消toash
     */
    public static void cancelToast() {

        //移除所有的toast
        CompatToast.cancle(App.getApp());
        compatToast = null;
        compatToastImg = null;
    }


    /**
     * 弹出消息(两秒内连续点击不起作用)
     *
     * @param str
     */
    public static void makeText(String str) {

        if (mLastStr != null && mLastStr.equals(str) && System.currentTimeMillis() - mLastTime < 2000) {
            return;
        }
        mLastStr = str;
        mLastTime = System.currentTimeMillis();

        if (compatToast == null || compatToast.inTheQueue()) {
            compatToast = new CompatToast(App.getApp());
            compatToast.setText(str);
            compatToast.setGravity(Gravity.CENTER, 0, 0);
            compatToast.setDuration(Toast.LENGTH_SHORT);

        } else {

            compatToast.setText(str);

        }
        compatToast.show();

    }


    public static void makeText(int drawable, String str) {

        if (drawable == mDrawable && TextUtils.equals(mLastStr, str) && System.currentTimeMillis() - mLastTime < 2000) {
            return;
        }
        mDrawable = drawable;
        mLastStr = str;
        mLastTime = System.currentTimeMillis();

        if (compatToastImg == null || compatToastImg.inTheQueue()) {
            compatToastImg = new CompatToast(App.getApp());


            View view = LayoutInflater.from(App.getApp()).inflate(R.layout.view_toast, null);
            Drawable background = compatToastImg.getBackground();
            if(background != null){
                Drawable drawable1 = background.getConstantState().newDrawable();
                view.setBackground(drawable1);
            }

            ImageView icon = (ImageView) view.findViewById(R.id.icon);
            icon.setImageResource(drawable);
            TextView text1 = (TextView) view.findViewById(R.id.text);
            text1.setText(str);

            compatToastImg.setView(view);
            compatToastImg.setGravity(Gravity.CENTER, 0, 0);
            compatToastImg.setDuration(Toast.LENGTH_SHORT);

        } else {
            if (compatToastImg.getView() != null) {

                ImageView icon = (ImageView) compatToastImg.getView().findViewById(android.R.id.icon);
                if (icon != null) {
                    icon.setImageResource(drawable);
                }
                TextView text = (TextView) compatToastImg.getView().findViewById(android.R.id.text1);
                if (text != null) {
                    text.setText(str);
                }
            }
        }

        compatToastImg.show();

    }




    /**
     * 自定义View 的Toast
     *
     * @param view
     */
    public static void makeCustomView(View view) {

        CompatToast.makeView(App.getApp(), view, Toast.LENGTH_SHORT).show();


    }


}
