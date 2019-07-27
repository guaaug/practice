package com.yuanstone.practice.leetcode.solution100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Solution0094 {
    private static List<Integer> list = new ArrayList<>();

    public static void main (String[] args) {
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn4 = new TreeNode(4);
        tn5.left = tn1;
        tn5.right = tn4;

        System.out.println(inorderTraversal2(tn5));
        System.out.println(inorderTraversal(tn5));
    }

    public static List<Integer> inorderTraversal (TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new ArrayDeque();
        TreeNode cur = root;
        while (cur != null || !deque.isEmpty()) {
            if (cur != null) {
                deque.push(cur);
                cur = cur.left;
            } else {
                cur = deque.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    public static List<Integer> inorderTraversal2 (TreeNode root) {
        if (root == null) {
            return list;
        }
        inorderTraversal2(root.left);
        list.add(root.val);
        inorderTraversal2(root.right);
        return list;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) { val = x; }
    }
}
