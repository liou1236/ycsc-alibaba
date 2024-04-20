package com.zrrd.controller;

import com.zrrd.pojo.User;
import com.zrrd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/userAjax")
    public String userAjax(){
        return "userAjax";
    }
    @RequestMapping("/findAjaxUser")
    @ResponseBody
    public List<User> findAjaxUser(){
        return userService.findAll();
    }

    @RequestMapping("/userList")
    public String userList(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("userList",users);
        return "userList";
    }
    /*
    利用RestFul实现用户数据新增
    新增之后需要重定向到userList.html页面
    url:/user/tom/18/男
    优化策略：
        1、多个参数提交采用对象接受
        2、参数名与属性名一致
     */
    @RequestMapping("/user/{name}/{age}/{sex}")
    public String insertUser(User user){
        userService.insertUser(user);
        return "redirect:/userList";
    }

    @RequestMapping("/user/{id}/{name}")
    public String modifyUser(User user){
        userService.updateUser(user);
        return "redirect:/userList";
    }
    @RequestMapping("/user/{id}")
    public String deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
        return "redirect:/userList";
    }
    @RequestMapping("/demo")
    @ResponseBody
    public String demo(){
        return "框架整合初步完成";
    }
}
