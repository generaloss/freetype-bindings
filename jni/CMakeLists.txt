cmake_minimum_required(VERSION 3.10)
project(freetype_bindings)

# platform variable
set(TARGET_OS "windows")

# jdk headers
set(JAVA_HOME "/usr/lib/jvm/java-17-openjdk")
include_directories("${JAVA_HOME}/include")

if(CMAKE_SYSTEM_NAME STREQUAL "Linux")
    include_directories("${JAVA_HOME}/include/linux")
elseif(CMAKE_SYSTEM_NAME STREQUAL "Windows")
    include_directories("${JAVA_HOME}/include/win32")
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

    if(MINGW)
        message(STATUS "Building with mingw-w64")
        # setup toolchain-mingw64.cmake
        set(CMAKE_SYSTEM_NAME Windows)
        set(CMAKE_SYSTEM_PROCESSOR x86_64)
        # specify the cross compiler
        set(CMAKE_C_COMPILER x86_64-w64-mingw32-gcc)
        set(CMAKE_CXX_COMPILER x86_64-w64-mingw32-g++)
        set(CMAKE_RC_COMPILER x86_64-w64-mingw32-windres)
        # where is the target environment
        set(CMAKE_FIND_ROOT_PATH /usr/x86_64-w64-mingw32)
        # search for programs in the build host directories
        set(CMAKE_FIND_ROOT_PATH_MODE_PROGRAM NEVER)
        # for libraries and headers in the target directories
        set(CMAKE_FIND_ROOT_PATH_MODE_LIBRARY ONLY)
        set(CMAKE_FIND_ROOT_PATH_MODE_INCLUDE ONLY)
    endif()

elseif(TARGET_OS STREQUAL "android")
    message(STATUS "Compiling for Android")

    set(CMAKE_TOOLCHAIN_FILE "${ANDROID_NDK}/build/cmake/android.toolchain.cmake")
    set(ANDROID_ABI "arm64-v8a")
    set(ANDROID_NATIVE_API_LEVEL 34)
    target_link_libraries(freetype_bindings PRIVATE android log)
endif()