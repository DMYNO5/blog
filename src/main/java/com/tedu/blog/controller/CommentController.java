package com.tedu.blog.controller;

import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.Comment;
import com.tedu.blog.pojo.PageResult;
import com.tedu.blog.pojo.User;
import com.tedu.blog.pojo.Result;
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
    @RequestMapping("/insert")
    public Result insert(Comment comment){
        Integer userId = comment.getUserId();
        if(userId==null){
            return new Result(1,"请先登陆");
        }else{
            Integer i = commentService.insert(comment);
            if(i>=1){
                return new Result(0,"评论成功");
            }else {
                return new Result(1,"评论失败");
            }
        }
    }

}
