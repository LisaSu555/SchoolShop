package com.zhang.ssmschoolshop.service.impl;


import com.zhang.ssmschoolshop.dao.UserMapper;
import com.zhang.ssmschoolshop.entity.User;
import com.zhang.ssmschoolshop.entity.UserExample;
import com.zhang.ssmschoolshop.service.UserService;
import com.zhang.ssmschoolshop.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(int userId) {
        return  userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> selectByExample(UserExample userExample) {
        return userMapper.selectByExample(userExample);
    }

    @Override
    public void insertSelective(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public void deleteUserById(Integer userid) {
        userMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public void updateByPrimaryKeySelective(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void saveUser(User user) {
        String pswd = "123456";
        String pswdMD5 = Md5Util.MD5Encode(pswd, "utf-8");
        user.setRegtime(new Date());
        user.setPassword(pswdMD5);
        userMapper.insert(user);
    }

    @Override
    public String updateUser(User user) {
        if(user == null){
            return "9999";
        }
        if(user.getUserid() == null){
            return "9000";
        }
        User userFromDBById = userMapper.selectByPrimaryKey(user.getUserid());
        user.setPassword(userFromDBById.getPassword());
        user.setRegtime(userFromDBById.getRegtime());
        userMapper.updateByPrimaryKey(user);
        return "0000";
    }


}
