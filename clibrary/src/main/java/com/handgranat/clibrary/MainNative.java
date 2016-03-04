package com.handgranat.clibrary;

public class MainNative {

    private static final String TAG = "MainNative";

    private native int callWithArguments(long n);
 
    static {
	//NOTE: this comes from the module name that we will define in our build.gradle
        System.loadLibrary("clibrary");
    }

    public MainNative() {
	//TODO implement a useful constructor
    }

    public int callNativeMethod(long n) {
	    return callWithArguments(n);
    }
}
