//package com.zrrd.proxy;
//
//import com.zrrd.service.UserService;
//
//public class UserServiceStaticProxy implements UserService {
//private UserService userService;
//
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public String save(String name) {
//        System.out.println("开启事务，提交事务   回滚事务");
//userService.save(name);
//        return name;
//    }
//}
