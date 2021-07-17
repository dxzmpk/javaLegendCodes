package com.company.basic;

public class LogicRightMoving {
    public static void main(String[] args){
        int a = 5;
        System.out.println(a + " math left 1 = " + (a << 1));
        System.out.println(a + " math right 1 = " + (a >> 1));
        System.out.println(a + " logic right 1 = " + (a >>> 1));
        int j;
        StringBuilder jString = new StringBuilder();
        for (j = Integer.SIZE; j > 0; --j) {
            jString.append(a & 1);
            a = a >>> 1;
        }
        System.out.println(jString.reverse().toString());

        a = -5;
        System.out.println(a + " math left 1 = " + (a << 1));
        System.out.println(a + " math right 1 = " + (a >> 1));
        System.out.println(a + " logic right 1 = " + (a >>> 1));
    }
}
