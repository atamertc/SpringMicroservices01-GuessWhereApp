package com.atamertc.controller;

import com.atamertc.dto.request.LoginRequestDto;
import com.atamertc.dto.request.RegisterRequestDto;
import com.atamertc.dto.response.RegisterResponseDto;
import com.atamertc.exception.ErrorType;
import com.atamertc.exception.UserManagerException;
import com.atamertc.repository.entity.User;
import com.atamertc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto dto) {
        return ResponseEntity.ok(service.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(LoginRequestDto dto) {
        return ResponseEntity.ok(service.login(dto));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/update-active-guess-id/{id}/{tahminId}")
    public ResponseEntity<Boolean> updateActiveGuessId(@PathVariable Long id, @PathVariable Long tahminId) {
        return ResponseEntity.ok(service.updateActiveGuessId(id, tahminId));
    }

}
