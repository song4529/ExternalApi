package com.example.upbitApi;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.List;

public class UpbitWebClient {

    private final WebClient webClient;

    public UpbitWebClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.upbit.com/v1/ticker").build();
    }

    public Mono<List<UpbitTicker>> getUpbitPriceList(String markets) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("markets", markets)
                        .build())
                .retrieve()
                .bodyToFlux(UpbitTicker.class)
                .collectList();
    }
}
