package com.demo.service;

import com.demo.dao.UserDao;
import com.demo.pojo.User;

public class UserService {
    public boolean login(String username, String password) {

        //调用Dao完成对数据库的操作

        UserDao userDao = new UserDao();

        try{
           User user= userDao.login(username,password);
            if (user==null){
                return false;
            }else {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
