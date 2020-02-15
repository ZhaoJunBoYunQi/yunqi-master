package com.yunqi.stackAndQueue;

import java.util.Stack;

/**
 * 两个栈实现队列
 *
 * @author: yunqi
 * @createdTime: 2020-02-15
 * 描述
 */
public class TwoStacksQueue {
    private Stack<Integer> pushStack = new Stack<>();

    private Stack<Integer> popStack = new Stack<>();

    public void add(int number) {
        pushStack.push(number);
    }

    public int poll() {
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(popStack.pop());
            }
        }
        return popStack.pop();
    }

    public int peek() {
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(popStack.pop());
            }
        }
        return popStack.peek();
    }

}
