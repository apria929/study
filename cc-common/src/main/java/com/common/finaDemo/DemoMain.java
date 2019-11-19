package com.common.finaDemo;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/10/30
 * To change this template use File | Settings | File Templates.
 **/
public class DemoMain {
    private final static String ID = "1";
    private final String name = "lily";
    private final ArrayList<String> ary1 = new ArrayList<String>();

    void say() {
    }

    public static void main(String[] args) {
        DemoMain demoMain = new DemoMain();
        demoMain.ary1.add("a");
//        demoMain.ary1=new ArrayList<>();
        System.out.println(demoMain.ary1);

    }
}
