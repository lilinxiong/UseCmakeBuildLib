cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_VERBOSE_MAKEFILE on)

# 设置资源主目录 CMAKE_CURRENT_SOURCE_DIR 代表当前CmakeLists.txt 所在的目录
set(lib_src_DIR ${CMAKE_CURRENT_SOURCE_DIR})

# 设置Cmake编译后文件的存放的临时目录
set(lib_build_DIR $ENV{HOME}/tmp)

# 将生成的临时文件放在 lib_build_DIR 中
file(MAKE_DIRECTORY ${lib_build_DIR})

# 添加子项目
add_subdirectory(${lib_src_DIR}/hello ${lib_build_DIR}/hello)

