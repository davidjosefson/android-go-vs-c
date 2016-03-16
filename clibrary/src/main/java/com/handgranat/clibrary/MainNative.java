package com.handgranat.clibrary;

public class MainNative {

    private static final String TAG = "MainNative";

    private native int integerMultiplication(long n);
    private native double floatMultiplication(double n);
    private native int createArray(long n);
    private native int bubbleSort(long n);

    static {
	//NOTE: this comes from the module name that we will define in our build.gradle
        System.loadLibrary("clibrary");
    }

    public MainNative() {
	//TODO implement a useful constructor
    }

    public int callIntegerMultiplication(long n) {
	    return integerMultiplication(n);
    }
    public double callFloatMultiplication(double n) {
	    return floatMultiplication(n);
    }
    public int callCreateArray(long n) {
	    return createArray(n);
    }
    public int callBubbleSort(long n) {
	    return bubbleSort(n);
    }
}
