package com.example.back.controller;


import com.example.back.dto.ProductListDto;
import com.example.back.dto.RecommendationListDto;
import com.example.back.repository.RecommendationRepository;
import com.example.back.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecommendationApiController {
    private final RecommendationService recommendationService;

    @GetMapping("/recommendation")
    public ResponseEntity<?> getRecommendationList() {
        List<RecommendationListDto> res = recommendationService.findAll();
        return ResponseEntity.ok().body(res);
    }
}
