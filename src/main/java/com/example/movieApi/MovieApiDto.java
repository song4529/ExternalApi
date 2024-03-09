package com.example.movieApi;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MovieApiDto {
    @Getter
    @AllArgsConstructor
    public static class Response {
        private long movieId;
        private String title;
    }
}
