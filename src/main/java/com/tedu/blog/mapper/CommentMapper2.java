package com.tedu.blog.mapper;

import com.tedu.blog.pojo.Comment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface CommentMapper2 {
    public List<Comment> selectCommentsByEssayId2(Integer essayId);
}
