package com.spring;

public class InjectionServiceImpl implements InjectionService {
    private InjectionDao injectionDao;
    //设值注入
    public void setInjectionDao(InjectionDao injectionDao) {
        this.injectionDao = injectionDao;
    }
    public void save(String arg) {
        System.out.println("service接受："+arg);
        arg=arg+":"+this.hashCode();
        injectionDao.save(arg);
    }
}
