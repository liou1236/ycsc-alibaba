package com.zrrd;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    static final String QUEUE_NAME = "hello";
    /*
    简单模式：发送消息
     */
    public static void main(String[] args) throws IOException, TimeoutException {
        //1、创建连接工厂（设置RabbitMQ的连接参数）
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //主机：默认为localhost
        connectionFactory.setHost("localhost");
        //连接端口：默认5672
        connectionFactory.setPort(5672);
        //虚拟主机
        connectionFactory.setVirtualHost("/mqtest");
        //用户名和密码 默认guest
        connectionFactory.setUsername("hao");
        connectionFactory.setPassword("hao");
        //2、创建连接
        Connection connection = connectionFactory.newConnection();
        //4、创建频道
        Channel channel = connection.createChannel();
        //4、声明队列
        /*
        参数1：队列名称
        参数2：是否定义持久化队列（消息会初九话保存在服务器上）
        参数3：是否独占本连接
        参数4：是否在不使用的时候队列自动删除
        参数5：其它参数
         */
        channel.queueDeclare(QUEUE_NAME,true,false,false,null);
        //5、发送消息
//        String message = "你好，小龙！";
        /*
        参数1：交换机的名称 如果没有则指定为空字符串
        参数2：路由key 简单模式中可以使用队列的名称
        参数3：消息其它属性
        参数4：消息的内容
         */
//        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());

        for (int i = 0; i < 10; i++) {
            String message = "再来一个消息"+i;
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());

        }
//        System.out.println("已发送消息"+message);
        //6、关闭资源
        channel.close();
        connection.close();
    }
}
