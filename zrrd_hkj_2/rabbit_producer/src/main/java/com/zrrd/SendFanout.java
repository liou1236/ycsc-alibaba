package test;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author : Ming
 */
public class SendFanout {
    /*
     * 简单模式: 发送消息
     * */
    public static void main(String[] args) throws IOException, TimeoutException {
        //1.创建连接工厂(设置RabbitMQ的连接参数)
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //主机:默认为localhost
        connectionFactory.setHost("localhost");
        //连接端口: 默认5672
        connectionFactory.setPort(5672);
        //虚拟主机 默认/
        connectionFactory.setVirtualHost("/mqtest");
        //用户名: 默认guest
        connectionFactory.setUsername("hao");
        //密码: 默认guest
        connectionFactory.setPassword("hao");
        //2.创建连接
        Connection connection = connectionFactory.newConnection();
        //3.创建频道
        Channel channel = connection.createChannel();
        //4.声明交换机
        String name = "exchange_fanout";
        /*
         * exchange: 交换机名称
         * BuiltinExchangeType type 交换机的类名
         *       Direct定向  Fanout 广播(扇形)将消息发送给与之绑定的所有的queue
         *       Topic 通配符
         * durable 是否持久化
         * autoDelete  是否自动删除
         * internal:  内部使用 一般都是false
         * arguments  参数
         * */
        channel.exchangeDeclare(name, BuiltinExchangeType.FANOUT,true,false,false,null);
        //5.创建两个队列
        String qname1 = "queue_fanout1";
        String qname2 = "queue_fanout2";
        /*
         * 参数1: 队列的名称
         * 参数2: 是否定义持久化队列(消息会持久化保存在服务器上)
         * 参数3:  是否独占本连接
         * 参数4:  是否在不使用的时候队列自动删除
         * 参数5:  其他参数
         * */

        channel.queueDeclare(qname1,true,false,false,null);
        channel.queueDeclare(qname2,true,false,false,null);
        //6.绑定队列和交换机
        /*
         * queue:要绑定的队列
         * exchange: 要绑定的交换机
         * routingKey 绑定规则(如果Type为fanout 则空字符串就可以 会自动分发给所有的队列)
         * */
        channel.queueBind(qname1,name,"");
        channel.queueBind(qname2,name,"");
        //7.发送消息
        //String message = "你好呀!小兔子";
        String message = "广播测试";
        /*
         * 参数1:  交换机的名称 如果没有则指定为空字符串(表示内部使用默认的交换机)
         * 参数2:  路由key 简单模式中可以使用队列的名称
         * 参数3:  消息其他属性
         * 参数4:  消息的内容
         * */
        channel.basicPublish(name,"",null,message.getBytes());
        /*for (int i = 0; i < 10; i++) {
            String message = "再来一个消息"+ i;
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        }*/

        //System.out.println("已发送消息"+message);
        //6.关闭资源
        channel.close();
        connection.close();
    }
}
