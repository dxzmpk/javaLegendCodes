package com.company.array_questions;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.Stack;

/**
 * 找到下一个比当前数值大的数值
 * [5,3,2,4,1]
 * [-1,4,4,-1,-1]
 */
public class FindNextBigNum {
    public int[] findNextBigNum(int[] s) {
        Stack<Integer> stack = new Stack<>();
        int i;
        int[] result = new int[s.length];

        for (i = s.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && stack.peek() < s[i]) {
                stack.pop();
            }
            if (stack.size() > 0) {
                result[i] = stack.peek();
            } else {
                result[i] = -1;
            }
            stack.push(s[i]);
        }
        return result;
    }

    public static void main(String[] args){
        int[] test = new int[] {5,3,2,4, 6, 7, 8, 9, 1};
        test = new FindNextBigNum().findNextBigNum(test);
        assert test[test.length - 1] == -1;
        System.out.println(Arrays.toString(test));
        BigInteger bu = new BigInteger("321373453458426873");
        BigInteger bu2 = new BigInteger("31232145345343123");
        bu.subtract(bu2);
    }
}
