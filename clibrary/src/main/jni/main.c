#include "main.h"

#include <errno.h>
#include <string.h>
#include <fcntl.h>
#include <malloc.h>
#include <unistd.h>
#include <stdlib.h>

double FloatRecurse(double m);

jlong Java_com_handgranat_clibrary_MainNative_integerMultiplication(JNIEnv* env, jobject thiz, jlong n) {
    long result = 0;
    long i;
    long j;

    for (i = 0; i < n; i = i + 1) {
        for (j = 0; j < n; j = j + 1) {
            result = j*(j+2) - j*(j+1) + i;
        }
    }

    return result;
}
jdouble Java_com_handgranat_clibrary_MainNative_floatMultiplication(JNIEnv* env, jobject thiz, jdouble n) {
    double result = 0;
    double i;
    double j;

    for (i = 0; i < n; i = i + 1) {
        for (j = 0; j < n; j = j + 1) {
            result = j*(j+1.123456789) - j*(j+0.987654321) + i;
        }
    }

    return result;
}

//jdouble Java_com_handgranat_clibrary_MainNative_floatFibonacci(JNIEnv* env, jobject thiz, jlong n) {
//    return FloatRecurse(n);
//}

jdouble Java_com_handgranat_clibrary_MainNative_floatPi(JNIEnv* env, jobject thiz, jint n) {
    double sum = 0.1;

    for (int i = 0; i < n; i++) {
        sum = sum + i * 0.1*0.22*0.333*0.4444*0.55555;
        sum = sum + i * 0.666666*0.7777777*0.88888888*0.999999999;
        sum = sum + i * 0.11*0.221*0.3331*0.44441*0.555551;
        sum = sum + i * 0.6666661*0.77777771*0.888888881*0.9999999991;
        sum = sum + i * 0.12*0.222*0.3332*0.44442*0.555552;
        sum = sum + i * 0.6666662*0.77777772*0.888888882*0.9999999992;
        sum = sum + i * 0.13*0.223*0.3333*0.44443*0.555553;
        sum = sum + i * 0.6666663*0.77777773*0.888888883*0.9999999993;
    }

    return sum;
}

jint Java_com_handgranat_clibrary_MainNative_createArray(JNIEnv* env, jobject thiz, jlong n) {

    long array[n];

    for (long i = 0; i < n; i++) {
        array[i] = n-i;
    }

    return array[n-1];
}

jint Java_com_handgranat_clibrary_MainNative_bubbleSort(JNIEnv* env, jobject thiz, jlong n) {

    long array[n];

    for (long i = 0; i < n; i++) {
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
//jint Java_com_handgranat_clibrary_MainNative_memoryAllocation(JNIEnv* env, jobject thiz, jlong n) {
//    long size = 4000*n;
////    char *description = calloc(size , sizeof *description);
////    description[9]=8;
////    int length = sizeof(description[2]);
//////    free(description);
////    int *p = (int*) malloc(size * sizeof *p);
////    memset(p, 1, size);
//
//
//
//    char array[size];
//
//    for (long i = 0; i < n; ++i) {
//        array[i] = 127;
//    }
//
////    if(p) {return p[10];}
//
//    return array[n-1];
//
////    exit(0);
//
////    return ((size_t *)p)[-1];
////    return 1;
//}



//long IntegerRecurse(long m){
//    if(m < 2){
//        return 1;
//    } else {
//        return IntegerRecurse(m-1) * IntegerRecurse(m-2);
//    }
//}

double FloatRecurse(double m){
//    if(m < 2.123456789){
//        return 1;
//    } else {
//        return FloatRecurse(m-1.123456789) * FloatRecurse(m-2.123456789);
//    }
    if(m < 2.0){
        return 1.0;
    } else {
        return (0.987654321 * FloatRecurse(m-1.0));
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

