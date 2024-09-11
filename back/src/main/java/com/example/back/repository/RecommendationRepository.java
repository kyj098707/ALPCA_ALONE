package com.example.back.repository;

import com.example.back.entity.Product;
import com.example.back.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Integer> {
}
