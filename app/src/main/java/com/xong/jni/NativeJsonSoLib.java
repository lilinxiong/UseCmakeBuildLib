package com.xong.jni;

/**
 * Create by xong on 2018/9/26
 */
public class NativeJsonSoLib {

    static {
        System.loadLibrary("native_test");
    }

    public static native String outputJsonSo(String name, String age, String sex, String type);

    public static native String parseJsonSo(String json_str);
}
