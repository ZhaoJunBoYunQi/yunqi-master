package com.yunqi.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yunqi
 * @createdTime: 2020-05-06
 * 描述
 */
public class BackTrack {




    // leetcode 17
    public static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits== null || digits.length() == 0) {
            return list;
        }
        doCombination(new StringBuilder(), list, digits);
        return list;
    }

    public void doCombination(StringBuilder prefix , List<String> list, final String digits) {
        if (prefix.length() == digits.length()) {
            list.add(prefix.toString());
        }
        int key = digits.charAt(prefix.length()) - '0';
        String letters = KEYS[key];
        for (char c : letters.toCharArray()) {
            prefix.append(c);
            doCombination(prefix, list, digits);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
}
