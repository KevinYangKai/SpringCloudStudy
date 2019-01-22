package com.kevin.configclientkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientKafkaApplication.class, args);
    }

}
