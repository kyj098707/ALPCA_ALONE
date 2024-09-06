package com.example.back.repository;


import com.example.back.entity.Member;
import com.example.back.entity.Product;
import com.example.back.entity.Tier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TierRepository extends JpaRepository<Tier, Integer> {
    Optional<Tier> findByProductAndMember(Product product, Member member);

    List<Tier> findByMember(Member member);
}
