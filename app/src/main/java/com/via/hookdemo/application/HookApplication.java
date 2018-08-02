package com.via.hookdemo.application;

import android.app.Application;
import android.util.Log;

import com.via.hookdemo.utils.Hooker;

/**
 * Created by eminzhang    2018/8/2
 */
public class HookApplication extends Application {
    private static final String TAG = "HookApplication";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate");
        try {
            Hooker.hookInstrumentation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
