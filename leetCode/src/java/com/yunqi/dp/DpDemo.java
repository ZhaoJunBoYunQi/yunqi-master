package com.yunqi.dp;

import java.util.Arrays;
import java.util.List;

/**
 * @author: yunqi
 * @createdTime: 2019-10-04
 * 描述
 * 递归自顶向下
 * 动态规划 自底向上
 */
public class DpDemo {

    public static void main(String[] args) {

    }

   // leetcode 的 62 号题：https://leetcode-cn.com/problems/unique-paths/
    /*   一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
    问总共有多少条不同的路径？*/
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    //  leetcode 的第64题：https://leetcode-cn.com/problems/minimum-path-sum/
    // 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    public static int uniquePaths(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + arr[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + arr[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + arr[i][j];
            }
        }
        return dp[m-1][n-1];
    }


    // leetcode 72
    /*给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
    你可以对一个单词进行如下三种操作：
    插入一个字符 删除一个字符
    替换一个字符*/
    public static int getMinDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
       // dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] + 1;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j-1] +1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    // leetcode 120三角形最小路径和
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        List<Integer> rows = triangle.get(n-1);
        for (int i = 0; i < n; i++) {
            dp[n-1][i] = rows.get(i);
        }
        for (int i = n-2; i >=0 ; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < i+1; j++) {
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + row.get(j);
            }
        }
        return dp[0][0];
    }

    // LeetCode 第 53 号问题：最大子序和
    public int maxSubArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int res = dp[0];
        for (int i = 1; i < arr.length; i++) {
            // dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
            dp[i] = Math.max(dp[i-1], 0) + arr[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 最长上升子序列 leetcode 300
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 最长的回文子串
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return null;
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            int temp = i;
            for (int j = 0; j < temp; j++) {
                if (chars[j] != chars[temp]) {
                    break;
                }else {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    sb.append(chars[j]);
                    temp--;
                }
            }
        }
        return s;
    }

}
