package com.common.desinpattern.abstractFactory;

public interface sqlFactory {
    public IUser createUser();     //用于访问User表的对象
}