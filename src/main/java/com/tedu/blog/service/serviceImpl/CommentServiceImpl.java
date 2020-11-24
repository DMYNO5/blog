package com.tedu.blog.service.serviceImpl;

import com.tedu.blog.mapper.CommentMapper;
import com.tedu.blog.mapper.CommentMapper2;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.Comment;
import com.tedu.blog.pojo.CommentExample;
import com.tedu.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import org.springframework.util.StringUtils;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

<<<<<<< HEAD
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

    @Override
    public PageInfo<Comment> selectByComment(Integer pageNum, Integer pageSize, Comment comment) {
        PageHelper.startPage(pageNum, pageSize);
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        if (!StringUtils.isEmpty(comment.getcId())) {
            criteria.andCIdEqualTo(comment.getcId());
        }
        if (!StringUtils.isEmpty(comment.getUserId())) {
            criteria.andUserIdEqualTo(comment.getUserId());
        }
        if (!StringUtils.isEmpty(comment.getEssayId())) {
            criteria.andEssayIdEqualTo(comment.getEssayId());
        }
        List<Comment> commentList = commentMapper.selectByExample(commentExample);
        PageInfo pageInfo = new PageInfo(commentList);
        return pageInfo;
    }
    @Override
    public Integer insert(Comment comment) {
        Integer i = commentMapper.insert(comment);
        return i;

    }
}
