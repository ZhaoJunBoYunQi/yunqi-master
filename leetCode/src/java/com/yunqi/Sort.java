package com.yunqi;

/**
 * @author: yunqi
 * @createdTime: 2019-10-01
 * 描述
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = {4,3,5,2,1,3,4,2,3};
        int[] ints = selectSort(arr);
        for (Integer i: ints) {
            System.out.println(i);
        }
        System.out.println();
    }


    //冒泡排序
    public static int[] bubbleSort(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length - i - 1; j ++) {
                if (arr[j-1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j -1];
                    arr[j - 1] = temp;
                }
                flag = true;
            }
            if (!flag) {
                break;
            }
        }
        return arr;
    }
    //插入排序{4,3,5,2}
    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            int value = arr[i];
            int j = i -1;
            for (; j >= 0;j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                }else {
                    break;
                }
            }
            arr[ j + 1] = value;
        }
        return arr;
    }
    //选择排序
    public static int[] selectSort(int[] arr) {
        //外层控制需要排序的趟数
        for (int i = 0; i < arr.length - 1; i++) {
            //新的趟数重新赋值为0
            int pos = 0;
            //内层循环控制遍历数组的个数并得到最大数的角标
            for (int j = 0; j < arr.length - i ;j++) {
                if (arr[j] > arr[pos]) {
                    pos = j;
                }
            }
            int temp = arr[pos];
            arr[pos] = arr[arr.length - 1 - i];
            arr[arr.length - 1- i] = temp;
        }
        return arr;
    }


}
