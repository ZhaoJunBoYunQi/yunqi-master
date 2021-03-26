package com.yunqi.calculate;

import com.yunqi.test.Father;

import java.util.Stack;

/**
 * @author: yunqi
 * @createdTime: 2020-04-06
 * 描述
 */
public class Calculator {
    public static void main(String[] args) {
        System.out.println(calculate("1+(7-3)/4"));
    }


    static long calculate(String str) {
        Stack<Long> dataStack = new Stack<>();
        long num = 0;
        int res = 0;
        char symbol = '+';
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                // 假如 12 咋加入时候 为 1，2 即 10+2
                num = num * 10 + (c - '0');
            }
            // 碰到左括号 就把括号里面当成一个 新的被加数
            if (c == '(') {
                int j = findClosing(str.substring(i));
                num = calculate(str.substring(i + 1, i + j));
                i += j;
            }
            // 如果去空格可以改为（!Character.isDigit(c)&& c!=' '）
            if (!Character.isDigit(c) || i == str.length()-1) {
                switch (symbol){
                    case '+':
                        dataStack.push(num);
                        break;
                    case '-':
                        dataStack.push(-num);
                        break;
                    case '*':
                        // 将前一个数与当前数相乘即可
                        long pre = dataStack.pop();
                        dataStack.push(pre * num);
                        break;
                    case '/':
                        long divide = dataStack.pop();
                        dataStack.push(divide / num);
                        break;

                }
                num = 0;
                symbol = c; // 将符号更新为当前符号，数字清零
            }
            if (c == ')'){
                break;
            }
        }
        while (!dataStack.isEmpty()) {
            res += dataStack.pop();
        }
        return res;
    }

    // 删除所有的括号对，并返回右括号的位置
    private static int findClosing(String s) {
        int level = 0, i = 0;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') level++;
            else if (s.charAt(i) == ')') {
                level--;
                if (level == 0) break;
            } else continue;
        }
        return i;
    }

}
