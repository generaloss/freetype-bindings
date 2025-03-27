#include "generaloss_freetype_FreeTypeFace.h"
#include <ft2build.h>
#include FT_FREETYPE_H

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getFaceFlags (JNIEnv *, jclass, jlong facePtr) {
    return reinterpret_cast<FT_Face>(facePtr)->face_flags;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getStyleFlags (JNIEnv *, jclass, jlong facePtr) {
    return reinterpret_cast<FT_Face>(facePtr)->style_flags;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getNumGlyphs (JNIEnv *, jclass, jlong facePtr) {
    return reinterpret_cast<FT_Face>(facePtr)->num_glyphs;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getAscender (JNIEnv *, jclass, jlong facePtr) {
    return reinterpret_cast<FT_Face>(facePtr)->ascender;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getDescender (JNIEnv *, jclass, jlong facePtr) {
    return reinterpret_cast<FT_Face>(facePtr)->descender;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getHeight (JNIEnv *, jclass, jlong facePtr) {
    return reinterpret_cast<FT_Face>(facePtr)->height;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getMaxAdvanceWidth (JNIEnv *, jclass, jlong facePtr) {
    return reinterpret_cast<FT_Face>(facePtr)->max_advance_width;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getMaxAdvanceHeight (JNIEnv *, jclass, jlong facePtr) {
    return reinterpret_cast<FT_Face>(facePtr)->max_advance_height;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getUnderlinePosition (JNIEnv *, jclass, jlong facePtr) {
    return reinterpret_cast<FT_Face>(facePtr)->underline_position;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getUnderlineThickness (JNIEnv *, jclass, jlong facePtr) {
    return reinterpret_cast<FT_Face>(facePtr)->underline_thickness;
}

JNIEXPORT jboolean JNICALL Java_generaloss_freetype_FreeTypeFace_selectSize (
        JNIEnv *, jclass, jlong facePtr, jint strikeIndex) {
    return FT_Select_Size(reinterpret_cast<FT_Face>(facePtr), strikeIndex) == 0;
}

JNIEXPORT jboolean JNICALL Java_generaloss_freetype_FreeTypeFace_setCharSize (
        JNIEnv *, jclass, jlong facePtr, jint charWidth, jint charHeight, jint horzRes, jint vertRes) {
    return FT_Set_Char_Size(reinterpret_cast<FT_Face>(facePtr), charWidth, charHeight, horzRes, vertRes) == 0;
}

JNIEXPORT jboolean JNICALL Java_generaloss_freetype_FreeTypeFace_setPixelSizes (
        JNIEnv *, jclass, jlong facePtr, jint width, jint height) {
    return FT_Set_Pixel_Sizes(reinterpret_cast<FT_Face>(facePtr), width, height) == 0;
}

JNIEXPORT jboolean JNICALL Java_generaloss_freetype_FreeTypeFace_loadGlyph (
        JNIEnv *, jclass, jlong facePtr, jint glyphIndex, jint loadFlags) {
    return FT_Load_Glyph(reinterpret_cast<FT_Face>(facePtr), glyphIndex, loadFlags) == 0;
}

JNIEXPORT jboolean JNICALL Java_generaloss_freetype_FreeTypeFace_loadChar (
        JNIEnv *, jclass, jlong facePtr, jint charCode, jint loadFlags) {
    return FT_Load_Char(reinterpret_cast<FT_Face>(facePtr), charCode, loadFlags) == 0;
}

JNIEXPORT jlong JNICALL Java_generaloss_freetype_FreeTypeFace_getGlyph (JNIEnv *, jclass, jlong facePtr) {
    return reinterpret_cast<jlong>(reinterpret_cast<FT_Face>(facePtr)->glyph);
}

JNIEXPORT jlong JNICALL Java_generaloss_freetype_FreeTypeFace_getSize (JNIEnv *, jclass, jlong facePtr) {
    return reinterpret_cast<jlong>(reinterpret_cast<FT_Face>(facePtr)->size);
}

JNIEXPORT jboolean JNICALL Java_generaloss_freetype_FreeTypeFace_hasKerning (JNIEnv *, jclass, jlong facePtr) {
    return reinterpret_cast<FT_Face>(facePtr)->face_flags & FT_FACE_FLAG_KERNING;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getKerning (
        JNIEnv *env, jclass, jlong facePtr, jint leftGlyph, jint rightGlyph, jint kernMode) {
    FT_Vector kerning;
    if (FT_Get_Kerning(reinterpret_cast<FT_Face>(facePtr), leftGlyph, rightGlyph, kernMode, &kerning) != 0)
        return 0;
    return kerning.x;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getCharIndex (JNIEnv *, jclass, jlong facePtr, jint charCode) {
    return FT_Get_Char_Index(reinterpret_cast<FT_Face>(facePtr), charCode);
}

JNIEXPORT void JNICALL Java_generaloss_freetype_FreeTypeFace_doneFace (JNIEnv *, jclass, jlong facePtr) {
    FT_Done_Face(reinterpret_cast<FT_Face>(facePtr));
}
