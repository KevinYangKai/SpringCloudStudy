package com.kevin.demo.controller;

import com.kevin.helloserviceapi.dto.User;
import com.kevin.helloserviceapi.service.HelloService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorHelloController implements HelloService {

    @Override
    public String hello(@RequestParam("name") String name) {
        return "Hello " + name;
    }

    @Override
    public User hello(@RequestParam("name") String name,@RequestParam("age") Integer age) {
        return new User(name, age);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "Hello " + user.getName() + ", " + user.getAge();
    }
}
