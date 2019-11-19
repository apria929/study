package com.common.desinpattern.factorypattern;

import com.common.desinpattern.simpleFactory.Add;
import com.common.desinpattern.simpleFactory.Operation;
import com.common.desinpattern.simpleFactory.Sub;

// 加法类工厂
public class AddFactory implements Factory {

    public Operation createOperation() {
        System.out.println("加法运算");
        return new Add();
    }
}
 
