cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_VERBOSE_MAKEFILE on)

add_library(hello STATIC src/libahello.cpp)

set(export_dir ${CMAKE_CURRENT_SOURCE_DIR}/../../../../../export)

set_target_properties(
        hello
        PROPERTIES
        ARCHIVE_OUTPUT_DIRECTORY
        "${export_dir}/libahello/lib/${ANDROID_ABI}")

add_custom_command(
        TARGET hello POST_BUILD
        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/libhello.h" "${export_dir}/libahello/include/libhello.h"
)

