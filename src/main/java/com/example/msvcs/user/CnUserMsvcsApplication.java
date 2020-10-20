package com.example.msvcs.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CnUserMsvcsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CnUserMsvcsApplication.class, args);
    }

}
