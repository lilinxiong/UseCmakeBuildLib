package com.xong.usecmakebuildlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_libs_content = findViewById(R.id.tv_libs_content);

        // new project
//        tv_libs_content.setText(Nativelib.stringFromNativeLib());

        /**---------------------------libcode---------------------------*/
//        集成cpp源码方式生成json字符串
//        String outputJsonCode = NativeCode.outputJsonCode("xong", "21", "man", "code");
//        tv_libs_content.setText(outputJsonCode);
//        集成cpp源码方式中解析json函数
//        String parseJsonCode = NativeCode.parseJsonCode(outputJsonCode);
//        tv_libs_content.setText(parseJsonCode);

        /**---------------------------libasimple---------------------------*/
        // 调用hello.a静态库中的函数
//        tv_libs_content.setText(String.valueOf(NativeHelloALib.intFromHelloA(100)));

        /**---------------------------libsosimple---------------------------*/
        // 调用hello.so动态库中的函数
//        tv_libs_content.setText(String.valueOf(NativeHelloSoLib.intFromHelloSo(10)));

        /**---------------------------libajsoncpp---------------------------*/
//        调用jsoncpp.a生成json
//        String outputJson = NativeJsonALib.outputJsonA("xong", "21", "man", "a");
//        tv_libs_content.setText(outputJson);
////      调用jsoncpp.a解析json
//        String parseJson = NativeJsonALib.parseJsonA(outputJson);
//        tv_libs_content.setText(parseJson);

        /**---------------------------libsojsoncpp---------------------------*/
//        调用jsoncpp.so生成json
//        String outputJsonSo = NativeJsonSoLib.outputJsonSo("xong", "21", "man", "so");
//        tv_libs_content.setText(outputJsonSo);
//        调用jsoncpp.so解析json
//        String parseJsonSo = NativeJsonSoLib.parseJsonSo(outputJsonSo);
//        tv_libs_content.setText(parseJsonSo);

    }
}
