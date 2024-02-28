package com.example.upbitApi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@Slf4j
public class UpbitApiController {
    private final UpbitApiService upbitApiService;

    public UpbitApiController(UpbitApiService upbitApiService) {
        this.upbitApiService = upbitApiService;
    }
    @GetMapping(value = "/v1/upbit/{ticker}")
    public Mono<List<UpbitTicker>> getUpbitTickerPrice(@PathVariable String ticker) {
        return upbitApiService.getUpbitPrice(ticker);
    }
}
