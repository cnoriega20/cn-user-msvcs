package com.example.msvcs.user.controllers;

import com.example.msvcs.user.config.SayHelloConfiguration;
import com.example.msvcs.user.services.UserServiceProxy;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RibbonClient(name = "cn-say-hello-msvcs", configuration = SayHelloConfiguration.class)
public class UserController {

    @LoadBalanced
    private final UserServiceProxy userServiceProxy;

    public UserController(UserServiceProxy userServiceProxy) {
        this.userServiceProxy = userServiceProxy;
    }

    @GetMapping("/sayHi")
    public String sayHi(@RequestParam(value = "name", defaultValue = "Cesar") String name){
        String greeting = userServiceProxy.greet();
        return String.format("%s, %s!", greeting, name);
    }
}
