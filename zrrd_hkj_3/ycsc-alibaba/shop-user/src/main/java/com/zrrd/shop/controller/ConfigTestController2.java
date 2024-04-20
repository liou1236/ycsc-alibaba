
package com.zrrd.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope//对当前Controller开启属性动态刷新
public class ConfigTestController2 {
    //注入一个获取上下文的对象
    @Value("${config.appName}")
    private String appName;
    @RequestMapping("/configTest2")
    public String configTest2(){
        return appName;
    }

}
