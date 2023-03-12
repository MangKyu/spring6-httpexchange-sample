package com.mangkyu.spring.web;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.Map;

@HttpExchange("https://open.er-api.com")
public interface ExchangeRateHttpClient {

    @GetExchange("/v6/latest")
    Map getLatest();

}