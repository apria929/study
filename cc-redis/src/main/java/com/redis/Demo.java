package com.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/11/7
 * To change this template use File | Settings | File Templates.
 **/
public class Demo {
    public static void main(String[] args) {
        String s1 = RedisUtil.getJedis().set("k1", "v1");
        String s2 = RedisUtil.getJedis().get("k1");
        System.out.println(s1 + "     " + s2);
        String host = "192.168.0.106";
//        String host = "127.0.0.1";
//        int port = 6379;
//        Jedis jedis = new Jedis(host, port);
//        jedis.set("k1","aaa");
//        System.out.println(jedis.get("k1")); //PONG }

    }


    @Test
    public void contextLoads() {
        String host = "apria.cn";
//        String host = "127.0.0.1";
        int port = 6300;
        Jedis jedis = new Jedis(host, port);
        jedis.auth("Chenyahui&929");
        jedis.set("k1", "aaa");
        System.out.println(jedis.get("k1")); //PONG }

    }
}
