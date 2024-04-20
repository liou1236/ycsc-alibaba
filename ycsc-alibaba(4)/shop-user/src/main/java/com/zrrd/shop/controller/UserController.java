package com.zrrd.shop.controller;

import com.zrrd.shop.pojo.User;
import com.zrrd.shop.service.UserService;
import com.zrrd.shop.util.JwtUtil;
import com.zrrd.shop.util.ResponseResult;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Ming
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public ResponseResult login(String username,String password){
        User user = userService.login(username,password);//完成登录的校验
        if (user == null){
            return new ResponseResult(401,"登录失败,用户名或者密码错误");
        }else {
            //登录成功生成jwt 并返回
            Map<String,String> data = new HashMap<>();
            data.put("tokenType","Bearer");
            data.put("token", JwtUtil.create(
                    3 * 60 * 60 * 1000,
                    user.getUid().toString(),
                    user.getUsername()));
            return new ResponseResult(200,"登录成功",data);
        }
    }
}
