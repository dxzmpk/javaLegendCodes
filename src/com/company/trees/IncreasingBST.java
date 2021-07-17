package com.company.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IncreasingBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode newTree = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = root;
        while (root != null || stack.size() > 0) {
            if (root == null) {
                root = stack.pop();
                if (newTree == null) {
                    newTree = root;
                } else {
                    pre.right = root;
                    pre.left = null;
                }
                pre = root;
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
        pre.left = null;
        return newTree;
    }

    TreeNode buildTreeFromArray(Integer[] array) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(array[0]);
        queue.add(root);
        TreeNode cur;
        int i = 0;
        int index = 1;
        while (!queue.isEmpty()) {
            cur = queue.poll();

            if (index == array.length) {
                break;
            }
            if (array[index] != null) {
                cur.left = new TreeNode(array[index]);
                queue.offer(cur.left);
            }
            index ++;
            if (index == array.length) {
                break;
            }
            if (array[index] != null) {
                cur.right = new TreeNode(array[index]);
                queue.offer(cur.right);
            }
            index ++;
        }
        return root;
    }
    
    public static void main(String[] args){
        TreeNode root = new IncreasingBST().buildTreeFromArray(new Integer[]{2,1,4,null,null,3});
        new IncreasingBST().increasingBST(root);
    }


}
