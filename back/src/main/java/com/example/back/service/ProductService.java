package com.example.back.service;


import com.example.back.dto.ProductDetailDto;
import com.example.back.dto.ProductListDto;
import com.example.back.entity.Product;
import com.example.back.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductListDto> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductListDto> res = products.stream()
                .map(p -> new ProductListDto(p))
                .collect(toList());

        return res;
    }

    public List<ProductListDto> findTrendingProduct() {
        List<Product> products = productRepository.findTop10ByOrderByRatingDesc();

        List<ProductListDto> res = products.stream()
                .map(ProductListDto::new)
                .collect(toList());

        return res;
    }

    public List<ProductListDto> findDefaultTierProduct() {
        List<Product> products = productRepository.findTop20ByOrderByRatingDesc();

        List<ProductListDto> res = products.stream()
                .map(ProductListDto::new)
                .collect(toList());

        return res;
    }

    public ProductDetailDto findById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(IllegalAccessError::new);
        ProductDetailDto res = new ProductDetailDto(product);
        return res;
    }

    public ProductListDto findByTitle(String title) {
        Product product = productRepository.findByTitle(title);
        ProductListDto res = new ProductListDto(product);
        return res;
    }
}