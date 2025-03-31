#include "FTGlyphSlot.h"
#include <ft2build.h>
#include FT_FREETYPE_H
#include FT_GLYPH_H

JNIEXPORT jlong JNICALL Java_generaloss_freetype_glyph_FTGlyphSlot_getMetrics (JNIEnv *, jclass, jlong slotPtr) {
    return reinterpret_cast<jlong>(&reinterpret_cast<FT_GlyphSlot>(slotPtr)->metrics);
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_glyph_FTGlyphSlot_getLinearHoriAdvance (JNIEnv *, jclass, jlong slotPtr) {
    return reinterpret_cast<FT_GlyphSlot>(slotPtr)->linearHoriAdvance;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_glyph_FTGlyphSlot_getLinearVertAdvance (JNIEnv *, jclass, jlong slotPtr) {
    return reinterpret_cast<FT_GlyphSlot>(slotPtr)->linearVertAdvance;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_glyph_FTGlyphSlot_getAdvanceX (JNIEnv *, jclass, jlong slotPtr) {
    return reinterpret_cast<FT_GlyphSlot>(slotPtr)->advance.x;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_glyph_FTGlyphSlot_getAdvanceY (JNIEnv *, jclass, jlong slotPtr) {
    return reinterpret_cast<FT_GlyphSlot>(slotPtr)->advance.y;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_glyph_FTGlyphSlot_getFormat (JNIEnv *, jclass, jlong slotPtr) {
    return reinterpret_cast<FT_GlyphSlot>(slotPtr)->format;
}

JNIEXPORT jlong JNICALL Java_generaloss_freetype_glyph_FTGlyphSlot_getBitmap (JNIEnv *, jclass, jlong slotPtr) {
    return reinterpret_cast<jlong>(&reinterpret_cast<FT_GlyphSlot>(slotPtr)->bitmap);
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_glyph_FTGlyphSlot_getBitmapLeft (JNIEnv *, jclass, jlong slotPtr) {
    return reinterpret_cast<FT_GlyphSlot>(slotPtr)->bitmap_left;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_glyph_FTGlyphSlot_getBitmapTop (JNIEnv *, jclass, jlong slotPtr) {
    return reinterpret_cast<FT_GlyphSlot>(slotPtr)->bitmap_top;
}

JNIEXPORT jboolean JNICALL Java_generaloss_freetype_glyph_FTGlyphSlot_renderGlyph (
        JNIEnv *, jclass, jlong slotPtr, jint mode) {
    return FT_Render_Glyph(reinterpret_cast<FT_GlyphSlot>(slotPtr), static_cast<FT_Render_Mode>(mode)) == 0;
}

JNIEXPORT jlong JNICALL Java_generaloss_freetype_glyph_FTGlyphSlot_getGlyph (JNIEnv *, jclass, jlong slotPtr) {
    FT_Glyph glyph;
    if(FT_Get_Glyph(reinterpret_cast<FT_GlyphSlot>(slotPtr), &glyph) == 0)
        return reinterpret_cast<jlong>(glyph);
    return 0;
}
