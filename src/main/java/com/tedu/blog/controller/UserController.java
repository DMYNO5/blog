package com.tedu.blog.controller;

import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.PageResult;
import com.tedu.blog.pojo.User;
import com.tedu.blog.service.UserService;
import com.tedu.blog.utils.CpachaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import com.tedu.blog.pojo.Result;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    //侯国萃   验证码
    @RequestMapping("/getImage")

    public Map<String, String> getImage(HttpServletRequest request) throws IOException {
        Map<String, String> result = new HashMap<>();
        CpachaUtil createImageCode = new CpachaUtil();
        // 获取验证码
        String securityCode = createImageCode.getCode();
        // 验证码存入session
        String key = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        request.getServletContext().setAttribute(key, securityCode);
        // 生成图片
        BufferedImage image = createImageCode.getBuffImg();
        //进行base64编码
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", bos);
        String string = Base64Utils.encodeToString(bos.toByteArray());
        result.put("key", key);
        result.put("image", string);
        return result;
    }

    //侯国萃  注册
    @RequestMapping("/register")
    public Result register(@RequestBody User user) {
        System.out.println(user);
        Result result = null;
        int isExist = userService.isExist(user);
        if (isExist == 0) {
            user.setCreatedTime(new Date());
            int row = userService.register(user);
            if (row >= 1) {//表示成功
                result = new Result(0, "注册成功");
            } else {
                result = new Result(1, "添加用户失败");
            }
        } else {
            result = new Result(2, "用户名已存在");
        }
        return result;
    }
}