package test;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author : Ming
 */
public class Reciv02 {
    static final String QUEUE_NAME = "hello";
    public static void main(String[] args) throws IOException, TimeoutException {

        //1.创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/mqtest");
        connectionFactory.setUsername("hao");
        connectionFactory.setPassword("hao");
        //2.创建连接
        Connection connection = connectionFactory.newConnection();
        //3.创建频道
        Channel channel = connection.createChannel();
        //4.创建队列
        channel.queueDeclare(QUEUE_NAME,true,false,false,null);
        //5.创建消费者(创建监听如果queue有消息则通过回调函数接收消息)
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            /*
             * consumerTag  标识
             * envelope 获取交换机 路由key等信息
             * properties 配置
             * body  消息
             * */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //路由key
                System.out.println("路由key为:"+envelope.getRoutingKey());
                System.out.println("交换机为:"+envelope.getExchange());
                System.out.println("消息id为:"+envelope.getDeliveryTag());
                System.out.println("接收到的消息为:"+ new String(body,"utf-8"));
            }
        };
        //6.监听队列(启动监听)
        /*
         * 参数1:队列名
         * 参数2:是否自动确认 设置true表示消息接收到自动向MQ回复接收到了 MQ则会将消息冲队列中删除 如果设置为false则需要手动确认
         * 参数3: 消费者
         * */
        channel.basicConsume("queue_topic2",true,defaultConsumer);

    }
}
