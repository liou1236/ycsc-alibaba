package com.bootmq_producer.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Ming
 */
@Configuration
public class RabbitConfig {
    public final static String EXCHANGE_NAME = "nomal_exchange";
    public final static String QUEUE_NAME = "nomal_queue";
    public final static String DLXEXCHANGE = "dlx_exchange";
    public final static String DLXQUEUE = "dlx_queue";
    //1.创建exchange
    @Bean("nomalExchange") //将bootExchange的对象放入spring容器中
    public Exchange bootExchange(){
        System.out.println("创建交换机");
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

    //2.创建队列
    @Bean("nomalQueue")
    public Queue getQueue(){
        System.out.println("创建队列");
        //expire设置过期时间  另一种方式：ttl(10000)
//        return QueueBuilder.durable(QUEUE_NAME).expires(10000).build();
        return QueueBuilder.durable(QUEUE_NAME).deadLetterExchange(DLXEXCHANGE)
                .deadLetterRoutingKey("a.info").ttl(10000).build();
    }
    //3.绑定queue和exchange
    @Bean
    public Binding getBinding(@Qualifier("nomalQueue") Queue queue, @Qualifier("nomalExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("*.info").noargs();
    }

    //处理无法被正常消费的消息 放入死信队列

    //创建死信交换机
    @Bean("dlxExchange")
    public Exchange dlxExchange(){
        System.out.println("创建死信交换机");
        return ExchangeBuilder.topicExchange(DLXEXCHANGE).durable(true).build();
    }
    //创建死信队列
    @Bean("dlxQueue")
    public Queue dlxQueue(){
        System.out.println("创建死信队列");
        return QueueBuilder.durable(DLXQUEUE).build();
    }
    //绑定死信queue和exchange
    @Bean
    public Binding dlxBinding(@Qualifier("dlxQueue") Queue queue, @Qualifier("dlxExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("*.info").noargs();
    }
}
