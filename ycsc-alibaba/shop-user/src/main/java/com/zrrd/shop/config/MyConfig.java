package com.zrrd.shop.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author : Ming
 */
@Configuration
public class MyConfig {
    //向容器中注入一个TestTemplate实例 用于在服务之间进行远程调用
    //设计模式 模板模式 不用关注于http协议 直接封装起来了
    @Bean
    @LoadBalanced//ribbon 负载均衡的注解
    public RestTemplate getTestTemplate(){
        return new RestTemplate();
    }
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));//如果配置多个插件,切记分页最后添加
        return interceptor;
    }
}
