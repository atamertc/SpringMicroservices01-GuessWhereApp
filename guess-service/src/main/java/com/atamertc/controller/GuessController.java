package com.atamertc.controller;

import com.atamertc.dto.request.GuessRequestDto;
import com.atamertc.dto.response.GuessResponseDto;
import com.atamertc.repository.entity.Guess;
import com.atamertc.service.GuessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guess")
@RequiredArgsConstructor
public class GuessController {
    private final GuessService service;

    @PostMapping("/create-guess")
    public ResponseEntity<GuessResponseDto> createGuess(@RequestParam Long userid) {
        return ResponseEntity.ok(service.createGuess(userid));
    }

    @PostMapping("/make-guess")
    public ResponseEntity<String> makeGuess(@RequestBody GuessRequestDto dto) {
        return ResponseEntity.ok(service.makeGuess(dto));
    }

}
