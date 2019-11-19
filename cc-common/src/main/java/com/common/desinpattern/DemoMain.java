package com.common.desinpattern;

import com.common.desinpattern.simpleFactory.Add;
import com.common.desinpattern.simpleFactory.Div;
import com.common.desinpattern.simpleFactory.Operation;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/10/28
 * To change this template use File | Settings | File Templates.
 **/
public class DemoMain {
    public static void main(String[] args) {
        Add add = new Add();
        add.getResult(1, 1);

        Operation operation = new Add();
        try {
            operation.getResult(1, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    private void demo(String type) {


    }


}
