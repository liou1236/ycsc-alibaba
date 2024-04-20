package com.zrrd.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zrrd.shop.dao.UserMapper;
import com.zrrd.shop.pojo.User;
import com.zrrd.shop.service.UserService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * @author : Ming
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Override
    public User login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        //因为用户需要保证唯一性 所以用户名为条件至多能查出一条记录
        User user = baseMapper.selectOne(queryWrapper);
        //判断用户名是否正确 使用spring的工具类来检查密码是否正确
        //password是用户填写的密码明文:123456
        //user.getPassword()  查到的加密后的密码
        if (user != null && BCrypt.checkpw(password,user.getPassword())){
            return user;
        }

        return null;  //用户名或密码错误都返回 null
    }
}
