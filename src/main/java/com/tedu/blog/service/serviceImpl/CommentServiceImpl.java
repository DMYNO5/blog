package com.tedu.blog.service.serviceImpl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tedu.blog.mapper.CommentMapper;


import com.tedu.blog.pojo.Comment;
import com.tedu.blog.pojo.CommentExample;
import com.tedu.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public PageInfo<Comment> selectByComment(Integer pageNum, Integer pageSize, Comment comment) {
        PageHelper.startPage(pageNum,pageSize);
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        if (!StringUtils.isEmpty(comment.getcId())){
            criteria.andCIdEqualTo(comment.getcId());
        }
        if(!StringUtils.isEmpty(comment.getUserId())){
            criteria.andUserIdEqualTo(comment.getUserId());
        }
        if (!StringUtils.isEmpty(comment.getEssayId())) {
            criteria.andEssayIdEqualTo(comment.getEssayId());
        }
        List<Comment> commentList = commentMapper.selectByExample(commentExample);
        PageInfo pageInfo = new PageInfo(commentList);
        return pageInfo;
    }
}
