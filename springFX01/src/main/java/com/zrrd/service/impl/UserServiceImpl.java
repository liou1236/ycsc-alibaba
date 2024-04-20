package com.zrrd.service.impl;

import com.zrrd.dao.UserDao;
import com.zrrd.dao.impl.UserDaoImpl;
import com.zrrd.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public void setUserDao(UserDaoImpl userDao){
        this.userDao = userDao;
    }
    @Override
    public String save(String name) {
        System.out.println("处理业务，调用dao");
//        userDao.save(name);
        return "qwer";
    }

}
