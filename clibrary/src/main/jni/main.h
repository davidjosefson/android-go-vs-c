#ifndef __MAIN_H__
#define __MAIN_H__

#include <jni.h>
#include <android/log.h>

// underscores are reserved characters in JNI referring to package boundaries.  
// stick with camelCase moduleNames, classNames and methodNames

jint Java_com_handgranat_clibrary_MainNative_callWithArguments(JNIEnv* env, jobject thiz, jlong n);

#endif // __MAIN_H__
