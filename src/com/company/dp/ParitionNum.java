package com.company.dp;

public class ParitionNum {

    int paritionNum(int n) {
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = dp[1][i] = dp[0][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                if (j <= i) {
                    dp[i][j] = dp[i][j-1] + dp[i-j][j];
                } else {
                    dp[i][j] = dp[i][i];
                }
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args){
        int res = new ParitionNum().paritionNum(5);
        System.out.println("res = " + res);
    }
}
