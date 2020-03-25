package com.yunqi.tree;

import com.yunqi.list.ListNode;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author: yunqi
 * @createdTime: 2019-10-04
 * 描述
 */
public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value) {
        this.value = value;
    }
}
class TreeDemo1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        postOrder(new ArrayList<>(), root);
        //System.out.println(i);
    }
    //翻转二叉树
    public TreeNode reverseListNode(TreeNode node) {
        if (node == null)
            return null;
        reverseListNode(node.left);
        reverseListNode(node.right);
        swap(node.left, node.right);
        return node;
    }

    private TreeNode swap(TreeNode left, TreeNode right) {
        TreeNode node = left;
        left = right;
        right = node;
        return node;
    }

    static void postOrder(List<Integer> values, TreeNode root) {
        Stack<TreeNode> stackPush = new Stack<>();
        Stack<TreeNode> stackPop = new Stack<>();
        stackPush.push(root);
        while (!stackPush.isEmpty()) {
            TreeNode node = stackPush.pop();
            stackPop.push(node);
            if (node.left != null) {
                stackPush.push(node.left);
            }
            if (node.right != null) {
                stackPush.push(node.right);
            }
        }

        while (!stackPop.isEmpty()) {
            values.add(stackPop.pop().value);
        }
        // 打印二叉树
        for (int i : values) {
            System.out.println(i);
        }
    }


    public static int sumSquares(int n) {
            return 0;
    }

}