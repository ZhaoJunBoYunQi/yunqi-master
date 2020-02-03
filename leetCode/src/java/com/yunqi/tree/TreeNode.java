package com.yunqi.tree;

import com.yunqi.list.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
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
        int i = sumSquares(4);
        System.out.println(i);
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

    public static int sumSquares(int n) {
            return 0;

    }

}