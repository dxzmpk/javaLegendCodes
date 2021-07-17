package com.company.bit_wise;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // i from 0 to 31
        // find left num left_pos * (left_mask&n)
        // find right num right_pos * (right_mask&n)
        // n = n|right num << 31 - i
        // n = n|left num << i
        for (int i = 0; i < 16; i++) {
            int left_mask = 1;
            int right_mask = 1;

            int left_num = n & (left_mask << (31 - i));
            int right_num = n & (right_mask << i);


            right_num =  right_num >>> i;
            left_num =  left_num >>> (31 - i);

            if(left_num == 1) {
                n = n | (1 << i);
            } else {
                n = n & ~(1 << i);
            }

            if(right_num == 1) {
                n = n | (1 << (31 - i));
            } else {
                n = n & ~(1 << (31 - i));
            }
        }
        return n;
    }
    
    public static void main(String[] args){
        int result = new ReverseBits().reverseBits(8);
        System.out.println("result = " + result);
    }
}
