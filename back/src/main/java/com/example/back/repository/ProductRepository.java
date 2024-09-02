package com.example.back.repository;

import com.example.back.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    ProductEntity findById(Long id);

//    @Query("SELECT p FROM ProductEntity p ORDER BY p.rating DESC")
    List<ProductEntity> findTop10ByOrderByRatingDesc();
}
