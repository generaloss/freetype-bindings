cmake_minimum_required(VERSION 3.10)
project(freetype_jni)

# jdk headers
set(JAVA_HOME "/usr/lib/jvm/java-8-openjdk") # for windows: set(JAVA_HOME "C:/Program Files/Java/jdk-8")
include_directories("${JAVA_HOME}/include/linux" "${JAVA_HOME}/include") # for windows: include_directories("${JAVA_HOME}/include/win32" "${JAVA_HOME}/include")

# sources
file(GLOB_RECURSE SOURCE_FILES src/*.*)
include_directories("include")

# library
add_library(freetype_jni SHARED ${SOURCE_FILES})

# freetype
target_include_directories(freetype_jni PRIVATE ${CMAKE_SOURCE_DIR}/freetype/include)

set(FREETYPE_LIB "${CMAKE_SOURCE_DIR}/freetype/lib/${TARGET_PLATFORM}/${TARGET_ARCH}/libfreetype.a")
if(NOT EXISTS "${FREETYPE_LIB}")
    message(FATAL_ERROR "libfreetype.a not found for current platform/arch: ${FREETYPE_LIB}")
endif()

add_library(freetype STATIC IMPORTED GLOBAL)
set_target_properties(freetype PROPERTIES IMPORTED_LOCATION "${FREETYPE_LIB}")

target_link_libraries(freetype_jni PRIVATE freetype)

# library
if(TARGET_PLATFORM STREQUAL "android")
    message(STATUS "Configuring for Android")

    target_link_libraries(freetype_jni PRIVATE z android log)
    set_target_properties(freetype_jni PROPERTIES SUFFIX ".so")

elseif(TARGET_PLATFORM STREQUAL "windows")
    message(STATUS "Configuring for Windows")
    set(CMAKE_WINDOWS_EXPORT_ALL_SYMBOLS ON)
    set_target_properties(freetype_jni PROPERTIES
        SUFFIX ".dll"
        PREFIX ""
        IMPORT_PREFIX ""
    )
    target_link_options(freetype_jni PRIVATE -static -static-libgcc -static-libstdc++)

else()
    message(STATUS "Configuring for Linux")
    target_compile_options(freetype_jni PRIVATE -fPIC)
    set_target_properties(freetype_jni PROPERTIES SUFFIX ".so")
endif()