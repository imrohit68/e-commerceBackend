package com.microservice.orderservice.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebClientConfig {
    @Bean
    public org.springframework.web.reactive.function.client.WebClient webClient(){
         return org.springframework.web.reactive.function.client.WebClient.builder().build();
    }
}
