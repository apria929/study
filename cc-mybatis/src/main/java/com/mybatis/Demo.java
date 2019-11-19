package com.mybatis;

import com.model.douban.Comment;
import com.mybatis.douban.dao.DoubanDao;
import com.mybatis.douban.mapper.IDoubanMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2019/11/7
 * To change this template use File | Settings | File Templates.
 **/
public class Demo {
    public static void main(String[] args) {

        IDoubanMapper mapper = new DoubanDao();
        List<Comment> comments = mapper.getCommentByPageLimitBookId(1, 2, "10451990");
        System.out.println();

    }


}
