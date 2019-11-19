package com.common.extendMeth;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/10/30
 * To change this template use File | Settings | File Templates.
 **/
public class Son extends Father {
    @Override
    protected void say() {
        super.say();
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.say();
    }
}
