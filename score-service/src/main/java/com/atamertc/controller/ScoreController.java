package com.atamertc.controller;

import com.atamertc.repository.entity.Score;
import com.atamertc.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/score")
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreService service;

    @GetMapping("/ordered-scores")
    public ResponseEntity<List<Score>> findAllOrdered() {
        return ResponseEntity.ok(service.findAllOrdered());
    }
}
