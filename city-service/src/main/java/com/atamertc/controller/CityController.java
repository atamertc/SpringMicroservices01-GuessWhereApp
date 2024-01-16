package com.atamertc.controller;

import com.atamertc.dto.request.AddRequestDto;
import com.atamertc.repository.entity.City;
import com.atamertc.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {
    private final CityService service;

    @PostMapping("/add")
    public ResponseEntity<City> add(@RequestBody AddRequestDto dto) {
        return ResponseEntity.ok(service.add(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findCity(@PathVariable Long id) {
        return ResponseEntity.ok(service.findCity(id));
    }

    @GetMapping("/get-random-city")
    public ResponseEntity<City> findRandomCity() {
        return ResponseEntity.ok(service.findRandomCity());
    }
}
