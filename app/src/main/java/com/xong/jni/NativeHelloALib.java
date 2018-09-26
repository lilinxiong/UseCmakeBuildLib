package com.xong.jni;

/**
 * Create by xong on 2018/9/26
 */
public class NativeHelloALib {
    static {
        System.loadLibrary("native_test");
    }
    public static native int intFromHelloA(int i);
}
