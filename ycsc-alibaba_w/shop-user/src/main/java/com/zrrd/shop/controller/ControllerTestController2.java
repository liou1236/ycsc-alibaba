package com.zrrd.shop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ControllerTestController2 {
    @Value("${config.appName}")
    private String appName;

    @RequestMapping("/configTest2")
    public String configTest1(){
        return appName;
    }
}
