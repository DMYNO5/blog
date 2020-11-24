package com.tedu.blog.mapper;

import com.tedu.blog.pojo.Comment;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CommentMapper2 {
    public List<Comment> selectCommentsByEssayId2(Integer essayId);
}
