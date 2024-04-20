package com.zrrd.shop.listener;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zrrd.shop.pojo.Order;
import com.zrrd.shop.pojo.Product;
import com.zrrd.shop.service.ProductService;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQReplyListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Ming
 */
@Component
@RocketMQMessageListener(topic = "Work",selectorExpression = "Report",consumerGroup = "${rocketmq.consumer.group}")
public class OneRocketMQMessageListener implements RocketMQReplyListener<String,Product> {


    @Override
    public Product onMessage(String message) {
        System.out.println("老板收到的消息:" + message);
        return new Product(3,"小米13Pro",3999d,9);
    }
}
