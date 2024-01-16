package com.atamertc.rabbitmq.consumer;

import com.atamertc.rabbitmq.model.CreateScoreModel;
import com.atamertc.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateScoreConsumer {

    private final ScoreService service;

    @RabbitListener(queues = "createScore-queue")
    public void listenCreateScoreQueue(CreateScoreModel model) {
        service.rabbitUpdateCreateScore(model);
    }
}
