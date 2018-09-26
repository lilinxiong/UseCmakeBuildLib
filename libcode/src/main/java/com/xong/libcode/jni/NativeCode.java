package com.xong.libcode.jni;

/**
 * Create by xong on 2018/9/26
 */
public class NativeCode {

    static {
        System.loadLibrary("usecode_lib");
    }

    public static native String outputJsonCode(String name, String age, String sex, String type);

    public static native String parseJsonCode(String json_str);

}
