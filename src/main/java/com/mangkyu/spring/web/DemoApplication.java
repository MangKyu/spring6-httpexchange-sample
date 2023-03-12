package com.mangkyu.spring.web;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@SpringBootApplication
public class DemoApplication {

    @Bean
    ApplicationRunner init(ExchangeRateHttpClient httpClient) {
        return args -> {
            Map<String, Map<String, Double>> result3 = httpClient.getLatest();
            System.out.println(result3.get("rates").get("KRW"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
