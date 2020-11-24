package com.tedu.blog.service;


import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.Comment;


public interface CommentService {
    PageInfo<Comment> selectByComment(Integer pageNum, Integer pageSize, Comment comment);
    public Integer insert(Comment comment);

}
