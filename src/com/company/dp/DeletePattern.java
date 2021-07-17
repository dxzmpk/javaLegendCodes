package com.company.dp;

import java.util.Arrays;

public class DeletePattern {

    private static String res;
    boolean[] exist;

    void delete(String s, String pattern) {
        deletePattern(s, pattern);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exist.length; i++) {
            if (exist[i]) {
                sb.append(s.charAt(i));
            }
        }
    }

    void deletePattern(String s, String pattern) {
        exist = new boolean[s.length()];
        Arrays.fill(exist, true);
        int i;
        int count = 0;
        boolean changed = false;
        for (i = 0; i < s.length(); i++) {
            // ababac
            // abac
            if (exist[i]) {
                if (s.charAt(i) != pattern.charAt(count)) {
                    i -= count - 1;
                    count = 0;
                    if (s.charAt(i) == pattern.charAt(0)){
                        count = 1;
                    }
                } else {
                    count ++;
                }
                if (count == pattern.length()) {
                    changed = true;
                    // back fill the bool array
                    while (count > 0) {
                        count--;
                        exist[i-count] = false;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < exist.length; j++) {
            if (exist[j]) {
                sb.append(s.charAt(j));
            }
        }
        res = sb.toString();
        System.out.println("res = " + res);
        if (changed) {
            deletePattern(sb.toString(), pattern);
        }
    }

    void deletePatternKMP(String s, String pattern) {
         int[] lpt = new int[pattern.length()];
         int i;
         lpt[0] = -1;
         int fir = 0;
         for (i = 1; i < lpt.length; i++) {
             if (pattern.charAt(i) == pattern.charAt(fir)) {
                 /*
                  * ab ab ab
                  * 00 12 12
                  *
                  * p: aaabaaaab
                  *    012012330
                  *
                  *
                  * 01234
                  * aaaaa
                  * 01234
                  */
                 fir ++;
                 lpt[i] = fir - 1;
             } else {
                 if (pattern.charAt(i) == pattern.charAt(i-1)) {
                     lpt[i] = lpt[i-1];
                     fir = lpt[i] + 1;
                 } else {
                     lpt[i] = -1;
                     fir = 0;
                 }
             }
         }
         int j = -1;
         int out;
         for (out = 0; out < s.length(); out++) {
             if(s.charAt(out) == pattern.charAt(j + 1)) {
                 j += 1;
             } else {
                 while (j != -1 && s.charAt(out) != pattern.charAt(j + 1)) {
                     j = lpt[j];
                 }
                 if (pattern.charAt(j + 1) == s.charAt(out)) {
                     j += 1;
                 }
             }
             if (j == pattern.length() - 1) {
                 j = -1;
                 System.out.println("matches at pos = " +  (out - pattern.length() + 1) );
             }
         }
    }

    void KMP(String s, String pattern) {
        int i = 0, j = -1;
        int[] next = new int[pattern.length()];
        next[0] = -1;
        while(i < pattern.length()-1) {
            if(j==-1 || pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j]; // 如果s[i]!=s[j]说明匹配失败, 回到上一级公共前后缀处
            }
        }

        j = 0;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == pattern.charAt(j)) {
                j++;
                if (j == pattern.length()) {
                    System.out.println("matches at = " + (i - j + 1));
                    j -= 2;
                }
            } else {
                while (j != 0 && s.charAt(i) != pattern.charAt(j)) {
                    j = next[j];
                }
                if (s.charAt(i) == pattern.charAt(j)) {
                    j += 1;
                }
            }
        }
    }

    public int strStr(String s, String pattern) {
        int n = s.length(), m =  pattern.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 &&  pattern.charAt(i) !=  pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if ( pattern.charAt(i) ==  pattern.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) !=  pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) ==  pattern.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args){
        new DeletePattern().KMP("mississippi", "issip");
        //System.out.println("res = " + res);
    }

}

/**
 * "adcadcaddcadde"
 * "adcadde"
 */

/**
 "mississippi"
 "issip"
 **/