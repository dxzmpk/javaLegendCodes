package com.company.matrix;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class UpperLeftTriangle {

    public static void main(String[] args){
        int N = 4;
        boolean[][] matrix = new boolean[N][N];
        for(int dif = 0; dif < N; dif++) {
            for (int col = 0; col <= dif; col++) {
                int row = dif - col;
                matrix[row][col] = true;
            }
        }
        for (int row = 0; row < N; row++) {
            System.out.println("Row " + row + " OF Matrix is = " + Arrays.toString(matrix[row]));
        }
    }
    /**
     * dif from 0 to N
     * col from 0 to N - dif
     * Row 0 OF Matrix is = [true, false, false, false]
     * Row 1 OF Matrix is = [true, true, false, false]
     * Row 2 OF Matrix is = [true, true, true, false]
     */

}
