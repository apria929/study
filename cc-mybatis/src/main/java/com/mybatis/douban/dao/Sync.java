package com.mybatis.douban.dao;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/11/10
 * To change this template use File | Settings | File Templates.
 **/
public class Sync {
    Test test = new Test();

    synchronized void sync() {
        try {
            String sql_select = "select amount from t_amount for update";

            int i = Test.select(sql_select);
            System.out.println(Thread.currentThread().getName() + " 当前库存 " + i);
            if (i >= 1) {
                String sql_update = " update t_amount set amount=" + (i - 1) + " where AID='1'";
                test.update(sql_update);
                System.out.println(Thread.currentThread().getName() + " 下单成功 ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
