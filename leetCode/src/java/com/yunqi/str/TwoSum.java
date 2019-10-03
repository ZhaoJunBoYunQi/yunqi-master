
package com.yunqi.str;

/**
 * @author: yunqi
 * @createdTime: 2019-10-03
 * 描述
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] twoSum = twoSum(new int[]{2, 7, 11,15},9);
        for (int i: twoSum) {
            System.out.println(i);
        }
    }
    //滑动窗口，求最小连续子数组
    public static int getMinLength(int[] arr, int target) {
        //每次right向右移动，如果sum《 target，那么则继续移动
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

}
