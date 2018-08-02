package com.via.hookdemo.utils;

import android.app.Instrumentation;

import com.via.hookdemo.utils.CustomInstrumentation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by eminzhang    2018/8/2
 */
public class Hooker {
    private static final String TAG = "Hooker";

    public static void hookInstrumentation() throws Exception {
        Class<?> activityThread = Class.forName("android.app.ActivityThread");
        Method sCurrentActivityThread = activityThread.getDeclaredMethod("currentActivityThread");
        sCurrentActivityThread.setAccessible(true);
        //获取ActivityThread 对象
        Object activityThreadObject = sCurrentActivityThread.invoke(activityThread);

        //获取 Instrumentation 对象
        Field mInstrumentation = activityThread.getDeclaredField("mInstrumentation");
        mInstrumentation.setAccessible(true);
        Instrumentation instrumentation = (Instrumentation) mInstrumentation.get(activityThreadObject);
        CustomInstrumentation customInstrumentation = new CustomInstrumentation(instrumentation);
        //将我们的 customInstrumentation 设置进去
        mInstrumentation.set(activityThreadObject, customInstrumentation);
    }
}
