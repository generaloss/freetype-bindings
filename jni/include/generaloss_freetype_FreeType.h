/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class generaloss_freetype_FreeType */

#ifndef _Included_generaloss_freetype_FreeType
#define _Included_generaloss_freetype_FreeType
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     generaloss_freetype_FreeType
 * Method:    getLastErrorCode
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_generaloss_freetype_FreeType_getLastErrorCode
  (JNIEnv *, jclass);

/*
 * Class:     generaloss_freetype_FreeType
 * Method:    initFreeType
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_generaloss_freetype_FreeType_initFreeType
  (JNIEnv *, jclass);

/*
 * Class:     generaloss_freetype_FreeType
 * Method:    newMemoryFace
 * Signature: (JLjava/nio/ByteBuffer;II)J
 */
JNIEXPORT jlong JNICALL Java_generaloss_freetype_FreeType_newMemoryFace
  (JNIEnv *, jclass, jlong, jobject, jint, jint);

/*
 * Class:     generaloss_freetype_FreeType
 * Method:    strokerNew
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_generaloss_freetype_FreeType_strokerNew
  (JNIEnv *, jclass, jlong);

/*
 * Class:     generaloss_freetype_FreeType
 * Method:    doneFreeType
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_generaloss_freetype_FreeType_doneFreeType
  (JNIEnv *, jclass, jlong);

#ifdef __cplusplus
}
#endif
#endif
