package com.company.dp;


//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/decode-ways/solution/jie-ma-fang-fa-by-leetcode-solution-p8np/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public class NumDecodings {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        boolean[] canUse = new boolean[s.length()];
        if (s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        canUse[0] = true;
        int i;
        for (i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i-1) != '1' && s.charAt(i-1) != '2') {
                    return 0;
                } else {
                    canUse[i] = false;
                    canUse[i-1] = false;
                }
            } else {
                canUse[i] = true;
            }
        }
        // dp[i] : 0-i的字符含有的编码种类
        dp[0] = 1;
        if (!canUse[0] || !canUse[1]) {
            dp[1] = 1;
        } else {
            if (s.charAt(0) == '1') {
                dp[1] = 2;
            } else if (s.charAt(0) == '2' && s.charAt(1) < '7') {
                dp[1] = 2;
            } else {
                dp[1] = 1;
            }
        }

        for (i = 2; i < s.length(); i++) {
            if (canUse[i-1] && canUse[i]) {
                if ((s.charAt(i) < '7' && s.charAt(i-1) == '2') || (s.charAt(i-1) == '1')) {
                    dp[i] = dp[i-1] + dp[i-2];
                } else {
                    dp[i] = dp[i-1];
                }
            } else {
                dp[i] = dp[i-1];
            }

        }
        return dp[s.length()-1];
    }

    public int numDecodings2(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] = f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }




    public static void main(String[] args){
        //int res = new NumDecodings().numDecodings("2611055971756562");
        //int res = new NumDecodings().numDecodings("226");
        int res = new NumDecodings().numDecodings("1201234");
        System.out.println("res = " + res);

    }
}
