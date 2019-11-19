package com.common.baseType;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/11/3
 * To change this template use File | Settings | File Templates.
 **/
public class A {
    public A(String id) {
        this.id = id;
    }

    public A() {
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
//        return super.hashCode();
        return 123;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
