package com.company.useless;

import java.util.Arrays;
import java.util.Random;

public class AIMA {

    public static void main(String[] args) {
        /**
         * 10 total
         * while total != 0, play the game
         * with the selected probability, get the result
         * add the result to total
         */

        int total = 10;
        int experimentNum = 100001;
        // go for 1000 times
        int[] playTime = new int[experimentNum];
        int singlePlayTime = 0;
        int sum = 0;
        int[] probList = new int[64];
        probList[0] = 20;
        probList[1] = 15;

        probList[2] = 5;
        probList[3] = 3;
        probList[4] = 3;
        probList[5] = 3;
        for (int i = 7; i <= 18; i++) {
            probList[i] = 1;
        }

        // 模拟1000次
        for (int j = 0; j < experimentNum; j++) {
            singlePlayTime = 0;
            total = 10;
            Random random = new Random();
            while (total >= 1) {

                total -= 1;
                int randomInt = random.nextInt(64);
                total += probList[randomInt];
                singlePlayTime += 1;

            }
            playTime[j] = singlePlayTime;
            sum += singlePlayTime;
        }

        Arrays.sort(playTime);

        System.out.println(Arrays.toString(playTime));
        System.out.println
                           ("中位数为 " + (playTime[experimentNum / 2] + playTime[experimentNum / 2 - 1]) / 2);
        System.out.println("平均数为" + sum / experimentNum);


    }
}
