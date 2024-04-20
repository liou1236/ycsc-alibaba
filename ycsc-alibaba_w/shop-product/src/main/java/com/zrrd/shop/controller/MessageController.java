package com.zrrd.shop.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/test")
public class MessageController {
    //给M1接口加一个限流规则
    @GetMapping("/m1")
    public String m1() throws InterruptedException {
        TimeUnit.MICROSECONDS.sleep(900);
        return "消息：message:1";
    }
    //M2接口作为对照组  看看M1限流规则是否影响M2
    @GetMapping("/m2")
    public String m2(){
        // 随机生成布尔值  只要是true就手动抛出异常
        if(new Random().nextBoolean()){
            throw new RuntimeException("手动模拟程序出错");
        }
        return "message:2消息";
    }
    @GetMapping("/m3")
    @SentinelResource("message3")//给当前方法加一个sentinel资源
    public String m3(String name,Integer age){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("你的姓名:");
        stringBuffer.append(name);
        stringBuffer.append("你的年龄");
        stringBuffer.append(age);
        return stringBuffer.toString();
    }
}
