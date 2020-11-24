package com.tedu.blog.service;

import com.tedu.blog.pojo.User;

public interface UserService {
    public User selectUserByUserNameAndPassword(String username, String password);
}
