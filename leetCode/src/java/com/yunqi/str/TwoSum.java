
package com.yunqi.str;

import com.yunqi.array.Array;

import java.lang.annotation.ElementType;
import java.rmi.registry.Registry;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author: yunqi
 * @createdTime: 2019-10-03
 * 描述
 * 字符集大小写是否敏感，只有字母？数字加字母？ASCII，字符集？
 * 子串，子序列？子数组？（后2个可以不连续）
 * 返回一个值，若没有值返回“”或者null，0
 */
public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Integer.valueOf('a'));
        Queue<Integer> queue = new LinkedList<>();
    }
   //求两个字符串的最长公共子串
    public static String getDupSubStr(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        String res = "";
        int i = 0;
        int j = 0;
        boolean flag = false;
        while (i < chars1.length) {
            for (j = 0; j <chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    flag = true;
                }
            }
            if (flag) {
                res += chars1[i];
                i++;
                j++;
            }else {
                j = 0;
            }

        }

        return null;
    }


    //滑动窗口找最大无重复的子串长度
    public static int getMaxSubStr(String s) {
        int l = 0, r = -1;
        int res = 0;
        //存放字母的频率
        int[] fre = new int[256];
        int len = s.toCharArray().length;
        char[] chars = s.toCharArray();
        while (l < len) {
            if (r + 1 < len && fre[chars[r+1]] == 0) {
                //等于++r;   fre[chars[r]]++;
                fre[chars[++r]]++;
            }else {
                fre[chars[l++]]--;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }

    //滑动窗口，求最小连续子数组
    public static int getMinLength(int[] arr, int target) {
        //每次right向右移动，如果sum < target，那么则继续移动
        //如果sum>target，则l左移，这样就可以缩短l与r之间的值
        int l = 0;
        int r = -1;
        int sum = 0, res = arr.length + 1;
        while ( l < arr.length) {
            if (r + 1 < arr.length && sum < target) {
                r++;
                sum += arr[r];
            } else {
                sum -= arr[l];
                l++;
            }
            if (sum >= target) {
                //则滑动窗口之间最小值为r-l+1；
                res = Math.min(res, r - l + 1);
            }
        }
        if (res == arr.length + 1)
            return 0;
        return res;

    }



    public static int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int res ;
        //[42,43]因为要找两个不同元素，所以是l<r
                while (l < r) {
            res = nums[r] + nums[l];
            if (res == target)
                return new int[]{l, r};
            else if (res > target)
                r--;
            else
                l++;
        }
        return new int[]{-1, -1};
    }
    public static void moveToZero(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
         /*   if (arr[i] != 0){
                arr[k++] = arr[i];
            }*/
         if (arr[i] != 0){
             if (i != k){
                 //当i=k时没必要交换，直接移动k值，当i！=k，将i和k进行交换
                 swap(arr, i, k++);
             }else {
                 k++;
             }
         }
        }
       /* for (int i = k; i < arr.length; i++) {
            arr[i] = 0;
        }*/
        for (int i : arr) {
            System.out.println(i);
        }
    }
    public static int[] swap(int[]arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }



    public static void sortColor(int[] arr) {
        int zero = -1;
        int two = arr.length;
        for (int i = 0; i < two; ) {
            if (arr[i] == 1) {
                i++;
            } else if (arr[i] == 0) {
                zero++;
                swap(arr, zero, i);
                i++;
                //等于 swap（arr, ++zero, i++）
            } else if (arr[i] == 2) {
                two--;
                swap(arr, i, two);
            }
        }
    }

    // 242. 有效的字母异位词
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sIndex = new int[26];
        for (int i = 0; i < t.length(); i++) {
            sIndex[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (sIndex[t.charAt(i) - 'a'] == 0) {
                return false;
            }
            sIndex[t.charAt(i) - 'a']--;
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sIndex = new int[26];
        for (int i = 0; i < t.length(); i++) {
            sIndex[s.charAt(i) - 'a']++;
            sIndex[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (sIndex[i] != 0) {
                return false;
            }
        }
        return true;
    }
    // 排序玩，比较是否相同，相同表示一样，速度最快
    public boolean isAnagram3(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        return new String(charS).equals(new String(charT));
    }
    // 791. 自定义字符串排序
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        for (int i = 0; i < T.length(); i++) {
            count[T.charAt(i) - 'a']++;
        }
        for (int i = 0; i < S.length(); i++) {
            if (count[S.charAt(i) - 'a'] > 0) {
                for (int j = 0; j < count[S.charAt(i) - 'a']; j++) {
                    sb.append(S.charAt(i));

                }
                count[S.charAt(i) - 'a'] = 0;
            }
        }

        for (int i = 0; i < T.length(); i++) {
            if (count[T.charAt(i) - 'a'] > 0) {
                sb.append(T.charAt(i));
            }
        }
        return sb.toString();
    }
}
