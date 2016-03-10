package com.handgranat.clibrary;

public class MainNative {

    private static final String TAG = "MainNative";

    private native int integerFibonacci(long n);
    private native int createArray(long n);
    private native int bubbleSort(long n);
    private native int memoryAllocation(long n);

    static {
	//NOTE: this comes from the module name that we will define in our build.gradle
        System.loadLibrary("clibrary");
    }

    public MainNative() {
	//TODO implement a useful constructor
    }

    public int callIntegerFibonacci(long n) {
	    return integerFibonacci(n);
    }
    public int callCreateArray(long n) {
	    return createArray(n);
    }
    public int callBubbleSort(long n) {
	    return bubbleSort(n);
    }
    public int callMemoryAllocation(long n) {
	    return memoryAllocation(n);
    }
}
