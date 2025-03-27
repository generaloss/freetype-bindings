#include "generaloss_freetype_FreeTypeSize.h"
#include <ft2build.h>
#include FT_FREETYPE_H

JNIEXPORT jlong JNICALL Java_generaloss_freetype_FreeTypeSize_getMetrics (JNIEnv *, jclass, jlong sizePtr) {
    return reinterpret_cast<jlong>(&reinterpret_cast<FT_Size>(sizePtr)->metrics);
}