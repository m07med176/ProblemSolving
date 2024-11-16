cmake_minimum_required(VERSION 3.22.1)

#project("problemsolving")
#add_library(${CMAKE_PROJECT_NAME} SHARED native-lib.cpp)
#target_link_libraries(${CMAKE_PROJECT_NAME} android log)

add_library(native-lib SHARED native-lib.cpp)
target_link_libraries(native-lib ${log-lib})