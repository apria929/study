package com.common.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by user on 2017/12/12.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future future = executor.submit(() -> {
                System.out.println(new Date() + "thread id is:" + Thread.currentThread().getId());
                Thread.sleep(5000);
                return null;
            });
            futures.add(future);
        }
        for (Future future : futures) {
            future.get();
        }
        System.out.println("over");
    }
}