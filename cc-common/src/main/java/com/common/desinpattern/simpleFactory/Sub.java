package com.common.desinpattern.simpleFactory;

public class Sub implements Operation {

    // 减法计算
    public double getResult(double numberA, double numberB) {
        return numberA - numberB;
    }
}