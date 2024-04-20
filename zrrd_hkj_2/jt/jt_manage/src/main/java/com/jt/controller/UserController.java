package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;

import com.jt.vo.PageResult;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ming
 * 时间 2023/8/6
 */
@RestController
@CrossOrigin
@RequestMapping("/user") //抽取公共的请求
public class UserController {

    @Autowired
    private UserService userService;
    /*
    * 1.url地址:/user/login
    * 2.请求参数: 用户表单对象的JSON串 post类型
    * 3.返回值结果 SysResult token?  有值 正确  null错误
    * */
    @PostMapping("/login")
    public SysResult login(@RequestBody User user){
        //String token = "123456";
        //return SysResult.success(token);
        //return SysResult.fail();
        String token = userService.findUserByUP(user);
        //判断字符串是否为空
        if (StringUtils.hasLength(token)){
            return SysResult.success(token);
        }else {
            return SysResult.fail();
        }
    }
    /*
    * 需求:进行分页查询
    * URl: /user/list
    * 请求参数: 使用PageResult对象接收
    * get
    * */
    @GetMapping("/list")
    public SysResult findUserByPage(PageResult pageResult){ //只有三个参数
        //携带所有数据返回
        pageResult = userService.findUserByPage(pageResult);
        return SysResult.success(pageResult);
    }
    /*
    * 更新状态信息
    * url:/user/status/{id}/{status}
    * 参数: id/status
    * 返回值:SysResult对象
    * */
    @PutMapping("/status/{id}/{status}")
    public SysResult updateStatus(User user){
        userService.updateStatus(user);
        return SysResult.success();
    }
    /*
    * 业务分析: 实现用户新增  注意密码加密
    * Url: /user/addUser
    * 请求参数 用户的form表单
    * 返回值 SysResult对象
    * */
    @PostMapping ("/addUser")
    public SysResult addUser(@RequestBody User user){
        userService.addUser(user);
        return SysResult.success();
    }
    /*
    * 删除用户
    * ajax说明:
    *       @RequestBody PUT/POST  要求ajax传递的对象 自己凤凰为json  所以在后端
    *       添加注解
    *       @get/delete  数据都是普通数据  后端正常接收就可以
    * */
    @DeleteMapping("/{id}")
    public SysResult deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
        return SysResult.success();
    }
}
