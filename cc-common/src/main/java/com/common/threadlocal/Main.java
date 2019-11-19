package com.common.threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/11/12
 * To change this template use File | Settings | File Templates.
 **/

public class Main {
    public static void main(String[] args) {
        new Thread("thread-1") {
            @Override
            public void run() {
                update();
            }
        }.start();

        new Thread("thread-2") {
            @Override
            public void run() {
                update();
            }
        }.start();

        new Thread("thread-3") {
            @Override
            public void run() {
                update();
            }
        }.start();
    }

//    private static ThreadLocal<Map> initValue=new ThreadLocal<Map>(){
//        @Override
//        protected Map initialValue(){
//            Map map=new HashMap();
//            map.put("k1",Thread.currentThread().getName());
//            map.put("k2",10);
//            return map;
//        }
//    };

    private static ThreadLocal<Integer> initValue = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 10;
        }
    };

    private static void update() {
        initValue.set(initValue.get() + 70);
        System.out.println(initValue.get());

    }
}
