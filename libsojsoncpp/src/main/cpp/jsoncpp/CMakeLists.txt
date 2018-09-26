cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_VERBOSE_MAKEFILE on)

add_library(jsoncpp SHARED
        src/json_tool.h
        src/json_reader.cpp
        src/json_valueiterator.inl
        src/json_value.cpp
        src/json_writer.cpp
        src/version.h.in)

set(export_dir ${CMAKE_CURRENT_SOURCE_DIR}/../../../../../export)

set_target_properties(
        jsoncpp
        PROPERTIES LIBRARY_OUTPUT_DIRECTORY "${export_dir}/libsojsoncpp/lib/${ANDROID_ABI}")

#add_custom_command(
#        TARGET jsoncpp POST_BUILD

#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/allocator.h" "${distribution_DIR}/libsojsoncpp/include/json/allocator.h"
#
#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/config.h" "${distribution_DIR}/libsojsoncpp/include/json/config.h"
#
#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/forwards.h" "${distribution_DIR}/libsojsoncpp/include/json/forwards.h"
#
#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/features.h" "${distribution_DIR}/libsojsoncpp/include/json/features.h"
#
#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/value.h" "${distribution_DIR}/libsojsoncpp/include/json/value.h"
#
#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/reader.h" "${distribution_DIR}/libsojsoncpp/include/json/reader.h"
#
#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/writer.h" "${distribution_DIR}/libsojsoncpp/include/json/writer.h"
#
#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/assertions.h" "${distribution_DIR}/libsojsoncpp/include/json/assertions.h"
#
#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/autolink.h"  "${distribution_DIR}/libsojsoncpp/include/json/autolink.h"
#
#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/json.h"  "${distribution_DIR}/libsojsoncpp/include/json/json.h"
#
#        COMMAND "${CMAKE_COMMAND}" -E copy "${CMAKE_CURRENT_SOURCE_DIR}/src/json/version.h"  "${distribution_DIR}/libsojsoncpp/include/json/version.h"

#        COMMENT "Copying libajsoncpp to output directory")

add_custom_command(
        TARGET jsoncpp POST_BUILD
        COMMAND "${CMAKE_COMMAND}" -E copy_directory "${CMAKE_CURRENT_SOURCE_DIR}/src/json" "${export_dir}/libsojsoncpp/include/json/")