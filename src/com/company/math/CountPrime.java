package com.company.math;
import java.util.*;

public class CountPrime {

    boolean IsPrime(int num){
        int base=2;
        if(num==1)return false;
        else if(num==2||num==3)return true;
        else {
            while(base<num){
                if(num%base==0)
                    return false;
                base++;
            }
        }
        return true;
    }

    public int countPrimes2(int n) {
        List<Integer> primes = countPrimesHelp(n);
        return primes.size();
        //int result = 0;
        //for (Integer cur : primes) {
        //    if (IsPrime(cur)) {
        //        result ++;
        //    }
        //}
        //return result;
    }

    public List<Integer> countPrimesHelp(int n) {
        List<Integer> primes1 = new ArrayList<>();
        List<Integer> primes2 = new ArrayList<>();
        int i;
        if (n <= 2) {
            return Collections.emptyList();
        }
        for (i = 2; i < n; i++) {
            primes1.add(i);
        }
        for (i = 2; i < Math.floor(Math.sqrt(n)); i++) {
            // use primes2 to store cur result
            if (primes2.size() == 0) {
                for (Integer cur : primes1) {
                    if (cur == i || cur % i != 0) {
                        primes2.add(cur);
                    }
                }
                primes1.clear();
            } else {
                for (Integer cur : primes2) {
                    if (cur == i || cur % i != 0) {
                        primes1.add(cur);
                    }
                }
                primes2.clear();
            }
        }
        return primes1.isEmpty()?primes2:primes1;
    }

    public static void main(String[] args){
        int primes = new CountPrime().countPrimes2(499979);
        System.out.println(primes);
    }
}
