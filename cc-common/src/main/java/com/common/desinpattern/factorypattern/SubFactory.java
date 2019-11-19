package com.common.desinpattern.factorypattern;

import com.common.desinpattern.simpleFactory.Operation;
import com.common.desinpattern.simpleFactory.Sub;

// 减法类工厂
public class SubFactory implements Factory {

    public Operation createOperation() {
        System.out.println("减法运算");
        return new Sub();
    }
}
