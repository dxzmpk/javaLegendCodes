package com.company.array_questions;

public class MountainArray {

    // [0,2,1,0]
    public int peakIndexInMountainArray(int[] arr) {
        // arr: 山脉数组
        int i;
        int beforeIndex = 0;
        boolean isFront = true;
        for (i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                return i - 1;
            }
        }
        return i - 1;
    }

}
