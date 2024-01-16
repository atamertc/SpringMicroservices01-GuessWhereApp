package com.atamertc.service;

import com.atamertc.dto.request.GuessRequestDto;
import com.atamertc.dto.response.City;
import com.atamertc.dto.response.GuessResponseDto;
import com.atamertc.exception.ErrorType;
import com.atamertc.exception.GuessManagerException;
import com.atamertc.manager.CityManager;
import com.atamertc.manager.UserManager;
import com.atamertc.mapper.GuessMapper;
import com.atamertc.rabbitmq.model.CreateScoreModel;
import com.atamertc.rabbitmq.producer.CreateScoreProducer;
import com.atamertc.repository.GuessRepository;
import com.atamertc.repository.entity.Guess;
import com.atamertc.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class GuessService extends ServiceManager<Guess, Long> {
    private final GuessRepository repository;
    private final CityManager cityManager;
    private final UserManager userManager;
    private final CreateScoreProducer createScoreProducer;

    public GuessService(GuessRepository repository, CityManager cityManager, UserManager userManager, CreateScoreProducer createScoreProducer) {
        super(repository);
        this.repository = repository;
        this.cityManager = cityManager;
        this.userManager = userManager;
        this.createScoreProducer = createScoreProducer;
    }

    public GuessResponseDto createGuess(Long userid) {
        City city = cityManager.findRandomCity().getBody();
        Guess guess = Guess.builder()
                .userid(userid)
                .correctAnswer(city.getName())
                .blur(city.getBlur())
                .build();
        save(guess);
        userManager.updateActiveGuessId(userid, guess.getId());
        return GuessMapper.INSTANCE.toGuessResponseDto(guess);
    }

    public String makeGuess(GuessRequestDto dto) {
        Optional<Guess> guess = repository.findById(dto.getGuessid());
        if (guess.get().getGuessRights() == 0) {
            return "Tahmin hakkiniz bitmistir :(";
        }
        if (guess.get().isVerified()) {
            throw new GuessManagerException(ErrorType.BAD_REQUEST,"Tahmin daha once dogrulanmis.");
        }
        guess.get().getGuesses().add(dto.getGuess());
        if (guess.get().getCorrectAnswer().equalsIgnoreCase(dto.getGuess())) {
            guess.get().setVerified(true);
            update(guess.get());
            createScoreProducer.createScore(CreateScoreModel.builder().score(10).userid(dto.getUserid()).build());
            return "Tebrikler! Dogru Tahmin Ettiniz...";
        }
        guess.get().setGuessRights(guess.get().getGuessRights() - 1);
        update(guess.get());
        createScoreProducer.createScore(CreateScoreModel.builder().score(-5).userid(dto.getUserid()).build());
        return "Yanlis cevap lutfen tekrar deneyiniz" + guess.get().getGuessRights() + "hakkiniz kaldi";
    }
}
