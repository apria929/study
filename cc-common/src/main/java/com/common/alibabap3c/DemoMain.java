package com.common.alibabap3c;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/10/31
 * To change this template use File | Settings | File Templates.
 **/
public class DemoMain {
    public static void main(String[] args) {

    }


    @Test
    public void sayHello() {
        System.out.println("junit");
    }

    @Test
    public void BigDecimal() {
       BigDecimal g = new BigDecimal(0.1f);
        BigDecimal recommend1 = new BigDecimal("0.1");
        BigDecimal recommend2 = BigDecimal.valueOf(0.1);
        System.out.println(g);
    }

    @Test
    public void Hashmap() {
        HashMap map=new HashMap();

        System.out.println("junit");
    }


}
