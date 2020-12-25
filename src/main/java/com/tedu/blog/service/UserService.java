package com.tedu.blog.service;

import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.Label;
import com.tedu.blog.pojo.User;

public interface UserService {
     PageInfo<User> selectByUser(Integer pageNum,Integer pageSize,User user);

     public User selectUserByUserNameAndPassword(String username, String password);
     public Integer updateUserById(Integer userId, String newName, String newPhone, String newEmail);
     public Integer updatePw(Integer userId,String newPw);

     public User updateUser(Integer userId);
     public int register(User user);
     public int isExist(User user);
     int deleteByUserId(Integer userId);
}
