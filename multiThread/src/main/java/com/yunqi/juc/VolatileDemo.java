package com.yunqi.juc;

import ch.qos.logback.core.util.TimeUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author: yunqi
 * @createdTime: 2019/4/22
 * 描述
 */
public class VolatileDemo {

      boolean able = false;//不加volatile就不能输出开始
    public static void main(String[] args) throws Exception{
        VolatileDemo volatileDemo = new VolatileDemo();
      new Thread(()->{
             volatileDemo.start();
        }).start();
        Thread.sleep(2000);
      new Thread(()->{
            volatileDemo.shutDown();
        }).start();
        // Thread t = new Thread();
        //t.start这种不能保证t1和t2同时启动，用volatile会无效

    }

    public void start() {
        while (!able) {
          //  System.out.println("..........");加这个不加wotalie也能输出开始
        }
        System.out.println("开始");
    }
    public void shutDown() {
        able = true;
    }
}
