//
// Created by xong on 2018/9/26.
//
#include <jni.h>
#include <string>

extern "C" JNIEXPORT
jstring JNICALL
Java_com_xong_jni_Nativelib_stringFromNativeLib(JNIEnv *env, jclass type) {
    std::string str = "hello from native_lib";
    return env->NewStringUTF("hello from native_lib");
//    return env->NewStringUTF(str.c_str());
}
