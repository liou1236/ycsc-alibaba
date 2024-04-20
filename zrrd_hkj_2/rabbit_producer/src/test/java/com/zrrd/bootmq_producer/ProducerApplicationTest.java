package com.zrrd.bootmq_producer;


import com.bootmq_producer.config.RabbitConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProducerApplicationTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void sendMessage(){
        String message = "私密信息";
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME,"*.info",message);
        System.out.println(message);
    }
    @Test
    public void testConfirm(){
        //1、定义confirmCallBack(在发送阶段需要设置回避)
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /*
            correlationDate: 相关信息设置 在发送时设置
            ack: 代表交换机是否成功收到消息
            cause: 失败原因
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                //表示获取投递的标识
                System.out.println(correlationData.getId());
                //投递成功或者失败
                System.out.println(ack);
                //如果失败显示原因
                System.out.println(cause);
                System.out.println("confirm方法被执行了");
            }
        });
        String message = "日志信息,key为boot.log";
        /*
        new CorrelationData()相当于发快递的时候准备一张快递单，过程中的所有单号
        问题都会记录在上面
         */
        //2、发送信息
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME,"boot.hello",message.getBytes(),new CorrelationData());
    }
    @Test
    public void testReturn(){
        //设置交换机是否丢弃消息 如果值为false则不管message是否成功都丢弃
        rabbitTemplate.setMandatory(true);
        //设置callback
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                //如果成功就不会调用 不像confirm不管成功失败都会调用
                System.out.println("exchange--->queue");
                System.out.println(returnedMessage);
                System.out.println(returnedMessage.getMessage());
                System.out.println(returnedMessage.getExchange());
                System.out.println(returnedMessage.getReplyCode());
                System.out.println(returnedMessage.getReplyText());
                System.out.println(returnedMessage.getRoutingKey());

            }
        });
        //2、发送消息
        for (int i = 0; i < 10; i++) {
            String  message = i + "哈哈哈";
            rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME,"111",message.getBytes());
        }
    }
}
