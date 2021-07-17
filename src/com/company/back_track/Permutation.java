package com.company.back_track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Permutation {

    List<List<Integer>> result = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        dfs(nums,  used);
        return result;
    }

    void dfs(int[] nums,  boolean[] used) {
        if (stack.size() == nums.length) {
            result.add(new ArrayList<>(stack));
            return;
        }
        int i;
        for (i = 0; i < nums.length; i++) {
            if (used[i] == false) {
                stack.push(nums[i]);
                used[i] = true;
                dfs(nums, used);
                used[i] = false;
                stack.pop();
            }
        }
    }

    public static void main(String[] args){
        Permutation comb = new Permutation();
        List<List<Integer>> results = comb.permute(new int[] {1,2,3});
        for (List<Integer> result : results) {
            System.out.println(result.toString());
        }
    }
}
