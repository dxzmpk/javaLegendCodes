package com.company.dp;

import java.util.Arrays;

public class LargestCommonSequence {

    String lcsRecursion(String X, String Y, int lastX, int lastY) {
        if (lastX == -1 || lastY == -1) {
            return "";
        }
        if (X.charAt(lastX) == Y.charAt(lastY)) {
            return lcsRecursion(X, Y, lastX - 1, lastY - 1) + X.charAt(lastX);
        }
        String z1 = lcsRecursion(X, Y, lastX - 1, lastY);
        String z2 = lcsRecursion(X, Y, lastX, lastY - 1);
        return z1.length() > z2.length() ? z1 : z2;
    }

    String lcsRecursion(String X, String Y) {
        return lcsRecursion(X, Y, X.length() - 1, Y.length() - 1);
    }

    public static void main(String[] args){
        //String res = new LargestCommonSequence().lcsRecursion("ABCBDB", "BCDB");
        String res = new LargestCommonSequence().lcsDP("ABCBDB", "BCDB");
        System.out.println("res = " + res);
    }

    String lcsDP(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];
        int[][] direction = new int[m + 1][n + 1];
        // 1 for upper left, 2 for upper, 3 for left
        int i, j;
        for (i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (j = 0; j < n; j++) {
            dp[0][j] = 0;
        }
        for (i = 1; i <= m; i++) {
            for (j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    direction[i][j] = 1;
                } else if (dp[i-1][j] >= dp[i][j-1]) {
                    dp[i][j] = dp[i-1][j];
                    direction[i][j] = 2;
                } else {
                    dp[i][j] = dp[i][j-1];
                    direction[i][j] = 3;
                }
            }
        }

        // Print LCS
        i = m;
        j = n;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (direction[i][j] == 1) {
                sb.append(X.charAt(i - 1));
                i --;
                j --;
            } else if (direction[i][j] == 2) {
                i -= 1;
            } else {
                j -= 1;
            }
        }
        return sb.reverse().toString().intern();
    }


}
