package gang.study.crud.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
public class Listener {

    @ResponseBody
    @RabbitListener(queues = "TestQ")
    public void processMessage(String content) {
        System.out.println(content);
        System.out.println("테스트");
        System.out.println("테스트");

    }

}
