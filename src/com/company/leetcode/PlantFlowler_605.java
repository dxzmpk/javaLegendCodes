package com.company.leetcode;


/**
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * 示例 1:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 *
 */
public class PlantFlowler_605 {
    /**
     cant be continous placed
     1 yes 0 no
     n
     flowerbed = [1,0,0,0,1]

     for all the flowerbed
     place a flower, n-1
     if n > 0, but come to the end of flower bed
     return false
     return true
     1 0 0 0 1

     **/
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int firstZero = -1;
        int secZero = -1;
        if (n == 0) {
            return true;
        }
        if (flowerbed.length == 1){
            if (n > 1) {
                return false;
            }
            return flowerbed[0] ==0;
        }
        if (flowerbed.length ==2) {
            if (n > 1) {
                return false;
            }
            return flowerbed[1]==0 && flowerbed[0] ==0;
        }
        for (int i =0; i < flowerbed.length; i ++) {
            if (flowerbed[i] == 0) {
                // if all > 0, fill and init
                if (firstZero > 0 && secZero > 0) {
                    n --;
                    secZero = -1;
                } else if (firstZero > 0 && i == 1) {
                    n--;
                    // 1000 101
                } else if (firstZero > 0 && i == flowerbed.length-1) {
                    n--;
                }else if (firstZero > 0 && secZero < 0) {
                    // if first > 0 and sec < 0, fill sec
                    secZero = 1;
                } else {
                    // if first < 0 and sec < 0, fill first
                    firstZero = 1;
                }
            } else {
                /**
                 if cur = 1, then all should be set to -1
                 **/
                firstZero = -1;
                secZero = -1;
            }
        }
        if (n > 0) {
            return false;
        }
        return true;
    }
}

//防御式编程思想：在 flowerbed 数组两端各增加一个 0， 这样处理的好处在于不用考虑边界条件，任意位置处只要连续出现三个 0 就可以栽上一棵花。
//
//class Solution(object):
//                              def canPlaceFlowers(self, flowerbed, n):
//                              tmp = [0]+flowerbed+[0]
//                              for i in range(1, len(tmp)-1):
//                              if tmp[i-1] == 0 and tmp[i] == 0 and tmp[i+1] == 0:
//                              tmp[i] = 1  # 在 i 处栽上花
//                              n -= 1
//                              return n <= 0   # n 小于等于 0 ，表示可以栽完花

