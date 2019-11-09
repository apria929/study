package com.common.desinpattern.abstractFactory;

public class oracleFactory implements sqlFactory {
    @Override
    public IUser createUser() {
        return new oracleUser();   //访问oracle中User表的对象
    }
}