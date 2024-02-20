package com.example.naverApi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import static org.apache.el.util.MessageFactory.get;

@Controller
public class NaverApiController {

    private static final String CLIENT_ID = "YOUR_CLIENT_ID"; // 애플리케이션 클라이언트 아이디
    private static final String CLIENT_SECRET = "YOUR_CLIENT_SECRET"; // 애플리케이션 클라이언트 시크릿
    private static final String NAVER_API_URL = "https://openapi.naver.com/v1/search/blog";

    @GetMapping("/blog/search")
    public String searchBlog(@RequestParam String keyword, Model model) {
        try {
            // 검색어 인코딩
            String encodedKeyword = URLEncoder.encode(keyword, "UTF-8");

            // API 호출을 위한 URL 조합
            String apiURL = NAVER_API_URL + "?query=" + encodedKeyword;

            // API 요청 헤더 설정
            Map<String, String> requestHeaders = new HashMap<>();
            requestHeaders.put("X-Naver-Client-Id", CLIENT_ID);
            requestHeaders.put("X-Naver-Client-Secret", CLIENT_SECRET);

            // API 호출 및 응답 받기
            String responseBody = get(apiURL, requestHeaders);

            // 결과를 모델에 추가
            model.addAttribute("searchKeyword", keyword);
            model.addAttribute("searchResult", responseBody);

            // 검색 결과를 출력할 뷰 이름 반환
            return "blogSearchResult";
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패", e);
        }
    }
}
