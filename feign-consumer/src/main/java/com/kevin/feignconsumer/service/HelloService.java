package com.kevin.feignconsumer.service;

import com.kevin.feignconsumer.dto.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "hello-service", fallback = HelloServiceFallback.class)
public interface HelloService {

    @RequestMapping(value = "/hello")
    String hello();

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    User hello(@RequestParam("name") String name, @RequestParam("age") Integer age);

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);

}
