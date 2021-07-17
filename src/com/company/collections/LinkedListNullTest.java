package com.company.collections;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListNullTest {
    class TreeNode {
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static void main(String[] args){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(null);
        queue.offer(null);
        queue.offer(null);
        queue.offer(null);
        System.out.println(queue.toString());
    }
    
}
