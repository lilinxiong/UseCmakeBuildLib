### 使用Cmake构建.a静态库和.so动态库
Google例子:https://github.com/googlesamples/android-ndk/tree/master/hello-libs

#### Demo中子模块说明:

* **libcode:**
    以源码的形式将SDK依赖到cpp中使用
* **libsosimple:**
    构建hello简单的.so动态库，且将.so和所需头文件导出到 project/export/libsohello 目录中
* **libsojsoncpp:**
    构建jsoncpp的.so动态库，且将.so和所需头文件导出到 project/export/libsojsoncpp 目录中
* **libasimple:**
    构建一个hello简单的.a静态库，且将.a和所需头文件导出到 project/export/libahello 目录中
* **libajsoncpp:**
    构建jsoncpp的.a静态库，且将.a和所需头文件导出到 project/export/libajsoncpp 目录中
