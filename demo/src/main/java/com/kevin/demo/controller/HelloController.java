package com.kevin.demo.controller;

//import com.kevin.demo.dto.User;
import com.kevin.helloserviceapi.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));

    @Autowired
    private DiscoveryClient client;

    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
        return "Hello World";
    }

    /*@RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() throws InterruptedException {
        ServiceInstance instance = client.getLocalServiceInstance();
        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime:" + sleepTime);
        Thread.sleep(sleepTime);

        logger.info("/hello,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
        return "Hello World";
    }*/

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public User hello(@RequestParam String name, @RequestParam Integer age) {
        return new User(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user) {
        return "Hello " + user.getName() + ", " + user.getAge();
    }
}
