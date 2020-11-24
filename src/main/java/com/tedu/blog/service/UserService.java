package com.tedu.blog.service;

import com.github.pagehelper.PageInfo;
import com.tedu.blog.pojo.User;

public interface UserService {
     PageInfo<User> selectByUser(Integer pageNum,Integer pageSize,User user);
}
