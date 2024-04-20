package com.zrrd.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ming
 */
@SpringBootApplication
@EnableDiscoveryClient//开启服务发现客户端
@EnableFeignClients//开启Fegin
@MapperScan("com.zrrd.shop.dao")
@RestController
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
    @GetMapping
    public String welcome(){
        return "欢迎来宾";
    }
}
