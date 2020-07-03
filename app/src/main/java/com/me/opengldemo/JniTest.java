package com.me.opengldemo;

/*
 * Copyright (C) 2017 - 2020 alibaba Inc. All Rights Reserved.
 * Description :
 * Attention   :
 *
 * History     : Creation, 2020/7/2, jiquan.ljq@alibaba-inc.com, Create the file
 */
public class JniTest {
    static {
        //JNIControl 后面新建的.c 或者.cpp 文件名  在这里可以先注释掉
        System.loadLibrary("testlib");
    }

    public static native String test();
}
