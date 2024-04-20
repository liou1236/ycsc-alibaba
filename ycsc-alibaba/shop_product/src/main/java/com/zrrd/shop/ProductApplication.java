package com.zrrd.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ming
 */
@SpringBootApplication
@EnableDiscoveryClient //启用服务注册发现的客户端
@MapperScan("com.zrrd.shop.dao")
@RestController
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class,args);
    }
    @GetMapping
    public String welcome(){
        return "欢迎来宾";
    }
}
