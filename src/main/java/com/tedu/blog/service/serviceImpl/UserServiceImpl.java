package com.tedu.blog.service.serviceImpl;

import com.tedu.blog.mapper.UserMapper;
import com.tedu.blog.pojo.User;
import com.tedu.blog.pojo.UserExample;
import com.tedu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public User selectUserByUserNameAndPassword(String username, String password){
        UserExample example=new UserExample();
        UserExample.Criteria criteria = example.or();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        if(users.size()==1){
            User user = users.get(0);
            return user;
        }else {
            return null;
        }
    }


}
