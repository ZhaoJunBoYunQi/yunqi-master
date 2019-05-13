package com.yunqi.juc;

import ch.qos.logback.core.util.TimeUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author: yunqi
 * @createdTime: 2019/4/22
 * 描述
 */
public class VolatileDemo {

    static volatile   Boolean able = false;
    public static void main(String[] args) throws Exception{

        Thread t1 = new Thread(()->{
                if (!able) {
                    System.out.println(!able);
                    able = true;
                    System.out.println("true**************" );
                }
        });


        Thread t2 = new Thread(()->{
            if (!able) {
                System.out.println(able);
                able = false;
                System.out.println("false**************" );
            }

        });
        t1.start();
        t2.start();
    }



}
