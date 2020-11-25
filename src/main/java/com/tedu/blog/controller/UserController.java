package com.tedu.blog.controller;

import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.PageResult;
import com.tedu.blog.pojo.User;
import com.tedu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tedu.blog.pojo.Result;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/selectByUser")
    public PageResult selectByUser(Integer pageNum, Integer pageSize, User user) {
        PageInfo pageInfo = userService.selectByUser(1, 10, user);
        PageResult pageResult = new PageResult(0, "ok");
        pageResult.setPageInfo(pageInfo);
        return pageResult;
    }

    //贾旭业 //登陆验证，需post传入user对象
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User user) {
        System.out.println(user);
        String username = user.getUsername();
        String password = user.getPassword();
        User userDao = userService.selectUserByUserNameAndPassword(username, password);
        if (userDao != null) {
            System.out.println(userDao);
            return new Result(0, "登陆成功", userDao);
        } else {
            return new Result(1, "用户名或密码不正确");
        }

    }

    @RequestMapping("/updateUser")
    public Result updateUser(Integer userId,String newName,String newPhone,String newEmail){
        int row = userService.updateUserById(userId,newName,newPhone,newEmail);
        if(row>=1){
            return new Result(0,"修改成功");
        }
            return  new Result(1,"修改失败");
    }

    @RequestMapping("/updatePw")
    public Result updatePw(Integer userId,String newPw){
        int row = userService.updatePw(userId,newPw);
        if(row>=1){
            return new Result(0,"修改成功");
        }
        return  new Result(1,"修改失败");
    }
}
