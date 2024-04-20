package com.zrrd.shop.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.zrrd.shop.pojo.User;

public interface UserService extends IService<User> {
    User login(String username, String password);
}
