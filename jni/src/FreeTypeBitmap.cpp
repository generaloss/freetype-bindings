#include "FreeTypeBitmap.h"
#include <ft2build.h>
#include FT_FREETYPE_H

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeBitmap_getRows (JNIEnv *, jclass, jlong bitmapPtr) {
    return reinterpret_cast<FT_Bitmap*>(bitmapPtr)->rows;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeBitmap_getWidth (JNIEnv *, jclass, jlong bitmapPtr) {
    return reinterpret_cast<FT_Bitmap*>(bitmapPtr)->width;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeBitmap_getPitch (JNIEnv *, jclass, jlong bitmapPtr) {
    return reinterpret_cast<FT_Bitmap*>(bitmapPtr)->pitch;
}

JNIEXPORT jobject JNICALL Java_generaloss_freetype_FreeTypeBitmap_getBuffer (JNIEnv *env, jclass, jlong bitmapPtr) {
    FT_Bitmap* bitmap = reinterpret_cast<FT_Bitmap*>(bitmapPtr);
    return env->NewDirectByteBuffer(bitmap->buffer, bitmap->rows * bitmap->pitch);
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeBitmap_getNumGray (JNIEnv *, jclass, jlong bitmapPtr) {
    return reinterpret_cast<FT_Bitmap*>(bitmapPtr)->num_grays;
}

JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeBitmap_getPixelMode (JNIEnv *, jclass, jlong bitmapPtr) {
    return reinterpret_cast<FT_Bitmap*>(bitmapPtr)->pixel_mode;
}
