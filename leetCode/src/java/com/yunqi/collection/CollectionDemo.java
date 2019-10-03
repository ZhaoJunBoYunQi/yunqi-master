package com.yunqi.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: yunqi
 * @createdTime: 2019-10-03
 * 描述 集合使用
 */
public class CollectionDemo {
    public static void main(String[] args) {

    }

    //获得两个集合的交集
    public static Object[] getUnion(int[] a, int[] b) {
       /* Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
           map.put(a[i], 0);
        }
        for (int i = 0; i < b.length; i++) {
            if (map.containsKey(b[i])) {
               map.put(b[i], map.get(b[i]) + 1);
            }
        }
        for (Integer i : map.keySet()) {
            if (map.get(i).intValue() >= 2) {
                res.add(b[i]);
            }
        }*/

        Set<Integer> in = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            in.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            if (in.contains(b[i])) {
                res.add(b[i]);
            }
        }
        return res.toArray();
    }

}
