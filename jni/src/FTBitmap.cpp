#include "FTBitmap.h"
#include <ft2build.h>
#include FT_FREETYPE_H

JNIEXPORT jint JNICALL Java_generaloss_freetype_bitmap_FTBitmap_getRows (JNIEnv *, jclass, jlong bitmapPtr) {
    return reinterpret_cast<FT_Bitmap*>(bitmapPtr)->rows;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_bitmap_FTBitmap_getWidth (JNIEnv *, jclass, jlong bitmapPtr) {
    return reinterpret_cast<FT_Bitmap*>(bitmapPtr)->width;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_bitmap_FTBitmap_getPitch (JNIEnv *, jclass, jlong bitmapPtr) {
    return reinterpret_cast<FT_Bitmap*>(bitmapPtr)->pitch;
}

JNIEXPORT jobject JNICALL Java_generaloss_freetype_bitmap_FTBitmap_getBuffer (JNIEnv *env, jclass, jlong bitmapPtr) {
    FT_Bitmap* bitmap = reinterpret_cast<FT_Bitmap*>(bitmapPtr);
    return env->NewDirectByteBuffer(bitmap->buffer, bitmap->rows * bitmap->pitch);
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_bitmap_FTBitmap_getNumGray (JNIEnv *, jclass, jlong bitmapPtr) {
    return reinterpret_cast<FT_Bitmap*>(bitmapPtr)->num_grays;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_bitmap_FTBitmap_getPixelMode (JNIEnv *, jclass, jlong bitmapPtr) {
    return reinterpret_cast<FT_Bitmap*>(bitmapPtr)->pixel_mode;
}
