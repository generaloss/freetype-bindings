/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class generaloss_freetype_FreeTypeFace */

#ifndef _Included_generaloss_freetype_FreeTypeFace
#define _Included_generaloss_freetype_FreeTypeFace
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    getFaceFlags
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getFaceFlags
  (JNIEnv *, jclass, jlong);

/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    getStyleFlags
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getStyleFlags
  (JNIEnv *, jclass, jlong);

/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    getNumGlyphs
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getNumGlyphs
  (JNIEnv *, jclass, jlong);

/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    getAscender
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getAscender
  (JNIEnv *, jclass, jlong);

/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    getDescender
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getDescender
  (JNIEnv *, jclass, jlong);

/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    getHeight
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getHeight
  (JNIEnv *, jclass, jlong);

/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    getMaxAdvanceWidth
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getMaxAdvanceWidth
  (JNIEnv *, jclass, jlong);

/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    getMaxAdvanceHeight
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getMaxAdvanceHeight
  (JNIEnv *, jclass, jlong);

/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    getUnderlinePosition
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getUnderlinePosition
  (JNIEnv *, jclass, jlong);

/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    getUnderlineThickness
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getUnderlineThickness
  (JNIEnv *, jclass, jlong);

/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    selectSize
 * Signature: (JI)Z
 */
JNIEXPORT jboolean JNICALL Java_generaloss_freetype_FreeTypeFace_selectSize
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    setCharSize
 * Signature: (JIIII)Z
 */
JNIEXPORT jboolean JNICALL Java_generaloss_freetype_FreeTypeFace_setCharSize
  (JNIEnv *, jclass, jlong, jint, jint, jint, jint);

/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    setPixelSizes
 * Signature: (JII)Z
 */
JNIEXPORT jboolean JNICALL Java_generaloss_freetype_FreeTypeFace_setPixelSizes
  (JNIEnv *, jclass, jlong, jint, jint);

/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    loadGlyph
 * Signature: (JII)Z
 */
JNIEXPORT jboolean JNICALL Java_generaloss_freetype_FreeTypeFace_loadGlyph
  (JNIEnv *, jclass, jlong, jint, jint);

/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    loadChar
 * Signature: (JII)Z
 */
JNIEXPORT jboolean JNICALL Java_generaloss_freetype_FreeTypeFace_loadChar
  (JNIEnv *, jclass, jlong, jint, jint);

/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    getGlyph
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_generaloss_freetype_FreeTypeFace_getGlyph
  (JNIEnv *, jclass, jlong);

/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    getSize
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_generaloss_freetype_FreeTypeFace_getSize
  (JNIEnv *, jclass, jlong);

/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    hasKerning
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_generaloss_freetype_FreeTypeFace_hasKerning
  (JNIEnv *, jclass, jlong);

/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    getKerning
 * Signature: (JIII)I
 */
JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getKerning
  (JNIEnv *, jclass, jlong, jint, jint, jint);

/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    getCharIndex
 * Signature: (JI)I
 */
JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeTypeFace_getCharIndex
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     generaloss_freetype_FreeTypeFace
 * Method:    doneFace
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_generaloss_freetype_FreeTypeFace_doneFace
  (JNIEnv *, jclass, jlong);

#ifdef __cplusplus
}
#endif
#endif
