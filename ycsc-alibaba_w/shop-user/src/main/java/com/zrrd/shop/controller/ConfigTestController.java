package com.zrrd.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigTestController {
    @Autowired
    private ConfigurableApplicationContext context;
    //动态获取属性信息
    @RequestMapping("/configTest1")
    public String configTest1(){
        return context.getEnvironment().getProperty("config.appName");
    }
}
