package com.tedu.blog.controller;

import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.Category;
import com.tedu.blog.pojo.Collection;
import com.tedu.blog.pojo.PageResult;
import com.tedu.blog.pojo.Result;
import com.tedu.blog.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/collection")
public class CollectionController {
    @Autowired
    CollectionService collectionService;

    @RequestMapping("/selectByCollection")
    public PageResult selectByCollection(Integer pageNum, Integer pageSize, Collection collection) {
        PageInfo pageInfo = collectionService.selectByCollection(1, 10, collection);
        PageResult pageResult = new PageResult(0, "ok");
        pageResult.setPageInfo(pageInfo);
        return pageResult;
    }

    //贾旭业/提交收藏/（需登陆校验）
    @RequestMapping("/insert")
    public Result insert(Collection collection) {
        if (collection.getUserId() != null) {
            Integer i = collectionService.insert(collection);
            if (i == 1) {
                return new Result(0, "收藏成功");
            } else {
                return new Result(1, "收藏失败");
            }
        } else {
            return new Result(1, "请先登陆");
        }
    }

    //删除收藏
    @RequestMapping("/deleteByColId")
    public Result deleteByColId(Integer colId) {
        int row = collectionService.deleteByColId(colId);
        if (row >= 1) {
            return new Result(0, "ok");
        }
        return new Result(1, "删除失败");
    }
}
