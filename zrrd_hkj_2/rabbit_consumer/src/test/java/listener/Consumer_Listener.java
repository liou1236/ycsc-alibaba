package listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer_Listener implements ChannelAwareMessageListener {
//从哪个queue接受消息
    @RabbitListener(queues = "nomal_queue")
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            int i= 1/0;
        } catch (Exception e) {
            System.out.println(message);
        }
    }
}
