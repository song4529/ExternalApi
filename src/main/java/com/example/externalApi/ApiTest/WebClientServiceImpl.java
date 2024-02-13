package com.example.externalApi.ApiTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
@Slf4j
public class WebClientServiceImpl {
    public void get() {
        String code = "myCode";

        //WebClient 기본 설정
        WebClient webClient =
                WebClient.builder()
                        .baseUrl("http://localhost:8080")
                        .build();

        //api 요청
        Map<String, Object> response =
                webClient.get()
                        .uri(uriBuilder ->
                                uriBuilder.path("/api/get")
                                        .queryParam("code", code)
                                        .build()
                        ).retrieve()
                        .bodyToMono(Map.class)
                        .block();

        //결과 확인
        log.info(response.toString());
    }
}
