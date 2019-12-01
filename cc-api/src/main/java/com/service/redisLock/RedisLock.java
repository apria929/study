//package com.service.redisLock;
//
//import com.redis2.RedisTool;
//import redis.clients.jedis.Jedis;
//
///**
// * Created by IntelliJ IDEA.
// * User: yahui
// * Date: 2019/11/10
// * To change this template use File | Settings | File Templates.
// **/
//public class RedisLock {
//    public static void main(String[] args) {
//        String host = "apria.cn";
////        String host = "127.0.0.1";
//        int port = 6300;
////        int port = 6379;
//
//        RedisTool redisTool = new RedisTool();
//        final Jedis jedis = new Jedis(host, port);
//        jedis.auth("Chenyahui&929");
//        jedis.set("k1", "aaa");
//        System.out.println(jedis.get("k1"));
//
//
//        for (int i = 0; i < 10; i++) {
//
//            final int finalI = i;
//            new Thread() {
//                @Override
//                public void run() {
//                    boolean b = RedisTool.tryGetDistributedLock(jedis, "lockkey_3", "a" + finalI, 10000);
//                    boolean b2 = false;
//                    if (b) {
//                        b2 = RedisTool.releaseDistributedLock(jedis, "lockkey_3", "a" + finalI);
//
//                    }
//                    System.out.println("获取锁 " + b + " 释放锁 " + b2);
//
//                }
//            }.start();
//
//        }
//
//    }
//
//}
