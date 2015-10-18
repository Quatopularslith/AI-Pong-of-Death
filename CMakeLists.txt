cmake_minimum_required(VERSION 3.3)
project(cpp)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES
        core/Main.h
        core/Main.cpp

        graphics/Box.h
        graphics/Box.cpp

        input/Input.h
        input/Input.cpp

        physics/Physics.h
        physics/Physics.cpp

        graphics/Render.h
        graphics/Render.cpp
)
add_executable(cpp ${SOURCE_FILES})

add_subdirectory(libraries/glfw)
include_directories(libraries/glfw/include)
target_link_libraries(cpp glfw ${GLFW_LIBRARIES})