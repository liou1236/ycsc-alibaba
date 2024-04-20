package com.zrrd.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ming
 */
@RestController
@RefreshScope//对当前Controller开启属性的动态更新
public class ConfigTestController2 {
    //注入一个获取上下文的对象
    @Value("${config.appName}")
    private String appName;

    //动态获取属性信息
    @RequestMapping("/configTest2")
    public String configTest1(){
        return appName;
    }
}
