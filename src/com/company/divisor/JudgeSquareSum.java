package com.company.divisor;

public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int max = (int) Math.sqrt(c);
        for (int i = 1; i <= max; i++) {
            double init = Math.sqrt(c - i*i);
            double floor = Math.floor(init);
            if (init == floor) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args){
        boolean res = new JudgeSquareSum().judgeSquareSum(3);
        System.out.println("res = " + res);
    }
}

