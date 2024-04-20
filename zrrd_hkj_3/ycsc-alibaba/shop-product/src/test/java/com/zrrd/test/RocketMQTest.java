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
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RocketMQTest {
    @Test
    public void t1() throws MQClientException, InterruptedException {
        //创建一个消息消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("my-cons-group");
        consumer.setNamesrvAddr("127.0.0.1:9876");//设置nameServer地址
        consumer.subscribe("Sports","NBA");//订阅消息分别指定主题和标签
//       //给当前的消息者注册一个监听器  作用是时刻监听是否有新的消息（扶额和订阅主题和标签）
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override//当新消息进来 会自动调用这个函数（在list参数中）
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt msg : list){
                    System.out.println("消息ID:" + msg.getMsgId());
                    System.out.println("消息主题:" + msg.getTopic());
                    System.out.println("消息Tag:" + msg.getTags());
                    System.out.println("消息内容:" + new String(msg.getBody()));
                    System.out.println("----------------------------");
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();//开启消费者实列
        TimeUnit.MINUTES.sleep(1);//睡眠1分钟  否则进程自动停止 看不见新消息进来



    }

    @Test
    public void t0() throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        //创建消息生产者  并指定生产者的组名
        DefaultMQProducer producer = new DefaultMQProducer("my-group");
        //设置nameServer地址
        producer.setNamesrvAddr("127.0.0.1:9876");
        //启动生产者
        producer.start();

        //创建消费对象
        Message message = new Message("Sports","CBA",("java yyds").getBytes());

        //发送消息
        SendResult sendResult = producer.send(message);

        System.out.println(sendResult);

        //关闭生产者
        producer.shutdown();
    }
}
