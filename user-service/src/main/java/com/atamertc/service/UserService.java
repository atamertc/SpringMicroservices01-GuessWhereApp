package com.atamertc.service;

import com.atamertc.dto.request.LoginRequestDto;
import com.atamertc.dto.request.RegisterRequestDto;
import com.atamertc.dto.response.RegisterResponseDto;
import com.atamertc.exception.ErrorType;
import com.atamertc.exception.UserManagerException;
import com.atamertc.mapper.UserMapper;
import com.atamertc.repository.UserRepository;
import com.atamertc.repository.entity.User;
import com.atamertc.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends ServiceManager<User, Long> {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public RegisterResponseDto register(RegisterRequestDto dto) {
        User user = UserMapper.INSTANCE.toUser(dto);
        save(user);
        return UserMapper.INSTANCE.toRegisterResponseDto(user);
    }

    public Boolean login(LoginRequestDto dto) {
        Optional<User> user = repository.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if (user.isEmpty()) {
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        }
        return true;
    }

    public Boolean updateActiveGuessId(Long id, Long tahminId) {
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()) {
            throw new UserManagerException(ErrorType.USER_NOT_FOUND);
        }
        user.get().setActiveGuessId(tahminId);
        user.get().getGuesses().add(tahminId);
        update(user.get());
        return true;
    }
}
