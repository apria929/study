package com.common.desinpattern.abstractFactory;

public class test_abstractFactory {
    public static void main(String[] args) {
        sqlFactory factory1 = new mysqlFactory();
        IUser userOperator = factory1.createUser();
        userOperator.getUser(1);
        userOperator.insert(new User());
    }
}