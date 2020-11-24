package com.tedu.blog.controller;

import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.Comment;
import com.tedu.blog.pojo.Essay;
import com.tedu.blog.pojo.PageResult;
import com.tedu.blog.pojo.Result;
import com.tedu.blog.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/essay")
public class EssayController {

    @Autowired
    EssayService essayService;

    @RequestMapping("/listAllEssay")
    public PageResult listAllEssay(Integer pageNum, Integer pageSize){
        PageInfo pageInfo = essayService.selectPage(pageNum, pageSize);
        PageResult pageResult = new PageResult(0,"ok");
        pageResult.setPageInfo(pageInfo);
        return pageResult;
    }

    @RequestMapping("/selectByTitle")
    public PageResult selectByTitle(Integer pageNum, Integer pageSize, Essay essay){
        PageInfo pageInfo = essayService.selectByTitle(1, 10, essay);
        PageResult pageResult = new PageResult(0,"ok");
        pageResult.setPageInfo(pageInfo);
        return pageResult;

    }
    @RequestMapping("selectByEssay")
    public PageResult selectByEssay(Integer pageNum,Integer pageSize,Essay essay){
        PageInfo pageInfo = essayService.selectByEssay(1,10,essay);
        PageResult pageResult = new PageResult(0,"ok");
        pageResult.setPageInfo(pageInfo);
        return pageResult;
    }

    //贾旭业。根据essayId查出文章对象
    @RequestMapping("/selectEssayByEssayId")
    public Result selectByEssayId(Integer essayId){
        Essay essay = essayService.selectEssayByEssayId(essayId);
        return new Result(0,"ok",essay);
    }

    //贾旭业。根据essayId查出评论对象的list集合
    @RequestMapping("/selectCommentsByEssayId")
    public Result selectCommentsByEssayId(Integer essayId){
        List<Comment> listComment = essayService.selectCommentsByEssayId(essayId);
        return new Result(0,"ok",listComment);
    }


    //贾旭业。根据essayId查出评论对象的list集合(关联user表)
    @RequestMapping("/selectCommentsByEssayId2")
    public Result selectCommentsByEssayId2(Integer essayId){
        List<Comment> commentList = essayService.selectCommentsByEssayId2(essayId);
        return new Result(0,"ok",commentList);
    }
}
