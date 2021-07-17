package com.company.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {

    public class TreeNode {
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

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return result;
        }

        while (root != null || !stack.isEmpty()){

            if (root != null){

                result.add(root.val);
                stack.push(root);
                root = root.left;

            } else {

                root = stack.pop();
                root = root.right;

            }



        }

        return result;

    }
}
