package com.zrrd.controller;

import com.zrrd.pojo.User;
import com.zrrd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AxiosUserController {
    @Autowired
    private UserService userService;
    @GetMapping("/axiosUser/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }
/*
实现更新操作
URL：http//localhost:8090/axiosUser/updateUser
参数：user无对象的json串
无返回值
 */
    @PutMapping("axiosUser/updateUser")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }
    /*
    实现删除操作
    url:http://localhost:8090/axiosUser/deleteUser?id=1
    参数：id=1
    返回值 无
     */
    @DeleteMapping("/axiosUser/deleteUser")
    public void deleteUser(Integer id){
        userService.deleteUserById(id);
    }
}
