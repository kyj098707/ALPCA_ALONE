package com.example.back.controller;

import com.example.back.dto.ProductDetailDto;
import com.example.back.dto.ProductListDto;
import com.example.back.entity.ProductEntity;
import com.example.back.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class ProductApiController {
    private final ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<?> getProductList() {

        List<ProductListDto> res = productService.findAll();
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductDetail(@PathVariable Integer id) {

        ProductDetailDto res = productService.findById(id);
        System.out.println(res);
        if (res == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(res);
    }
}
