package com.example.jasonxu.mobiletester.utils;

import android.app.Application;
import android.view.WindowManager;

/**
 * my application class
 **/
public class MyApplication extends Application {

//    //LeakCanary example
//    private RefWatcher mRefWatcher;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        mRefWatcher = LeakCanary.install(this);
//    }

    private WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams();

    public WindowManager.LayoutParams getMywmParams() {
        return wmParams;
    }


}
