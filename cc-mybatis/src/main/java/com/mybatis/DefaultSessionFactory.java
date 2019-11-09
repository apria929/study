package com.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.io.IOException;
import java.io.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/11/7
 * To change this template use File | Settings | File Templates.
 **/
public class DefaultSessionFactory {
    public static Logger LOG = LoggerFactory.getLogger(DefaultSqlSessionFactory.class);
    private  final static SqlSessionFactory sqlSessionFactory;
    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("MysqlConfig.xml");
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    public  SqlSessionFactory  getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
