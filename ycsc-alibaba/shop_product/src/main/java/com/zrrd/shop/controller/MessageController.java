package com.zrrd.shop.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author : Ming
 */
@RestController
@RequestMapping("/aaa")
public class MessageController {
    //给m1接口加一个限流规则
    @GetMapping("/m1")
    public String m1() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(900);
        return "消息:message:1.";
    }
    //m2接口作为对照组 看看m1的限流规则是否影响m2
    @GetMapping("/m2")
    public String m2(){
        //随机生成布尔值  只要是true就手动抛出异常
        if (new Random().nextBoolean()){
            throw new RuntimeException("手动模拟程序出错");
        }
        return "消息:message:2.";
    }
    @GetMapping("/m3")
    @SentinelResource("message3") //给当前方法加一个Sentinel资源名称
    public String m3(String name,Integer age){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("你的姓名:");
        stringBuffer.append(name);
        stringBuffer.append("你的年龄");
        stringBuffer.append(age);
        return stringBuffer.toString();
    }

}
