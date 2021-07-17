package com.company.useless;

import com.company.time.ITimeRunner;

public class MatrixInit implements ITimeRunner {
    public void run1() {
        int[][] intMatrix = new int[1024][1024];
        for (int j=0;j<1024;j++){
            for (int i=0;i<1024;i++) {
                intMatrix[i][j] = 1;
            }
        }
    }

    // 最里的最靠右
    public void run2(){
        int[][] intMatrix = new int[1024][1024];
        for (int j=0;j<1024;j++){
            for (int i=0;i<1024;i++) {
                intMatrix[j][i] = 1;
            }
        }
    }


}
