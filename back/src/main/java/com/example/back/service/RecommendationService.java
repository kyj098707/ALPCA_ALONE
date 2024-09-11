package com.example.back.service;


import com.example.back.dto.ProductListDto;
import com.example.back.dto.RecommendationListDto;
import com.example.back.entity.Product;
import com.example.back.entity.Recommendation;
import com.example.back.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final RecommendationRepository recommendationRepository;

    public List<RecommendationListDto> findAll() {

        List<Recommendation> recommendations = recommendationRepository.findAll();

        return recommendations.stream()
                .map(recommendation -> new RecommendationListDto(recommendation))
                .collect(toList());
    }
}
