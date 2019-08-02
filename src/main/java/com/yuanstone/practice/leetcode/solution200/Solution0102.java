package com.yuanstone.practice.leetcode.solution200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class Solution0102 {

    public List<List<Integer>> levelOrder (TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            levels.add(new ArrayList<>());
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode tn = queue.poll();
                levels.get(level).add(tn.val);
                if (tn.left != null) queue.offer(tn.left);
                if (tn.right != null) queue.offer(tn.right);
            }
            ++level;
        }
        return levels;
    }

    // use dfs
    public List<List<Integer>> levelOrder2 (TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    public void dfs (TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return;
        if (result.size() < level + 1) result.add(new ArrayList<>());
        result.get(level).add(node.val);
        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) { val = x; }
    }
}
