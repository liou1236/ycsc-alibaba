package com.zrrd.controller;

import com.zrrd.User;
import com.zrrd.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    //会去到注册中心寻找userService实例，以及所提供的服务
    @Reference(timeout = 3000)
    private UserService userService;
    @RequestMapping("/test")
    public String test(){
        userService.insert();
        return "远程调用";
    }
    @RequestMapping("/getUser")
    public User getUserById(){
        return userService.getUserById(1);
    }
}
