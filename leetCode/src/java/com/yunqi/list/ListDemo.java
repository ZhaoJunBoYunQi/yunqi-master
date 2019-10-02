package com.yunqi.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yunqi
 * @createdTime: 2019-10-01
 * 描述
 */
public class ListDemo {
    public static void main(String[] args) {
        int f = fun(5);
        System.out.println(f);
    }

    /**
     * 这样可以当找到f（n） 如果有，可以重复利用已经查过的，避免多次占用内存
     * 变态青蛙跳台阶，一次跳一个，或者一次跳2个台阶
     * @param n
     * @return
     */
    public static int f(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int res = f(n - 1) + f(n - 2);
        map.put(n, res);
        return res;
    }
    //非递归
    public static int fun(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int pre = 1;
        int next = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = pre + next;
            pre = next;
            next = res;
        }
        return res;
    }

}
