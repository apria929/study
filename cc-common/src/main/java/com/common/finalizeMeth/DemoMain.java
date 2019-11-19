package com.common.finalizeMeth;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/10/30
 * To change this template use File | Settings | File Templates.
 **/
public class DemoMain {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize demo ");
    }

    public static void main(String[] args) {
        DemoMain demoMain = new DemoMain();
        System.gc();

    }
}
