package com.example.back.dto;


import com.example.back.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private String imageUrl;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.imageUrl = product.getImageUrl();
    }
}
