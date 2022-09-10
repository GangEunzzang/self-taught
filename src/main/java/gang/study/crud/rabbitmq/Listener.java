package gang.study.crud.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @RabbitListener(queues = "TestQ")
    public void processMessage(String content) {
        System.out.println(content);
        System.out.println("테스트");
        System.out.println("테스트");

    }

}
