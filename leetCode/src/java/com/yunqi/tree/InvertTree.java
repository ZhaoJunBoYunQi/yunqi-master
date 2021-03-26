package com.yunqi.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author: yunqi
 * @createdTime: 2020-04-12
 * 描述
 */
public class InvertTree {


    // 利用前序遍历
    class Solution {
        // 先序遍历--从顶向下交换
        public TreeNode preInvertTree(TreeNode root) {
            if (root == null) return null;
            // 保存右子树
            TreeNode rightTree = root.right;
            // 交换左右子树的位置
            root.right = preInvertTree(root.left);
            root.left = preInvertTree(rightTree);
            return root;
        }
    }

    // 利用中序遍历
    public TreeNode inInvertTree(TreeNode root) {
        if (root == null) return null;
        inInvertTree(root.left); // 递归找到左节点
        TreeNode rightNode = root.right; // 保存右节点
        root.right = root.left;
        root.left = rightNode;
        // 递归找到右节点 继续交换 : 因为此时左右节点已经交换了,所以此时的右节点为root.left
        inInvertTree(root.left);
        return root;
    }


    public TreeNode postInvertTree(TreeNode root) {
        // 后序遍历-- 从下向上交换
        if (root == null) return null;
        TreeNode leftNode = postInvertTree(root.left);
        TreeNode rightNode = postInvertTree(root.right);
        root.right = leftNode;
        root.left = rightNode;
        return root;
    }


    //  利用层次遍历
    public TreeNode invertTreeBfs(TreeNode root) {
        // 层次遍历--直接左右交换即可
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode rightTree = node.right;
            node.right = node.left;
            node.left = rightTree;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    // 814. 二叉树剪枝 当左右子树都为空时候，并且当前root值为0时，返回null，否则返回root节点
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

    /** 07. 重建二叉树
     * 1、前序遍历的第一个元素可以在中序遍历中将一颗二叉树一分为二，左边的即为左子树，右边的为右子树
     * 2、遍历中序二叉树，记录二叉树的索引下标存入map中
     * 3、然后分别构造左右子树即可
     */
    // 使用全局变量是为了让递归方法少传一些参数，不一定非要这么做
    private Map<Integer, Integer> reverses = new HashMap<>();
    private int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        // 可以不做判断，因为题目中给出的数据都是有效的
        if (preLen != inLen) {
            return null;
        }

        this.preorder = preorder;

        // 以空间换时间，否则，找根结点在中序遍历中的位置需要遍历
        reverses = new HashMap<>(inLen);
        for (int i = 0; i < inLen; i++) {
            reverses.put(inorder[i], i);
        }

        return buildTree(0, preLen - 1, 0, inLen - 1);
    }
    public TreeNode buildTree(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int pivot = preorder[preStart];
        TreeNode root = new TreeNode(pivot);
        // 拿到 根节点所在的索引位置
        int index = reverses.get(pivot);
        // 左子树 便是从 preStart -> index - inStart + preStart
        // 右子树 便是从  index - inStart + preStart +1 - >inEnd
        root.left = buildTree(preStart + 1, index - inStart + preStart, inStart, index -1);
        root.right = buildTree(index - inStart + preStart +1, preEnd, index +1, inEnd);
        return root;
    }

    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return max;
    }
    public int getMax(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, getMax(root.left));
        int right = Math.max(0, getMax(root.right));
        max = Math.max(max, root.val + left + right);
        return Math.max(left, right) + root.val;
    }


}
