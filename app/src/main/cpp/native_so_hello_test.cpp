//
// Created by xong on 2018/9/25.
//
#include <jni.h>
#include "sohello.h"
extern "C" JNIEXPORT
jint JNICALL
Java_com_xong_jni_NativeHelloSoLib_intFromHelloSo(JNIEnv *env, jclass type, jint i)
{
    return sohello(i);
}