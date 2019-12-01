package com.service.redisLock;

import com.common.utils.IdGenerator;
import com.redis2.RedisTool;
import redis.clients.jedis.Jedis;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/11/12
 * To change this template use File | Settings | File Templates.
 **/
public class RedisIncr {
    public static void main(String[] args) {
        String host = "apria.cn";
//        String host = "127.0.0.1";
        int port = 6300;
//        int port = 6379;

        RedisTool redisTool = new RedisTool();
        final Jedis jedis = new Jedis(host, port);
        jedis.auth("Chenyahui&929");
        jedis.set("k1", "aaa");
        System.out.println(jedis.get("k1"));

        for (int i = 0; i < 100; i++) {
            final int finalI = i;
            new Thread() {
                @Override
                public void run() {
                    Long value = jedis.incr("key1");
                    if (true) {
                        /**
                         * 还有库存，在redis中 建立订单
                         * */
                        long orderid = IdGenerator.getInstance(Thread.currentThread().getId()).getId();
                        jedis.zadd("order:map:zadd", 1, orderid + "");

                    }


                }
            }.start();

        }

    }

}
