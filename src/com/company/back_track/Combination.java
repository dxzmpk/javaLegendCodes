package com.company.back_track;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combination {


    List<List<Integer>> results = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    public List<List<Integer>> combine(int n, int k) {
        help(n, 1, k);
        return results;
    }

    void help(int n, int cur, int k) {
        if (stack.size() + (n - cur + 1) < k) {
            return;
        }
        if (stack.size() > k) {
            return;
        }
        if (stack.size() == k) {
            results.add(new ArrayList<>(stack));
            //System.out.println(results.get(results.size()-1));
            return;
        }
        help(n, cur + 1, k);
        stack.push(cur);
        help(n, cur + 1, k);
        stack.pop();

    }

    public static void main(String[] args){
        Combination comb = new Combination();
        List<List<Integer>> results = comb.combine(4,2);
        for (List<Integer> result : results) {
            System.out.println(result.toString());
        }
    }
}
