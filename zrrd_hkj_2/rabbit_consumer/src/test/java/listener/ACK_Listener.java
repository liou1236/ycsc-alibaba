package listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

import java.io.IOException;

public class ACK_Listener implements ChannelAwareMessageListener {

    /*
    1、设置手动签收 acknowledge="manual"
    2、让监听器监听 ChannelAwareMessageListener
    3、如果签收成功 调用channel.basicAck()
    4、如果签收失败 调用channel.basicNack()拒绝签收 broker会重新发送
     */
    @RabbitListener(queues = "nomal_queue",ackMode = "MANUAL")
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        //获取消息的投递标识  在多个消息中 明确哪个消息有问题或者确认签收
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            System.out.println(new String(message.getBody()));
            System.out.println(deliveryTag);
            System.out.println("处理业务");
            channel.basicAck(deliveryTag,true);
        } catch (IOException e) {
            //requeue如果为true 则退回消息到queue 并让其重新发送
            System.out.println("出现错误，重新发送");
            //告诉queue消息没有正确接受 需要重新发送
            //requeue 如果消息被拒绝 要重新查询 而不是进入死信或者丢弃
            channel.basicNack(deliveryTag,true,true);
        }
    }
}
