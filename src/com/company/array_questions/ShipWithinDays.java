package com.company.array_questions;

import java.util.Arrays;

public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int D) {
        int sum = Arrays.stream(weights).sum();
        int min = Arrays.stream(weights).min().getAsInt();
        int max = sum;
        int mid = 0;
        while (min < max) {
            mid = min + (max - min) / 2;
            if (possible(weights, mid, D)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return max;
    }

    boolean possible(int[] weights, int capacity, int D) {
        // 尽可能装更多
        int curWeight = 0;
        int curD = 1;
        for (int weight : weights) {
            // 不允许大于capacity的货物出现
            if (weight > capacity) {
                return false;
            }
            // 若小于等于容量
            if (curWeight + weight <= capacity) {
                curWeight += weight;
            } else {
                // 否则放在新桶里，判断桶数是否超量
                curWeight = weight;
                curD ++;
                if (curD > D) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        int res = new ShipWithinDays().shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5);
        System.out.println("res = " + res);
    }
}
