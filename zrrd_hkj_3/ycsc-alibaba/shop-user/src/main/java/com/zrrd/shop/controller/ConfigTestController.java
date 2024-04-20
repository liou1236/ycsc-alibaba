package com.zrrd.shop.controller;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigTestController {
    //注入一个获取上下文的对象
    @Autowired
    private ConfigurableApplicationContext context;

    @RequestMapping("/configTest1")
    public String configTest1(){
        //获取配置文件
        String config = context.getEnvironment().getProperty("config.appName");
        return config;
    }

}
