#include "FTGlyphMetrics.h"
#include <ft2build.h>
#include FT_FREETYPE_H

JNIEXPORT jint JNICALL Java_generaloss_freetype_FTGlyphMetrics_getWidth (JNIEnv *, jclass, jlong metricsPtr) {
    return reinterpret_cast<FT_Glyph_Metrics*>(metricsPtr)->width;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FTGlyphMetrics_getHeight (JNIEnv *, jclass, jlong metricsPtr) {
    return reinterpret_cast<FT_Glyph_Metrics*>(metricsPtr)->height;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FTGlyphMetrics_getHoriBearingX (JNIEnv *, jclass, jlong metricsPtr) {
    return reinterpret_cast<FT_Glyph_Metrics*>(metricsPtr)->horiBearingX;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FTGlyphMetrics_getHoriBearingY (JNIEnv *, jclass, jlong metricsPtr) {
    return reinterpret_cast<FT_Glyph_Metrics*>(metricsPtr)->horiBearingY;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FTGlyphMetrics_getHoriAdvance (JNIEnv *, jclass, jlong metricsPtr) {
    return reinterpret_cast<FT_Glyph_Metrics*>(metricsPtr)->horiAdvance;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FTGlyphMetrics_getVertBearingX (JNIEnv *, jclass, jlong metricsPtr) {
    FT_Glyph_Metrics* metrics = reinterpret_cast<FT_Glyph_Metrics*>(metricsPtr);
    return static_cast<jint>(metrics->vertBearingX);
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FTGlyphMetrics_getVertBearingY (JNIEnv *, jclass, jlong metricsPtr) {
    FT_Glyph_Metrics* metrics = reinterpret_cast<FT_Glyph_Metrics*>(metricsPtr);
    return static_cast<jint>(metrics->vertBearingY);
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FTGlyphMetrics_getVertAdvance (JNIEnv *, jclass, jlong metricsPtr) {
    FT_Glyph_Metrics* metrics = reinterpret_cast<FT_Glyph_Metrics*>(metricsPtr);
    return static_cast<jint>(metrics->vertAdvance);
}
