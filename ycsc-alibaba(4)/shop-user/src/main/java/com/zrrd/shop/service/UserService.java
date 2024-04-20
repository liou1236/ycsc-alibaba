package com.zrrd.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zrrd.shop.pojo.User;

/**
 * @author : Ming
 */
public interface UserService extends IService<User> {
    //执行登录验证的方法
    User login(String username,String password);
}
