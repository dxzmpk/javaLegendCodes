package com.company.collections;

import com.company.time.Runner;
import com.company.time.TimeEvaluater;

import java.util.*;

/**
 * 179.最大数
 */
public class LargestNum {

    /**
     * dp[i][j] : 使用前i个数字，
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {

        PriorityQueue<String> heap = new PriorityQueue<>((x, y) -> (y + x).compareTo(x + y));
        for(int x: nums) heap.offer(String.valueOf(x));
        String res = "";
        while(heap.size() > 0) res += heap.poll();
        if(res.charAt(0) == '0') return "0";

        return res;
    }

    public String largestNumber2(int[] nums) {

        List<String> strings = new ArrayList<>();
        for (int x : nums) strings.add(String.valueOf(x));
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder res = new StringBuilder();
        for (String s : strings) res.append(s);
        if(res.charAt(0) == '0') return "0";
        return strings.toString();
    }

    public String largestNumberFinal(int[] nums) {

        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        List<Integer> numsArr = new ArrayList<>();
        for (int x : nums) numsArr.add(x);
        numsArr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                long sx = 10, sy = 10;
                while (sx <= x) {
                    sx *= 10;
                }
                while (sy <= y) {
                    sy *= 10;
                }
                return (int) (-sy * x - y + sx * y + x);
            }
        });

        if (numsArr.get(0) == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }

    public static void main(String[] args){
        int[] test = TimeEvaluater.getRandomIntArray(100);
        System.out.println(Arrays.toString(test));
        new TimeEvaluater().testAndPrint(new Runner() {
            @Override
            public void run() {
                String res = new LargestNum().largestNumber(test);
                System.out.println("res = " + res);
            }
        });

        new TimeEvaluater().testAndPrint(new Runner() {
            @Override
            public void run() {
                String res = new LargestNum().largestNumberFinal(test);
                System.out.println("largestNumberFinal = " + res);
            }
        });
    }
}
