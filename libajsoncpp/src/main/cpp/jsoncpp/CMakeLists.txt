cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_VERBOSE_MAKEFILE on)

add_library(
        jsoncpp
        STATIC
        src/json_tool.h
        src/json_reader.cpp
        src/json_valueiterator.inl
        src/json_value.cpp
        src/json_writer.cpp
        src/version.h.in)

set(export_dir ${CMAKE_CURRENT_SOURCE_DIR}/../../../../../export)

set_target_properties(
        jsoncpp
        PROPERTIES ARCHIVE_OUTPUT_DIRECTORY "${export_dir}/libajsoncpp/lib/${ANDROID_ABI}")

# 按文件挨个导出头文件
#add_custom_command(
#        TARGET jsoncpp POST_BUILD

#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/allocator.h" "${export_dir}/libajsoncpp/include/json/allocator.h"
#
#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/config.h" "${export_dir}/libajsoncpp/include/json/config.h"
#
#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/forwards.h" "${export_dir}/libajsoncpp/include/json/forwards.h"
#
#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/features.h" "${export_dir}/libajsoncpp/include/json/features.h"
#
#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/value.h" "${export_dir}/libajsoncpp/include/json/value.h"
#
#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/reader.h" "${export_dir}/libajsoncpp/include/json/reader.h"
#
#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/writer.h" "${export_dir}/libajsoncpp/include/json/writer.h"
#
#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/assertions.h" "${export_dir}/libajsoncpp/include/json/assertions.h"
#
#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/autolink.h"  "${export_dir}/libajsoncpp/include/json/autolink.h"
#
#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/json.h"  "${export_dir}/libajsoncpp/include/json/json.h"
#
#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/version.h"  "${export_dir}/libajsoncpp/include/json/version.h"
#)

# 按文件夹导出
add_custom_command(
        TARGET jsoncpp POST_BUILD
        # 将 ${CMAKE_CURRENT_SOURCE_DIR}/src/json 文件夹下的文件 导出到 ${export_dir}/libajsoncpp/include/json/ 文件夹内
        COMMAND "${CMAKE_COMMAND}" -E copy_directory "${CMAKE_CURRENT_SOURCE_DIR}/src/json" "${export_dir}/libajsoncpp/include/json/"
)