package com.xong.jni;

/**
 * Create by xong on 2018/9/26
 */
public class NativeJsonALib {

    static {
        System.loadLibrary("native_test");
    }

    // 生成json
    public static native String outputJsonA(String name, String age, String sex, String type);
    // 解析json
    public static native String parseJsonA(String json_str);
}
