#include "generaloss_freetype_FreeTypeGlyph.h"
#include <ft2build.h>
#include FT_FREETYPE_H
#include FT_GLYPH_H
#include FT_OUTLINE_H
#include FT_STROKER_H

JNIEXPORT jlong JNICALL Java_generaloss_freetype_FreeTypeGlyph_strokeBorder (
        JNIEnv *, jclass, jlong glyphPtr, jlong strokerPtr, jboolean inside) {

    FT_Glyph glyph = reinterpret_cast<FT_Glyph>(glyphPtr);
    FT_Stroker stroker = reinterpret_cast<FT_Stroker>(strokerPtr);

    FT_Glyph newGlyph;
    if(FT_Glyph_Copy(glyph, &newGlyph) != 0)
        return 0;

    if(FT_Glyph_StrokeBorder(&newGlyph, stroker, inside, 1) != 0){
        FT_Done_Glyph(newGlyph);
        return 0;
    }

    return reinterpret_cast<jlong>(newGlyph);
}

JNIEXPORT jlong JNICALL Java_generaloss_freetype_FreeTypeGlyph_toBitmap (JNIEnv *, jclass, jlong glyphPtr, jint mode) {
    FT_Glyph glyph = reinterpret_cast<FT_Glyph>(glyphPtr);
    if(FT_Glyph_To_Bitmap(&glyph, static_cast<FT_Render_Mode>(mode), nullptr, 1) == 0)
        return reinterpret_cast<jlong>(glyph);
    return 0;
}

JNIEXPORT jlong JNICALL Java_generaloss_freetype_FreeTypeGlyph_getBitmap (JNIEnv *, jclass, jlong glyphPtr) {
    return reinterpret_cast<jlong>(&reinterpret_cast<FT_BitmapGlyph>(glyphPtr)->bitmap);
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeGlyph_getLeft (JNIEnv *, jclass, jlong glyphPtr) {
    return reinterpret_cast<FT_BitmapGlyph>(glyphPtr)->left;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeGlyph_getTop (JNIEnv *, jclass, jlong glyphPtr) {
    return reinterpret_cast<FT_BitmapGlyph>(glyphPtr)->top;
}

JNIEXPORT void JNICALL Java_generaloss_freetype_FreeTypeGlyph_done (JNIEnv *, jclass, jlong glyphPtr) {
    FT_Done_Glyph(reinterpret_cast<FT_Glyph>(glyphPtr));
}
