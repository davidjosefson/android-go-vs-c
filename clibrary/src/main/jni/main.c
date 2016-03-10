#include "main.h"

#include <errno.h>
#include <string.h>
#include <fcntl.h>
#include <malloc.h>
#include <unistd.h>

long Recurse(long m);

jint Java_com_handgranat_clibrary_MainNative_integerFibonacci(JNIEnv* env, jobject thiz, jlong n) {
    return Recurse(n);
}

jint Java_com_handgranat_clibrary_MainNative_createArray(JNIEnv* env, jobject thiz, jlong n) {

    long array[n];

    for (long i = 0; i < n; ++i) {
        array[i] = n-i;
    }

    return array[0];
}

jint Java_com_handgranat_clibrary_MainNative_bubbleSort(JNIEnv* env, jobject thiz, jlong n) {

    long array[n];

    for (long i = 0; i < n; ++i) {
        array[i] = n-i;
    }

    long temp = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 1; j < (n - i); j++) {
            if (array[j-1] > array[j]) {
                temp = array[j-1];
                array[j-1] = array[j];
                array[j] = temp;
            }
        }
    }
    return array[0];
}
jint Java_com_handgranat_clibrary_MainNative_memoryAllocation(JNIEnv* env, jobject thiz, jlong n) {
    long size = 4000*n;
//    char *description = calloc(size , sizeof *description);
//    description[9]=8;
//    int length = sizeof(description[2]);
////    free(description);
    return 1;
}

long Recurse(long m){
    if(m < 2){
        return 1;
    } else {
        return Recurse(m-1) * Recurse(m-2);
    }
}

// Required for the default JNI implementation
jint JNI_OnLoad(JavaVM* vm, void* reserved) {
    return JNI_VERSION_1_6;
}



//const char* dev_name = (*env)->GetStringUTFChars(env, deviceName, 0);
//(*env)->ReleaseStringUTFChars(env, deviceName, dev_name);

//    result := 0
//
//    for  i := 0; i < n; i++ {
//        result += n*i;
//    }
//
//    return result

//    int result;
//    int i;
//
//    for (i = 0; i < n; i = i + 1) {
//        result = n * i;
//    }
//
//    return result;

//    long result = 0;
//    long i;
//    long j;
//
//    for (i = 0; i < n; i = i + 1) {
//        for (j = 0; j < n; j = j + 1) {
////            result = j*1*2*3*4*5*6;
//            result = (j*1*2*3*4*5*6)+i;
//        }
//    }
//    return result;
//}

