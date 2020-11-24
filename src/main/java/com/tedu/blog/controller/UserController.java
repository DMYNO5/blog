package com.tedu.blog.controller;

import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.Essay;
import com.tedu.blog.pojo.PageResult;
import com.tedu.blog.pojo.User;
import com.tedu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/selectByUser")
    public PageResult selectByUser(Integer pageNum, Integer pageSize, User user){
        PageInfo pageInfo = userService.selectByUser(1,10,user);
        PageResult pageResult = new PageResult(0,"ok");
        pageResult.setPageInfo(pageInfo);
        return pageResult;
    }
}
