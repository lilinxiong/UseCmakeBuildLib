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



##### 注：
1. export 是编译 任何一个模块 自己在当前项目目录下自动生成的;
1. app/src/main/cpp/CmakeLists.txt 中的注释是关于链接so动态库、a静态库、链接头文件到native;
1. libasimple/build.gradle 中需要设置一下 targets 名称，最好和 libasimple/src/main/cpp/hello/CmakeLists.txt 中的名字一样 如下:
    ```
    android {
    ...
        defaultConfig {
            ...
            externalNativeBuild {
                cmake {
                ...
                    targets "hello"
                ...
                }
            }
            ...
        }
    ...
    }
    ```
1. libasimple/src/main/cpp/CmakeLists.txt 中的注释是关于 编译前期目录配置 和 链接 子目录;
1. libasimple/src/main/cpp/hello/CmakeLists.txt 中的注释是关于 库名字、库类型、库导出路径、头文件导出;
1. libsosimple/src/main/cpp/hello/CmakeLists.txt 中的注释是关于 so动态库如何导出，相比 **第5条** 只改了一个参数;
1. libajsoncpp/src/main/cpp/jsoncpp/CmakeLists.txt 中的注释是关于 相比 **第5条** 多了一个 按文件夹导出的命令;
1. app/build.gradle 中最重要的注释是关于集成so动态库时的注意事项，配置如下:
    ```
    android {
    ...
        sourceSets {
            main {
                jniLibs.srcDirs = ['../export/libsohello/lib', '../export/libsojsoncpp/lib']
            }
        }
    ...
    }
    ```