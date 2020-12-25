package com.tedu.blog.controller;

import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.Comment;
import com.tedu.blog.pojo.Essay;
import com.tedu.blog.pojo.PageResult;
import com.tedu.blog.pojo.Result;
import com.tedu.blog.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
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
    public PageResult listAllEssay(Integer pageNum, Integer pageSize) {
        PageInfo pageInfo = essayService.selectPage(pageNum, pageSize);
        PageResult pageResult = new PageResult(0, "ok");
        pageResult.setPageInfo(pageInfo);
        return pageResult;
    }

    @RequestMapping("/selectByTitle")
    public PageResult selectByTitle(Integer pageNum, Integer pageSize, Essay essay) {
        PageInfo pageInfo = essayService.selectByTitle(1, 10, essay);
        PageResult pageResult = new PageResult(0, "ok");
        pageResult.setPageInfo(pageInfo);
        return pageResult;

    }

    @RequestMapping("/selectByEssay")
    public PageResult selectByEssay(Integer pageNum, Integer pageSize, Essay essay) {
        PageInfo pageInfo = essayService.selectByEssay(1, 10, essay);
        PageResult pageResult = new PageResult(0, "ok");
        pageResult.setPageInfo(pageInfo);
        return pageResult;
    }

    @RequestMapping("/selectByPower")
    public PageResult selectByPower(Integer pageNum, Integer pageSize, Essay essay) {
        PageInfo pageInfo = essayService.selectByPower(1, 10, essay);
        PageResult pageResult = new PageResult(0, "ok");
        pageResult.setPageInfo(pageInfo);
        return pageResult;
    }

    /**
     * 赵飞宇      新增文章的方法
     *
     * @param essay
     * @return result
     */
    @RequestMapping("/insertEssay")
    public Result insertEssay(Essay essay) {
        Result result = null;
        int hangshu = essayService.insertEssay(essay);
        if (hangshu > 0) {
            result = new Result(0, "成功添加一篇文章", essay);
        }
        if (hangshu == 0) {
            result = new Result(500, "添加失败");
        }
        return result;
    }

    /**
     * 赵飞宇      通过文章的id删除文章的方法
     *
     * @param essayId
     * @return result
     */
    @RequestMapping("/deleteById")
    public Result deleteById(Integer essayId) {
        Result result = null;
        int hangshu = essayService.deleteById(essayId);
        if (hangshu > 0) {
            result = new Result(0, "成功删除一篇文章", essayId);
        }
        if (hangshu == 0) {
            result = new Result(500, "删除失败");
        }

        return result;
    }


    /**
     * 赵飞宇      更新文章
     *
     * @param essay
     * @return result
     */
    @RequestMapping("updateEssay")
    public Result updateEssay(Essay essay) {
        Result result = null;
        int hangshu = essayService.update(essay);
        if (hangshu > 0) {
            result = new Result(0, "成功修改一篇文章", essay);
        }
        if (hangshu == 0) {
            result = new Result(500, "修改失败");
        }

        return result;
    }


    //贾旭业。根据essayId查出文章对象
    @RequestMapping("/selectEssayByEssayId")
    public Result selectByEssayId(Integer essayId) {
        Essay essay = essayService.selectEssayByEssayId(essayId);
        return new Result(0, "ok", essay);
    }


}
