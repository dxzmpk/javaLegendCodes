package com.company.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Candy_TreeSet {
    /**
     candiesCount[i] count of i candy
     queries[i][] = [type, day, cap]
     0
     cant eat i before finishing i - 1
     eat at least one before empty
     answer[i] = true :
     */
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] canEat = new boolean[queries.length];
        int i = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < candiesCount.length; j++) {
            sum += candiesCount[j];
            map.put(j, sum);
        }
        for (int[] query : queries) {
            canEat[i] = judge(candiesCount, query, map);
            i++;
        }
        return canEat;
    }

    boolean judge(int[] candiesCount, int[] query, Map<Integer, Integer> map) {
        int max = query[1] * query[2];
        int min = query[1];
        if (min > map.get(query[0]) || max <= map.get(query[0]) - candiesCount[query[0]]) {
            return false;
        } else {
            return true;
        }
    }
    
    public static void main(String[] args){
        int[][] queries = new int[3][3];
        queries[0] = new int[] {0,2,2};
        queries[1] = new int[] {4,2,4};
        queries[2] = new int[] {2,13,1000000000};
        boolean[] res = new Candy_TreeSet().canEat(new int[]{7,4,5,3,8}, queries);
        System.out.println("Res = " + Arrays.toString(res));
    }
}
