package com.zhang.ssmschoolshop.service.impl;


import com.zhang.ssmschoolshop.dao.UserMapper;
import com.zhang.ssmschoolshop.entity.User;
import com.zhang.ssmschoolshop.entity.UserExample;
import com.zhang.ssmschoolshop.service.UserService;
import com.zhang.ssmschoolshop.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    /**
     * 如果是修改用户信息，这传来的对象中有id、username、email、telephone
     * 如果只是修改密码，则传来的只有id和psw
     * 所以需要将不全的字段信息补全，要么补全psw要么补全其他三个字段，id不用补全，一定会传递过来
     * @param user vi对象
     * @return 状态码
     */
    @Override
    public String updateUser(User user) {
        if(user == null){
            return "9999";
        }
        if(user.getUserid() == null){
            return "9000";
        }
        User userFromDBById = userMapper.selectByPrimaryKey(user.getUserid());
        // 如果点击的是修改用户，则传来的对象中密码字段是空的，所以根据传来的对象中密码字段是否为空判断是在修改用户信息还是在修改用户密码
        // 如果传来的对象中密码不是空的，则是修改密码
        if(!StringUtils.isEmpty(user.getPassword())){
            // 修改密码时需要设置的参数
            user.setUsername(user.getUsername());
            user.setEmail(userFromDBById.getEmail());
            user.setTelephone(userFromDBById.getTelephone());
        }else{
            // 修改用户信息时需要的传递密码
            user.setPassword(userFromDBById.getPassword());
        }
        user.setRegtime(userFromDBById.getRegtime());
        userMapper.updateByPrimaryKey(user);
        return "0000";
    }


}
