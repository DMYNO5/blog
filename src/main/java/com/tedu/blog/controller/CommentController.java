package com.tedu.blog.controller;

import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.Comment;
import com.tedu.blog.pojo.PageResult;
import com.tedu.blog.pojo.User;
import com.tedu.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @RequestMapping("/selectByComment")
    public PageResult selectByComment(Integer pageNum, Integer pageSize, Comment comment){
        PageInfo pageInfo = commentService.selectByComment(1,10,comment);
        PageResult pageResult = new PageResult(0,"ok");
        pageResult.setPageInfo(pageInfo);
        return pageResult;
    }
}
