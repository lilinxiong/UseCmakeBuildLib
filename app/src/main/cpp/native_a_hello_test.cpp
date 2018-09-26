//
// Created by xong on 2018/9/25.
//
#include <jni.h>
#include "ahello.h"

extern "C" JNIEXPORT
jint JNICALL
Java_com_xong_jni_NativeHelloALib_intFromHelloA(JNIEnv *env, jclass type, jint i)
{
    return ahello(i);
}