package com.zrrd.dao.impl;

import com.zrrd.dao.UserDao;

public class UserDaoImpl implements UserDao {


    @Override
    public void save(String a) {
        System.out.println("我保存了" + a);
    }
}
