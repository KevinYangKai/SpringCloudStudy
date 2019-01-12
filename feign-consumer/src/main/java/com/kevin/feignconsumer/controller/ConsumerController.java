package com.kevin.feignconsumer.controller;

import com.kevin.feignconsumer.dto.User;
import com.kevin.feignconsumer.service.HelloService;
import com.kevin.feignconsumer.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    HelloService helloService;

    @Autowired
    RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuffer sb = new StringBuffer();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("张三")).append("\n");
        sb.append(helloService.hello("李四", 18)).append("\n");
        sb.append(helloService.hello(new User("王五", 20)));
        return sb.toString();
    }

    @RequestMapping(value = "/feign-consumer3", method = RequestMethod.GET)
    public String helloConsumer3() {
        StringBuffer sb = new StringBuffer();
        sb.append(refactorHelloService.hello("张三")).append("\n");
        sb.append(refactorHelloService.hello("李四", 19)).append("\n");
        sb.append(refactorHelloService.hello(new com.kevin.helloserviceapi.dto.User("王五", 21)));
        return sb.toString();
    }

}
