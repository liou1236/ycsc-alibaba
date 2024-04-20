package com.zrrd.test;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.jupiter.api.Test;
import org.springframework.messaging.support.MessageBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RocketMQTest {
    @Test
    public void t1() throws MQClientException, InterruptedException {
        //创建一个消息消费者实例
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("my-cons-group");
        consumer.setNamesrvAddr("127.0.0.1:9876");//设置nameService地址
        consumer.subscribe("Sports","CBA");//订阅消息指定主题和标签
        //给当前的消费者注册一个监听器  作用是时刻监听是否有性的消息（符合订阅主题和标签）
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override//当有新的消息进来之后 会自动调用这分函数：新消息（可能是多个）
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for(MessageExt msg : list){
                    System.out.println("消息ID："+msg.getMsgId());
                    System.out.println("消息主题："+msg.getTopic());
                    System.out.println("消息Tag："+msg.getTags());
                    System.out.println("消息内容："+new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();//开启消费者实例
        TimeUnit.MINUTES.sleep(1);//睡眠一分钟 否则进程自动停止  看不到性的消息进来
    }
    @Test
    public void t0() throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        //创建生产者的组名
        DefaultMQProducer producer = new DefaultMQProducer("my-group");
        //设置nameserver的地址
        producer.setNamesrvAddr("127.0.0.1:9876");
        //启动生产者
        producer.start();

        //创建消费者消费对象               主题    标签                      字节数组内容
        Message message = new Message("Sports","CBA",("java yyds").getBytes());

        //发送消息
        SendResult sendResult = producer.send(message);

        System.out.println(sendResult);

        //关闭生产者
        producer.shutdown();
    }
}
