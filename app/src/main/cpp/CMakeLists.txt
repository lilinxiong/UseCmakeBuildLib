cmake_minimum_required(VERSION 3.4.1)

# 设置变量
set(export_dir ${CMAKE_SOURCE_DIR}/../../../../export)

# 添加.so动态库(hello)
add_library(lib_so_hello SHARED IMPORTED)
# 链接so
set_target_properties(lib_so_hello PROPERTIES IMPORTED_LOCATION
        ${export_dir}/libsohello/lib/${ANDROID_ABI}/libhello.so)

# 添加.so动态库(jsoncpp)
add_library(lib_so_jsoncpp SHARED IMPORTED)
# 链接
set_target_properties(lib_so_jsoncpp PROPERTIES IMPORTED_LOCATION
        ${export_dir}/libsojsoncpp/lib/${ANDROID_ABI}/libjsoncpp.so)

# 添加.a静态库(hello)
add_library(lib_a_hello STATIC IMPORTED)
# 链接
set_target_properties(lib_a_hello PROPERTIES IMPORTED_LOCATION
        ${export_dir}/libahello/lib/${ANDROID_ABI}/libhello.a)

# 添加.a静态库(jsoncpp)
add_library(lib_a_jsoncpp STATIC IMPORTED)
# 链接
set_target_properties(lib_a_jsoncpp PROPERTIES IMPORTED_LOCATION
        ${export_dir}/libajsoncpp/lib/${ANDROID_ABI}/libjsoncpp.a)

# build application's shared lib
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

add_library(
        native_test
        SHARED
        # new project cpp
        native_lib.cpp
        # .so hello
        native_so_hello_test.cpp
        # .a hello
        native_a_hello_test.cpp
        # .so jsoncpp
        native_so_jsoncpp_test.cpp
        # .a jsoncpp
        native_a_jsoncpp_test.cpp
)

# 链接头文件
target_include_directories(
        native_test
        PRIVATE
        # native_so_hello_test 需要的头文件
        ${export_dir}/libsohello/include
        # native_so_jsoncpp_test 需要的头文件
        ${export_dir}/libsojsoncpp/include
        # native_a_hello_test 需要的头文件
        ${export_dir}/libahello/include
        # navite_a_jsoncpp_test 需要的头文件
        ${export_dir}/libajsoncpp/include
        )

# 链接库
target_link_libraries(
        native_test
        android
        log
        # 链接 hello.so
        lib_so_hello
        # 链接 jsoncpp.so
        lib_so_jsoncpp
        # 链接 hello.a
        lib_a_hello
        # 链接 jsoncpp.a
        lib_a_jsoncpp
)