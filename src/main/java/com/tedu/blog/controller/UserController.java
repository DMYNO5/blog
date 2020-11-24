package com.tedu.blog.controller;

import com.tedu.blog.pojo.Result;
import com.tedu.blog.pojo.User;
import com.tedu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestBody User user){
        System.out.println(user);
        String username = user.getUsername();
        String password = user.getPassword();
        User userDao = userService.selectUserByUserNameAndPassword(username, password);
        if(userDao!=null){
            System.out.println(userDao);
            return new Result(0,"登陆成功",userDao);
        }else{
            return new Result(1,"用户名或密码不正确");
        }
    }
}
