package com.common.extendMeth;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/10/30
 * To change this template use File | Settings | File Templates.
 **/
public class Father extends Grandfather {
    @Override
    protected void say() {
        super.say();
        System.out.println("Father say");
    }
}
