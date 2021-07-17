package com.company.matrix;

import java.util.Arrays;

public class Rectangular {
    public static void main(String[] args){
        int N = 4;
        boolean[][] matrix = new boolean[N][N];
        for(int r = 0; r < N; r++) {
            for (int col = 0; col < N; col++) {
                matrix[r][col] = true;
            }
            System.out.println("Row " + r + " OF Matrix is = " + Arrays.toString(matrix[r]));
        }
    }
}
