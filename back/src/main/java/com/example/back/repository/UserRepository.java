package com.example.back.repository;

import com.example.back.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Member, Integer> {

    Boolean existsByUsername(String username);
    Member findByEmail(String email);
    Member findByUsername(String username);
}
