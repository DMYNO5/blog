package com.tedu.blog.service;

import com.tedu.blog.pojo.Comment;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface CommentService {
    public List<Comment> selectCommentsByEssayId(Integer essayId);
    public List<Comment> selectCommentsByEssayId2(Integer essayId);
    public Integer insert(Comment comment);
    PageInfo<Comment> selectByComment(Integer pageNum, Integer pageSize, Comment comment);
    public Integer delete(Integer cId);

    int deleteByCId(Integer cId);
}
