package com.yuanstone.practice.geektime.bdsa.structure;

import lombok.Data;

@Data
public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private int data;

    public TreeNode (TreeNode left, TreeNode right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public TreeNode (int data) {
        this.data = data;
    }

    public TreeNode (TreeNode left, int data) {
        this.left = left;
        this.data = data;
    }

    @Override
    public String toString () {
        return " " + data + " ";
    }
}
