package com.tedu.blog.service.serviceImpl;

import com.tedu.blog.mapper.CommentMapper;
import com.tedu.blog.pojo.Comment;
import com.tedu.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Override
    public Integer insert(Comment comment) {
        Integer i = commentMapper.insert(comment);
        return i;
    }
}
