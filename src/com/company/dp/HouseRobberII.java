package com.company.dp;

import java.util.Arrays;

/**
 * 213. 打家劫舍 II
 */
public class HouseRobberII {
    /**
     [1,2,3,9,6,1,2]
     **/
    public int rob(int[] nums) {
        boolean stoleFirst = true;
        int[] dp = new int[nums.length];
        if (nums.length <= 2) {
            Arrays.sort(nums);
            return nums[nums.length-1];
        }
        int i;
        int curMax = Integer.MIN_VALUE;
        int j;
        for (j = 0; j < 2; j++) {
            if (stoleFirst) {
                dp[0] = nums[0];
                dp[1] = nums[0];
                if (nums.length == 3) {
                    dp[2] = nums[0];
                } else {
                    dp[2] = nums[0] + nums[2];
                }
            } else {
                dp[0] = 0;
                dp[1] = nums[1];
                dp[2] = Math.max(nums[1], nums[2]);
            }
            for (i = 3; i < nums.length; i++) {
                // last can't be chosen
                if (i == nums.length - 1 && stoleFirst) {
                    dp[i] = dp[i-1];
                    break;
                }
                dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
            }
            if (curMax < dp[nums.length-1]) {
                curMax = dp[nums.length-1];
            }
            stoleFirst = false;
        }

        return curMax;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{200,3,140,20,10};
        System.out.println("res = " + new HouseRobberII().rob(nums));
    }
}
