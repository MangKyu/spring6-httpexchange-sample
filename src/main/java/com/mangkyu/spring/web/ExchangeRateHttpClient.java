package com.mangkyu.spring.web;

import org.springframework.web.service.annotation.GetExchange;

import java.util.Map;

public interface ExchangeRateHttpClient {

    @GetExchange("/v6/latest")
    Map getLatest();

}