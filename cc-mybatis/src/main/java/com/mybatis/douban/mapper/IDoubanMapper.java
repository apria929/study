package com.mybatis.douban.mapper;

import com.model.douban.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: yahui
 * Date: 2018/7/24
 * To change this template use File | Settings | File Templates.
 **/
public interface IDoubanMapper {

    // comment
    public List<Comment> getCommentByPageLimitBookId(@Param(value = "start") int start, @Param(value = "limit") int limit, @Param(value = "bookId") String bookId);


}
