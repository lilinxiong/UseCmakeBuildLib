//
// Created by xong on 2018/9/25.
//
#include <jni.h>
#include "ahello.h"
#define XONGFUNC(name)Java_com_xong_jni_##name

extern "C" JNIEXPORT
jint JNICALL
XONGFUNC(NativeHelloALib_intFromHelloA)(JNIEnv *env, jclass type,
                                                jint i)
{
    return ahello(i);
}