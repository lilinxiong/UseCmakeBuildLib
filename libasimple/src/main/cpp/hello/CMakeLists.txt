cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_VERBOSE_MAKEFILE on)

add_library(
        # 库名字
        hello
        # 库类型
        STATIC
        # 库中所包含的源文件
        src/ahello.cpp
)

# 设置变量
set(export_dir ${CMAKE_CURRENT_SOURCE_DIR}/../../../../../export)

set_target_properties(
        # 库名字
        hello
        # 设置输出.a静态库的路径
        PROPERTIES ARCHIVE_OUTPUT_DIRECTORY "${export_dir}/libahello/lib/${ANDROID_ABI}")

add_custom_command(
        # POST_BUILD 处 有三个值可选
        # 分别是:
        # PRE_BUILD：在 hello 运行其他规则前执行
        # PRE_LINK：在编译源文件之后但在 链接其他二进制文件 或 运行静态库的库管理器 或 归档工具 之前执行
        # POST_BUILD：最后执行
        TARGET hello POST_BUILD
        # 拷贝命令 将 ${CMAKE_CURRENT_SOURCE_DIR}/src/ahello.h 文件拷贝到 ${export_dir}/libahello/include/ 文件夹内 且名字和之前的相同
        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/ahello.h" "${export_dir}/libahello/include/ahello.h"
)

