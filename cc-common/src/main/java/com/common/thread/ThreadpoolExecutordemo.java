package com.common.thread;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/11/5
 * To change this template use File | Settings | File Templates.
 **/
public class ThreadpoolExecutordemo {
    public static void main(String[] args) {
        demo2();
    }

    private static void demo() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                System.out.println("thread id is: " + Thread.currentThread().getId());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }
    }


    private static void demo2() {
        Executor executor = new ThreadPoolExecutor(3, 4, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2)) {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("beforeExecute is called");
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("afterExecute is called");
            }

            @Override
            protected void terminated() {
                System.out.println("over");
            }
        };
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println(new Date() + "thread id is: " + Thread.currentThread().getId());
                Thread.sleep(1000 * 5);
                return null;
            }
        };

        for (int i = 0; i < 10; i++) {
            ((ThreadPoolExecutor) executor).submit(callable);
            long l = ((ThreadPoolExecutor) executor).getCompletedTaskCount();
            if (l == 10) {

            }
        }
        ((ThreadPoolExecutor) executor).shutdown();
//        if(((ThreadPoolExecutor) executor).isShutdown()){
//            System.out.println("over");
//        }


//        while (true) {
//            if (((ThreadPoolExecutor) executor).getActiveCount() == 0) {
//                System.out.println("over");
//                return;
//
//            }
//        }

    }


}
