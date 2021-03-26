package com.yunqi.tree;

import java.util.*;

/**
 * @author: yunqi
 * @createdTime: 2019-10-04
 * 描述
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value) {
        this.val = value;
    }
}
class TreeDemo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(depth(root));
        postOrder(new ArrayList<>(), root);
        //System.out.println(i);
    }

    /**
     *   树的遍历，一般要考虑左右子树的情况，当前left 与right的关系
     *   以及当前root.val 与left.val right.val 的关系
     *
     *
     */



    //翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
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
            values.add(stackPop.pop().val);
        }
        // 打印二叉树
        for (int i : values) {
            System.out.println(i);
        }
    }

    // 110. 平衡二叉树
    public  boolean isBalanced(TreeNode root) {
        // 如果遍历为空 则说明肯定为符合标准的
        if (root == null){
            return true;
        }
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false; // 如果左右子树的高度大于1，则不符合
        } // 分别再去判断左右子树是否符合平衡二叉树
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // 获取子树的高度由，左右子树最大的那个高度决定
    public  static int depth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left, right) + 1;
    }

    // 对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isValid(root, root);
    }

    public boolean isValid(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) { // 都为空节点说明对称，如果只有一个节点不为空，那么为不对称，如果
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) { // 如果二叉树的值不相同也不对称
            return false;
        }
        return isValid(root1.left, root2.right) && isValid(root1.right, root2.left);
    }


    public static int sumSquares(int n) {
        int temp = 12;
        int a = temp;
        int b = a;
        return 0;
    }
    // 662. 二叉树最大宽度
    int maxW;
    HashMap<Integer, Integer> map = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        /**
         假设满二叉树表示成数组序列, 根节点所在的位置为1, 则任意位于i节点的左右子节点的index为2*i, 2*i+1
         用一个List保存每层的左端点, 易知二叉树有多少层List的元素就有多少个. 那么可以在dfs的过程中记录每个
         节点的index及其所在的层level, 如果level > List.size()说明当前节点就是新的一层的最左节点, 将其
         加入List中, 否则判断当前节点的index减去List中对应层的最左节点的index的宽度是否大于最大宽度并更新
         **/
        dfs(root, 1, 1);
        return maxW;
    }
    private void dfs(TreeNode root, int level, int index) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(level)) {
            map.put(level, index);
        }
        maxW = Math.max(maxW, index- map.get(level) +1);
        dfs(root, level +1, index *2);
        dfs(root, level+1, index*2+1);
    }

}