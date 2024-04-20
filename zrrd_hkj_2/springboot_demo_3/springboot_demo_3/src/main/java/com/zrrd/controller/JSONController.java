package com.zrrd.controller;

import com.zrrd.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController// @Controller+@ResponseBody
//@Controller
public class JSONController {
    /*
    跟据getJSON请求 获取User对象的JSON数据
    如果需要返回JSON数据 则使用主句@ResponseBody
    知识点讲解：
    返回对象后 SpringMVC通过内部API（objectMapper）调用对象的getxx()方法 动态的获取属性和属性值
     */
    @RequestMapping("/getJSON")
//    @ResponseBody
    public User getJSON(){
        User user = new User();
        user.setName("JSON测试").setId(1000);
        return user;//不需要执行视图解析器
    }
}
