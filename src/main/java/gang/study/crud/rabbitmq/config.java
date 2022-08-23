//package gang.study.crud.rabbitmq;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//
//@Configuration
//
//public class config {
//    private static final String queueName = "message-queue";
//    private static final String topicExchangeName = "topic-message";
//
//
//    // 메시지 Producer가 보내는 곳
//    @Bean
//    public TopicExchange exchange() {
//        return new TopicExchange(topicExchangeName);
//    }
//
//    // 예제에서는 BindingBuilder를 사용해서 위에서 설정한 Queue와 Exchange 를 바인딩 시킨다.
//    // with로 들어가는 값은 RoutingKey 로 foo.bar.하위의 모든 키들과 관계를 맺는다.
//    @Bean
//    public Binding binding(Queue queue, TopicExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
//    }
//
//    // Jackson 메세지 컨버터를 빈으로 등록하고,
//    // RabbitTemplate도 빈으로 등록한다.
//    // Spring boot가 ConnectionFactory를 주입해서 넣어준다.
//    @Bean
//    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(messageConverter());
//        return rabbitTemplate;
//    }
//
//    @Bean
//    MessageConverter messageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//}
