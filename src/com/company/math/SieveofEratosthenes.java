package com.company.math;

import java.util.Arrays;

/**
 * 204. 计算质数
 */
public class SieveofEratosthenes {
    public int countPrimes(int n) {
        boolean[] primeFlag = new boolean[n];
        Arrays.fill(primeFlag, true);
        if (n <= 2) {
            return 0;
        }
        primeFlag[0] = false;
        primeFlag[1] = false;
        long i;
        for (i = 2; i < n; i++) {
            if (primeFlag[(int) i]) {
                if (i * i < n) {
                    for (long j = (long) i *i; j < n; j+=i) {
                        primeFlag[(int) j] = false;
                    }
                }

            }
        }
        int count = 0;
        for (boolean flag : primeFlag) {
            if (flag) {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println("count = " + new SieveofEratosthenes().countPrimes(65532));
    }


}
