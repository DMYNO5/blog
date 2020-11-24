package com.tedu.blog.mapper;

import com.tedu.blog.pojo.Comment;

import java.util.List;

public interface CommentMapper2 {
    public List<Comment> selectCommentsByEssayId2(Integer essayId);
}
