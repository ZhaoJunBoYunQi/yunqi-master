package com.yunqi.stackAndQueue;

import java.util.Stack;

/**
 * 获取最小值栈
 *
 * @author: yunqi
 * @createdTime: 2020-02-15
 * 描述
 */
public class MyStack {
    private Stack<Integer> minStack = new Stack<>();

    private Stack<Integer> dataStack = new Stack<>();

    public void push(int number) {
        if (minStack.isEmpty()) {
            minStack.push(number);
        }
        if (number < getMin()) {
            minStack.push(number);
        }
        dataStack.push(number);
    }

    public int pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("Your stack is empty！");
        }
        int value = dataStack.peek();
        if (value == minStack.peek()) {
            minStack.pop();
        }
        dataStack.pop();
        return value;
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("最小值不存在");
        }
        return minStack.peek();
    }
}
