package com.atamertc.manager;

import com.atamertc.dto.response.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "city-manager", url = "http://localhost:9091/city", decode404 = true)
public interface CityManager {

    @GetMapping("/{id}")
    ResponseEntity<City> findCity(@PathVariable Long id);

    @GetMapping("/get-random-city")
    ResponseEntity<City> findRandomCity();

}
