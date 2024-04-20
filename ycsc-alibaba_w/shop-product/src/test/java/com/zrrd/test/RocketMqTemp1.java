package com.zrrd.test;

import com.zrrd.shop.ProductApplication;
import com.zrrd.shop.pojo.Order;
import com.zrrd.shop.pojo.Product;
import lombok.SneakyThrows;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = ProductApplication.class)
public class RocketMqTemp1 {
    //RocketMQTemplate是一个专门用于spring项目访问RocketMQ的一个模板类
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    int n = 0; //记录异步重试次数
    @Test
    public void t4(){
        rocketMQTemplate.sendOneWay("Life:play","一定要睡觉啊");

    }
    @Test
    public void t3() throws InterruptedException {
        //将订单对象发送到mq
        Order newOrder = new Order();
        newOrder.setOid(13L);
        newOrder.setPid(6);
        newOrder.setPname("诺基亚k300");
        newOrder.setPprice(2599D);
        newOrder.setNumber(1);
        newOrder.setUid(1);
        newOrder.setUsername("张三");
        //将新的订单实例作为消息的主机发送
        Message<Order> message = MessageBuilder.withPayload(newOrder).build();
        rocketMQTemplate.asyncSend("Life:Eat", message, new SendCallback() {
            @Override//当MQ返回发送结果后  会自动回调函数
            public void onSuccess(SendResult sendResult) {
                System.out.println(sendResult);
            }

            @SneakyThrows
            @Override //发生异常  消息发送未成功回调
            public void onException(Throwable throwable) {
                if (n<3){
                    t3();//递归调用t3，重复发送
                    n++;
                }
            }
        });
        TimeUnit.MINUTES.sleep(1);
    }

    @Test
    public void t2(){
        //用同步的方式想mq发送消息  主题Life 标签EAT 内容：TQJ
        SendResult sendResult = rocketMQTemplate.syncSend("life:EAT", "还想睡觉啊");
        System.out.println(sendResult);
    }
    @Test
    public void t5(){
        Message<String> message = MessageBuilder.withPayload("老板计划写好了请查收").build();
        SendResult sendResult = rocketMQTemplate.syncSend("Work:plan", message, 15000, 4);
        System.out.println(sendResult);
    }
    @Test
    public void t6(){
        //发送一个回馈消息
        Product product = rocketMQTemplate.sendAndReceive("Work:Report", "该睡觉啦", Product.class);
        System.out.println("睡觉的结果："+"开除"+product);
    }
}
