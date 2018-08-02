package com.via.hookdemo.utils;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.util.Log;

/**
 * Created by eminzhang    2018/8/2
 */
public class CustomInstrumentation extends Instrumentation {

    private static final String TAG = "CustomInstrumentation";
    private Instrumentation base;

    public CustomInstrumentation(Instrumentation base) {
        this.base = base;
    }

    @Override
    public Activity newActivity(ClassLoader cl, String className, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Log.d(TAG,"invoked  CustomInstrumentation#newActivity, " + "class name =" + className + ", intent = " + intent);
        return super.newActivity(cl, className, intent);
    }
}
