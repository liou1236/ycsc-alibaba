package com.zrrd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//1、将该类交给Spring容器管理2、同时开启SpringMVC机制
public class HelloController {
    //需求：http://localhost:8090/hello  访问hello.html
    //实现步骤：1、拦截用户请求@RequestMapping("/hello")
    //         2、String类型的返回值 表示返回页面名称
    //         3、根据yml配置文件中的内容 动态拼接前缀后后缀 形成页面唯一路径
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
