package com.example.msvcs.user.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cn-say-hello-msvcs")
public interface UserServiceProxy {

    @GetMapping("/greeting")
    public String greet();
}
