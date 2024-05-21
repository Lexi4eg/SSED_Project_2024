package com.example.swp_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBContoller {

    @RequestMapping
    public String index() {
        return "Hello, World!";
    }

    @RequestMapping("/test")
    public String test() {
        return "Hello, Test!";
    }

}
