package com.example.movieApi;

import org.springframework.web.reactive.function.client.WebClient;

public class MovieApiWebClient {

    private final WebClient webClient;

    public MovieApiWebClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.movie.com/v1/ticker").build();
    }
}
