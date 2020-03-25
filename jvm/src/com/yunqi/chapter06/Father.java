package com.yunqi.chapter06;


/**
 * @author: yunqi
 * @createdTime: 2020-03-22
 * 描述
 */
public class Father {
    private int age;
}

class Son extends Father {
    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
     //   SizeOf sizeOf = new AgentSizeOf();
    }
}