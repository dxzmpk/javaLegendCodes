package com.company.math;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UglyNum {
    public int nthUglyNumber(int n) {
        int[] factors = {2,3,5};
        Set<Integer> seen = new HashSet<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        seen.add(1);
        heap.offer(1);
        int ugly = 0;
        for (int i = 0; i < n; i ++) {
            ugly = heap.poll();
            for (int factor : factors) {
                int next = ugly * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
    public static void main(String[] args){
        System.out.println(new UglyNum().nthUglyNumber(1407));
    }
}
