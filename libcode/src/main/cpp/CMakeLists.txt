cmake_minimum_required(VERSION 3.4.1)

add_library(
        usecode_lib
        SHARED
        moudle/jsoncpp/json_tool.h
        moudle/jsoncpp/json_reader.cpp
        moudle/jsoncpp/json_valueiterator.inl
        moudle/jsoncpp/json_value.cpp
        moudle/jsoncpp/json_writer.cpp
        moudle/jsoncpp/version.h.in
        share/useCode.cpp
)

target_include_directories(usecode_lib PRIVATE
        src/main/cpp/moudle/jsoncpp/json)

target_link_libraries(
        usecode_lib
        android
        log
)