package com.tedu.blog.service.serviceImpl;

import com.tedu.blog.mapper.CommentMapper;
import com.tedu.blog.mapper.CommentMapper2;
import com.tedu.blog.pojo.Comment;
import com.tedu.blog.pojo.CommentExample;
import com.tedu.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    CommentMapper2 commentMapper2;

    //贾旭业。根据essayId查出评论对象的list集合
    public List<Comment> selectCommentsByEssayId(Integer essayId){
        CommentExample example=new CommentExample();
        CommentExample.Criteria criteria=example.or();
        criteria.andEssayIdEqualTo(essayId);
        List<Comment> ListComment = commentMapper.selectByExample(example);
        return ListComment;
    }

    //贾旭业。根据essayId查出评论对象的list集合//两表联查
    public List<Comment> selectCommentsByEssayId2(Integer essayId){
        List<Comment> commentList = commentMapper2.selectCommentsByEssayId2(essayId);
        return commentList;
    }

    //贾旭业。向评论表插入一条评论
    public Integer insert(Comment comment){
        Date date=new Date();
        comment.setCreatedTime(date);
        Integer i = commentMapper.insert(comment);
        return i;
    }

}
