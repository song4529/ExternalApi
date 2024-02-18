package com.example.externalApi.ApiTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class WebClientServiceImplTest {
    @Autowired
    private WebClientServiceImpl webClientService;

    @Test
    void testGet() {
        webClientService.get();
    }
}