cmake_minimum_required(VERSION 3.10)
project(freetype_bindings)

# platform variable
set(TARGET_OS "windows")

# jdk headers
if(CMAKE_SYSTEM_NAME STREQUAL "Linux")
    set(JAVA_HOME "/usr/lib/jvm/java-17-openjdk")
    include_directories("${JAVA_HOME}/include/linux")
    include_directories("${JAVA_HOME}/include")

elseif(CMAKE_SYSTEM_NAME STREQUAL "Windows")
    set(JAVA_HOME "your windows java home path")
    include_directories("${JAVA_HOME}\\include\\win32")
    include_directories("${JAVA_HOME}\\include")

elseif(CMAKE_SYSTEM_NAME STREQUAL "Android")
    # android-specific include paths can be added here if needed
endif()

# find freetype lib
find_package(Freetype REQUIRED)
# add sources
file(GLOB_RECURSE SOURCE_FILES src/*.cpp)
add_library(freetype_bindings SHARED ${SOURCE_FILES})
include_directories("include")

# include headers
target_include_directories(freetype_bindings PRIVATE ${FREETYPE_INCLUDE_DIRS})
target_link_libraries(freetype_bindings PRIVATE ${FREETYPE_LIBRARIES})

# platform-specific options
if(TARGET_OS STREQUAL "linux")
    message(STATUS "Compiling for Linux")

elseif(TARGET_OS STREQUAL "windows")
    message(STATUS "Compiling for Windows")
    # ensure cmake generates a dll
    set(CMAKE_WINDOWS_EXPORT_ALL_SYMBOLS ON)

elseif(TARGET_OS STREQUAL "android")
    message(STATUS "Compiling for Android")

    set(CMAKE_TOOLCHAIN_FILE "${ANDROID_NDK}/build/cmake/android.toolchain.cmake")
    set(ANDROID_ABI "arm64-v8a")
    set(ANDROID_NATIVE_API_LEVEL 34)
    target_link_libraries(freetype_bindings PRIVATE android log)
endif()