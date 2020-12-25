package com.tedu.blog.service;

import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.Label;
import com.tedu.blog.pojo.User;

public interface UserService {
    PageInfo<User> selectByUser(Integer pageNum, Integer pageSize, User user);

    public User selectUserByUserNameAndPassword(String username, String password);

    public User updateUser(Integer userId);

    int deleteByUserId(Integer userId);
}
