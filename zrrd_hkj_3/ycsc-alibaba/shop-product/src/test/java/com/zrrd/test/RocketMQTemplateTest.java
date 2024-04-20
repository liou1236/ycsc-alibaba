package com.zrrd.test;

import com.zrrd.shop.ProductApplication;
import com.zrrd.shop.pojo.Order;
import com.zrrd.shop.pojo.Product;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootTest(classes = ProductApplication.class)
public class RocketMQTemplateTest {
    //RocketMQTemplate是一个专门用Spring项目中访问RocketMQ的模板类
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void t6(){
        //发送一个回退消息
        Product product = rocketMQTemplate.sendAndReceive("Work:Report","老板写好了给我看看ba", Product.class);
        System.out.println("老板反馈的结果："+product);
    }
    @Test
    public void t5(){
        Message<String> message = MessageBuilder.withPayload("老板写好了给我看看").build();
        //发送延迟消息
        SendResult sendResult = rocketMQTemplate.syncSend("Work:plan",message,15000,4);
        System.out.println(sendResult);
    }

    @Test
    public void t4(){
        rocketMQTemplate.sendOneWay("Life:play","来呀一起上分");
    }

    int n = 0;//记录异步重试发送次数
    @Test
    public void t3(){
        Order newOrder = new Order();
        newOrder.setOid(13L);
        newOrder.setPid(6);
        newOrder.setPname("诺基亚k500");
        newOrder.setPprice(2599D);
        newOrder.setNumber(1);
        newOrder.setUid(1);
        newOrder.setUsername("张三");
        Message<Order> message = MessageBuilder.withPayload(newOrder).build();
        rocketMQTemplate.asyncSend("Life:EAT", message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println(sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                if (n<3){
                    t3();//调用t3重复发送
                    n++;
                }
            }
        });
    }

    @Test
    public void t2(){
        //用同步的方式向MQ发送一条消息  主题Life 标签EAT 内容：
        rocketMQTemplate.syncSend("Life:EAT","帮我带份饭");
    }

}
