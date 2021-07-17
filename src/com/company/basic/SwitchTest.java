package com.company.basic;

public class SwitchTest {
    public static void main(String[] args){
        CASEENUM a = CASEENUM.CASE3;
        switch (a) {
            default:
                System.out.println("default");
            case CASE1:
                System.out.println("likes");
                break;
            case CASE2:
                System.out.println("hates");
                break;

        }
    }
}
