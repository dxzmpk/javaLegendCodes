package com.company.matrix;

import java.util.Arrays;

public class UpperRightTriangle {

    public static void main(String[] args){
        int N = 4;
        boolean[][] matrix = new boolean[N][N];
        for(int dif = 0; dif < N; dif++) {
            for (int row = 0; row + dif < N; row++) {
                int col = row + dif;
                matrix[row][col] = true;
            }
        }
        for (int row = 0; row < N; row++) {
            System.out.println("Row " + row + " OF Matrix is = " + Arrays.toString(matrix[row]));
        }

        /**
         * Row 0 OF Matrix is = [true, true, true, true]
         * Row 1 OF Matrix is = [false, true, true, true]
         * Row 2 OF Matrix is = [false, false, true, true]
         * Row 3 OF Matrix is = [false, false, false, true]
         */
    }

}
