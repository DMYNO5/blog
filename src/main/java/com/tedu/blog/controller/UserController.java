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
    public Result login(String code,String key,@RequestBody User user,HttpServletRequest request) {

        Result  result=new Result();
        System.out.println(code);
        //验证验证码
        String keyCode = (String)request.getServletContext().getAttribute(key);
        try {
            if(code.equalsIgnoreCase(keyCode)){
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
            else{
                throw new RuntimeException("验证码错误！！");
            }
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            result.setMsg(e.getMessage());
            result.setState(1);
        }
        return result;

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
            user.setPower(0);
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


