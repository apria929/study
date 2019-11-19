package com.common.desinpattern.factorypattern;

import com.common.desinpattern.simpleFactory.Operation;

public class Client {

    public static void main(String[] args) throws Exception {

        // 使用反射机制实例化工厂对象，因为字符串是可以通过变量改变的
//        Factory addFactory = (Factory) Class.forName("org.zero01.factory.AddFactory").newInstance();
//        Factory subFactory=(Factory) Class.forName("org.zero01.factory.SubFactory").newInstance();
        Factory addFactory = new AddFactory();
        Factory subFactory = new SubFactory();

        // 通过工厂对象创建相应的实例对象
        Operation add = addFactory.createOperation();
        Operation sub = subFactory.createOperation();

        System.out.println(add.getResult(1, 1));
        System.out.println(sub.getResult(1, 1));
    }
}