package com.common;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/10/28
 * To change this template use File | Settings | File Templates.
 **/
public class Demo {
    static  int amount=100;
    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(){
                @Override
                public void run() {
                    amount-=50;
                    System.out.println("取钱 50元");
                }
            }.start();

            new Thread(){
                @Override
                public void run() {
                    amount+=50;
                    System.out.println("存钱 50元");
                }
            }.start();

            System.out.println(i+ " 现在还剩 "+amount);
//            try {
//                Thread.sleep(100);
//                System.out.println(i+ " 现在还剩222 "+amount);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }


        }
        }


}
