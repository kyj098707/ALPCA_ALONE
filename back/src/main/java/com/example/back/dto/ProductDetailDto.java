package com.example.back.dto;


import com.example.back.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDto {
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
    private Long hits;

    public ProductDetailDto(ProductEntity product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.type = product.getType();
        this.genre = product.getGenre();
        this.rank = product.getRank();
        this.rating = product.getRating();
        this.tier = product.getTier();
        this.broadcastAt = product.getBroadcastAt();
        this.airedYear = product.getAiredYear();
        this.imageUrl = product.getImageUrl();
        this.hits = product.getHits();
    }

}
