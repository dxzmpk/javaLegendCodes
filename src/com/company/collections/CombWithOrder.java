package com.company.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombWithOrder {

    /**
     nums已排序 num>0
     pick [1,n] to nums
     make [1,n] can be represented by sum of nums
     output: how many to pick?

     [1, 3] n=6

     1 1
     2 2
     3 1,2
     4 1,3 2,2
     5 1,4 2,3
     6 1,5 2,4 3,3


     **/

    List<Integer> combList = new LinkedList<>();

    @Deprecated
    public int minPatches(int[] nums, int n) {
        
        helper(new ArrayList<Integer>(), 0, nums.length, nums);
        return 0;
    }

    /**
     helper function:
     if it has depth to to length, then return the comb
     return helper(before,depth+1) and helper(before + current ,helper+1)
     **/
    public void helper(List<Integer> comb, int currentDepth, int depth, int[] nums) {

        if(currentDepth == depth) {
            combList.add(comb.stream().reduce(0, Integer::sum));
            System.out.println(comb.toString());
        } else {
            helper(new ArrayList<Integer>(comb), currentDepth + 1, depth, nums);
            List<Integer> newList = new ArrayList<>(comb);
            newList.add(nums[currentDepth]);
            helper(newList, currentDepth + 1, depth, nums);
        }

    }
    
    public static void main(String[] args){
        new CombWithOrder().minPatches(new int[]{1,2,3,4}, 6);
    }
}
