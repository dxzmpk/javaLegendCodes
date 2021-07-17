package com.company.dp;

public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int res = 0;
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                res += combinationSum4(nums, target - nums[i]);
            }
        }
        return res;
    }

    public int combinationSum2(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
    
    public static void main(String[] args){
        int res1 = new CombinationSum4().combinationSum2(new int[]{1,2,3,4}, 35);
        System.out.println("res1 = " + res1);
        int res2 = new CombinationSum4().combinationSum4(new int[]{1,2,3,4}, 35);
        System.out.println("res2 = " + res2);
    }
}
