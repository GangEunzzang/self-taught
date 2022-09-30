package gang.study.crud.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
class Sender {
    @Autowired
    RabbitMessagingTemplate template;

//    @Bean
//    Queue queue() {
//        return new Queue("TestQ", false);
//    }

    public void send(String message) {
        template.convertAndSend("TestQ", message);
    }

    public void send2(String message) {
        template.convertAndSend("redirect", message);
    }
}
