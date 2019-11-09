package com.mybatis.douban.dao;


import com.model.douban.Comment;
import com.mybatis.DefaultSessionFactory;
import com.mybatis.douban.mapper.IDoubanMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2018/7/24
 * To change this template use File | Settings | File Templates.
 **/
public class DoubanDao implements IDoubanMapper {
  private  DefaultSessionFactory defaultSessionFactory=new DefaultSessionFactory();

    public List<Comment> getCommentByPageLimitBookId(int start, int limit, String bookId) {
        SqlSessionFactory sessionFactory = defaultSessionFactory.getSqlSessionFactory();
        SqlSession session=null;
        try {
            session=sessionFactory.openSession();
            IDoubanMapper mapper=session.getMapper(IDoubanMapper.class);
            List<Comment> comments=mapper.getCommentByPageLimitBookId(start,limit,bookId);
            session.commit();
            return comments;
        }catch (Exception e){
            e.printStackTrace();
            if (session!=null){
                session.rollback();
            }
        }finally {
            session.clearCache();
            session.close();
        }
        return null;
    }

//
//    public List<Comment> getCommentByPageLimitBookId(int start, int limit, String bookId) {
//        SqlSessionFactory sessionFactory = defaultSessionFactory.getSqlSessionFactory();
//        SqlSession session=null;
//        try {
//            session=sessionFactory.openSession();
//            IDoubanMapper mapper=session.getMapper(IDoubanMapper.class);
//            List<Comment> comments=mapper.getCommentByPageLimitBookId(start,limit,bookId);
//            session.commit();
//            return comments;
//        }catch (Exception e){
//            e.printStackTrace();
//            if (session!=null){
//                session.rollback();
//            }
//        }finally {
//            session.clearCache();
//            session.close();
//        }
//        return null;
//    }


}
