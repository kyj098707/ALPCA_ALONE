package com.example.back.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true, nullable = false)
    private String email;
    @Column(unique=true, nullable = false)
    private String username;
    private String password;

    private String gender;
    private String role;

}
