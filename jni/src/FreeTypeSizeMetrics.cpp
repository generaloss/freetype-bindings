#include "FreeTypeSizeMetrics.h"
#include <ft2build.h>
#include FT_FREETYPE_H

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeSizeMetrics_getXppem (JNIEnv *, jclass, jlong metricsPtr) {
    return reinterpret_cast<FT_Size_Metrics*>(metricsPtr)->x_ppem;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeSizeMetrics_getYppem (JNIEnv *, jclass, jlong metricsPtr) {
    return reinterpret_cast<FT_Size_Metrics*>(metricsPtr)->y_ppem;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeSizeMetrics_getXscale (JNIEnv *, jclass, jlong metricsPtr) {
    return reinterpret_cast<FT_Size_Metrics*>(metricsPtr)->x_scale;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeSizeMetrics_getYscale (JNIEnv *, jclass, jlong metricsPtr) {
    return reinterpret_cast<FT_Size_Metrics*>(metricsPtr)->y_scale;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeSizeMetrics_getAscender (JNIEnv *, jclass, jlong metricsPtr) {
    return reinterpret_cast<FT_Size_Metrics*>(metricsPtr)->ascender;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeSizeMetrics_getDescender (JNIEnv *, jclass, jlong metricsPtr) {
    return reinterpret_cast<FT_Size_Metrics*>(metricsPtr)->descender;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeSizeMetrics_getHeight (JNIEnv *, jclass, jlong metricsPtr) {
    return reinterpret_cast<FT_Size_Metrics*>(metricsPtr)->height;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeSizeMetrics_getMaxAdvance (JNIEnv *, jclass, jlong metricsPtr) {
    return reinterpret_cast<FT_Size_Metrics*>(metricsPtr)->max_advance;
}
