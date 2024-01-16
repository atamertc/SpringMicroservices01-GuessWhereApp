package com.atamertc.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    //******************* EXCHANGE FIELD AND BEAN *******************//
    //------------- score-service Exchange -------------//
    @Value("score-exchange")
    private String scoreExchange;

    @Bean
    DirectExchange scoreExchange() {
        return new DirectExchange(scoreExchange);
    }


    //******************* PRODUCER FIELDS AND BEANS *******************//





    //******************* CONSUMER FIELDS AND BEANS *******************//

    //------------- GuessService createScore Metodu -------------//

    @Value("createScore-queue")
    private String createScoreQueueName;

    @Bean
    Queue createScoreQueue() {
        return new Queue(createScoreQueueName);
    }



}
