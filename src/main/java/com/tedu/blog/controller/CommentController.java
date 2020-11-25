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

import java.util.List;


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

    //贾旭业 /插入一条评论（校验登陆）
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

    //贾旭业。根据essayId查出评论对象的list集合
    @RequestMapping("/selectCommentsByEssayId")
    public Result selectCommentsByEssayId(Integer essayId){
        List<Comment> listComment = commentService.selectCommentsByEssayId(essayId);
        return new Result(0,"ok",listComment);
    }


    //贾旭业。根据essayId查出评论对象的list集合(关联user表)
    @RequestMapping("/selectCommentsByEssayId2")
    public Result selectCommentsByEssayId2(Integer essayId){
        List<Comment> commentList = commentService.selectCommentsByEssayId2(essayId);
        return new Result(0,"ok",commentList);
    }
}
