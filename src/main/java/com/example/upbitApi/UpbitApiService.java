package com.example.upbitApi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UpbitApiService {
    private final UpbitWebClient upbitWebClient;

    public UpbitApiService(UpbitWebClient upbitWebClient) {
        this.upbitWebClient = upbitWebClient;
    }

    public Mono<List<UpbitTicker>> getUpbitPrice(String markets) {
        return upbitWebClient.getUpbitPriceList(markets);
    }

    // Alternatively, if you want to block and get the result synchronously
    public List<UpbitTicker> getUpbitPriceSynchronously(String markets) {
        return upbitWebClient.getUpbitPriceList(markets).block();
    }
}