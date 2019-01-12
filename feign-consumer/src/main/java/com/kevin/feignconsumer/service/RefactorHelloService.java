package com.kevin.feignconsumer.service;

import com.kevin.helloserviceapi.service.HelloService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService extends HelloService {
}
