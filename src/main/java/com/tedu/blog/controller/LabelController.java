package com.tedu.blog.controller;

import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.Label;
import com.tedu.blog.pojo.PageResult;
import com.tedu.blog.pojo.Result;
import com.tedu.blog.service.serviceImpl.LabelServiceImpl;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/blog/label")
public class LabelController {

    @Autowired(required = false)
    LabelServiceImpl labelServiceImpl;


    //添加标签
    @RequestMapping("/insertLabel")
    public Result insertLabel(Label label) {
        int row = labelServiceImpl.insertLabel(label);
        if (row >= 1) {
            return new Result(0, "ok");
        }
        return new Result(1, "添加失败");
    }

    //查看全部标签
    @RequestMapping("/listAllLabel")
    public PageResult ListAllLabel(Integer pageNum, Integer pageSize) {
        PageInfo pageInfo = labelServiceImpl.listAllLabel(pageNum, pageSize);
        PageResult pageResult = new PageResult(0, "ok");
        pageResult.setPageInfo(pageInfo);
        return pageResult;
    }

    //修改标签
    @RequestMapping("/updateLabel")
    public Result updateLabel(Label label) {
        int row = labelServiceImpl.updateLabel(label);
        if (row >= 1) {
            return new Result(0, "ok");
        }
        return new Result(1, "修改失败");
    }

    //删除标签
    @RequestMapping("/deleteById")
    public Result deleteById(Integer labelId) {
        int row = labelServiceImpl.deleteById(labelId);
        if (row >= 1) {
            return new Result(0, "ok");
        }
        return new Result(1, "删除失败");
    }

    //根据label查找标签
    @RequestMapping("/selectByLabel")
    public PageResult selectByLabel(Label label, Integer pageNum, Integer pageSize) {
        PageInfo pageInfo = labelServiceImpl.selectByLabel(label, pageNum, pageSize);
        PageResult pageResult = new PageResult(0, "ok");
        pageResult.setPageInfo(pageInfo);
        return pageResult;
    }


}
