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
    @Value("guess-exchange")
    private String guessExchange;

    @Bean
    DirectExchange guessExchange() {
        return new DirectExchange(guessExchange);
    }


    //******************* PRODUCER FIELDS AND BEANS *******************//


    //------------- ScoreService createScore Metodu -------------//
    @Value("createScore-bindingKey")
    private String createScoreBindingKey;
    @Value("createScore-queue")
    private String createScoreQueueName;

    @Bean
    Queue createScoreQueue() {
        return new Queue(createScoreQueueName);
    }
    @Bean
    public Binding bindingRegister(final Queue createScoreQueue, final DirectExchange guessExchange) {
        return BindingBuilder.bind(createScoreQueue).to(guessExchange).with(createScoreBindingKey);
    }



    //******************* CONSUMER FIELDS AND BEANS *******************//




}
