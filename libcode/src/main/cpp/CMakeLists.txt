cmake_minimum_required(VERSION 3.4.1)

add_library(
        usecode_lib
        SHARED
        jsoncpp/json_tool.h
        jsoncpp/json_reader.cpp
        jsoncpp/json_valueiterator.inl
        jsoncpp/json_value.cpp
        jsoncpp/json_writer.cpp
        jsoncpp/version.h.in
        useCode.cpp
)


target_link_libraries(
        usecode_lib
        android
        log
)