package com.atamertc.manager;

import com.atamertc.dto.response.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "user-manager", url = "http://localhost:9090/user", decode404 = true)
public interface UserManager {

    @PutMapping("/update-active-guess-id/{id}/{tahminId}")
    ResponseEntity<Boolean> updateActiveGuessId(@PathVariable Long id, @PathVariable Long tahminId);

}
