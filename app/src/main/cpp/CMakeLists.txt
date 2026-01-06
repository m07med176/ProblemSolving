cmake_minimum_required(VERSION 3.22.1)

project("problemsolving")


#project(Testc)
#set(CMAKE_CXX_STANDARD 20)
#add_executable(Testc main.cpp)


add_library(${CMAKE_PROJECT_NAME} SHARED
        ${CMAKE_CURRENT_SOURCE_DIR}/easy/ConcatenationOfArray/ConcatenationOfArray.cpp
        ${CMAKE_CURRENT_SOURCE_DIR}/easy/SmallerNumberThanCurrent/SmallerNumbersThanCurrent.cpp
)

# Link dependencies
target_link_libraries(
        ${CMAKE_PROJECT_NAME}
        android log
)