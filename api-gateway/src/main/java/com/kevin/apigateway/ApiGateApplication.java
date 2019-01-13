package com.kevin.apigateway;

import com.kevin.apigateway.configuration.MyErrorAttributes;
import com.kevin.apigateway.filter.AccessFilter;
import com.kevin.apigateway.filter.MyFilterProcessor;
import com.netflix.zuul.FilterProcessor;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class ApiGateApplication {

    public static void main(String[] args) {
        FilterProcessor.setProcessor(new MyFilterProcessor());
        new SpringApplicationBuilder(ApiGateApplication.class).web(true).run(args);
    }

    @Bean
    public DefaultErrorAttributes defaultErrorAttributes() {
        return new MyErrorAttributes();
    }
}
