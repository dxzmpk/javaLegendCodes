package com.company.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestIncreaseSubSequence {
    int longest(int[] s) {
        int[] dp = new int[s.length];
        int i;
        if (s.length < 1) {
            return 0;
        }
        HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
        for (int k = 0; k < s.length; k++) {
            hashMap.put(k, new ArrayList<>());
        }
        hashMap.put(0, new ArrayList<Integer>(){{add(0);}});
        dp[0] = 1;
        int res = 0;
        for (i = 1; i < s.length; i++) {
            int maxLen = 1;
            int maxIndex = -1;
            for (int j = 0; j < i; j++) {
                if (s[j] < s[i]) {
                    if (dp[j] + 1 > maxLen) {
                        maxLen = dp[j] + 1;
                        maxIndex = j;
                    }
                }
            }
            dp[i] = maxLen;
            if (maxIndex >= 0) {
                hashMap.get(i).addAll(hashMap.get(maxIndex));
            }
            hashMap.get(i).add(i);
            if (dp[i] > hashMap.get(res).size()) res = i;
        }
        for (int index : hashMap.get(res)) {
            System.out.print(s[index] + " ");
        }
        System.out.println();
        System.out.println("long increasing sub sequence = " + hashMap.get(res).toString());
        return hashMap.get(res).size();
    }
    
    public static void main(String[] args){
        int res = new LongestIncreaseSubSequence().longest(new int[] {10,9,2,5,3,7,101,18});
        //int res = new LongestIncreaseSubSequence().longest(new int[1]);
        System.out.println("res = " + res);
    }
}
