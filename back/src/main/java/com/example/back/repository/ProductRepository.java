package com.example.back.repository;

import com.example.back.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findById(Long id);

//    @Query("SELECT p FROM ProductEntity p ORDER BY p.rating DESC")
    List<Product> findTop10ByOrderByRatingDesc();

    List<Product> findTop20ByOrderByRatingDesc();

    Product findByTitle(String title);
}
