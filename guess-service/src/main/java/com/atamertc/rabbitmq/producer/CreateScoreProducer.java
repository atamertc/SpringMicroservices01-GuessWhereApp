package com.atamertc.rabbitmq.producer;

import com.atamertc.rabbitmq.model.CreateScoreModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateScoreProducer {

    @Value("guess-exchange")
    private String guessExchange;

    @Value("createScore-bindingKey")
    private String createScoreBindingKey;

    private final RabbitTemplate rabbitTemplate;

    public void createScore(CreateScoreModel model) {
        rabbitTemplate.convertAndSend(guessExchange, createScoreBindingKey, model);
    }
}
