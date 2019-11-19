package com.common.desinpattern.abstractFactory;

public class mysqlFactory implements sqlFactory {
    @Override
    public IUser createUser() {
        return new mysqlUser();  //访问mysql中User表的对象
    }
}