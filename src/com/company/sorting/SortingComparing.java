package com.company.sorting;

import com.company.time.Runner;
import com.company.time.TimeEvaluater;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SortingComparing {
    public static void main(String[] args){
        TimeEvaluater evaluater = new TimeEvaluater();
        Random random = new Random(1);
        int i;
        final int TEST_SIZE = (int) 300;

        int[] first = new int[150];
        int[] second = new int[150];
        for (i = 0; i < 150; i++) {
            first[i] = random.nextInt(200);
            second[i] = random.nextInt(200);
        }
        Arrays.sort(first);
        Arrays.sort(second);

        int[] quickArray = new int[TEST_SIZE];

        for (i = 0; i < TEST_SIZE; i++) {
            if (i < 150) {
                quickArray[i] = first[i];
            } else {
                quickArray[i] = second[i - 150];
            }
        }

        // clone the arrays
        int[] mergeArray = quickArray.clone();
        int[] systemArray = quickArray.clone();

        evaluater.testAndPrint(new Runner() {
            @Override
            public void run() {
                Arrays.sort(systemArray);
            }
        }, "System");

        evaluater.testAndPrint(new Runner() {
            @Override
            public void run() {
                new MergeSort().mergesort(mergeArray, 0, TEST_SIZE-1);
            }
        }, "MergeSort");

        evaluater.testAndPrint(new Runner() {
            @Override
            public void run() {
                new QuickSort().quickSort(quickArray, 0, TEST_SIZE-1);
            }
        }, "QuickSort");
    }
}
