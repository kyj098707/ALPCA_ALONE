package com.example.back.dto;

import com.example.back.entity.Product;
import com.example.back.entity.Recommendation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationListDto {
    private Long id;
    private String title;
    private String type;
    private String genre;
    private String rank;
    private float rating;
    private String tier;
    private String broadcastAt;
    private String airedYear;
    private String imageUrl;


    public RecommendationListDto(Recommendation recommendation) {
        this.id = recommendation.getId();
        this.title = recommendation.getTitle();
        this.type = recommendation.getType();
        this.genre = recommendation.getGenre().split(",")[0];
        this.rank = recommendation.getRank();
        this.rating = recommendation.getRating();
        this.tier = recommendation.getTier();
        this.broadcastAt = recommendation.getBroadcastAt();
        this.airedYear = recommendation.getAiredYear();
        this.imageUrl = recommendation.getImageUrl();
    }

}
