package com.company.array_questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class DuplicateNums {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        long[][] newNums = new long[n][2];
        int i;
        for (i = 0; i < n; i++){
            newNums[i][0] = nums[i];
            newNums[i][1] = i;
        }
        Arrays.sort(newNums, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[0] - o2[0] > 0) {
                    return 1;
                } else if (o1[0] - o2[0] < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        for (i = 1; i < n; i++) {
            long diff = newNums[i][0] - newNums[i-1][0];
            if (diff <= t) {
                long indexDiff = Math.abs(newNums[i][1] - newNums[i-1][1]);
                if (indexDiff <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }


    public static void main(String[] args){
        boolean res = new DuplicateNums().containsNearbyAlmostDuplicate(new int[]{-2147483648,2147483647}, 1, 1);
        System.out.println("res = " + res);
    }
}
