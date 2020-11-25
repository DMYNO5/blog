package com.tedu.blog.service.serviceImpl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tedu.blog.mapper.UserMapper;
import com.tedu.blog.pojo.Result;
import com.tedu.blog.pojo.User;
import com.tedu.blog.pojo.UserExample;
import com.tedu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    UserMapper userMapper;

    @Override
    public PageInfo<User> selectByUser(Integer pageNum, Integer pageSize, User user) {
        PageHelper.startPage(pageNum,pageSize);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        if(!StringUtils.isEmpty(user.getUserId())){
            criteria.andUserIdEqualTo(user.getUserId());
        }
        if(!StringUtils.isEmpty(user.getUsername())){
            criteria.andUsernameEqualTo(user.getUsername());
        }
        if(!StringUtils.isEmpty(user.getEmail())){
            criteria.andEmailEqualTo(user.getEmail());
        }
        if(!StringUtils.isEmpty(user.getPower())){
            criteria.andPowerEqualTo(user.getPower());
        }
        List<User> userList = userMapper.selectByExample(userExample);
        PageInfo pageInfo =new PageInfo(userList);
        return pageInfo;
    }

    //贾旭业
    @Override
    public User selectUserByUserNameAndPassword(String username, String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.or();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        if (users.size() == 1) {
            User user = users.get(0);
            return user;
        } else {
            return null;
        }
    }

    @Override
    public Integer updateUserById(Integer userId, String newName, String newPhone, String newEmail) {
        User user = userMapper.selectByPrimaryKey(userId);
        if(!(newName.equals(user.getUsername())&newPhone.equals(user.getPhone())&newEmail.equals(user.getEmail()))){
            user.setUsername(newName);
            user.setPhone(newPhone);
            user.setEmail(newEmail);
        }
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public Integer updatePw(Integer userId, String newPw) {
        User user = userMapper.selectByPrimaryKey(userId);
        if(!newPw.equals(user.getPassword())){
            user.setPassword(newPw);
        }
        return userMapper.updateByPrimaryKey(user);
    }


}
