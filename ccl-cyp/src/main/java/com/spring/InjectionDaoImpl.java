package com.spring;

public class InjectionDaoImpl implements  InjectionDao{
    public void save(String arg) {
        System.out.println("保存数据："+arg);
    }
}
