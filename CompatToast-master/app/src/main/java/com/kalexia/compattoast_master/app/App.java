package com.kalexia.compattoast_master.app;

import android.app.Application;
import android.os.Build;

/**
 * Created by G on 2017/9/16.
 *
 *
 */

public class App extends Application {

    private static App mApp;//唯一实例

    @Override
    public void onCreate() {
        super.onCreate();

        mApp = this;
        //设置程序的异常处理器
    }


    public static App getApp(){
        return mApp;
    }

}
