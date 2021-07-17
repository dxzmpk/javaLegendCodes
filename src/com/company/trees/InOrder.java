package com.company.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {

    class TreeNode {
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

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null){
            return results;
        }

        while (root != null || !stack.isEmpty()){

            if (root != null){

                stack.push(root);
                root = root.left;

            } else {

                root  = stack.pop();
                results.add(root.val);
                root = root.right;

            }

        }

        return results;
    }
}
