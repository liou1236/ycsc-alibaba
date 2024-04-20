package com.zrrd.test;

import com.zrrd.shop.ProductApplication;
import com.zrrd.shop.pojo.Order;
import com.zrrd.shop.pojo.Product;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author : Ming
 */
@SpringBootTest(classes = ProductApplication.class)
public class RocketMQTemplateTest {
    //RocketMQTemplate是一个专门用Spring项目中访问RocketMQ的一个模板类
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void t6(){
        //发送一个回馈消息
        Product product = rocketMQTemplate.sendAndReceive("Work:Report","老板计划写好了请查收", Product.class);
        System.out.println("老板反馈的结果:"+product);
    }

    @Test
    public void t5() {
        Message<String> message = MessageBuilder.withPayload("老板计划写好了请查收").build();
        //发送延时消息
        SendResult sendResult = rocketMQTemplate.syncSend("Work:plan", message, 15000, 4);
        System.out.println(sendResult);
    }
    @Test
    public void t4(){
        rocketMQTemplate.sendOneWay("Life:play","来呀一起上分");
    }


    int n = 0; //记录异步发送重试次数
    @Test
    public void t3(){
        //我想把一订单对象发送到MQ
        Order newOrder = new Order();
        newOrder.setOid(13L);
        newOrder.setPid(6);
        newOrder.setPname("诺基亚k500");
        newOrder.setPprice(2599D);
        newOrder.setNumber(1);
        newOrder.setUid(1);
        newOrder.setUsername("张三");
        //将新的订单实例作为消息的主题内容
        Message<Order> message = MessageBuilder.withPayload(newOrder).build();
        rocketMQTemplate.asyncSend("Life:EAT", message, new SendCallback() {
            @Override  //当MQ返回发送结果之后 会自动回调这个函数
            public void onSuccess(SendResult sendResult) {
                System.out.println(sendResult);
            }
            @Override//当发生异常 消息发送未成功回调
            public void onException(Throwable throwable) {
                if (n<3){
                    t3();  //递归调用t3重复发送
                    n++;
                }
            }
        });
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void t2(){
        //用同步的方式向MQ发送一条消息 主题Life 标签EAT 内容:
        SendResult sendResult = rocketMQTemplate.syncSend("Life:EAT", "帮我带一份饭");
        System.out.println(sendResult);
    }
}
