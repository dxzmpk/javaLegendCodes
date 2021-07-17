package com.company.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {

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

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode previous = null;

        while (root != null || !stack.isEmpty()) {

            if (root != null) {

                stack.push(root);

                root = root.left;

            } else {

                root = stack.pop();

                // 如果root右侧无节点或者右侧节点刚访问过
                if (root.right == null || root.right == previous){

                    // 访问root
                    resultList.add(root.val);
                    // 更新previous
                    previous = root;
                    // root置空
                    root = null;

                }  else {

                    // 将root压进来
                    stack.push(root);
                    // 向右侧移动
                    root = root.right;
                }

            }
        }

        return resultList;

    }
}
