package com.zrrd.shop.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.zrrd.shop.util.ExceptionHandlerPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    //将Sentinel异常处理的组件添加到当前的Bean容器中
    @Bean
    public BlockExceptionHandler blockExceptionHandler(){
        return new ExceptionHandlerPage();
    }
}
