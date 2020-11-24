package com.tedu.blog.controller;

import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.Collection;
import com.tedu.blog.pojo.PageResult;
import com.tedu.blog.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/collection")
public class CollectionController {
    @Autowired
    CollectionService collectionService;
    @RequestMapping("/selectByCollection")
    public PageResult selectByCollection(Integer pageNum, Integer pageSize, Collection collection){
        PageInfo pageInfo = collectionService.selectByCollection(1,10,collection);
        PageResult pageResult = new PageResult(0,"ok");
        pageResult.setPageInfo(pageInfo);
        return pageResult;
    }
}
