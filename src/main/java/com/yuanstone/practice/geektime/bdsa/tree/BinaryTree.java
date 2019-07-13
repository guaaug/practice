package com.yuanstone.practice.geektime.bdsa.tree;

import com.yuanstone.practice.geektime.bdsa.structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    public static void main (String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);

        TreeNode node3 = new TreeNode(node6, node7, 3);
        TreeNode node2 = new TreeNode(node4, node5, 2);
        TreeNode node1 = new TreeNode(node2, node3, 1);

        preOrderTraverse(node1);
        System.out.println();
        preOrderTraverse2(node1);
        System.out.println();
        System.out.println("-------------------------");
        inOrderTraverse(node1);
        System.out.println();
        inOrderTraverse2(node1);
        System.out.println();
        System.out.println("-------------------------");
        postOrderTraverse(node1);
        System.out.println();
        postOrderTraverse2(node1);
        System.out.println();
        System.out.println("-------------------------");
        levelTraverse(node1);
        System.out.println();
        deepTraverse(node1);
    }

    public static void preOrderTraverse (TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.toString());
        preOrderTraverse(node.getLeft());
        preOrderTraverse(node.getRight());
    }

    public static void preOrderTraverse2 (TreeNode node) {
        if (node == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                System.out.print(cur.toString());
                stack.push(cur);
                cur = cur.getLeft();
            } else {
                cur = stack.pop().getRight();
            }
        }
    }

    public static void inOrderTraverse (TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.getLeft());
        System.out.print(node.toString());
        inOrderTraverse(node.getRight());
    }

    public static void inOrderTraverse2 (TreeNode node) {
        if (node == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.getLeft();
            } else {
                cur = stack.pop();
                System.out.print(cur.toString());
                cur = cur.getRight();
            }
        }
    }

    public static void postOrderTraverse (TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.getLeft());
        postOrderTraverse(node.getRight());
        System.out.print(node.toString());
    }

    public static void postOrderTraverse2 (TreeNode node) {
        if (node == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(node);
        TreeNode cur, pre = null;
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if ((cur.getLeft() == null && cur.getRight() == null) || (pre != null && (pre == cur.getLeft() || pre == cur.getRight()))) {
                System.out.print(cur.toString());
                pre = stack.pop();
            } else {
                if (cur.getRight() != null) {
                    stack.push(cur.getRight());
                }
                if (cur.getLeft() != null) {
                    stack.push(cur.getLeft());
                }
            }
        }
    }

    public static void levelTraverse (TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.toString());
            if (temp.getLeft() != null) {
                queue.offer(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.offer(temp.getRight());
            }
        }
    }

    public static void deepTraverse (TreeNode node) {
        if (node == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp);
            if (temp.getRight() != null) {
                stack.push(temp.getRight());
            }
            if (temp.getLeft() != null) {
                stack.push(temp.getLeft());
            }
        }
    }
}
