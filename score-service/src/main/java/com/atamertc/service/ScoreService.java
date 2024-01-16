package com.atamertc.service;

import com.atamertc.rabbitmq.model.CreateScoreModel;
import com.atamertc.repository.ScoreRepository;
import com.atamertc.repository.entity.Score;
import com.atamertc.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService extends ServiceManager<Score, Long> {
    private final ScoreRepository repository;

    public ScoreService(ScoreRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Score rabbitUpdateCreateScore(CreateScoreModel model) {
        Optional<Score> score = repository.findByUserid(model.getUserid());
        if (score.isEmpty()) {
            score = Optional.of(save(Score.builder().score(model.getScore()).userid(model.getUserid()).build()));
        } else {
            score.get().setScore(score.get().getScore() + model.getScore());
            update(score.get());
        }
        return score.get();
    }

    public List<Score> findAllOrdered() {
        return repository.findAllByOrderByScoreDesc();
    }
}
