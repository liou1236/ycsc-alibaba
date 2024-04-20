package com.zrrd.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.cloud.openfeign.EnableFeginClients;

@SpringBootApplication
@MapperScan("com.zrrd.shop.dao")
@EnableDiscoveryClient//开启服务发现客户端
@EnableFeignClients//开启feign服务
@RestController
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
