package com.atamertc.manager;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user-manager", url = "http://localhost:9091/user", decode404 = true)
public interface UserManager {



}
