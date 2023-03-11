package com.mangkyu.spring.web;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

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

    @Bean
    ExchangeRateHttpClient exchangeRateHttpClient() {
        WebClient client = WebClient.create("https://open.er-api.com");
        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(client))
                .build();

        return proxyFactory.createClient(ExchangeRateHttpClient.class);

    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
