package com.example.back.controller;

import com.example.back.dto.ProductDetailDto;
import com.example.back.dto.ProductListDto;
import com.example.back.entity.Product;
import com.example.back.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductApiController {
    private final ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<?> getProductList() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        List<ProductListDto> res = productService.findAll();
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/product/contain")
    public ResponseEntity<?> searchProducts(@RequestParam String query) {
        productService.findByTitleContainingIgnoreCase(query);
        List<ProductListDto> res = productService.findByTitleContainingIgnoreCase(query);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/product/trending")
    public ResponseEntity<?> getTrendingProductList() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(name);

        List<ProductListDto> res = productService.findTrendingProduct();
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/product/search")
    public ResponseEntity<?> getProductByTitle(@RequestParam(value = "title", required = false) String title) {

        ProductListDto res = productService.findByTitle(title);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/product/defaulttier")
    public ResponseEntity<?> getDefaultTierProductList() {

        List<ProductListDto> res = productService.findDefaultTierProduct();
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
